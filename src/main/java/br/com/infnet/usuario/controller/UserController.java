package br.com.infnet.usuario.controller;

import br.com.infnet.usuario.model.Usuario;
import br.com.infnet.usuario.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("usuario/")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("add")
    public ResponseEntity<Map<String, Object>> addUser(@RequestBody Usuario user) {
        if (user.getNome().isEmpty() || user.getSenha().isEmpty() || user.getEmail().isEmpty() || user.getTelefone().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("Error", "Algum dos campos não preenchidos"));
        }
        userService.addUser(user);

        return ResponseEntity.ok(Map.of("Usuário Criado com sucesso!", user));
    }

    @GetMapping("listarUsuarios")
    public ResponseEntity<Map<String,List<Usuario>>> listarUsers(){
        List<Usuario> usuarios = userService.buscarUsuarios();
        if(usuarios.isEmpty()){
            return ResponseEntity.ok(Map.of("Aviso: Não há usuário cadastrados", usuarios));
        }
        return ResponseEntity.ok(Map.of("User", usuarios));
    }

    /*@GetMapping("getUserInfo")
    public ResponseEntity<String> getUserInfo(){
        String nomeUser = userService.
    }*/
}
