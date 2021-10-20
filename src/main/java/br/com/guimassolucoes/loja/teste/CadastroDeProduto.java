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
		EntityManager em = JPAUtil.getEntityManager();

		Categoria categoria = new Categoria();
		categoria.setNome("produtoes");

		CategoriaDao categoriaDao = new CategoriaDao(em);

		Produto produto = new Produto();
		produto.setNome("Xiaomi Redmi");
		produto.setDescricao("Muito bom");
		produto.setPreco(new BigDecimal("800"));
		produto.setCategoria(categoria);

		ProdutoDao produtoDao = new ProdutoDao(em);

		em.getTransaction().begin();

		categoriaDao.cadastrar(categoria);
		produtoDao.cadastrar(produto);

		em.getTransaction().commit();
		em.close();
	}

}
