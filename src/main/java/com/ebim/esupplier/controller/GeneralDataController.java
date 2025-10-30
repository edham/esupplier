
package com.ebim.esupplier.controller;

import com.ebim.esupplier.domain.GeneralData;
import com.ebim.esupplier.repository.GeneralDataRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/general-data")
public class GeneralDataController extends BaseCrudController<GeneralData, Integer> {
    public GeneralDataController(GeneralDataRepository repo) { super(repo); }
}
