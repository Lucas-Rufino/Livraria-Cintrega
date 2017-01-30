package relatorios;

import java.io.*;
import java.util.Iterator;

import negocios.ValorInvalidoException;
import repositorios.IteratorPessoa;
import repositorios.IteratorProduto;
import repositorios.IteratorServico;

public class RepositorioRelatorio{

	private RelatorioPessoa rPessoa;	//relatorio de pessoa
	private RelatorioProduto rProduto;	//relatorio de produtos
	private RelatorioServico rServico;	//relatorio de serviços
	
	private File file;						//arquivo com os dados serializados
	private FileInputStream input;			//controle de entrada de dados no programa
	private ObjectInputStream objInput;		//controle de entrada de objetos no programa
	private FileOutputStream output;		//controle de saida de dados no arquivo
	private ObjectOutputStream objOutput;	//controle de saida de objetos no arquivo
	
	/**
	 * Metodo que inicia os atributos da classe Repositorio relatorio.
	 */
	public RepositorioRelatorio(){
		try{
			this.file = new File("relatorios.ip");
			if(this.file.exists()){
				this.input = new FileInputStream(this.file);
				this.objInput = new ObjectInputStream(this.input);
				
				this.rPessoa = (RelatorioPessoa)this.objInput.readObject();
				this.rProduto = (RelatorioProduto)this.objInput.readObject();
				this.rServico = (RelatorioServico)this.objInput.readObject();
				
				this.objInput.close();
			} else {
				this.file.createNewFile();
				this.rPessoa = new RelatorioPessoa();
				this.rProduto = new RelatorioProduto();
				this.rServico = new RelatorioServico();
			}
		} catch (IOException e) {
			
		} catch (ClassNotFoundException e) {
			
		}
	}
	
	/**
	 * Metodo que gera um novo relatorio de pessoa
	 * @param it IteratorPessoa - iterator do repositorio de pessoa.
	 */
	public void gerarRelatorioPessoa(IteratorPessoa it){
		try {
			this.output = new FileOutputStream(this.file);
			this.objOutput = new ObjectOutputStream(this.output);
			
			this.rPessoa.gerarRelatorio(it);
			
			this.objOutput.writeObject(this.rPessoa);
			this.objOutput.writeObject(this.rProduto);
			this.objOutput.writeObject(this.rServico);
			
			this.objOutput.close();
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		}
	}
	
	/**
	 * Metodo que gera um novo relatorio de produto
	 * @param it IteratorProduto - iterator do repositorio de produto.
	 */
	public void gerarRelatorioProduto(IteratorProduto it){
		try {
			this.output = new FileOutputStream(this.file);
			this.objOutput = new ObjectOutputStream(this.output);
			
			this.rProduto.gerarRelatorio(it);
			
			this.objOutput.writeObject(this.rPessoa);
			this.objOutput.writeObject(this.rProduto);
			this.objOutput.writeObject(this.rServico);
			
			this.objOutput.close();
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		}
	}
	
	/**
	 * Metodo que gera um novo relatorio de servico
	 * @param it IteratorServico - iterator do repositorio de servico.
	 */
	public void gerarRelatorioServico(IteratorServico it){
		try {
			this.output = new FileOutputStream(this.file);
			this.objOutput = new ObjectOutputStream(this.output);
			
			this.rServico.gerarRelatorio(it);
			
			this.objOutput.writeObject(this.rPessoa);
			this.objOutput.writeObject(this.rProduto);
			this.objOutput.writeObject(this.rServico);
			
			this.objOutput.close();
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		}
	}
	
	/**
	 * Metodo que retorna a iteração do relatorio de pessoa
	 * @return Iterator<String> - iteração do relatorio.
	 */
	public Iterator<String> IteratorRelatorioPessoa(){
		return this.rPessoa.iterator();
	}
	
	/**
	 * Metodo que retorna a iteração do relatorio de produto
	 * @return Iterator<String> - iteração do relatorio.
	 */
	public Iterator<String> IteratorRelatorioProduto(){
		return this.rProduto.iterator();
	}
	
	/**
	 * Metodo que retorna a iteração do relatorio de produto
	 * @return Iterator<String> - iteração do relatorio.
	 */
	public Iterator<String> IteratorRelatorioServico(){
		return this.rServico.iterator();
	}
	
	/**
	 * Metodo que retorna um relatorio segundo um respectivo número
	 * @param numero int - numero do relatorio desejado
	 * @return String - respectivo relatorio.
	 * @throws ValorInvalidoException excecao para tratamento de valores invalidos
	 */
	public String puxarRelatorioPessoa(int numero) throws ValorInvalidoException{
		if(numero > 0 && numero <= this.rPessoa.getIndice()){
			return this.rPessoa.getRelatorios()[numero-1];
		} else {
			throw new ValorInvalidoException("Número do Relatório");
		}
	}
	
	/**
	 * Metodo que retorna um relatorio segundo um respectivo número
	 * @param numero int - numero do relatorio desejado
	 * @return String - respectivo relatorio.
	 * @throws ValorInvalidoException excecao para tratamento de valores invalidos
	 */
	public String puxarRelatorioProduto(int numero) throws ValorInvalidoException{
		if(numero > 0 && numero <= this.rProduto.getIndice()){
			return this.rProduto.getRelatorios()[numero-1];
		} else {
			throw new ValorInvalidoException("Número do Relatório");
		}
	}
	
	/**
	 * Metodo que retorna um relatorio segundo um respectivo número
	 * @param numero int - numero do relatorio desejado
	 * @return String - respectivo relatorio.
	 * @throws ValorInvalidoException excecao para tratamento de valores invalidos
	 */
	public String puxarRelatorioServico(int numero) throws ValorInvalidoException{
		if(numero > 0 && numero <= this.rServico.getIndice()){
			return this.rServico.getRelatorios()[numero-1];
		} else {
			throw new ValorInvalidoException("Número do Relatório");
		}
	}
	
	/**
	 * Metodo que retorna o último relatorio produzido do respectivo tipo.
	 * @return String - último relatório produzido.
	 * @throws ValorInvalidoException excecao para tratamento de valores invalidos
	 */
	public String puxarUltimoRelatorioPessoa() throws ValorInvalidoException{
		return this.puxarRelatorioPessoa(this.rPessoa.getIndice());
	}
	
	/**
	 * Metodo que retorna o último relatorio produzido do respectivo tipo.
	 * @return String - último relatório produzido.
	 * @throws ValorInvalidoException excecao para tratamento de valores invalidos
	 */
	public String puxarUltimoRelatorioProduto() throws ValorInvalidoException{
		return this.puxarRelatorioProduto(this.rProduto.getIndice());
	}
	
	/**
	 * Metodo que retorna o último relatorio produzido do respectivo tipo.
	 * @return String - último relatório produzido.
	 * @throws ValorInvalidoException excecao para tratamento de valores invalidos
	 */
	public String puxarUltimoRelatorioServico() throws ValorInvalidoException{
		return this.puxarRelatorioServico(this.rServico.getIndice());
	}
}
