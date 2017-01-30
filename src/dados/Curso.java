package dados;

import constantes.Dia;

/**
 * Classe que define o funcionamento do objeto curso.
 * @author Lucas Alves Rufino e Miriane Silva Trajano do Nascimento.
 */
public class Curso extends Servico { 

	private String professor;		//professor do curso.
	private double cargaHoraria;	//carga horaria total do curso em horas.
	private Dia[] dias;				//dias de aula do curso.
	
	/**
	 * Metodo construtor que inicia os atributos do curso.
	 * @param nome String - nome do curso.
	 * @param codigo String - Codigo de identificacao do curso.
	 * @param vagas int - vagas para o curso.
	 * @param data Data - data de realizacao do curso.
	 * @param horario String - horario inicial do curso.
	 * @param duracao double - duracao do curso em horas diarias.
	 * @param endereco Endereco - local do curso.
	 * @param pessoas String[] - participantes do curso.
	 * @param vagasOcupadas int - total de vagas oculpadas.
	 * @param descricao String - descricao do curso.
	 * @param professor String - nome do professor do curso.
	 * @param cargaHoraria double - carga horaria total do curso.
	 * @param dias Dias[] - dias de aula na semana.
	 */
	public Curso(String nome, String codigo, int vagas, Data data, String horario, double duracao, Endereco endereco,
			String[] pessoas, int vagasOcupadas, String descricao, String professor, double cargaHoraria, Dia[] dias) {
		super(nome, codigo, vagas, data, horario, duracao, endereco, pessoas, vagasOcupadas, descricao);
		this.professor = professor;
		this.cargaHoraria = cargaHoraria;
		this.dias = dias;
	}

	/**
	 * Metodo construtor que inicia os atributos do curso.
	 * @param nome String - nome do curso.
	 * @param codigo String - Codigo de identificacao do curso.
	 * @param vagas int - vagas para o curso.
	 * @param data Data - data de realizacao do curso.
	 * @param horario String - horario inicial do curso.
	 * @param duracao double - duracao do curso em horas diarias.
	 * @param endereco Endereco - local do curso.
	 * @param descricao String - descricao do curso.
	 * @param professor String - nome do professor do curso.
	 * @param cargaHoraria double - carga horária total do curso.
	 * @param dias Dia[] - dias de aula do curso.
	 */
	public Curso(String nome, String codigo, int vagas, Data data, String horario, double duracao, Endereco endereco,
			String descricao, String professor, double cargaHoraria, Dia[] dias) {
		super(nome, codigo, vagas, data, horario, duracao, endereco, descricao);
		this.professor = professor;
		this.dias = dias;
		this.cargaHoraria = cargaHoraria;
	}

	//Metodos Getters///////////////////////////////////////////
	public String getProfessor() {
		return professor;
	}

	public double getCargaHoraria() {
		return cargaHoraria;
	}

	public Dia[] getDias() {
		return dias;
	}
	
	//Metodos Setters///////////////////////////////////////////
	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public void setCargaHoraria(double cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public void setDias(Dia[] dias) {
		this.dias = dias;
	}
	
	public Servico clone(){
		return new Curso(this.getNome(), this.getCodigo(), this.getVagas(), this.getData().clone(), this.getHorario(),
				this.getDuracao(), this.getEndereco().clone(), this.getPessoas().clone(), this.getVagasOcupadas(),
				this.getDescricao(), this.professor, this.cargaHoraria, this.dias);
	}
	
}
