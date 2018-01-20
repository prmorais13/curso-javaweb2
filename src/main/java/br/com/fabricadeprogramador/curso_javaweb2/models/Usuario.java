package br.com.fabricadeprogramador.curso_javaweb2.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter @Setter @NoArgsConstructor
@Entity
public class Usuario implements Serializable{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String senha;

    @JoinColumn(name = "perfil_id")
    @ManyToOne
    private Perfil perfil;
}
