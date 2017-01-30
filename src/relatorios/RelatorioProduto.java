package relatorios;

import java.io.Serializable;
import java.lang.Iterable;
import java.util.Iterator;
import java.util.Date;
import dados.Livro;
import dados.Produto;
import repositorios.IteratorProduto;

/**
 * Metodo que define o funcionamento do relatorio de produto
 * @author Lucas Alves Rufino e Miriane Silva Trajano do Nascimento.
 */
public class RelatorioProduto implements Iterable<String>, Iterator<String>, Serializable {
	
	private static final long serialVersionUID = -7106231864052649521L;
	
	private String[] relatorios;	//Relatorios produzidos
	private int indice;				//quantidade de relatorios produzidos
	private String[] copia;			//copia dos relatorios para iteração
	private int indiceCopia;		//indice de controle da copia.
	
	/**
	 * Metodo que inicia os atributos da classe do relatorio de produto
	 */
	public RelatorioProduto(){
		this.relatorios = new String[10];
		this.indice = 0;
		this.copia = new String[1];
		this.indiceCopia = 0;
	}
	
	//Metodos getters/////////////////////////////////////
	public int getIndice() {
		return this.indice;
	}
	
	public String[] getRelatorios() {
		return this.relatorios;
	}
	
	/**
	 * Metodo que gera um novo relatorio e o adiciona o conjunto de relatorios.
	 * @param it IteratorProduto - iterator do repositorio de produtos
	 */
	public void gerarRelatorio(IteratorProduto it){
		Produto[] produtos = new Produto[10];
		int indice = 0;
		while(it.hasNext()){
			if(indice == produtos.length){
				Produto[] aux = produtos;
				produtos = new Produto[indice+10];
				for(int i=0 ; i<indice ; i++){
					produtos[i] = aux[i];
				}
			}
			produtos[indice++] = it.next();
		}
		
		for(int i=0 ; i<indice ; i++){
			for(int j=i+1 ; j<indice ; j++){
				if(produtos[i].getDisponibilidade() < produtos[j].getDisponibilidade()){
					Produto produto = produtos[i];
					produtos[i] = produtos[j];
					produtos[j] = produto;
				}
			}
		}
		
		if(this.indice == this.relatorios.length){
			String[] aux = this.relatorios;
			this.relatorios = new String[this.indice + 10];
			for(int i=0 ; i<this.indice ; i++){
				this.relatorios[i] = aux[i];
			}
		}
		
		this.relatorios[this.indice] = "Relatório de produtos - número " + (this.indice+1) + " - Data de geração: " + new Date().toString() + "\nModelo: Disponibilidade(ordem decrescente) / Título / Tipo\n";
		for(int i=0 ; i<indice ; i++){
			this.relatorios[this.indice] = this.relatorios[this.indice] + "\n" + (i+1) + "- " + produtos[i].getDisponibilidade() + " / " + produtos[i].getTitulo() + " / ";
			if(produtos[i] instanceof Livro){
				this.relatorios[this.indice] = this.relatorios[this.indice] + "Livro";
			} else {
				this.relatorios[this.indice] = this.relatorios[this.indice] + "Ebook";
			}
		}
		
		this.indice++;
	}

	/**
	 * Metodo que inicia a iteração dos relatorios.
	 * @return Iterator<String> - iterator de string de relatorios.
	 */
	public Iterator<String> iterator() {
		this.copia = this.relatorios.clone();
		this.indiceCopia = 0;
		return this;
	}

	/**
	 * Metodo que retorna e existencia de um proximo item do relatorio ou nao.
	 * @return boolean - se true, existe proximo item, se false, não existe.
	 */
	public boolean hasNext() {
		boolean resposta;
		if(this.indiceCopia >= this.copia.length || this.copia[this.indiceCopia] == null) {
			resposta = false;
		} else {
			resposta = true;
		}
		return resposta;
	}

	/**
	 * metodo que retorna o proximo item do relatorio.
	 * @return String - item do relatorio.
	 */
	public String next() {
		return this.copia[this.indiceCopia++];
	}
}
