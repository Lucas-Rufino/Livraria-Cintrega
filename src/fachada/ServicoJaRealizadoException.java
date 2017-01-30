package fachada;

/**
 * Classe de excecao para tratamento de servi�os j� realizados.
 * @author Lucas Alves Rufino e Miriane Silva Trajano do Nascimento.
 */
public class ServicoJaRealizadoException extends Exception {

	private static final long serialVersionUID = 8073660345509463879L;

	/**
	 * Metodo construtor da excecao de servico j� realizado.
	 */
	public ServicoJaRealizadoException(){
		super("Este servi�o j� foi realizado ou est� em andamento. N�o � possivel se inscrever!");
	}
}
