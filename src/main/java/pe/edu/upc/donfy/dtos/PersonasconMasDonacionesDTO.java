package pe.edu.upc.donfy.dtos;

public class PersonasconMasDonacionesDTO {
    private String nombre;
    private String nombreTipoDonation;
    private int totalDonaciones;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreTipoDonation() {
        return nombreTipoDonation;
    }

    public void setNombreTipoDonation(String nombreTipoDonation) {
        this.nombreTipoDonation = nombreTipoDonation;
    }

    public int getTotalDonaciones() {
        return totalDonaciones;
    }

    public void setTotalDonaciones(int totalDonaciones) {
        this.totalDonaciones = totalDonaciones;
    }
}
