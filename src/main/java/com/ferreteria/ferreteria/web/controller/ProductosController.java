package com.ferreteria.ferreteria.web.controller;

import com.ferreteria.ferreteria.persistance.entity.ProductosEntity;
import com.ferreteria.ferreteria.serve.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class ProductosController {

    private final ProductosService productosService;

    @Autowired
    public ProductosController(ProductosService productosService) {
        this.productosService = productosService;
    }

    // CREATE
    @GetMapping("/nuevo/productos")
    public String showAddProductoForm(Model model) {
        model.addAttribute("producto", new ProductosEntity());
        return "nuevoProducto";
    }

    @PostMapping("/nuevo/productos")
    public String saveProducto(@ModelAttribute ProductosEntity producto) {
        productosService.save(producto);
        return "redirect:/productos/todos";
    }

    // READ
    @GetMapping("/productos/todos")
    public String getAllProductos(Model model) {
        List<ProductosEntity> productos = productosService.getAll();
        model.addAttribute("productos", productos);
        return "productos";
    }

    // UPDATE
    @GetMapping("/productos/actualizar/{id}")
    public String showUpdateProductoForm(@PathVariable("id") int id, Model model) {
        ProductosEntity producto = productosService.findById(id);
        model.addAttribute("producto", producto);
        return "actualizarProducto";
    }

    @PostMapping("/productos/actualizar/{id}")
    public String updateProducto(@PathVariable("id") int id, @ModelAttribute ProductosEntity producto) {
        producto.setIdProducto(id);
        productosService.save(producto);
        return "redirect:/productos/todos";
    }

   // DELETE
    @GetMapping("/productos/eliminar/{id}")
    public String showDeleteProductoForm(@PathVariable("id") int id, Model model) {
    ProductosEntity producto = productosService.findById(id);
    model.addAttribute("producto", producto);
    return "eliminarProducto";
    }

    @PostMapping("/productos/eliminar/{id}")
    public String deleteProducto(@PathVariable("id") int id) {
    productosService.deleteById(id);
    return "redirect:/productos/todos";
    }
    //Busqueda
    @GetMapping("/productos/buscar")
    public String buscarPorId(@RequestParam("id") int id, Model model) {
    ProductosEntity producto = productosService.findById(id);
    model.addAttribute("producto", producto);
    return "buscarProducto";
    }
}