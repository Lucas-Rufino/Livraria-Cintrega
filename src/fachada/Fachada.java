package fachada;

import java.util.Date;

import constantes.Dia;
import dados.Cliente;
import dados.Curso;
import dados.Ebook;
import dados.Funcionario;
import dados.Livro;
import dados.Palestra;
import dados.Pessoa;
import dados.Produto;
import dados.Servico;
import negocios.NegocioPessoa;
import negocios.NegocioProduto;
import negocios.NegocioServico;
import negocios.ValorInvalidoException;
import negocios.ValorJaCadastradoException;
import negocios.ValorNaoEncontradoException;
import repositorios.RepositorioException;
import repositorios.RepositorioPessoa;
import repositorios.RepositorioProduto;
import repositorios.RepositorioServico;

/**
 * Classe que define o funcionamento da fachada.
 * @author Lucas Alves Rufino e Miriane Silva Trajano do Nascimento.
 */
public class Fachada {
	
	private NegocioPessoa nPessoa;		//Define o negocio de pessoa.
	private NegocioProduto nProduto;	//define o negocio de produto.
	private NegocioServico nServico;	//define o negocio de servico.
	
	/**
	 * Metodo que inicia os atributos da classe fachada
	 * @param repPessoa	RepositorioPessoa - repositorio de pessoas.
	 * @param repProduto RepositorioProduto - repositorio de produtos.
	 * @param repServico RepositorioServico - repositorio de servicos.
	 */
	public Fachada(RepositorioPessoa repPessoa, RepositorioProduto repProduto, RepositorioServico repServico){
		this.nPessoa = new NegocioPessoa(repPessoa);
		this.nProduto = new NegocioProduto(repProduto);
		this.nServico = new NegocioServico(repServico);
	}
	
	/**
	 * Metodo que cadastra uma nova pessoa no repositorio de pessoas.
	 * @param pessoa Pessoa - pessoa a ser cadastrada.
	 * @throws RepositorioException exceçao para tratamento de erros no repositorio.
	 * @throws ValorInvalidoException exceção para tramaneto de valores invalidos.
	 * @throws ValorJaCadastradoException exceção para tratamento de valores ja cadastrados.
	 */
	public void cadastrarPessoa(Pessoa pessoa) throws RepositorioException, ValorInvalidoException, ValorJaCadastradoException{
		this.nPessoa.cadastrar(pessoa);
	}
	
	/**
	 * Metodo que cadastra um novo produto no repositorio de produtos.
	 * @param produto Produto - produto a ser cadastrado.
	 * @throws RepositorioException exceçao para tratamento de erros no repositorio.
	 * @throws ValorInvalidoException exceção para tramaneto de valores invalidos.
	 * @throws ValorJaCadastradoException exceção para tratamento de valores ja cadastrados.
	 */
	public void cadastrarProduto(Produto produto) throws RepositorioException, ValorInvalidoException, ValorJaCadastradoException{
		this.nProduto.cadastrar(produto);
	}
	
	/**
	 * Metodo que cadastra um novo serviço no repositorio de serviços.
	 * @param servico Servico - serviço a ser cadastrado.
	 * @throws RepositorioException exceçao para tratamento de erros no repositorio.
	 * @throws ValorInvalidoException exceção para tramaneto de valores invalidos.
	 * @throws ValorJaCadastradoException exceção para tratamento de valores ja cadastrados.
	 */
	public void cadastrarServico(Servico servico) throws RepositorioException, ValorInvalidoException, ValorJaCadastradoException{
		this.nServico.cadastrar(servico);
	}
	
	/**
	 * Metodo que remove uma pessoa do repositorio de pessoas.
	 * @param CPF String - CPF da pessoa a ser removida.
	 * @throws RepositorioException exceção para tratamento de erros no repositorio.
	 * @throws ValorNaoEncontradoException exceção para tratamento de valores não encontrados.
	 */
	public void removerPessoa(String CPF) throws RepositorioException, ValorNaoEncontradoException{
		this.nPessoa.remover(CPF);
	}
	
