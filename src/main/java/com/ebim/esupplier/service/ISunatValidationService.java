
package com.ebim.esupplier.service;

import com.ebim.esupplier.web.dto.SunatValidationDTO;

public interface ISunatValidationService {
    SunatValidationDTO getsunatValidation(Integer id);
    SunatValidationDTO savesunatValidation(SunatValidationDTO sunatValidationDTO);
    SunatValidationDTO updatsunatValidation(SunatValidationDTO sunatValidationDTO, Integer id);
    void deletesunatValidation(Integer id);
}
