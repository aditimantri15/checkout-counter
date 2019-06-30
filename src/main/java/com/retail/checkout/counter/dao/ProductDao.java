package com.retail.checkout.counter.dao;

import com.retail.checkout.counter.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ProductDao extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> getAllByIdIn(Set<Long> productIds);
}
