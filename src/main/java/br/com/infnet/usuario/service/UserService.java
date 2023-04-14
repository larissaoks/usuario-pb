package br.com.infnet.usuario.service;

import br.com.infnet.usuario.model.Usuario;
import br.com.infnet.usuario.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Qualifier("IUserRepository")
    @Autowired
    IUserRepository userRepository;

    public void addUser(Usuario user) {
        userRepository.save(user);
    }

    public List<Usuario> buscarUsuarios() { return userRepository.findAll(); }

   /* public String getUserInfo(){
        return userRepository.findBy
    }*/
}
