package com.ferreteria.ferreteria.web.controller;

import com.ferreteria.ferreteria.persistance.entity.VentasEntity;
import com.ferreteria.ferreteria.serve.PdfService;
import com.ferreteria.ferreteria.serve.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Controller
public class VentasController {

    private final VentasService ventasService;
    private final PdfService pdfService;

    @Autowired
    public VentasController(VentasService ventasService, PdfService pdfService) {
        this.ventasService = ventasService;
        this.pdfService = pdfService;
    }

    // CREATE
    @GetMapping("/nuevo/ventas")
    public String showAddVentaForm(Model model) {
        model.addAttribute("venta", new VentasEntity());
        return "nuevoVenta";
    }

    @PostMapping("/nuevo/ventas")
    public String saveVenta(@ModelAttribute VentasEntity venta) {
        ventasService.save(venta);
        return "redirect:/ventas/todos";
    }

    // READ
    @GetMapping("/ventas/todos")
    public String getAllVentas(Model model) {
        List<VentasEntity> ventas = ventasService.getAll();
        model.addAttribute("ventas", ventas);
        return "ventas";
    }

    // UPDATE
    @GetMapping("/ventas/actualizar/{id}")
    public String showUpdateVentaForm(@PathVariable("id") int id, Model model) {
        VentasEntity venta = ventasService.findById(id);
        model.addAttribute("venta", venta);
        return "actualizarVenta";
    }

    @PostMapping("/ventas/actualizar/{id}")
    public String updateVenta(@PathVariable("id") int id, @ModelAttribute VentasEntity venta) {
        venta.setIdVenta(id);
        ventasService.save(venta);
        return "redirect:/ventas/todos";
    }

    // DELETE
    @GetMapping("/ventas/eliminar/{id}")
    public String showDeleteVentaForm(@PathVariable("id") int id, Model model) {
        VentasEntity venta = ventasService.findById(id);
        model.addAttribute("venta", venta);
        return "eliminarVenta";
    }

    @DeleteMapping("/ventas/eliminar/{id}")
    @ResponseBody
    public ResponseEntity<Void> deleteVenta(@PathVariable("id") int id) {
        ventasService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    //Buscar
    @GetMapping("/ventas/buscar")
    public String buscarPorId(@RequestParam("id") int id, Model model) {
    VentasEntity venta = ventasService.findById(id);
    model.addAttribute("venta", venta);
    return "buscarVenta";
    }

    //Generar PDF
    @GetMapping("/ventas/ticket/{id}")
    public String generarTicket(@PathVariable("id") int id, Model model) {
    VentasEntity venta = ventasService.findById(id);
    byte[] ticket = pdfService.generarTicket(venta);
    model.addAttribute("ticket", ticket);
    return "ventas";
    }

    //Descargar PDF
    @GetMapping("/ventas/descargar/{id}")
    public ResponseEntity<byte[]> descargarTicket(@PathVariable("id") int id) {
    VentasEntity venta = ventasService.findById(id);
    byte[] ticket = pdfService.generarTicket(venta);

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_PDF);
    String filename = "ticket_" + venta.getIdVenta() + ".pdf";
    headers.setContentDispositionFormData(filename, filename);
    headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
    ResponseEntity<byte[]> response = new ResponseEntity<>(ticket, headers, HttpStatus.OK);
    return response;
    }



}
