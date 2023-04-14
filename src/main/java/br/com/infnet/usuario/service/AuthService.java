package br.com.infnet.usuario.service;

import br.com.infnet.usuario.model.Admin;
import br.com.infnet.usuario.model.Cliente;
import br.com.infnet.usuario.model.Usuario;
import br.com.infnet.usuario.repository.IAdminRepository;
import br.com.infnet.usuario.repository.IClienteRepository;
import br.com.infnet.usuario.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Qualifier("IUserRepository")
    @Autowired
    IUserRepository userRepository;

    @Autowired
    IAdminRepository adminRepository;

    @Autowired
    IClienteRepository clienteRepository;

    public Usuario logar(String email, String senha) {
        return userRepository.findByEmailAndSenha(email, senha);
    }

    public Admin logarAdmin(String email, String senha){
        return adminRepository.findByEmailAndSenha(email, senha);
    }

    public Cliente logarCliente(String email, String senha){
        return clienteRepository.findByEmailAndSenha(email, senha);
    }

}
