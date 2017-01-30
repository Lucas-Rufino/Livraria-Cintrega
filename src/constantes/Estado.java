package constantes;

/**
 * Enumeração que define os estados do endereco.
 * @author Lucas Alves Rufino e Miriane Silva Trajano do Nascimento.
 */
public enum Estado {

	ACRE ("Acre"),
	ALAGOAS ("Alagoas"),
	AMAPA ("Amapá"),
	AMAZONAS ("Amazonas"),
	BAHIA ("Bahia"),
	CEARA ("Ceará"),
	DISTRITOFEDERAL ("Distrito Federal"),
	ESPIRITOSANTO ("Espírito Santo"),
	GOIAS ("Goiás"),
	MARANHAO ("Maranhão"),
	MATOGROSSO ("Mato Grosso"),
	MATOGROSSODOSUL ("Mato Grosso do Sul"),
	MINASGERAIS ("Minas Gerais"),
	PARA ("Pará"),
	PARAIBA ("Paraíba"),
	PARANA ("Paraná"),
	PERNAMBUCO ("Pernambuco"),
	PIAUI ("Piauí"),
	RIODEJANEIRO ("Rio de Janeiro"),
	RIOGRANDEDONORTE ("Rio Grande do Norte"),
	RIOGRANDEDOSUL ("Rio Grande do Sul"),
	RONDONIA ("Rondônia"),
	RORAIMA ("Roraima"),
	SANTACATARINA ("Santa Catarina"),
	SAOPAULO ("São Paulo"),
	SERGIPE ("Sergipe"),
	TOCANTINS ("Tocantins");
	
	private String nome;	//nome do estado.
	
	/**
	 * Metodo construtor para atribuição dos valores da enumeração.
	 * @param nome String - nome do estado.
	 */
	private Estado(String nome){
		this.nome = nome;
	}
	
	/**
	 * Metodo que retorna a representação textual do nome do estado.
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
	 * @param number int - numero do indice de enumeraçoes
	 * @return Estado - enumeração respectiva ao valor.
	 */
	public static Estado seletor(int number){
		return values()[number];
	}
	
}
