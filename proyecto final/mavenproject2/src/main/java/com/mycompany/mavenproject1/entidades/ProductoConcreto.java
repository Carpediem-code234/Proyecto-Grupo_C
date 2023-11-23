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
public class ProductoConcreto extends Producto {

    public ProductoConcreto() {
        super();
    }

    public ProductoConcreto(String Producto, String Grupo, int Stock, LocalDate FechaCaducidad, String Proveedor, LocalDate FechaAgregacion) {
        super(Producto, Grupo, Stock, FechaCaducidad, Proveedor, FechaAgregacion);
    }

    @Override
    public String getDataFromFileTxt() {
        return String.format("%-15s: %s\n%-15s: %s\n%-15s: %d\n%-15s: %s\n%-15s: %s\n%-15s: %s\n",
                "Producto", this.getProducto(),
                "Grupo", this.getGrupo(),
                "Stock", this.getStock(),
                "Fecha de Caducidad", this.getFechaAgregacion().toString(),
                "Proveedor", this.getProveedor(),
                "Fecha de Agregado", this.getFechaAgregacion().toString());
    }

    @Override
    public com.mycompany.mavenproject1.entidades.Producto clonar() {
        return new ProductoConcreto(getProducto(), getGrupo(), getStock(), getFechaCaducidad(), getProveedor(), getFechaAgregacion());
    }

    



}

