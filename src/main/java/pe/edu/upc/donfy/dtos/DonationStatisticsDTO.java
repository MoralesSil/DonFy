package pe.edu.upc.donfy.dtos;

public class DonationStatisticsDTO {
    private String nombreONG;
    private Long totalDonativos;
    private Double valorTotalEstimado;

    public String getNombreONG() {
        return nombreONG;
    }

    public void setNombreONG(String nombreONG) {
        this.nombreONG = nombreONG;
    }

    public Long getTotalDonativos() {
        return totalDonativos;
    }

    public void setTotalDonativos(Long totalDonativos) {
        this.totalDonativos = totalDonativos;
    }

    public Double getValorTotalEstimado() {
        return valorTotalEstimado;
    }

    public void setValorTotalEstimado(Double valorTotalEstimado) {
        this.valorTotalEstimado = valorTotalEstimado;
    }
}
