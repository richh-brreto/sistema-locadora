package com.example.locadora_filmes.service;

import com.example.locadora_filmes.DTO.cliente.ClienteRequest;
import com.example.locadora_filmes.DTO.cliente.ClienteResponse;
import com.example.locadora_filmes.mapper.ClienteMapper;
import com.example.locadora_filmes.model.Cliente;
import com.example.locadora_filmes.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@RequestMapping("/clientes")
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> listar(){
        return clienteRepository.findAll();
    }

    public ClienteResponse cadastrar(ClienteRequest request){
        return ClienteMapper.toResponse(clienteRepository.save(ClienteMapper.toEntity(request)));
    }
}
