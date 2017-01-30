package constantes;

/**
 * Enumera��o que define os estados do endereco.
 * @author Lucas Alves Rufino e Miriane Silva Trajano do Nascimento.
 */
public enum Estado {

	ACRE ("Acre"),
	ALAGOAS ("Alagoas"),
	AMAPA ("Amap�"),
	AMAZONAS ("Amazonas"),
	BAHIA ("Bahia"),
	CEARA ("Cear�"),
	DISTRITOFEDERAL ("Distrito Federal"),
	ESPIRITOSANTO ("Esp�rito Santo"),
	GOIAS ("Goi�s"),
	MARANHAO ("Maranh�o"),
	MATOGROSSO ("Mato Grosso"),
	MATOGROSSODOSUL ("Mato Grosso do Sul"),
	MINASGERAIS ("Minas Gerais"),
	PARA ("Par�"),
	PARAIBA ("Para�ba"),
	PARANA ("Paran�"),
	PERNAMBUCO ("Pernambuco"),
	PIAUI ("Piau�"),
	RIODEJANEIRO ("Rio de Janeiro"),
	RIOGRANDEDONORTE ("Rio Grande do Norte"),
	RIOGRANDEDOSUL ("Rio Grande do Sul"),
	RONDONIA ("Rond�nia"),
	RORAIMA ("Roraima"),
	SANTACATARINA ("Santa Catarina"),
	SAOPAULO ("S�o Paulo"),
	SERGIPE ("Sergipe"),
	TOCANTINS ("Tocantins");
	
	private String nome;	//nome do estado.
	
	/**
	 * Metodo construtor para atribui��o dos valores da enumera��o.
	 * @param nome String - nome do estado.
	 */
	private Estado(String nome){
		this.nome = nome;
	}
	
	/**
	 * Metodo que retorna a representa��o textual do nome do estado.
	 * @return String - nome do estado.
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Metodo que retorna um array de String com os nomes dos estados da enumeracao.
	 * @return String[] - nomes dos estados.
	 */
	public static String[] getEstados(){
		Estado[] estados = values();
		String[] nomes = new String[estados.length];		
		for(int i=0, len=estados.length ; i<len ; i++){	//varre o array de enumeracao.
			nomes[i] = estados[i].getNome();			//aplica os nomes no array de string.
		}
		return nomes;
	}
	
	/**
	 * Metodo que recebe um numero e retorna a enumeracao respectiva a esse numero.
	 * @param number int - numero do indice de enumera�oes
	 * @return Estado - enumera��o respectiva ao valor.
	 */
	public static Estado seletor(int number){
		return values()[number];
	}
	
}
