package pe.edu.upc.donfy.entities;

import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.Date;

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

    @Column(name = "usuarioReceptor", nullable = false, length = 200)
    private String usuarioReceptor;

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


    public Donations() {
    }


}
