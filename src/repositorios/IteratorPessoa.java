package repositorios;

import dados.Pessoa;

/**
 * Interface Iterator de Pessoa.
 * @author Lucas Alves Rufino e Miriane Silva Trajano do Nascimento.
 */
public interface IteratorPessoa {

	/**
	 * @return Retorna a próxima pessoa cadastrada no repositório.
	 */
	Pessoa next();
	
	/**
	 * Define se existe ou não uma próxima pessoa cadastrada no repositório.
	 * @return Retorna true - caso exista - false - caso não exista -.
	 */
	boolean hasNext();
}
