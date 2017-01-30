package repositorios;

import dados.Produto;

/**
 * Interface Iterator de Produto.
 * @author Lucas Alves Rufino e Miriane Silva Trajano do Nascimento.
 */
public interface IteratorProduto {
	
	/**
	 * @return Retorna o pr�ximo produto cadastrado no reposit�rio.
	 */
	Produto next();
	
	/**
	 * Define se existe ou n�o um pr�ximo produto cadastrado no reposit�rio.
	 * @return Retorna true - caso exista - false - caso n�o exista -.
	 */
	boolean hasNext();
}
