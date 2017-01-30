package repositorios;

import java.io.File;
import java.io.IOException;

import constantes.Cargo;
import constantes.Estado;
import dados.Cliente;
import dados.Data;
import dados.Endereco;
import dados.Funcionario;
import dados.Pessoa;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 * Repositório Arquivo de Pessoa.
 * @author Lucas Alves Rufino e Miriane Silva Trajano do Nascimento.
 */
public class RepositorioPessoaArquivo implements RepositorioPessoa, IteratorPessoa{

	private File file;					//arquivo do repositorio
	private WritableWorkbook workbook;	//workbook gravavel do repositorio
	private WritableSheet sheet;		//folha de trabalho do arquivo
	private int indice;					//indice de produtos no repositorio
	private Pessoa[] copia;				//array de copia de iteracao
	private int indiceCopia;			//indice do array para iteracao.
	
	/**
	 * Metodo que inicia os atributos do repositorio de arquivo de pessoas
	 * @throws RepositorioException excecao para tratamento de erros do repositorio.
	 */
	public RepositorioPessoaArquivo() throws RepositorioException {
		try{
			this.file = new File("repositorioPessoa.xls");
			if(!this.file.exists()){
				String[] captions = {"Nome","CPF","Email","Senha","Telefone","Sexo","Dia","Mes","Ano","Logradouro","Numero",
					"Complemento","CEP","Bairro","Cidade","Estado","Pais","N Produtos","N Servicos","salario","cargo","horas"};
				this.file.createNewFile();
				this.workbook = Workbook.createWorkbook(this.file);
				this.sheet = this.workbook.createSheet("page", 0);
				this.indice = 0;
				sheet.addCell(new Number(0, 0, this.indice));
				for(int i=0, len=captions.length ; i<len ; i++){
					sheet.addCell(new Label(i+1, 0, captions[i]));
				}
			} else {
				this.workbook = Workbook.createWorkbook(this.file, Workbook.getWorkbook(this.file));
				this.sheet = this.workbook.getSheet(0);
				this.indice = Integer.parseInt(sheet.getCell(0,0).getContents());
			}
			this.copia = null;
			this.indiceCopia = 0;
			workbook.write();
			workbook.close();
		} catch (IOException e) {
			throw new RepositorioException(e);
		} catch (RowsExceededException e) {
			throw new RepositorioException(e);
		} catch (WriteException e) {
			throw new RepositorioException(e);
		} catch (BiffException e) {
			throw new RepositorioException(e);
		}
	}
	
	public void inserir(Pessoa pessoa) throws RepositorioException {
		try{
			this.workbook = Workbook.createWorkbook(this.file, Workbook.getWorkbook(this.file));
			this.sheet = this.workbook.getSheet(0);
			
			this.setPessoa(pessoa, ++this.indice);
			sheet.addCell(new Number(0, 0, this.indice));
			
			workbook.write();
			workbook.close();
		} catch (IOException e) {
			throw new RepositorioException(e);
		} catch (RowsExceededException e) {
			throw new RepositorioException(e);
		} catch (WriteException e) {
			throw new RepositorioException(e);
		} catch (BiffException e) {
			throw new RepositorioException(e);
		}
	}
	
	public void remover(String CPF) throws RepositorioException {
		try{
			this.workbook = Workbook.createWorkbook(this.file, Workbook.getWorkbook(this.file));
			this.sheet = this.workbook.getSheet(0);
			
			boolean achou = false;
			for(int i=1 ; i<=this.indice && !achou ; i++){
				if(sheet.getCell(2,i).getContents().equals(CPF)){
					Pessoa pessoa = this.getPessoa(this.indice);
					sheet.removeRow(i);
					sheet.insertRow(i);
					this.setPessoa(pessoa, i);
					sheet.removeRow(this.indice);
					sheet.addCell(new Number(0, 0, --this.indice));
					achou = true;
				}
			}
			
			workbook.write();
			workbook.close();
		} catch (RowsExceededException e) {
			throw new RepositorioException(e);
		} catch (WriteException e) {
			throw new RepositorioException(e);
		} catch (IOException e) {
			throw new RepositorioException(e);
		} catch (BiffException e) {
			throw new RepositorioException(e);
		}
	}
	
	public Pessoa procurar(String CPF) throws RepositorioException {
		try{
			this.workbook = Workbook.createWorkbook(this.file, Workbook.getWorkbook(this.file));
			this.sheet = this.workbook.getSheet(0);
			
			Pessoa pessoa = null;
			boolean achou = false;
			for(int i=1 ; i<=this.indice && !achou ; i++){
				if(sheet.getCell(2,i).getContents().equals(CPF)){
					pessoa = this.getPessoa(i);
					achou = true;
				}
			}
			
			workbook.write();
			workbook.close();
			return pessoa;
		} catch (IOException e) {
			throw new RepositorioException(e);
		} catch (WriteException e) {
			throw new RepositorioException(e);
		} catch (BiffException e) {
			throw new RepositorioException(e);
		}
	}
	
