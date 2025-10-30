package com.ebim.esupplier.web.dto;

import lombok.Data;

@Data
public class BankAccountDTO {
    private String id;
    private Integer businessPartnerId;
    private String cuenta;
    private String cci;
    private String iban;
    private String aba;
    private String swif;
    private String idPais;
    private String idTipo;
    private String entidad;
    private String contacto;
    private String idTipoPro;
    private String idTipoMoneda;
    private String idEntidadBancaria;
}