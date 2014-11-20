package br.com.clovisleoncio.walmart.negocio;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.clovisleoncio.walmart.negocio.entidade.Mapa;
import br.com.clovisleoncio.walmart.negocio.grafo.Caminho;
import br.com.clovisleoncio.walmart.negocio.grafo.Grafo;

@Singleton
@Startup
public class MalhaLogisticaEJB {
	
	@PersistenceContext(name = "entregas")
	EntityManager entityManager;
	
	private Grafo grafo;
	
	@PostConstruct
	public void carregarGrafo() {
		@SuppressWarnings("unchecked")
		List<Mapa> mapas = entityManager.createQuery("from Mapa").getResultList();
		grafo = new Grafo(mapas);
	}
	
	public void gravar(Mapa mapa) {
		Mapa existente = obter(mapa.getNome());
		
		if (existente != null) {
			excluir(existente);
			entityManager.flush();
		}
		
		inserir(mapa);
		
		carregarGrafo();
	}

	public void inserir(Mapa mapa) {
		entityManager.persist(mapa);
	}

	public void excluir(Mapa existente) {
		entityManager.remove(existente);
	}

	public Mapa obter(String nome) {
		return entityManager.find(Mapa.class, nome);
	}

	public Caminho obterMenorCaminho(String origem, String destino) {
		return grafo.getMenorCaminho(origem, destino);
	}
}
