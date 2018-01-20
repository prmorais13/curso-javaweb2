package br.com.fabricadeprogramador.curso_javaweb2.Services;

import br.com.fabricadeprogramador.curso_javaweb2.models.Perfil;
import br.com.fabricadeprogramador.curso_javaweb2.repositories.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository perfilRepo;

    public Perfil inserir(Perfil perfil) {
        return this.perfilRepo.save(perfil);
    }

    public List<Perfil> todos() {
        return this.perfilRepo.findAll();
    }
}
