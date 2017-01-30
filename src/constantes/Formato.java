package constantes;

/**
 * Enumeração que define os formatos de ebooks.
 * @author Lucas Alves Rufino e Miriane Silva Trajano do Nascimento.
 */
public enum Formato {

	//Fonte da pesquisa - https://pt.wikipedia.org/wiki/Livro_digital
	AZW (".azw"),
	BBEB (".bbeb"),
	CBR (".cbr"),
	CBZ (".cbz"),
	CHM (".chm"),
	DJVU (".djvu"),
	DOC (".doc"),
	DOCX (".docx"),
	DRM (".drm"),
	EPUB (".epub"),
	FB2 (".fb2"),
	HTM (".htm"),
	HTML (".html"),
	IBA (".iba"),
	LIT (".lit"),
	MOBI (".mobi"),
	ODF (".odf"),
	PDF (".pdf"),
	PRC (".prc"),
	PRS (".prs"),
	RTF (".rtf"),
	TCR (".tcr"),
	TXT (".txt"),
	OUTROS ("Outros");
	
	private String nome;	//nome do formato.
	
	/**
	 * Metodo construtor para atribuição dos valores da enumeração.
	 * @param nome String - nome do formato.
	 */
	private Formato(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Metodo que retorna a representação textual do nome do formato
	 * @return String - nome do formato.
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Metodo que retorna um array de String com os nomes dos formatos da enumeracao.
	 * @return String[] - nomes dos formatos.
	 */
	public static String[] getFormatos(){
		Formato[] formatos = values();
		String[] nomes = new String[formatos.length];		
		for(int i=0, len=formatos.length ; i<len ; i++){	//varre o array de enumeracao.
			nomes[i] = formatos[i].getNome();			//aplica os nomes nos array de string.
		}
		return nomes;
	}
	
	/**
	 * Metodo que recebe um numero e retorna a enumeracao respectiva a esse numero.
	 * @param number int - numero do indice de enumeraçoes
	 * @return Formato - enumeração respectiva ao valor.
	 */
	public static Formato seletor(int number){
		return values()[number];
	}
}
