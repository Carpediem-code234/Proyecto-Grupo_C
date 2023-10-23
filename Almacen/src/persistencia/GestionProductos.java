/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.Proveedor;
import entidades.Producto;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Camilo Mendoza
 */
public class GestionProductos {
    
    public static void agregarProducto(Scanner scanner, List<entidades.Producto> productos) {
        System.out.println("Ingrese los datos del producto:");

        // Ingresar nombre del producto
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        // Menú para seleccionar el grupo alimenticio
        int grupoAlimenticio;
        do {
            System.out.println("Seleccione el grupo alimenticio:");
            System.out.println("Grupo 1: Leche y derivados");
            System.out.println("Grupo 2: Carne, huevos y pescados");
            System.out.println("Grupo 3: Tubérculos, legumbres y frutos secos");
            System.out.println("Grupo 4: Verduras y hortalizas");
            System.out.println("Grupo 5: Frutas");
            System.out.println("Grupo 6: Pan, pasta, cereales y azúcar");
            System.out.println("Grupo 7: Grasas, aceite y mantequillas");
            System.out.print("Opción: ");
            try {
                grupoAlimenticio = scanner.nextInt();
                scanner.nextLine(); // Consumir la nueva línea
                if (grupoAlimenticio < 1 || grupoAlimenticio > 7) {
                    System.out.println("Opción no válida. Intente nuevamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Debe ingresar un número.");
                scanner.nextLine(); // Consumir la entrada incorrecta
                grupoAlimenticio = 0; // Establecer un valor predeterminado para continuar el bucle
            }
        } while (grupoAlimenticio < 1 || grupoAlimenticio > 7);

        String categoria = obtenerCategoriaPorGrupo(grupoAlimenticio);

        // Ingresar cantidad en stock
        int cantidad;
        do {
            System.out.print("Cantidad en Stock: ");
            try {
                cantidad = scanner.nextInt();
                scanner.nextLine(); // Consumir la nueva línea
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Debe ingresar un número entero.");
                scanner.nextLine(); // Consumir la entrada incorrecta
                cantidad = -1; // Establecer un valor predeterminado para continuar el bucle
            }
        } while (cantidad < 0);

        LocalDate fecha = LocalDate.now();

        // Crear un producto con los datos ingresados
        entidades.Producto producto = new entidades.Producto(nombre, categoria, cantidad, null, fecha);
        productos.add(producto);

        System.out.println("Producto agregado con éxito.");
    }

    public static void modificarProducto(Scanner scanner, List<entidades.Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }

        System.out.println("");
        System.out.println("Lista de productos:");
        for (int i = 0; i < productos.size(); i++) {
            System.out.println((i + 1) + ". " + productos.get(i).getNombre());
        }

        System.out.print("Seleccione el número del producto a modificar: ");
        int seleccion = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        if (seleccion < 1 || seleccion > productos.size()) {
            System.out.println("Número de producto no válido.");
            return;
        }

        entidades.Producto productoSeleccionado = productos.get(seleccion - 1);

        System.out.println("Modificar producto: " + productoSeleccionado.getNombre());

        // Ingresar nombre del producto
        System.out.print("Nuevo nombre (dejar en blanco para mantener el actual): ");
        String nuevoNombre = scanner.nextLine();
        if (!nuevoNombre.isEmpty()) {
            productoSeleccionado.setNombre(nuevoNombre);
        }

        // Menú para seleccionar el grupo alimenticio
        int grupoAlimenticio;
        do {
            System.out.println("");
            System.out.println("Seleccione el nuevo grupo alimenticio:");
            System.out.println("1. Frutas y verduras");
            System.out.println("2. Carnes y pescados");
            System.out.println("3. Lácteos");
            System.out.println("4. Cereales y legumbres");
            System.out.println("0. Mantener la categoría actual");
            System.out.print("Opción: ");
            grupoAlimenticio = scanner.nextInt();
            System.out.println("");
            scanner.nextLine(); // Consumir la nueva línea
            if (grupoAlimenticio < 0 || grupoAlimenticio > 4) {
                System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (grupoAlimenticio < 0 || grupoAlimenticio > 4);

        if (grupoAlimenticio != 0) {
            String nuevaCategoria = obtenerCategoriaPorGrupo(grupoAlimenticio);
            productoSeleccionado.setCategoria(nuevaCategoria);
        }

        // Ingresar nueva cantidad en stock
        System.out.print("Nueva cantidad en Stock (dejar en blanco para mantener la actual): ");
        String nuevaCantidadStr = scanner.nextLine();
        if (!nuevaCantidadStr.isEmpty()) {
            int nuevaCantidad = Integer.parseInt(nuevaCantidadStr);
            productoSeleccionado.setCantidad(nuevaCantidad);
        }

        System.out.println("Producto modificado con éxito.");
    }

    public static void eliminarProducto(Scanner scanner, List<entidades.Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }

        System.out.println("");
        System.out.println("Lista de productos:");
        for (int i = 0; i < productos.size(); i++) {
            System.out.println((i + 1) + ". " + productos.get(i).getNombre());
        }

        System.out.print("Seleccione el número del producto a eliminar: ");
        int seleccion = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        if (seleccion < 1 || seleccion > productos.size()) {
            System.out.println("Número de producto no válido.");
            return;
        }

        entidades.Producto productoEliminado = productos.remove(seleccion - 1);
        System.out.println("Producto eliminado con éxito: " + productoEliminado.getNombre());
    }

    public static String obtenerCategoriaPorGrupo(int grupoAlimenticio) {
        String[] categorias = {
            "Leche y derivados",
            "Carne, huevos y pescados",
            "Tubérculos, legumbres y frutos secos",
            "Verduras y hortalizas",
            "Frutas",
            "Pan, pasta, cereales y azúcar",
            "Grasas, aceite y mantequillas"
        };

        if (grupoAlimenticio >= 1 && grupoAlimenticio <= categorias.length) {
            return categorias[grupoAlimenticio - 1];
        } else {
            throw new IllegalArgumentException("Grupo alimenticio desconocido: " + grupoAlimenticio);
        }
    }

    public static void asociarProveedorAProducto(Scanner scanner, List<entidades.Producto> productos, persistencia.GestionProveedor gestionProveedor) {
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }

        System.out.println("");
        System.out.println("Lista de productos:");
        for (int i = 0; i < productos.size(); i++) {
            System.out.println((i + 1) + ". " + productos.get(i).getNombre());
        }

        System.out.print("Seleccione el número del producto al que desea asociar un proveedor: ");
        int seleccionProducto = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        if (seleccionProducto < 1 || seleccionProducto > productos.size()) {
            System.out.println("Número de producto no válido.");
            return;
        }

        entidades.Producto productoSeleccionado = productos.get(seleccionProducto - 1);

        System.out.println("Lista de proveedores:");
        List<entidades.Proveedor> proveedores = gestionProveedor.getProveedores();
        for (int i = 0; i < proveedores.size(); i++) {
            System.out.println((i + 1) + ". " + proveedores.get(i).getNombreEmpresa());
        }

        System.out.print("Seleccione el número del proveedor que desea asociar: ");
        int seleccionProveedor = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        if (seleccionProveedor < 1 || seleccionProveedor > proveedores.size()) {
            System.out.println("Número de proveedor no válido.");
            return;
        }

        entidades.Proveedor proveedorAsociado = proveedores.get(seleccionProveedor - 1);
        productoSeleccionado.setProveedor(proveedorAsociado);

        System.out.println("Proveedor asociado con éxito al producto: " + productoSeleccionado.getNombre());
    }

    public static void mostrarProductos(List<entidades.Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            System.out.println("");
            System.out.println("Lista de productos:");
            for (entidades.Producto producto : productos) {
                System.out.println("Nombre: " + producto.getNombre());
                System.out.println("Categoría: " + producto.getCategoria());
                System.out.println("Cantidad en Stock: " + producto.getCantidad());
                entidades.Proveedor proveedor = producto.getProveedor();
                if (proveedor != null) {
                    System.out.println("Proveedor: " + proveedor.getNombreEmpresa());
                }
                System.out.println("--------------------");
            }
        }
    }
}
