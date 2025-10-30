
package com.ebim.esupplier.web.mapper;

import com.ebim.esupplier.domain.CatalogItem;
import com.ebim.esupplier.web.dto.CatalogItemDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CatalogItemMapper {
    @Mapping(target="businessPartner.id", source="businessPartnerId")
    CatalogItem toEntity(CatalogItemDTO dto);

    @Mapping(target="businessPartnerId", source="businessPartner.id")
    CatalogItemDTO toDTO(CatalogItem entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target="businessPartner.id", source="businessPartnerId")
    void updateFromDTO(CatalogItemDTO dto, @MappingTarget CatalogItem entity);
}
