package negocios;

import constantes.Dia;
import dados.Curso;
import dados.Servico;
import repositorios.RepositorioException;
import repositorios.RepositorioServico;

/**
 * Classe que define o funcionamento do negocio relacionado a servi�os.
 * @author Lucas Alves Rufino e Miriane Silva Trajano do Nascimento.
 */
public class NegocioServico {

	private RepositorioServico rep;		//Repositorio de servi�os
	
	/**
	 * Metodo que inicia os atributos da classe negocio de servi�os
	 * @param rep RepositorioServico - repositorio de servicos que ser� implementado no neg�cio.
	 */
	public NegocioServico(RepositorioServico rep){
		this.rep = rep;
	}
	
	/**
	 * Metodo que cadastra servicos no reposit�rio de servicos.
	 * @param servico Servico - novo servico a ser cadastrado.
	 * @throws RepositorioException exce�ao para tratamento de erros no repositorio.
	 * @throws ValorInvalidoException exce��o para tratamento de valores invalidos.
	 * @throws ValorJaCadastradoException exce��o para tratamento de valores ja cadastrados.
	 */
	public void cadastrar(Servico servico) throws RepositorioException, ValorInvalidoException, ValorJaCadastradoException{
		if(this.rep.procurar(servico.getCodigo()) == null){
			this.validar(servico);
			this.rep.inserir(servico);
		} else {
			if(servico instanceof Curso){
				throw new ValorJaCadastradoException("Curso");
			} else {
				throw new ValorJaCadastradoException("Palestra");
			}
		}
	}
	
	/**
	 * Metodo que remove um servico do repositorio de servicos.
	 * @param codigo String - c�digo do servi�o a ser removido.
	 * @throws RepositorioException exce��o para tratamento de erros no repositorio.
	 * @throws ValorNaoEncontradoException exce��o para tratamento de valores n�o encontrados.
	 */
	public void remover(String codigo) throws RepositorioException, ValorNaoEncontradoException{
		if(this.rep.procurar(codigo) != null){
			this.rep.remover(codigo);
		} else {
			throw new ValorNaoEncontradoException("Servi�o");
		}
	}
	
	/**
	 * M�todo que procura por um servico no repositorio de produtos segundo um codigo e o retorna.
	 * @param codigo String - codigo do servi�o.
	 * @return Servico - servico com o respectivo codigo.
	 * @throws RepositorioException exce��o para tratamento de erros no repositorio.
	 * @throws ValorNaoEncontradoException exce��o para tratamento de valores n�o encontrados.
	 */
	public Servico procurar(String codigo) throws RepositorioException, ValorNaoEncontradoException{
		Servico servico = this.rep.procurar(codigo);
		if(servico == null){
			throw new ValorNaoEncontradoException("Servico");
		} else {
			return servico;
		}
	}
	
	/**
	 * M�todo que atualiza um servico presente no reposit�rio de servicos
	 * @param servico Servico - servi�o com os dados atualizados.
	 * @throws RepositorioException exce�ao para tratamento de erros no repositorio.
	 * @throws ValorInvalidoException exce��o para tramaneto de valores invalidos.
	 * @throws ValorNaoEncontradoException exce��o para tratamento de valores n�o encontrados.
	 */
	public void atualizar(Servico servico) throws RepositorioException, ValorInvalidoException, ValorNaoEncontradoException{
		if(this.rep.procurar(servico.getCodigo()) != null){
			this.validar(servico);
			this.rep.atualizar(servico);
		} else {
			throw new ValorNaoEncontradoException("Servico");
		}
	}
	
	/**
	 * Metodo que valida os servi�os a serem adicionadas ou atualizadas no repositorio.
	 * @param servico Servico - servico a ter atributos validados
	 * @throws ValorInvalidoException exce��o para tratamento de valores invalidos.
	 */
	private void validar(Servico servico) throws ValorInvalidoException{
		if(!servico.getCodigo().matches("[0-9]{9}")){
			throw new ValorInvalidoException("c�digo");
		} else if(servico.getVagas() <= 0){
			throw new ValorInvalidoException("vagas");
		} else if(servico.getData().testar()){
			throw new ValorInvalidoException("data");
		} else if(!servico.getHorario().matches("([0-1][0-9]:[0-5][0-9])|(2[0-3]:[0-5][0-9])")){
			throw new ValorInvalidoException("hor�rio");
		} else {
			double duracao = servico.getDuracao();
			if(duracao <=0 || duracao > 4){
				throw new ValorInvalidoException("dura��o");
			} else if(servico instanceof Curso){
				Dia[] dias = ((Curso)servico).getDias();
				for(int i=0, len=dias.length ; i<len ; i++){
					if(i==0 && dias[i] == null){
						throw new ValorInvalidoException("dias! Marque um valor ao menos");
					} else if(dias[i] == null){
						throw new ValorInvalidoException("conjunto de dias da semana");
					}
				}
				double cargaHoraria = ((Curso)servico).getCargaHoraria();
				if(duracao*(dias.length-1) > cargaHoraria){
					throw new ValorInvalidoException("carga hor�ria");
				}
			}
		}
	}
}
