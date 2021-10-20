package br.com.guimassolucoes.loja.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.guimassolucoes.loja.entity.Produto;

public class CadastroDeProduto {

	public static void main(String[] args) {
		Produto celular = new Produto();
		celular.setNome("Xiaomi Redmi");
		celular.setDescricao("Muito bom");
		celular.setPreco(new BigDecimal("800"));
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dbH2");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(celular);
		em.getTransaction().commit();
		em.close();
	}

}
