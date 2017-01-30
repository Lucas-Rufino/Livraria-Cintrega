package dados;

import constantes.Idioma;

/**
 * Classe que define o funcionamento do objeto Produto.
 * @author Lucas Alves Rufino e Miriane Silva Trajano do Nascimento.
 */
public abstract class Produto {

	private String titulo;		//Título do produto.
	private String ISBN;		//Código de identificação de acordo com a International Standard Book Number.
	private double preco;		//Valor do produto.
	private String autor;		//Nome do autor do produto.
	private String editora;		//Nome da editora por onde o produto foi lançado.
	private int edicao;			//Edição do produto.
	private int ano;			//Ano de lançamento do produto.
	private Idioma idioma;		//Idioma do produto.
	
	/**
	 * Método construtor que inicia os atributos da classe Produto.
	 * @param titulo String - Título do produto.
	 * @param ISBN String - Código de identificação de acordo com a International Standard Book Number.
	 * @param preco double - Valor do produto.
	 * @param autor String - Nome do autor do produto.
	 * @param editora String - Nome da editora por onde o produto foi lançado.
	 * @param edicao int - Edição do produto.
	 * @param ano int - Ano de lançamento do produto.
	 * @param idioma Idioma - Idioma do produto.
	 */
	public Produto(String titulo, String ISBN, double preco, String autor, String editora, int edicao,
			int ano, Idioma idioma) {
		this.titulo = titulo;
		this.ISBN = ISBN;
		this.preco = preco;
		this.autor = autor;
		this.editora = editora;
		this.edicao = edicao;
		this.ano = ano;
		this.idioma = idioma;
	}

	//Metodos Getters/////////////////////////////////////////////////////////
	public String getTitulo() {
		return this.titulo;
	}

	public String getISBN() {
		return this.ISBN;
	}

	public double getPreco() {
		return this.preco;
	}

	public String getAutor() {
		return this.autor;
	}

	public String getEditora() {
		return this.editora;
	}

	public int getEdicao() {
		return this.edicao;
	}

	public int getAno() {
		return this.ano;
	}

	public Idioma getIdioma() {
		return this.idioma;
	}

	//Metodos Setters///////////////////////////////////////////////////////
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}

	public void setPreco(double preco) {
		this.preco = preco;		
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}
	
	//Metodos Abstratos//////////////////////////////////////////////////
	
	/**
	 * Metodo que retorna a quantidade do produto disponível para venda.
	 * @return int - disponibilidade do produto na loja.
	 */
	public abstract int getDisponibilidade();
	
	/**
	 * Metodo que modifica a quantidade do produto disponível para venda.
	 * @param quant int - quantidade a ser reduzida.
	 */
	public abstract void setDisponibilidade(int quant);
	
	/**
	 * Metodo que retorna um novo objeto com os mesmos valores do atributo da chamada.
	 * @return Produto - novo produto clonado.
	 */
	public abstract Produto clone();
}
