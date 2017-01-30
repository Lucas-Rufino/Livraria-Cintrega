package repositorios;

import dados.Pessoa;

/**
 * Repositório Lista de Pessoa.
 * @author Lucas Alves Rufino e Miriane Silva Trajano do Nascimento.
 */
public class RepositorioPessoaLista implements RepositorioPessoa, IteratorPessoa {

	private ListaPessoa lista;	//lista de pessoas
	private Pessoa[] copia;		//Array de copia para iteracao.
	private int indice;			//contador de valores na lista.
	private int indiceCopia;	//indice auxiliar para iterar a copia.
	
	/**
	 * Metodo contrutor que inicia os atributos do repositorio.
	 */
	public RepositorioPessoaLista() {
		this.lista = new ListaPessoa();
		this.copia = null;
		this.indice = 0;
		this.indiceCopia = 0;
	}
	
	public void inserir(Pessoa pessoa) {
		this.lista.inserir(pessoa);
		this.indice++;
	}
	
	public void remover(String CPF) {
		this.lista.remover(CPF);
		this.indice--;
	}
	
	public Pessoa procurar(String CPF) {
		return this.lista.procurar(CPF);
	}
	
	public void atualizar(Pessoa pessoa) {
		this.lista.atualizar(pessoa);
	}
	
	public Pessoa next() {
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
	
	public IteratorPessoa getIterator() {
		this.indiceCopia = 0;
		this.copia = new Pessoa[this.indice];
		ListaPessoa auxLista = this.lista;
		for(int i=0 ; i<this.indice ; i++){
			this.copia[i] = auxLista.getInfo().clone();
			auxLista = auxLista.getProximo();
		}
		return this;
	}
}
