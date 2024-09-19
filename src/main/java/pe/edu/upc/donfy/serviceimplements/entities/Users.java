package pe.edu.upc.donfy.serviceimplements.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import pe.edu.upc.donfy.entities.Role;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Users")
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 30)
    private String username;
    @Column(length = 200)
    private String password;

    private Boolean enabled;

    @Column(name = "correo", nullable = false, length = 50)
    private String correo;
    @Column(name = "nombre", nullable = false, length = 20)
    private String nombre;
    @Column(name = "apellidos", nullable = false, length = 30)
    private String apellidos;
    @Column(name = "telefono", nullable = false, length = 9)
    private String telefono;
    @Column(name = "dni", nullable = false, length = 8)
    private String dni;
    @Column(name = "ruc", nullable = false, length = 11)
    private String ruc;
    @Column(name = "direccion", nullable = false, length = 150)
    private String direccion;
    @Column(name = "nombreONG", nullable = false, length = 200)
    private String nombreONG;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Role> roles;

    public Users() {
    }

    public Users(Long id, String username, String password, Boolean enabled, String correo, String nombre, String apellidos, String telefono, String dni, String ruc, String direccion, String nombreONG, List<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.correo = correo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.dni = dni;
        this.ruc = ruc;
        this.direccion = direccion;
        this.nombreONG = nombreONG;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
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

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombreONG() {
        return nombreONG;
    }

    public void setNombreONG(String nombreONG) {
        this.nombreONG = nombreONG;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
