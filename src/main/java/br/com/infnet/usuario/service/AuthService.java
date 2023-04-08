package br.com.infnet.usuario.service;

import br.com.infnet.usuario.model.Usuario;
import br.com.infnet.usuario.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    IUserRepository userRepository;

    public Usuario logar(String email, String senha) {
        return userRepository.findUsuarioByEmailAndSenha(email, senha);
    }
}