	/**
	 * Metodo que remove um produto do repositorio de produtos.
	 * @param ISBN String - ISBN do produto a ser removido.
	 * @throws RepositorioException exceção para tratamento de erros no repositorio.
	 * @throws ValorNaoEncontradoException exceção para tratamento de valores não encontrados.
	 */
	public void removerProduto(String ISBN) throws RepositorioException, ValorNaoEncontradoException{
		this.nProduto.remover(ISBN);
	}
	
	/**
	 * Metodo que remove um serviço do repositorio de serviços.
	 * @param codigo String - código do produto a ser removido.
	 * @throws RepositorioException exceção para tratamento de erros no repositorio.
	 * @throws ValorNaoEncontradoException exceção para tratamento de valores não encontrados.
	 */
	public void removerServico(String codigo) throws RepositorioException, ValorNaoEncontradoException{
		this.nServico.remover(codigo);
	}
	
	/**
	 * Método que procura por uma pessoa no repositorio de pessoas segundo um CPF e o retorna.
	 * @param CPF String - CPF da pessoa.
	 * @return Pessoa - Pessoa com o respectivo CPF.
	 * @throws RepositorioException exceção para tratamento de erros no repositorio.
	 * @throws ValorNaoEncontradoException exceção para tratamento de valores não encontrados.
	 */
	public Pessoa procurarPessoa(String CPF) throws RepositorioException, ValorNaoEncontradoException{
		return this.nPessoa.procurar(CPF);
	}
	
	/**
	 * Método que procura por um produto no repositorio de produtos segundo um ISBN e o retorna.
	 * @param ISBN String - ISBN do produto.
	 * @return Produto - produto com o respectivo ISBN.
	 * @throws RepositorioException exceção para tratamento de erros no repositorio.
	 * @throws ValorNaoEncontradoException exceção para tratamento de valores não encontrados.
	 */
	public Produto procurarProduto(String ISBN) throws RepositorioException, ValorNaoEncontradoException{
		return this.nProduto.procurar(ISBN);
	}
	
	/**
	 * Método que procura por um servico no repositorio de servicos segundo um codigo e o retorna.
	 * @param codigo String - código do serviço.
	 * @return Servico - serviço com o respectivo código.
	 * @throws RepositorioException exceção para tratamento de erros no repositorio.
	 * @throws ValorNaoEncontradoException exceção para tratamento de valores não encontrados.
	 */
	public Servico procurarServico(String codigo) throws RepositorioException, ValorNaoEncontradoException{
		return this.nServico.procurar(codigo);
	}
	
	/**
	 * Método que atualiza uma pessoa presente no repositório de pessoas
	 * @param pessoa Pessoa - pessoa com os dados atualizados.
	 * @throws RepositorioException exceçao para tratamento de erros no repositorio.
	 * @throws ValorInvalidoException exceção para tratamento de valores invalidos.
	 * @throws ValorNaoEncontradoException exceção para tratamento de valores não encontrados.
	 */
	public void atualizarPessoa(Pessoa pessoa) throws RepositorioException, ValorInvalidoException, ValorNaoEncontradoException{
		this.nPessoa.atualizar(pessoa);
	}
	
	/**
	 * Método que atualiza um produto presente no repositório de produtos
	 * @param produto Produto - produto com os dados atualizados.
	 * @throws RepositorioException exceçao para tratamento de erros no repositorio.
	 * @throws ValorInvalidoException exceção para tratamento de valores invalidos.
	 * @throws ValorNaoEncontradoException exceção para tratamento de valores não encontrados.
	 */
	public void atualizarProduto(Produto produto) throws RepositorioException, ValorInvalidoException, ValorNaoEncontradoException{
		this.nProduto.atualizar(produto);
	}
	
	/**
	 * Método que atualiza um serviço presente no repositório de serviços
	 * @param servico Servico - serviço com os dados atualizados.
	 * @throws RepositorioException exceçao para tratamento de erros no repositorio.
	 * @throws ValorInvalidoException exceção para tratamento de valores invalidos.
	 * @throws ValorNaoEncontradoException exceção para tratamento de valores não encontrados.
	 */
	public void atualizarServico(Servico servico) throws RepositorioException, ValorInvalidoException, ValorNaoEncontradoException{
		this.nServico.atualizar(servico);
	}
	
