package com.blogPessoal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blogPessoal.model.Tema;
import com.blogPessoal.repository.TemaRepository;

@RestController
public class TemaController {

	@Autowired
	private TemaRepository repository;

	@GetMapping("/temas")
	public List<Tema> getAll() {
		return repository.findAll();
	}

	@GetMapping("/temaById/{id}")
	public Tema getTemaById(@PathVariable long id) {
		return repository.findById(id).orElse(null);
	}

	@GetMapping("/tema/{descricao}")
	public List<Tema> getByTitulo(@PathVariable String descricao) {
		return repository.findAllByDescricaoContainingIgnoreCase(descricao);
	}

	@PostMapping("/addTema")
	public Tema savePostagem(@RequestBody Tema tema) {
		return repository.save(tema);
	}

	@PostMapping("/addTemas")
	public List<Tema> savePostagens(@RequestBody List<Tema> temas) {
		return repository.saveAll(temas);
	}

	@DeleteMapping("/deleteTema/{id}")
	public String deleteTema(@PathVariable long id) {
		repository.deleteById(id);
		return "tema removido: " + id;
	}

	@PutMapping("updateTema")
	public Tema updateTema(@RequestBody Tema tema) {
		Tema temaExistente = repository.findById(tema.getId()).orElse(null);
		temaExistente.setDescricao(tema.getDescricao());
		temaExistente.setPostagem(tema.getPostagens());
		return repository.save(temaExistente);
	}

}
