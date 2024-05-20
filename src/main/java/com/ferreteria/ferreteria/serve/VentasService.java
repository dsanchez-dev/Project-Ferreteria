package com.ferreteria.ferreteria.serve;

import com.ferreteria.ferreteria.persistance.entity.VentasEntity;
import com.ferreteria.ferreteria.persistance.repository.VentasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class VentasService {

    private final VentasRepository ventasRepository;

    @Autowired
    public VentasService(VentasRepository ventasRepository) {
        this.ventasRepository = ventasRepository;
    }

    // CREATE
    public VentasEntity save(VentasEntity venta) {
        return ventasRepository.save(venta);
    }

    // READ
    public List<VentasEntity> getAll() {
        return ventasRepository.findAll(Sort.by(Sort.Direction.DESC, "idVenta"));
    }

    public VentasEntity findById(int idVenta) {
        Optional<VentasEntity> ventaOptional = ventasRepository.findById(idVenta);
        return ventaOptional.orElse(null);
    }

    // DELETE
    public void deleteById(int idVenta) {
        ventasRepository.deleteById(idVenta);
    }


    public int getCantidad() {
        return this.getCantidad();
    }


}