	/**
	 * Metodo que realiza a compra de um produto, indicando a quantidade, por uma pessoa cadastrada. 
	 * @param CPF String - cpf do comprador
	 * @param ISBN String - ISBN do produto a ser comprado.
	 * @param quant int - quantidade de produtos a serem adqueridos.
	 * @throws RepositorioException exceçao para tratamento de erros no repositorio.
	 * @throws ValorNaoEncontradoException exceção para tratamento de valores não encontrados.
	 * @throws ValorInvalidoException exceção para tratamento de valores invalidos.
	 * @throws QuantidadeIndisponivelException excecao para tratamento de quantidade indisponivel.
	 */
	public void comprar(String CPF, String ISBN, int quant) throws RepositorioException, ValorNaoEncontradoException, ValorInvalidoException, QuantidadeIndisponivelException{
		Pessoa pessoa = this.nPessoa.procurar(CPF);
		Produto produto = this.nProduto.procurar(ISBN);
		if(quant > 0){
			if(produto.getDisponibilidade() >= quant){
				pessoa.adquerirProduto(produto, quant);
				produto.setDisponibilidade(quant);
				this.nPessoa.atualizar(pessoa);
				this.nProduto.atualizar(produto);
			} else {
				throw new QuantidadeIndisponivelException(produto.getDisponibilidade());
			}
		} else {
			throw new ValorInvalidoException("quantidade! É necessario adquerir ao menos 1");
		}
	}
	
	/**
	 * Metodo que adiciona um novo participante nos serviços oferecidos.
	 * @param CPF String - cpf do participante.
	 * @param codigo String - codigo do serviço que se deseja participar.
	 * @throws RepositorioException exceçao para tratamento de erros no repositorio.
	 * @throws ValorNaoEncontradoException exceção para tratamento de valores não encontrados.
	 * @throws ServicoJaRealizadoException exceção para tratamento de serviços lotados.
	 * @throws ValorJaCadastradoException exceção para tratamento de participantes ja cadastrados.
	 * @throws ServicoLotadoException exceção para serviços lotados.
	 * @throws ValorInvalidoException exceção para tratamento de valores invalidos.
	 */
	public void participar(String CPF, String codigo) throws RepositorioException, ValorNaoEncontradoException, ServicoJaRealizadoException, ValorJaCadastradoException, ServicoLotadoException, ValorInvalidoException{
		Pessoa pessoa = this.nPessoa.procurar(CPF);
		Servico servico = this.nServico.procurar(codigo);
		
		String data = new Date().toString();
		String meses = "Jan, Feb, Mar, Apr, May, Jun, Jul, Aug, Sep, Oct, Nov, Dec";
		int ano = Integer.parseInt(data.substring(data.length()-4));
		int mes = (meses.indexOf(data.substring(4, 7))+5)/5;
		int dia = Integer.parseInt(data.substring(8,10));
		if(ano > servico.getData().getAno()){
			throw new ServicoJaRealizadoException();
		} else if(ano == servico.getData().getAno() && mes > servico.getData().getMes()){
			throw new ServicoJaRealizadoException();
		} else if(ano == servico.getData().getAno() && mes == servico.getData().getMes() && dia > servico.getData().getDia()){
			throw new ServicoJaRealizadoException();
		} else if(ano == servico.getData().getAno() && mes == servico.getData().getMes() && dia == servico.getData().getDia() && data.substring(11,16).compareTo(servico.getHorario()) > 0){
			throw new ServicoJaRealizadoException();
		} else {
			if(servico instanceof Curso && pessoa instanceof Cliente){
				throw new ValorInvalidoException("participante! Apenas funcionários podem participar dos cursos");
			}
			String[] servicos = pessoa.getServicosAdquiridos();
			for(int i=0, len=pessoa.getIndiceServicos() ; i<len ; i++){
				if(servicos[i].equals(servico.getCodigo())){
					throw new ValorJaCadastradoException("Particiante");
				}
			}
			if(servico.getVagas() == servico.getVagasOcupadas()){
				throw new ServicoLotadoException();
			}
			pessoa.adquerirServico(servico);
			servico.adicionarPessoa(pessoa);
			this.nPessoa.atualizar(pessoa);
			this.nServico.atualizar(servico);
		}
	}
	
