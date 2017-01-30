package repositorios;

import dados.Servico;

/**
 * Classe de define o funcionamento da lista de sevicos.
 * @author Lucas Alves Rufino e Miriane Silva Trajano do Nascimento.
 */
public class ListaServico {

	private Servico info;			//Item da lista em quest�o.
	private ListaServico proximo;	//Pr�ximo item da lista.
	
	/**
	 * Metodo construtor que inicia os atributos da classe ListaServico.
	 */
	public ListaServico() {
		this.info = null;
		this.proximo = null;
	}
	
	//Metodos Getters//////////////////////////////////////
	public Servico getInfo() {
		return this.info;
	}

	public ListaServico getProximo() {
		return this.proximo;
	}

	/**
	 * Metodo que insere um novo valor a lista de servicos
	 * @param servico Servicos - novo servico a ser inserido.
	 */
	public void inserir(Servico servico) {
		if(this.info == null) {					//Insere o produto ao encontrar um item da lista null (o primeiro - caso a lista esteja vazia - ou o ultimo - caso n�o esteja -)
			this.info = servico;
			this.proximo = new ListaServico();
		} else {								//Enquanto n�o encontrar, chama o metodo inserir do proximo item at� encontrar o ultimo item da lista.
			this.proximo.inserir(servico);
		}
	}
	
	/**
	 * Metodo que remover um item da lista de servicos apartir de um identificador.
	 * @param codigo String - codigo do servico.
	 */
	public void remover(String codigo) {
		if(this.info.getCodigo().equals(codigo)) {	//Quando o item da lista que tem o mesmo c�digo informado � encontrado
			this.info = this.proximo.info;			//a variav�l que apontava para ele, agora aponta para o seu proximo
			this.proximo = this.proximo.proximo;	//e a variav�l que apontava para o seu proximo, agora aponta para o proximo do seu proximo
		} else {									//Enquanto n�o encontrar chama o remover do pr�ximo.
			this.proximo.remover(codigo);
		}
	}
	
	/**
	 * Metodo que procura um servico na lista apartir de um identificador e o retorna.
	 * @param codigo String - codigo do servico.
	 * @return Servico - servico com o respectivo c�digo, ou null caso nao encontrado.
	 */
	public Servico procurar(String codigo) {
		Servico resposta = null;
		if(this.proximo == null){							//se o proximo for nulo indica o fim da lista, retorna null.
			resposta = null;
		} else if(this.info.getCodigo().equals(codigo)) {	//Retorna o item da lista que tem o mesmo c�digo informado
			resposta = this.info;
		} else {											//Enquanto n�o encontrar o item, chama o metodo procurar do proximo item, at� ele ser encontrado
			resposta = this.proximo.procurar(codigo);
		}
		return resposta;
	}
	
	/**
	 * Metodo que atualiza um valor presente na lista.
	 * @param servico Servico - novo servico atualizado.
	 */
	public void atualizar(Servico servico) {
		if (this.info.getCodigo().equals(servico.getCodigo())) {	//Ao encontrar o item da lista que tem o mesmo c�digo informado, tal item � atualizado
			this.info = servico;
		} else {													//Enquanto n�o o encontrar chama o m�todo atualizar do pr�ximo item da lista.
			this.proximo.atualizar(servico);
		}
	}
}
