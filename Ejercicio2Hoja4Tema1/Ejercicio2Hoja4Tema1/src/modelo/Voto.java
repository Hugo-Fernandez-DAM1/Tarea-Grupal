package modelo;

import java.time.LocalDate;

public class Voto {
    private String usuario;
    private LocalDate fecha;
    private int nCancion;

    public Voto(String usuario, LocalDate fecha, int nCancion) {
        this.usuario = usuario;
        this.fecha = fecha;
        this.nCancion = nCancion;
    }

    public String getUsuario() {
        return usuario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public int getnCancion() {
        return nCancion;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setnCancion(int nCancion) {
        this.nCancion = nCancion;
    }
    @Override
    public String toString() {
        return "Voto{" +
                "usuario='" + usuario + '\'' +
                ", fecha=" + fecha +
                ", nCancion=" + nCancion +
                '}';
    }
}
