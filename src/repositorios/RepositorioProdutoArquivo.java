package repositorios;

import java.io.File;
import java.io.IOException;

import constantes.Acabamento;
import constantes.Formato;
import constantes.Idioma;
import dados.Livro;
import dados.Ebook;
import dados.Produto;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 * Repositório Arquivo de Produto.
 * @author Lucas Alves Rufino e Miriane Silva Trajano do Nascimento.
 */
public class RepositorioProdutoArquivo implements RepositorioProduto, IteratorProduto {
	
	private File file;					//arquivo do repositorio
	private WritableWorkbook workbook;	//workbook gravavel do repositorio
	private WritableSheet sheet;		//folha de trabalho do arquivo
	private int indice;					//indice de produtos no repositorio
	private Produto[] copia;			//array de copia de iteracao
	private int indiceCopia;			//indice do array para iteracao.
	
	/**
	 * Metodo que inicia os atributos do repositorio de arquivo de produtos
	 * @throws RepositorioException excecao para tratamento de erros do repositorio.
	 */
	public RepositorioProdutoArquivo() throws RepositorioException {
		try{
			this.file = new File("repositorioProduto.xls");
			if(!this.file.exists()){
				String[] captions = {"Título","ISBN","Preço","Autor","Editora","Edicao","Ano","Idioma","Quantidade em estoque","Número de Páginas",
									 "Acabamento","Peso","Altura","Largura","Comprimento","Quantidade de Licenças","Tamanho","Formato"};
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

	public void inserir(Produto produto) throws RepositorioException{
		try{
			this.workbook = Workbook.createWorkbook(this.file, Workbook.getWorkbook(this.file));
			this.sheet = this.workbook.getSheet(0);
			
			this.setProduto(produto, ++this.indice);
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
	
	public void remover(String ISBN) throws RepositorioException{
		try{
			this.workbook = Workbook.createWorkbook(this.file, Workbook.getWorkbook(this.file));
			this.sheet = this.workbook.getSheet(0);
			
			boolean achou = false;
			for(int i=1 ; i<=this.indice && !achou ; i++){
				if(sheet.getCell(2,i).getContents().equals(ISBN)){
					Produto produto = this.getProduto(this.indice);
					sheet.removeRow(i);
					sheet.insertRow(i);
					this.setProduto(produto, i);
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
	
	public Produto procurar(String ISBN) throws RepositorioException{
		try{
			this.workbook = Workbook.createWorkbook(this.file, Workbook.getWorkbook(this.file));
			this.sheet = this.workbook.getSheet(0);
			
			Produto produto = null;
			boolean achou = false;
			for(int i=1 ; i<=this.indice && !achou ; i++){
				if(sheet.getCell(2,i).getContents().equals(ISBN)){
					produto = this.getProduto(i);
					achou = true;
				}
			}
			
			workbook.write();
			workbook.close();
			return produto;
		} catch (IOException e) {
			throw new RepositorioException(e);
		} catch (WriteException e) {
			throw new RepositorioException(e);
		} catch (BiffException e) {
			throw new RepositorioException(e);
		}
	}
	
	public void atualizar(Produto produto) throws RepositorioException{
		try{
			this.workbook = Workbook.createWorkbook(this.file, Workbook.getWorkbook(this.file));
			this.sheet = this.workbook.getSheet(0);
			
			boolean achou = false;
			for(int i=1 ; i<=this.indice && !achou ; i++){
				if(sheet.getCell(2,i).getContents().equals(produto.getISBN())){
					sheet.removeRow(i);
					sheet.insertRow(i);
					this.setProduto(produto, i);
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
	
	public Produto next(){
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
	
	public IteratorProduto getIterator() throws RepositorioException{
		try{
			this.workbook = Workbook.createWorkbook(this.file, Workbook.getWorkbook(this.file));
			this.sheet = this.workbook.getSheet(0);
			
			this.copia = new Produto[this.indice];
			this.indiceCopia = 0;
			for(int i=1 ; i<=this.indice ; i++){
				this.copia[i-1] = this.getProduto(i);
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
	 * Metodo que adiciona um novo produto ao arquivo em um respectivo indice.
	 * @param produto Produto - produto a ser adicionado.
	 * @param indice int - posicao onde será adicionado.
	 * @throws RepositorioException excecao para tratamento de erros no repositorio.
	 */
	private void setProduto(Produto produto, int indice) throws RepositorioException {
		try{
			sheet.addCell(new  Label(1, indice, produto.getTitulo()));
			sheet.addCell(new  Label(2, indice, produto.getISBN()));
			sheet.addCell(new Number(3, indice, produto.getPreco()));
			sheet.addCell(new  Label(4, indice, produto.getAutor()));
			sheet.addCell(new  Label(5, indice, produto.getEditora()));
			sheet.addCell(new Number(6, indice, produto.getEdicao()));
			sheet.addCell(new Number(7, indice, produto.getAno()));
			sheet.addCell(new  Label(8, indice, produto.getIdioma().toString()));
			if(produto instanceof Livro){
				sheet.addCell(new Number(9,  indice,((Livro)produto).getQntdEstoque()));
				sheet.addCell(new Number(10, indice,((Livro)produto).getNPags()));
				sheet.addCell(new  Label(11, indice,((Livro)produto).getAcabamento().toString()));
				sheet.addCell(new Number(12, indice,((Livro)produto).getPeso()));
				sheet.addCell(new Number(13, indice,((Livro)produto).getAltura()));
				sheet.addCell(new Number(14, indice,((Livro)produto).getLargura()));
				sheet.addCell(new Number(15, indice,((Livro)produto).getComprimento()));
				sheet.addCell(new   Label(0, indice,"Livro"));
			} else {
				sheet.addCell(new Number(16, indice,((Ebook)produto).getQntdLicenca()));
				sheet.addCell(new Number(17, indice,((Ebook)produto).getTamanho()));
				sheet.addCell(new  Label(18, indice,((Ebook)produto).getFormato().toString()));
				sheet.addCell(new  Label(0,  indice,"Ebook"));
			}
		} catch (RowsExceededException e) {
			throw new RepositorioException(e);
		} catch (WriteException e) {
			throw new RepositorioException(e);
		}
	}
	
	/**
	 * Metodo que realiza a leitura de um produto segunto um determinado indice e o retorna.
	 * @param indice int - posicao no arquivo respectivo ao produto. 
	 * @return Produto - produto da respectiva posicao.
	 */
	private Produto getProduto(int indice) {
		Produto produto;
		String titulo = sheet.getCell(1, indice).getContents();
		String ISBN = sheet.getCell(2, indice).getContents();
		double preco = Double.parseDouble(sheet.getCell(3, indice).getContents().replace(',','.'));
		String autor = sheet.getCell(4, indice).getContents();
		String editora = sheet.getCell(5, indice).getContents();
		int edicao = Integer.parseInt(sheet.getCell(6, indice).getContents());
		int ano = Integer.parseInt(sheet.getCell(7, indice).getContents());
		Idioma idioma = Idioma.valueOf(sheet.getCell(8, indice).getContents());
		if(sheet.getCell(0, indice).getContents().equals("Livro")){
			int qntdEstoque = Integer.parseInt(sheet.getCell(9, indice).getContents());
			int nPags = Integer.parseInt(sheet.getCell(10, indice).getContents());
			Acabamento acabamento = Acabamento.valueOf(sheet.getCell(11, indice).getContents());
			double peso = Double.parseDouble(sheet.getCell(12, indice).getContents().replace(',','.'));
			double altura = Double.parseDouble(sheet.getCell(13, indice).getContents().replace(',','.'));
			double largura = Double.parseDouble(sheet.getCell(14, indice).getContents().replace(',','.'));
			double comprimento = Double.parseDouble(sheet.getCell(15, indice).getContents().replace(',','.'));
			produto = new Livro(titulo, ISBN, preco, autor, editora, edicao, ano, idioma, qntdEstoque, nPags,
								acabamento, peso, altura, largura, comprimento);
		} else {
			int qntdLicenca = Integer.parseInt(sheet.getCell(16, indice).getContents());
			double tamanho = Double.parseDouble(sheet.getCell(17, indice).getContents().replace(',','.'));
			Formato formato = Formato.valueOf(sheet.getCell(18, indice).getContents());
			produto = new Ebook(titulo, ISBN, preco, autor, editora, edicao, ano, idioma, qntdLicenca, tamanho, formato);
		}
		return produto;
	}
}
