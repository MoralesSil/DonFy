package pe.edu.upc.donfy.dtos;

public class DonationsSummaryYearONGDTO {
    private String nombreONG;
    private float montoDonado;

    public String getNombreONG() {
        return nombreONG;
    }

    public void setNombreONG(String nombreONG) {
        this.nombreONG = nombreONG;
    }

    public float getMontoDonado() {
        return montoDonado;
    }

    public void setMontoDonado(float montoDonado) {
        this.montoDonado = montoDonado;
    }
}
