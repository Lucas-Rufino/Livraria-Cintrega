package constantes;

/**
 * Eumeração que define os cargos dos funcionarios.
 * @author Lucas Alves Rufino e Miriane Silva Trajano do Nascimento.
 */
public enum Cargo {

	VENDEDOR ("Vendedor(a)"),
	GERENTE ("Gerente"),
	COPEIRO ("Copeiro(a)"),
	BIBLIOTECARIO ("Bibliotecário(a)"),
	SERVICOSGERAIS ("Auxiliar de serviços gerais"),
	SEGURANCA ("Segurança");
	
	private String nome;	//nome do cargo.
	
	/**
	 * Metodo construtor para atribuição dos valores da enumeração.
	 * @param nome String - nome do cargo.
	 */
	private Cargo(String nome){
		this.nome = nome;
	}
	
	/**
	 * Metodo que retorna a representação textual do cargo.
	 * @return String - nome do cargo.
	 */
	public String getNome(){
		return this.nome;
	}
	
	/**
	 * Metodo que retorna um array de String com os nomes dos cargos da enumeracao.
	 * @return String[] - nomes dos cargos.
	 */
	public static String[] getCargos(){
		Cargo[] cargos = values();
		String[] nomes = new String[cargos.length];		
		for(int i=0, len=cargos.length ; i<len ; i++){		//varre o array de enumeracao.
			nomes[i] = cargos[i].getNome();					//aplica os nomes nos array de string.
		}
		return nomes;
	}
	
	/**
	 * Metodo que recebe um numero e retorna a enumeracao respectiva a esse numero.
	 * @param number int - numero do indice de enumeraçoes
	 * @return Acabamento - enumeração respectiva ao valor.
	 */
	public static Cargo seletor(int number){
		return values()[number];
	}
	
}
