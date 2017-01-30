package dados;

import constantes.Cargo;

/**
 * Classe que define o funcionamento do objeto Funcionario.
 * @author Lucas Alves Rufino e Miriane Silva Trajano do Nascimento.
 */
public class Funcionario extends Pessoa {

	private double salario;			//salario do funcionario.
	private Cargo cargo;			//cargo do funcionario.
	private double horasSemanais;	//horas semanais trabalhadas pelo profissional.
	
	/**
	 * Metodo que inicializa os atributos da classe Funcionario.
	 * @param nome String - Nome do funcionario.
	 * @param CPF String - código de pessoa fisica.
	 * @param email String - email do funcionario.
	 * @param senha String - Senha do funcionario.
	 * @param telefone String - telefone do funcionario.
	 * @param sexo char - sexo do funcionario.
	 * @param data Data - data de nascimento do funcionario.
	 * @param endereco Endereco - endereco para envio do funcionario.
	 * @param produtosAdquiridos String[] - colecao de produtos adqueridos pelo funcionário.
	 * @param precoProdutos double[] - colecao de preco de cada produto.
	 * @param quantProdutos int[] - colecao de quantidadeas de produtos comprados.
	 * @param indiceProdutos int - indice das colecoes relacionadas a produtos.
	 * @param servicosAdquiridos String[] - colecao de servicos adqueridos pelo funcionario.
	 * @param indiceServicos int - indice da colecao de servicos adqueridos.
	 * @param salario double - salario do funcionario
	 * @param cargo Cargo - cargo do funcionario.
	 * @param horasSemanais double - carga horaria semanal do usuario.
	 */
	public Funcionario(String nome, String CPF, String email, String senha, String telefone, char sexo, Data data,
			Endereco endereco, String[] produtosAdquiridos, double[] precoProdutos, int[] quantProdutos,
			int indiceProdutos, String[] servicosAdquiridos, int indiceServicos, double salario, Cargo cargo,
			double horasSemanais) {
		super(nome, CPF, email, senha, telefone, sexo, data, endereco, produtosAdquiridos, precoProdutos, quantProdutos,
				indiceProdutos, servicosAdquiridos, indiceServicos);
		this.salario = salario;
		this.cargo = cargo;
		this.horasSemanais = horasSemanais;
	}

	/**
	 * Metodo que inicializa os atributos da classe Funcionario.
	 * @param nome String - Nome do funcionario.
	 * @param CPF String - código de pessoa fisica.
	 * @param email String - email do funcionario.
	 * @param senha String - Senha do funcionario.
	 * @param telefone String - telefone do funcionario.
	 * @param sexo char - sexo do funcionario.
	 * @param data Data - data de nascimento do funcionario.
	 * @param endereco Endereco - endereco para envio do funcionario.
	 * @param salario double - salario do funcionario
	 * @param cargo Cargo - cargo do funcionario.
	 * @param horasSemanais double - carga horaria semanal do usuario.
	 * @throws ValorInvalidoException excecao para tratamento de valores invalidos.
	 */
	public Funcionario(String nome, String CPF, String email, String senha, String telefone, char sexo, Data data,
			Endereco endereco, double salario, Cargo cargo, double horasSemanais) {
		super(nome, CPF, email, senha, telefone, sexo, data, endereco);
		this.salario = salario;
		this.cargo = cargo;
		this.horasSemanais = horasSemanais;
	}

	//Metodos Getters/////////////////////////////////
	public double getSalario() {
		return salario;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public double getHorasSemanais() {
		return horasSemanais;
	}

	//Metodos Setters/////////////////////////////////////
	public void setSalario(double salario) {
		this.salario = salario;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public void setHorasSemanais(double horasSemanais) {
		this.horasSemanais = horasSemanais;
	}
	
	public double getDesconto(){
		switch(this.cargo){
			case GERENTE: return (0.15);
			case BIBLIOTECARIO: return (0.12);
			default: return (0.10);
		}
	}
	
	public Pessoa clone(){
		return new Funcionario(this.getNome(), this.getCPF(), this.getEmail(), this.getSenha(), this.getTelefone(),
			this.getSexo(), this.getData().clone(), this.getEndereco().clone(), this.getProdutosAdquiridos().clone(),
			this.getPrecoProdutos().clone(), this.getQuantProdutos().clone(), this.getIndiceProdutos(),
			this.getServicosAdquiridos().clone(), this.getIndiceServicos(), this.salario, this.cargo, this.horasSemanais);
	}
}
