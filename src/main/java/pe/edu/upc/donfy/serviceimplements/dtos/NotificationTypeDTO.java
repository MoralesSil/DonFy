package pe.edu.upc.donfy.serviceimplements.dtos;

public class NotificationTypeDTO {
    private int idTipoNotificacion;
    private String nombre;

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
