/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenproject1.controllers;

import com.mycompany.mavenproject1.entidades.Producto;
import com.mycompany.mavenproject1.entidades.ProductoConcreto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.util.converter.LocalDateStringConverter;

public class IngresarProductoController implements Initializable {

    @FXML
    private TextField productoTextField;

    @FXML
    private ComboBox<String> grupoAlimenticioComboBox;

    @FXML
    private TextField stockTextField;

    @FXML
    private DatePicker fechaCaducidadDatePicker;

    private DatePicker fechaAgregacionDatePicker;

    @FXML
    private TextField proveedorTextField;

    @FXML
    private Button guardarButton;

    @FXML
    private Button eliminarButton;

    @FXML
    private Button modificarButton;
    
    @FXML
    private TableView<Producto> tablavista;

    @FXML
    private TableColumn<Producto, String> productoColumn;

    @FXML
    private TableColumn<Producto, String> grupoColumn;

    @FXML
    private TableColumn<Producto, Integer> stockColumn;

    @FXML
    private TableColumn<Producto, String> fechaCaducidadColumn;

    @FXML
    private TableColumn<Producto, String> proveedorColumn;

    @FXML
    private TableColumn<Producto, String> fechaAgregacionColumn;

    private final ObservableList<Producto> productosList = FXCollections.observableArrayList();

    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        grupoAlimenticioComboBox.setItems(FXCollections.observableArrayList(
                "Leche y derivados",
                "Carne",
                "Huevos",
                "Tubérculos, legumbres o frutos secos",
                "Verduras",
                "Frutas",
                "Pan",
                "Pasta",
                "Cereales",
                "Azúcar",
                "Aceite o mantequillas"
        ));
        configurarColumnasTabla();
        configurarComboBox();
        configurarTabla();
        deshabilitarModificarSinSeleccion();
        // Inicializar fechaAgregacionDatePicker
        fechaAgregacionDatePicker = new DatePicker();

        // Establecer el StringConverter personalizado
        fechaAgregacionDatePicker.setConverter(new LocalDateStringConverter());
    }

    private void configurarColumnasTabla() {
        productoColumn.setCellValueFactory(new PropertyValueFactory<>("producto"));
        grupoColumn.setCellValueFactory(new PropertyValueFactory<>("grupo"));
        stockColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
        fechaCaducidadColumn.setCellValueFactory(new PropertyValueFactory<>("fechaCaducidad"));
        proveedorColumn.setCellValueFactory(new PropertyValueFactory<>("proveedor"));
        fechaAgregacionColumn.setCellValueFactory(new PropertyValueFactory<>("fechaAgregacion"));
    }

    private void configurarComboBox() {
        grupoAlimenticioComboBox.getItems().addAll(
                "Leche y derivados",
                "Carne",
                "Huevos",
                "Tubérculos, legumbres o frutos secos",
                "Verduras",
                "Frutas",
                "Pan",
                "Pasta",
                "Cereales o granos",
                "Azúcar",
                "Aceite o mantequillas"
        );
    }

    private void configurarTabla() {
        tablavista.setItems(productosList);
    }

    private void deshabilitarModificarSinSeleccion() {
        modificarButton.setDisable(true);
        tablavista.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)
                -> modificarButton.setDisable(newValue == null));
    }

    @FXML
    public void clickguardar() {
        try {
            validarEntrada();

            Producto producto = new ProductoConcreto(
                    productoTextField.getText(),
                    grupoAlimenticioComboBox.getValue(),
                    Integer.parseInt(stockTextField.getText()),
                    fechaCaducidadDatePicker.getValue(),
                    proveedorTextField.getText(),
                    fechaAgregacionDatePicker.getValue()
            );

            productosList.add(producto);
            limpiarCampos();

        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "Ingrese un valor numérico válido para el stock.");
        } catch (Exception e) {
            mostrarAlerta("Error", "Todos los campos son obligatorios.");
        }
    }



    @FXML
    public void clickeliminar() {
        Producto productoSeleccionado = tablavista.getSelectionModel().getSelectedItem();
        if (productoSeleccionado != null) {
            productosList.remove(productoSeleccionado);
        }
    }

    @FXML
    public void clickmodificar() {
        try {
            validarEntrada();

            Producto productoSeleccionado = tablavista.getSelectionModel().getSelectedItem();
            if (productoSeleccionado != null) {
                // Clonar el producto seleccionado
                Producto productoClon = productoSeleccionado.clonar();

                // Modificar el clon con los nuevos valores
                productoClon.setProducto(productoTextField.getText());
                productoClon.setGrupo(grupoAlimenticioComboBox.getValue());
                productoClon.setStock(Integer.parseInt(stockTextField.getText()));
                productoClon.setFechaCaducidad(fechaCaducidadDatePicker.getValue());
                productoClon.setProveedor(proveedorTextField.getText());
                productoClon.setFechaAgregacion(fechaAgregacionDatePicker.getValue());

                // Actualizar la lista con el producto clon
                productosList.remove(productoSeleccionado);
                productosList.add(productoClon);

                // Refrescar la tabla
                tablavista.refresh();

                // Limpiar campos
                limpiarCampos();
            }

        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "Ingrese un valor numérico válido para el stock.");
        } catch (Exception e) {
            mostrarAlerta("Error", "Todos los campos son obligatorios.");
        }
    }

    private void limpiarCampos() {
        productoTextField.clear();
        grupoAlimenticioComboBox.setValue(null);
        stockTextField.clear();
        fechaCaducidadDatePicker.setValue(null);
        proveedorTextField.clear();
        fechaAgregacionDatePicker.setValue(null);
    }

    private void validarEntrada() throws Exception {
        // Verificar si el campo Producto está vacío
        if (productoTextField.getText().isEmpty()) {
            throw new Exception("El campo Producto es obligatorio.");
        }

        // Verificar si no se ha seleccionado un Grupo Alimenticio
        if (grupoAlimenticioComboBox.getValue() == null) {
            throw new Exception("Seleccione un Grupo Alimenticio.");
        }

        // Verificar si el campo Stock está vacío o no es un número válido
        if (stockTextField.getText().isEmpty() || !esNumeroValido(stockTextField.getText())) {
            throw new Exception("Ingrese un valor numérico válido para el stock.");
        }

        // Verificar si la fecha de caducidad no está seleccionada
        if (fechaCaducidadDatePicker.getValue() == null) {
            throw new Exception("Seleccione una Fecha de Caducidad.");
        }

        // Verificar si el campo Proveedor está vacío
        if (proveedorTextField.getText().isEmpty()) {
            throw new Exception("El campo Proveedor es obligatorio.");
        }

        // Si llega aquí, todos los campos están completos
    }

// Método de utilidad para verificar si una cadena es un número válido
    private boolean esNumeroValido(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
