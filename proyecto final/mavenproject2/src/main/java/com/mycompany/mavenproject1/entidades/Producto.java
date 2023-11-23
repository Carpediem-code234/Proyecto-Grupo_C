/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.entidades;


import java.time.LocalDate;

/**
 *
 * @author camilo
 */
public abstract class Producto {
    
    private String Producto;
    private String Grupo;
    private int Stock;      
    private LocalDate FechaCaducidad;
    private String Proveedor;
    private LocalDate FechaAgregacion;
    
    public Producto(){
        
    }

    public Producto(String Producto, String Grupo, int Stock, LocalDate FechaCaducidad, String Proveedor, LocalDate FechaAgregacion) {
        this.Producto = Producto;
        this.Grupo = Grupo;
        this.Stock = Stock;
        this.FechaCaducidad = FechaCaducidad;
        this.Proveedor = Proveedor;
        this.FechaAgregacion = FechaAgregacion;
    }
    

    public abstract Producto clonar();

    public String getProducto() {
        return Producto;
    }

    public void setProducto(String Producto) {
        this.Producto = Producto;
    }

    public String getGrupo() {
        return Grupo;
    }

    public void setGrupo(String Grupo) {
        this.Grupo = Grupo;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public LocalDate getFechaCaducidad() {
        return FechaCaducidad;
    }

    public void setFechaCaducidad(LocalDate FechaCaducidad) {
        this.FechaCaducidad = FechaCaducidad;
    }

    public String getProveedor() {
        return Proveedor;
    }

    public void setProveedor(String Proveedor) {
        this.Proveedor = Proveedor;
    }

    public LocalDate getFechaAgregacion() {
        return FechaAgregacion;
    }

    public void setFechaAgregacion(LocalDate FechaAgregacion) {
        this.FechaAgregacion = FechaAgregacion;
    }
    
    
    public abstract String getDataFromFileTxt();
}
