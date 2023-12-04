/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteriatornillo.Logic;

/**
 *
 * @author migue
 */
public class Users {
    private String id;
    private String name;
    private String password;

    public Users(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
