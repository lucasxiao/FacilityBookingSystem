/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Facility;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author naresh
 */
@Local
public interface FacilityDAO {

    void create(Facility facility);

    void edit(Facility facility);

    void remove(Facility facility);

    Facility find(Object id);

    List<Facility> findAll();

    List<Facility> findRange(int[] range);

    int count();
    
}
