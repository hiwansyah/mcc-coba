/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrdb.hrdb.repository;


import hrdb.hrdb.entities.Userhr;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gabri
 */
@Repository
public interface userRepo extends CrudRepository<Userhr, Integer> {
    
    @Query(value = "SELECT * FROM userhr WHERE username = ?1", nativeQuery = true)
    public Userhr findUserByEmail(String email);
    
}
