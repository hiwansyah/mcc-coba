/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrdb.hrdb.controller;

import hrdb.hrdb.entities.Employees;
import hrdb.hrdb.serviceimplements.employeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author gabri
 */
@Controller
public class employeeController {

    @Autowired
    private employeeService servisnyaEmployee;

    @GetMapping("/thisisHome")
    public String home() {
        System.out.println("Running Index");
        System.out.println("Running Index");
        return "index";
    }

    @RequestMapping(value = "/getAllEmployee", method = RequestMethod.GET)
    public String getAllEmployee(Model model) {

        Iterable<Employees> employees = servisnyaEmployee.getAll();

        for (Employees employeList : employees) {
            System.out.println("employees Email = " + employeList.getEmail());
            System.out.println("employees firstname = " + employeList.getFirstName());
            System.out.println("employees lastname = " + employeList.getLastName());
            System.out.println("employees phone number = " + employeList.getPhoneNumber());

        }
        model.addAttribute("employeList", employees);
        return "view/viewAllEmployee";
    }

    @RequestMapping(value = "/searchPageEmployee", method = RequestMethod.GET)
    public String searchEmployeeByFirstname() {
        return "view/searchPageFirstname";
    }

    @RequestMapping(value = "/selectByName", method = RequestMethod.POST)
    public String selectByName(Model model,
            @RequestParam(value = "firstname", required = false) String nama) {
        
        Iterable<Employees> employees = servisnyaEmployee.searchByFirstName(nama);

        model.addAttribute("listEmployee", employees);
        return "view/viewSearchFirstname";
    }
    
    
    /*
    Spring Security inisialisasi 
    username : user
    password : sesuai random di console
    */
    @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }
    
    @RequestMapping(value = "/manager", method = RequestMethod.GET)
    public String homemanager() {
        
        System.out.println("homemanager");
        return "index";
    }
    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String homeemployee() {
        System.out.println("homeemployee");
        
        return "index";
    }
    
    

    
}
