/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author salsa
 */
public class Cancion {
    private int numCancion;
    private String titulo;
    private int totalvotos;

    public Cancion(int numCancion, String titulo, int totalvotos) {
        this.numCancion = numCancion;
        this.titulo = titulo;
        this.totalvotos = totalvotos;
    }

    public int getNumCancion() {
        return numCancion;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getTotalvotos() {
        return totalvotos;
    }

    @Override
    public String toString() {
        return "Cancion{" + "numCancion=" + numCancion + ", titulo=" + titulo + ", totalvotos=" + totalvotos + '}';
    }
    
}
