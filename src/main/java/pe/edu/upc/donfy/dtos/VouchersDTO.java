package pe.edu.upc.donfy.dtos;
import jakarta.persistence.Column;
import pe.edu.upc.donfy.entities.Donations;

import java.time.LocalDateTime;
import java.util.Date;


public class VouchersDTO {

    private int idComprobante;
    private Date fechaEmision;
    private double total;
    private String nombreDonante;
    private String descripcion;
    private Donations donations;

    public int getIdComprobante() {
        return idComprobante;
    }

    public void setIdComprobante(int idComprobante) {
        this.idComprobante = idComprobante;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
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

    public Donations getDonations() {
        return donations;
    }

    public void setDonations(Donations donations) {
        this.donations = donations;
    }
}