package br.com.infnet.usuario.repository;

import br.com.infnet.usuario.model.Cliente;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends IUserRepository{
    @Override
    Cliente findByEmailAndSenha(String email, String senha);
}
