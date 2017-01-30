package repositorios;

import dados.Servico;
	
/**
 * Interface que define os repositorios de Pessoa.
 * @author Lucas Alves Rufino e Miriane Silva Trajano do Nascimento.
 */
public interface RepositorioServico {

	/**
	 * Método que insere serviços ao repositório. 
	 * @param servico Servico - Serviço que se deseja inserir ao repositório.
	 * @throws RepositorioException excecao para tratamento de erros do repositorio.
	 */
	void inserir(Servico servico) throws RepositorioException;
	
	/**
	 * Método que remove serviços do repostitório.
	 * @param codigo String - Código identificador do Serviço.
	 * @throws RepositorioException excecao para tratamento de erros do repositorio.
	 */
	void remover(String codigo) throws RepositorioException;
	
	/**
	 * Método que procura serviços no repositório.
	 * @param codigo String - Código identificador do Serviço.
	 * @return Servico - Serviço com o código informado.
	 * @throws RepositorioException excecao para tratamento de erros do repositorio.
	 */
	Servico procurar(String codigo) throws RepositorioException;
	
	/**
	 * Método que atualiza um dado serviço no repositório.
	 * @param servico Servico - Serviço atualizado.
	 * @throws RepositorioException excecao para tratamento de erros do repositorio.
	 */
	void atualizar(Servico servico) throws RepositorioException;
	
	/**
	 * Metodo que realiza o procedimento inicial de construcão da iteração.
	 * @throws RepositorioException excecao para tratamento de erros do repositorio.
	 */
	IteratorServico getIterator() throws RepositorioException;
}
