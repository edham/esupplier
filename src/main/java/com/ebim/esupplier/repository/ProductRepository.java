
package com.ebim.esupplier.repository;

import com.ebim.esupplier.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {}
