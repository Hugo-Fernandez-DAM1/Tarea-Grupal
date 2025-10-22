package examen.model;

public class Pedido {
    private int id;
    private int clienteId;
    private String fecha;
    private double importe;

    public Pedido(int id,int clienteId,String fecha,double importe) {
        this.id=id;
        this.clienteId = clienteId;
        this.fecha=fecha;
        this.importe=importe;
    }
    public Pedido(int clienteId,String fecha,double importe) {
        this.clienteId = clienteId;
        this.fecha=fecha;
        this.importe=importe;
    }
    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "clienteId=" + clienteId +
                ", id=" + id +
                ", fecha='" + fecha + '\'' +
                ", importe=" + importe +
                '}';
    }
}
