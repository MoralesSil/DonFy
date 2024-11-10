package pe.edu.upc.donfy.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "Vouchers")
public class Vouchers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComprobante;

    @Column(name = "fechaEmision", nullable = false)
    private LocalDateTime fechaEmision;

    @Column(name = "total", nullable = false)
    private double total;

    @Column(name = "nombreDonante", nullable = false, length = 200)
    private String nombreDonante;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "idDonativo")
    private Donations donations;

    public Vouchers() {
    }

    public Vouchers(int idComprobante, LocalDateTime fechaEmision, double total, String nombreDonante, String descripcion, Donations donations) {
        this.idComprobante = idComprobante;
        this.fechaEmision = fechaEmision;
        this.total = total;
        this.nombreDonante = nombreDonante;
        this.descripcion = descripcion;
        this.donations = donations;
    }

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

    public Donations getDonations() {
        return donations;
    }

    public void setDonations(Donations donations) {
        this.donations = donations;
    }
}
