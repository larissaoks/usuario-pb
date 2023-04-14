package br.com.infnet.usuario.model;

import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "admin")
@DiscriminatorValue("admin")
public class Admin extends Usuario{
    private String cargo;

    public Admin(String nome, String email, String senha, String telefone, String cargo) {
        super(nome, email, senha, telefone);
        this.cargo = cargo;
    }

}
