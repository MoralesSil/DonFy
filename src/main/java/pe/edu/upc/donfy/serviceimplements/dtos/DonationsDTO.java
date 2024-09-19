package pe.edu.upc.donfy.serviceimplements.dtos;

import pe.edu.upc.donfy.entities.DonationType;
import pe.edu.upc.donfy.entities.Notifications;
import pe.edu.upc.donfy.entities.Users;

import java.time.LocalDate;

public class DonationsDTO {
    private int idDonation;
    private String nombre;
    private String descripcion;
    private String estado;
    private String categoria;
    private String fotoDonativo;
    private LocalDate fechaRecojo;
    private float montoDonado;
    private float precioDonativo;
    private int stock;
    private boolean eliminado;
    private Users user;
    private DonationType donationType;
    private Notifications notifications;
    private String direccionRecojo;
    private Users userReceptor;

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

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
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

    public String getDireccionRecojo() {
        return direccionRecojo;
    }

    public void setDireccionRecojo(String direccionRecojo) {
        this.direccionRecojo = direccionRecojo;
    }

    public Users getUserReceptor() {
        return userReceptor;
    }

    public void setUserReceptor(Users userReceptor) {
        this.userReceptor = userReceptor;
    }
}

