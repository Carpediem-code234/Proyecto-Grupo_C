/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenproject1.controllers;


import com.mycompany.mavenproject1.entidades.ProductoConcreto;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class InformeStockController implements Initializable {

    @FXML
    private TextField buscarproducto;

    @FXML
    private TableView<ProductoConcreto> tablavista;

    @FXML
    private TableColumn<ProductoConcreto, String> productoColumn;

    @FXML
    private TableColumn<ProductoConcreto, String> grupoColumn;

    @FXML
    private TableColumn<ProductoConcreto, Integer> stockColumn;

    @FXML
    private TableColumn<ProductoConcreto, LocalDate> fechaCaducidadColumn;

    @FXML
    private TableColumn<ProductoConcreto, String> proveedorColumn;

    @FXML
    private TableColumn<ProductoConcreto, LocalDate> fechaAgregacionColumn;

    private List<ProductoConcreto> listaProductos = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Configuración inicial, si es necesario
    }

    @FXML
    public void clickbuscar(ActionEvent event) {
        String textoBusqueda = buscarproducto.getText().toLowerCase();

        // Crear una nueva lista para almacenar los resultados de la búsqueda
        List<ProductoConcreto> resultados = new ArrayList<>();

        // Iterar a través de la lista de productos y agregar aquellos que coincidan con la búsqueda
        for (ProductoConcreto producto : listaProductos) {
            if (producto.getProducto().toLowerCase().contains(textoBusqueda)) {
                resultados.add(producto);
            }
        }

        // Limpiar la tabla y agregar los resultados de la búsqueda
        tablavista.getItems().clear();
        tablavista.getItems().addAll(resultados);
    }

    public void setListaProductos(List<ProductoConcreto> listaProductos) {
        this.listaProductos = listaProductos;
        actualizarTabla();
    }

    public void actualizarTabla() {
        // Limpiar la tabla
        tablavista.getItems().clear();

        // Agregar todos los productos a la tabla
        tablavista.getItems().addAll(listaProductos);
    }
}

