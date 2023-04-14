package br.com.infnet.usuario.controller;

import br.com.infnet.usuario.model.Admin;
import br.com.infnet.usuario.model.Cliente;
import br.com.infnet.usuario.model.Usuario;
import br.com.infnet.usuario.service.AdminService;
import br.com.infnet.usuario.service.ClienteService;
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

    /*@Autowired
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
    }*/

    @Autowired
    ClienteService clienteService;

    @Autowired
    AdminService adminService;

    @PostMapping("addCliente")
    public ResponseEntity<Map<String, Object>> addCliente(@RequestBody Cliente cliente) {
        if (cliente.getNome().isEmpty() || cliente.getSenha().isEmpty() || cliente.getEmail().isEmpty() || cliente.getTelefone().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("Error", "Algum dos campos não preenchidos"));
        }
        clienteService.addCliente(cliente);

        return ResponseEntity.ok(Map.of("Cliente criado com sucesso!", cliente));
    }

    @PostMapping("addAdmin")
    public ResponseEntity<Map<String, Object>> addAdmin(@RequestBody Admin admin) {
        if (admin.getNome().isEmpty() || admin.getSenha().isEmpty() || admin.getEmail().isEmpty() || admin.getTelefone().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("Error", "Algum dos campos não preenchidos"));
        }
        adminService.addAdmin(admin);

        return ResponseEntity.ok(Map.of("Admin criado com sucesso!", admin));
    }

/*    @GetMapping("listarClientes")
    public ResponseEntity<Map<String,List<Cliente>>> listarClientes(){
        List<Cliente> clientes = clienteService.buscarClientes();
        if(clientes.isEmpty()){
            return ResponseEntity.ok(Map.of("Não foram encontrados clientes.", clientes));
        }
        return ResponseEntity.ok(Map.of("Clientes encontrados:", clientes));
    }*/

/*    @GetMapping("listarAdmins")
    public ResponseEntity<Map<String,List<Admin>>> listarAdmins(){
        List<Admin> admins = adminService.buscarAdmins();
        if(admins.isEmpty()){
            return ResponseEntity.ok(Map.of("Não foram encontrados admins.", admins));
        }
        return ResponseEntity.ok(Map.of("Admins encontrados:", admins));
    }*/


    /*@GetMapping("getUserInfo")
    public ResponseEntity<String> getUserInfo(){
        String nomeUser = userService.
    }*/
}
