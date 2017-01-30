package dados;

/**
 * Classe que define o funcionamento do objeto Servico
 * @author Lucas Alves Rufino e Miriane Silva Trajano do Nascimento.
 */
public abstract class Servico {

	private String nome;		//nome do servico
	private String codigo;		//codigo de identificacao unica do servico
	private int vagas;			//vagas para o servico
	private Data data;			//data inicial do servico
	private String horario;		//horario do servico HH:MM.
	private double duracao;		//duracao do servico no dia em horas.
	private Endereco endereco;	//endereco onde o servico sera realizado.
	private String descricao;	//descricao breve do servico.
	
	private String[] pessoas;	//lista de participantes do servico.
	private int vagasOcupadas;	//vagas ja preenchidas do servico
	
	
	/**
	 * Metodo contrutor que inicia os atributos do servico.
	 * @param nome String - nome do servico.
	 * @param codigo String - codigo de identificacao unica do servico
	 * @param vagas int - vagas para o servico.
	 * @param data Data - data inicial do servico.
	 * @param horario String - horario do servico.
	 * @param duracao double - duracao do servico no dia mim.
	 * @param endereco Endereco - endereco onde o servico sera realizado.
	 * @param pessoas String[] - colecao de participantes do serviço.
	 * @param vagasOcupadas int - vagas oculpadas do servico.
	 * @param descricao String - descricao breve do servico.
	 */
	public Servico(String nome, String codigo, int vagas, Data data, String horario, double duracao, Endereco endereco,
			String[] pessoas, int vagasOcupadas, String descricao) {
		this.nome = nome;
		this.codigo = codigo;
		this.vagas = vagas;
		this.data = data;
		this.horario = horario;
		this.duracao = duracao;
		this.endereco = endereco;
		this.pessoas = pessoas;
		this.vagasOcupadas = vagasOcupadas;
		this.descricao = descricao;
	}
	
	/**
	 * Metodo contrutor que inicia os atributos do servico.
	 * @param nome String - nome do servico.
	 * @param codigo String - codigo de identificacao unica do servico
	 * @param vagas int - vagas para o servico.
	 * @param data Data - data inicial do servico.
	 * @param horario String - horario do servico.
	 * @param duracao double - duracao do servico no dia mim.
	 * @param endereco Endereco - endereco onde o servico sera realizado.
	 * @param descricao String - descricao breve do servico.
	 */
	public Servico(String nome, String codigo, int vagas, Data data, String horario, double duracao, 
			Endereco endereco, String descricao) {
		this( nome, codigo, vagas, data, horario, duracao, endereco, new String[vagas], 0, descricao);
	}

	//Metodos Getters///////////////////////////////////////
	public String getNome() {
		return this.nome;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public int getVagas() {
		return this.vagas;
	}

	public Data getData() {
		return this.data;
	}

	public String getHorario() {
		return this.horario;
	}
	
	public double getDuracao() {
		return this.duracao;
	}

	public Endereco getEndereco() {
		return this.endereco;
	}

	public String[] getPessoas() {
		return this.pessoas;
	}

	public int getVagasOcupadas() {
		return this.vagasOcupadas;
	}

	public String getDescricao() {
		return this.descricao;
	}

	//Metodos Setters////////////////////////////////////////
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setVagas(int vagas) {
		this.vagas = vagas;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	public void setDuracao(double duracao) {
		this.duracao = duracao;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void setPessoas(String[] pessoas) {
		this.pessoas = pessoas;
	}

	public void setVagasOcupadas(int vagasOcupadas) {
		this.vagasOcupadas = vagasOcupadas;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	/**
	 * Metodo que adiciona uma nova pessoa a lista de participantes do servico.
	 * @param pessoa Pessoa - pessoa a ser adicionada na lista de participantes.
	 */
	public void adicionarPessoa(Pessoa pessoa) {
		if(this.vagasOcupadas == this.pessoas.length){
			String[] aux = new String[this.vagasOcupadas + 10];
			for(int i=0 ; i<this.vagasOcupadas ; i++){
				aux[i] = pessoas[i];
			}
			this.pessoas = aux;
		}
		this.pessoas[this.vagasOcupadas++] = pessoa.getCPF();
	}
	
	
	
	//Metodos Abstratos///////////////////////////////////////////
	
	/**
	 * Metodo que retorna um novo objeto com os mesmos valores do atributo da chamada.
	 * @return Servico - novo produto clonado.
	 */
	public abstract Servico clone();
}
