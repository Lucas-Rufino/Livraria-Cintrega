package repositorios;

import dados.Servico;
	
/**
 * Repositório Lista de Serviço.
 * @author Lucas Alves Rufino e Mirane Silva Trajano do Nascimento.
 */
public class RepositorioServicoLista implements RepositorioServico, IteratorServico{

	private ListaServico lista;	//lista de servicos
	private Servico[] copia;	//Array de copia para iteracao.
	private int indice;			//contador de valores na lista.
	private int indiceCopia;	//indice auxiliar para iterar a copia.
	
	/**
	 * Metodo contrutor que inicia os atributos do repositorio.
	 */
	public RepositorioServicoLista() {
		this.lista = new ListaServico();
		this.copia = null;
		this.indice = 0;
		this.indiceCopia = 0;
	}
	
	public void inserir(Servico servico) {
		this.lista.inserir(servico);
		this.indice++;
	}
	
	public void remover(String codigo) {
		this.lista.remover(codigo);
		this.indice--;
	}

	public Servico procurar(String codigo) {
		return this.lista.procurar(codigo);
	}
	
	public void atualizar(Servico servico) {
		this.lista.atualizar(servico);
	}
	
	public Servico next() {
		return this.copia[this.indiceCopia++];
	}

	public boolean hasNext() {
		boolean resposta;
		if(this.indiceCopia >= this.copia.length || this.copia[this.indiceCopia] == null) {
			resposta = false;
		} else {
			resposta = true;
		}
		return resposta;
	}
		
	public IteratorServico getIterator() {
		this.indiceCopia = 0;
		this.copia = new Servico[this.indice];
		ListaServico auxLista = this.lista;
		for(int i=0 ; i<this.indice ; i++){
			this.copia[i] = auxLista.getInfo().clone();
			auxLista = auxLista.getProximo();
		}
		return this;
	}
}
