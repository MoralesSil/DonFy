package pe.edu.upc.donfy.dtos;

public class DonationStatisticsDTO {
    private Long totalDonativos;
    private Double valorTotalEstimado;
    private Integer cantidadONGBeneficiadas;

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

    public Integer getCantidadONGBeneficiadas() {
        return cantidadONGBeneficiadas;
    }

    public void setCantidadONGBeneficiadas(Integer cantidadONGBeneficiadas) {
        this.cantidadONGBeneficiadas = cantidadONGBeneficiadas;
    }
}
