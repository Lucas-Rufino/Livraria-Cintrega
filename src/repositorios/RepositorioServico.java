package repositorios;

import dados.Servico;
	
/**
 * Interface que define os repositorios de Pessoa.
 * @author Lucas Alves Rufino e Miriane Silva Trajano do Nascimento.
 */
public interface RepositorioServico {

	/**
	 * M�todo que insere servi�os ao reposit�rio. 
	 * @param servico Servico - Servi�o que se deseja inserir ao reposit�rio.
	 * @throws RepositorioException excecao para tratamento de erros do repositorio.
	 */
	void inserir(Servico servico) throws RepositorioException;
	
	/**
	 * M�todo que remove servi�os do repostit�rio.
	 * @param codigo String - C�digo identificador do Servi�o.
	 * @throws RepositorioException excecao para tratamento de erros do repositorio.
	 */
	void remover(String codigo) throws RepositorioException;
	
	/**
	 * M�todo que procura servi�os no reposit�rio.
	 * @param codigo String - C�digo identificador do Servi�o.
	 * @return Servico - Servi�o com o c�digo informado.
	 * @throws RepositorioException excecao para tratamento de erros do repositorio.
	 */
	Servico procurar(String codigo) throws RepositorioException;
	
	/**
	 * M�todo que atualiza um dado servi�o no reposit�rio.
	 * @param servico Servico - Servi�o atualizado.
	 * @throws RepositorioException excecao para tratamento de erros do repositorio.
	 */
	void atualizar(Servico servico) throws RepositorioException;
	
	/**
	 * Metodo que realiza o procedimento inicial de construc�o da itera��o.
	 * @throws RepositorioException excecao para tratamento de erros do repositorio.
	 */
	IteratorServico getIterator() throws RepositorioException;
}
