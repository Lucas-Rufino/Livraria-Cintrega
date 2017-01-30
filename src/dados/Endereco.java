package dados;

import constantes.Estado;

/**
 * Classe que define o objeto Endereco.
 * Caracterizado por logradouro, numero, complemento, CEP, bairro, cidade, estado e pais.
 * @author Lucas Alves Rufino e Miriane Silva Trajano do Nascimento.
 */
public class Endereco {

	private String logradouro;		//Logradouro do endereco (Avenida, Rua...).
	private int numero;				//numero do endereco.
	private String complemento;		//complemento do endereco (apartamento, edificio...)
	private String CEP;				//codigo de enderecamento postal do endereco.
	private String bairro;			//bairro do endereco.
	private String cidade;			//cidade do endereco.
	private Estado estado;			//estado do endereco.
	private String pais;			//pais do endereco.
	
	/**
	 * Metodo construtor que inicia os atributos do endereco.
	 * @param logradouro String - Logradouro do endereco (Avenida, Rua...).
	 * @param numero int - numero do endereco.
	 * @param complemento String - complemento do endereco (apartamento, edificio...)
	 * @param CEP String - codigo de enderecamento postal do endereco.
	 * @param bairro String - bairro do endereco.
	 * @param cidade String - cidade do endereco.
	 * @param estado Estado - estado do endereco.
	 * @param pais String - pais do endereco.
	 */
	public Endereco(String logradouro, int numero, String complemento, String CEP, String bairro, String cidade,
			Estado estado, String pais) {
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.CEP = CEP;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
	}

	//Metodos Getters/////////////////////////////////////////////////////////////////////
	public String getLogradouro() {
		return this.logradouro;
	}

	public int getNumero() {
		return this.numero;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public String getCEP(){
		return this.CEP;
	}

	public String getBairro() {
		return this.bairro;
	}

	public String getCidade() {
		return this.cidade;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public String getPais() {
		return this.pais;
	}

	//Metodos Setters/////////////////////////////////////////////////////////////////////
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public void setCEP(String CEP) {
		this.CEP = CEP;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	
	/**
	 * retorna uma string formatada com os dados do endereco.
	 * @return String - texto com os dados do endereco formatado.
	 */
	public String toString(){
		String str = "\tLogradouro: " + this.logradouro +
					 "\n\tNúmero: " + this.numero +
					 "\n\tCEP: " + this.CEP.substring(0, 5) + "-" + this.CEP.substring(5, 8) +
					 "\n\tBairro: " + this.bairro +
					 "\n\tCidade: " + this.cidade +
					 "\n\tEstado/Provincia: " + this.estado.getNome() +
					 "\n\tPais: " + this.pais;
		return str;
	}
	
	/**
	 * Metodo que retorna um novo objeto com os mesmos valores do atributo da chamada.
	 * @return endereco Endereco - novo endereco clonado.
	 */
	public Endereco clone(){
		return new Endereco(this.logradouro, this.numero, this.complemento, this.CEP, this.bairro, this.cidade,
				this.estado, this.pais);
	}
}
