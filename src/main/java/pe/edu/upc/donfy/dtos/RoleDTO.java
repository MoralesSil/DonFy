package pe.edu.upc.donfy.dtos;

import jakarta.persistence.Column;

public class RoleDTO {
    private int idRolUsuario;
    private String nombre;

    public int getIdRolUsuario() {
        return idRolUsuario;
    }

    public void setIdRolUsuario(int idRolUsuario) {
        this.idRolUsuario = idRolUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
