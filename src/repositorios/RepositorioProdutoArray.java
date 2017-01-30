package repositorios;

	import dados.Produto;

/**
 * Repositorio Array de Produto.
 * @author Lucas Alves Rufino e Miriane Silva Trajano do Nascimento.
 */
public class RepositorioProdutoArray implements RepositorioProduto, IteratorProduto {

	private Produto[] produtos;	//Array de produtos.
	private Produto[] copia;	//Copia do array de produtos.
	private int indice;			//Indice que armazena a primeira posição livre no array.
	private int indiceCopia; 	//Indice do array copia.
	
	/**
	 * Metodo contrutor que inicia os atributos do repositorio.
	 */
	public RepositorioProdutoArray() {
		this.produtos = new Produto[100];
		this.copia = null;
		this.indice = 0;
		this.indiceCopia = 0;
	}
	
	public void inserir(Produto produto) {
		if(this.indice == this.produtos.length) {			//Verifica se o array está cheio,
			Produto[] temp = this.produtos;					//se estiver cria um novo array que recebe o array original
			this.produtos = new Produto[this.indice + 100];	//e o original agora aponta para um array de tamanho maior,
			for (int i = 0; i < this.indice; i++) {			//retorna todos os elementos do array original para esse maior
				this.produtos[i] = temp[i];
			}
		}
		this.produtos[this.indice++] = produto;
	}
	
	public void remover(String ISBN) {
		boolean achou = false;
		for(int i = 0; i < this.indice && !achou; i++) {				//Percorre o array a procura de um produto com o ISBN informado pelo usuário.
			if(this.produtos[i].getISBN().equals(ISBN)) {				//Quando encontra o produto com o mesmo ISBN
				this.produtos[i] = this.produtos[--this.indice];		//decrementa o índice e transfere o ultimo produto cadastrado para a posição do produto a ser removido
				this.produtos[this.indice] = null;						
				achou = true;
			}
		}
	}
	
	public Produto procurar(String ISBN) {
		Produto resposta = null;
		boolean achou = false;
		for(int i = 0; i < this.indice && !achou; i++) {
			if(this.produtos[i].getISBN().equals(ISBN)) {
				resposta = this.produtos[i];
				achou = true;
			}
		}
		return resposta;
	}
	
	public void atualizar(Produto produto) {
		boolean achou = false;
		for(int i = 0; i < this.indice && !achou; i++) {
			if(this.produtos[i].getISBN().equals(produto.getISBN())) {
				this.produtos[i] = produto;
				achou = true;
			}
		}
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
		for(int i = 0; i < this.indice; i++) {
			this.copia[i] = this.produtos[i].clone();
		}
		return this;
	}
}