	public void atualizar(Pessoa pessoa) throws RepositorioException {
		try{
			this.workbook = Workbook.createWorkbook(this.file, Workbook.getWorkbook(this.file));
			this.sheet = this.workbook.getSheet(0);
			
			boolean achou = false;
			for(int i=1 ; i<=this.indice && !achou ; i++){
				if(sheet.getCell(2,i).getContents().equals(pessoa.getCPF())){
					sheet.removeRow(i);
					sheet.insertRow(i);
					this.setPessoa(pessoa, i);
					achou = true;
				}
			}
			
			workbook.write();
			workbook.close();
		} catch (BiffException e) {
			throw new RepositorioException(e);
		} catch (IOException e) {
			throw new RepositorioException(e);
		} catch (RowsExceededException e) {
			throw new RepositorioException(e);
		} catch (WriteException e) {
			throw new RepositorioException(e);
		}
	}
	
	public Pessoa next(){
		return this.copia[this.indiceCopia++];
	}
	
	public boolean hasNext(){
		boolean resposta;
		if(this.indiceCopia >= this.copia.length || this.copia[this.indiceCopia] == null) {
			resposta = false;
		} else {
			resposta = true;
		}
		return resposta;
	}
	
	public IteratorPessoa getIterator() throws RepositorioException {
		try{
			this.workbook = Workbook.createWorkbook(this.file, Workbook.getWorkbook(this.file));
			this.sheet = this.workbook.getSheet(0);
			
			this.copia = new Pessoa[this.indice];
			this.indiceCopia = 0;
			for(int i=1 ; i<=this.indice ; i++){
				this.copia[i-1] = this.getPessoa(i);
			}
			
			workbook.write();
			workbook.close();
			
			return this;
		} catch (BiffException e) {
			throw new RepositorioException(e);
		} catch (IOException e) {
			throw new RepositorioException(e);
		} catch (WriteException e) {
			throw new RepositorioException(e);
		}
	}
	
	/**
	 * Metodo que adiciona uma nova pessoa ao arquivo em um respectivo indice.
	 * @param pessoa Pessoa - pessoa a ser adicionada.
	 * @param indice int - posicao onde será adicionada.
	 * @throws RepositorioException excecao para tratamento de erros no repositorio.
	 */
	private void setPessoa(Pessoa pessoa, int indice) throws RepositorioException {
		try{
			sheet.addCell(new   Label(1, indice, pessoa.getNome()));
			sheet.addCell(new   Label(2, indice, pessoa.getCPF()));
			sheet.addCell(new   Label(3, indice, pessoa.getEmail()));
			sheet.addCell(new   Label(4, indice, pessoa.getSenha()));
			sheet.addCell(new   Label(5, indice, pessoa.getTelefone()));
			sheet.addCell(new   Label(6, indice, pessoa.getSexo() + ""));
			sheet.addCell(new  Number(7, indice, pessoa.getData().getDia()));
			sheet.addCell(new  Number(8, indice, pessoa.getData().getMes()));
			sheet.addCell(new  Number(9, indice, pessoa.getData().getAno()));
			sheet.addCell(new  Label(10, indice, pessoa.getEndereco().getLogradouro()));
			sheet.addCell(new Number(11, indice, pessoa.getEndereco().getNumero()));
			sheet.addCell(new  Label(12, indice, pessoa.getEndereco().getComplemento()));
			sheet.addCell(new  Label(13, indice, pessoa.getEndereco().getCEP()));
			sheet.addCell(new  Label(14, indice, pessoa.getEndereco().getBairro()));
			sheet.addCell(new  Label(15, indice, pessoa.getEndereco().getCidade()));
			sheet.addCell(new  Label(16, indice, pessoa.getEndereco().getEstado().toString()));
			sheet.addCell(new  Label(17, indice, pessoa.getEndereco().getPais()));
			sheet.addCell(new Number(18, indice, pessoa.getIndiceProdutos()));
			sheet.addCell(new Number(19, indice, pessoa.getIndiceServicos()));
			if(pessoa instanceof Funcionario){
				sheet.addCell(new Number(20, indice,((Funcionario)pessoa).getSalario()));
				sheet.addCell(new  Label(21, indice,((Funcionario)pessoa).getCargo().toString()));
				sheet.addCell(new Number(22, indice,((Funcionario)pessoa).getHorasSemanais()));
				sheet.addCell(new   Label(0, indice,"Funcionario"));
			} else {
				sheet.addCell(new   Label(0, indice,"Cliente"));
			}
			String[] str = pessoa.getProdutosAdquiridos();
			double[] str2 = pessoa.getPrecoProdutos();
			int[] str3 = pessoa.getQuantProdutos();
			for(int i=0, len=pessoa.getIndiceProdutos() ; i<len ; i++){
				sheet.addCell(new  	Label(23+(i*3), indice, str[i]));
				sheet.addCell(new  Number(23+(i*3 + 1), indice, str2[i]));
				sheet.addCell(new  Number(23+(i*3 + 2), indice, str3[i]));
			}
			int aux = 23 + pessoa.getIndiceProdutos()*3;
			str = pessoa.getServicosAdquiridos();
			for(int i=0, len=pessoa.getIndiceServicos() ; i<len ; i++){
				sheet.addCell(new  Label(aux+i, indice, str[i]));
			}
		} catch (RowsExceededException e) {
			throw new RepositorioException(e);
		} catch (WriteException e) {
			throw new RepositorioException(e);
		}
	}
	
