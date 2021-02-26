/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrdb.hrdb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author gabri
 */
@Controller
public class employeeController {
    
    
    @GetMapping("/thisisHome")
    public String home() {
        System.out.println("Running Index");
        System.out.println("Running Index");
        System.out.println("Running Index");
        System.out.println("Running Index");
        System.out.println("Running Index");
        System.out.println("Running Index");
        System.out.println("Running Index");
        System.out.println("Running Index");
        System.out.println("Running Index");
        return "index";
    }
    
    
}
