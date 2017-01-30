package dados;

import constantes.Formato;
import constantes.Idioma;

/**
 * Classe que define o funcionamento do objeto Ebook.
 * @author Lucas Alves Rufino e Miriane Silva Trajano do Nascimento.
 */
public class Ebook extends Produto {

	private int qntdLicenca;	//Quantidade de licenças do ebook, cada venda equivale a perda de 3 licensas.
	private double tamanho;		//Tamanho do ebook em KBytes.
	private Formato formato;	//Formato da extensão do ebook.
	
	/**
	 * Método construtor que inicia os atributos da classe Ebook.
	 * @param titulo String - Título do ebook.
	 * @param ISBN String - Código de identificação de acordo com a International Standard Book Number.
	 * @param preco double - Valor do ebook.
	 * @param autor String - Nome do autor do ebook.
	 * @param editora String - Nome da editora por onde o ebook foi lançado.
	 * @param edicao int - Edição do ebook.
	 * @param ano int - Ano de lançamento do ebook.
	 * @param idioma Idioma - Idioma do ebook.
	 * @param qntdLicenca int - Quantidade de licenças para venda..
	 * @param tamanho double - Tamanho do ebook em KBytes.
	 * @param formato - Formato da extensão do ebook.
	 */
	
	public Ebook(String titulo, String ISBN, double preco, String autor, String editora, int edicao, int ano,
			Idioma idioma, int qntdLicenca, double tamanho, Formato formato) {
		super(titulo, ISBN, preco, autor, editora, edicao, ano, idioma);
		this.qntdLicenca = qntdLicenca;
		this.tamanho = tamanho;
		this.formato = formato;
	}

	//Metodos Getters////////////////////////////////////////////////
	public int getQntdLicenca() {
		return this.qntdLicenca;
	}

	public double getTamanho() {
		return this.tamanho;
	}

	public Formato getFormato() {
		return this.formato;
	}

	//Metodos Setters////////////////////////////////////////////////
	public void setQntdLicenca(int qntdLicenca) {
		this.qntdLicenca = qntdLicenca;
	}

	public void setTamanho(double tamanho) {
		this.tamanho = tamanho;
	}

	public void setFormato(Formato formato) {
		this.formato = formato;
	}
	
	public int getDisponibilidade(){
		return this.qntdLicenca/3;
	}
	
	public void setDisponibilidade(int quant){
		this.qntdLicenca -= 3*quant;
	}
	
	public Produto clone(){
		return new Ebook(this.getTitulo(), this.getISBN(), this.getPreco(), this.getAutor(), this.getEditora(),
				this.getEdicao(), this.getAno(), this.getIdioma(), this.qntdLicenca, this.tamanho, this.formato);
	}
}
