/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.FacilityInstances;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author naresh
 */
@Stateless
public class FacilityInstancesDAOImpl extends AbstractDAO<FacilityInstances> implements FacilityInstancesDAO {
    @PersistenceContext(unitName = "FacilityBookingSystemPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FacilityInstancesDAOImpl() {
        super(FacilityInstances.class);
    }
    
}
