/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrdb.hrdb.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gabri
 */
@Entity
@Table(name = "userhr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userhr.findAll", query = "SELECT u FROM Userhr u")
    , @NamedQuery(name = "Userhr.findById", query = "SELECT u FROM Userhr u WHERE u.id = :id")
    , @NamedQuery(name = "Userhr.findByPassword", query = "SELECT u FROM Userhr u WHERE u.password = :password")
    , @NamedQuery(name = "Userhr.findByRoleid", query = "SELECT u FROM Userhr u WHERE u.roleid = :roleid")})
public class Userhr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 60)
    @Column(name = "password")
    private String password;
    @Size(max = 60)
    @Column(name = "roleid")
    private String roleid;
    @JoinColumn(name = "username", referencedColumnName = "email")
    @ManyToOne(fetch = FetchType.LAZY)
    private Employees username;

    public Userhr() {
    }

    public Userhr(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public Employees getUsername() {
        return username;
    }

    public void setUsername(Employees username) {
        this.username = username;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userhr)) {
            return false;
        }
        Userhr other = (Userhr) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hrdb.hrdb.entities.Userhr[ id=" + id + " ]";
    }
    
}
