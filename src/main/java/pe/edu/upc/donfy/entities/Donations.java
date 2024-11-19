package pe.edu.upc.donfy.entities;

import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.Date;
@Entity
@Table(name = "Donations")
public class Donations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDonation;

    @Column(name = "nombre", length = 150)
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "estado", length = 20)
    private String estado;

    @Column(name = "fechaRecojo")
    private LocalDate fechaRecojo;

    @Column(name = "montoDonado")
    private float montoDonado;

    @Column(name = "eliminado")
    private boolean eliminado;

    @Column(name = "direccionRecojo", length = 200)
    private String direccionRecojo;

    @ManyToOne
    @JoinColumn(name = "Users_id")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "TipoDonativo_id")
    private DonationType donationType;

    @ManyToOne
    @JoinColumn(name = "Users_Id_Receptor")
    private Users usersReceptor;

    public Donations() {
    }

    public Donations(int idDonation, String nombre, String descripcion, String estado, LocalDate fechaRecojo, float montoDonado, boolean eliminado, String direccionRecojo, Users users, DonationType donationType, Users usersReceptor) {
        this.idDonation = idDonation;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaRecojo = fechaRecojo;
        this.montoDonado = montoDonado;
        this.eliminado = eliminado;
        this.direccionRecojo = direccionRecojo;
        this.users = users;
        this.donationType = donationType;
        this.usersReceptor = usersReceptor;
    }

    public int getIdDonation() {
        return idDonation;
    }

    public void setIdDonation(int idDonation) {
        this.idDonation = idDonation;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFechaRecojo() {
        return fechaRecojo;
    }

    public void setFechaRecojo(LocalDate fechaRecojo) {
        this.fechaRecojo = fechaRecojo;
    }

    public float getMontoDonado() {
        return montoDonado;
    }

    public void setMontoDonado(float montoDonado) {
        this.montoDonado = montoDonado;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    public String getDireccionRecojo() {
        return direccionRecojo;
    }

    public void setDireccionRecojo(String direccionRecojo) {
        this.direccionRecojo = direccionRecojo;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public DonationType getDonationType() {
        return donationType;
    }

    public void setDonationType(DonationType donationType) {
        this.donationType = donationType;
    }

    public Users getUsersReceptor() {
        return usersReceptor;
    }

    public void setUsersReceptor(Users usersReceptor) {
        this.usersReceptor = usersReceptor;
    }
}
