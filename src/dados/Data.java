package dados;

/**
 * Classe que define o objeto Data.
 * Caracterizado por dia, mes e ano.
 * @author Lucas Alves Rufino e Miriane Silva Trajano do Nascimento.
 */
public class Data {
	
	private int dia;	//dia da data.
	private int mes;	//mes da data.
	private int ano;	//ano da data.
	
	/**
	 * Metodo construtor resposavel por atribuir os valores inicias do objeto Data.
	 * @param dia int - dia da data.
	 * @param mes int - mes da data.
	 * @param ano int - ano da data.
	 */
	public Data(int dia, int mes, int ano) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}

	//Metodos Getters///////////////////////////////////////
	public int getDia() {
		return this.dia;
	}

	public int getMes() {
		return this.mes;
	}

	public int getAno() {
		return this.ano;
	}

	//Metodos Setters///////////////////////////////////////
	public void setDia(int dia) {
		this.dia = dia;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	/**
	 * Metodo que testa as diferentes limitacoes para entrada de data, se caso haja
	 * uma incoerencia, o valor do retorno eh verdade, sendo necessario um a obtencao
	 * de novos valores, se falso, o valor estao corretos para uma descrisao de data.
	 * @return boolean - se verdade, data invalida, se falso, data valida
	 */
	public boolean testar(){
		int[] limMes = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};	//valores limites de data para os meses
		boolean erro = false;												//marcado de data invalida
		
		if(this.mes < 1 || this.mes > 12){								//teste para os meses validos
			erro = true;
		} else if(this.dia < 1 || this.dia > limMes[this.mes-1]){		//teste para o dia nos limites do mes.
			erro = true;
		} else if(this.ano < 1){										//teste de anos.
			erro = true;
		} else if(!((this.ano%4 == 0 && this.ano%100 != 0) || this.ano%400 == 0)){	//teste de anos bissextos
			if(this.dia == 29 && this.mes == 2){						//se o ano nao for bissexto o dia 
				erro = true;											//29 de fev nao existe para esse ano.
			}
		}
		return erro;
	}
	
	/**
	 * retorna uma string formatada com os dados de data.
	 * @return String - data formatada (DD/MM/AAAA).
	 */
	public String toString(){
		String str = "";
		
		if(this.dia < 10){
			str = str + "0" + this.dia;
		} else {
			str = str + this.dia;
		}
		
		if(this.mes < 10){
			str = str + "/0" + this.mes;
		} else {
			str = str + "/" + this.mes;
		}
		
		if(this.ano < 10){
			str = str + "/000" + this.ano;
		} else if(this.ano < 100){
			str = str + "/00" + this.ano;
		} else if(this.ano < 1000){
			str = str + "/0" + this.ano;
		} else {
			str = str + "/" + this.ano;
		}
		
		return str;
	}
	
	/**
	 * Metodo que retorna um novo objeto com os mesmos valores do atributo da chamada.
	 * @return data Data - nova data clonado.
	 */
	public Data clone()	{
		return new Data( this.dia, this.mes, this.ano);
	}
}
