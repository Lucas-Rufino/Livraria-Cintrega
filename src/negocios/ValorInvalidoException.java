package negocios;

/**
 * Classe de excecao para tratamento de valores invalidos.
 * @author Lucas Alves Rufino e Miriane Silva Trajano do Nascimento.
 */
public class ValorInvalidoException extends Exception {

	private static final long serialVersionUID = 279391181865779527L;

	/**
	 * Metodo construtor da excecao de valor invalido.
	 * @param texto String - descricao da variavel que receberia o valor invalido.
	 */
	public ValorInvalidoException(String texto){
		super("Valor invalido para " + texto + "!");
	}
}
