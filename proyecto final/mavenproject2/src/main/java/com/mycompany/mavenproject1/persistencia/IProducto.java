/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.mavenproject1.persistencia;

import com.mycompany.mavenproject1.entidades.Producto;
import java.util.ArrayList;

/**
 *
 * @author camilo
 */
public interface IProducto {
    
    void adicionarProducto(Producto p);
    ArrayList<Producto> obtenerProductos();

}
