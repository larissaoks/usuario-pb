package br.com.infnet.usuario.model;

import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cliente")
@DiscriminatorValue("cliente")
public class Cliente extends Usuario{
    private String cpf;

    public Cliente(String nome, String email, String senha, String telefone, String cpf) {
        super(nome, email, senha, telefone);
        this.cpf = cpf;
    }

}
