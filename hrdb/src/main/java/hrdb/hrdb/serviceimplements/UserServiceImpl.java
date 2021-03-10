/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrdb.hrdb.serviceimplements;

import hrdb.hrdb.entities.Userhr;
import hrdb.hrdb.repository.userRepo;
import hrdb.hrdb.serviceinterface.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gabri
 */
@Service
public class UserServiceImpl implements UserServiceInterface{

   
    @Autowired
    private userRepo ur;
    
    @Autowired
    UserServiceInterface userServiceInterface;

    @Override
    public Userhr findUserByEmail(String email) {
        return ur.findUserByEmail(email);
    }
    
}
