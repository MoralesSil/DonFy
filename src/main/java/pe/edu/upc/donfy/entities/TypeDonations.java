package pe.edu.upc.donfy.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "TypeDonations")
public class TypeDonations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTypeDonation;
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    public TypeDonations() {
    }

    public TypeDonations(int idTypeDonation, String nombre) {
        this.idTypeDonation = idTypeDonation;
        this.nombre = nombre;
    }

    public int getIdTypeDonation() {
        return idTypeDonation;
    }

    public void setIdTypeDonation(int idTypeDonation) {
        this.idTypeDonation = idTypeDonation;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