	/**
	 * Metodo que realiza a leitura de uma pessoa segundo um determinado indice e o retorna.
	 * @param indice int - posicao no arquivo respectivo a pessoa. 
	 * @return Pessoa - pessoa da respectiva posicao.
	 */
	private Pessoa getPessoa(int indice) {
		Pessoa pessoa;
		String nome = sheet.getCell(1, indice).getContents();
		String CPF = sheet.getCell(2, indice).getContents();
		String email = sheet.getCell(3, indice).getContents();
		String senha = sheet.getCell(4, indice).getContents();
		String telefone = sheet.getCell(5, indice).getContents();
		char sexo = sheet.getCell(6, indice).getContents().charAt(0);
		int dia = Integer.parseInt(sheet.getCell(7, indice).getContents());
		int mes = Integer.parseInt(sheet.getCell(8, indice).getContents());
		int ano = Integer.parseInt(sheet.getCell(9, indice).getContents());
		String logradouro = sheet.getCell(10, indice).getContents();
		int numero = Integer.parseInt(sheet.getCell(11, indice).getContents());
		String complemento = sheet.getCell(12, indice).getContents();
		String CEP = sheet.getCell(13, indice).getContents();
		String bairro = sheet.getCell(14, indice).getContents();
		String cidade = sheet.getCell(15, indice).getContents();
		Estado estado = Estado.valueOf(sheet.getCell(16, indice).getContents());
		String pais = sheet.getCell(17, indice).getContents();
		int indiceProdutos = Integer.parseInt(sheet.getCell(18, indice).getContents());
		int indiceServicos = Integer.parseInt(sheet.getCell(19, indice).getContents());
		
		String[] produtosAdquiridos = new String[indiceProdutos];
		double[] precoProdutos = new double[indiceProdutos];
		int[] quantProdutos = new int[indiceProdutos];
		for(int i=0 ; i<indiceProdutos ; i++){
			produtosAdquiridos[i] = sheet.getCell(23+(i*3), indice).getContents();
			precoProdutos[i] = Double.parseDouble(sheet.getCell(23+(i*3+1), indice).getContents().replace(',','.'));
			quantProdutos[i] = Integer.parseInt(sheet.getCell(23+(i*3+2), indice).getContents());
		}
		int aux = 23 + indiceProdutos*3;
		String[] servicosAdquiridos = new String[indiceServicos];
		for(int i=0 ; i<indiceServicos ; i++){
			servicosAdquiridos[i] = sheet.getCell(aux+i, indice).getContents();
		}
		Data data = new Data(dia, mes, ano);
		Endereco endereco = new Endereco(logradouro, numero, complemento, CEP, bairro, cidade, estado, pais);
		
		if(sheet.getCell(0, indice).getContents().equals("Funcionario")){
			double salario = Double.parseDouble(sheet.getCell(20, indice).getContents().replace(',','.'));
			Cargo cargo = Cargo.valueOf(sheet.getCell(21, indice).getContents());
			double horas = Double.parseDouble(sheet.getCell(22, indice).getContents().replace(',','.'));
			pessoa = new Funcionario(nome, CPF, email, senha, telefone, sexo, data, endereco, produtosAdquiridos,
					precoProdutos, quantProdutos, indiceProdutos, servicosAdquiridos, indiceServicos, salario,
					cargo, horas);
		} else {
			pessoa = new Cliente(nome, CPF, email, senha, telefone, sexo, data, endereco, produtosAdquiridos,
					precoProdutos, quantProdutos, indiceProdutos, servicosAdquiridos, indiceServicos);
		}
		return pessoa;
	}
}
