package br.com.guimassolucoes.loja.dao;

import javax.persistence.EntityManager;

import br.com.guimassolucoes.loja.entity.Categoria;

public class CategoriaDao {

	private EntityManager em;

	public CategoriaDao(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Categoria categoria) {
		this.em.persist(categoria);
	}
}
