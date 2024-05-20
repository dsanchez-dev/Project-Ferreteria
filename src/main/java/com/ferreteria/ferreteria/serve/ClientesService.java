package com.ferreteria.ferreteria.serve;

import com.ferreteria.ferreteria.persistance.entity.ClientesEntity;
import com.ferreteria.ferreteria.persistance.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientesService {

    private final ClientesRepository clientesRepository;

    @Autowired
    public ClientesService(ClientesRepository clientesRepository) {
        this.clientesRepository = clientesRepository;
    }


    public List<ClientesEntity> getAll(){
        return clientesRepository.findAll(Sort.by(Sort.Direction.DESC, "idCliente"));
    }


    public ClientesEntity save(ClientesEntity cliente){
        return clientesRepository.save(cliente);
    }

    //                                CRUD     Method
public ClientesEntity findById(int idCliente) {
    return clientesRepository.findById(idCliente)
        .orElseThrow(() -> new RuntimeException("Cliente no encontrado con id: " + idCliente));
}

   public void deleteById(int idCliente) {
    clientesRepository.deleteById(idCliente);
    }

    public List<ClientesEntity> buscarPorNombre(String nombre) {
        return clientesRepository.findByNombre(nombre);
    }



}
