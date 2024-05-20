package com.ferreteria.ferreteria.web.controller;

import com.ferreteria.ferreteria.persistance.entity.ClientesEntity;
import com.ferreteria.ferreteria.serve.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class ClienteController {

    private final ClientesService clientesService;

    private final ClientesService busquedaService;

    @Autowired
    public ClienteController(ClientesService clientesService, ClientesService busquedaService) {
        this.clientesService = clientesService;
        this.busquedaService = busquedaService;
    }

    //                                  CREATE      //it works

    @GetMapping("/nuevo/clientes")
    public String showAddClienteForm(Model model) {
        model.addAttribute("cliente", new ClientesEntity());
        return "nuevoCliente";
    }

    @PostMapping("/nuevo/clientes")
    public String saveCliente(@ModelAttribute ClientesEntity cliente) {
        clientesService.save(cliente);
        return "redirect:/clientes/todos";
    }

    //                              READ        //it works

    @GetMapping("/clientes/todos")
    public String getAllClientes(Model model) {
        List<ClientesEntity> clientes = clientesService.getAll();
        model.addAttribute("clientes", clientes);
        return "clientes";
    }

    //                                  Update //it works

    @GetMapping("/clientes/actualizar/{id}")
    public String showUpdateClienteForm(@PathVariable("id") int id, Model model) {
        ClientesEntity cliente = clientesService.findById(id);
        model.addAttribute("cliente", cliente);
        return "actualizarCliente";
    }

    @PostMapping("/clientes/actualizar/{id}")
    public String updateCliente(@PathVariable("id") int id, @ModelAttribute ClientesEntity cliente) {
        cliente.setIdCliente(id);
        clientesService.save(cliente);
        return "redirect:/clientes/todos";
    }

    //                                  DELETE  //it works

    @GetMapping("/clientes/eliminar/{id}")
    public String showDeleteClienteForm(@PathVariable("id") int id, Model model) {
        ClientesEntity cliente = clientesService.findById(id);
        model.addAttribute("cliente", cliente);
        return "eliminarCliente";
    }

    @PostMapping("/clientes/eliminar/{id}")
    @ResponseBody
    public ResponseEntity<Void> deleteCliente(@PathVariable("id") int id) {
    clientesService.deleteById(id);
    return ResponseEntity.ok().build();
    }

    //Busqueda

    @GetMapping("/buscar")
    public String buscar(@RequestParam(value = "nombre", required = false) String nombre, Model model) {
        List<ClientesEntity> resultados = busquedaService.buscarPorNombre(nombre);
        model.addAttribute("resultados", resultados);
        return "buscar";
    }
}