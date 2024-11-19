package pe.edu.upc.donfy.dtos;

public class DonationforTypemothDTO {
    private String tipoDonation;
    private Long cantidadDonaciones;
    private int mes;

    public String getTipoDonation() {
        return tipoDonation;
    }

    public void setTipoDonation(String tipoDonation) {
        this.tipoDonation = tipoDonation;
    }

    public Long getCantidadDonaciones() {
        return cantidadDonaciones;
    }

    public void setCantidadDonaciones(Long cantidadDonaciones) {
        this.cantidadDonaciones = cantidadDonaciones;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }
}
