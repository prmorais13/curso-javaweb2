package br.com.fabricadeprogramador.curso_javaweb2.controllers;

import br.com.fabricadeprogramador.curso_javaweb2.Services.PerfilService;
import br.com.fabricadeprogramador.curso_javaweb2.models.Perfil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perfis")
@CrossOrigin("*")
public class PerfilController {

    @Autowired
    private PerfilService perfilServ;

    @PostMapping
    public Perfil salvar(@RequestBody Perfil perfil) {
        return this.perfilServ.inserir(perfil);
    }

    @GetMapping
    public List<Perfil> buscarTodos() {
        return this.perfilServ.todos();
    }
}
