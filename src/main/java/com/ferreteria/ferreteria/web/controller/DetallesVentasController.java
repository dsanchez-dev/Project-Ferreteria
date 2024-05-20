package com.ferreteria.ferreteria.web.controller;

import com.ferreteria.ferreteria.persistance.entity.DetallesVentaEntity;
import com.ferreteria.ferreteria.serve.DetallesVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DetallesVentasController {

    private final DetallesVentaService detallesVentasService;

    @Autowired
    public DetallesVentasController(DetallesVentaService detallesVentasService) {
        this.detallesVentasService = detallesVentasService;
    }

    //CREATE
    @GetMapping("/nuevo/detallesVentas")
    public String showAddDetallesVentaForm(Model model) {
        model.addAttribute("detallesVenta", new DetallesVentaEntity());
        return "nuevoDetalleVenta";
    }

    @PostMapping("/nuevo/detallesVentas")
    public String saveDetallesVenta(@ModelAttribute DetallesVentaEntity detallesVenta) {
        detallesVentasService.save(detallesVenta);
        return "redirect:/detallesVentas/todos";
    }

    //READ
    @GetMapping("/detallesVentas/todos")
    public String getAllDetallesVentas(Model model) {
    List<DetallesVentaEntity> detallesVentas = detallesVentasService.getAll();
    model.addAttribute("detallesVentas", detallesVentas);
    return "detallesVentas";
    }

    //UPDATE
    @GetMapping("/detallesVentas/actualizar/{id}")
    public String showUpdateDetallesVentaForm(@PathVariable("id") int id, Model model) {
        DetallesVentaEntity detallesVenta = detallesVentasService.findById(id);
        model.addAttribute("detallesVenta", detallesVenta);
        return "actualizarDetalleVenta";
    }

    @PostMapping("/detallesVentas/actualizar/{id}")
    public String updateDetallesVenta(@PathVariable("id") int id, @ModelAttribute DetallesVentaEntity detallesVenta) {
        detallesVenta.setIdDetalle(id);
        detallesVentasService.save(detallesVenta);
        return "redirect:/detallesVentas/todos";
    }

    //DELETE
    @GetMapping("/detallesVentas/eliminar/{id}")
    public String showDeleteDetallesVentaForm(@PathVariable("id") int id, Model model) {
        DetallesVentaEntity detallesVenta = detallesVentasService.findById(id);
        model.addAttribute("detallesVenta", detallesVenta);
        return "eliminarDetalleVenta";
    }

    @DeleteMapping("/detallesVentas/eliminar/{id}")
    @ResponseBody
    public ResponseEntity<Void> deleteDetallesVenta(@PathVariable("id") int id) {
        detallesVentasService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    //Buscar
    @GetMapping("/detallesVentas/buscar")
    public String buscarPorId(@RequestParam("id") int id, Model model) {
    DetallesVentaEntity detallesVenta = detallesVentasService.findById(id);
    model.addAttribute("detallesVenta", detallesVenta);
    return "buscarDetalleVenta";
    }
}
