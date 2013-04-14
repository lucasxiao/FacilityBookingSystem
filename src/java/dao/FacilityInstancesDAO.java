/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.FacilityInstances;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author naresh
 */
@Local
public interface FacilityInstancesDAO {

    void create(FacilityInstances facilityInstances);

    void edit(FacilityInstances facilityInstances);

    void remove(FacilityInstances facilityInstances);

    FacilityInstances find(Object id);

    List<FacilityInstances> findAll();

    List<FacilityInstances> findRange(int[] range);

    int count();
    
}
