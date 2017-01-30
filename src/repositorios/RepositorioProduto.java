package repositorios;

import dados.Produto;
	
/**
 * Interface que define os repositorios de Produto.
 * @author Lucas Alves Rufino e Miriane Silva Trajano do Nascimento.
 */
public interface RepositorioProduto {

	/**
	 * M�todo que insere produtos ao reposit�rio.
	 * @param produto Produto - Produto a ser inserido.
	 * @throws RepositorioException excecao para tratamento de erros do repositorio.
	 */
	void inserir(Produto produto) throws RepositorioException;
	
	/**
	 * M�todo que remove produtos do repostit�rio.
	 * @param ISBN String - ISBN do produto a ser removido.
	 * @throws RepositorioException excecao para tratamento de erros do repositorio.
	 */
	void remover(String ISBN) throws RepositorioException;
	
	/**
	 * M�todo que procura Produtos no reposit�rio.
	 * @param ISBN String - ISBN do produto a ser procurado.
	 * @return Produto armazenado com o ISBN informado - caso exista -, null - caso n�o exista-.
	 * @throws RepositorioException excecao para tratamento de erros do repositorio.
	 */
	Produto procurar(String ISBN) throws RepositorioException;
	
	/**
	 * M�todo que atualiza um dado Produto no reposit�rio.
	 * @param produto Produto - Produto atualizado.
	 * @throws RepositorioException excecao para tratamento de erros do repositorio.
	 */
	void atualizar(Produto produto) throws RepositorioException;
	
	/**
	 * Metodo que realiza o procedimento inicial de construc�o da itera��o.
	 * @throws RepositorioException excecao para tratamento de erros do repositorio.
	 */
	IteratorProduto getIterator() throws RepositorioException;
}
