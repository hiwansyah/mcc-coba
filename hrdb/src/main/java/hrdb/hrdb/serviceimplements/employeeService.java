/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrdb.hrdb.serviceimplements;

import hrdb.hrdb.entities.Employees;
import hrdb.hrdb.repository.employeeRepository;
import hrdb.hrdb.serviceinterface.employeeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gabri
 */
@Service
public class employeeService implements employeeServiceInterface {

    @Autowired
    private employeeRepository r;

    @Override
    public Iterable<Employees> getAll() {
        return r.findAll();
    }

    @Override
    public Iterable<Employees> searchByFirstName(String firstname) {
        return r.searchByName(firstname);
    }

}