	/**
	 * Metodo que retorna uma string formatada com os dados da pessoa.
	 * @param CPF String - cpf da pessoa.
	 * @return String - dados da pessoa
	 * @throws RepositorioException exceçao para tratamento de erros no repositorio.
	 * @throws ValorNaoEncontradoException exceção para tratamento de valores não encontrados.
	 */
	public String descricaoPessoa(String CPF) throws RepositorioException, ValorNaoEncontradoException{
		Pessoa pessoa = this.nPessoa.procurar(CPF);
		
		String str = "Nome: " + pessoa.getNome() +
				 	 "\nCPF: " + pessoa.getCPF().substring(0, 3) + "." + pessoa.getCPF().substring(3, 6) + "." + 	//formatacao no padrao CPF
				 	 			 pessoa.getCPF().substring(6, 9) + "-" + pessoa.getCPF().substring(9,11) +
				 	 "\nEmail: " + pessoa.getEmail() +
				 	 //"\nSenha: " + pessoa.getSenha() +
				 	 "\nTelefone: (" + pessoa.getTelefone().substring(0, 2) + ") " + pessoa.getTelefone().substring(2, pessoa.getTelefone().length()-4) +
				 	 			   "-" + pessoa.getTelefone().substring(pessoa.getTelefone().length()-4, pessoa.getTelefone().length()) +
				 	 "\nSexo: ";
		if(pessoa.getSexo() == 'M'){
			str = str + "Masculino";
		} else {
			str = str + "Feminino";
		}
		str = str + "\nData de nascimento: " + pessoa.getData().toString() +
					"\nEndereço: \n" + pessoa.getEndereco().toString();
		
		if(pessoa instanceof Funcionario){
			str = str + "\nSalário: " + ((Funcionario)pessoa).getSalario() +
						"\nCargo: " + ((Funcionario)pessoa).getCargo().getNome() + 
						"\nHoras Semanais: " + ((Funcionario)pessoa).getHorasSemanais();
		}
		
		if(pessoa.getIndiceProdutos() != 0){
			str = str + "\n\nProduto(s) adquerido(s): Nome / ISBN / Quant / Total";
			String[] ISBNs = pessoa.getProdutosAdquiridos();
			double[] precos = pessoa.getPrecoProdutos();
			int[] quants = pessoa.getQuantProdutos();
			for(int i=0, len=pessoa.getIndiceProdutos() ; i<len ; i++){
				str = str + "\n\t" + (i+1) + "- ";
				try{
					str = str + this.nProduto.procurar(ISBNs[i]).getTitulo();
				} catch (ValorNaoEncontradoException e) {
					str = str + "produto removido!";
				}
				str = str +  " / " + ISBNs[i].substring(0,3) + "-" + ISBNs[i].charAt(3) + "-" +  ISBNs[i].substring(4, 6) + "-" +
									 ISBNs[i].substring(6, 12) + "-" + ISBNs[i].charAt(12) + " / " + quants[i] + " / " + precos[i];
			}
		}

		if(pessoa.getIndiceServicos() != 0){
			str = str + "\n\nServiços adqueridos: Nome / código";
			String[] codigos = pessoa.getServicosAdquiridos();
			for(int i=0, len=pessoa.getIndiceProdutos() ; i<len ; i++){
				str = str + "\n\t" + (i+1) + "- ";
				try{
					str = str + this.nServico.procurar(codigos[i]).getNome();
				} catch (ValorNaoEncontradoException e) {
					str = str + "serviço removido!";
				}
				str = str +  " / " + codigos[i];
			}
		}
		
		return str;
	}
	
