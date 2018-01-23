package br.com.fabricadeprogramador.curso_javaweb2.Services;

import br.com.fabricadeprogramador.curso_javaweb2.models.Perfil;
import br.com.fabricadeprogramador.curso_javaweb2.models.Usuario;
import br.com.fabricadeprogramador.curso_javaweb2.repositories.PerfilRepository;
import br.com.fabricadeprogramador.curso_javaweb2.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Autowired
    private PerfilRepository perfilRepo;


    public Usuario inserir(Usuario usuario) {
        if (usuario.getPerfil() == null) {
            Perfil perfil = this.perfilRepo.findOne(2);
            usuario.setPerfil(perfil);
        }
        return this.usuarioRepo.save(usuario);
    }

    public void excluir(Integer id) {
        Usuario usuario = this.porId(id);
        if (usuario != null) {
            this.usuarioRepo.delete(id);
        }

    }

    public List<Usuario> todos() {
        return this.usuarioRepo.findAll();
    }

    public Usuario porId(Integer id) {
        return this.usuarioRepo.findOne(id);
    }

    public List<Usuario> porNome(String nome) {
        return this.usuarioRepo.findByNomeIgnoreCase(nome);
    }

    public List<Usuario> porNomeSenha(String nome, String senha) {
        return this.usuarioRepo.findByNomeAndSenha(nome, senha);
    }

    public List<Usuario> buscarPorPerfil(String perfil) {
       return this.usuarioRepo.porPerfil(perfil);
    }
}