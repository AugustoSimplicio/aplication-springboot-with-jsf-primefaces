package br.com.augusto.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import br.com.augusto.model.Pessoa;

@Component
public class PessoaRepository implements Repository<Pessoa> {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Pessoa> listar() {
		TypedQuery<Pessoa> query = manager.createQuery("from Pessoa", Pessoa.class);
		return query.getResultList();
	}

	@Override
	public Pessoa buscar(Pessoa pessoa) {
		return manager.find(Pessoa.class, pessoa.getId());
	}

	@Transactional
	@Override
	public Pessoa salvar(Pessoa pessoa) {
		return manager.merge(pessoa);
	}

	@Transactional
	@Override
	public boolean remover(Pessoa pessoa) {
		boolean salvo = false;
		try {
			pessoa = buscar(pessoa);
			manager.remove(pessoa);
			salvo = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return salvo;
	}
}
