
package com.ebim.esupplier.controller;

import com.ebim.esupplier.domain.Location;
import com.ebim.esupplier.repository.LocationRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/locations")
public class LocationsController extends BaseCrudController<Location, String> {
    public LocationsController(LocationRepository repo) { super(repo); }
}
