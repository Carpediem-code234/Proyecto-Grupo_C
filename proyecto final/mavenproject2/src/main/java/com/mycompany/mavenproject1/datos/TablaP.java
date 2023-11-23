/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.datos;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class TablaP {

    private final SimpleStringProperty Producto;
    private final SimpleStringProperty Grupo;
    private final SimpleIntegerProperty Stock;
    private final SimpleStringProperty FechaC;
    private final SimpleStringProperty Proveedor;
    private final SimpleStringProperty FechaG;

    public TablaP(String Producto, String Grupo, int Stock, String FechaC, String Proveedor, String FechaG) {
        this.Producto = new SimpleStringProperty(Producto);
        this.Grupo = new SimpleStringProperty(Grupo);
        this.Stock = new SimpleIntegerProperty(Stock);
        this.FechaC = new SimpleStringProperty(FechaC);
        this.Proveedor = new SimpleStringProperty(Proveedor);
        this.FechaG = new SimpleStringProperty(FechaG);
    }

    /**
     * @return the Producto
     */
    public String getProducto() {
        return Producto.get();
    }

    /**
     * @return the Grupo
     */
    public String getGrupo() {
        return Grupo.get();
    }

    /**
     * @return the Stock
     */
    public int getStock() {
        return Stock.get();
    }

    /**
     * @return the FechaC
     */
    public String getFechaC() {
        return FechaC.get();
    }

    /**
     * @return the Proveedor
     */
    public String getProveedor() {
        return Proveedor.get();
    }

    /**
     * @return the FechaG
     */
    public String getFechaG() {
        return FechaG.get();
    }
}