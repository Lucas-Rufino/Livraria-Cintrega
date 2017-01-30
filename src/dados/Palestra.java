package dados;

/**
 * Classe que define o funcionamento do objeto palestra
 * @author Lucas Alves Rufino e Miriane Silva Trajano do Nascimento.
 */
public class Palestra extends Servico{
	
	private String palestrante;		//nome do palestrante

	/**
	 * Metodo construtor que inicia os atributos da palestra.
	 * @param nome String - nome da palestra.
	 * @param codigo String - Codigo de identificacao da palestra.
	 * @param vagas int - vagas para a palestra.
	 * @param data Data - data de realizacao da palestra.
	 * @param horario String - horario inicial da palestra.
	 * @param duracao double - duracao da palestra em horas.
	 * @param endereco Endereco - local da palestra.
	 * @param pessoas String[] - participantes da palestra.
	 * @param vagasOcupadas int - total de vagas oculpadas.
	 * @param descricao String - descricao da palestra.
	 * @param palestrante String - palestrante.
	 */
	public Palestra(String nome, String codigo, int vagas, Data data, String horario, double duracao, Endereco endereco,
			String[] pessoas, int vagasOcupadas, String descricao, String palestrante) {
		super(nome, codigo, vagas, data, horario, duracao, endereco, pessoas, vagasOcupadas, descricao);
		this.palestrante = palestrante;
	}

	/**
	 * Metodo construtor que inicia os atributos da palestra.
	 * @param nome String - nome da palestra.
	 * @param codigo String - Codigo de identificacao da palestra.
	 * @param vagas int - vagas para a palestra.
	 * @param data Data - data de realizacao da palestra.
	 * @param horario String - horario inicial da palestra.
	 * @param duracao double - duracao da palestra em horas.
	 * @param endereco Endereco - local da palestra.
	 * @param descricao String - descricao da palestra.
	 * @param palestrante - nome do palestrante.
	 */
	public Palestra(String nome, String codigo, int vagas, Data data, String horario, double duracao, Endereco endereco,
			String descricao, String palestrante) {
		super(nome, codigo, vagas, data, horario, duracao, endereco, descricao);
		this.palestrante = palestrante;
	}
	
	//Metodo Getter/////////////////////////////////////////////////
	public String getPalestrante() {
		return this.palestrante;
	}
	
	//Metodo Setter////////////////////////////////////////////////
	public void setPalestrante(String palestrante) {
		this.palestrante = palestrante;
	}
	
	public Servico clone(){
		return new Palestra(this.getNome(), this.getCodigo(), this.getVagas(), this.getData().clone(),
				this.getHorario(), this.getDuracao(), this.getEndereco().clone(), this.getPessoas().clone(),
				this.getVagasOcupadas(), this.getDescricao(), this.palestrante);
	}
}
