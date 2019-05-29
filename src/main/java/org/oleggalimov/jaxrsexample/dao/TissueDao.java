
package org.oleggalimov.jaxrsexample.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.oleggalimov.jaxrsexample.dto.Tissues;

@Stateless
public class TissueDao {
    @PersistenceContext(
            unitName = "PostgresDataSource"
    )
    private EntityManager em;

    public TissueDao() {
    }

    public void save(Tissues tissues) {
        this.em.persist(tissues);
    }

    public List findAll() {
        return this.em.createQuery("select t from Tissues t").getResultList();
    }
}
