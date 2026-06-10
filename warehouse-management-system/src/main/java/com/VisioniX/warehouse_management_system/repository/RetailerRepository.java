package com.VisioniX.warehouse_management_system.repository;

import com.VisioniX.warehouse_management_system.entity.Retailer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetailerRepository extends JpaRepository<Retailer, Long> {
}