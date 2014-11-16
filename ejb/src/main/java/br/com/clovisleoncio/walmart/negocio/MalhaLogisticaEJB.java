package br.com.clovisleoncio.walmart.negocio;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.clovisleoncio.walmart.negocio.entidade.MalhaLogistica;

@Stateless
public class MalhaLogisticaEJB {
	
	@PersistenceContext(name = "entregas")
	EntityManager entityManager;
	
	public void gravar(MalhaLogistica malha) {
		
		MalhaLogistica existente = entityManager.find(MalhaLogistica.class, malha.getNome());
		
		if (existente != null) {
			excluir(existente);
			entityManager.flush();
		}
		
		inserir(malha);
		
	}

	public void inserir(MalhaLogistica malha) {
		entityManager.persist(malha);
	}

	public void excluir(MalhaLogistica existente) {
		entityManager.remove(existente);
	}
	
}
