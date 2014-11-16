package br.com.clovisleoncio.walmart.negocio;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.clovisleoncio.walmart.negocio.entidade.MalhaLogistica;
import br.com.clovisleoncio.walmart.negocio.entidade.Ponto;

@Stateless
public class MalhaLogisticaEJB {
	
	@PersistenceContext(name = "entregas")
	EntityManager entityManager;
	
	public void gravar(MalhaLogistica malha) {
		
		MalhaLogistica existente = obter(malha.getNome());
		
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

	public MalhaLogistica obter(String nome) {
		return entityManager.find(MalhaLogistica.class, nome);
	}

	// TODO	usar fetch ao carregar
	public MalhaLogistica carregar(String nome) {
		MalhaLogistica malha = obter(nome);
		for (Ponto ponto : malha.getPontos()) {
			ponto.getTrechos().size();
		}
		return malha;
	}
	
}
