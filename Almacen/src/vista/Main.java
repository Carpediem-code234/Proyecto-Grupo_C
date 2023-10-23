/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;


import entidades.RegistrarCompra;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author alexs
 */
public class Main {
    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
             entidades.Usuario usuarioUnico = new entidades.Usuario("santiago", "1234");

            Login login = new Login(usuarioUnico);

            boolean usuarioValido = false;

            while (!usuarioValido) {
                System.out.print("****BIENVENIDO AL DEPÓSITO EL PORVENIR**** : ");
                System.out.println("");
                System.out.print("Nombre de usuario: ");
                String nombreUsuario = scanner.nextLine();
                System.out.print("Contraseña: ");
                String password = scanner.nextLine();

                if (login.validar(nombreUsuario, password)) {
                    usuarioValido = true;
                    System.out.println("");
                    System.out.println("Inicio de sesión exitoso. Bienvenido, " + usuarioUnico.getNombreUsuario());
                    System.out.println("");
                } else {
                    System.out.println("");
                    System.out.println("Credenciales incorrectas. Intente nuevamente.");
                    System.out.println("");
                }
            }
             // Crear una lista para almacenar productos
             List<entidades.Producto> productos = new ArrayList<>();
             // Crear una lista para almacenar proveedores
             persistencia.GestionProveedor gestionProveedor = new persistencia.GestionProveedor();
             // Crear un objeto InformeStock
             logica.InformeStock informeStock = new logica.InformeStock();
             // Crear un objeto InformeTendencias
             logica.InformeStock informeTendencias = new logica.InformeStock();

             int opcion;
             boolean seguirEjecutando = true; // Variable para controlar si se debe seguir ejecutando el menú principal
             do {
                 System.out.println("     DEPOSITO EL PORVENIR");
                 System.out.println("Menú de opciones:");
                 System.out.println("1. Agregar un producto");
                 System.out.println("2. Modificar un producto");
                 System.out.println("3. Eliminar un producto");
                 System.out.println("4. Asociar un proveedor a un producto");
                 System.out.println("5. Mostrar productos");
                 System.out.println("6. Generar informe de stock");
                 System.out.println("7. Generar informe de tendencias");
                 System.out.println("8. Registrar compra");
                 System.out.println("9. Registrar venta");
                 System.out.println("10. Agregar un proveedor");
                 System.out.println("11. Salir");
                 System.out.print("Seleccione una opción: ");
                 opcion = scanner.nextInt();
                 System.out.println("");
                 scanner.nextLine(); // Consumir la nueva línea

                 switch (opcion) {
                     case 1 -> // Agregar un producto
                         persistencia.GestionProductos.agregarProducto(scanner, productos);
                     case 2 -> // Modificar un producto
                         persistencia.GestionProductos.modificarProducto(scanner, productos);
                     case 3 -> // Eliminar un producto
                         persistencia.GestionProductos.eliminarProducto(scanner, productos);
                     case 4 -> // Asociar un proveedor a un producto
                         persistencia.GestionProductos.asociarProveedorAProducto(scanner, productos, gestionProveedor);
                     case 5 -> // Mostrar la lista de productos
                         persistencia.GestionProductos.mostrarProductos(productos);
                     case 6 -> // Generar informe de stock
                         informeStock.generarInformeStock(productos);
                     case 7 -> // Generar informe de tendencias
                         informeTendencias.generarInformeTendencias(productos);
                     case 8 -> // Registrar compra
                         RegistrarCompra.registrarCompra(scanner, productos);
                     case 9 -> // Registrar venta
                         entidades.RegistrarVenta.registrarVenta(scanner, productos);
                     case 10 -> // Agregar un proveedor
                         persistencia.GestionProveedor.agregarProveedor(scanner, gestionProveedor);
                     case 11 -> {
                         // Salir del programa
                         System.out.println("Saliendo del programa.");
                         seguirEjecutando = false; // Establecer la variable a false para salir del bucle
                     }
                     default -> System.out.println("Opción no válida.");
                 }
             } while (seguirEjecutando);
    }
}

}