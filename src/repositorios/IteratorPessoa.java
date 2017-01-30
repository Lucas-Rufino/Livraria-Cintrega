package repositorios;

import dados.Pessoa;

/**
 * Interface Iterator de Pessoa.
 * @author Lucas Alves Rufino e Miriane Silva Trajano do Nascimento.
 */
public interface IteratorPessoa {

	/**
	 * @return Retorna a pr�xima pessoa cadastrada no reposit�rio.
	 */
	Pessoa next();
	
	/**
	 * Define se existe ou n�o uma pr�xima pessoa cadastrada no reposit�rio.
	 * @return Retorna true - caso exista - false - caso n�o exista -.
	 */
	boolean hasNext();
}
