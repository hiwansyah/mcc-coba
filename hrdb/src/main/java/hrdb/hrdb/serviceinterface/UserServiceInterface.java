/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrdb.hrdb.serviceinterface;

import hrdb.hrdb.entities.Userhr;

/**
 *
 * @author gabri
 */
public interface UserServiceInterface {
    Userhr findUserByEmail(String email);
    
}
