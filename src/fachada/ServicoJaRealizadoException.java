package fachada;

/**
 * Classe de excecao para tratamento de serviços já realizados.
 * @author Lucas Alves Rufino e Miriane Silva Trajano do Nascimento.
 */
public class ServicoJaRealizadoException extends Exception {

	private static final long serialVersionUID = 8073660345509463879L;

	/**
	 * Metodo construtor da excecao de servico já realizado.
	 */
	public ServicoJaRealizadoException(){
		super("Este serviço já foi realizado ou está em andamento. Não é possivel se inscrever!");
	}
}
