package negocios;

import java.util.Date;
import dados.Funcionario;
import dados.Pessoa;
import repositorios.RepositorioException;
import repositorios.RepositorioPessoa;

/**
 * Classe que define o funcionamento do negocio relacionado a pessoas.
 * @author Lucas Alves Rufino e Miriane Silva Trajano do Nascimento.
 */
public class NegocioPessoa {

	private RepositorioPessoa rep;	//repositorio de pessoas
	
	/**
	 * Metodo que inicia os atributos da classe negocio de pessoa
	 * @param rep RepositorioPessoa - repositorio de pessoa que será implementado no negócio.
	 */
	public NegocioPessoa(RepositorioPessoa rep){
		this.rep = rep;
	}
	
	/**
	 * Metodo que cadastra pessoas no repositório de pessoas.
	 * @param pessoa Pessoa - nova pessoa a ser cadastrada.
	 * @throws RepositorioException exceçao para tratamento de erros no repositorio.
	 * @throws ValorInvalidoException exceção para tramaneto de valores invalidos.
	 * @throws ValorJaCadastradoException exceção para tratamento de valores ja cadastrados.
	 */
	public void cadastrar(Pessoa pessoa) throws RepositorioException, ValorInvalidoException, ValorJaCadastradoException{
		if(this.rep.procurar(pessoa.getCPF()) == null){
			this.validar(pessoa);
			this.rep.inserir(pessoa);
		} else {
			if(pessoa instanceof Funcionario){
				throw new ValorJaCadastradoException("Funcionário");
			} else {
				throw new ValorJaCadastradoException("Cliente");
			}
		}
	}
	
	/**
	 * Metodo que remove uma pessoa do repositorio de pessoas.
	 * @param CPF String - cpf da pessoa a ser removida.
	 * @throws RepositorioException exceção para tratamento de erros no repositorio.
	 * @throws ValorNaoEncontradoException exceção para tratamento de valores não encontrados.
	 */
	public void remover(String CPF) throws RepositorioException, ValorNaoEncontradoException{
		if(this.rep.procurar(CPF) != null){
			this.rep.remover(CPF);
		} else {
			throw new ValorNaoEncontradoException("Pessoa");
		}
	}
	
	/**
	 * Método que procura por um pessoa no repositorio de pessoas segundo um CPF e o retorna.
	 * @param CPF String - CPF da pessoa.
	 * @return Pessoa - Pessoa com o respectivo CPF.
	 * @throws RepositorioException exceção para tratamento de erros no repositorio.
	 * @throws ValorNaoEncontradoException exceção para tratamento de valores não encontrados.
	 */
	public Pessoa procurar(String CPF) throws RepositorioException, ValorNaoEncontradoException{
		Pessoa pessoa = this.rep.procurar(CPF);
		if(pessoa == null){
			throw new ValorNaoEncontradoException("Pessoa");
		} else {
			return pessoa;
		}
	}
	
	/**
	 * Método que atualiza uma pessoa presente no repositório de pessoas
	 * @param pessoa Pessoa - pessoa com os dados atualizados.
	 * @throws RepositorioException exceçao para tratamento de erros no repositorio.
	 * @throws ValorInvalidoException exceção para tramaneto de valores invalidos.
	 * @throws ValorNaoEncontradoException exceção para tratamento de valores não encontrados.
	 */
	public void atualizar(Pessoa pessoa) throws RepositorioException, ValorInvalidoException, ValorNaoEncontradoException{
		if(this.rep.procurar(pessoa.getCPF()) != null){
			this.validar(pessoa);
			this.rep.atualizar(pessoa);
		} else {
			throw new ValorNaoEncontradoException("Pessoa");
		}
	}
	
	/**
	 * Metodo que valida as pessoas a serem adicionadas ou atualizadas no repositorio.
	 * @param pessoa Pessoa - pessoa a ter atributos validados
	 * @throws ValorInvalidoException exceção para tratamento de valores invalidos.
	 */
	private void validar(Pessoa pessoa) throws ValorInvalidoException{
		if(!pessoa.getCPF().matches("[0-9]{11}")){
			throw new ValorInvalidoException("CPF");
		} else if(!pessoa.getEmail().matches("^[A-Za-z]{1}[_A-Za-z0-9-]*(\\.[_A-Za-z0-9-]+)*@[a-z]+(\\.[a-z]+)+$")){
			throw new ValorInvalidoException("email");
		} else if(!pessoa.getTelefone().matches("[0-9]{10,11}")){
			throw new ValorInvalidoException("telefone");
		} else if(pessoa.getSexo() != 'M' && pessoa.getSexo() != 'F'){
			throw new ValorInvalidoException("sexo");
		} else if(pessoa.getData().testar()){
			throw new ValorInvalidoException("data");
		} else {
			String data = new Date().toString();
			String meses = "Jan, Feb, Mar, Apr, May, Jun, Jul, Aug, Sep, Oct, Nov, Dec";
			int ano = Integer.parseInt(data.substring(data.length()-4));
			int mes = (meses.indexOf(data.substring(4, 7))+5)/5;
			int dia = Integer.parseInt(data.substring(8,10));
			if(ano < pessoa.getData().getAno()){
				throw new ValorInvalidoException("data");
			} else if(ano == pessoa.getData().getAno() && mes < pessoa.getData().getMes()){
				throw new ValorInvalidoException("data");
			} else if(ano == pessoa.getData().getAno() && mes == pessoa.getData().getMes() && dia < pessoa.getData().getDia()){
				throw new ValorInvalidoException("data");
			} else if(pessoa.getEndereco().getNumero() <= 0){
				throw new ValorInvalidoException("número do endereço");
			} else if(!pessoa.getEndereco().getCEP().matches("[0-9]{8}")){
				throw new ValorInvalidoException("CEP do endereço");
			} else if(pessoa instanceof Funcionario){
				if(((Funcionario)pessoa).getSalario() < 0){
					throw new ValorInvalidoException("salário");
				} else{
					double horas = ((Funcionario)pessoa).getHorasSemanais();
					if(horas < 20 || horas > 40){
						throw new ValorInvalidoException("horas semanais");
					}
				}
			}
		}
	}
}
