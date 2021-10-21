package br.com.guimassolucoes.loja.dao;

import java.math.BigDecimal;
import java.util.List;

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

	public List<Produto> buscarProdutos() {
		return em.createQuery("from Produto", Produto.class).getResultList();
	}

	public List<Produto> buscarProdutosPorNome(String nome) {
		return em.createQuery("from Produto p where p.nome = :nome", Produto.class)
				.setParameter("nome", nome)
				.getResultList();
	}
	
	public List<Produto> buscarProdutosPorNomeDaCategoria(String nomeCategoria) {
		return em.createQuery("from Produto p where p.categoria.nome = :nomeCategoria", Produto.class)
				.setParameter("nomeCategoria", nomeCategoria)
				.getResultList();
	}

	public BigDecimal buscarPrecoDoProdutoPorNome(String nome) {
		return em.createQuery("select p.preco from Produto p where p.nome = :nome", BigDecimal.class)
				.setParameter("nome", nome)
				.getSingleResult();
	}
}
