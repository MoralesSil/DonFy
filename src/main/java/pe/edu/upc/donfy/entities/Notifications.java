package pe.edu.upc.donfy.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Notifications")
public class Notifications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNotificacion;

    @Column(name = "mensaje", nullable = false)
    private String mensaje;
    @Column(name="estado", nullable=false, length=50)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "tipoNotificacion_id")
    private NotificationType tipoNotificacion;

    public Notifications() {

    }

    public Notifications(int idNotificacion, String mensaje, String estado, NotificationType tipoNotificacion) {
        this.idNotificacion = idNotificacion;
        this.mensaje = mensaje;
        this.estado = estado;
        this.tipoNotificacion = tipoNotificacion;
    }

    public int getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(int idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public NotificationType getTipoNotificacion() {
        return tipoNotificacion;
    }

    public void setTipoNotificacion(NotificationType tipoNotificacion) {
        this.tipoNotificacion = tipoNotificacion;
    }
}
