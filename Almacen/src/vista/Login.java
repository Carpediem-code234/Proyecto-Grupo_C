/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import entidades.Usuario;



/**
 *
 * @author Camilo Mendoza
 */
public class Login {
    
    private Usuario usuario;

    public Login(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean validar(String nombreUsuario, String password) {
        return usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getPassword().equals(password);
    }
}
