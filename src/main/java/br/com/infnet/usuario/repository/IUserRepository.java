package br.com.infnet.usuario.repository;

import br.com.infnet.usuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmailAndSenha(String email, String senha);
}
