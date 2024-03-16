package com.blogPessoal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogPessoal.model.Postagem;

public interface IPostagemRepository extends JpaRepository<Postagem, Long> {

}
