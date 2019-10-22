package br.com.augusto.managedbean;

import java.util.ArrayList;
import java.util.List;

import br.com.augusto.dao.Repository;
import br.com.augusto.filtro.Filtro;
import br.com.augusto.view.enums.Modo;

public abstract class AbstractMB<T> {
	private MessagesView messagesView = new MessagesView();
	private Modo modo = null;
	private T model;
	private List<T> resultados = new ArrayList<T>();
	private Repository<T> service = novoService();

	protected abstract T novoModel(); // primeiro padrao de projeto implementado .. template method

	protected abstract Repository<T> novoService(); // template method

	public abstract List<Filtro<T>> obterFiltros();
	
	public boolean isExibeResultadoConsulta() {
		return !resultados.isEmpty();
	}
	
	public List<T> getResultados() {
		return resultados;
	}

	public void setResultados(List<T> resultados) {
		this.resultados = resultados;
	}

	protected MessagesView getMessagesView() {
		return messagesView;
	}

	public T getModel() {
		return model;
	}

	public void setModel(T model) {
		this.model = model;
	}

	protected void setMessagesView(MessagesView messagesView) {
		this.messagesView = messagesView;
	}

	protected Modo getModo() {
		return modo;
	}

	protected void setModo(Modo modo) {
		this.modo = modo;
	}

	public void botao() {
		if (Modo.ALTERACAO.equals(getModo())) {
			editar();
		} else if (Modo.INCLUSAO.equals(getModo())) {
			salvar();
		}
		setModo(Modo.CONSULTA);
	}

	public boolean isMostrarPanelCadastroEdicao() {
		return Modo.ALTERACAO.equals(getModo()) || Modo.INCLUSAO.equals(getModo());
	}

	public void novo() {
		setModo(Modo.INCLUSAO);
		model = novoModel();
	}

	public void editar() {
		service.salvar(model);
		model = novoModel();
	}

	public void cancelar() {
		setModo(Modo.CONSULTA);
		model = novoModel();
	}

	public void salvar() {
		service.salvar(model);
		buscar();
		model = novoModel();
	}

	public void deletar(T t) {
		if (service.remover(t)) {
			getMessagesView().sucessoDeletar();
		} else {
			getMessagesView().erroDeletar();
		}
		buscar();
	}

	public void buscar() {
		resultados = metodoFiltro(service.listar(), obterFiltros());
	}

	public void chamarEdicao(T modelEditado) {
		setModo(Modo.ALTERACAO);
		model = modelEditado;
	}

	protected boolean filtrar(List<Filtro<T>> filtros, T t) {
		boolean booleanFilter = true;
		for (Filtro<T> filtro : filtros) {
			booleanFilter = booleanFilter && filtro.filtrar(t);
		}
		return booleanFilter;
	}

	protected List<T> metodoFiltro(List<T> list, List<Filtro<T>> filtros) {
		List<T> listaFiltrada = new ArrayList<T>();
		for (T t : list) {
			if (filtrar(filtros, t)) {
				listaFiltrada.add(t);
			}
		}
		return listaFiltrada;
	}
}
