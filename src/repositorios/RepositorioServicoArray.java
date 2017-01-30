package repositorios;

	import dados.Servico;
	
/**
 * Reposit�rio Array de Servi�o.
 * @author Lucas Alves Rufino e Miriane Silva Trajano do Nascimento.
 */
public class RepositorioServicoArray implements RepositorioServico, IteratorServico{

	private Servico[] servicos;	//Array de servico.
	private Servico[] copia;	//Copia do array de sevico.
	private int indice;			//Inteiro que marca a primeira posi��o disponivel no array.
	private int indiceCopia;	//Indice do array copia.
	
	/**
	 * Metodo contrutor que inicia os atributos do repositorio.
	 */
	public RepositorioServicoArray() {
		this.servicos = new Servico[100];
		this.copia = null;
		this.indice = 0;
		this.indiceCopia = 0;
	}
	
	public void inserir(Servico servico) {
		if(this.indice == this.servicos.length) {			//Verifica se o array est� cheio,
			Servico[] temp = this.servicos;					//se estiver cria um novo array que recebe o array original
			this.servicos = new Servico[this.indice + 100];	//e o original agora aponta para um array de tamanho maior,
			for(int i = 0; i < this.indice; i++) {			//retorna todos os elementos do array original para esse maior
				this.servicos[i] = temp[i];
			}
		}
		this.servicos[this.indice++] = servico;
	}
	
	public void remover(String codigo) {
		boolean achou = false;
		for(int i = 0; i < this.indice && !achou; i++) {			//Procura no array um servi�o com o c�digo informado
			if(this.servicos[i].getCodigo().equals(codigo)) {		//Quando encontra o servico com o mesmo codigo 
				this.servicos[i] = this.servicos[--this.indice];	//decrementa o �ndice e transfere o ultimo produto cadastrado para a posi��o do produto a ser removido
				this.servicos[this.indice] = null;					
				achou = false;
			}
		}
	}
	
	public Servico procurar(String codigo) {
		Servico resposta = null;
		boolean achou = false;
		for(int i = 0; i < this.indice && !achou; i++) {
			if(this.servicos[i].getCodigo().equals(codigo)) {
				resposta = this.servicos[i];
				achou = true;
			}
		}
		return resposta;
	}
	
	public void atualizar(Servico servico) {
		boolean achou = false;
		for(int i = 0; i < this.indice && !achou; i++) {
			if(this.servicos[i].getCodigo().equals(servico.getCodigo())) {
				this.servicos[i] = servico;
				achou = true;
			}
		}
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
		for(int i = 0; i < this.indice; i++) {
			this.copia[i] = this.servicos[i].clone();
		}
		return this;
	}
}
