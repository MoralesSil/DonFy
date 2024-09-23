package pe.edu.upc.donfy.dtos;

import pe.edu.upc.donfy.entities.NotificationType;
import pe.edu.upc.donfy.entities.Users;

public class NotificationsDTO {
    private int idNotificacion;
    private String mensaje;
    private String estado;
    private NotificationType tipoNotificacion;
    private Users usuarios;

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

    public Users getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Users usuarios) {
        this.usuarios = usuarios;
    }
}
