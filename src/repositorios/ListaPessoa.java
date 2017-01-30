package repositorios;

import dados.Pessoa;

/**
 * Classe de define o funcionamento da lista de pessoas.
 * @author Lucas Alves Rufino e Miriane Silva Trajano do Nascimento.
 */
public class ListaPessoa {

	private Pessoa info;			//Item da lista em quest�o.
	private ListaPessoa proximo;	//Proximo item da lista.
	
	/**
	 * Metodo construtor que inicia os atributos da classe ListaPessoa
	 */
	public ListaPessoa() {
		this.info = null;
		this.proximo = null;
	}
	
	//Metodos Getters///////////////////////////////////////////
	public Pessoa getInfo() {
		return this.info;
	}

	public ListaPessoa getProximo() {
		return this.proximo;
	}
	
	/**
	 * Metodo que insere um novo valor a lista de pessoas
	 * @param pessoa Pessoa - nova pessoa a ser inserida.
	 */
	public void inserir(Pessoa pessoa) {
		if(this.info == null) {					//Insere a pessoa ao encontrar um item da lista null (o primeiro - caso a lista esteja vazia - ou o ultimo - caso n�o esteja -)
			this.info = pessoa;					
			this.proximo = new ListaPessoa();
		} else {								//Enquanto n�o encontrar, chama o metodo inserir do proximo item at� encontrar o ultimo item da lista.
			this.proximo.inserir(pessoa);		
		}
	}

	/**
	 * Metodo que remover um item da lista de pessoas apartir de um identificador.
	 * @param CPF String - cpf da pessoa.
	 */
	public void remover(String CPF) {
		if(this.info.getCPF().equals(CPF)) {		//Quando o item da lista que tem o mesmo CPF informado � encontrado 
			this.info = this.proximo.info;			//a variav�l que apontava para ele, agora aponta para o seu proximo
			this.proximo = this.proximo.proximo;	//e a variav�l que apontava para o seu proximo, agora aponta para o proximo do seu proximo
		} else {
			this.proximo.remover(CPF);				//Enquanto n�o encontrar chama o remover do pr�ximo.
		}
	}

	/**
	 * Metodo que procura uma pessoa na lista apartir de um identificador e a retorna.
	 * @param CPF String - cpf da pessoa.
	 * @return Pessoa - pessoa com o respectivo cpf, ou null caso nao encontrado.
	 */
	public Pessoa procurar(String CPF) {
		Pessoa resposta;
		if(this.proximo == null){						//se o proximo for nulo indica o fim da lista, retorna null.
			resposta = null;
		} else if(this.info.getCPF().equals(CPF)) {		//Retorna o item da lista que tem o mesmo CPF informado
			resposta = this.info;
		} else {										//Enquanto n�o encontrar o item, chama o metodo procurar do proximo item, at� ele ser encontrado
			resposta = this.proximo.procurar(CPF); 
		}
		return resposta;
	}

	/**
	 * Metodo que atualiza um valor presente na lista.
	 * @param pessoa Pessoa - nova pessoa atualizada.
	 */
	public void atualizar(Pessoa pessoa) {
		if (this.info.getCPF().equals(pessoa.getCPF())) {	//Ao encontrar o item da lista que tem o mesmo CPF informado, tal item � atualizado
			this.info = pessoa;
		} else {											//Enquanto n�o o encontrar chama o m�todo atualizar do pr�ximo item da lista.
			this.proximo.atualizar(pessoa);
		}
	}
}
