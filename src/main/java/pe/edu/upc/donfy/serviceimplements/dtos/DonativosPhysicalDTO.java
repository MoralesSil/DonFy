package pe.edu.upc.donfy.serviceimplements.dtos;

import java.time.LocalDate;

public class DonativosPhysicalDTO {
    private String usuarioReceptor;
    private String fotoDonativo;
    private LocalDate fechaRecojo;
    private String estado;

    public String getUsuarioReceptor() {
        return usuarioReceptor;
    }

    public void setUsuarioReceptor(String usuarioReceptor) {
        this.usuarioReceptor = usuarioReceptor;
    }

    public String getFotoDonativo() {
        return fotoDonativo;
    }

    public void setFotoDonativo(String fotoDonativo) {
        this.fotoDonativo = fotoDonativo;
    }

    public LocalDate getFechaRecojo() {
        return fechaRecojo;
    }

    public void setFechaRecojo(LocalDate fechaRecojo) {
        this.fechaRecojo = fechaRecojo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
