package com.ferreteria.ferreteria.persistance.repository;

import com.ferreteria.ferreteria.persistance.entity.DetallesVentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetallesVentaRepository extends JpaRepository<DetallesVentaEntity,Integer> {
    List<DetallesVentaEntity> findByIdDetalle(int cantidad);
}