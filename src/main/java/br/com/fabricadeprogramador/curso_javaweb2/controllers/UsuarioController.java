package br.com.fabricadeprogramador.curso_javaweb2.controllers;

import br.com.fabricadeprogramador.curso_javaweb2.Services.UsuarioService;
import br.com.fabricadeprogramador.curso_javaweb2.controllers.exceptions.UsuarioNaoEncontradoException;
import br.com.fabricadeprogramador.curso_javaweb2.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("http://localhost:3000")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioServ;

	@PostMapping
    public Usuario salvar(@RequestBody Usuario usuario) {
		return this.usuarioServ.inserir(usuario);
	}

	@PutMapping
	public Usuario alterar(@RequestBody Usuario usuario) {
		return this.usuarioServ.inserir(usuario);
	}

	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Integer id) {
		this.usuarioServ.excluir(id);
	}

	@GetMapping
	public List<Usuario> buscarTodos() {
		return this.usuarioServ.todos();
	}

	@GetMapping("/{id}")
	public Usuario buscarPorId(@PathVariable Integer id) {
		return this.usuarioServ.porId(id);
	}

	@GetMapping("/nome")
	public List<Usuario> buscarPorNome(@RequestParam String nome) {
		return this.usuarioServ.porNome(nome);
	}

	@GetMapping("/usuario")
	public List<Usuario> buscarPorNomeSenha(@RequestParam String nome, @RequestParam String senha) {
		return this.usuarioServ.porNomeSenha(nome, senha);
	}

	@GetMapping("/perfil")
	public List<Usuario> buscarPorPerfil(@RequestParam String perfil) {
		return this.usuarioServ.buscarPorPerfil(perfil);
	}

	@PostMapping("/autenticar")
	public List<Usuario> autenticar(@RequestBody Usuario usuario) throws UsuarioNaoEncontradoException {
		List<Usuario> lista = this.usuarioServ.porNomeSenha(usuario.getNome(), usuario.getSenha());
		if (lista == null || lista.size() == 0) {
			throw new UsuarioNaoEncontradoException();
		}
		else {
			return lista;
		}
	}
}

