package pe.edu.upc.donfy.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRolUsuario;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    public Role() {
    }

    public Role(int idRolUsuario, String nombre) {
        this.idRolUsuario = idRolUsuario;
        this.nombre = nombre;
    }

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
