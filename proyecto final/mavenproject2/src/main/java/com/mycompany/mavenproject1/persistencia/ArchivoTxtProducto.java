/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.persistencia;


import com.mycompany.mavenproject1.entidades.Producto;
import com.mycompany.mavenproject1.entidades.ProductoConcreto;
import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Jairo F
 */
public class ArchivoTxtProducto implements IProducto {

    private File archivo;
    private FileWriter archivoEscritura;
    private Scanner archivoLectura;

    public ArchivoTxtProducto() {
        this("FileProductos.txt");
    }

    public ArchivoTxtProducto(String nameFile) {
        this.archivo = new File(nameFile);
    }

    @Override
    public void adicionarProducto(Producto p) {
        PrintWriter pw = null;
        try {
            this.archivoEscritura = new FileWriter(this.archivo, true);
            pw = new PrintWriter(this.archivoEscritura);
            pw.println(p.getDataFromFileTxt());
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Error al abrir o escribir en el archivo");
        } finally {
            if (pw != null)
                pw.close();
        }
    }

    public Producto leerFromFile(String data[]) {
        Producto leido;

        String producto = String.valueOf(data[0]);
        String grupo = String.valueOf(data[1]);
        int stock = Integer.parseInt(data[2]);
        LocalDate fechaC = LocalDate.parse(data[3]);
        String proveedor = data[4];
        LocalDate fechaG = LocalDate.parse(data[5]);

        leido = new ProductoConcreto(producto, grupo, stock, fechaC, proveedor, fechaG);

        // Construir y devolver un objeto Producto con los datos leídos
        return leido;
    }

    @Override
    public ArrayList<Producto> obtenerProductos() {
        try {
            this.archivoLectura = new Scanner(this.archivo);
            ArrayList<Producto> productosLeidos = new ArrayList();
            while (this.archivoLectura.hasNext()) {
                String datos[] = this.archivoLectura.nextLine().split(";");
                Producto leido = this.leerFromFile(datos);
                productosLeidos.add(leido);
            }
            return productosLeidos;
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Error al abrir archivo o no existe");
        } finally {
            if (this.archivoLectura != null)
                this.archivoLectura.close();
        }
    }
    
}
