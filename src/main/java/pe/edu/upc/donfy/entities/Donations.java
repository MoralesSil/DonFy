package pe.edu.upc.donfy.entities;

import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "Donations")
public class Donations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDonation;

    @Column(name = "nombre", nullable = false, length = 150)
    private String nombre;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "estado", nullable = false, length = 20)
    private String estado;

    @Column(name = "categoria", length = 50)
    private String categoria;

    @Column(name = "fotoDonativo")
    private String fotoDonativo;

    @Column(name = "fechaEntrega")
    private Date fechaEntrega;

    @Column(name = "montoDonado")
    private float montoDonado;

    @Column(name = "precioDonativo")
    private float precioDonativo;

    @Column(name = "stock")
    private int stock;

    @Column(name = "eliminado")
    private boolean eliminado;

    @ManyToOne
    @JoinTable(name = "Users_id")
    private Users users;

    @ManyToOne
    @JoinTable(name = "TipoDonativo_id")
    private TypeDonations typeDonationsypeDonations;

    @ManyToOne
    @JoinTable(name = "Notification_id")
    private Notifications notifications;


    public Donations() {
    }

    public Donations(int idDonation, String nombre, String descripcion, String estado, String categoria, String fotoDonativo, Date fechaEntrega, float montoDonado, float precioDonativo, int stock, boolean eliminado, Users users, TypeDonations typeDonationsypeDonations, Notifications notifications) {
        this.idDonation = idDonation;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.categoria = categoria;
        this.fotoDonativo = fotoDonativo;
        this.fechaEntrega = fechaEntrega;
        this.montoDonado = montoDonado;
        this.precioDonativo = precioDonativo;
        this.stock = stock;
        this.eliminado = eliminado;
        this.users = users;
        this.typeDonationsypeDonations = typeDonationsypeDonations;
        this.notifications = notifications;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getFotoDonativo() {
        return fotoDonativo;
    }

    public void setFotoDonativo(String fotoDonativo) {
        this.fotoDonativo = fotoDonativo;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public float getMontoDonado() {
        return montoDonado;
    }

    public void setMontoDonado(float montoDonado) {
        this.montoDonado = montoDonado;
    }

    public float getPrecioDonativo() {
        return precioDonativo;
    }

    public void setPrecioDonativo(float precioDonativo) {
        this.precioDonativo = precioDonativo;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public TypeDonations getTypeDonationsypeDonations() {
        return typeDonationsypeDonations;
    }

    public void setTypeDonationsypeDonations(TypeDonations typeDonationsypeDonations) {
        this.typeDonationsypeDonations = typeDonationsypeDonations;
    }

    public Notifications getNotifications() {
        return notifications;
    }

    public void setNotifications(Notifications notifications) {
        this.notifications = notifications;
    }
}
