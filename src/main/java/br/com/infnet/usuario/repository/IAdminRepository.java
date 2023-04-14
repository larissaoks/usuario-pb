package br.com.infnet.usuario.repository;

import br.com.infnet.usuario.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdminRepository extends IUserRepository{
    @Override
    Admin findByEmailAndSenha(String email, String senha);

}
