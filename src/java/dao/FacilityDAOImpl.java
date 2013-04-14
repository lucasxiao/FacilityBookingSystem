/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Facility;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author naresh
 */
@Stateless
public class FacilityDAOImpl extends AbstractDAO<Facility> implements FacilityDAO {
    @PersistenceContext(unitName = "FacilityBookingSystemPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FacilityDAOImpl() {
        super(Facility.class);
    }
    
}
