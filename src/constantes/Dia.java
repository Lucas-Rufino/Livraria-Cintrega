package constantes;

/**
 * Enumeração que define os dias da semana do curso.
 * @author Lucas Alves Rufino e Miriane Silva Trajano do Nascimento.
 */
public enum Dia {

	DOMINGO ("Domingo", "dom"),
	SEGUNDAFEIRA ("Segunda-feira", "seg"),
	TERCAFEIRA ("Terça-feira", "ter"),
	QUARTAFEIRA ("Quarta-feira", "qua"),
	QUINTAFEIRA ("Quinta-feira", "qui"),
	SEXTAFEIRA ("Sexta-Feira", "sex"),
	SABADO ("Sábado", "sáb");
	
	private String nome;			//nome do dia da semana
	private String abreviatura;		//abreviatura do dia da semana
	
	/**
	 * Metodo construtor para atribuição dos valores da enumeração.
	 * @param nome String - nome do dia da semana.
	 * @param abreviatura Strng - abreviatura do dia.
	 */
	private Dia(String nome, String abreviatura){
		this.nome = nome;
		this.abreviatura = abreviatura;
	}
	
	/**
	 * Metodo que retorna a representação textual do nome do dia da semana.
	 * @return String - nome do dia.
	 */
	public String getNome(){
		return this.nome;
	}
	
	/**
	 * Metodo que retorna a representação textual da abreviatura do dia da semana.
	 * @return String - abreviatura do dia.
	 */
	public String getAbreviatura(){
		return this.abreviatura;
	}
	
	/**
	 * Metodo que retorna um array de String com os nomes dos dias da enumeracao.
	 * @return String[] - nomes dos dias.
	 */
	public static String[] getDiasNomes(){
		Dia[] dias = values();
		String[] nomes = new String[dias.length];		
		for(int i=0, len=dias.length ; i<len ; i++){	//varre o array de enumeracao.
			nomes[i] = dias[i].getNome();				//aplica os nomes no array de string.
		}
		return nomes;
	}
	
	/**
	 * Metodo que retorna um array de String com as abreviaturas dos dias da enumeracao.
	 * @return String[] - abreviaturas dos dias.
	 */
	public static String[] getDiasAbreviaturas(){
		Dia[] dias = values();
		String[] abreviaturas = new String[dias.length];		
		for(int i=0, len=dias.length ; i<len ; i++){		//varre o array de enumeracao.
			abreviaturas[i] = dias[i].getAbreviatura();		//aplica os nomes no array de string.
		}
		return abreviaturas;
	}
	
	/**
	 * Metodo que recebe um numero e retorna a enumeracao respectiva a esse numero.
	 * @param number int - numero do indice de enumeraçoes
	 * @return Dia - enumeração respectiva ao valor.
	 */
	public static Dia seletor(int number){
		return values()[number];
	}
}
