package com.blogPessoal.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_TEMA")
public class Tema {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long temaId;
	private String descricao;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_tema_id", referencedColumnName = "temaId")
	@JsonIgnoreProperties("tema")
	private List<Postagem> postagens;

	public long getId() {
		return temaId;
	}

	public void setId(Long id) {
		this.temaId = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Postagem> getPostagens() {
		return postagens;
	}

	public void setPostagem(List<Postagem> postagens) {
		this.postagens = postagens;
	}

}
