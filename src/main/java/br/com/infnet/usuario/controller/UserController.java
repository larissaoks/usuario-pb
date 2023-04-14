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
}
