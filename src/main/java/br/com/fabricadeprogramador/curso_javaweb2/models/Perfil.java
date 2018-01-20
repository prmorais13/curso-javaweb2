package br.com.fabricadeprogramador.curso_javaweb2.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Getter @Setter @NoArgsConstructor
@Entity
public class Perfil implements Serializable{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;
}
