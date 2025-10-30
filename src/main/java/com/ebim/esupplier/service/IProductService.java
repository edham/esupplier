
package com.ebim.esupplier.service;

import com.ebim.esupplier.web.dto.ProductDTO;

public interface IProductService {
    ProductDTO getproduct(String id);
    ProductDTO saveproduct(ProductDTO productDTO);
    ProductDTO updatproduct(ProductDTO productDTO, String id);
    void deleteproduct(String id);
}
