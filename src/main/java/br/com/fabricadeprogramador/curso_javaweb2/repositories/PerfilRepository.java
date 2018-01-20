package br.com.fabricadeprogramador.curso_javaweb2.repositories;

import br.com.fabricadeprogramador.curso_javaweb2.models.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Integer> {
}
