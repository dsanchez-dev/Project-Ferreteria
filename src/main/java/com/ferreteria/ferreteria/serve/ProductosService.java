package com.ferreteria.ferreteria.serve;

import com.ferreteria.ferreteria.persistance.entity.ProductosEntity;
import com.ferreteria.ferreteria.persistance.repository.ProductosRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductosService {

    private final ProductosRespository productosRespository;

    @Autowired
    public ProductosService(ProductosRespository productosRespository) {
        this.productosRespository = productosRespository;
    }

    public List<ProductosEntity> getAll() {
        return productosRespository.findAll(Sort.by(Sort.Direction.DESC, "idProducto"));
    }

    //                  CRUD    Methods

    // READ
    public ProductosEntity findById(int idProducto){
        return productosRespository.findByIdProducto(idProducto);
    }

    // DELETE
    public void deleteById(int id) {
        productosRespository.deleteById(id);
    }


    public ProductosEntity save(ProductosEntity producto) {
    return productosRespository.save(producto);
    }

    private List<ProductosEntity> productos;

    public List<ProductosEntity> getProductos() {
        return productos;
    }

    public int getCantidad() {
        return this.getCantidad();
    }



}
