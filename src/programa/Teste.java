package programa;

import constantes.Estado;
import constantes.Cargo;
import constantes.Dia;
import constantes.Idioma;
import constantes.Acabamento;
import constantes.Formato;
import dados.Pessoa;
import dados.Produto;
import dados.Servico;
import dados.Ebook;
import dados.Livro;
import dados.Cliente;
import dados.Funcionario;
import dados.Curso;
import dados.Palestra;
import dados.Data;
import dados.Endereco;
import fachada.Fachada;
import fachada.QuantidadeIndisponivelException;
import java.util.Scanner;
import negocios.ValorInvalidoException;
import negocios.ValorJaCadastradoException;
import negocios.ValorNaoEncontradoException;
import repositorios.RepositorioException;
import repositorios.RepositorioPessoa;
import repositorios.RepositorioPessoaArquivo;
import repositorios.RepositorioPessoaArray;
import repositorios.RepositorioPessoaLista;
import repositorios.RepositorioProduto;
import repositorios.RepositorioProdutoArquivo;
import repositorios.RepositorioProdutoArray;
import repositorios.RepositorioProdutoLista;
import repositorios.RepositorioServico;
import repositorios.RepositorioServicoArquivo;
import repositorios.RepositorioServicoArray;
import repositorios.RepositorioServicoLista;

public class Teste {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		Pessoa cliente = null, funcionario = null;
		Produto ebook = null, livro = null;
		Servico curso = null, palestra = null;
		Data dataC = null, dataF = null, dataS = null;
		Endereco endereco = null;
		RepositorioPessoa repPes = null;
		RepositorioProduto repPro = null;
		RepositorioServico repSer = null;
		Fachada fachada = null;
		String op1;
		int i = 1;
		
		try {
			System.out.println("Escolha o tipo de repositório: \n1. Array \n2. Lista \n3. Arquivo");
			op1 = input.nextLine();
			
			if(op1.length() > 1 || !op1.equals("1") && !op1.equals("2") && !op1.equals("3")) {
				throw new ValorInvalidoException("Entrada");
			} else if(op1.equals("1")) {
				repPes = new RepositorioPessoaArray();
				repPro = new RepositorioProdutoArray();
				repSer = new RepositorioServicoArray();
			} else if(op1.equals("2")) {
				repPes = new RepositorioPessoaLista();
				repPro = new RepositorioProdutoLista();
				repSer = new RepositorioServicoLista();
			} else if(op1.equals("3")) {
				repPes = new RepositorioPessoaArquivo();
				repPro = new RepositorioProdutoArquivo();
				repSer = new RepositorioServicoArquivo();
			}
			
			fachada = new Fachada(repPes, repPro, repSer);
		} catch (ValorInvalidoException e) {
			System.out.println(e.getMessage());
		} catch (RepositorioException e) {
			System.out.println(e.getMessage());
		}
		
		do {
			try {			
					if (i == 1) {
						dataC = new Data(20, 3, 2000);
						dataF = new Data(18, 3, 2012);
						dataS = new Data(22, 6, 2014);
						Dia[] dia = {Dia.SEGUNDAFEIRA, Dia.TERCAFEIRA, Dia.QUINTAFEIRA};
							
						endereco = new Endereco("Av. Jorn. Anibal Fernandes", 2220, "CIn", "50740560", "Cidade Universitária", "Recife", Estado.PERNAMBUCO, "Brasil");
													
						cliente = new Cliente("Miriane Silva", "95416325789", "mstn@cin.ufpe.br", "123456", "8185468232", 'F', dataC, endereco);
						funcionario = new Funcionario("Lucas Alves", "54632598712", "lar@cin.ufpe.br", "36259", "8195632792", 'M', dataF, endereco, 800.72, Cargo.GERENTE, 40.0);
							
						ebook = new Ebook("O guia dos moxileiros das galáxias, vol. 1", "5214327205625", 18.80, "Alguém", "Aquela", 1, 2011, Idioma.INGLES, 12, 220.0, Formato.PDF);
						livro = new Livro("O guia dos moxileiros das galáxias, vol. 1", "1256327541225", 32.50, "Alguém", "Aquela", 2, 2012, Idioma.PORTUGUES, 30, 120, Acabamento.CAPADURA, 0.200, 15.0, 0.125, 0.180);
							
						curso = new Curso("OOP: Java!", "125125125", 30, dataS, "13:00", 3.0, endereco, "Aprenda programação orientada a objetos com JAVA!", "Sheldon Cooper", 120.0, dia);
						palestra = new Palestra("As 5 próximas linguagens de programação que você deve aprender!", "543621475", 10, dataS, "13:00", 2.0, endereco, "Venha descobrir quais as 5 próximas linguagens de programação que você deve aprender!", "Leonard Hoofstader");

						System.out.println(fachada.descricaoPessoa(cliente.getCPF()));
						fachada.cadastrarPessoa(cliente);
						fachada.cadastrarPessoa(funcionario);
						fachada.cadastrarProduto(ebook);
						fachada.cadastrarProduto(livro);
						fachada.cadastrarServico(curso);
						fachada.cadastrarServico(palestra);
					} else if (i == 2) {
						Pessoa cliente1 = cliente.clone();
						cliente1.setEmail("masodansionfaoela.sandoaefaepa.amepofa@.amspoandienape.apoe");
						fachada.atualizarPessoa(cliente1);
					} else if (i == 3) {
						Produto livro1 = livro.clone();
						livro1.setPreco(-89.99);
						fachada.atualizarProduto(livro1);	
					} else if (i == 4) {
						Servico curso1 = curso.clone();
						curso1.setHorario("17:00hs");
						fachada.atualizarServico(curso1);
					} else if (i == 5) {
						Pessoa funcionario1 = funcionario.clone();
						funcionario1.setEndereco(null);
					} else if(i == 6) {
						fachada.cadastrarPessoa(cliente);
						fachada.cadastrarProduto(ebook);
						fachada.cadastrarServico(palestra);
					} else if(i == 7) {
						System.out.println(fachada.procurarPessoa("124097621").getDesconto());
						System.out.println(fachada.procurarProduto("09875mbiuo").getAutor());
						System.out.println(fachada.procurarServico("123,09876").getVagasOcupadas());
					} else if(i == 8) {
						fachada.removerPessoa("54632598712");
						fachada.removerProduto("1256327541230");
						fachada.removerServico("125125128");
						fachada.removerPessoa("54632598712");
					} else if(i == 9) {
						fachada.comprar("95416325789", "1256327541225", 15);
						fachada.comprar("96574232597", "1256327541227", 7);	
						fachada.comprar("95416325789", "1256327541225", 150);
					} else if(i == 10) {
						System.out.println(fachada.procurarProduto("1256327541225").getTitulo());
						System.out.println(fachada.procurarPessoa("95416325789").getEmail());
						System.out.println(fachada.procurarServico("125125125").getVagas());
					}
			} catch (ValorInvalidoException e) {
				System.out.println(e.getMessage());
			} catch (RepositorioException e) {
				System.out.println(e.getMessage());
			} catch (ValorJaCadastradoException e) {
				System.out.println(e.getMessage());
			} catch (ValorNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (QuantidadeIndisponivelException e) {
				System.out.println(e.getMessage());
			} finally {
				System.out.println("Deseja continuar? \n1. Sim \n2. Não");
				op1 = input.nextLine();
				
				if (op1.equals("1")) {
					i++;
				} else {
					System.out.println("Tchau :3");
					i = 11;
				}
			}
		} while(i <= 10);
		
		System.out.println("Tchau :3");
		
		input.close();
	}
}
