package repositorios;

import dados.Produto;

/**
 * Classe de define o funcionamento da lista de produtos.
 * @author Lucas Alves Rufino e Miriane Silva Trajano do Nascimento.
 */
public class ListaProduto {
	
	private Produto info;			//Item da lista em questão.
	private ListaProduto proximo;	//Próximo item da lista.
	
	/**
	 * Metodo construtor que inicia os atributos da classe ListaProduto
	 */
	public ListaProduto() {
		this.info = null;
		this.proximo = null;
	}

	//Metodos Getters///////////////////////////////////////
	public Produto getInfo() {
		return this.info;
	}
	
	public ListaProduto getProximo() {
		return this.proximo;
	}

	/**
	 * Metodo que insere um novo valor a lista de produtos
	 * @param produto Produto - novo produto a ser inserido.
	 */
	public void inserir(Produto produto) {
		if(this.info == null) {					//Insere o produto ao encontrar um item da lista null (o primeiro - caso a lista esteja vazia - ou o ultimo - caso não esteja -)
			this.info = produto;							
			this.proximo = new ListaProduto();
		} else {								//Enquanto não encontrar, chama o metodo inserir do proximo item até encontrar o ultimo item da lista.
			this.proximo.inserir(produto);
		}
	}

	/**
	 * Metodo que remover um item da lista de produtos apartir de um identificador.
	 * @param ISBN String - ISBN do produto.
	 */
	public void remover(String ISBN) {
		if(this.info.getISBN().equals(ISBN)) {		//Quando o item da lista que tem o mesmo ISBN informado é encontrado 
			this.info = this.proximo.info;			//a variavél que apontava para ele, agora aponta para o seu proximo
			this.proximo = this.proximo.proximo;	//e a variavél que apontava para o seu proximo, agora aponta para o proximo do seu proximo
		} else {									//Enquanto não encontrar chama o remover do próximo.
			this.proximo.remover(ISBN);
		}
	}

	/**
	 * Metodo que procura um produto na lista apartir de um identificador e o retorna.
	 * @param ISBN String - ISBN do produto.
	 * @return Produto - produto com o respectivo ISBN, ou null caso nao encontrado.
	 */
	public Produto procurar(String ISBN) {
		Produto resposta = null;
		if(this.proximo == null){						//se o proximo for nulo indica o fim da lista, retorna null.
			resposta = null;
		} else if(this.info.getISBN().equals(ISBN)) {	//Retorna o item da lista que tem o mesmo ISBN informado
			resposta = this.info;
		} else {										//Enquanto não encontrar o item, chama o metodo procurar do proximo item, até ele ser encontrado
			resposta = this.proximo.procurar(ISBN); 
		}
		return resposta;
	}

	/**
	 * Metodo que atualiza um valor presente na lista.
	 * @param produto Produto - novo produto atualizado.
	 */
	public void atualizar(Produto produto) {
		if (this.info.getISBN().equals(produto.getISBN())) {	//Ao encontrar o item da lista que tem o mesmo ISBN informado, tal item é atualizado
			this.info = produto;
		} else {												//Enquanto não o encontrar chama o método atualizar do próximo item da lista.
			this.proximo.atualizar(produto);
		}
	}
}
