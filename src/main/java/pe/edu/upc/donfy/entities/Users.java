package pe.edu.upc.donfy.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @Column(unique = true, length = 20)
    private String username;
    @Column(length = 20)
    private String password;

    @Column(name = "correo",nullable = false, length = 50)
    private String correo;
    @Column(name = "nombre",nullable = false, length = 20)
    private String nombre;
    @Column(name = "apellidos",nullable = false, length = 30)
    private String apellidos;
    @Column(name = "telefono",nullable = false, length = 9)
    private String telefono;
    @Column(name = "dni",nullable = false, length = 8)
    private String dni;

    public Users() {
    }

    public Users(int idUsuario, String username, String password, String correo, String nombre, String apellidos, String telefono, String dni) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.password = password;
        this.correo = correo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.dni = dni;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
