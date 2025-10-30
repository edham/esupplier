package com.ebim.esupplier.web.dto;

import lombok.Data;

@Data
public class LocationDTO {
    private String id;
    private Integer businessPartnerId;
    private String direccion;
    private String telefono;
    private String idPais;
    private String idTipo;
    private String idRegion;
    private String idDistrito;
    private String idTipoZona;
    private String idProvincia;
    private String idTipoCalle;
    private String departamento;
    private String idTipoDireccion;
}