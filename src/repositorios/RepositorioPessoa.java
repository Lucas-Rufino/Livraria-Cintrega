package repositorios;

import dados.Pessoa;

/**
 * Interface que define os repositorios de Pessoa.
 * @author Lucas Alves Rufino e Miriane Silva Trajano do Nascimento.
 */
public interface RepositorioPessoa {

	/**
	 * Insere uma Pessoa no repositório.
	 * @param pessoa Pessoa - Pessoa a ser inserida.
	 * @throws RepositorioException excecao para tratamento de erros do repositorio.
	 */
	void inserir(Pessoa pessoa) throws RepositorioException;
	
	/**
	 * Remove uma Pessoa no repositório.
	 * @param CPF String - Código identificador da Pessoa a ser removida.
	 * @throws RepositorioException excecao para tratamento de erros do repositorio.
	 */
	void remover(String CPF) throws RepositorioException;
	
	/**
	 * Procura uma Pessoa no repositório.
	 * @param CPF String - Código identificador da Pessoa que se deseja procurar.
	 * @return Pessoa - Pessoa com o CPF informado.
	 * @throws RepositorioException excecao para tratamento de erros do repositorio.
	 */
	Pessoa procurar(String CPF) throws RepositorioException;
	
	/**
	 * Atualiza as informações de uma Pessoa no repositório.
	 * @param pessoa Pessoa - Pessoa atualizada.
	 * @throws RepositorioException excecao para tratamento de erros do repositorio.
	 */
	void atualizar(Pessoa pessoa) throws RepositorioException;
	
	/**
	 * Metodo que realiza o procedimento inicial de construcão da iteração.
	 * @throws RepositorioException excecao para tratamento de erros no repositorio.
	 */
	IteratorPessoa getIterator() throws RepositorioException;
}
