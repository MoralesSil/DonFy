package pe.edu.upc.donfy.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Vouchers")
public class Vouchers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComprobante;

    @Column(name = "fechaEmision", nullable = false)
    private Date fechaEmision;

    @Column(name = "total", nullable = false)
    private double total;

    @Column(name = "nombreDonante", nullable = false, length = 200)
    private String nombreDonante;

    @Lob
    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "donativo_idDonat", referencedColumnName = "idDonativo", nullable = false)
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
