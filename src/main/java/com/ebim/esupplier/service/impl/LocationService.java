
package com.ebim.esupplier.service.impl;

import com.ebim.esupplier.domain.Location;
import com.ebim.esupplier.repository.LocationRepository;
import com.ebim.esupplier.service.ILocationService;
import com.ebim.esupplier.web.dto.LocationDTO;
import com.ebim.esupplier.web.mapper.LocationMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LocationService implements ILocationService {
    private final LocationRepository repo;
    private final LocationMapper mapper;

    public LocationService(LocationRepository repo, LocationMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    @Transactional(readOnly = true)
    public LocationDTO getlocation(String id) {
        var entity = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Location not found"));
        return mapper.toDTO(entity);
    }

    @Override
    public LocationDTO savelocation(LocationDTO locationDTO) {
        var entity = mapper.toEntity(locationDTO);
        // Relationship fix if needed handled by mapper
        entity = repo.save(entity);
        return mapper.toDTO(entity);
    }

    @Override
    public LocationDTO updatlocation(LocationDTO locationDTO, String id) {
        var entity = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Location not found"));
        mapper.updateFromDTO(locationDTO, entity);
        entity = repo.save(entity);
        return mapper.toDTO(entity);
    }

    @Override
    public void deletelocation(String id) {
        if (!repo.existsById(id)) throw new IllegalArgumentException("Location not found");
        repo.deleteById(id);
    }
}
