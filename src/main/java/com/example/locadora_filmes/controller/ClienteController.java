package com.example.locadora_filmes.controller;

import com.example.locadora_filmes.DTO.cliente.ClienteRequest;
import com.example.locadora_filmes.DTO.cliente.ClienteResponse;
import com.example.locadora_filmes.model.Cliente;
import com.example.locadora_filmes.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    @Tag(name = "Listar clientes")
    @Operation(summary = "Listar clientes no banco de dados", description = "Usa o 'listar' do ClienteService")
    public List<Cliente> listar(){
        return clienteService.listar();
    }

    @PostMapping
    @Tag(name = "Cadastrar clientes")
    @Operation(summary = "Cadastrar clientes no banco de dados", description = "Usa o 'cadastrar' do ClienteService")
    public ResponseEntity<ClienteResponse> cadastrar(@RequestBody ClienteRequest request){
        return ResponseEntity.status(201).body(clienteService.cadastrar(request));
    }
}
