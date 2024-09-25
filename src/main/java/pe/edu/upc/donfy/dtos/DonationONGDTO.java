package pe.edu.upc.donfy.dtos;

import java.time.LocalDate;

public class DonationONGDTO {
    private int idDonativo;
    private String nombreDonativo;
    private String descripcion;
    private String estado;
    private LocalDate fechaRecojo;
    private float montoDonado;
    private String direccionRecojo;
    private Long idONG;
    private String nombreONG;

    public int getIdDonativo() {
        return idDonativo;
    }

    public void setIdDonativo(int idDonativo) {
        this.idDonativo = idDonativo;
    }

    public String getNombreDonativo() {
        return nombreDonativo;
    }

    public void setNombreDonativo(String nombreDonativo) {
        this.nombreDonativo = nombreDonativo;
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

    public String getDireccionRecojo() {
        return direccionRecojo;
    }

    public void setDireccionRecojo(String direccionRecojo) {
        this.direccionRecojo = direccionRecojo;
    }

    public Long getIdONG() {
        return idONG;
    }

    public void setIdONG(Long idONG) {
        this.idONG = idONG;
    }

    public String getNombreONG() {
        return nombreONG;
    }

    public void setNombreONG(String nombreONG) {
        this.nombreONG = nombreONG;
    }
}
