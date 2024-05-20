package com.ferreteria.ferreteria.persistance.repository;

import com.ferreteria.ferreteria.persistance.entity.ProductosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ProductosRespository extends JpaRepository<ProductosEntity, Integer> {

    List<ProductosEntity> findAll();

    @Query(value = "SELECT p FROM ProductosEntity p WHERE p.idProducto =:idProducto")
    ProductosEntity findByIdProducto(@Param("idProducto")int idProducto);

}
