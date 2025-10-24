package es.edu.biblioteca.model;

public class Libro {
    private int id;
    private String titulo;
    private int idAutor;
    private int anioPublicacion;
    private String nombreAutor; // Para mostrar en JOIN

    public Libro(int id,String titulo,int idAutor,int anioPublicacion,String nombreAutor) {
        this.id=id;
        this.titulo=titulo;
        this.idAutor=idAutor;
        this.anioPublicacion=anioPublicacion;
        this.nombreAutor=nombreAutor;
    }
    public Libro(String titulo,int idAutor,int anioPublicacion) {
        this.titulo=titulo;
        this.idAutor=idAutor;
        this.anioPublicacion=anioPublicacion;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "anioPublicacion=" + anioPublicacion +
                ", id=" + id +
                ", titulo='" + titulo + '\'' +
                ", idAutor=" + idAutor +
                ", nombreAutor='" + nombreAutor + '\'' +
                '}';
    }
}
