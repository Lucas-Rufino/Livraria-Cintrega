package negocios;

/**
 * Classe de excecao para tratamento de valores ja cadastrados.
 * @author Lucas Alves Rufino e Miriane Silva Trajano do Nascimento.
 * @category Exception
 */
public class ValorJaCadastradoException extends Exception{

	private static final long serialVersionUID = -4689079662322936093L;

	/**
	 * Metodo construtor da excecao de valor ja cadastrado.
	 * @param texto String - descricao do objeto que ja foi cadastrado.
	 */
	public ValorJaCadastradoException(String texto){
		super(texto + " já cadastrad(o/a)!");
	}
	
}
