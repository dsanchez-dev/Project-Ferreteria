package com.ferreteria.ferreteria.persistance.repository;


import com.ferreteria.ferreteria.persistance.entity.ClientesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ClientesRepository extends JpaRepository<ClientesEntity,Integer> {

    List<ClientesEntity> findByNombre(String nombre);

    List<ClientesEntity> findAll();


}
