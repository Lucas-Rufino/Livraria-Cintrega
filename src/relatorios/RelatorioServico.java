package relatorios;

import java.io.Serializable;
import java.lang.Iterable;
import java.util.Iterator;
import java.util.Date;
import dados.Palestra;
import dados.Servico;
import repositorios.IteratorServico;

/**
 * Metodo que define o funcionamento do relatorio de serviço
 * @author Lucas Alves Rufino e Miriane Silva Trajano do Nascimento.
 */
public class RelatorioServico implements Iterable<String>, Iterator<String>, Serializable {
	
	private static final long serialVersionUID = 8336909863609250013L;
	
	private String[] relatorios;	//Relatorios produzidos
	private int indice;				//quantidade de relatorios produzidos
	private String[] copia;			//copia dos relatorios para iteração
	private int indiceCopia;		//indice de controle da copia.
	
	/**
	 * Metodo que inicia os atributos da classe do relatorio de serviço
	 */
	public RelatorioServico(){
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
	 * @param it IteratorServico - iterator do repositorio de serviços
	 */
	public void gerarRelatorio(IteratorServico it){
		Servico[] servicos = new Servico[10];
		int indice = 0;
		while(it.hasNext()){
			if(indice == servicos.length){
				Servico[] aux = servicos;
				servicos = new Servico[indice+10];
				for(int i=0 ; i<indice ; i++){
					servicos[i] = aux[i];
				}
			}
			servicos[indice++] = it.next();
		}
		
		for(int i=0 ; i<indice ; i++){
			for(int j=i+1 ; j<indice ; j++){
				if(servicos[i].getNome().compareToIgnoreCase(servicos[j].getNome()) > 0){
					Servico servico = servicos[i];
					servicos[i] = servicos[j];
					servicos[j] = servico;
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
		
		this.relatorios[this.indice] = "Relatório de serviços - número " + (this.indice+1) + " - Data de geração: " + new Date().toString() + "\nModelo: nome(ordem alfabética) / tipo\n";
		for(int i=0 ; i<indice ; i++){
			this.relatorios[this.indice] = this.relatorios[this.indice] + "\n" + (i+1) + "- " + servicos[i].getNome() + " / ";
			if(servicos[i] instanceof Palestra){
				this.relatorios[this.indice] = this.relatorios[this.indice] + "Palestra";
			} else {
				this.relatorios[this.indice] = this.relatorios[this.indice] + "Curso";
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
