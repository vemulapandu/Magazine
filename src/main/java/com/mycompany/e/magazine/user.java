/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.e.magazine;
import java.io.Serializable;
/**
 *
 * @author malli
 */
public class user implements Serializable {
    
    private String username;
    private String name;
    private String email;
    private String password;
    
    public void setName(String s){
        this.name = s;
    }
    public void setUsername(String s){
        this.username = s;
    }
    public void setPassword(String s){
        this.password = s;
    }
    public void setEmail(String s){
        this.email = s;
    }
    public String getName(){
        return this.name;
    }
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }
    public String getEmail(){
        return this.email;
    }
    public String toString(){
        return this.name + "\n" + this.email + "\n" + this.username + "\n" + this.password + "\n";
    }
    
}
