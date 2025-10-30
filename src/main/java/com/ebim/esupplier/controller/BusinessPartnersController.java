
package com.ebim.esupplier.controller;

import com.ebim.esupplier.domain.BusinessPartner;
import com.ebim.esupplier.repository.BusinessPartnerRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/business-partners")
public class BusinessPartnersController extends BaseCrudController<BusinessPartner, Integer> {
    public BusinessPartnersController(BusinessPartnerRepository repo) { super(repo); }
}
