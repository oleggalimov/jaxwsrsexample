//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.oleggalimov.jaxrsexample;

import io.swagger.annotations.Contact;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Info;
import io.swagger.jaxrs.config.BeanConfig;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/myopenapi")
@SwaggerDefinition(info = @Info (
        title = "Example Service",
        description = "A simple example of apiee",
        version = "1.0.0",
        contact = @Contact(
                name = "Phillip Kruger",
                email = "apiee@phillip-kruger.com",
                url = "http://phillip-kruger.com"
        )
)
)
public class App extends Application {
    public App() {
    }
}
