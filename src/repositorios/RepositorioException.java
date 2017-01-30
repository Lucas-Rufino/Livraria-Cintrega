package repositorios;

/**
 * Classe para tratamento da excecao repositorio.
 * @author Lucas Alves Rufino e Miriane Silva Trajano do Nascimento.
 */
public class RepositorioException extends Exception {

	private static final long serialVersionUID = -6467975113873353890L;
	private Throwable exception;

	/**
	 * Metodo que inicia a os atributos da excecao.
	 */
	public RepositorioException(Throwable exception){
		this.exception = exception;
	}
	
	/**
	 * Metodo que retorma a mensagem repectiva ao erro levantado.
	 */
	public String getMessage(){
		return this.exception.getMessage();
	}
}
