/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrdb.hrdb.repository;

import hrdb.hrdb.entities.Employees;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gabri
 */
@Repository
public interface employeeRepository extends CrudRepository<Employees, Integer>{
    
    @Query(value = "SELECT * FROM employees WHERE first_name like %?1%", nativeQuery = true)
    public Iterable<Employees> searchByName(String keyword);
    
}
