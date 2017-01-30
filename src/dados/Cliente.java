package dados;

/**
 * Classe que define o funcionamento do objeto Cliente.
 * @author Lucas Alves Rufino e Miriane Silva Trajano do Nascimento.
 */
public class Cliente extends Pessoa{

	/**
	 * Metodo construtor que inicializa os atributos da classe Cliente.
	 * @param nome String - Nome do cliente.
	 * @param CPF String - código de pessoa fisica.
	 * @param email String - email do cliente.
	 * @param senha String - Senha do cliente.
	 * @param telefone String - telefone do cliente.
	 * @param sexo char - sexo do cliente.
	 * @param data Data - data de nascimento do cliente.
	 * @param endereco Endereco - endereco para envio do cliente.
	 * @param produtosAdquiridos String[] - colecao de produtos adqueridos pelo cliente.
	 * @param precoProdutos double[] - colecao de preco de cada produto.
	 * @param quantProdutos int[] - colecao de quantidadeas de produtos comprados.
	 * @param indiceProdutos int - indice das colecoes relacionadas a produtos.
	 * @param servicosAdquiridos String[] - colecao de servicos adqueridos pelo cliente.
	 * @param indiceServicos int - indice da colecao de servicos adqueridos.
	 */
	public Cliente(String nome, String CPF, String email, String senha, String telefone, char sexo, Data data,
			Endereco endereco, String[] produtosAdquiridos, double[] precoProdutos, int[] quantProdutos,
			int indiceProdutos, String[] servicosAdquiridos, int indiceServicos) {
		super(nome, CPF, email, senha, telefone, sexo, data, endereco, produtosAdquiridos, precoProdutos, quantProdutos,
				indiceProdutos, servicosAdquiridos, indiceServicos);
	}
	
	/**
	 * Metodo construtor que inicializa os atributos da classe Cliente.
	 * @param nome String - Nome do cliente.
	 * @param CPF String - código de pessoa fisica.
	 * @param email String - email do cliente.
	 * @param senha String - Senha do cliente.
	 * @param telefone String - telefone do cliente.
	 * @param sexo char - sexo do cliente.
	 * @param data Data - data de nascimento do cliente.
	 * @param endereco Endereco - endereco para envio do cliente.
	 */
	public Cliente(String nome, String CPF, String email, String senha, String telefone, char sexo, Data data,
			Endereco endereco) {
		super(nome, CPF, email, senha, telefone, sexo, data, endereco);
	}

	public double getDesconto(){
		if(this.getIndiceProdutos() > 10){
			return (0.05);
		} else {
			return (0);
		}
	}
	
	public Pessoa clone(){
		return new Cliente(this.getNome(), this.getCPF(), this.getEmail(), this.getSenha(), this.getTelefone(),
			this.getSexo(), this.getData().clone(), this.getEndereco().clone(), this.getProdutosAdquiridos().clone(),
			this.getPrecoProdutos().clone(), this.getQuantProdutos().clone(), this.getIndiceProdutos(),
			this.getServicosAdquiridos().clone(), this.getIndiceServicos());
	}
}
