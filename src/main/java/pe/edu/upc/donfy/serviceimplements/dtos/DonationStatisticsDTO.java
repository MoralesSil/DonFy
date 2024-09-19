package pe.edu.upc.donfy.serviceimplements.dtos;

public class DonationStatisticsDTO {
    private Long totalDonativos;
    private Double valorTotalEstimado;
    private Long cantidadONGBeneficiadas;

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

    public Long getCantidadONGBeneficiadas() {
        return cantidadONGBeneficiadas;
    }

    public void setCantidadONGBeneficiadas(Long cantidadONGBeneficiadas) {
        this.cantidadONGBeneficiadas = cantidadONGBeneficiadas;
    }
}
