
package com.ebim.esupplier.domain;

import com.ebim.esupplier.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "catalog_items", schema = "esupplier")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class CatalogItem extends BaseEntity<String> {

    @Id
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_partner_id")
    private BusinessPartner businessPartner;

    @Column(name = "nombre")
    private String nombre;

    @Lob
    @Column(name = "archivo")
    private byte[] archivo;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "upload_date")
    private Instant uploadDate;

    @Override
    public String getId() { return id; }
}
