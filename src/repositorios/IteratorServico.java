package repositorios;

import dados.Servico;

/** 
 * Interface Iterator de Servico.
 * @author Lucas Alves Rufino e Miriane Silva Trajano do Nascimento.
 */
public interface IteratorServico {

	/**
	 * @return Retorna o próximo serviço cadastrado no repositório.
	 */
	Servico next();
	
	/**
	 * Define se existe ou não um próximo serviço cadastrado no repositório.
	 * @return Retorna true - caso exista - false - caso não exista -.
	 */
	boolean hasNext();
}
