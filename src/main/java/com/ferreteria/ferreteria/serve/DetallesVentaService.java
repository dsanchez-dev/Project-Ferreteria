package com.ferreteria.ferreteria.serve;

import com.ferreteria.ferreteria.persistance.entity.DetallesVentaEntity;
import com.ferreteria.ferreteria.persistance.repository.DetallesVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetallesVentaService {
    private final DetallesVentaRepository detallesVentaRepository;

    @Autowired
    public DetallesVentaService(DetallesVentaRepository detallesVentaRepository) {
        this.detallesVentaRepository = detallesVentaRepository;
    }
    //CREATE
    public DetallesVentaEntity save(DetallesVentaEntity detallesVenta) {
        return detallesVentaRepository.save(detallesVenta);
    }

    //READ
    public List<DetallesVentaEntity> getAll() {
        return detallesVentaRepository.findAll(Sort.by(Sort.Direction.DESC, "idDetalle"));
    }


    //DELETE
    public void deleteById(int idDetallesVenta) {
        detallesVentaRepository.deleteById(idDetallesVenta);
    }

    public DetallesVentaEntity findById(int idDetallesVenta) {
        Optional<DetallesVentaEntity> detallesVentaOptional = detallesVentaRepository.findById(idDetallesVenta);
        return detallesVentaOptional.orElse(null);
    }

    public List<DetallesVentaEntity> findByIdDetalle(int cantidad) {
        return detallesVentaRepository.findByIdDetalle(cantidad);
    }

}
