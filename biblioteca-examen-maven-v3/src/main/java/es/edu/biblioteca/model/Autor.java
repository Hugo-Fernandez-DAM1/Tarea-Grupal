package es.edu.biblioteca.model;

public class Autor {
    private int id;
    private String nombre;
    private String nacionalidad;

    public Autor(int id,String nombre,String nacionalidad) {
        this.id = id;
        this.nombre=nombre;
        this.nacionalidad=nacionalidad;
    }
    public Autor(String nombre,String nacionalidad) {
        this.nombre=nombre;
        this.nacionalidad=nacionalidad;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return id + " - " + nombre + " (" + nacionalidad + ")";
    }
}
