/**
 * This user entity class is an entity, that represents a table stored in a database.
 * Every instance of an entity represents a row in the table.
 *
 * Authors: Chizie Leitricia Moguem Foka, Dolvie Emma Kouekam, Gabriel Nathanael Da Gomez,
 *          Nasreddin Abdalla A El Alawani, Said Franck Dam Noujepme Njimoluh, Torben Heller
 */
package fhir.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int user_id;
    @NotNull
    @Size(min=4, max = 10)
    @Column(name = "username")
    private String username;
    @NotNull
    @NotEmpty
    @Column(name = "password")
    private String password;
    @NotNull
    @Column(name = "roles")
    private String roles;
    @NotNull
    @Column(name = "active")
    private boolean active = true;
    
    /**
     * Getter and Setter methods for each attributes
     */
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    

    public int getUser_id() {
        return user_id;
    }
    

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    

    public String getUsername() {
        return username;
    }
    

    public void setUsername(String username) {
        this.username = username;
    }
    

    public String getPassword() {
        return password;
    }
    

    public void setPassword(String password) {
        this.password = password;
    }
    

    public String getRoles() {
        return roles;
    }
    

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
