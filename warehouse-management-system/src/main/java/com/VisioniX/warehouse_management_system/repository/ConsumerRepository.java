package com.VisioniX.warehouse_management_system.repository;

import com.VisioniX.warehouse_management_system.entity.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumerRepository
        extends JpaRepository<Consumer, Long> {
}