package pe.edu.upc.donfy.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

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

    @Column(name = "categoria", nullable = false, length = 50)
    private String categoria;

    @Column(name = "fotoDonativo", nullable = false)
    private String fotoDonativo;

    @Column(name = "fechaRecojo", nullable = false)
    private LocalDate fechaRecojo;

    @Column(name = "montoDonado", nullable = false)
    private float montoDonado;

    @Column(name = "precioDonativo", nullable = false)
    private float precioDonativo;

    @Column(name = "stock", nullable = false)
    private int stock;

    @Column(name = "eliminado")
    private boolean eliminado;

    @Column(name = "direccionRecojo", nullable = false, length = 200)
    private String direccionRecojo;

    @ManyToOne
    @JoinColumn(name = "Users_id")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "TipoDonativo_id")
    private DonationType donationType;

    @ManyToOne
    @JoinColumn(name = "Notification_id")
    private Notifications notifications;

    @ManyToOne
    @JoinColumn(name = "Users_Id_Receptor")
    private Users usersReceptor;

    public Donations() {
    }

    public Donations(int idDonation, String nombre, String descripcion, String estado, String categoria, String fotoDonativo, LocalDate fechaRecojo, float montoDonado, float precioDonativo, int stock, boolean eliminado, String direccionRecojo, Users users, DonationType donationType, Notifications notifications, Users usersReceptor) {
        this.idDonation = idDonation;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.categoria = categoria;
        this.fotoDonativo = fotoDonativo;
        this.fechaRecojo = fechaRecojo;
        this.montoDonado = montoDonado;
        this.precioDonativo = precioDonativo;
        this.stock = stock;
        this.eliminado = eliminado;
        this.direccionRecojo = direccionRecojo;
        this.users = users;
        this.donationType = donationType;
        this.notifications = notifications;
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

    public Notifications getNotifications() {
        return notifications;
    }

    public void setNotifications(Notifications notifications) {
        this.notifications = notifications;
    }

    public Users getUsersReceptor() {
        return usersReceptor;
    }

    public void setUsersReceptor(Users usersReceptor) {
        this.usersReceptor = usersReceptor;
    }
}
