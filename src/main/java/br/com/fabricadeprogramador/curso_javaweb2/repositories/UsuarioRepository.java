package br.com.fabricadeprogramador.curso_javaweb2.repositories;

import br.com.fabricadeprogramador.curso_javaweb2.models.Usuario;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    List<Usuario> findByNomeIgnoreCase(String nome);
    List<Usuario> findByNomeAndSenha(String nome, String senha);

    @Query("SELECT u FROM Usuario u WHERE u.perfil.descricao = :desc")
    List<Usuario> porPerfil(@Param("desc") String descricaoPerfil);
}
