
package com.ebim.esupplier.service;

import com.ebim.esupplier.web.dto.CatalogItemDTO;

public interface ICatalogItemService {
    CatalogItemDTO getcatalogItem(String id);
    CatalogItemDTO savecatalogItem(CatalogItemDTO catalogItemDTO);
    CatalogItemDTO updatcatalogItem(CatalogItemDTO catalogItemDTO, String id);
    void deletecatalogItem(String id);
}
