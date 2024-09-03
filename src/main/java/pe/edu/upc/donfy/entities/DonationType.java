package pe.edu.upc.donfy.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "DonationType")
public class DonationType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoDonation;
    @Column(name="nombreTipoDonation",nullable = false,length = 50)
    private String nombreTipoDonation;

    public DonationType() {

    }

    public int getIdTipoDonation() {
        return idTipoDonation;
    }

    public void setIdTipoDonation(int idTipoDonation) {
        this.idTipoDonation = idTipoDonation;
    }

    public String getNombreTipoDonation() {
        return nombreTipoDonation;
    }

    public void setNombreTipoDonation(String nombreTipoDonation) {
        this.nombreTipoDonation = nombreTipoDonation;
    }
}
