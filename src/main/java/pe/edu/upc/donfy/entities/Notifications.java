package pe.edu.upc.donfy.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "Notifications")
public class Notifications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNotificacion;

    private int Mensaje;
    private String estado;

    public Notifications() {

    }

    public Notifications(int idNotificacion, int Mensaje, String estado) {
        this.idNotificacion = idNotificacion;
        this.Mensaje = Mensaje;
        this.estado = estado;
    }

    public int getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(int idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public int getMensaje() {
        return Mensaje;
    }

    public void setMensaje(int mensaje) {
        Mensaje = mensaje;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
