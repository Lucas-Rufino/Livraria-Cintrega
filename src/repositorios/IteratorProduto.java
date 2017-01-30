package repositorios;

import dados.Produto;

/**
 * Interface Iterator de Produto.
 * @author Lucas Alves Rufino e Miriane Silva Trajano do Nascimento.
 */
public interface IteratorProduto {
	
	/**
	 * @return Retorna o próximo produto cadastrado no repositório.
	 */
	Produto next();
	
	/**
	 * Define se existe ou não um próximo produto cadastrado no repositório.
	 * @return Retorna true - caso exista - false - caso não exista -.
	 */
	boolean hasNext();
}
