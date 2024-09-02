package pe.edu.upc.donfy.dtos;

import jakarta.persistence.Column;

import java.util.Date;

public class DonationsDTO {
    private int idDonation;
    private String nombre;
    private String descripcion;
    private String estado;
    private String categoria;
    private String fotoDonativo;
    private Date fechaEntrega;
    private float montoDonado;
    private float precioDonativo;
    private int stock;
    private boolean eliminado;
    private UsersDTO user;
    private TypeDonationsDTO typeDonation;
    private NotificationsDTO notifications;

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

    public UsersDTO getUser() {
        return user;
    }

    public void setUser(UsersDTO user) {
        this.user = user;
    }

    public TypeDonationsDTO getTypeDonation() {
        return typeDonation;
    }

    public void setTypeDonation(TypeDonationsDTO typeDonation) {
        this.typeDonation = typeDonation;
    }

    public NotificationsDTO getNotifications() {
        return notifications;
    }

    public void setNotifications(NotificationsDTO notifications) {
        this.notifications = notifications;
    }
}