package repositorios;

import java.io.File;
import java.io.IOException;

import constantes.Dia;
import constantes.Estado;
import dados.Curso;
import dados.Data;
import dados.Endereco;
import dados.Palestra;
import dados.Servico;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 * Repositório Arquivo de Servico.
 * @author Lucas Alves Rufino e Miriane Silva Trajano do Nascimento.
 */
public class RepositorioServicoArquivo implements RepositorioServico, IteratorServico{

	private File file;					//arquivo do repositorio
	private WritableWorkbook workbook;	//workbook gravavel do repositorio
	private WritableSheet sheet;		//folha de trabalho do arquivo
	private int indice;					//indice de produtos no repositorio
	private Servico[] copia;			//array de copia de iteracao
	private int indiceCopia;			//indice do array para iteracao.
	
	/**
	 * Metodo que inicia os atributos do repositorio de arquivo de servicos
	 * @throws RepositorioException excecao para tratamento de erros do repositorio.
	 */
	public RepositorioServicoArquivo() throws RepositorioException {
		try{
			this.file = new File("repositorioServico.xls");
			if(!this.file.exists()){
				String[] captions = {"Nome","Código","Vagas","Dia","Mês","Ano","Horário","Duração","Logradouro","Número","Complemento","CEP",
					"Bairro","Cidade","Estado","Pais","Vagas Oculpadas","Descrição","Palestrante","Professor","Carga Horária", "Número de Dias"};
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
	
	public void inserir(Servico servico) throws RepositorioException{
		try{
			this.workbook = Workbook.createWorkbook(this.file, Workbook.getWorkbook(this.file));
			this.sheet = this.workbook.getSheet(0);
			
			this.setServico(servico, ++this.indice);
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
	
	public void remover(String codigo) throws RepositorioException{
		try{
			this.workbook = Workbook.createWorkbook(this.file, Workbook.getWorkbook(this.file));
			this.sheet = this.workbook.getSheet(0);
			
			boolean achou = false;
			for(int i=1 ; i<=this.indice && !achou ; i++){
				if(sheet.getCell(2,i).getContents().equals(codigo)){
					Servico servico = this.getServico(this.indice);
					sheet.removeRow(i);
					sheet.insertRow(i);
					this.setServico(servico, i);
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
	
	public Servico procurar(String codigo) throws RepositorioException{
		try{
			this.workbook = Workbook.createWorkbook(this.file, Workbook.getWorkbook(this.file));
			this.sheet = this.workbook.getSheet(0);
			
			Servico servico = null;
			boolean achou = false;
			for(int i=1 ; i<=this.indice && !achou ; i++){
				if(sheet.getCell(2,i).getContents().equals(codigo)){
					servico = this.getServico(i);
					achou = true;
				}
			}
			
			workbook.write();
			workbook.close();
			return servico;
		} catch (IOException e) {
			throw new RepositorioException(e);
		} catch (WriteException e) {
			throw new RepositorioException(e);
		} catch (BiffException e) {
			throw new RepositorioException(e);
		}
	}
	
	public void atualizar(Servico servico) throws RepositorioException{
		try{
			this.workbook = Workbook.createWorkbook(this.file, Workbook.getWorkbook(this.file));
			this.sheet = this.workbook.getSheet(0);
			
			boolean achou = false;
			for(int i=1 ; i<=this.indice && !achou ; i++){
				if(sheet.getCell(2,i).getContents().equals(servico.getCodigo())){
					sheet.removeRow(i);
					sheet.insertRow(i);
					this.setServico(servico, i);
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
	
	public Servico next(){
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
	
	public IteratorServico getIterator() throws RepositorioException{
		try{
			this.workbook = Workbook.createWorkbook(this.file, Workbook.getWorkbook(this.file));
			this.sheet = this.workbook.getSheet(0);
			
			this.copia = new Servico[this.indice];
			this.indiceCopia = 0;
			for(int i=1 ; i<=this.indice ; i++){
				this.copia[i-1] = this.getServico(i);
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
	 * Metodo que adiciona um novo servico ao arquivo em um respectivo indice.
	 * @param servico Servico - servico a ser adicionado.
	 * @param indice int - posicao onde será adicionado.
	 * @throws RepositorioException excecao para tratamento de erros no repositorio.
	 */
	private void setServico(Servico servico, int indice) throws RepositorioException {
		try{
			sheet.addCell(new   Label(1, indice, servico.getNome()));
			sheet.addCell(new   Label(2, indice, servico.getCodigo()));
			sheet.addCell(new  Number(3, indice, servico.getVagas()));
			sheet.addCell(new  Number(4, indice, servico.getData().getDia()));
			sheet.addCell(new  Number(5, indice, servico.getData().getMes()));
			sheet.addCell(new  Number(6, indice, servico.getData().getAno()));
			sheet.addCell(new   Label(7, indice, servico.getHorario()));
			sheet.addCell(new  Number(8, indice, servico.getDuracao()));
			sheet.addCell(new   Label(9, indice, servico.getEndereco().getLogradouro()));
			sheet.addCell(new Number(10, indice, servico.getEndereco().getNumero()));
			sheet.addCell(new  Label(11, indice, servico.getEndereco().getComplemento()));
			sheet.addCell(new  Label(12, indice, servico.getEndereco().getCEP()));
			sheet.addCell(new  Label(13, indice, servico.getEndereco().getBairro()));
			sheet.addCell(new  Label(14, indice, servico.getEndereco().getCidade()));
			sheet.addCell(new  Label(15, indice, servico.getEndereco().getEstado().toString()));
			sheet.addCell(new  Label(16, indice, servico.getEndereco().getPais()));
			sheet.addCell(new Number(17, indice, servico.getVagasOcupadas()));
			sheet.addCell(new  Label(18, indice, servico.getDescricao()));
			if(servico instanceof Palestra){
				sheet.addCell(new Label(19, indice,((Palestra)servico).getPalestrante()));
				sheet.addCell(new Label(0,  indice,"Palestra"));
			} else {
				sheet.addCell(new  Label(20, indice,((Curso)servico).getProfessor()));
				sheet.addCell(new Number(21, indice,((Curso)servico).getCargaHoraria()));
				sheet.addCell(new Number(22, indice,((Curso)servico).getDias().length));
				String[] str = servico.getPessoas();
				for(int i=0, len=servico.getVagasOcupadas() ; i<len ; i++){
					sheet.addCell(new Label(23+i, indice, str[i]));
				}
				int aux = 23 + servico.getVagasOcupadas();
				Dia[] dias = ((Curso)servico).getDias();
				for(int i=0, len=dias.length ; i<len ; i++){
					sheet.addCell(new  Label(aux+i, indice, dias[i].toString()));
				}
				sheet.addCell(new   Label(0, indice,"Curso"));
			}
		} catch (RowsExceededException e) {
			throw new RepositorioException(e);
		} catch (WriteException e) {
			throw new RepositorioException(e);
		}
	}
	
	/**
	 * Metodo que realiza a leitura de um servico segundo um determinado indice e o retorna.
	 * @param indice int - posicao no arquivo respectivo ao servico. 
	 * @return Servico - servico da respectiva posicao.
	 */
	private Servico getServico(int indice) {
		Servico servico;
		String nome = sheet.getCell(1, indice).getContents();
		String codigo = sheet.getCell(2, indice).getContents();
		int vagas = Integer.parseInt(sheet.getCell(3, indice).getContents());
		int dia = Integer.parseInt(sheet.getCell(4, indice).getContents());
		int mes = Integer.parseInt(sheet.getCell(5, indice).getContents());
		int ano = Integer.parseInt(sheet.getCell(6, indice).getContents());
		String horario = sheet.getCell(7, indice).getContents();
		double duracao = Double.parseDouble(sheet.getCell(8, indice).getContents().replace(',','.'));
		String logradouro = sheet.getCell(9, indice).getContents();
		int numero = Integer.parseInt(sheet.getCell(10, indice).getContents());
		String complemento = sheet.getCell(11, indice).getContents();
		String CEP = sheet.getCell(12, indice).getContents();
		String bairro = sheet.getCell(13, indice).getContents();
		String cidade = sheet.getCell(14, indice).getContents();
		Estado estado = Estado.valueOf(sheet.getCell(15, indice).getContents());
		String pais = sheet.getCell(16, indice).getContents();
		int vagasOcupadas = Integer.parseInt(sheet.getCell(17, indice).getContents());
		String descricao = sheet.getCell(18, indice).getContents();
		String[] pessoas = new String[vagasOcupadas];
		for(int i=0 ; i<vagasOcupadas ; i++){
			pessoas[i] = sheet.getCell(23+i, indice).getContents();
		}
		Data data = new Data(dia, mes, ano);
		Endereco endereco = new Endereco(logradouro, numero, complemento, CEP, bairro, cidade, estado, pais);
		
		if(sheet.getCell(0, indice).getContents().equals("Palestra")){
			String palestrante = sheet.getCell(19, indice).getContents();
			servico = new Palestra(nome, codigo, vagas, data, horario, duracao, endereco, pessoas, vagasOcupadas,
								   descricao, palestrante);
		} else {
			String professor = sheet.getCell(20, indice).getContents();
			double cargaHoraria = Double.parseDouble(sheet.getCell(21, indice).getContents().replace(',','.'));
			int auxNumero = Integer.parseInt(sheet.getCell(22, indice).getContents());
			Dia[] dias = new Dia[auxNumero];
			int aux = 23 + vagasOcupadas;
			for(int i=0 ; i<auxNumero ; i++){
				dias[i] = Dia.valueOf(sheet.getCell(aux+i, indice).getContents());
			}
			servico = new Curso(nome, codigo, vagas, data, horario, duracao, endereco, pessoas, vagasOcupadas,
								descricao, professor, cargaHoraria, dias);
		}
		return servico;
	}
}
