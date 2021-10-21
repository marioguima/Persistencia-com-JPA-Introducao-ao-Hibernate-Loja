package br.com.guimassolucoes.loja.dao;

import javax.persistence.EntityManager;

import br.com.guimassolucoes.loja.entity.Produto;

public class ProdutoDao {

	private EntityManager em;

	public ProdutoDao(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Produto produto) {
		this.em.persist(produto);
	}

	public Produto buscarPorId(Long id) {
		return em.find(Produto.class, id);
	}
}
