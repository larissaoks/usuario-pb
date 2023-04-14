package br.com.infnet.usuario.model;


import lombok.*;
import org.springframework.core.serializer.Serializer;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_usuario")
public class Usuario implements Serializable {

    @Column(name = "tipo_usuario", insertable = false, updatable = false)
    private String tipoUser;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    private String nome;

    private String email;

    private String senha;

    private String telefone;

    public Usuario(String nome, String email, String senha, String telefone){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;

    }

}
