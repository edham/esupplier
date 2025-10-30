
package com.ebim.esupplier.web.mapper;

import com.ebim.esupplier.domain.Contact;
import com.ebim.esupplier.web.dto.ContactDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ContactMapper {
    @Mapping(target="businessPartner.id", source="businessPartnerId")
    Contact toEntity(ContactDTO dto);

    @Mapping(target="businessPartnerId", source="businessPartner.id")
    ContactDTO toDTO(Contact entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target="businessPartner.id", source="businessPartnerId")
    void updateFromDTO(ContactDTO dto, @MappingTarget Contact entity);
}
