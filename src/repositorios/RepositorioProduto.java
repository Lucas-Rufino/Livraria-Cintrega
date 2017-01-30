package repositorios;

import dados.Produto;
	
/**
 * Interface que define os repositorios de Produto.
 * @author Lucas Alves Rufino e Miriane Silva Trajano do Nascimento.
 */
public interface RepositorioProduto {

	/**
	 * Método que insere produtos ao repositório.
	 * @param produto Produto - Produto a ser inserido.
	 * @throws RepositorioException excecao para tratamento de erros do repositorio.
	 */
	void inserir(Produto produto) throws RepositorioException;
	
	/**
	 * Método que remove produtos do repostitório.
	 * @param ISBN String - ISBN do produto a ser removido.
	 * @throws RepositorioException excecao para tratamento de erros do repositorio.
	 */
	void remover(String ISBN) throws RepositorioException;
	
	/**
	 * Método que procura Produtos no repositório.
	 * @param ISBN String - ISBN do produto a ser procurado.
	 * @return Produto armazenado com o ISBN informado - caso exista -, null - caso não exista-.
	 * @throws RepositorioException excecao para tratamento de erros do repositorio.
	 */
	Produto procurar(String ISBN) throws RepositorioException;
	
	/**
	 * Método que atualiza um dado Produto no repositório.
	 * @param produto Produto - Produto atualizado.
	 * @throws RepositorioException excecao para tratamento de erros do repositorio.
	 */
	void atualizar(Produto produto) throws RepositorioException;
	
	/**
	 * Metodo que realiza o procedimento inicial de construcão da iteração.
	 * @throws RepositorioException excecao para tratamento de erros do repositorio.
	 */
	IteratorProduto getIterator() throws RepositorioException;
}
