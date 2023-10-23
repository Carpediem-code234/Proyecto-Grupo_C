/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import entidades.Registro;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Camilo Mendoza
 */
public class RegistrarVenta extends Registro{
    
    private final List<Registro> registrosVentas;

    public RegistrarVenta(List<Registro> registrosVentas, Producto producto, int cantidad, LocalDate fecha) {
        super(producto, cantidad, fecha);
        this.registrosVentas = registrosVentas;
    }

    public List<Registro> getRegistrosVentas() {
        return registrosVentas;
    }

    public void registrarVenta(int cantidadVenta, LocalDate fechaVenta) {
        if (cantidadVenta <= 0) {
            System.out.println("La cantidad de venta debe ser mayor que cero.");
            return;
        }

        if (cantidadVenta > this.cantidad) {
            System.out.println("No hay suficientes productos en el inventario para realizar esta venta.");
            return;
        }

        this.cantidad -= cantidadVenta;
        Registro registroVenta = new Registro(producto, this.cantidad, fecha);
        registrosVentas.add(registroVenta);

        System.out.println("Venta registrada con éxito.");
    }
    
    public static void registrarVenta(Scanner scanner, List<Producto> productos) {
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

        Producto productoSeleccionado = productos.get(seleccionProducto - 1);

        // Ingresar cantidad de venta
        System.out.print("Cantidad de venta: ");
        int cantidadVenta = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        // Obtener la fecha actual
        LocalDate fechaVenta = LocalDate.now();

        // Registrar la venta en el producto
        productoSeleccionado.registrarVenta(cantidadVenta, fechaVenta);
    }
}
