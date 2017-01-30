package dados;

import constantes.Acabamento;
import constantes.Idioma;

/**
 * Classe que define o funcionamento do objeto Livro.
 * @author Lucas Alves Rufino e Miriane Silva Trajano do Nascimento.
 */
public class Livro extends Produto {
	
	private int qntdEstoque;		//Quantidade deste livro disponivel em estoque.
	private int nPags;				//Número de páginas.
	private Acabamento acabamento;	//Tipo de acabamento do livro.
	private double peso;			//Peso do livro em gramas.
	private double altura;			//Altura do livro em cm.
	private double largura;			//Largura do livro em cm.
	private double comprimento;		//Comprimento do livro em cm.

	/**
	 * Método construtor que inicia os atributos da classe Livro.
	 * @param titulo String - Título do livro.
	 * @param ISBN String - Código de identificação de acordo com a International Standard Book Number.
	 * @param preco double - Valor do livro.
	 * @param autor String - Nome do autor do livro.
	 * @param editora String - Nome da editora por onde o livro foi lançado.
	 * @param edicao int - Edição do livro.
	 * @param ano int - Ano de lançamento do livro.
	 * @param idioma Idioma - Idioma do livro.
	 * @param qntdEstoque int - Quantidade deste livro disponivel em estoque.
	 * @param nPags int - Número de páginas.
	 * @param acabamento Acabamento - Tipo de acabamento do livro.
	 * @param peso double - Peso do livro em gramas.
	 * @param altura double - Altura do livro em cm.
	 * @param largura double - Largura do livro em cm.
	 * @param comprimento double - Comprimento do livro em cm.
	 */
	public Livro(String titulo, String ISBN, double preco, String autor, String editora, int edicao, int ano,
			Idioma idioma, int qntdEstoque, int nPags, Acabamento acabamento, double peso, double altura,
			double largura, double comprimento) {
		super(titulo, ISBN, preco, autor, editora, edicao, ano, idioma);
		this.qntdEstoque = qntdEstoque;
		this.nPags = nPags;
		this.acabamento = acabamento;
		this.peso = peso;
		this.altura = altura;
		this.largura = largura;
		this.comprimento = comprimento;
	}

	//Metodos Getters//////////////////////////////////////////////////////
	public int getQntdEstoque() {
		return this.qntdEstoque;
	}

	public int getNPags() {
		return this.nPags;
	}

	public Acabamento getAcabamento() {
		return this.acabamento;
	}

	public double getPeso() {
		return this.peso;
	}

	public double getAltura() {
		return this.altura;
	}

	public double getLargura() {
		return this.largura;
	}

	public double getComprimento() {
		return this.comprimento;
	}

	//Metodos Setters/////////////////////////////////////////////////////////
	public void setQntdEstoque(int qntdEstoque) {
		this.qntdEstoque = qntdEstoque;
	}

	public void setNPags(int nPags) {
		this.nPags = nPags;
	}
	
	public void setAcabamento(Acabamento acabamento) {
		this.acabamento = acabamento;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public void setLargura(double largura) {
		this.largura = largura;
	}

	public void setComprimento(double comprimento) {
		this.comprimento = comprimento;
	}
	
	public int getDisponibilidade(){
		return this.qntdEstoque;
	}
	
	public void setDisponibilidade(int quant){
		this.qntdEstoque -= quant;
	}
	
	public Produto clone(){
		return new Livro(this.getTitulo(), this.getISBN(), this.getPreco(), this.getAutor(), this.getEditora(),
				this.getEdicao(), this.getAno(), this.getIdioma(), this.qntdEstoque, this.nPags, this.acabamento,
				this.peso, this.altura, this.largura, this.comprimento);
	}
}
