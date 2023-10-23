/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import entidades.Producto;
import entidades.Registro;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author alexs
 */
public class InformeStock {
   private final List<Producto> productos;

    public InformeStock() {
        productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void generarInformeStock(List<Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados para generar el informe de stock.");
            return;
        }

        System.out.println("Informe de Stock:");
        for (Producto producto : productos) {
            producto.mostrarProducto();
            System.out.println("--------------------");
        }
    }

    public Map<String, Integer> obtenerStockPorCategoria() {
        Map<String, Integer> stockPorCategoria = new HashMap<>();
        for (Producto producto : productos) {
            String categoria = producto.getCategoria();
            int cantidad = producto.getCantidad();
            stockPorCategoria.put(categoria, stockPorCategoria.getOrDefault(categoria, 0) + cantidad);
        }
        return stockPorCategoria;
    }

    public void generarInformeTendencias(List<Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados para generar un informe de tendencias.");
            return;
        }

        System.out.println("Informe de Tendencias:");

        List<Registro> registrosVentas = new ArrayList<>();
        for (Producto producto : productos) {
            registrosVentas.addAll(producto.getRegistrosVentas());
        }

        Map<String, Integer> productosMasVendidos = new HashMap<>();
        for (Registro registro : registrosVentas) {
            String nombreProducto = registro.getProducto().getNombre();
            int cantidadVendida = registro.getCantidad();
            productosMasVendidos.put(nombreProducto, productosMasVendidos.getOrDefault(nombreProducto, 0) + cantidadVendida);
        }

        String productoMasVendido = "";
        int maxVentas = 0;
        for (Map.Entry<String, Integer> entry : productosMasVendidos.entrySet()) {
            String nombreProducto = entry.getKey();
            int ventas = entry.getValue();
            if (ventas > maxVentas) {
                productoMasVendido = nombreProducto;
                maxVentas = ventas;
            }
        }

        String productoMenosVendido = "";
        int minVentas = Integer.MAX_VALUE;
        for (Map.Entry<String, Integer> entry : productosMasVendidos.entrySet()) {
            String nombreProducto = entry.getKey();
            int ventas = entry.getValue();
            if (ventas < minVentas) {
                productoMenosVendido = nombreProducto;
                minVentas = ventas;
            }
        }

        System.out.println("Producto más vendido: " + productoMasVendido);
        System.out.println("Producto menos vendido: " + productoMenosVendido);
    } 
}
