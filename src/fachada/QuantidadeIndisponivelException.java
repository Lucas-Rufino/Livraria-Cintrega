package fachada;

/**
 * Classe de excecao para tratamento de valores indisponiveis.
 * @author Lucas Alves Rufino e Miriane Silva Trajano do Nascimento.
 */
public class QuantidadeIndisponivelException extends Exception {

	private static final long serialVersionUID = -823600921374544206L;

	/**
	 * Metodo construtor da excecao de quantidade indispon�vel.
	 * @param quant int - quantidade ainda disponivel a venda.
	 */
	public QuantidadeIndisponivelException(int quant){
		super("Quantidade indispon�vel para venda! Disponibilidade de : " + quant + " exemplar(es).");
	}
}
