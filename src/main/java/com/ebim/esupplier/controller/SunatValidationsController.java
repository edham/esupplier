
package com.ebim.esupplier.controller;

import com.ebim.esupplier.domain.SunatValidation;
import com.ebim.esupplier.repository.SunatValidationRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sunat-validations")
public class SunatValidationsController extends BaseCrudController<SunatValidation, Integer> {
    public SunatValidationsController(SunatValidationRepository repo) { super(repo); }
}
