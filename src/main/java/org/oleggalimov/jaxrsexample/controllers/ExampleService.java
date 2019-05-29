package org.oleggalimov.jaxrsexample.controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import io.swagger.annotations.ApiOperation;
import org.oleggalimov.jaxrsexample.dao.TissueDao;


@Path("/version")

public class ExampleService  {
    @Inject
    private TissueDao tissueDao;

    public ExampleService () {
    }

    @GET

    @Path("/ping")
    @ApiOperation(value = "Finds Pets by status",
            notes = "Multiple status values can be provided with comma seperated strings",
            responseContainer = "List")
    public Response ping() {
        return Response.ok().entity("Service online").build();
    }

    @GET
    @Path("/jndi")
    public Response jndi() {
        try {
            Context context = new InitialContext();
            DataSource dataSource = (DataSource)context.lookup("java:/PostgresDS");
            Connection conn = dataSource.getConnection();
            String SELECT_ALL = "SELECT * FROM public.Tissues";
            ResultSet resultSet = conn.prepareStatement(SELECT_ALL).executeQuery();
            StringBuilder buffer = new StringBuilder();

            while(resultSet.next()) {
                buffer.append("ID: ").append(resultSet.getInt(1)).append(" , TITLE: ").append(resultSet.getString(2)).append(", PRICE: ").append(resultSet.getFloat(3));
            }

            return Response.ok().entity(buffer.toString()).build();
        } catch (NamingException var7) {
            var7.printStackTrace();
            return Response.serverError().entity("Can't get context").build();
        } catch (SQLException var8) {
            var8.printStackTrace();
            return Response.serverError().entity("Can't get connection to DB").build();
        }
    }

    @GET
    @Path("/ejbtest")
    @Produces({"application/json; charset=UTF-8"})
    @Consumes({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "Retrieve some example content", notes = "Return some json to the client")
    public Response ejbtest() {
        List result = this.tissueDao.findAll();
        return Response.ok().entity(result).build();
    }
}
