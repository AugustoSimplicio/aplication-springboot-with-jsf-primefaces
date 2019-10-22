package br.com.augusto.dao;

import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import br.com.augusto.model.Fundo;

@SessionScoped
public class FundoRespository implements Repository<Fundo> {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Fundo> listar() {
		TypedQuery<Fundo> query = manager.createQuery("from Fundo", Fundo.class);
		return query.getResultList();
	}

	@Override
	public Fundo buscar(Fundo fundo) {
		return manager.find(Fundo.class, fundo.getId());
	}

	@Transactional
	@Override
	public Fundo salvar(Fundo fundo) {
		return manager.merge(fundo);
	}

	@Transactional
	@Override
	public boolean remover(Fundo fundo) {
		boolean salvo = false;
		try {
			fundo = buscar(fundo);
			manager.remove(fundo);
			salvo = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return salvo;
	}
}
