package pe.edu.upc.donfy.dtos;
import jakarta.persistence.Column;

import java.time.LocalDateTime;


public class VouchersDTO {

    private int idComprobante;
    private LocalDateTime fechaEmision;
    private double total;
    private String nombreDonante;
    private String descripcion;
    private int donativoId;

    public int getIdComprobante() {
        return idComprobante;
    }

    public void setIdComprobante(int idComprobante) {
        this.idComprobante = idComprobante;
    }

    public LocalDateTime getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDateTime fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getNombreDonante() {
        return nombreDonante;
    }

    public void setNombreDonante(String nombreDonante) {
        this.nombreDonante = nombreDonante;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDonativoId() {
        return donativoId;
    }

    public void setDonativoId(int donativoId) {
        this.donativoId = donativoId;
    }
}