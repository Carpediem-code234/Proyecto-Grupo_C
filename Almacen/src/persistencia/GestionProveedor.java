/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;


import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author alexs
 */
public class GestionProveedor {
     private final List<entidades.Proveedor> proveedores;

    public GestionProveedor() {
        proveedores = new ArrayList<>();
    }

    public void agregarProveedor(entidades.Proveedor proveedor) {
        proveedores.add(proveedor);
    }

    public entidades.Proveedor buscarProveedorPorNombre(String nombreEmpresa) {
        for (entidades.Proveedor proveedor : proveedores) {
            if (proveedor.getNombreEmpresa().equals(nombreEmpresa)) {
                return proveedor;
            }
        }
        return null;
    }

    public void actualizarProveedor(int id, String nuevoNombre, String nuevaDireccion, String nuevoContacto) {
        for (entidades.Proveedor proveedor : proveedores) {
            if (proveedor.getId() == id) {
                proveedor.setNombreEmpresa(nuevoNombre);
                proveedor.setDireccion(nuevaDireccion);
                proveedor.setContacto(nuevoContacto);
                break;
            }
        }
    }

    public void eliminarProveedor(int id) {
        entidades.Proveedor proveedorAEliminar = null;
        for (entidades.Proveedor proveedor : proveedores) {
            if (proveedor.getId() == id) {
                proveedorAEliminar = proveedor;
                break;
            }
        }
        if (proveedorAEliminar != null) {
            proveedores.remove(proveedorAEliminar);
        }
    }

    public void mostrarProveedores() {
        System.out.println("Lista de Proveedores:");
        for (entidades.Proveedor proveedor : proveedores) {
            proveedor.mostrarProveedor();
            System.out.println("--------------------");
        }
    }

    public List<entidades.Proveedor> getProveedores() {
        return proveedores;
    }
    
    public static void agregarProveedor(Scanner scanner, persistencia.GestionProveedor gestionProveedor) {
        System.out.println("");
        System.out.println("Ingrese los datos del proveedor:");

        // Ingresar nombre de la empresa del proveedor
        System.out.print("Nombre de la Empresa: ");
        String nombreEmpresa = scanner.nextLine();

        // Ingresar dirección del proveedor
        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();

        // Ingresar contacto del proveedor
        System.out.print("Contacto: ");
        String contacto = scanner.nextLine();

        // Crear un objeto Proveedor con los datos ingresados
        entidades.Proveedor proveedor = new entidades.Proveedor(nombreEmpresa, direccion, contacto);
        gestionProveedor.agregarProveedor(proveedor);

        System.out.println("Proveedor agregado con éxito.");
        System.out.println("");
    }
}