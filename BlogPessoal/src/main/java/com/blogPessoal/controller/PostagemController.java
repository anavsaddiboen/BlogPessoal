package com.blogPessoal.controller;

import java.util.List;

import com.blogPessoal.model.Postagem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blogPessoal.repository.PostagemRepository;

@RestController
public class PostagemController {

	@Autowired
	private PostagemRepository repository;

	@GetMapping("/postagens")
	public List<Postagem> getAll() {
		return repository.findAll();
	}

	@GetMapping("/postagemById/{id}")
	public Postagem getPostagemById(@PathVariable long id) {
		return repository.findById(id).orElse(null);
	}

	@GetMapping("/postagem/{titulo}")
	public List<Postagem> getByTitulo(@PathVariable String titulo) {
		return repository.findAllByTituloContainingIgnoreCase(titulo);
	}

	@PostMapping("/addPostagem")
	public Postagem savePostagem(@RequestBody Postagem postagem) {
		return repository.save(postagem);
	}

	@PostMapping("/addPostagens")
	public List<Postagem> savePostagens(@RequestBody List<Postagem> postagens) {
		return repository.saveAll(postagens);
	}

	@DeleteMapping("/deletePostagem/{id}")
	public String deletePostagem(@PathVariable long id) {
		repository.deleteById(id);
		return "postagem removida: " + id;
	}

	@PutMapping("updatePostagem")
	public Postagem updatePostagem(@RequestBody Postagem postagem) {
		Postagem postagemExistente = repository.findById(postagem.getId()).orElse(null);
		postagemExistente.setAutor(postagem.getAutor());
		postagemExistente.setCompartilhamentos(postagem.getCompartilhamentos());
		postagemExistente.setConteudo(postagem.getConteudo());
		postagemExistente.setCurtidas(postagem.getCurtidas());
		postagemExistente.setTitulo(postagem.getTitulo());
		return repository.save(postagemExistente);
	}
}
