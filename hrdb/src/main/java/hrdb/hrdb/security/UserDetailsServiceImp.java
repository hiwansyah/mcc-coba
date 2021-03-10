/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrdb.hrdb.security;

import hrdb.hrdb.entities.ThisUser;
import hrdb.hrdb.entities.Userhr;
import hrdb.hrdb.serviceimplements.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;

/**
 *
 * @author gabri
 */
@Controller
public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    private UserServiceImpl usi;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ThisUser user = userConfig(username);

        User.UserBuilder builder = null;
        if (user != null) {
            builder = org.springframework.security.core.userdetails.User.withUsername(username);
            builder.password(user.getPassword());
            builder.roles(user.getRoles());
        } else {
            System.out.println("User Salah");
        }
        return builder.build();
    }

    private ThisUser userConfig(String username) {
        String pwd = null, role = null;
        Userhr user = usi.findUserByEmail(username);
        if (user != null) {
            user = usi.findUserByEmail(username);
            if (user != null) {
                username = user.getUsername().getEmail();
                pwd = user.getPassword();
                role = user.getRoleid();
            } else {
                System.out.println("ACCESS DENIED");
            }
        }
        if (username.equalsIgnoreCase(username)) {
            return new ThisUser(username, pwd, role);
        }
        return null;
    }

}
