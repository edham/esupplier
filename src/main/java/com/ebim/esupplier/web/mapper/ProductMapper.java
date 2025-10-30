
package com.ebim.esupplier.web.mapper;

import com.ebim.esupplier.domain.Product;
import com.ebim.esupplier.web.dto.ProductDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target="businessPartner.id", source="businessPartnerId")
    Product toEntity(ProductDTO dto);

    @Mapping(target="businessPartnerId", source="businessPartner.id")
    ProductDTO toDTO(Product entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target="businessPartner.id", source="businessPartnerId")
    void updateFromDTO(ProductDTO dto, @MappingTarget Product entity);
}
