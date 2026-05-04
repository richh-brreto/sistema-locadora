package com.example.locadora_filmes.mapper;

import com.example.locadora_filmes.DTO.cliente.ClienteRequest;
import com.example.locadora_filmes.DTO.cliente.ClienteResponse;
import com.example.locadora_filmes.model.Cliente;

public class ClienteMapper {
    public static Cliente toEntity (ClienteRequest request){
        Cliente cliente = new Cliente();
        cliente.setEmail(request.email());
        cliente.setNome(request.nome());

        return cliente;
    }

    public static ClienteResponse toResponse (Cliente cliente){
        ClienteResponse response = new ClienteResponse(
                cliente.getId(), cliente.getNome(),  cliente.getEmail()
        );

        return response;
    }
}
