package br.com.guimassolucoes.loja.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.guimassolucoes.loja.dao.ProdutoDao;
import br.com.guimassolucoes.loja.entity.Categoria;
import br.com.guimassolucoes.loja.entity.Produto;
import br.com.guimassolucoes.loja.util.JPAUtil;

public class CadastroDeProduto {

	public static void main(String[] args) {
		Produto celular = new Produto();
		celular.setNome("Xiaomi Redmi");
		celular.setDescricao("Muito bom");
		celular.setPreco(new BigDecimal("800"));
		celular.setCategoria(Categoria.CELULARES);

		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);

		em.getTransaction().begin();
		produtoDao.cadastrar(celular);
		em.getTransaction().commit();
		em.close();
	}

}
