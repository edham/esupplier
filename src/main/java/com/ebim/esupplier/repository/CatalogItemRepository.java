
package com.ebim.esupplier.repository;

import com.ebim.esupplier.domain.CatalogItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogItemRepository extends JpaRepository<CatalogItem, String> {}
