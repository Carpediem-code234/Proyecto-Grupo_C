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
 * @author Camilo Mendoza
 */
public class RegistrarCompra extends Registro{
    
    private LocalDate fechaCompra;

    public RegistrarCompra(Producto producto, int cantidad, LocalDate fecha) {
        super(producto, cantidad, fecha);
    }
    
    
    public static void registrarCompra(Scanner scanner, List<Producto> productos) {
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

        Producto productoSeleccionado = productos.get(seleccionProducto - 1);

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
    
    
    public void registrarCompra(int cantidadCompra, LocalDate fecha) {
        if (cantidadCompra <= 0) {
            System.out.println("La cantidad de compra debe ser mayor que cero.");
            return;
        }
        // Actualizar la cantidad en stock
        this.cantidad += cantidadCompra;

        // Registrar la fecha de compra (puedes almacenarla en algún atributo si lo deseas)
        this.fecha = fechaCompra;

        System.out.println("Compra registrada con éxito.");
    }
    
    @Override
    public void mostrarRegistro() {
        System.out.println("Producto: " + producto.getNombre());
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Fecha: " + fecha);
    }

    

    
}
