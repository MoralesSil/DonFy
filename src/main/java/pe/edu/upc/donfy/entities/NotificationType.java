package pe.edu.upc.donfy.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "NotificationType")
public class NotificationType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoNotificacion;

    @Column(name="nombre",nullable = false,length = 50)
    private String nombre;

    public NotificationType() {
    }

    public NotificationType(int idTipoNotificacion, String nombre) {
        this.idTipoNotificacion = idTipoNotificacion;
        this.nombre = nombre;
    }

    public int getIdTipoNotificacion() {
        return idTipoNotificacion;
    }

    public void setIdTipoNotificacion(int idTipoNotificacion) {
        this.idTipoNotificacion = idTipoNotificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
