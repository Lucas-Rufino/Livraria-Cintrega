package repositorios;

import dados.Servico;

/** 
 * Interface Iterator de Servico.
 * @author Lucas Alves Rufino e Miriane Silva Trajano do Nascimento.
 */
public interface IteratorServico {

	/**
	 * @return Retorna o pr�ximo servi�o cadastrado no reposit�rio.
	 */
	Servico next();
	
	/**
	 * Define se existe ou n�o um pr�ximo servi�o cadastrado no reposit�rio.
	 * @return Retorna true - caso exista - false - caso n�o exista -.
	 */
	boolean hasNext();
}
