/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alexs
 */
public class Producto {
    private String nombre;
    private String categoria;
    private int cantidad;
    private Proveedor proveedor;
    private final List<Registro> registrosVentas;
    private LocalDate fechaCompra;

    public Producto(String nombre, String categoria, int cantidad, Proveedor proveedor, LocalDate fechaCompra) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.proveedor = proveedor;
        this.registrosVentas = new ArrayList<>();
        this.fechaCompra = fechaCompra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
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
        Registro registroVenta = new Registro(this, cantidadVenta, fechaVenta);
        registrosVentas.add(registroVenta);

        System.out.println("Venta registrada con éxito.");
    }

    public void mostrarProducto() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Categoría: " + categoria);
        System.out.println("Cantidad en Stock: " + cantidad);
        if (proveedor != null) {
            System.out.println("Proveedor: " + proveedor.getNombreEmpresa());
        }
    }

    public void actualizarProducto(String nuevoNombre, String nuevaCategoria, int nuevaCantidad) {
        this.nombre = nuevoNombre;
        this.categoria = nuevaCategoria;
        this.cantidad = nuevaCantidad;
    }

    public void eliminarProveedor() {
        this.proveedor = null;
    }

    public void asociarProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public void agregarRegistroVenta(Registro registro) {
        registrosVentas.add(registro);
    }

    public void registrarCompra(int cantidadCompra, LocalDate fechaCompra) {
        if (cantidadCompra <= 0) {
            System.out.println("La cantidad de compra debe ser mayor que cero.");
            return;
        }

        // Actualizar la cantidad en stock
        this.cantidad += cantidadCompra;

        // Registrar la fecha de compra (puedes almacenarla en algún atributo si lo deseas)
        this.fechaCompra = fechaCompra;

        System.out.println("Compra registrada con éxito.");
    }
}
