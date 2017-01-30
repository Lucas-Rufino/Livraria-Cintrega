package repositorios;

import dados.Produto;

/**
 * Repositório Lista de Produto.
 * @author Lucas Alves Rufino e Miriane Silva Trajano do Nascimento.
 */
public class RepositorioProdutoLista implements RepositorioProduto, IteratorProduto {

	private ListaProduto lista;	//lista de produtos
	private Produto[] copia;	//Array de copia para iteracao.
	private int indice;			//contador de valores na lista.
	private int indiceCopia;	//indice auxiliar para iterar a copia.
	
	/**
	 * Metodo contrutor que inicia os atributos do repositorio.
	 */
	public RepositorioProdutoLista() {
		this.lista = new ListaProduto();
		this.copia = null;
		this.indice = 0;
		this.indiceCopia = 0;
	}

	public void inserir(Produto produto) {
		this.lista.inserir(produto);
		this.indice++;
	}

	public void remover(String ISBN) {
		this.lista.remover(ISBN);
		this.indice--;
	}

	public Produto procurar(String ISBN) {
		return this.lista.procurar(ISBN);
	}

	public void atualizar(Produto produto) {
		this.lista.atualizar(produto);
	}

	public Produto next() {
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
	
	public IteratorProduto getIterator() {
		this.indiceCopia = 0;
		this.copia = new Produto[this.indice];
		ListaProduto auxLista = this.lista;
		for(int i=0 ; i<this.indice ; i++){
			this.copia[i] = auxLista.getInfo().clone();
			auxLista = auxLista.getProximo();
		}
		return this;
	}	
}
