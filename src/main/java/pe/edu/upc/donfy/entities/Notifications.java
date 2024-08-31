package pe.edu.upc.donfy.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "Notifications")
public class Notifications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNotificacion;

    @Column(name = "mensaje", nullable = false)
    private int mensaje;
    @Column(name="estado", nullable=false, length=50)
    private String estado;

    public Notifications() {

    }

    public Notifications(int idNotificacion, int Mensaje, String estado) {
        this.idNotificacion = idNotificacion;
        this.mensaje = Mensaje;
        this.estado = estado;
    }

    public int getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(int idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public int getMensaje() {
        return mensaje;
    }

    public void setMensaje(int mensaje) {
        this.mensaje = mensaje;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
