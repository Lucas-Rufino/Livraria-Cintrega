package repositorios;

import dados.Pessoa;

/**
 * Repositorio Array de Produto.
 * @author Lucas Alves Rufino e Miriane Silva Trajano do Nascimento.
 */
public class RepositorioPessoaArray implements RepositorioPessoa, IteratorPessoa {

	private Pessoa[] pessoas;	//Array de Pessoa.
	private Pessoa[] copia;		//Copia do array de Pessoa.
	private int indice;			//Indice que armazena a primeira posição livre no array.
	private int indiceCopia; 	//Indice do array copia.
	
	/**
	 * Metodo contrutor que inicia os atributos do repositorio.
	 */
	public RepositorioPessoaArray() {
		this.pessoas = new Pessoa[100];
		this.copia = null;
		this.indice = 0;
		this.indiceCopia = 0;
	}
	
	public void inserir(Pessoa pessoa) {
		if(this.indice == this.pessoas.length) {			//Verifica se o array está cheio,
			Pessoa[] temp = this.pessoas;					//se estiver cria um novo array que recebe o array original
			this.pessoas = new Pessoa[this.indice + 100];	//e o original agora aponta para um array de tamanho maior,
			for(int i = 0; i < this.indice; i++) {			//retorna todos os elementos do array original para esse maior
				this.pessoas[i] = temp[i];
			}
		}
		this.pessoas[this.indice++] = pessoa;
	}
	
	public void remover(String CPF) {
		boolean achou = false;
		for(int i = 0; i < this.indice && !achou; i++) {			//Percorre o array a procura de uma pessoa com o CPF informado pelo usuário.
			if(this.pessoas[i].getCPF().equals(CPF)) {				//Quando encontra a pessoa com o mesmo CPF
				this.pessoas[i] = this.pessoas[--this.indice];		//decrementa o indice e transfere a ultima pessoa cadastrada para a posição da pessoa a ser removida
				this.pessoas[this.indice] = null;					//A posição da ultima pessoa cadastrada aponta para null
				achou = true;
			}
		}
	}
	
	public Pessoa procurar(String CPF) {
		Pessoa resposta = null;
		boolean achou = false;
		for(int i = 0; i < this.indice && !achou; i++) {
			if(this.pessoas[i].getCPF().equals(CPF)) {
				resposta = this.pessoas[i];
				achou = true;
			}
		}
		return resposta;//.clone();
	}
	
	public void atualizar(Pessoa pessoa) {
		boolean achou = false;
		for(int i = 0; i < this.indice && !achou ; i++) {
			if(this.pessoas[i].getCPF().equals(pessoa.getCPF())) {
				this.pessoas[i] = pessoa;
				achou = true;
			}
		}
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
		for(int i = 0; i < this.indice; i++) {
			this.copia[i] = this.pessoas[i].clone();
		}
		return this;
	}
}
