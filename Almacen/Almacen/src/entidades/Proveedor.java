/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author alexs
 */
public class Proveedor {
    private static int contadorId = 1;
    private int id;
    private String nombreEmpresa;
    private String direccion;
    private String contacto;

    public Proveedor(String nombreEmpresa, String direccion, String contacto) {
        this.id = contadorId++;
        this.nombreEmpresa = nombreEmpresa;
        this.direccion = direccion;
        this.contacto = contacto;
    }

    public int getId() {
        return id;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public void mostrarProveedor() {
        System.out.println("ID del Proveedor: " + id);
        System.out.println("Nombre de la Empresa: " + nombreEmpresa);
        System.out.println("Dirección: " + direccion);
        System.out.println("Contacto: " + contacto);
    }
}

