
package com.ebim.esupplier.service;

import com.ebim.esupplier.web.dto.BusinessPartnerDTO;

public interface IBusinessPartnerService {
    BusinessPartnerDTO getbusinessPartner(Integer id);
    BusinessPartnerDTO savebusinessPartner(BusinessPartnerDTO businessPartnerDTO);
    BusinessPartnerDTO updatbusinessPartner(BusinessPartnerDTO businessPartnerDTO, Integer id);
    void deletebusinessPartner(Integer id);
}
