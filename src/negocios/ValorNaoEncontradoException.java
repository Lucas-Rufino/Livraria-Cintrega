package negocios;

/**
 * Classe de excecao para tratamento de valores nao encontrados.
 * @author Lucas Alves Rufino e Miriane Silva Trajano do Nascimento.
 * @category Exception
 */
public class ValorNaoEncontradoException extends Exception{

	private static final long serialVersionUID = 3409633957553676765L;

	/**
	 * Metodo construtor da excecao de valor nao encontrado.
	 * @param texto String - descricao do objeto que nao foi encontrado.
	 */
	public ValorNaoEncontradoException(String texto){
		super(texto + " não encontrad(o/a)!");
	}
}
