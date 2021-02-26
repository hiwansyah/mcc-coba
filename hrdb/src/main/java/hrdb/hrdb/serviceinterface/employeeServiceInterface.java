/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrdb.hrdb.serviceinterface;

import hrdb.hrdb.entities.Employees;

/**
 *
 * @author gabri
 */

public interface employeeServiceInterface {
    
    Iterable<Employees> getAll();
    
}