	/**
	 * Metodo que retorna uma string formatada com os dados do produto.
	 * @param ISBN String - ISBN do produto.
	 * @return String - dados do produto
	 * @throws RepositorioException exceçao para tratamento de erros no repositorio.
	 * @throws ValorNaoEncontradoException exceção para tratamento de valores não encontrados.
	 */
	public String descricaoProduto(String ISBN) throws RepositorioException, ValorNaoEncontradoException{
		Produto produto = this.nProduto.procurar(ISBN);
		
		String str = "Título: " + produto.getTitulo() +
				 	 "\nISBN: " + produto.getISBN().substring(0,3) + "-" + produto.getISBN().charAt(3) + "-" + produto.getISBN().substring(4, 6) + "-" +
				 	 			  produto.getISBN().substring(6, 12) + "-" + produto.getISBN().charAt(12) + 
				 	 "\nPreco: " + produto.getPreco() + " reais" +
				 	 "\nAutor(es): " + produto.getAutor() +
				 	 "\nEditora: " + produto.getEditora() +
				 	 "\nEdiçao: " + produto.getEdicao() +
				 	 "\nAno: " + produto.getAno() +
				 	 "\nIdioma: " + produto.getIdioma().getNome();
		if(produto instanceof Livro){
			str = str + "\nQuantidade em estoque: " + ((Livro)produto).getQntdEstoque() +
						"\nNúmero de páginas: " + ((Livro)produto).getNPags() +
						"\nAcabamento: " + ((Livro)produto).getAcabamento().getNome() +
						"\nPeso: " + ((Livro)produto).getPeso() + " gramas" +
						"\nDimensões (CxLxA): " + ((Livro)produto).getAltura() + "x" + ((Livro)produto).getLargura() + "x" + ((Livro)produto).getComprimento();
		} else {
			str = str + "\nQuantidade de licensas: " + ((Ebook)produto).getQntdLicenca() +
						"\nTamanho: " + ((Ebook)produto).getTamanho() + "Kb" +
						"\nFormato: " + ((Ebook)produto).getFormato().getNome();
			
		}
		return str;
	}
	
	/**
	 * Metodo que retorna uma string formatada com os dados do servico.
	 * @param codigo String - código do serviço.
	 * @return String - dados do serviço
	 * @throws RepositorioException exceçao para tratamento de erros no repositorio.
	 * @throws ValorNaoEncontradoException exceção para tratamento de valores não encontrados.
	 */
	public String descricaoServico(String codigo) throws RepositorioException, ValorNaoEncontradoException{
		Servico servico = this.nServico.procurar(codigo);
		
		String str = "Nome: " + servico.getNome() +
					 "\nCódigo: " + servico.getCodigo() +
					 "\nTotal de vagas: " + servico.getVagas() +
					 "\nData: " + servico.getData().toString() + 
					 "\nHorário: " + servico.getHorario() + "\tDuração: " + servico.getDuracao() + "horas" +
					 "\nEndereço: \n" + servico.getEndereco().toString();
		if(servico instanceof Curso){
			Dia[] dias = ((Curso)servico).getDias();
			str = str + "\nProfessor: " + ((Curso)servico).getProfessor() +
						"\nCarga horária: " + ((Curso)servico).getCargaHoraria() +
						"\nDia(s) de aula: ";
			for(int i=0, len=dias.length ; i<len ; i++){
				str = str + dias[i].getAbreviatura() + "\t";
			}
		} else {
			str = str + "\nPalestrante: " + ((Palestra)servico).getPalestrante();
		}
		str = str + "\nNúmero de inscritos no serviço: " + servico.getVagasOcupadas();
		if(servico.getVagasOcupadas() != 0){
			str = str + "\nLista de participantes: nome / CPF ";
			String[] pessoas = servico.getPessoas();
			for(int i=0, len=servico.getVagasOcupadas() ; i<len ; i++){
				str = str + "\n\t" + (i+1) + "- ";
				try{
					str = str + this.nPessoa.procurar(pessoas[i]).getNome();
				} catch (ValorNaoEncontradoException e) {
					str = str + "Pessoa removida!";
				}
				str = str +  " / " + pessoas[i];
			}
		}
		return str;
	}
}
