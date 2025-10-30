
    package com.ebim.esupplier.web.dto;

    import lombok.Data;

    @Data
    public class ContactDTO {
        private String id;
private Integer businessPartnerId;
private String nombres;
private String apellidos;
private String cargo;
private String correo;
private String telefono;
private Boolean principal;
    }
