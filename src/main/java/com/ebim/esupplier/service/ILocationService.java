
package com.ebim.esupplier.service;

import com.ebim.esupplier.web.dto.LocationDTO;

public interface ILocationService {
    LocationDTO getlocation(String id);
    LocationDTO savelocation(LocationDTO locationDTO);
    LocationDTO updatlocation(LocationDTO locationDTO, String id);
    void deletelocation(String id);
}
