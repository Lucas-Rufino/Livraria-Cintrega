package fachada;

/**
 * Classe que define a excecao para servicos lotados.
 * @author Lucas Alves Rufino
 */
public class ServicoLotadoException extends Exception {

	private static final long serialVersionUID = -2822402986901419092L;

	/**
	 * Metodo que inicia a excecao para servicos lotados.
	 */
	public ServicoLotadoException(){
		super("O serviço nao possui mais vagas disponíveis!");
	}
}
