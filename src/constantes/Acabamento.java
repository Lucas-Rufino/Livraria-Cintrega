package constantes;

/**
 * Enumera��o que define os acabamentos de livros.
 * @author Lucas Alves Rufino e Miriane Silva Trajano do Nascimento.
 */
public enum Acabamento {
	
	//fonte da pesquisa - https://pt.wikipedia.org/wiki/Encaderna��o
	BROCHURA ("Brochura"),
	CANOA ("Canoa"),
	ESPIRAL ("Espiral"),
	CAPADURA ("Capa Dura"),
	WIREO ("Wire-o"),
	OUTROS ("Outros");

	private String nome;	//nome do acabamento.
	
	/**
	 * Metodo construtor para atribui��o dos valores da enumera��o.
	 * @param nome String - nome do acabamento.
	 */
	private Acabamento(String nome){
		this.nome = nome;
	}
	
	/**
	 * Metodo que retorna a representa��o textual do acabamento.
	 * @return String - nome do acabamento.
	 */
	public String getNome(){
		return this.nome;
	}
	
	/**
	 * Metodo que retorna um array de String com os nomes dos acabamentos da enumeracao.
	 * @return String[] - nomes dos acabamentos.
	 */
	public static String[] getAcabamentos(){
		Acabamento[] acabamentos = values();
		String[] nomes = new String[acabamentos.length];		
		for(int i=0, len=acabamentos.length ; i<len ; i++){		//varre o array de enumeracao.
			nomes[i] = acabamentos[i].getNome();				//aplica os nomes nos array de string.
		}
		return nomes;
	}
	
	/**
	 * Metodo que recebe um numero e retorna a enumeracao respectiva a esse numero.
	 * @param number int - numero do indice de enumera�oes
	 * @return Acabamento - enumera��o respectiva ao valor.
	 */
	public static Acabamento seletor(int number){
		return values()[number];
	}
}
