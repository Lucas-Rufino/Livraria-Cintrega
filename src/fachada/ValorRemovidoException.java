package fachada;

/**
 * Classe de excecao para tratamento de valores removidos.
 * @author Lucas Alves Rufino e Miriane Silva Trajano do Nascimento.
 */
public class ValorRemovidoException extends Exception {

	private static final long serialVersionUID = 6336045511935796529L;

	/**
	 * Metodo construtor da excecao de valores removidos.
	 * @param texto String - descricao do valor removido
	 */
	public ValorRemovidoException(String texto){
		super(texto + " removido/a!");
	}
}
