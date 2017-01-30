package dados;

/**
 * Classe que determina o funcionamento do objeto Pessoa
 * Caraterizado por nome, CPF, email, senha, telefone, sexo, data de nascimento e endereço. 
 * @author Lucas Alves Rufino e Miriane Silva Trajano do Nascimento.
 */
public abstract class Pessoa {

	//Atributos relacionados a cadastro
	private String nome;				//Nome da pessoa.
	private String CPF;					//código de pessoa fisica(cpf).
	private String email;				//email da pessoa.
	private String senha;				//senha da pessoa.
	private String telefone;			//telefone da pessoa.
	private char sexo;					//sexo da pessoa.
	private Data data;					//data de nascimento da pessoa.
	private Endereco endereco;			//endereco para envio da pessoa.
	
	//atributos relacionados a produtos
	private String[] produtosAdquiridos;	//colecao de produtos adquiridos pela pessoa.
	private double[] precoProdutos;			//colecao de precos totais gasto por produto.
	private int[] quantProdutos;			//colecao de numeros de exemplares comprados
	private int indiceProdutos;				//indice de controle de colecoes de produtos
	
	//Atributos relacionados a servicos
	private String[] servicosAdquiridos;	//colecao de servicos adqueridos.
	private int indiceServicos;				//indice de controle de colecao de servicos

	/**
	 * Metodo construtor dos atributos da pessoa.
	 * @param nome String - Nome da pessoa
	 * @param CPF String - código de pessoa fisica.
	 * @param email String - email da pessoa.
	 * @param senha String - Senha da pessoa.
	 * @param telefone String - telefone da pessoa.
	 * @param sexo char - sexo da pessoa.
	 * @param data Data - data de nascimento da pessoa
	 * @param endereco Endereco - endereco para envio da pessoa.
	 * @param produtosAdquiridos String[] - colecao de produtos adqueridos pelo pessoa.
	 * @param precoProdutos double[] - colecao de preco total de cada produto.
	 * @param quantProdutos int[] - colecao de quantidadeas de produtos comprados.
	 * @param indiceProdutos int - indice das colecoes relacionadas a produtos.
	 * @param servicosAdquiridos String[] - colecao de servicos adqueridos pela pessoa.
	 * @param indiceServicos int - indice da colecao de servicos adqueridos.
	 */
	public Pessoa(String nome, String CPF, String email, String senha, String telefone, char sexo, Data data,
			Endereco endereco, String[] produtosAdquiridos, double[] precoProdutos, int[] quantProdutos,
			int indiceProdutos, String[] servicosAdquiridos, int indiceServicos) {
		this.nome = nome;
		this.CPF = CPF;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.sexo = sexo;
		this.data = data;
		this.endereco = endereco;
		
		this.produtosAdquiridos = produtosAdquiridos;
		this.precoProdutos = precoProdutos;
		this.quantProdutos = quantProdutos;
		this.indiceProdutos = indiceProdutos;
		
		this.servicosAdquiridos = servicosAdquiridos;
		this.indiceServicos = indiceServicos;
	}

	/**
	 * Metodo construtor dos atributos da pessoa.
	 * @param nome String - Nome da pessoa
	 * @param CPF String - código de pessoa fisica.
	 * @param email String - email da pessoa.
	 * @param senha String - Senha da pessoa.
	 * @param telefone String - telefone da pessoa.
	 * @param sexo char - sexo da pessoa.
	 * @param data Data - data de nascimento da pessoa
	 * @param endereco Endereco - endereco para envio da pessoa.
	 */
	public Pessoa(String nome, String CPF, String email, String senha, String telefone, char sexo, Data data,
			Endereco endereco){
		this(nome, CPF, email, senha, telefone, sexo, data, endereco, new String[10], new double[10], new int[10],
			0, new String[10], 0);	
	}

	//Metodos Getters//////////////////////////////////
	public String getNome() {
		return this.nome;
	}

	public String getCPF() {
		return this.CPF;
	}

	public String getEmail() {
		return this.email;
	}

