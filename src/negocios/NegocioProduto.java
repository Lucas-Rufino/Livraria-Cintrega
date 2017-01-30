package negocios;

import java.util.Date;
import dados.Livro;
import dados.Ebook;
import dados.Produto;
import repositorios.RepositorioException;
import repositorios.RepositorioProduto;

/**
 * Classe que define o funcionamento do negocio relacionado a produtos.
 * @author Lucas Alves Rufino e Miriane Silva Trajano do Nascimento.
 */
public class NegocioProduto {

	private RepositorioProduto rep;		//repositorio de produtos
	
	/**
	 * Metodo que inicia os atributos da classe negocio de pessoa
	 * @param rep RepositorioProduto - repositorio de produto que ser� implementado no neg�cio.
	 */
	public NegocioProduto(RepositorioProduto rep){
		this.rep = rep;
	}
	
	/**
	 * Metodo que cadastra produtos no reposit�rio de produtos.
	 * @param produto Produto - novo produto a ser cadastrado.
	 * @throws RepositorioException exce�ao para tratamento de erros no repositorio.
	 * @throws ValorInvalidoException exce��o para tratamento de valores invalidos.
	 * @throws ValorJaCadastradoException exce��o para tratamento de valores ja cadastrados.
	 */
	public void cadastrar(Produto produto) throws RepositorioException, ValorInvalidoException, ValorJaCadastradoException{
		if(this.rep.procurar(produto.getISBN()) == null){
			this.validar(produto);
			this.rep.inserir(produto);
		} else {
			if(produto instanceof Livro){
				throw new ValorJaCadastradoException("Livro");
			} else {
				throw new ValorJaCadastradoException("Ebook");
			}
		}
	}
	
	/**
	 * Metodo que remove um produto do repositorio de produtos.
	 * @param ISBN String - ISBN do produto a ser removido.
	 * @throws RepositorioException exce��o para tratamento de erros no repositorio.
	 * @throws ValorNaoEncontradoException exce��o para tratamento de valores n�o encontrados.
	 */
	public void remover(String ISBN) throws RepositorioException, ValorNaoEncontradoException{
		if(this.rep.procurar(ISBN) != null){
			this.rep.remover(ISBN);
		} else {
			throw new ValorNaoEncontradoException("Produto");
		}
	}
	
	/**
	 * M�todo que procura por um produto no repositorio de produtos segundo um ISBN e o retorna.
	 * @param ISBN String - ISBN da pessoa.
	 * @return Produto - produto com o respectivo ISBN.
	 * @throws RepositorioException exce��o para tratamento de erros no repositorio.
	 * @throws ValorNaoEncontradoException exce��o para tratamento de valores n�o encontrados.
	 */
	public Produto procurar(String ISBN) throws RepositorioException, ValorNaoEncontradoException{
		Produto produto = this.rep.procurar(ISBN);
		if(produto == null){
			throw new ValorNaoEncontradoException("Produto");
		} else {
			return produto;
		}
	}
	
	/**
	 * M�todo que atualiza um produto presente no reposit�rio de produtos
	 * @param produto Produto - produto com os dados atualizados.
	 * @throws RepositorioException exce�ao para tratamento de erros no repositorio.
	 * @throws ValorInvalidoException exce��o para tramaneto de valores invalidos.
	 * @throws ValorNaoEncontradoException exce��o para tratamento de valores n�o encontrados.
	 */
	public void atualizar(Produto produto) throws RepositorioException, ValorInvalidoException, ValorNaoEncontradoException{
		if(this.rep.procurar(produto.getISBN()) != null){
			this.validar(produto);
			this.rep.atualizar(produto);
		} else {
			throw new ValorNaoEncontradoException("Produto");
		}
	}
	
	/**
	 * Metodo que valida os produtos a serem adicionadas ou atualizadas no repositorio.
	 * @param produto Produto - produto a ter atributos validados
	 * @throws ValorInvalidoException exce��o para tratamento de valores invalidos.
	 */
	private void validar(Produto produto) throws ValorInvalidoException{
		if(!produto.getISBN().matches("[0-9]{13}")){
			throw new ValorInvalidoException("ISBN");
		} else if(produto.getPreco() < 0){
			throw new ValorInvalidoException("pre�o");
		} else if(produto.getEdicao() <= 0){
			throw new ValorInvalidoException("edi��o");
		} else {
			String data = new Date().toString();
			if(produto.getAno() <= 0 || produto.getAno() > Integer.parseInt(data.substring(data.length()-4))){
				throw new ValorInvalidoException("ano");
			} else {
				if(produto instanceof Livro){
					if(((Livro)produto).getQntdEstoque() < 0){
						throw new ValorInvalidoException("quantidade em estoque");
					} else if(((Livro)produto).getNPags() <= 0){
						throw new ValorInvalidoException("n�mero de p�ginas");
					} else if(((Livro)produto).getPeso() <= 0){
						throw new ValorInvalidoException("peso");
					} else if(((Livro)produto).getAltura() <= 0){
						throw new ValorInvalidoException("altura");
					} else if(((Livro)produto).getLargura() <= 0){
						throw new ValorInvalidoException("largura");
					} else if(((Livro)produto).getComprimento() <= 0){
						throw new ValorInvalidoException("comprimento");
					}
				} else {
					if(((Ebook)produto).getQntdLicenca() < 0){
						throw new ValorInvalidoException("quantidade de licen�as");
					} else if(((Ebook)produto).getTamanho() <= 0){
						throw new ValorInvalidoException("tamanho");
					}
				}
			}
		}
	}
}
