/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.entidades;

/**
 *
 * @author camilo
 */
public class Usuario {
    private String id;
//    private String nombre;
//    private String apellido;
    private String username;
    private String password;
//    private boolean admin;

    public Usuario() {
        this.id = "12345";
        this.username="admin";
        this.password="root";
//        this.admin=true;
        
    }
    
    

//    public Usuario(String id, String username, String password, boolean admin) {
//        this.id = id;
//        this.username = username;
//        this.password = password;
//        this.admin = admin;
//    }
    
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }
    
    /**
     *  @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
    
    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }
    
    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    
    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
//    /**
//     * @return the admin
//     */
//    public boolean isAdmin() {
//        return admin;
//    }
//    
//    /**
//     * @param admin the admin to set
//     */
//    public void setAdmin(boolean admin) {
//        this.admin = admin;
//    }

    
    
    
    
}