	public String getSenha() {
		return this.senha;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public char getSexo() {
		return this.sexo;
	}

	public Data getData() {
		return this.data;
	}

	public Endereco getEndereco() {
		return this.endereco;
	}

	public String[] getProdutosAdquiridos() {
		return this.produtosAdquiridos;
	}

	public double[] getPrecoProdutos() {
		return this.precoProdutos;
	}

	public int[] getQuantProdutos() {
		return this.quantProdutos;
	}

	public int getIndiceProdutos() {
		return this.indiceProdutos;
	}

	public String[] getServicosAdquiridos() {
		return this.servicosAdquiridos;
	}

	public int getIndiceServicos() {
		return this.indiceServicos;
	}

	//Metodos Setter/////////////////////////////////////////////
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCPF(String CPF){
		this.CPF = CPF;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setTelefone(String telefone){
		this.telefone = telefone;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public void setProdutosAdquiridos(String[] produtosAdquiridos) {
		this.produtosAdquiridos = produtosAdquiridos;
	}

	public void setPrecoProdutos(double[] precoProdutos) {
		this.precoProdutos = precoProdutos;
	}

	public void setQuantProdutos(int[] quantProdutos) {
		this.quantProdutos = quantProdutos;
	}

	public void setIndiceProdutos(int indiceProdutos) {
		this.indiceProdutos = indiceProdutos;
	}

	public void setServicosAdquiridos(String[] servicosAdquiridos) {
		this.servicosAdquiridos = servicosAdquiridos;
	}

	public void setIndiceServicos(int indiceServicos) {
		this.indiceServicos = indiceServicos;
	}

	/**
	 * Metodo que expande as colecoes relacionadas a compra de livros.
	 * @param tamanho int - tamanho a ser expandido.
	 */
	private void expandirProdutos(int tamanho){
		String[] auxLivrosAdquiridos = new String[this.indiceProdutos + tamanho];
		double[] auxPrecoLivros = new double[this.indiceProdutos + tamanho];
		int[] auxQuantLivros = new int[this.indiceProdutos + tamanho];
		
		for(int i=0 ; i<this.indiceProdutos ; i++){
			auxLivrosAdquiridos[i] = this.produtosAdquiridos[i];
			auxPrecoLivros[i] = this.precoProdutos[i];
			auxQuantLivros[i] = this.quantProdutos[i];
		}
		
		this.produtosAdquiridos = auxLivrosAdquiridos;
		this.precoProdutos = auxPrecoLivros;
		this.quantProdutos = auxQuantLivros;
	}
	
	/**
	 * Metodo que expande a colecao de servicos adqueridos
	 * @param tamanho int - tamanho a ser expandido.
	 */
	private void expandirServicos(int tamanho){
		String[] auxServicosAdquiridos = new String[this.indiceServicos + tamanho];
		
		for(int i=0 ; i<this.indiceServicos ; i++){
			auxServicosAdquiridos[i] = servicosAdquiridos[i];
		}
		
		this.servicosAdquiridos = auxServicosAdquiridos;
	}
	
	/**
	 * Metodo que rebebe um produto e sua respectiva quantidade e armazena na colecao de produtos adqueridos
	 * @param produto Produto - produto a ser adquerido.
	 * @param quant int - quantidade de produtos adqueridos.
	 */
	public void adquerirProduto(Produto produto, int quant) {
		boolean achou = false;
		int indice = 0;
		
		if(this.indiceProdutos == this.produtosAdquiridos.length){
			expandirProdutos(10);
		}
		
		for(int i=0 ; i<this.indiceProdutos && !achou ; i++){
			if(this.produtosAdquiridos[i].equals(produto.getISBN())){
				achou = true;
				indice = i;
			}
		}
		if(!achou){
			this.produtosAdquiridos[this.indiceProdutos] = produto.getISBN();
			this.quantProdutos[this.indiceProdutos] = quant;
			this.precoProdutos[this.indiceProdutos++] = quant*(produto.getPreco() - produto.getPreco()*getDesconto());
		} else {
			this.quantProdutos[indice] = quant + this.quantProdutos[indice];
			this.precoProdutos[indice] = quant*(produto.getPreco() - produto.getPreco()*getDesconto()) + this.precoProdutos[indice];
		}
	}
	
	/**
	 * Metodo que rebebe um produto e sua respectiva quantidade e armazena na colecao de produtos adqueridos
	 * @param produto Produto - produto a ser adquerido.
	 */
	public void adquerirServico(Servico servico) {
		if(this.indiceServicos == this.servicosAdquiridos.length){
			expandirServicos(10);
		}
		this.servicosAdquiridos[this.indiceServicos++] = servico.getCodigo();
	}
	
	//Metodos Abstratos
	
	/**
	 * Metodo que retorna um valor de desconto segundo os dados do funcionario ou cliente.
	 * @return double - fator de desconto ao adquerir livros.
	 */
	public abstract double getDesconto();
	
	/**
	 * Metodo que retorna um novo objeto com os mesmos valores do atributo da chamada.
	 * @return Pessoa - nova pessoa clonado.
	 */
	public abstract Pessoa clone();
	
}
