package br.com.infnet.usuario.service;

import br.com.infnet.usuario.model.Cliente;
import br.com.infnet.usuario.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    IClienteRepository clienteRepository;

    public void addCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }



}
