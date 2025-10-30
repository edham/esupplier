
package com.ebim.esupplier.web.mapper;

import com.ebim.esupplier.domain.BusinessPartner;
import com.ebim.esupplier.web.dto.BusinessPartnerDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface BusinessPartnerMapper {

    BusinessPartner toEntity(BusinessPartnerDTO dto);


    BusinessPartnerDTO toDTO(BusinessPartner entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)

    void updateFromDTO(BusinessPartnerDTO dto, @MappingTarget BusinessPartner entity);
}
