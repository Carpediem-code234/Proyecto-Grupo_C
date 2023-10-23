/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;



/**
 *
 * @author alexs
 */
public class Registro {
    protected entidades.Producto producto;
    protected int cantidad;
    protected LocalDate fecha;

    public Registro(Producto producto, int cantidad, LocalDate fecha) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    public static void registrarCompra(Scanner scanner, List<entidades.Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados para registrar una compra.");
            return;
        }
        
        System.out.println("");
        System.out.println("Lista de productos:");
        for (int i = 0; i < productos.size(); i++) {
            System.out.println((i + 1) + ". " + productos.get(i).getNombre());
        }

        System.out.print("Seleccione el número del producto para registrar la compra: ");
        int seleccionProducto = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        if (seleccionProducto < 1 || seleccionProducto > productos.size()) {
            System.out.println("Número de producto no válido.");
            return;
        }

        entidades.Producto productoSeleccionado = productos.get(seleccionProducto - 1);

        // Ingresar cantidad de compra
        System.out.print("Cantidad de compra: ");
        int cantidadCompra = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        // Obtener la fecha actual
        LocalDate fechaCompra = LocalDate.now();

        // Registrar la compra en el producto
        //productoSeleccionado.registrarCompra(cantidadCompra, fechaCompra);
        productoSeleccionado.registrarCompra(cantidadCompra, fechaCompra);
    }

    public static void registrarVenta(Scanner scanner, List<entidades.Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados para registrar una venta.");
            return;
        }
        
        System.out.println("");
        System.out.println("Lista de productos:");
        for (int i = 0; i < productos.size(); i++) {
            System.out.println((i + 1) + ". " + productos.get(i).getNombre());
        }

        System.out.print("Seleccione el número del producto para registrar la venta: ");
        int seleccionProducto = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        if (seleccionProducto < 1 || seleccionProducto > productos.size()) {
            System.out.println("Número de producto no válido.");
            return;
        }

        entidades.Producto productoSeleccionado = productos.get(seleccionProducto - 1);

        // Ingresar cantidad de venta
        System.out.print("Cantidad de venta: ");
        int cantidadVenta = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        // Obtener la fecha actual
        LocalDate fechaVenta = LocalDate.now();

        // Registrar la venta en el producto
        productoSeleccionado.registrarVenta(cantidadVenta, fechaVenta);
    }
    
    public void mostrarRegistro() {
        System.out.println("Producto: " + producto.getNombre());
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Fecha: " + fecha);
    }
}
