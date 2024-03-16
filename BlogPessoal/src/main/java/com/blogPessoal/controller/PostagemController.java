package com.blogPessoal.controller;

import java.util.List;

import com.blogPessoal.model.Postagem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogPessoal.repository.IPostagemRepository;

@RestController
public class PostagemController {

	@Autowired
	private IPostagemRepository repository;

	@GetMapping("/postagens")
	public List<Postagem> getAll() {
		return repository.findAll();
	}

}
