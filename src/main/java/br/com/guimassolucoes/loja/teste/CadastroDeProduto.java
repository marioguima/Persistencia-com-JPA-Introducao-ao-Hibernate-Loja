package br.com.guimassolucoes.loja.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.guimassolucoes.loja.dao.CategoriaDao;
import br.com.guimassolucoes.loja.dao.ProdutoDao;
import br.com.guimassolucoes.loja.entity.Categoria;
import br.com.guimassolucoes.loja.entity.Produto;
import br.com.guimassolucoes.loja.util.JPAUtil;

public class CadastroDeProduto {

	public static void main(String[] args) {
		cadastrarProduto();
		buscarProdutoPorId();
	}

	private static void buscarProdutoPorId() {
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);

		Produto produto = produtoDao.buscarPorId(1L);
		System.out.println(produto.getPreco());
	}

	private static void cadastrarProduto() {
		Categoria categoria = new Categoria();
		categoria.setNome("produtoes");

		Produto produto = new Produto();
		produto.setNome("Xiaomi Redmi");
		produto.setDescricao("Muito bom");
		produto.setPreco(new BigDecimal("800"));
		produto.setCategoria(categoria);

		EntityManager em = JPAUtil.getEntityManager();

		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);

		em.getTransaction().begin();

		categoriaDao.cadastrar(categoria);
		produtoDao.cadastrar(produto);

		em.getTransaction().commit();
		em.close();
	}

}
