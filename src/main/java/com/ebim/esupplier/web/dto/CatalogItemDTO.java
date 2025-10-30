
    package com.ebim.esupplier.web.dto;

    import lombok.Data;

    @Data
    public class CatalogItemDTO {
        private String id;
private Integer businessPartnerId;
private String nombre;
private String fileName;
private java.time.Instant uploadDate;
    }
