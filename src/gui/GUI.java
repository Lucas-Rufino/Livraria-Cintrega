package gui;

import java.awt.EventQueue;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import fachada.QuantidadeIndisponivelException;
import fachada.ServicoJaRealizadoException;
import fachada.ServicoLotadoException;
import negocios.ValorInvalidoException;
import negocios.ValorJaCadastradoException;
import negocios.ValorNaoEncontradoException;
import relatorios.RepositorioRelatorio;
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
import javax.swing.JMenuBar;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

import constantes.Acabamento;
import constantes.Cargo;
import constantes.Dia;
import constantes.Estado;
import constantes.Formato;
import constantes.Idioma;
import dados.Cliente;
import dados.Curso;
import dados.Data;
import dados.Ebook;
import dados.Endereco;
import dados.Funcionario;
import dados.Livro;
import dados.Palestra;
import dados.Pessoa;
import dados.Produto;
import dados.Servico;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2282264823446550304L;
	private Fachada fachada;				//fachada do projeto.
	private RepositorioPessoa repPessoa;	//interface de repositorio de pessoa
	private RepositorioProduto repProduto; 	//interface de repositorio de produto
	private RepositorioServico repServico; 	//interface de repositorio de servico
	private RepositorioRelatorio repRelatorio;
	
	@SuppressWarnings("unused")
	private boolean cadastrar_atualizar;
	
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu menuCadastrar;
	private JMenu menuAtualizar;
	private JMenu menuProcurar;
	private JMenu menuRemover;
	private JMenu menuVender;
	private JMenu menuParticipar;
	private JMenu menuRelatorio;
	private JMenu menuUsuario;
	private JMenuItem cadastrarPessoa;
	private JMenuItem cadastrarProduto;
	private JMenuItem cadastrarServico;
	private JMenuItem atualizarPessoa;
	private JMenuItem atualizarProduto;
	private JMenuItem atualizarServico;
	private JMenuItem procurarPessoa;
	private JMenuItem procurarProduto;
	private JMenuItem procurarServico;
	private JMenuItem removerPessoa;
	private JMenuItem removerProduto;
	private JMenuItem removerServico;
	private JMenuItem relatorioPessoa;
	private JMenuItem relatorioProduto;
	private JMenuItem relatorioServico;
	private JMenuItem sair;
	private JMenuItem menuProduto;
	private JMenuItem menuServico;
	private JPanel panelHome;
	private JPanel panelCadastrar;
	private JPanel panelAtualizar;
	private JPanel panelRemover;
	private JPanel panelVender;
	private JPanel panelParticipar;
	private JPanel panelRelatorio;
	private JPanel panelProcurar;
	private JPanel panelCadastrarPessoa;
	private JPanel panelCadastrarProduto;
	private JPanel panelCadastrarServico;
	private JPanel panelAtualizarPessoa;
	private JPanel panelAtualizarProduto;
	private JPanel panelAtualizarServico;
	private JPanel panelProcurarPessoa;
	private JPanel panelProcurarProduto;
	private JPanel panelProcurarServico;
	private JPanel panelRemoverPessoa;
	private JPanel panelRemoverProduto;
	private JPanel panelRemoverServico;
	private JPanel panelRelatorioPessoa;
	private JPanel panelRelatorioProduto;
	private JPanel panelRelatorioServico;
	private JRadioButton radioFuncionario;
	private JRadioButton radioCliente;
	private JRadioButton radioEbook;
	private JRadioButton radioLivro;
	private JRadioButton radioCurso;
	private JRadioButton radioPalestra;
	private JTextField textcNome;
	private JTextField textcEmail;
	private JTextField textcTelefone;
	private JTextField textcLogradouro;
	private JTextField textcComplemento;
	private JTextField textcCEP;
	private JTextField textcPais;
	private JLabel labelcNome;
	private JLabel labelcEmail;
	private JLabel labelcTelefone;
	private JLabel labelcLogradouro;
	private JLabel labelcComplemento;
	private JLabel labelcCEP;
	private JLabel labelcEstado;
	private JLabel labelcCPF;
	private JTextField textcCPF;
	private JLabel labelcSenha;
	private JTextField textcSenha;
	private JLabel labelcSexo;
	private JComboBox<Object> comboBoxcSexo;
	private JLabel labelcData;
	private JComboBox<Object> comboBoxcDias;
	private JComboBox<Object> comboBoxcMes;
	private JComboBox<Object> comboBoxcAnos;
	private JLabel labelcNumero;
	private JTextField textcNumero;
	private JLabel labelcBairro;
	private JLabel labelcCidade;
	private JTextField textcBairro;
	private JTextField textcCidade;
	private JLabel labelcPais;
	private JComboBox<Object> comboBoxcEstados;
	private JButton buttoncCancelarPessoa;
	private JLabel labelErroCadastroPessoa;
	private JButton buttoncPessoa;
	private JTextField textcSalario;
	private JTextField textcHorasSemanais;
	private JPanel panelcFuncionario;
	private JLabel labelcSalario;
	private JComboBox<Object> comboBoxcCargos;
	private JLabel labelcCargo;
	private JLabel labelcHorasSemanais;
	private JLabel labelpcTitulo;
	private JTextField textpcTitulo;
	private JTextField textpcPreco;
	private JTextField textpcEdicao;
	private JLabel labelpcPreco;
	private JLabel labelpcEdicao;
	private JLabel labelpcISBN;
	private JTextField textpcISBN;
	private JLabel labelpcAutor;
	private JTextField textpcAutor;
	private JLabel labelpcEditora;
	private JTextField textpcEditora;
	private JLabel labelpcAno;
	private JTextField textpcAno;
	private JLabel labelpcIdioma;
	private JPanel panelCadastroEbook;
	private JPanel panelCadastroLivro;
	private JLabel labelpcQuantEstoque;
	private JTextField textpcNumeroPag;
	private JLabel labelpcNumeroPag;
	private JTextField textpcQuantEstoque;
	private JLabel labelpcAcabamento;
	private JLabel labelpcPeso;
	private JTextField textpcPeso;
	private JLabel labelpcAltura;
	private JTextField textpcAltura;
	private JLabel labelpcLargura;
	private JTextField textpcLargura;
	private JLabel labelpcComprimento;
	private JTextField textpcComprimento;
	private JComboBox<Object> comboBoxpcIdiomas;
	private JComboBox<Object> comboBoxpcAcabamentos;
	private JLabel labelpcTamanho;
	private JTextField textpcTamanho;
	private JLabel labelpcQuantLicenca;
	private JTextField textpcQuantLicenca;
	private JLabel labelpcFormato;
	private JComboBox<Object> comboBoxpcFormatos;
	private JButton buttonpcCancelarProduto;
	private JButton buttonpcCadastrarProduto;
	private JLabel label;
	private JTextField textscNome;
	private JTextField textscHorario;
	private JLabel lblHorrio;
	private JLabel vagas;
	private JTextField textscVagas;
	private JLabel lblCdigo;
	private JTextField textscCodigo;
	private JLabel lblData;
	private JComboBox<Object> comboBoxscDias;
	private JComboBox<Object> comboBoxscMeses;
	private JComboBox<Object> comboBoxscAnos;
	private JLabel lblDurao;
	private JTextField textscDuracao;
	private JLabel label_6;
	private JTextField textscLogradouro;
	private JLabel label_7;
	private JTextField textscNumero;
	private JLabel label_8;
	private JTextField textscComplemento;
	private JLabel label_9;
	private JTextField textscCEP;
	private JLabel label_10;
	private JTextField textscBairro;
	private JLabel label_11;
	private JTextField textscCidade;
	private JTextField textscPais;
	private JLabel label_12;
	private JComboBox<Object> comboBoxscEstados;
	private JLabel label_13;
	private JLabel lblDescrio;
	private JTextField textscDescricao;
	private JPanel panelscPalestra;
	private JLabel lblPalestrante;
	private JTextField textscPalestrante;
	private JPanel panelscCurso;
	private JLabel lblProfessor;
	private JTextField textscProfessor;
	private JLabel lblCargaHorria;
	private JTextField textscCargaHoraria;
	private JCheckBox checkscseg;
	private JCheckBox checkscter;
	private JCheckBox checkscqua;
	private JCheckBox checkscqui;
	private JCheckBox checkscsex;
	private JCheckBox checkscsab;
	private JCheckBox checkscdom;
	private JLabel lblDigiteOCpf;
	private JTextField textapBuscar;
	private JButton buttonBuscarAtualizarPessoa;
	private JPanel panelDadosPessoa;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_14;
	private JLabel label_15;
	private JLabel label_16;
	private JLabel label_17;
	private JLabel label_18;
	private JLabel label_19;
	private JLabel label_20;
	private JLabel label_21;
	private JLabel label_22;
	private JLabel label_23;
	private JLabel label_24;
	private JTextField textapNome;
	private JTextField textapEmail;
	private JTextField textapTelefone;
	private JTextField textapLogradouro;
	private JTextField textapComplemento;
	private JTextField textapCEP;
	private JTextField textapPais;
	private JTextField textapCPF;
	private JTextField textapSenha;
	private JTextField textapNumero;
	private JTextField textapBairro;
	private JTextField textapCidade;
	private JComboBox<Object> comboBoxapSexo;
	private JComboBox<Object> comboBoxapDias;
	private JComboBox<Object> comboBoxapMeses;
	private JComboBox<Object> comboBoapAnos;
	private JComboBox<Object> comboBoxapEstados;
	private JPanel panelDadosFuncionario;
	private JLabel label_25;
	private JLabel label_26;
	private JLabel label_27;
	private JTextField textapSalario;
	private JTextField textapHorasSemanais;
	private JComboBox<Object> comboBoxapCargo;
	private JButton buttonCancelarAtualizarPessoa;
	private JButton buttonAtualizarPessoa;
	private JLabel label_28;
	private JTextField textppBuscar;
	private JButton buttonppBuscar;
	private JTextArea textppDescricao;
	private JLabel label_29;
	private JTextField textrpBuscar;
	private JButton btnRemover;
	private JLabel label_30;
	private JTextField textvCPF;
	private JLabel lblOCodigo;
	private JTextField textvISBN;
	private JLabel lblAQuantidade;
	private JTextField textvQuant;
	private JButton botaoVender;
	private JLabel label_31;
	private JTextField textpsCPF;
	private JLabel lblOCdigo;
	private JTextField textpsCodigo;
	private JButton btnParticipar;
	private JButton btnGerarRelatrio;
	private JTextPane textrPessoa;
	private JButton buttonVerRelatorio;
	private JButton btnSalvarRelatrioN;
	private JButton btnSalvarRelatrios;
	private JLabel lblNmeroDoRelatrio;
	private JTextField textrpNumero;
	private JLabel lblCpf;
	private JTextField textloginCPF;
	private JLabel lblSenha;
	private JTextField textloginSenha;
	private JButton btnLogar;
	private JTextField textpproBuscar;
	private JButton buttonpproBuscar;
	private JTextArea textpproDescricao;
	private JLabel lblDigiteOIsbn;
	private JLabel lblDigiteOCdigo;
	private JTextField textpsBuscar;
	private JButton buttonpsBuscar;
	private JTextArea textpsDescricao;
	private JLabel lblDigiteOIsbn_1;
	private JTextField textrproRemover;
	private JButton buttonrproRemover;
	private JLabel lblDigiteOCdigo_1;
	private JTextField textrsRemover;
	private JButton buttonrsRemover;
	private JTextField textrpRelatorioNumero;
	private JTextPane textrProduto;
	private JButton buttonsGerarRelatorio;
	private JTextPane textsRelatorioServico;
	private JButton buttonsVerRelatorio;
	private JButton buttonsSalvarRelatorio;
	private JButton buttonsSalvarRelatorios;
	private JLabel label_33;
	private JTextField textsNumero;
	private JLabel lblDigiteOIsbn_2;
	private JTextField textaProduto;
	private JButton buttonaBuscar;
	private JTextField textapTitulo;
	private JTextField textapPreco;
	private JTextField textapEdicao;
	private JTextField textapISBN;
	private JTextField textapAutor;
	private JTextField textapEditora;
	private JTextField textapAno;
	private JLabel label_42;
	private JLabel label_43;
	private JLabel label_44;
	private JLabel label_45;
	private JLabel label_46;
	private JLabel label_47;
	private JLabel label_48;
	private JTextField textapNumeroPag;
	private JTextField textapQuantEstoque;
	private JTextField textapPeso;
	private JTextField textapAltura;
	private JTextField textapLargura;
	private JTextField textapComprimento;
	private JComboBox<Object> comboBoxapAcabamento;
	private JLabel label_49;
	private JLabel lblFormato;
	private JLabel label_51;
	private JTextField textapTamanho;
	private JTextField textapQuantLicenca;
	private JComboBox<Object> comboBoxapFomatos;
	private JPanel panelDadosProduto;
	private JComboBox<Object> comboBoxapIdioma;
	private JPanel panelDadosLivro;
	private JPanel panelDadosEbook;
	private JButton button;
	private JButton button_1;
	private JLabel lblDigiteOCdigo_2;
	private JTextField textsaBuscar;
	private JButton button_2;
	private JPanel panelDadosServico;
	private JLabel label_50;
	private JLabel label_52;
	private JLabel label_53;
	private JLabel label_54;
	private JLabel label_55;
	private JLabel label_56;
	private JLabel label_57;
	private JLabel label_58;
	private JLabel label_59;
	private JLabel label_60;
	private JLabel label_61;
	private JLabel label_62;
	private JLabel label_63;
	private JLabel label_64;
	private JTextField textNome;
	private JTextField textHorario;
	private JTextField textVagas;
	private JTextField textCodigo;
	private JTextField textDuracao;
	private JTextField textLogradouro;
	private JTextField textNumero;
	private JTextField textComplemento;
	private JTextField textCEP;
	private JTextField textBairro;
	private JTextField textCidade;
	private JTextField textPais;
	private JComboBox<Object> comboBoxDia;
	private JComboBox<Object> comboBoxMes;
	private JComboBox<Object> comboBoxAnos;
	private JComboBox<Object> comboBoxEstado;
	private JLabel label_65;
	private JPanel panelDadosCurso;
	private JLabel label_66;
	private JTextField textProfessor;
	private JLabel label_67;
	private JTextField textCarga;
	private JCheckBox checkBoxSeg;
	private JCheckBox checkBoxTer;
	private JCheckBox checkBoxQua;
	private JCheckBox checkBoxQui;
	private JCheckBox checkBoxSex;
	private JCheckBox checkBoxSab;
	private JCheckBox checkBoxDom;
	private JLabel label_68;
	private JPanel panelDadosPalestra;
	private JTextField textDescricao;
	private JButton button_3;
	private JButton button_4;
	private JLabel label_69;
	private JTextField textPalestrante;
	private JLabel lblTituloCintrega;
	private JLabel lblBooks;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					File file = new File("config.txt");
					Scanner in = new Scanner(file);
					char valor = in.next().charAt(0);
					in.close();
					GUI frame = new GUI(valor);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI(int valor) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GUI.class.getResource("/icon.png")));
		setResizable(false);
		setTitle("Livraria Cintrega");
		try{
			switch(valor){
				case '1': this.repPessoa = new RepositorioPessoaArray();
			  		  	  this.repProduto = new RepositorioProdutoArray();
			  		  	  this.repServico = new RepositorioServicoArray();
			  		  	  break;
				case '2': this.repPessoa = new RepositorioPessoaLista();
			  		  	  this.repProduto = new RepositorioProdutoLista();
			  		  	  this.repServico = new RepositorioServicoLista();
			  		  	  break;
				case '3': this.repPessoa = new RepositorioPessoaArquivo();
	  		  		  	  this.repProduto = new RepositorioProdutoArquivo();
	  		  		  	  this.repServico = new RepositorioServicoArquivo();
	  		  		  	  break;
				 default: this.repPessoa = new RepositorioPessoaArquivo();
	  		  	  		  this.repProduto = new RepositorioProdutoArquivo();
	  		  	  		  this.repServico = new RepositorioServicoArquivo();
	  		  	  		  break;
			}
		} catch (RepositorioException e) {
			JOptionPane.showMessageDialog(this, "Erro no repositório! Reinicie o programa. se pesistir, instale novamente.", "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
		}
		
		this.fachada = new Fachada(this.repPessoa, this.repProduto, this.repServico);
		
		this.repRelatorio = new RepositorioRelatorio();
		
		////////////////////////////////////////////////////////////////////////////
		cadastrar_atualizar = true;
		String[] sexos = {"M","F"};
		
		String[] dias = new String[31];
		for(int i=0 ; i<31 ; i++){
			dias[i] = (i+1) + "";
		}
		
		String[] meses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho",
				"Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
		
		String[] anos = new String[150];
		String data = new Date().toString();
		int ano = Integer.parseInt(data.toString().substring(data.length()-4, data.length()));
		for(int i=0 ; i<150 ; i++){
			anos[i] = (ano-i) + "";
		}
		String[] maisAnos = new String[10];
		for(int i=0 ; i<10 ;i++){
			maisAnos[i] = (ano+i)+"";
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menuBar = new JMenuBar();
		menuBar.setEnabled(false);
		menuBar.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		menuBar.setBackground(new Color(255, 255, 255));
		menuBar.setFont(new Font("Tahoma", Font.BOLD, 12));
		menuBar.setBounds(0, 0, 684, 21);
		contentPane.add(menuBar);
		
		menuCadastrar = new JMenu("Cadastrar");
		menuCadastrar.setBackground(new Color(255, 255, 255));
		menuCadastrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		menuBar.add(menuCadastrar);
		
		cadastrarPessoa = new JMenuItem("Pessoa");
		cadastrarPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setTitle("Livraria Cintrega - Cadastrar - Pessoa");
				limparText();
				
				cadastrar_atualizar = true;
				panelHome.setVisible(false);
				panelCadastrar.setVisible(true);
				panelAtualizar.setVisible(false);
				panelProcurar.setVisible(false);
				panelRemover.setVisible(false);
				panelVender.setVisible(false);
				panelParticipar.setVisible(false);
				panelRelatorio.setVisible(false);
				
				panelCadastrarPessoa.setVisible(true);
				panelCadastrarProduto.setVisible(false);
				panelCadastrarServico.setVisible(false);
			}
		});
		cadastrarPessoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cadastrarPessoa.setBackground(new Color(255, 255, 255));
		menuCadastrar.add(cadastrarPessoa);
		
		cadastrarProduto = new JMenuItem("Produto");
		cadastrarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTitle("Livraria Cintrega - Cadastrar - Produto");
				limparText();
				
				cadastrar_atualizar = true;
				panelHome.setVisible(false);
				panelCadastrar.setVisible(true);
				panelAtualizar.setVisible(false);
				panelProcurar.setVisible(false);
				panelRemover.setVisible(false);
				panelVender.setVisible(false);
				panelParticipar.setVisible(false);
				panelRelatorio.setVisible(false);
				
				panelCadastrarPessoa.setVisible(false);
				panelCadastrarProduto.setVisible(true);
				panelCadastrarServico.setVisible(false);
			}
		});
		cadastrarProduto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cadastrarProduto.setBackground(Color.WHITE);
		menuCadastrar.add(cadastrarProduto);
		
		cadastrarServico = new JMenuItem("Servi\u00E7o");
		cadastrarServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTitle("Livraria Cintrega - Cadastrar - Serviço");
				limparText();
				
				cadastrar_atualizar = true;
				panelHome.setVisible(false);
				panelCadastrar.setVisible(true);
				panelAtualizar.setVisible(false);
				panelProcurar.setVisible(false);
				panelRemover.setVisible(false);
				panelVender.setVisible(false);
				panelParticipar.setVisible(false);
				panelRelatorio.setVisible(false);
				
				panelCadastrarPessoa.setVisible(false);
				panelCadastrarProduto.setVisible(false);
				panelCadastrarServico.setVisible(true);
			}
		});
		cadastrarServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cadastrarServico.setBackground(Color.WHITE);
		menuCadastrar.add(cadastrarServico);
		
		menuAtualizar = new JMenu("Atualizar");
		menuAtualizar.setFont(new Font("Tahoma", Font.BOLD, 12));
		menuAtualizar.setBackground(Color.WHITE);
		menuBar.add(menuAtualizar);
		
		atualizarPessoa = new JMenuItem("Pessoa");
		atualizarPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTitle("Livraria Cintrega - Atualizar - Pessoa");
				limparText();
				
				cadastrar_atualizar = false;
				panelHome.setVisible(false);
				panelCadastrar.setVisible(false);
				panelAtualizar.setVisible(true);
				panelProcurar.setVisible(false);
				panelRemover.setVisible(false);
				panelVender.setVisible(false);
				panelParticipar.setVisible(false);
				panelRelatorio.setVisible(false);
				
				panelAtualizarPessoa.setVisible(true);
				panelAtualizarProduto.setVisible(false);
				panelAtualizarServico.setVisible(false);
				
				panelDadosPessoa.setVisible(false);
				textapBuscar.setText("");
			}
		});
		atualizarPessoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		atualizarPessoa.setBackground(Color.WHITE);
		menuAtualizar.add(atualizarPessoa);
		
		atualizarProduto = new JMenuItem("Produto");
		atualizarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTitle("Livraria Cintrega - Atualizar - Produto");
				limparText();
				
				cadastrar_atualizar = false;
				panelHome.setVisible(false);
				panelCadastrar.setVisible(false);
				panelAtualizar.setVisible(true);
				panelProcurar.setVisible(false);
				panelRemover.setVisible(false);
				panelVender.setVisible(false);
				panelParticipar.setVisible(false);
				panelRelatorio.setVisible(false);
				
				panelAtualizarPessoa.setVisible(false);
				panelAtualizarProduto.setVisible(true);
				panelAtualizarServico.setVisible(false);
				
				panelDadosProduto.setVisible(false);
				panelDadosLivro.setVisible(false);
				panelDadosEbook.setVisible(false);
				textaProduto.setText("");
			}
		});
		atualizarProduto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		atualizarProduto.setBackground(Color.WHITE);
		menuAtualizar.add(atualizarProduto);
		
		atualizarServico = new JMenuItem("Servi\u00E7o");
		atualizarServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTitle("Livraria Cintrega - Atualizar - Serviço");
				limparText();
				
				cadastrar_atualizar = false;
				panelHome.setVisible(false);
				panelCadastrar.setVisible(false);
				panelAtualizar.setVisible(true);
				panelProcurar.setVisible(false);
				panelRemover.setVisible(false);
				panelVender.setVisible(false);
				panelParticipar.setVisible(false);
				panelRelatorio.setVisible(false);
				
				panelAtualizarPessoa.setVisible(false);
				panelAtualizarProduto.setVisible(false);
				panelAtualizarServico.setVisible(true);
				
				panelDadosServico.setVisible(false);
				panelDadosPalestra.setVisible(false);
				panelDadosCurso.setVisible(false);
				textsaBuscar.setText("");
			}
		});
		atualizarServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		atualizarServico.setBackground(Color.WHITE);
		menuAtualizar.add(atualizarServico);
		
		menuProcurar = new JMenu("Procurar");
		menuProcurar.setFont(new Font("Tahoma", Font.BOLD, 12));
		menuProcurar.setBackground(Color.WHITE);
		menuBar.add(menuProcurar);
		
		procurarPessoa = new JMenuItem("Pessoa");
		procurarPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTitle("Livraria Cintrega - Procurar - Pessoa");
				limparText();
				
				panelHome.setVisible(false);
				panelCadastrar.setVisible(false);
				panelAtualizar.setVisible(false);
				panelProcurar.setVisible(true);
				panelRemover.setVisible(false);
				panelVender.setVisible(false);
				panelParticipar.setVisible(false);
				panelRelatorio.setVisible(false);
				
				panelProcurarPessoa.setVisible(true);
				panelProcurarProduto.setVisible(false);
				panelProcurarServico.setVisible(false);
				
				textppDescricao.setVisible(false);
				textppBuscar.setText("");
			}
		});
		procurarPessoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		procurarPessoa.setBackground(Color.WHITE);
		menuProcurar.add(procurarPessoa);
		
		procurarProduto = new JMenuItem("Produto");
		procurarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTitle("Livraria Cintrega - Procurar - Produto");
				limparText();
				
				panelHome.setVisible(false);
				panelCadastrar.setVisible(false);
				panelAtualizar.setVisible(false);
				panelProcurar.setVisible(true);
				panelRemover.setVisible(false);
				panelVender.setVisible(false);
				panelParticipar.setVisible(false);
				panelRelatorio.setVisible(false);
				
				panelProcurarPessoa.setVisible(false);
				panelProcurarProduto.setVisible(true);
				panelProcurarServico.setVisible(false);
				
				textpproDescricao.setText("");
				textpproBuscar.setText("");
				
				
			}
		});
		procurarProduto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		procurarProduto.setBackground(Color.WHITE);
		menuProcurar.add(procurarProduto);
		
		procurarServico = new JMenuItem("Servi\u00E7o");
		procurarServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTitle("Livraria Cintrega - Procurar - Serviço");
				limparText();
				
				panelHome.setVisible(false);
				panelCadastrar.setVisible(false);
				panelAtualizar.setVisible(false);
				panelProcurar.setVisible(true);
				panelRemover.setVisible(false);
				panelVender.setVisible(false);
				panelParticipar.setVisible(false);
				panelRelatorio.setVisible(false);
				
				panelProcurarPessoa.setVisible(false);
				panelProcurarProduto.setVisible(false);
				panelProcurarServico.setVisible(true);
				
				textpsDescricao.setText("");
				textpsBuscar.setText("");
			}
		});
		procurarServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		procurarServico.setBackground(Color.WHITE);
		menuProcurar.add(procurarServico);
		
		menuRemover = new JMenu("Remover");
		menuRemover.setFont(new Font("Tahoma", Font.BOLD, 12));
		menuRemover.setBackground(Color.WHITE);
		menuBar.add(menuRemover);
		
		removerPessoa = new JMenuItem("Pessoa");
		removerPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTitle("Livraria Cintrega - Remover - Pessoa");
				limparText();
				
				panelHome.setVisible(false);
				panelCadastrar.setVisible(false);
				panelAtualizar.setVisible(false);
				panelProcurar.setVisible(false);
				panelRemover.setVisible(true);
				panelVender.setVisible(false);
				panelParticipar.setVisible(false);
				panelRelatorio.setVisible(false);
				
				panelRemoverPessoa.setVisible(true);
				panelRemoverProduto.setVisible(false);
				panelRemoverServico.setVisible(false);
				
				textrpBuscar.setText("");
			}
		});
		removerPessoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		removerPessoa.setBackground(Color.WHITE);
		menuRemover.add(removerPessoa);
		
		removerProduto = new JMenuItem("Produto");
		removerProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTitle("Livraria Cintrega - Remover - Produto");
				limparText();
				
				panelHome.setVisible(false);
				panelCadastrar.setVisible(false);
				panelAtualizar.setVisible(false);
				panelProcurar.setVisible(false);
				panelRemover.setVisible(true);
				panelVender.setVisible(false);
				panelParticipar.setVisible(false);
				panelRelatorio.setVisible(false);
				
				panelRemoverPessoa.setVisible(false);
				panelRemoverProduto.setVisible(true);
				panelRemoverServico.setVisible(false);
				
				textrproRemover.setText("");
			}
		});
		removerProduto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		removerProduto.setBackground(Color.WHITE);
		menuRemover.add(removerProduto);
		
		removerServico = new JMenuItem("Servi\u00E7o");
		removerServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTitle("Livraria Cintrega - Remover - Serviço");
				limparText();
				
				panelHome.setVisible(false);
				panelCadastrar.setVisible(false);
				panelAtualizar.setVisible(false);
				panelProcurar.setVisible(false);
				panelRemover.setVisible(true);
				panelVender.setVisible(false);
				panelParticipar.setVisible(false);
				panelRelatorio.setVisible(false);
				
				panelRemoverPessoa.setVisible(false);
				panelRemoverProduto.setVisible(false);
				panelRemoverServico.setVisible(true);
				
				textrsRemover.setText("");
			}
		});
		removerServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		removerServico.setBackground(Color.WHITE);
		menuRemover.add(removerServico);
		
		menuVender = new JMenu("Vender");
		menuVender.setFont(new Font("Tahoma", Font.BOLD, 12));
		menuVender.setBackground(Color.WHITE);
		menuBar.add(menuVender);
		
		menuProduto = new JMenuItem("Produto");
		menuProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTitle("Livraria Cintrega - Vender Produto");
				limparText();
				
				panelHome.setVisible(false);
				panelCadastrar.setVisible(false);
				panelAtualizar.setVisible(false);
				panelProcurar.setVisible(false);
				panelRemover.setVisible(false);
				panelVender.setVisible(true);
				panelParticipar.setVisible(false);
				panelRelatorio.setVisible(false);
				
				textvCPF.setText("");
				textvISBN.setText("");
				textvQuant.setText("");
			}
		});
		menuProduto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		menuProduto.setBackground(Color.WHITE);
		menuVender.add(menuProduto);
		
		menuParticipar = new JMenu("Participar");
		menuParticipar.setFont(new Font("Tahoma", Font.BOLD, 12));
		menuParticipar.setBackground(Color.WHITE);
		menuBar.add(menuParticipar);
		
		menuServico = new JMenuItem("Servi\u00E7o");
		menuServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTitle("Livraria Cintrega - Participar Serviço");
				limparText();
				
				panelHome.setVisible(false);
				panelCadastrar.setVisible(false);
				panelAtualizar.setVisible(false);
				panelProcurar.setVisible(false);
				panelRemover.setVisible(false);
				panelVender.setVisible(false);
				panelParticipar.setVisible(true);
				panelRelatorio.setVisible(false);
				
				textpsCPF.setText("");
				textpsCodigo.setText("");
			}
		});
		menuServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		menuServico.setBackground(Color.WHITE);
		menuParticipar.add(menuServico);
		
		menuRelatorio = new JMenu("Relatorio");
		menuRelatorio.setFont(new Font("Tahoma", Font.BOLD, 12));
		menuRelatorio.setBackground(Color.WHITE);
		menuBar.add(menuRelatorio);
		
		relatorioPessoa = new JMenuItem("Pessoa");
		relatorioPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTitle("Livraria Cintrega - Relatório - Pessoa");
				limparText();
				
				panelHome.setVisible(false);
				panelCadastrar.setVisible(false);
				panelAtualizar.setVisible(false);
				panelProcurar.setVisible(false);
				panelRemover.setVisible(false);
				panelVender.setVisible(false);
				panelParticipar.setVisible(false);
				panelRelatorio.setVisible(true);
				
				panelRelatorioPessoa.setVisible(true);
				panelRelatorioProduto.setVisible(false);
				panelRelatorioServico.setVisible(false);
			}
		});
		relatorioPessoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		relatorioPessoa.setBackground(Color.WHITE);
		menuRelatorio.add(relatorioPessoa);
		
		relatorioProduto = new JMenuItem("Produto");
		relatorioProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTitle("Livraria Cintrega - Relatório - Produto");
				limparText();
				
				panelHome.setVisible(false);
				panelCadastrar.setVisible(false);
				panelAtualizar.setVisible(false);
				panelProcurar.setVisible(false);
				panelRemover.setVisible(false);
				panelVender.setVisible(false);
				panelParticipar.setVisible(false);
				panelRelatorio.setVisible(true);
				
				panelRelatorioPessoa.setVisible(false);
				panelRelatorioProduto.setVisible(true);
				panelRelatorioServico.setVisible(false);
			}
		});
		relatorioProduto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		relatorioProduto.setBackground(Color.WHITE);
		menuRelatorio.add(relatorioProduto);
		
		relatorioServico = new JMenuItem("Servi\u00E7o");
		relatorioServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTitle("Livraria Cintrega - Relatório - Serviço");
				limparText();
				
				panelHome.setVisible(false);
				panelCadastrar.setVisible(false);
				panelAtualizar.setVisible(false);
				panelProcurar.setVisible(false);
				panelRemover.setVisible(false);
				panelVender.setVisible(false);
				panelParticipar.setVisible(false);
				panelRelatorio.setVisible(true);
				
				panelRelatorioPessoa.setVisible(false);
				panelRelatorioProduto.setVisible(false);
				panelRelatorioServico.setVisible(true);
			}
		});
		relatorioServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		relatorioServico.setBackground(Color.WHITE);
		menuRelatorio.add(relatorioServico);
		
		menuUsuario = new JMenu("Usu\u00E1rio");
		menuUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		menuUsuario.setBackground(Color.WHITE);
		menuBar.add(menuUsuario);
		
		menuCadastrar.setEnabled(false);
		menuAtualizar.setEnabled(false);
		menuProcurar.setEnabled(false);
		menuRemover.setEnabled(false);
		menuVender.setEnabled(false);
		menuParticipar.setEnabled(false);
		menuRelatorio.setEnabled(false);
		menuUsuario.setEnabled(false);
		
		sair = new JMenuItem("Sair");
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTitle("Livraria Cintrega");
				limparText();
				
				panelHome.setVisible(true);
				panelCadastrar.setVisible(false);
				panelAtualizar.setVisible(false);
				panelProcurar.setVisible(false);
				panelRemover.setVisible(false);
				panelVender.setVisible(false);
				panelParticipar.setVisible(false);
				panelRelatorio.setVisible(false);
				
				menuCadastrar.setEnabled(false);
				menuAtualizar.setEnabled(false);
				menuProcurar.setEnabled(false);
				menuRemover.setEnabled(false);
				menuVender.setEnabled(false);
				menuParticipar.setEnabled(false);
				menuRelatorio.setEnabled(false);
				menuUsuario.setEnabled(false);
				
				textloginCPF.setEnabled(true);
				textloginSenha.setEnabled(true);
				btnLogar.setEnabled(true);
				
			}
		});
		sair.setFont(new Font("Tahoma", Font.PLAIN, 12));
		sair.setBackground(Color.WHITE);
		menuUsuario.add(sair);
		
		panelHome = new JPanel();
		panelHome.setBackground(new Color(0, 153, 204));
		panelHome.setBounds(0, 21, 684, 440);
		contentPane.add(panelHome);
		panelHome.setLayout(null);
		
		lblCpf = new JLabel("CPF:");
		lblCpf.setForeground(Color.WHITE);
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCpf.setBounds(79, 326, 52, 20);
		panelHome.add(lblCpf);
		
		textloginCPF = new JTextField();
		textloginCPF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					btnLogar.doClick();
				}
			}
		});
		textloginCPF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textloginCPF.setColumns(10);
		textloginCPF.setBorder(new LineBorder(new Color(0, 102, 153)));
		textloginCPF.setBounds(114, 326, 507, 20);
		panelHome.add(textloginCPF);
		
		lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSenha.setBounds(63, 357, 68, 20);
		panelHome.add(lblSenha);
		
		textloginSenha = new JPasswordField();
		textloginSenha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textloginSenha.setColumns(10);
		textloginSenha.setBorder(new LineBorder(new Color(0, 102, 153)));
		textloginSenha.setBounds(114, 357, 507, 20);
		textloginSenha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					btnLogar.doClick();
				}
			}
		});
		panelHome.add(textloginSenha);
		
		btnLogar = new JButton("Logar");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(textloginCPF.getText().equals("admin") && textloginSenha.getText().equals("admin")){
						menuCadastrar.setEnabled(true);
						menuAtualizar.setEnabled(true);
						menuProcurar.setEnabled(true);
						menuRemover.setEnabled(true);
						menuVender.setEnabled(true);
						menuParticipar.setEnabled(true);
						menuRelatorio.setEnabled(true);
						menuUsuario.setEnabled(true);
						textloginCPF.setText("");
						textloginSenha.setText("");
						textloginCPF.setEnabled(false);
						textloginSenha.setEnabled(false);
						btnLogar.setEnabled(false);
					} else {
						Pessoa pessoa = fachada.procurarPessoa(textloginCPF.getText());
						if(pessoa instanceof Funcionario && textloginSenha.getText().equals(pessoa.getSenha())){
							menuCadastrar.setEnabled(true);
							menuAtualizar.setEnabled(true);
							menuProcurar.setEnabled(true);
							menuRemover.setEnabled(true);
							menuVender.setEnabled(true);
							menuParticipar.setEnabled(true);
							menuRelatorio.setEnabled(true);
							menuUsuario.setEnabled(true);
							textloginCPF.setText("");
							textloginSenha.setText("");
							textloginCPF.setEnabled(false);
							textloginSenha.setEnabled(false);
							btnLogar.setEnabled(false);
						} else {
							JOptionPane.showMessageDialog(panelHome, "CPF ou Senha invalidos!", "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
						}
					}
				} catch (RepositorioException e1) {
					JOptionPane.showMessageDialog(panelHome, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				} catch (ValorNaoEncontradoException e1) {
					JOptionPane.showMessageDialog(panelHome, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				}
			}
		});
		btnLogar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogar.setBorder(new LineBorder(new Color(0, 102, 153)));
		btnLogar.setBackground(Color.WHITE);
		btnLogar.setBounds(276, 388, 133, 23);
		panelHome.add(btnLogar);
		
		lblBooks = new JLabel("");
		lblBooks.setIcon(new ImageIcon(GUI.class.getResource("/books.png")));
		lblBooks.setHorizontalAlignment(SwingConstants.CENTER);
		lblBooks.setBounds(80, 60, 128, 128);
		panelHome.add(lblBooks);
		
		JLabel lblTituloLivraria = new JLabel("Livraria");
		lblTituloLivraria.setForeground(Color.WHITE);
		lblTituloLivraria.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloLivraria.setFont(new Font("Calibri", Font.BOLD, 120));
		lblTituloLivraria.setBounds(198, 78, 406, 128);
		panelHome.add(lblTituloLivraria);
		
		lblTituloCintrega = new JLabel("Cintrega");
		lblTituloCintrega.setForeground(Color.WHITE);
		lblTituloCintrega.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloCintrega.setFont(new Font("Calibri", Font.BOLD, 120));
		lblTituloCintrega.setBounds(0, 177, 684, 128);
		panelHome.add(lblTituloCintrega);
		
		panelParticipar = new JPanel();
		panelParticipar.setLayout(null);
		panelParticipar.setBackground(new Color(0, 153, 204));
		panelParticipar.setBounds(0, 21, 684, 440);
		contentPane.add(panelParticipar);
		
		label_31 = new JLabel("Digite o CPF:");
		label_31.setForeground(Color.WHITE);
		label_31.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_31.setBounds(16, 12, 117, 20);
		panelParticipar.add(label_31);
		
		textpsCPF = new JTextField();
		textpsCPF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					btnParticipar.doClick();
				}
			}
		});
		textpsCPF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textpsCPF.setColumns(10);
		textpsCPF.setBorder(new LineBorder(new Color(0, 102, 153)));
		textpsCPF.setBounds(98, 12, 462, 20);
		panelParticipar.add(textpsCPF);
		
		lblOCdigo = new JLabel("o C\u00F3digo:");
		lblOCdigo.setForeground(Color.WHITE);
		lblOCdigo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOCdigo.setBounds(35, 43, 78, 20);
		panelParticipar.add(lblOCdigo);
		
		textpsCodigo = new JTextField();
		textpsCodigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					btnParticipar.doClick();
				}
			}
		});
		textpsCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textpsCodigo.setColumns(10);
		textpsCodigo.setBorder(new LineBorder(new Color(0, 102, 153)));
		textpsCodigo.setBounds(98, 43, 462, 20);
		panelParticipar.add(textpsCodigo);
		
		btnParticipar = new JButton("Participar");
		btnParticipar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					fachada.participar(textpsCPF.getText(), textpsCodigo.getText());
					JOptionPane.showMessageDialog(panelParticipar, "A pessoa foi incluida na lista de participantes com suscesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
					panelHome.setVisible(true);
					panelParticipar.setVisible(false);
				} catch (RepositorioException e1) {
					JOptionPane.showMessageDialog(panelParticipar, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				} catch (ValorNaoEncontradoException e1) {
					JOptionPane.showMessageDialog(panelParticipar, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				} catch (ServicoJaRealizadoException e1) {
					JOptionPane.showMessageDialog(panelParticipar, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				} catch (ValorJaCadastradoException e1) {
					JOptionPane.showMessageDialog(panelParticipar, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				} catch (ServicoLotadoException e1) {
					JOptionPane.showMessageDialog(panelParticipar, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				} catch (ValorInvalidoException e1) {
					JOptionPane.showMessageDialog(panelParticipar, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				}
			}
		});
		btnParticipar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnParticipar.setBorder(new LineBorder(new Color(0, 102, 153)));
		btnParticipar.setBackground(Color.WHITE);
		btnParticipar.setBounds(570, 42, 104, 23);
		panelParticipar.add(btnParticipar);
		panelParticipar.setVisible(false);
		
		panelVender = new JPanel();
		panelVender.setLayout(null);
		panelVender.setBackground(new Color(0, 153, 204));
		panelVender.setBounds(0, 21, 684, 440);
		contentPane.add(panelVender);
		
		label_30 = new JLabel("Digite o CPF:");
		label_30.setForeground(Color.WHITE);
		label_30.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_30.setBounds(15, 12, 112, 20);
		panelVender.add(label_30);
		
		textvCPF = new JTextField();
		textvCPF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					botaoVender.doClick();
				}
			}
		});
		textvCPF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textvCPF.setColumns(10);
		textvCPF.setBorder(new LineBorder(new Color(0, 102, 153)));
		textvCPF.setBounds(98, 12, 462, 20);
		panelVender.add(textvCPF);
		
		lblOCodigo = new JLabel("ISBN:");
		lblOCodigo.setForeground(Color.WHITE);
		lblOCodigo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOCodigo.setBounds(60, 43, 78, 20);
		panelVender.add(lblOCodigo);
		
		textvISBN = new JTextField();
		textvISBN.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					botaoVender.doClick();
				}
			}
		});
		textvISBN.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textvISBN.setColumns(10);
		textvISBN.setBorder(new LineBorder(new Color(0, 102, 153)));
		textvISBN.setBounds(98, 43, 462, 20);
		panelVender.add(textvISBN);
		
		lblAQuantidade = new JLabel("Quantidade:");
		lblAQuantidade.setForeground(Color.WHITE);
		lblAQuantidade.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAQuantidade.setBounds(18, 74, 86, 20);
		panelVender.add(lblAQuantidade);
		
		textvQuant = new JTextField();
		textvQuant.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					botaoVender.doClick();
				}
			}
		});
		textvQuant.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textvQuant.setColumns(10);
		textvQuant.setBorder(new LineBorder(new Color(0, 102, 153)));
		textvQuant.setBounds(98, 74, 462, 20);
		panelVender.add(textvQuant);
		
		botaoVender = new JButton("Vender");
		botaoVender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int quant = 0;
					if(textvQuant.getText().matches("[0-9]+")){
						quant = Integer.parseInt(textvQuant.getText());
					} else {
						throw new ValorInvalidoException("vagas");
					}
					fachada.comprar(textvCPF.getText(), textvISBN.getText(), quant);
					JOptionPane.showMessageDialog(panelVender, "Venda realizada com sucesso", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
					panelHome.setVisible(true);
					panelVender.setVisible(false);
				} catch (ValorInvalidoException e1) {
					JOptionPane.showMessageDialog(panelVender, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				} catch (RepositorioException e1) {
					JOptionPane.showMessageDialog(panelVender, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				} catch (ValorNaoEncontradoException e1) {
					JOptionPane.showMessageDialog(panelVender, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				} catch (QuantidadeIndisponivelException e1) {
					JOptionPane.showMessageDialog(panelVender, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				}
				
			}
		});
		botaoVender.setFont(new Font("Tahoma", Font.BOLD, 12));
		botaoVender.setBorder(new LineBorder(new Color(0, 102, 153)));
		botaoVender.setBackground(Color.WHITE);
		botaoVender.setBounds(570, 73, 104, 23);
		panelVender.add(botaoVender);
		panelVender.setVisible(false);
		
		panelProcurar = new JPanel();
		panelProcurar.setLayout(null);
		panelProcurar.setBackground(new Color(0, 153, 204));
		panelProcurar.setBounds(0, 21, 684, 440);
		contentPane.add(panelProcurar);
		
		panelProcurarProduto = new JPanel();
		panelProcurarProduto.setLayout(null);
		panelProcurarProduto.setBackground(new Color(0, 153, 204));
		panelProcurarProduto.setBounds(0, 0, 684, 440);
		panelProcurar.add(panelProcurarProduto);
		
		lblDigiteOIsbn = new JLabel("Digite o ISBN:");
		lblDigiteOIsbn.setForeground(Color.WHITE);
		lblDigiteOIsbn.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDigiteOIsbn.setBounds(7, 12, 136, 20);
		panelProcurarProduto.add(lblDigiteOIsbn);
		
		textpproBuscar = new JTextField();
		textpproBuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					buttonpproBuscar.doClick();
				}
			}
		});
		textpproBuscar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textpproBuscar.setColumns(10);
		textpproBuscar.setBorder(new LineBorder(new Color(0, 102, 153)));
		textpproBuscar.setBounds(98, 12, 462, 20);
		panelProcurarProduto.add(textpproBuscar);
		
		buttonpproBuscar = new JButton("Buscar");
		buttonpproBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					textpproDescricao.setText("");
					Produto produto = fachada.procurarProduto(textpproBuscar.getText());
					textpproDescricao.setText(fachada.descricaoProduto(produto.getISBN()));
					textpproDescricao.setVisible(true);
					
				} catch (RepositorioException e1) {
					JOptionPane.showMessageDialog(panelProcurarProduto, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				} catch (ValorNaoEncontradoException e1) {
					JOptionPane.showMessageDialog(panelProcurarProduto, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				}
			}
		});
		buttonpproBuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonpproBuscar.setBorder(new LineBorder(new Color(0, 102, 153)));
		buttonpproBuscar.setBackground(Color.WHITE);
		buttonpproBuscar.setBounds(570, 11, 104, 23);
		panelProcurarProduto.add(buttonpproBuscar);
		
		textpproDescricao = new JTextArea();
		textpproDescricao.setForeground(Color.WHITE);
		textpproDescricao.setFont(new Font("Tahoma", Font.BOLD, 12));
		textpproDescricao.setBackground(new Color(0, 153, 204));
		textpproDescricao.setBounds(10, 51, 664, 378);
		panelProcurarProduto.add(textpproDescricao);
		
		panelProcurarPessoa = new JPanel();
		panelProcurarPessoa.setLayout(null);
		panelProcurarPessoa.setBackground(new Color(0, 153, 204));
		panelProcurarPessoa.setBounds(0, 0, 684, 440);
		panelProcurar.add(panelProcurarPessoa);
		
		label_28 = new JLabel("Digite o CPF:");
		label_28.setForeground(Color.WHITE);
		label_28.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_28.setBounds(7, 12, 130, 20);
		panelProcurarPessoa.add(label_28);
		
		textppBuscar = new JTextField();
		textppBuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					buttonppBuscar.doClick();
				}
			}
		});
		textppBuscar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textppBuscar.setColumns(10);
		textppBuscar.setBorder(new LineBorder(new Color(0, 102, 153)));
		textppBuscar.setBounds(89, 12, 471, 20);
		panelProcurarPessoa.add(textppBuscar);
		
		buttonppBuscar = new JButton("Buscar");
		buttonppBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					
					textppDescricao.setText("");
					Pessoa pessoa = fachada.procurarPessoa(textppBuscar.getText());
					textppDescricao.setText(fachada.descricaoPessoa(pessoa.getCPF()));
					textppDescricao.setVisible(true);
					
				} catch (RepositorioException e1) {
					JOptionPane.showMessageDialog(panelProcurarPessoa, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				} catch (ValorNaoEncontradoException e1) {
					JOptionPane.showMessageDialog(panelProcurarPessoa, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				}
			}
		});
		buttonppBuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonppBuscar.setBorder(new LineBorder(new Color(0, 102, 153)));
		buttonppBuscar.setBackground(Color.WHITE);
		buttonppBuscar.setBounds(570, 11, 104, 23);
		panelProcurarPessoa.add(buttonppBuscar);
		
		textppDescricao = new JTextArea();
		textppDescricao.setForeground(new Color(255, 255, 255));
		textppDescricao.setFont(new Font("Tahoma", Font.BOLD, 12));
		textppDescricao.setBackground(new Color(0, 153, 204));
		textppDescricao.setBounds(10, 51, 664, 378);
		panelProcurarPessoa.add(textppDescricao);
		
		panelProcurarServico = new JPanel();
		panelProcurarServico.setLayout(null);
		panelProcurarServico.setBackground(new Color(0, 153, 204));
		panelProcurarServico.setBounds(0, 0, 684, 440);
		panelProcurar.add(panelProcurarServico);
		
		lblDigiteOCdigo = new JLabel("Digite o C\u00F3digo:");
		lblDigiteOCdigo.setForeground(Color.WHITE);
		lblDigiteOCdigo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDigiteOCdigo.setBounds(7, 12, 129, 20);
		panelProcurarServico.add(lblDigiteOCdigo);
		
		textpsBuscar = new JTextField();
		textpsBuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					buttonpsBuscar.doClick();
				}
			}
		});
		textpsBuscar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textpsBuscar.setColumns(10);
		textpsBuscar.setBorder(new LineBorder(new Color(0, 102, 153)));
		textpsBuscar.setBounds(110, 12, 450, 20);
		panelProcurarServico.add(textpsBuscar);
		
		buttonpsBuscar = new JButton("Buscar");
		buttonpsBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					textpsDescricao.setText("");
					Servico servico = fachada.procurarServico(textpsBuscar.getText());
					textpsDescricao.setText(fachada.descricaoServico(servico.getCodigo()));
					textpsDescricao.setVisible(true);
					
				} catch (RepositorioException e1) {
					JOptionPane.showMessageDialog(panelProcurarServico, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				} catch (ValorNaoEncontradoException e1) {
					JOptionPane.showMessageDialog(panelProcurarServico, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				}
			}
		});
		buttonpsBuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonpsBuscar.setBorder(new LineBorder(new Color(0, 102, 153)));
		buttonpsBuscar.setBackground(Color.WHITE);
		buttonpsBuscar.setBounds(570, 11, 104, 23);
		panelProcurarServico.add(buttonpsBuscar);
		
		textpsDescricao = new JTextArea();
		textpsDescricao.setForeground(Color.WHITE);
		textpsDescricao.setFont(new Font("Tahoma", Font.BOLD, 12));
		textpsDescricao.setBackground(new Color(0, 153, 204));
		textpsDescricao.setBounds(10, 51, 664, 378);
		panelProcurarServico.add(textpsDescricao);
		panelProcurar.setVisible(false);
		
		panelRemover = new JPanel();
		panelRemover.setLayout(null);
		panelRemover.setBackground(new Color(0, 153, 204));
		panelRemover.setBounds(0, 21, 684, 440);
		contentPane.add(panelRemover);
		
		panelRemoverProduto = new JPanel();
		panelRemoverProduto.setLayout(null);
		panelRemoverProduto.setBackground(new Color(0, 153, 204));
		panelRemoverProduto.setBounds(0, 0, 684, 440);
		panelRemover.add(panelRemoverProduto);
		
		lblDigiteOIsbn_1 = new JLabel("Digite o ISBN:");
		lblDigiteOIsbn_1.setForeground(Color.WHITE);
		lblDigiteOIsbn_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDigiteOIsbn_1.setBounds(7, 12, 124, 20);
		panelRemoverProduto.add(lblDigiteOIsbn_1);
		
		textrproRemover = new JTextField();
		textrproRemover.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					buttonrproRemover.doClick();
				}
			}
		});
		textrproRemover.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textrproRemover.setColumns(10);
		textrproRemover.setBorder(new LineBorder(new Color(0, 102, 153)));
		textrproRemover.setBounds(96, 12, 464, 20);
		panelRemoverProduto.add(textrproRemover);
		
		buttonrproRemover = new JButton("Remover");
		buttonrproRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					fachada.removerProduto(textrproRemover.getText());
					JOptionPane.showMessageDialog(panelRemoverProduto, "Produto removido com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
				} catch (RepositorioException e1) {
					JOptionPane.showMessageDialog(panelRemoverProduto, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				} catch (ValorNaoEncontradoException e1) {
					JOptionPane.showMessageDialog(panelRemoverProduto, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				}
			}
		});
		buttonrproRemover.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonrproRemover.setBorder(new LineBorder(new Color(0, 102, 153)));
		buttonrproRemover.setBackground(Color.WHITE);
		buttonrproRemover.setBounds(570, 11, 104, 23);
		panelRemoverProduto.add(buttonrproRemover);
		
		panelRemoverPessoa = new JPanel();
		panelRemoverPessoa.setLayout(null);
		panelRemoverPessoa.setBackground(new Color(0, 153, 204));
		panelRemoverPessoa.setBounds(0, 0, 684, 440);
		panelRemover.add(panelRemoverPessoa);
		
		label_29 = new JLabel("Digite o CPF:");
		label_29.setForeground(Color.WHITE);
		label_29.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_29.setBounds(7, 12, 178, 20);
		panelRemoverPessoa.add(label_29);
		
		textrpBuscar = new JTextField();
		textrpBuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					btnRemover.doClick();
				}
			}
		});
		textrpBuscar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textrpBuscar.setColumns(10);
		textrpBuscar.setBorder(new LineBorder(new Color(0, 102, 153)));
		textrpBuscar.setBounds(90, 12, 470, 20);
		panelRemoverPessoa.add(textrpBuscar);
		
		btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					fachada.removerPessoa(textrpBuscar.getText());
					JOptionPane.showMessageDialog(panelRemoverPessoa, "Pessoa removida com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
				} catch (RepositorioException e1) {
					JOptionPane.showMessageDialog(panelRemoverPessoa, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				} catch (ValorNaoEncontradoException e1) {
					JOptionPane.showMessageDialog(panelRemoverPessoa, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				}
			}
		});
		btnRemover.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRemover.setBorder(new LineBorder(new Color(0, 102, 153)));
		btnRemover.setBackground(Color.WHITE);
		btnRemover.setBounds(570, 11, 104, 23);
		panelRemoverPessoa.add(btnRemover);
		
		panelRemoverServico = new JPanel();
		panelRemoverServico.setLayout(null);
		panelRemoverServico.setBackground(new Color(0, 153, 204));
		panelRemoverServico.setBounds(0, 0, 684, 440);
		panelRemover.add(panelRemoverServico);
		
		lblDigiteOCdigo_1 = new JLabel("Digite o C\u00F3digo:");
		lblDigiteOCdigo_1.setForeground(Color.WHITE);
		lblDigiteOCdigo_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDigiteOCdigo_1.setBounds(7, 12, 117, 20);
		panelRemoverServico.add(lblDigiteOCdigo_1);
		
		textrsRemover = new JTextField();
		textrsRemover.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					buttonrsRemover.doClick();
				}
			}
		});
		textrsRemover.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textrsRemover.setColumns(10);
		textrsRemover.setBorder(new LineBorder(new Color(0, 102, 153)));
		textrsRemover.setBounds(112, 12, 448, 20);
		panelRemoverServico.add(textrsRemover);
		
		buttonrsRemover = new JButton("Remover");
		buttonrsRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					fachada.removerServico(textrsRemover.getText());
					JOptionPane.showMessageDialog(panelRemoverServico, "Serviço removido com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
				} catch (RepositorioException e1) {
					JOptionPane.showMessageDialog(panelRemoverServico, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				} catch (ValorNaoEncontradoException e1) {
					JOptionPane.showMessageDialog(panelRemoverServico, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				}
			}
		});
		buttonrsRemover.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonrsRemover.setBorder(new LineBorder(new Color(0, 102, 153)));
		buttonrsRemover.setBackground(Color.WHITE);
		buttonrsRemover.setBounds(570, 11, 104, 23);
		panelRemoverServico.add(buttonrsRemover);
		panelRemover.setVisible(false);
		
		panelAtualizar = new JPanel();
		panelAtualizar.setLayout(null);
		panelAtualizar.setBackground(new Color(0, 153, 204));
		panelAtualizar.setBounds(0, 21, 684, 440);
		contentPane.add(panelAtualizar);
		
		panelAtualizarServico = new JPanel();
		panelAtualizarServico.setLayout(null);
		panelAtualizarServico.setBackground(new Color(0, 153, 204));
		panelAtualizarServico.setBounds(0, 0, 684, 440);
		panelAtualizar.add(panelAtualizarServico);
		
		lblDigiteOCdigo_2 = new JLabel("Digite o C\u00F3digo:");
		lblDigiteOCdigo_2.setForeground(Color.WHITE);
		lblDigiteOCdigo_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDigiteOCdigo_2.setBounds(7, 12, 161, 20);
		panelAtualizarServico.add(lblDigiteOCdigo_2);
		
		textsaBuscar = new JTextField();
		textsaBuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					button_2.doClick();
				}
			}
		});
		textsaBuscar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textsaBuscar.setColumns(10);
		textsaBuscar.setBorder(new LineBorder(new Color(0, 102, 153)));
		textsaBuscar.setBounds(112, 12, 448, 20);
		panelAtualizarServico.add(textsaBuscar);
		
		button_2 = new JButton("Buscar");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{ 
					Servico servico = fachada.procurarServico(textsaBuscar.getText());
					panelDadosServico.setVisible(true);
					
					textNome.setText(servico.getNome());
					textCodigo.setText(servico.getCodigo());
					textCodigo.setEnabled(false);
					textVagas.setText(servico.getVagas()+"");
					comboBoxDia.setSelectedIndex(servico.getData().getDia()-1);
					comboBoxMes.setSelectedIndex(servico.getData().getMes()-1);
					String data = new Date().toString();
					comboBoxAnos.setSelectedIndex(Integer.parseInt(data.substring(data.length()-4, data.length())) - servico.getData().getAno());
					textHorario.setText(servico.getHorario());
					textDuracao.setText(servico.getDuracao()+"");
					textLogradouro.setText(servico.getEndereco().getLogradouro());
					textNumero.setText(servico.getEndereco().getNumero()+"");
					textComplemento.setText(servico.getEndereco().getComplemento());
					textCEP.setText(servico.getEndereco().getCEP());
					textBairro.setText(servico.getEndereco().getBairro());
					textCidade.setText(servico.getEndereco().getCidade());
					//
					textPais.setText(servico.getEndereco().getPais());
					textDescricao.setText(servico.getDescricao());
					if(servico instanceof Palestra){
						textPalestrante.setText(((Palestra)servico).getPalestrante());
						panelDadosPalestra.setVisible(true);
					} else {
						textProfessor.setText(((Curso)servico).getProfessor());
						textCarga.setText(((Curso)servico).getCargaHoraria()+"");
						panelDadosCurso.setVisible(true);
					}
					panelDadosServico.setVisible(true);
				} catch (RepositorioException e1) {
					JOptionPane.showMessageDialog(panelAtualizarServico, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				} catch (ValorNaoEncontradoException e1) {
					JOptionPane.showMessageDialog(panelAtualizarServico, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				}
			}
		});
		button_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_2.setBorder(new LineBorder(new Color(0, 102, 153)));
		button_2.setBackground(Color.WHITE);
		button_2.setBounds(570, 11, 104, 23);
		panelAtualizarServico.add(button_2);
		
		panelDadosServico = new JPanel();
		panelDadosServico.setBackground(new Color(0, 153, 204));
		panelDadosServico.setBounds(0, 37, 684, 403);
		panelAtualizarServico.add(panelDadosServico);
		panelDadosServico.setLayout(null);
		panelDadosServico.setVisible(false);
		
		label_50 = new JLabel("Hor\u00E1rio: ");
		label_50.setForeground(Color.WHITE);
		label_50.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_50.setBounds(55, 68, 60, 20);
		panelDadosServico.add(label_50);
		
		label_52 = new JLabel("vagas:");
		label_52.setForeground(Color.WHITE);
		label_52.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_52.setBounds(65, 37, 60, 20);
		panelDadosServico.add(label_52);
		
		label_53 = new JLabel("C\u00F3digo:");
		label_53.setForeground(Color.WHITE);
		label_53.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_53.setBounds(465, 6, 59, 20);
		panelDadosServico.add(label_53);
		
		label_54 = new JLabel("Data:");
		label_54.setForeground(Color.WHITE);
		label_54.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_54.setBounds(416, 37, 39, 20);
		panelDadosServico.add(label_54);
		
		label_55 = new JLabel("Dura\u00E7\u00E3o:");
		label_55.setForeground(Color.WHITE);
		label_55.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_55.setBounds(200, 68, 60, 20);
		panelDadosServico.add(label_55);
		
		label_56 = new JLabel("Logradouro:");
		label_56.setForeground(Color.WHITE);
		label_56.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_56.setBounds(28, 99, 86, 20);
		panelDadosServico.add(label_56);
		
		label_57 = new JLabel("Num: ");
		label_57.setForeground(Color.WHITE);
		label_57.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_57.setBounds(562, 99, 39, 20);
		panelDadosServico.add(label_57);
		
		label_58 = new JLabel("Nome:");
		label_58.setForeground(Color.WHITE);
		label_58.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_58.setBounds(67, 6, 46, 20);
		panelDadosServico.add(label_58);
		
		label_59 = new JLabel("Complemento: ");
		label_59.setForeground(Color.WHITE);
		label_59.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_59.setBounds(15, 130, 98, 20);
		panelDadosServico.add(label_59);
		
		label_60 = new JLabel("CEP: ");
		label_60.setForeground(Color.WHITE);
		label_60.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_60.setBounds(76, 161, 31, 20);
		panelDadosServico.add(label_60);
		
		label_61 = new JLabel("Bairro: ");
		label_61.setForeground(Color.WHITE);
		label_61.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_61.setBounds(261, 161, 54, 20);
		panelDadosServico.add(label_61);
		
		label_62 = new JLabel("Cidade: ");
		label_62.setForeground(Color.WHITE);
		label_62.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_62.setBounds(493, 161, 68, 20);
		panelDadosServico.add(label_62);
		
		label_63 = new JLabel("Pais: ");
		label_63.setForeground(Color.WHITE);
		label_63.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_63.setBounds(435, 192, 46, 20);
		panelDadosServico.add(label_63);
		
		label_64 = new JLabel("Estado:");
		label_64.setForeground(Color.WHITE);
		label_64.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_64.setBounds(57, 192, 60, 20);
		panelDadosServico.add(label_64);
		
		textNome = new JTextField();
		textNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNome.setColumns(10);
		textNome.setBorder(new LineBorder(new Color(0, 102, 153)));
		textNome.setBounds(108, 6, 322, 20);
		panelDadosServico.add(textNome);
		
		textHorario = new JTextField();
		textHorario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textHorario.setColumns(10);
		textHorario.setBorder(new LineBorder(new Color(0, 102, 153)));
		textHorario.setBounds(108, 68, 53, 20);
		panelDadosServico.add(textHorario);
		
		textVagas = new JTextField();
		textVagas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textVagas.setColumns(10);
		textVagas.setBorder(new LineBorder(new Color(0, 102, 153)));
		textVagas.setBounds(108, 37, 110, 20);
		panelDadosServico.add(textVagas);
		
		textCodigo = new JTextField();
		textCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textCodigo.setColumns(10);
		textCodigo.setBorder(new LineBorder(new Color(0, 102, 153)));
		textCodigo.setBounds(516, 6, 158, 20);
		panelDadosServico.add(textCodigo);
		
		textDuracao = new JTextField();
		textDuracao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textDuracao.setColumns(10);
		textDuracao.setBorder(new LineBorder(new Color(0, 102, 153)));
		textDuracao.setBounds(256, 68, 53, 20);
		panelDadosServico.add(textDuracao);
		
		textLogradouro = new JTextField();
		textLogradouro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textLogradouro.setColumns(10);
		textLogradouro.setBorder(new LineBorder(new Color(0, 102, 153)));
		textLogradouro.setBounds(108, 99, 425, 20);
		panelDadosServico.add(textLogradouro);
		
		textNumero = new JTextField();
		textNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNumero.setColumns(10);
		textNumero.setBorder(new LineBorder(new Color(0, 102, 153)));
		textNumero.setBounds(595, 99, 79, 20);
		panelDadosServico.add(textNumero);
		
		textComplemento = new JTextField();
		textComplemento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textComplemento.setColumns(10);
		textComplemento.setBorder(new LineBorder(new Color(0, 102, 153)));
		textComplemento.setBounds(108, 130, 566, 20);
		panelDadosServico.add(textComplemento);
		
		textCEP = new JTextField();
		textCEP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textCEP.setColumns(10);
		textCEP.setBorder(new LineBorder(new Color(0, 102, 153)));
		textCEP.setBounds(107, 161, 110, 20);
		panelDadosServico.add(textCEP);
		
		textBairro = new JTextField();
		textBairro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textBairro.setColumns(10);
		textBairro.setBorder(new LineBorder(new Color(0, 102, 153)));
		textBairro.setBounds(305, 161, 136, 20);
		panelDadosServico.add(textBairro);
		
		textCidade = new JTextField();
		textCidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textCidade.setColumns(10);
		textCidade.setBorder(new LineBorder(new Color(0, 102, 153)));
		textCidade.setBounds(542, 161, 132, 20);
		panelDadosServico.add(textCidade);
		
		textPais = new JTextField();
		textPais.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textPais.setColumns(10);
		textPais.setBorder(new LineBorder(new Color(0, 102, 153)));
		textPais.setBounds(468, 192, 206, 20);
		panelDadosServico.add(textPais);
		
		comboBoxDia = new JComboBox<Object>(dias);
		comboBoxDia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxDia.setBackground(Color.WHITE);
		comboBoxDia.setBounds(453, 37, 39, 20);
		panelDadosServico.add(comboBoxDia);
		
		comboBoxMes = new JComboBox<Object>(meses);
		comboBoxMes.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxMes.setBackground(Color.WHITE);
		comboBoxMes.setBounds(502, 37, 110, 20);
		panelDadosServico.add(comboBoxMes);
		
		comboBoxAnos = new JComboBox<Object>(maisAnos);
		comboBoxAnos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxAnos.setBackground(Color.WHITE);
		comboBoxAnos.setBounds(622, 37, 52, 20);
		panelDadosServico.add(comboBoxAnos);
		
		comboBoxEstado = new JComboBox<Object>(Estado.getEstados());
		comboBoxEstado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxEstado.setBackground(Color.WHITE);
		comboBoxEstado.setBounds(108, 192, 282, 20);
		panelDadosServico.add(comboBoxEstado);
		
		label_65 = new JLabel("Descri\u00E7\u00E3o:");
		label_65.setForeground(Color.WHITE);
		label_65.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_65.setBounds(42, 223, 68, 20);
		panelDadosServico.add(label_65);
		
		panelDadosCurso = new JPanel();
		panelDadosCurso.setLayout(null);
		panelDadosCurso.setBackground(new Color(0, 153, 204));
		panelDadosCurso.setBounds(399, 223, 279, 172);
		panelDadosServico.add(panelDadosCurso);
		
		
		label_66 = new JLabel("Professor:");
		label_66.setForeground(Color.WHITE);
		label_66.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_66.setBounds(12, 0, 98, 20);
		panelDadosCurso.add(label_66);
		
		textProfessor = new JTextField();
		textProfessor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textProfessor.setColumns(10);
		textProfessor.setBorder(new LineBorder(new Color(0, 102, 153)));
		textProfessor.setBounds(77, 0, 198, 20);
		panelDadosCurso.add(textProfessor);
		
		label_67 = new JLabel("Carga hor\u00E1ria:");
		label_67.setForeground(Color.WHITE);
		label_67.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_67.setBounds(72, 31, 98, 20);
		panelDadosCurso.add(label_67);
		
		textCarga = new JTextField();
		textCarga.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textCarga.setColumns(10);
		textCarga.setBorder(new LineBorder(new Color(0, 102, 153)));
		textCarga.setBounds(162, 31, 113, 20);
		panelDadosCurso.add(textCarga);
		
		checkBoxSeg = new JCheckBox("SEG");
		checkBoxSeg.setForeground(Color.WHITE);
		checkBoxSeg.setFont(new Font("Tahoma", Font.BOLD, 12));
		checkBoxSeg.setBackground(new Color(0, 153, 204));
		checkBoxSeg.setBounds(6, 80, 55, 23);
		panelDadosCurso.add(checkBoxSeg);
		
		checkBoxTer = new JCheckBox("TER");
		checkBoxTer.setForeground(Color.WHITE);
		checkBoxTer.setFont(new Font("Tahoma", Font.BOLD, 12));
		checkBoxTer.setBackground(new Color(0, 153, 204));
		checkBoxTer.setBounds(62, 80, 55, 23);
		panelDadosCurso.add(checkBoxTer);
		
		checkBoxQua = new JCheckBox("QUA");
		checkBoxQua.setForeground(Color.WHITE);
		checkBoxQua.setFont(new Font("Tahoma", Font.BOLD, 12));
		checkBoxQua.setBackground(new Color(0, 153, 204));
		checkBoxQua.setBounds(119, 80, 55, 23);
		panelDadosCurso.add(checkBoxQua);
		
		checkBoxQui = new JCheckBox("QUI");
		checkBoxQui.setForeground(Color.WHITE);
		checkBoxQui.setFont(new Font("Tahoma", Font.BOLD, 12));
		checkBoxQui.setBackground(new Color(0, 153, 204));
		checkBoxQui.setBounds(176, 80, 55, 23);
		panelDadosCurso.add(checkBoxQui);
		
		checkBoxSex = new JCheckBox("SEX");
		checkBoxSex.setForeground(Color.WHITE);
		checkBoxSex.setFont(new Font("Tahoma", Font.BOLD, 12));
		checkBoxSex.setBackground(new Color(0, 153, 204));
		checkBoxSex.setBounds(6, 106, 55, 23);
		panelDadosCurso.add(checkBoxSex);
		
		checkBoxSab = new JCheckBox("SAB");
		checkBoxSab.setForeground(Color.WHITE);
		checkBoxSab.setFont(new Font("Tahoma", Font.BOLD, 12));
		checkBoxSab.setBackground(new Color(0, 153, 204));
		checkBoxSab.setBounds(62, 106, 55, 23);
		panelDadosCurso.add(checkBoxSab);
		
		checkBoxDom = new JCheckBox("DOM");
		checkBoxDom.setForeground(Color.WHITE);
		checkBoxDom.setFont(new Font("Tahoma", Font.BOLD, 12));
		checkBoxDom.setBackground(new Color(0, 153, 204));
		checkBoxDom.setBounds(119, 106, 55, 23);
		panelDadosCurso.add(checkBoxDom);
		
		label_68 = new JLabel("Dias com aula:");
		label_68.setForeground(Color.WHITE);
		label_68.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_68.setBounds(11, 62, 98, 14);
		panelDadosCurso.add(label_68);
		
		panelDadosPalestra = new JPanel();
		panelDadosPalestra.setLayout(null);
		panelDadosPalestra.setBackground(new Color(0, 153, 204));
		panelDadosPalestra.setBounds(399, 223, 279, 170);
		panelDadosServico.add(panelDadosPalestra);
		
		label_69 = new JLabel("Palestrante:");
		label_69.setForeground(Color.WHITE);
		label_69.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_69.setBounds(14, 0, 98, 20);
		panelDadosPalestra.add(label_69);
		
		textPalestrante = new JTextField();
		textPalestrante.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textPalestrante.setColumns(10);
		textPalestrante.setBorder(new LineBorder(new Color(0, 102, 153)));
		textPalestrante.setBounds(92, 0, 184, 20);
		panelDadosPalestra.add(textPalestrante);
		
		textDescricao = new JTextField();
		textDescricao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textDescricao.setColumns(10);
		textDescricao.setBorder(new LineBorder(new Color(0, 102, 153)));
		textDescricao.setBounds(108, 223, 281, 124);
		panelDadosServico.add(textDescricao);
		
		button_3 = new JButton("Cancelar");
		button_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_3.setBorder(new LineBorder(new Color(0, 102, 153)));
		button_3.setBackground(Color.WHITE);
		button_3.setBounds(10, 369, 104, 23);
		panelDadosServico.add(button_3);
		
		button_4 = new JButton("Atualizar");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Servico servico = fachada.procurarServico(textsaBuscar.getText());
					
					String nome = textNome.getText();
					int vagas = 0;
					if(textVagas.getText().matches("[0-9]+")){
						vagas = Integer.parseInt(textVagas.getText());
					} else {
						throw new ValorInvalidoException("vagas");
					}
					int dia = comboBoxDia.getSelectedIndex() + 1;
					int mes = comboBoxMes.getSelectedIndex() + 1;
					String data = new Date().toString();
					int ano = Integer.parseInt(data.substring(data.length()- 4, data.length())) + comboBoxAnos.getSelectedIndex();
					String horario = textHorario.getText();
					double duracao = 0;
					if(textDuracao.getText().matches("[0-9]+\\,{0,1}[0-9]*")){
						duracao = Double.parseDouble(textDuracao.getText().replace(',', '.'));
					} else {
						throw new ValorInvalidoException("duração");
					}
					String logradouro = textLogradouro.getText();
					int numero = 0;
					if(textNumero.getText().matches("[0-9]+")){
						numero = Integer.parseInt(textNumero.getText());
					} else {
						throw new ValorInvalidoException("número");
					}
					String complemento = textComplemento.getText();
					String CEP = textCEP.getText();
					String bairro = textBairro.getText();
					String cidade = textCidade.getText();
					Estado estado = Estado.seletor(comboBoxEstado.getSelectedIndex());
					String pais = textPais.getText();
					String descricao = textDescricao.getText();
					Data dat = new Data(dia, mes, ano);
					Endereco endereco = new Endereco(logradouro, numero, complemento, CEP, bairro, cidade, estado, pais);
					
					servico.setNome(nome);
					servico.setVagas(vagas);
					servico.setData(dat);
					servico.setHorario(horario);
					servico.setDuracao(duracao);
					servico.setEndereco(endereco);
					servico.setDescricao(descricao);
					
					if(servico instanceof Palestra){
						String palestrante = textPalestrante.getText();
						((Palestra)servico).setPalestrante(palestrante);
						
						fachada.atualizarServico(servico);
					} else {
						String professor = textProfessor.getText();
						double hora = 0;
						if(textCarga.getText().matches("[0-9]+\\,{0,1}[0-9]*")){
							hora = Double.parseDouble(textCarga.getText().replace(',', '.'));
						} else {
							throw new ValorInvalidoException("carga horária");
						}
						int contador = 0;
						if(checkBoxSeg.isSelected()){
							contador++;
						}
						if(checkBoxTer.isSelected()){
							contador++;
						}
						if(checkBoxQua.isSelected()){
							contador++;
						}
						if(checkBoxQui.isSelected()){
							contador++;
						}
						if(checkBoxSex.isSelected()){
							contador++;
						}
						if(checkBoxSab.isSelected()){
							contador++;
						}
						if(checkBoxDom.isSelected()){
							contador++;
						}
						
						if(contador==0){
							contador++;
						}
						Dia[] dias = new Dia[contador];
						contador = 0;
						if(checkBoxSeg.isSelected()){
							dias[contador++] = Dia.SEGUNDAFEIRA;
						}
						if(checkBoxTer.isSelected()){
							dias[contador++] = Dia.TERCAFEIRA;
						}
						if(checkBoxQua.isSelected()){
							dias[contador++] = Dia.QUARTAFEIRA;
						}
						if(checkBoxQui.isSelected()){
							dias[contador++] = Dia.QUINTAFEIRA;
						}
						if(checkBoxSex.isSelected()){
							dias[contador++] = Dia.SEXTAFEIRA;
						}
						if(checkBoxSab.isSelected()){
							dias[contador++] = Dia.SABADO;
						}
						if(checkBoxDom.isSelected()){
							dias[contador++] = Dia.DOMINGO;
						}
						
						((Curso)servico).setProfessor(professor);
						((Curso)servico).setCargaHoraria(hora);
						((Curso)servico).setDias(dias);
						
						
						fachada.atualizarServico(servico);
					}
					JOptionPane.showMessageDialog(panelDadosServico, "Serviço atualizado com sucesso", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
					panelHome.setVisible(true);
					panelAtualizar.setVisible(false);
				} catch (ValorInvalidoException e1) {
					JOptionPane.showMessageDialog(panelDadosServico, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				} catch (RepositorioException e1) {
					JOptionPane.showMessageDialog(panelDadosServico, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				} catch (ValorNaoEncontradoException e1) {
					JOptionPane.showMessageDialog(panelDadosServico, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				}
			}
		});
		button_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_4.setBorder(new LineBorder(new Color(0, 102, 153)));
		button_4.setBackground(Color.WHITE);
		button_4.setBounds(124, 369, 104, 23);
		panelDadosServico.add(button_4);
		
		panelAtualizarProduto = new JPanel();
		panelAtualizarProduto.setLayout(null);
		panelAtualizarProduto.setBackground(new Color(0, 153, 204));
		panelAtualizarProduto.setBounds(0, 0, 684, 440);
		panelAtualizar.add(panelAtualizarProduto);
		
		lblDigiteOIsbn_2 = new JLabel("Digite o ISBN:");
		lblDigiteOIsbn_2.setForeground(Color.WHITE);
		lblDigiteOIsbn_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDigiteOIsbn_2.setBounds(7, 12, 133, 20);
		panelAtualizarProduto.add(lblDigiteOIsbn_2);
		
		textaProduto = new JTextField();
		textaProduto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					buttonaBuscar.doClick();
				}
			}
		});
		textaProduto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textaProduto.setColumns(10);
		textaProduto.setBorder(new LineBorder(new Color(0, 102, 153)));
		textaProduto.setBounds(97, 12, 463, 20);
		panelAtualizarProduto.add(textaProduto);
		
		buttonaBuscar = new JButton("Buscar");
		buttonaBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Produto produto = fachada.procurarProduto(textaProduto.getText());
					panelDadosProduto.setVisible(true);
					
					
					textapTitulo.setText(produto.getTitulo());
					textapISBN.setText(produto.getISBN());
					textapISBN.setEnabled(false);
					textapPreco.setText(produto.getPreco()+"");
					textapAutor.setText(produto.getAutor());
					textapEditora.setText(produto.getEditora());
					textapEdicao.setText(produto.getEdicao()+"");
					textapAno.setText(produto.getAno()+"");
					//comboBoxapIdioma.setSelectedIndex(0);
					if(produto instanceof Livro){
						panelDadosLivro.setVisible(true);
						panelDadosEbook.setVisible(false);
						textapNumeroPag.setText(((Livro)produto).getNPags()+"");
						textapQuantEstoque.setText(((Livro)produto).getQntdEstoque()+"");
						textapPeso.setText(((Livro)produto).getPeso()+"");
						textapAltura.setText(((Livro)produto).getAltura()+"");
						textapLargura.setText(((Livro)produto).getLargura()+"");
						textapComprimento.setText(((Livro)produto).getComprimento()+"");
					} else{
						panelDadosLivro.setVisible(false);
						panelDadosEbook.setVisible(true);
						textapTamanho.setText(((Ebook)produto).getTamanho()+"");
						textapQuantLicenca.setText(((Ebook)produto).getQntdLicenca()+"");
						//comboBoxapFomatos.setSelectedIndex(0);
					}
					panelDadosProduto.setVisible(true);
				} catch (RepositorioException e1) {
					JOptionPane.showMessageDialog(panelAtualizarProduto, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				} catch (ValorNaoEncontradoException e1) {
					JOptionPane.showMessageDialog(panelAtualizarProduto, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				}
				
			}
		});
		buttonaBuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonaBuscar.setBorder(new LineBorder(new Color(0, 102, 153)));
		buttonaBuscar.setBackground(Color.WHITE);
		buttonaBuscar.setBounds(570, 11, 104, 23);
		panelAtualizarProduto.add(buttonaBuscar);
		
		panelDadosProduto = new JPanel();
		panelDadosProduto.setBackground(new Color(0, 153, 204));
		panelDadosProduto.setBounds(0, 37, 684, 403);
		panelAtualizarProduto.add(panelDadosProduto);
		panelDadosProduto.setLayout(null);
		
		JLabel label_34 = new JLabel("Titulo:");
		label_34.setForeground(Color.WHITE);
		label_34.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_34.setBounds(16, 6, 46, 20);
		panelDadosProduto.add(label_34);
		
		JLabel label_35 = new JLabel("Pre\u00E7o:");
		label_35.setForeground(Color.WHITE);
		label_35.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_35.setBounds(17, 37, 46, 20);
		panelDadosProduto.add(label_35);
		
		JLabel label_36 = new JLabel("Edi\u00E7\u00E3o: ");
		label_36.setForeground(Color.WHITE);
		label_36.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_36.setBounds(12, 68, 61, 20);
		panelDadosProduto.add(label_36);
		
		JLabel label_37 = new JLabel("ISBN: ");
		label_37.setForeground(Color.WHITE);
		label_37.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_37.setBounds(458, 6, 46, 20);
		panelDadosProduto.add(label_37);
		
		JLabel label_38 = new JLabel("Autor: ");
		label_38.setForeground(Color.WHITE);
		label_38.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_38.setBounds(226, 37, 46, 20);
		panelDadosProduto.add(label_38);
		
		JLabel label_39 = new JLabel("Editora:");
		label_39.setForeground(Color.WHITE);
		label_39.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_39.setBounds(462, 37, 56, 20);
		panelDadosProduto.add(label_39);
		
		JLabel label_40 = new JLabel("Ano: ");
		label_40.setForeground(Color.WHITE);
		label_40.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_40.setBounds(198, 68, 61, 20);
		panelDadosProduto.add(label_40);
		
		JLabel label_41 = new JLabel("Idioma: ");
		label_41.setForeground(Color.WHITE);
		label_41.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_41.setBounds(348, 68, 61, 20);
		panelDadosProduto.add(label_41);
		
		textapTitulo = new JTextField();
		textapTitulo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textapTitulo.setColumns(10);
		textapTitulo.setBorder(new LineBorder(new Color(0, 102, 153)));
		textapTitulo.setBounds(61, 6, 371, 20);
		panelDadosProduto.add(textapTitulo);
		
		textapPreco = new JTextField();
		textapPreco.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textapPreco.setColumns(10);
		textapPreco.setBorder(new LineBorder(new Color(0, 102, 153)));
		textapPreco.setBounds(61, 37, 121, 20);
		panelDadosProduto.add(textapPreco);
		
		textapEdicao = new JTextField();
		textapEdicao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textapEdicao.setColumns(10);
		textapEdicao.setBorder(new LineBorder(new Color(0, 102, 153)));
		textapEdicao.setBounds(61, 68, 85, 20);
		panelDadosProduto.add(textapEdicao);
		
		textapISBN = new JTextField();
		textapISBN.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textapISBN.setColumns(10);
		textapISBN.setBorder(new LineBorder(new Color(0, 102, 153)));
		textapISBN.setBounds(496, 6, 182, 20);
		panelDadosProduto.add(textapISBN);
		
		textapAutor = new JTextField();
		textapAutor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textapAutor.setColumns(10);
		textapAutor.setBorder(new LineBorder(new Color(0, 102, 153)));
		textapAutor.setBounds(270, 37, 162, 20);
		panelDadosProduto.add(textapAutor);
		
		textapEditora = new JTextField();
		textapEditora.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textapEditora.setColumns(10);
		textapEditora.setBorder(new LineBorder(new Color(0, 102, 153)));
		textapEditora.setBounds(516, 37, 162, 20);
		panelDadosProduto.add(textapEditora);
		
		textapAno = new JTextField();
		textapAno.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textapAno.setColumns(10);
		textapAno.setBorder(new LineBorder(new Color(0, 102, 153)));
		textapAno.setBounds(231, 68, 85, 20);
		panelDadosProduto.add(textapAno);
		
		comboBoxapIdioma = new JComboBox<Object>(Idioma.getIdiomas());
		comboBoxapIdioma.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxapIdioma.setBackground(Color.WHITE);
		comboBoxapIdioma.setBounds(399, 68, 279, 20);
		panelDadosProduto.add(comboBoxapIdioma);
		
		panelDadosEbook = new JPanel();
		panelDadosEbook.setBounds(3, 99, 681, 152);
		panelDadosProduto.add(panelDadosEbook);
		panelDadosEbook.setLayout(null);
		panelDadosEbook.setBackground(new Color(0, 153, 204));
		
		label_49 = new JLabel("Quant. Licen\u00E7a:");
		label_49.setForeground(Color.WHITE);
		label_49.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_49.setBounds(169, 1, 108, 20);
		panelDadosEbook.add(label_49);
		
		lblFormato = new JLabel("Formato:");
		lblFormato.setForeground(Color.WHITE);
		lblFormato.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFormato.setBounds(380, 1, 91, 20);
		panelDadosEbook.add(lblFormato);
		
		label_51 = new JLabel("Tamh:");
		label_51.setForeground(Color.WHITE);
		label_51.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_51.setBounds(15, 1, 59, 20);
		panelDadosEbook.add(label_51);
		
		textapTamanho = new JTextField();
		textapTamanho.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textapTamanho.setColumns(10);
		textapTamanho.setBorder(new LineBorder(new Color(0, 102, 153)));
		textapTamanho.setBounds(58, 1, 77, 20);
		panelDadosEbook.add(textapTamanho);
		
		textapQuantLicenca = new JTextField();
		textapQuantLicenca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textapQuantLicenca.setColumns(10);
		textapQuantLicenca.setBorder(new LineBorder(new Color(0, 102, 153)));
		textapQuantLicenca.setBounds(268, 1, 68, 20);
		panelDadosEbook.add(textapQuantLicenca);
		
		comboBoxapFomatos = new JComboBox<Object>(Formato.getFormatos());
		comboBoxapFomatos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxapFomatos.setBackground(Color.WHITE);
		comboBoxapFomatos.setBounds(441, 1, 233, 20);
		panelDadosEbook.add(comboBoxapFomatos);
		panelDadosEbook.setVisible(false);
		
		panelDadosLivro = new JPanel();
		panelDadosLivro.setBackground(new Color(0, 153, 204));
		panelDadosLivro.setBounds(5, 99, 679, 152);
		panelDadosProduto.add(panelDadosLivro);
		panelDadosLivro.setLayout(null);
		
		panelDadosLivro.setVisible(false);
		
		label_42 = new JLabel("N pag:");
		label_42.setForeground(Color.WHITE);
		label_42.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_42.setBounds(11, 1, 46, 20);
		panelDadosLivro.add(label_42);
		
		label_43 = new JLabel("Acabamento:");
		label_43.setForeground(Color.WHITE);
		label_43.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_43.setBounds(355, 1, 91, 20);
		panelDadosLivro.add(label_43);
		
		label_44 = new JLabel("Peso:");
		label_44.setForeground(Color.WHITE);
		label_44.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_44.setBounds(18, 32, 46, 20);
		panelDadosLivro.add(label_44);
		
		label_45 = new JLabel("Altura:");
		label_45.setForeground(Color.WHITE);
		label_45.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_45.setBounds(162, 32, 46, 20);
		panelDadosLivro.add(label_45);
		
		label_46 = new JLabel("Largura:");
		label_46.setForeground(Color.WHITE);
		label_46.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_46.setBounds(322, 32, 62, 20);
		panelDadosLivro.add(label_46);
		
		label_47 = new JLabel("Comprimento:");
		label_47.setForeground(Color.WHITE);
		label_47.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_47.setBounds(503, 32, 91, 20);
		panelDadosLivro.add(label_47);
		
		label_48 = new JLabel("Quant. Estoque:");
		label_48.setForeground(Color.WHITE);
		label_48.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_48.setBounds(164, 1, 108, 20);
		panelDadosLivro.add(label_48);
		
		textapNumeroPag = new JTextField();
		textapNumeroPag.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textapNumeroPag.setColumns(10);
		textapNumeroPag.setBorder(new LineBorder(new Color(0, 102, 153)));
		textapNumeroPag.setBounds(56, 1, 83, 20);
		panelDadosLivro.add(textapNumeroPag);
		
		textapQuantEstoque = new JTextField();
		textapQuantEstoque.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textapQuantEstoque.setColumns(10);
		textapQuantEstoque.setBorder(new LineBorder(new Color(0, 102, 153)));
		textapQuantEstoque.setBounds(268, 1, 68, 20);
		panelDadosLivro.add(textapQuantEstoque);
		
		textapPeso = new JTextField();
		textapPeso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textapPeso.setColumns(10);
		textapPeso.setBorder(new LineBorder(new Color(0, 102, 153)));
		textapPeso.setBounds(56, 32, 79, 20);
		panelDadosLivro.add(textapPeso);
		
		textapAltura = new JTextField();
		textapAltura.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textapAltura.setColumns(10);
		textapAltura.setBorder(new LineBorder(new Color(0, 102, 153)));
		textapAltura.setBounds(208, 32, 79, 20);
		panelDadosLivro.add(textapAltura);
		
		textapLargura = new JTextField();
		textapLargura.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textapLargura.setColumns(10);
		textapLargura.setBorder(new LineBorder(new Color(0, 102, 153)));
		textapLargura.setBounds(376, 32, 79, 20);
		panelDadosLivro.add(textapLargura);
		
		textapComprimento = new JTextField();
		textapComprimento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textapComprimento.setColumns(10);
		textapComprimento.setBorder(new LineBorder(new Color(0, 102, 153)));
		textapComprimento.setBounds(595, 32, 79, 20);
		panelDadosLivro.add(textapComprimento);
		
		comboBoxapAcabamento = new JComboBox<Object>(Acabamento.getAcabamentos());
		comboBoxapAcabamento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxapAcabamento.setBackground(Color.WHITE);
		comboBoxapAcabamento.setBounds(441, 1, 233, 20);
		panelDadosLivro.add(comboBoxapAcabamento);
		
		button = new JButton("Cancelar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(panelAtualizarProduto, "Deseja realmente cancelar a operação") == JOptionPane.YES_OPTION){
					panelAtualizar.setVisible(false);
					panelHome.setVisible(true);
				}
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		button.setBorder(new LineBorder(new Color(0, 102, 153)));
		button.setBackground(Color.WHITE);
		button.setBounds(10, 369, 104, 23);
		panelDadosProduto.add(button);
		
		button_1 = new JButton("Atualizar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Produto produto = fachada.procurarProduto(textaProduto.getText());
					
					String titulo = textapTitulo.getText();
					double preco = 0;
					if(textapPreco.getText().matches("[0-9]+\\,{0,1}[0-9]*")){
						preco = Double.parseDouble(textapPreco.getText().replace(',', '.'));
					} else {
						throw new ValorInvalidoException("preco");
					}
					String autor = textapAutor.getText();
					String editora = textapEditora.getText();
					int edicao = 0;
					if(textapEdicao.getText().matches("[0-9]+")){
						edicao = Integer.parseInt(textapEdicao.getText());
					} else {
						throw new ValorInvalidoException("edição");
					}
					int ano = 0;
					if(textapAno.getText().matches("[0-9]+")){
						ano = Integer.parseInt(textapAno.getText());
					} else {
						throw new ValorInvalidoException("ano");
					}
					Idioma idioma = Idioma.seletor(comboBoxapIdioma.getSelectedIndex());
					produto.setAno(ano);
					produto.setAutor(autor);
					produto.setEdicao(edicao);
					produto.setEditora(editora);
					produto.setIdioma(idioma);
					produto.setPreco(preco);
					produto.setTitulo(titulo);
					if(produto instanceof Ebook){
						double tamanho = 0;
						if(textapTamanho.getText().matches("[0-9]+\\,{0,1}[0-9]*")){
							tamanho = Double.parseDouble(textapTamanho.getText().replace(',', '.'));
						} else {
							throw new ValorInvalidoException("tamanho");
						}
						int quant = 0;
						if(textapQuantLicenca.getText().matches("[0-9]+")){
							quant = Integer.parseInt(textapQuantLicenca.getText());
						} else {
							throw new ValorInvalidoException("quantidade de licença");
						}
						Formato formato = Formato.seletor(comboBoxapFomatos.getSelectedIndex());
						((Ebook)produto).setTamanho(tamanho);
						((Ebook)produto).setQntdLicenca(quant);
						((Ebook)produto).setFormato(formato);
						fachada.atualizarProduto(produto);
					} else {
						int nPag = 0;
						if(textapNumeroPag.getText().matches("[0-9]+")){
							nPag = Integer.parseInt(textapNumeroPag.getText());
						} else {
							throw new ValorInvalidoException("numero de páginas");
						}
						int quant = 0;
						if(textapQuantEstoque.getText().matches("[0-9]+")){
							quant = Integer.parseInt(textapQuantEstoque.getText());
						} else {
							throw new ValorInvalidoException("quantidade em estoque");
						}
						Acabamento acabamento = Acabamento.seletor(comboBoxapAcabamento.getSelectedIndex());
						double peso = 0;
						if(textapPeso.getText().matches("[0-9]+\\,{0,1}[0-9]*")){
							peso = Double.parseDouble(textapPeso.getText().replace(',', '.'));
						} else {
							throw new ValorInvalidoException("peso");
						}
						double altura = 0;
						if(textapAltura.getText().matches("[0-9]+\\,{0,1}[0-9]*")){
							altura = Double.parseDouble(textapAltura.getText().replace(',', '.'));
						} else {
							throw new ValorInvalidoException("altura");
						}
						double largura = 0;
						if(textapLargura.getText().matches("[0-9]+\\,{0,1}[0-9]*")){
							largura = Double.parseDouble(textapLargura.getText().replace(',', '.'));
						} else {
							throw new ValorInvalidoException("largura");
						}
						double comprimento = 0;
						if(textapComprimento.getText().matches("[0-9]+\\,{0,1}[0-9]*")){
							comprimento = Double.parseDouble(textapComprimento.getText().replace(',', '.'));
						} else {
							throw new ValorInvalidoException("comprimento");
						}
						((Livro)produto).setNPags(nPag);
						((Livro)produto).setQntdEstoque(quant);
						((Livro)produto).setAcabamento(acabamento);
						((Livro)produto).setPeso(peso);
						((Livro)produto).setAltura(altura);
						((Livro)produto).setLargura(largura);
						((Livro)produto).setComprimento(comprimento);
						fachada.atualizarProduto(produto);
					}
					JOptionPane.showMessageDialog(panelDadosProduto, "Produto atualizado com sucesso", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
					panelHome.setVisible(true);
					panelAtualizar.setVisible(false);
				} catch (ValorInvalidoException e1) {
					JOptionPane.showMessageDialog(panelDadosProduto, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				} catch (RepositorioException e1) {
					JOptionPane.showMessageDialog(panelDadosProduto, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				} catch (ValorNaoEncontradoException e1) {
					JOptionPane.showMessageDialog(panelDadosProduto, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				}
			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_1.setBorder(new LineBorder(new Color(0, 102, 153)));
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(124, 369, 104, 23);
		panelDadosProduto.add(button_1);
		
		panelAtualizarPessoa = new JPanel();
		panelAtualizarPessoa.setLayout(null);
		panelAtualizarPessoa.setBackground(new Color(0, 153, 204));
		panelAtualizarPessoa.setBounds(0, 0, 684, 440);
		panelAtualizar.add(panelAtualizarPessoa);
		
		lblDigiteOCpf = new JLabel("Digite o CPF:");
		lblDigiteOCpf.setForeground(Color.WHITE);
		lblDigiteOCpf.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDigiteOCpf.setBounds(7, 12, 125, 20);
		panelAtualizarPessoa.add(lblDigiteOCpf);
		
		textapBuscar = new JTextField();
		textapBuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					buttonBuscarAtualizarPessoa.doClick();
				}
					
			}
		});
		textapBuscar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textapBuscar.setColumns(10);
		textapBuscar.setBorder(new LineBorder(new Color(0, 102, 153)));
		textapBuscar.setBounds(89, 12, 471, 20);
		panelAtualizarPessoa.add(textapBuscar);
		
		buttonBuscarAtualizarPessoa = new JButton("Buscar");
		buttonBuscarAtualizarPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Pessoa pessoa = fachada.procurarPessoa(textapBuscar.getText());
					panelDadosPessoa.setVisible(true);
					
					textapNome.setText(pessoa.getNome());
					textapEmail.setText(pessoa.getEmail());
					textapTelefone.setText(pessoa.getTelefone());
					textapLogradouro.setText(pessoa.getEndereco().getLogradouro());
					textapComplemento.setText(pessoa.getEndereco().getComplemento());
					textapCEP.setText(pessoa.getEndereco().getCEP());
					textapPais.setText(pessoa.getEndereco().getPais());
					textapCPF.setText(pessoa.getCPF());
					textapCPF.setEnabled(false);
					textapSenha.setText(pessoa.getSenha());
					textapNumero.setText(pessoa.getEndereco().getNumero()+"");
					textapBairro.setText(pessoa.getEndereco().getBairro());
					textapCidade.setText(pessoa.getEndereco().getCidade());
					if(pessoa.getSexo() == 'M'){
						comboBoxapSexo.setSelectedIndex(0);
					} else {
						comboBoxapSexo.setSelectedIndex(1);
					}
					comboBoxapDias.setSelectedIndex(pessoa.getData().getDia()-1);
					comboBoxapMeses.setSelectedIndex(pessoa.getData().getMes()-1);
					String dat = new Date().toString();
					comboBoapAnos.setSelectedIndex(Integer.parseInt(dat.substring(dat.length()-4, dat.length())) - pessoa.getData().getAno());
					//comboBoxapEstados.setSelectedIndex((int)pessoa.getEndereco().getEstado());
					if(pessoa instanceof Funcionario){
						panelDadosFuncionario.setVisible(true);
						textapSalario.setText(((Funcionario)pessoa).getSalario()+"");
						textapHorasSemanais.setText(((Funcionario)pessoa).getHorasSemanais()+"");
						//private JComboBox comboBoxapCargo;
					} else{
						panelDadosFuncionario.setVisible(false);
					}
					panelDadosPessoa.setVisible(true);
				} catch (RepositorioException e1) {
					JOptionPane.showMessageDialog(panelAtualizarPessoa, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				} catch (ValorNaoEncontradoException e1) {
					JOptionPane.showMessageDialog(panelAtualizarPessoa, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				}
			}
		});
		buttonBuscarAtualizarPessoa.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonBuscarAtualizarPessoa.setBorder(new LineBorder(new Color(0, 102, 153)));
		buttonBuscarAtualizarPessoa.setBackground(Color.WHITE);
		buttonBuscarAtualizarPessoa.setBounds(570, 11, 104, 23);
		panelAtualizarPessoa.add(buttonBuscarAtualizarPessoa);
		
		panelDadosPessoa = new JPanel();
		panelDadosPessoa.setBackground(new Color(0, 153, 204));
		panelDadosPessoa.setBounds(0, 37, 684, 403);
		panelAtualizarPessoa.add(panelDadosPessoa);
		panelDadosPessoa.setLayout(null);
		panelDadosPessoa.setVisible(false);
		
		label_1 = new JLabel("Nome:");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(66, 6, 46, 20);
		panelDadosPessoa.add(label_1);
		
		label_2 = new JLabel("Email: ");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(68, 37, 39, 20);
		panelDadosPessoa.add(label_2);
		
		label_3 = new JLabel("Telefone: ");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_3.setBounds(47, 68, 60, 20);
		panelDadosPessoa.add(label_3);
		
		label_4 = new JLabel("Logradouro:");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_4.setBounds(26, 99, 86, 20);
		panelDadosPessoa.add(label_4);
		
		label_5 = new JLabel("Complemento: ");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_5.setBounds(13, 130, 98, 20);
		panelDadosPessoa.add(label_5);
		
		label_14 = new JLabel("CEP: ");
		label_14.setForeground(Color.WHITE);
		label_14.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_14.setBounds(75, 161, 31, 20);
		panelDadosPessoa.add(label_14);
		
		label_15 = new JLabel("Estado:");
		label_15.setForeground(Color.WHITE);
		label_15.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_15.setBounds(56, 192, 57, 20);
		panelDadosPessoa.add(label_15);
		
		label_16 = new JLabel("CPF:");
		label_16.setForeground(Color.WHITE);
		label_16.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_16.setBounds(521, 6, 46, 20);
		panelDadosPessoa.add(label_16);
		
		label_17 = new JLabel("Senha:");
		label_17.setForeground(Color.WHITE);
		label_17.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_17.setBounds(468, 37, 46, 20);
		panelDadosPessoa.add(label_17);
		
		label_18 = new JLabel("Sexo: ");
		label_18.setForeground(Color.WHITE);
		label_18.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_18.setBounds(253, 68, 60, 20);
		panelDadosPessoa.add(label_18);
		
		label_19 = new JLabel("Data de Nasc.:");
		label_19.setForeground(Color.WHITE);
		label_19.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_19.setBounds(361, 68, 98, 20);
		panelDadosPessoa.add(label_19);
		
		label_20 = new JLabel("Num: ");
		label_20.setForeground(Color.WHITE);
		label_20.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_20.setBounds(563, 99, 39, 20);
		panelDadosPessoa.add(label_20);
		
		label_21 = new JLabel("Bairro: ");
		label_21.setForeground(Color.WHITE);
		label_21.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_21.setBounds(260, 161, 54, 20);
		panelDadosPessoa.add(label_21);
		
		label_22 = new JLabel("Cidade: ");
		label_22.setForeground(Color.WHITE);
		label_22.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_22.setBounds(492, 161, 68, 20);
		panelDadosPessoa.add(label_22);
		
		label_23 = new JLabel("Pais: ");
		label_23.setForeground(Color.WHITE);
		label_23.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_23.setBounds(435, 192, 46, 20);
		panelDadosPessoa.add(label_23);
		
		label_24 = new JLabel("");
		label_24.setForeground(new Color(204, 51, 51));
		label_24.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_24.setBackground(new Color(0, 153, 204));
		label_24.setBounds(249, 385, 429, 14);
		panelDadosPessoa.add(label_24);
		
		textapNome = new JTextField();
		textapNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textapNome.setColumns(10);
		textapNome.setBorder(new LineBorder(new Color(0, 102, 153)));
		textapNome.setBounds(107, 6, 384, 20);
		panelDadosPessoa.add(textapNome);
		
		textapEmail = new JTextField();
		textapEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textapEmail.setColumns(10);
		textapEmail.setBorder(new LineBorder(new Color(0, 102, 153)));
		textapEmail.setBounds(107, 37, 307, 20);
		panelDadosPessoa.add(textapEmail);
		
		textapTelefone = new JTextField();
		textapTelefone.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textapTelefone.setColumns(10);
		textapTelefone.setBorder(new LineBorder(new Color(0, 102, 153)));
		textapTelefone.setBounds(107, 68, 110, 20);
		panelDadosPessoa.add(textapTelefone);
		
		textapLogradouro = new JTextField();
		textapLogradouro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textapLogradouro.setColumns(10);
		textapLogradouro.setBorder(new LineBorder(new Color(0, 102, 153)));
		textapLogradouro.setBounds(107, 99, 425, 20);
		panelDadosPessoa.add(textapLogradouro);
		
		textapComplemento = new JTextField();
		textapComplemento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textapComplemento.setColumns(10);
		textapComplemento.setBorder(new LineBorder(new Color(0, 102, 153)));
		textapComplemento.setBounds(107, 130, 571, 20);
		panelDadosPessoa.add(textapComplemento);
		
		textapCEP = new JTextField();
		textapCEP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textapCEP.setColumns(10);
		textapCEP.setBorder(new LineBorder(new Color(0, 102, 153)));
		textapCEP.setBounds(107, 161, 110, 20);
		panelDadosPessoa.add(textapCEP);
		
		textapPais = new JTextField();
		textapPais.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textapPais.setColumns(10);
		textapPais.setBorder(new LineBorder(new Color(0, 102, 153)));
		textapPais.setBounds(468, 192, 210, 20);
		panelDadosPessoa.add(textapPais);
		
		textapCPF = new JTextField();
		textapCPF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textapCPF.setColumns(10);
		textapCPF.setBorder(new LineBorder(new Color(0, 102, 153)));
		textapCPF.setBounds(551, 6, 127, 20);
		panelDadosPessoa.add(textapCPF);
		
		textapSenha = new JTextField();
		textapSenha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textapSenha.setColumns(10);
		textapSenha.setBorder(new LineBorder(new Color(0, 102, 153)));
		textapSenha.setBounds(514, 37, 164, 20);
		panelDadosPessoa.add(textapSenha);
		
		textapNumero = new JTextField();
		textapNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textapNumero.setColumns(10);
		textapNumero.setBorder(new LineBorder(new Color(0, 102, 153)));
		textapNumero.setBounds(599, 99, 79, 20);
		panelDadosPessoa.add(textapNumero);
		
		textapBairro = new JTextField();
		textapBairro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textapBairro.setColumns(10);
		textapBairro.setBorder(new LineBorder(new Color(0, 102, 153)));
		textapBairro.setBounds(305, 161, 136, 20);
		panelDadosPessoa.add(textapBairro);
		
		textapCidade = new JTextField();
		textapCidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textapCidade.setColumns(10);
		textapCidade.setBorder(new LineBorder(new Color(0, 102, 153)));
		textapCidade.setBounds(542, 161, 136, 20);
		panelDadosPessoa.add(textapCidade);
		
		comboBoxapSexo = new JComboBox<Object>(sexos);
		comboBoxapSexo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxapSexo.setBackground(Color.WHITE);
		comboBoxapSexo.setBounds(291, 68, 39, 20);
		panelDadosPessoa.add(comboBoxapSexo);
		
		comboBoxapDias = new JComboBox<Object>(dias);
		comboBoxapDias.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxapDias.setBackground(Color.WHITE);
		comboBoxapDias.setBounds(453, 68, 39, 20);
		panelDadosPessoa.add(comboBoxapDias);
		
		comboBoxapMeses = new JComboBox<Object>(meses);
		comboBoxapMeses.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxapMeses.setBackground(Color.WHITE);
		comboBoxapMeses.setBounds(502, 68, 110, 20);
		panelDadosPessoa.add(comboBoxapMeses);
		
		comboBoapAnos = new JComboBox<Object>(anos);
		comboBoapAnos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoapAnos.setBackground(Color.WHITE);
		comboBoapAnos.setBounds(622, 68, 56, 20);
		panelDadosPessoa.add(comboBoapAnos);
		
		comboBoxapEstados = new JComboBox<Object>(Estado.getEstados());
		comboBoxapEstados.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxapEstados.setBackground(Color.WHITE);
		comboBoxapEstados.setBounds(107, 192, 282, 20);
		panelDadosPessoa.add(comboBoxapEstados);
		
		panelDadosFuncionario = new JPanel();
		panelDadosFuncionario.setBackground(new Color(0, 153, 204));
		panelDadosFuncionario.setBounds(0, 225, 684, 128);
		panelDadosPessoa.add(panelDadosFuncionario);
		panelDadosFuncionario.setLayout(null);
		
		label_25 = new JLabel("Salario: ");
		label_25.setForeground(Color.WHITE);
		label_25.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_25.setBounds(56, 0, 49, 20);
		panelDadosFuncionario.add(label_25);
		
		label_26 = new JLabel("Cargo: ");
		label_26.setForeground(Color.WHITE);
		label_26.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_26.setBounds(226, 0, 54, 20);
		panelDadosFuncionario.add(label_26);
		
		label_27 = new JLabel("Horas semanais: ");
		label_27.setForeground(Color.WHITE);
		label_27.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_27.setBounds(477, 0, 110, 20);
		panelDadosFuncionario.add(label_27);
		
		textapSalario = new JTextField();
		textapSalario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textapSalario.setColumns(10);
		textapSalario.setBorder(new LineBorder(new Color(0, 102, 153)));
		textapSalario.setBounds(107, 0, 83, 20);
		panelDadosFuncionario.add(textapSalario);
		
		textapHorasSemanais = new JTextField();
		textapHorasSemanais.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textapHorasSemanais.setColumns(10);
		textapHorasSemanais.setBorder(new LineBorder(new Color(0, 102, 153)));
		textapHorasSemanais.setBounds(580, 0, 94, 20);
		panelDadosFuncionario.add(textapHorasSemanais);
		
		comboBoxapCargo = new JComboBox<Object>(Cargo.getCargos());
		comboBoxapCargo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxapCargo.setBackground(Color.WHITE);
		comboBoxapCargo.setBounds(271, 0, 174, 20);
		panelDadosFuncionario.add(comboBoxapCargo);
		
		buttonCancelarAtualizarPessoa = new JButton("Cancelar");
		buttonCancelarAtualizarPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(panelAtualizarPessoa, "Deseja realmente cancelar a operação") == JOptionPane.YES_OPTION){
					panelAtualizar.setVisible(false);
					panelHome.setVisible(true);
				}
			}
		});
		buttonCancelarAtualizarPessoa.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonCancelarAtualizarPessoa.setBorder(new LineBorder(new Color(0, 102, 153)));
		buttonCancelarAtualizarPessoa.setBackground(Color.WHITE);
		buttonCancelarAtualizarPessoa.setBounds(10, 369, 104, 23);
		panelDadosPessoa.add(buttonCancelarAtualizarPessoa);
		
		buttonAtualizarPessoa = new JButton("Atualizar");
		buttonAtualizarPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Pessoa pessoa = fachada.procurarPessoa(textapCPF.getText());
					String nome = textapNome.getText();
					String email = textapEmail.getText();
					String senha = textapSenha.getText();
					String telefone = textapTelefone.getText();
					char sexo = sexos[comboBoxapSexo.getSelectedIndex()].charAt(0);
					int dia = comboBoxapDias.getSelectedIndex() + 1;
					int mes = comboBoxapMeses.getSelectedIndex() + 1;
					String data = new Date().toString();
					int ano = Integer.parseInt(data.substring(data.length()- 4, data.length())) - comboBoapAnos.getSelectedIndex();
					String logradouro = textapLogradouro.getText();
					int numero = 0;
					if(textapNumero.getText().matches("[0-9]+")){
						numero = Integer.parseInt(textapNumero.getText());
					} else {
						throw new ValorInvalidoException("número");
					}
					String complemento = textapComplemento.getText();
					String CEP = textapCEP.getText();
					String bairro = textapBairro.getText();
					String cidade = textapCidade.getText();
					Estado estado = Estado.seletor(comboBoxapEstados.getSelectedIndex());
					String pais = textapPais.getText();
					Data dat = new Data(dia, mes, ano);
					Endereco endereco = new Endereco(logradouro, numero, complemento, CEP, bairro, cidade, estado, pais);
					pessoa.setNome(nome);
					pessoa.setEmail(email);
					pessoa.setSenha(senha);
					pessoa.setTelefone(telefone);
					pessoa.setSexo(sexo);
					pessoa.setData(dat);
					pessoa.setEndereco(endereco);
					if(pessoa instanceof Cliente){
						fachada.atualizarPessoa(pessoa);
					} else {
						double salario = 0;
						if(textapSalario.getText().matches("[0-9]+\\,{0,1}[0-9]*")){
							salario = Double.parseDouble(textapSalario.getText().replace(',', '.'));
						} else {
							throw new ValorInvalidoException("salário");
						}
						Cargo cargo = Cargo.seletor(comboBoxapCargo.getSelectedIndex());
						double horas = 0;
						if(textapHorasSemanais.getText().matches("[0-9]+\\,{0,1}[0-9]*")){
							horas = Double.parseDouble(textapHorasSemanais.getText().replace(',', '.'));
						} else {
							throw new ValorInvalidoException("horas semanais");
						}
						((Funcionario)pessoa).setSalario(salario);
						((Funcionario)pessoa).setCargo(cargo);
						((Funcionario)pessoa).setHorasSemanais(horas);
						fachada.atualizarPessoa(pessoa);
					}
					JOptionPane.showMessageDialog(panelAtualizar, "Pessoa atualizada com sucesso", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
					panelHome.setVisible(true);
					panelAtualizar.setVisible(false);
				} catch (RepositorioException e1) {
					JOptionPane.showMessageDialog(panelAtualizar, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				} catch (ValorInvalidoException e1) {
					JOptionPane.showMessageDialog(panelAtualizar, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				} catch (ValorNaoEncontradoException e1) {
					JOptionPane.showMessageDialog(panelAtualizar, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				}
			}
		});
		buttonAtualizarPessoa.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonAtualizarPessoa.setBorder(new LineBorder(new Color(0, 102, 153)));
		buttonAtualizarPessoa.setBackground(Color.WHITE);
		buttonAtualizarPessoa.setBounds(124, 369, 104, 23);
		panelDadosPessoa.add(buttonAtualizarPessoa);
		panelAtualizar.setVisible(false);
		
		panelCadastrar = new JPanel();
		panelCadastrar.setLayout(null);
		panelCadastrar.setBackground(new Color(0, 153, 204));
		panelCadastrar.setBounds(0, 21, 684, 440);
		contentPane.add(panelCadastrar);
		
		panelCadastrarProduto = new JPanel();
		panelCadastrarProduto.setLayout(null);
		panelCadastrarProduto.setBackground(new Color(0, 153, 204));
		panelCadastrarProduto.setBounds(0, 0, 684, 440);
		panelCadastrar.add(panelCadastrarProduto);
		
		radioLivro = new JRadioButton("Livro");
		radioLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioEbook.setSelected(false);
				radioLivro.setSelected(true);
				panelCadastroEbook.setVisible(false);
				panelCadastroLivro.setVisible(true);
			}
		});
		radioLivro.setForeground(Color.WHITE);
		radioLivro.setFont(new Font("Tahoma", Font.BOLD, 12));
		radioLivro.setBackground(new Color(0, 153, 204));
		radioLivro.setBounds(6, 7, 72, 23);
		panelCadastrarProduto.add(radioLivro);
		radioLivro.setSelected(true);
		
		radioEbook = new JRadioButton("Ebook");
		radioEbook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioLivro.setSelected(false);
				radioEbook.setSelected(true);
				panelCadastroEbook.setVisible(true);
				panelCadastroLivro.setVisible(false);
			}
		});
		radioEbook.setForeground(Color.WHITE);
		radioEbook.setFont(new Font("Tahoma", Font.BOLD, 12));
		radioEbook.setBackground(new Color(0, 153, 204));
		radioEbook.setBounds(73, 7, 104, 23);
		panelCadastrarProduto.add(radioEbook);
		radioEbook.setSelected(false);
		
		labelpcTitulo = new JLabel("Titulo:");
		labelpcTitulo.setForeground(Color.WHITE);
		labelpcTitulo.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelpcTitulo.setBounds(14, 37, 46, 20);
		panelCadastrarProduto.add(labelpcTitulo);
		
		labelpcPreco = new JLabel("Pre\u00E7o:");
		labelpcPreco.setForeground(Color.WHITE);
		labelpcPreco.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelpcPreco.setBounds(15, 68, 46, 20);
		panelCadastrarProduto.add(labelpcPreco);
		
		labelpcEdicao = new JLabel("Edi\u00E7\u00E3o: ");
		labelpcEdicao.setForeground(Color.WHITE);
		labelpcEdicao.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelpcEdicao.setBounds(10, 99, 61, 20);
		panelCadastrarProduto.add(labelpcEdicao);
		
		labelpcISBN = new JLabel("ISBN: ");
		labelpcISBN.setForeground(Color.WHITE);
		labelpcISBN.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelpcISBN.setBounds(455, 37, 46, 20);
		panelCadastrarProduto.add(labelpcISBN);
		
		labelpcAutor = new JLabel("Autor: ");
		labelpcAutor.setForeground(Color.WHITE);
		labelpcAutor.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelpcAutor.setBounds(221, 68, 46, 20);
		panelCadastrarProduto.add(labelpcAutor);
		
		labelpcEditora = new JLabel("Editora:");
		labelpcEditora.setForeground(Color.WHITE);
		labelpcEditora.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelpcEditora.setBounds(460, 68, 56, 20);
		panelCadastrarProduto.add(labelpcEditora);
		
		labelpcAno = new JLabel("Ano: ");
		labelpcAno.setForeground(Color.WHITE);
		labelpcAno.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelpcAno.setBounds(193, 99, 61, 20);
		panelCadastrarProduto.add(labelpcAno);
		
		labelpcIdioma = new JLabel("Idioma: ");
		labelpcIdioma.setForeground(Color.WHITE);
		labelpcIdioma.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelpcIdioma.setBounds(344, 99, 61, 20);
		panelCadastrarProduto.add(labelpcIdioma);
		
		textpcTitulo = new JTextField();
		textpcTitulo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textpcTitulo.setColumns(10);
		textpcTitulo.setBorder(new LineBorder(new Color(0, 102, 153)));
		textpcTitulo.setBounds(57, 37, 371, 20);
		panelCadastrarProduto.add(textpcTitulo);
		
		textpcPreco = new JTextField();
		textpcPreco.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textpcPreco.setColumns(10);
		textpcPreco.setBorder(new LineBorder(new Color(0, 102, 153)));
		textpcPreco.setBounds(57, 68, 121, 20);
		panelCadastrarProduto.add(textpcPreco);
		
		textpcEdicao = new JTextField();
		textpcEdicao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textpcEdicao.setColumns(10);
		textpcEdicao.setBorder(new LineBorder(new Color(0, 102, 153)));
		textpcEdicao.setBounds(57, 99, 85, 20);
		panelCadastrarProduto.add(textpcEdicao);
		
		textpcISBN = new JTextField();
		textpcISBN.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textpcISBN.setColumns(10);
		textpcISBN.setBorder(new LineBorder(new Color(0, 102, 153)));
		textpcISBN.setBounds(492, 37, 182, 20);
		panelCadastrarProduto.add(textpcISBN);
		
		textpcAutor = new JTextField();
		textpcAutor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textpcAutor.setColumns(10);
		textpcAutor.setBorder(new LineBorder(new Color(0, 102, 153)));
		textpcAutor.setBounds(266, 68, 162, 20);
		panelCadastrarProduto.add(textpcAutor);
		
		textpcEditora = new JTextField();
		textpcEditora.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textpcEditora.setColumns(10);
		textpcEditora.setBorder(new LineBorder(new Color(0, 102, 153)));
		textpcEditora.setBounds(512, 68, 162, 20);
		panelCadastrarProduto.add(textpcEditora);
		
		textpcAno = new JTextField();
		textpcAno.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textpcAno.setColumns(10);
		textpcAno.setBorder(new LineBorder(new Color(0, 102, 153)));
		textpcAno.setBounds(227, 99, 85, 20);
		panelCadastrarProduto.add(textpcAno);
		
		comboBoxpcIdiomas = new JComboBox<Object>(Idioma.getIdiomas());
		comboBoxpcIdiomas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxpcIdiomas.setBackground(Color.WHITE);
		comboBoxpcIdiomas.setBounds(395, 99, 279, 20);
		panelCadastrarProduto.add(comboBoxpcIdiomas);
		
		panelCadastroLivro = new JPanel();
		panelCadastroLivro.setBounds(0, 126, 684, 165);
		panelCadastrarProduto.add(panelCadastroLivro);
		panelCadastroLivro.setLayout(null);
		panelCadastroLivro.setBackground(new Color(0, 153, 204));
		panelCadastroLivro.setVisible(true);
		
		labelpcNumeroPag = new JLabel("N pag:");
		labelpcNumeroPag.setForeground(Color.WHITE);
		labelpcNumeroPag.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelpcNumeroPag.setBounds(14, 5, 46, 20);
		panelCadastroLivro.add(labelpcNumeroPag);
		
		labelpcAcabamento = new JLabel("Acabamento:");
		labelpcAcabamento.setForeground(Color.WHITE);
		labelpcAcabamento.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelpcAcabamento.setBounds(356, 5, 91, 20);
		panelCadastroLivro.add(labelpcAcabamento);
		
		labelpcPeso = new JLabel("Peso:");
		labelpcPeso.setForeground(Color.WHITE);
		labelpcPeso.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelpcPeso.setBounds(20, 36, 46, 20);
		panelCadastroLivro.add(labelpcPeso);
		
		labelpcAltura = new JLabel("Altura:");
		labelpcAltura.setForeground(Color.WHITE);
		labelpcAltura.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelpcAltura.setBounds(161, 36, 46, 20);
		panelCadastroLivro.add(labelpcAltura);
		
		labelpcLargura = new JLabel("Largura:");
		labelpcLargura.setForeground(Color.WHITE);
		labelpcLargura.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelpcLargura.setBounds(321, 36, 62, 20);
		panelCadastroLivro.add(labelpcLargura);
		
		labelpcComprimento = new JLabel("Comprimento:");
		labelpcComprimento.setForeground(Color.WHITE);
		labelpcComprimento.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelpcComprimento.setBounds(505, 36, 91, 20);
		panelCadastroLivro.add(labelpcComprimento);
		
		labelpcQuantEstoque = new JLabel("Quant. Estoque:");
		labelpcQuantEstoque.setForeground(Color.WHITE);
		labelpcQuantEstoque.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelpcQuantEstoque.setBounds(163, 5, 108, 20);
		panelCadastroLivro.add(labelpcQuantEstoque);
		
		textpcNumeroPag = new JTextField();
		textpcNumeroPag.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textpcNumeroPag.setColumns(10);
		textpcNumeroPag.setBorder(new LineBorder(new Color(0, 102, 153)));
		textpcNumeroPag.setBounds(57, 5, 79, 20);
		panelCadastroLivro.add(textpcNumeroPag);
		
		textpcQuantEstoque = new JTextField();
		textpcQuantEstoque.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textpcQuantEstoque.setColumns(10);
		textpcQuantEstoque.setBorder(new LineBorder(new Color(0, 102, 153)));
		textpcQuantEstoque.setBounds(268, 5, 68, 20);
		panelCadastroLivro.add(textpcQuantEstoque);
		
		textpcPeso = new JTextField();
		textpcPeso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textpcPeso.setColumns(10);
		textpcPeso.setBorder(new LineBorder(new Color(0, 102, 153)));
		textpcPeso.setBounds(57, 36, 79, 20);
		panelCadastroLivro.add(textpcPeso);
		
		textpcAltura = new JTextField();
		textpcAltura.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textpcAltura.setColumns(10);
		textpcAltura.setBorder(new LineBorder(new Color(0, 102, 153)));
		textpcAltura.setBounds(208, 36, 79, 20);
		panelCadastroLivro.add(textpcAltura);
		
		textpcLargura = new JTextField();
		textpcLargura.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textpcLargura.setColumns(10);
		textpcLargura.setBorder(new LineBorder(new Color(0, 102, 153)));
		textpcLargura.setBounds(376, 36, 79, 20);
		panelCadastroLivro.add(textpcLargura);
		
		textpcComprimento = new JTextField();
		textpcComprimento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textpcComprimento.setColumns(10);
		textpcComprimento.setBorder(new LineBorder(new Color(0, 102, 153)));
		textpcComprimento.setBounds(595, 36, 79, 20);
		panelCadastroLivro.add(textpcComprimento);
		
		comboBoxpcAcabamentos = new JComboBox<Object>(Acabamento.getAcabamentos());
		comboBoxpcAcabamentos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxpcAcabamentos.setBackground(Color.WHITE);
		comboBoxpcAcabamentos.setBounds(441, 5, 233, 20);
		panelCadastroLivro.add(comboBoxpcAcabamentos);
		
		panelCadastroEbook = new JPanel();
		panelCadastroEbook.setBackground(new Color(0, 153, 204));
		panelCadastroEbook.setBounds(0, 126, 684, 165);
		panelCadastrarProduto.add(panelCadastroEbook);
		panelCadastroEbook.setLayout(null);
		panelCadastroEbook.setVisible(false);
		
		labelpcQuantLicenca = new JLabel("Quant. Licen\u00E7a:");
		labelpcQuantLicenca.setForeground(Color.WHITE);
		labelpcQuantLicenca.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelpcQuantLicenca.setBounds(169, 5, 108, 20);
		panelCadastroEbook.add(labelpcQuantLicenca);
		
		labelpcFormato = new JLabel("Formato:");
		labelpcFormato.setForeground(Color.WHITE);
		labelpcFormato.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelpcFormato.setBounds(380, 5, 91, 20);
		panelCadastroEbook.add(labelpcFormato);
		
		labelpcTamanho = new JLabel("Tamh:");
		labelpcTamanho.setForeground(Color.WHITE);
		labelpcTamanho.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelpcTamanho.setBounds(16, 5, 59, 20);
		panelCadastroEbook.add(labelpcTamanho);
		
		textpcTamanho = new JTextField();
		textpcTamanho.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textpcTamanho.setColumns(10);
		textpcTamanho.setBorder(new LineBorder(new Color(0, 102, 153)));
		textpcTamanho.setBounds(57, 5, 77, 20);
		panelCadastroEbook.add(textpcTamanho);
		
		textpcQuantLicenca = new JTextField();
		textpcQuantLicenca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textpcQuantLicenca.setColumns(10);
		textpcQuantLicenca.setBorder(new LineBorder(new Color(0, 102, 153)));
		textpcQuantLicenca.setBounds(268, 5, 68, 20);
		panelCadastroEbook.add(textpcQuantLicenca);
		
		comboBoxpcFormatos = new JComboBox<Object>(Formato.getFormatos());
		comboBoxpcFormatos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxpcFormatos.setBackground(Color.WHITE);
		comboBoxpcFormatos.setBounds(441, 5, 233, 20);
		panelCadastroEbook.add(comboBoxpcFormatos);
		
		buttonpcCancelarProduto = new JButton("Cancelar");
		buttonpcCancelarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(panelCadastrarProduto, "Deseja realmente cancelar a operação") == JOptionPane.YES_OPTION){
					panelCadastrar.setVisible(false);
					panelHome.setVisible(true);
				}
			}
		});
		buttonpcCancelarProduto.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonpcCancelarProduto.setBorder(new LineBorder(new Color(0, 102, 153)));
		buttonpcCancelarProduto.setBackground(Color.WHITE);
		buttonpcCancelarProduto.setBounds(10, 406, 104, 23);
		panelCadastrarProduto.add(buttonpcCancelarProduto);
		
		buttonpcCadastrarProduto = new JButton("Cadastrar");
		buttonpcCadastrarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String titulo = textpcTitulo.getText();
					String ISBN = textpcISBN.getText();
					double preco = 0;
					if(textpcPreco.getText().matches("[0-9]+\\,{0,1}[0-9]*")){
						preco = Double.parseDouble(textpcPreco.getText().replace(',', '.'));
					} else {
						throw new ValorInvalidoException("preço");
					}
					String autor =textpcAutor.getText();
					String editora = textpcEditora.getText();
					int edicao = 0;
					if(textpcEdicao.getText().matches("[0-9]+")){
						edicao = Integer.parseInt(textpcEdicao.getText());
					} else {
						throw new ValorInvalidoException("edição");
					}
					int ano = 0;
					if(textpcAno.getText().matches("[0-9]+")){
						ano = Integer.parseInt(textpcAno.getText());
					} else {
						throw new ValorInvalidoException("ano");
					}
					Idioma idioma = Idioma.seletor(comboBoxpcIdiomas.getSelectedIndex());
					if(radioLivro.isSelected()){
						int quantEstoque = 0;
						if(textpcQuantEstoque.getText().matches("[0-9]+")){
							quantEstoque = Integer.parseInt(textpcQuantEstoque.getText());
						} else {
							throw new ValorInvalidoException("quantidade de estoque");
						}
						int nPag = 0;
						if(textpcNumeroPag.getText().matches("[0-9]+")){
							nPag = Integer.parseInt(textpcNumeroPag.getText());
						} else {
							throw new ValorInvalidoException("número de páginas");
						}
						Acabamento acabamento = Acabamento.seletor(comboBoxpcAcabamentos.getSelectedIndex());
						double peso = 0;
						if(textpcPeso.getText().matches("[0-9]+\\,{0,1}[0-9]*")){
							peso = Double.parseDouble(textpcPeso.getText().replace(',', '.'));
						} else {
							throw new ValorInvalidoException("peso");
						}
						double altura = 0;
						if(textpcAltura.getText().matches("[0-9]+\\,{0,1}[0-9]*")){
							altura = Double.parseDouble(textpcAltura.getText().replace(',', '.'));
						} else {
							throw new ValorInvalidoException("altura");
						}
						double largura = 0;
						if(textpcLargura.getText().matches("[0-9]+\\,{0,1}[0-9]*")){
							largura = Double.parseDouble(textpcLargura.getText().replace(',', '.'));
						} else {
							throw new ValorInvalidoException("largura");
						}
						double comprimento = 0;
						if(textpcComprimento.getText().matches("[0-9]+\\,{0,1}[0-9]*")){
							comprimento = Double.parseDouble(textpcComprimento.getText().replace(',', '.'));
						} else {
							throw new ValorInvalidoException("comprimento");
						}
						Livro livro = new Livro(titulo, ISBN, preco, autor, editora, edicao, ano, idioma, quantEstoque, nPag, acabamento, peso, altura, largura, comprimento);
						fachada.cadastrarProduto(livro);
					} else {
						int quantLicenca = 0;
						if(textpcQuantLicenca.getText().matches("[0-9]+")){
							quantLicenca = Integer.parseInt(textpcQuantLicenca.getText());
						} else {
							throw new ValorInvalidoException("quantidade de licencas");
						}
						double tamanho = 0;
						if(textpcTamanho.getText().matches("[0-9]+\\,{0,1}[0-9]*")){
							tamanho = Double.parseDouble(textpcTamanho.getText().replace(',', '.'));
						} else {
							throw new ValorInvalidoException("tamanho");
						}
						Formato formato = Formato.seletor(comboBoxpcFormatos.getSelectedIndex());
						Ebook ebook = new Ebook(titulo, ISBN, preco, autor, editora, edicao, ano, idioma, quantLicenca, tamanho, formato);
						fachada.cadastrarProduto(ebook);
					}
					JOptionPane.showMessageDialog(panelCadastrarProduto, "Produto cadastrado com sucesso", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
					panelHome.setVisible(true);
					panelCadastrar.setVisible(false);
				} catch (ValorInvalidoException e1) {
					JOptionPane.showMessageDialog(panelCadastrarProduto, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				} catch (RepositorioException e1) {
					JOptionPane.showMessageDialog(panelCadastrarProduto, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				} catch (ValorJaCadastradoException e1) {
					JOptionPane.showMessageDialog(panelCadastrarProduto, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				}
			}
		});
		buttonpcCadastrarProduto.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonpcCadastrarProduto.setBorder(new LineBorder(new Color(0, 102, 153)));
		buttonpcCadastrarProduto.setBackground(Color.WHITE);
		buttonpcCadastrarProduto.setBounds(124, 406, 104, 23);
		panelCadastrarProduto.add(buttonpcCadastrarProduto);
		
		panelCadastrarPessoa = new JPanel();
		panelCadastrarPessoa.setBackground(new Color(0, 153, 204));
		panelCadastrarPessoa.setBounds(0, 0, 684, 440);
		panelCadastrar.add(panelCadastrarPessoa);
		panelCadastrarPessoa.setLayout(null);
		
		radioCliente = new JRadioButton("Cliente");
		radioCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioCliente.setSelected(true);
				radioFuncionario.setSelected(false);
				panelcFuncionario.setVisible(false);
			}
		});
		radioCliente.setForeground(new Color(255, 255, 255));
		radioCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
		radioCliente.setBackground(new Color(0, 153, 204));
		radioCliente.setBounds(6, 7, 72, 23);
		panelCadastrarPessoa.add(radioCliente);
		radioCliente.setSelected(true);
		
		radioFuncionario = new JRadioButton("Funcion\u00E1rio");
		radioFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioFuncionario.setSelected(true);
				radioCliente.setSelected(false);
				panelcFuncionario.setVisible(true);
			}
		});
		radioFuncionario.setForeground(Color.WHITE);
		radioFuncionario.setFont(new Font("Tahoma", Font.BOLD, 12));
		radioFuncionario.setBackground(new Color(0, 153, 204));
		radioFuncionario.setBounds(80, 7, 104, 23);
		panelCadastrarPessoa.add(radioFuncionario);
		radioFuncionario.setSelected(false);
		
		labelcNome = new JLabel("Nome:");
		labelcNome.setForeground(new Color(255, 255, 255));
		labelcNome.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelcNome.setBounds(60, 37, 46, 20);
		panelCadastrarPessoa.add(labelcNome);
		
		labelcEmail = new JLabel("Email: ");
		labelcEmail.setForeground(Color.WHITE);
		labelcEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelcEmail.setBounds(63, 68, 39, 20);
		panelCadastrarPessoa.add(labelcEmail);
		
		labelcTelefone = new JLabel("Telefone: ");
		labelcTelefone.setForeground(Color.WHITE);
		labelcTelefone.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelcTelefone.setBounds(42, 99, 60, 20);
		panelCadastrarPessoa.add(labelcTelefone);
		
		labelcLogradouro = new JLabel("Logradouro:");
		labelcLogradouro.setForeground(Color.WHITE);
		labelcLogradouro.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelcLogradouro.setBounds(22, 130, 86, 20);
		panelCadastrarPessoa.add(labelcLogradouro);
		
		labelcComplemento = new JLabel("Complemento: ");
		labelcComplemento.setForeground(Color.WHITE);
		labelcComplemento.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelcComplemento.setBounds(9, 161, 98, 20);
		panelCadastrarPessoa.add(labelcComplemento);
		
		labelcCEP = new JLabel("CEP: ");
		labelcCEP.setForeground(Color.WHITE);
		labelcCEP.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelcCEP.setBounds(71, 192, 31, 20);
		panelCadastrarPessoa.add(labelcCEP);
		
		labelcEstado = new JLabel("Estado:");
		labelcEstado.setForeground(Color.WHITE);
		labelcEstado.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelcEstado.setBounds(52, 223, 46, 20);
		panelCadastrarPessoa.add(labelcEstado);
		
		labelcCPF = new JLabel("CPF:");
		labelcCPF.setForeground(Color.WHITE);
		labelcCPF.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelcCPF.setBounds(516, 37, 46, 20);
		panelCadastrarPessoa.add(labelcCPF);
		
		labelcSenha = new JLabel("Senha:");
		labelcSenha.setForeground(Color.WHITE);
		labelcSenha.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelcSenha.setBounds(464, 68, 46, 20);
		panelCadastrarPessoa.add(labelcSenha);
		
		labelcSexo = new JLabel("Sexo: ");
		labelcSexo.setForeground(Color.WHITE);
		labelcSexo.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelcSexo.setBounds(248, 99, 60, 20);
		panelCadastrarPessoa.add(labelcSexo);
		
		labelcData = new JLabel("Data de Nasc.:");
		labelcData.setForeground(Color.WHITE);
		labelcData.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelcData.setBounds(357, 99, 98, 20);
		panelCadastrarPessoa.add(labelcData);
		
		labelcNumero = new JLabel("Num: ");
		labelcNumero.setForeground(Color.WHITE);
		labelcNumero.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelcNumero.setBounds(560, 130, 39, 20);
		panelCadastrarPessoa.add(labelcNumero);
		
		labelcBairro = new JLabel("Bairro: ");
		labelcBairro.setForeground(Color.WHITE);
		labelcBairro.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelcBairro.setBounds(257, 192, 54, 20);
		panelCadastrarPessoa.add(labelcBairro);
		
		labelcCidade = new JLabel("Cidade: ");
		labelcCidade.setForeground(Color.WHITE);
		labelcCidade.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelcCidade.setBounds(489, 192, 68, 20);
		panelCadastrarPessoa.add(labelcCidade);
		
		labelcPais = new JLabel("Pais: ");
		labelcPais.setForeground(Color.WHITE);
		labelcPais.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelcPais.setBounds(431, 223, 46, 20);
		panelCadastrarPessoa.add(labelcPais);
		
		labelErroCadastroPessoa = new JLabel("");
		labelErroCadastroPessoa.setForeground(new Color(204, 51, 51));
		labelErroCadastroPessoa.setBackground(new Color(0, 153, 204));
		labelErroCadastroPessoa.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelErroCadastroPessoa.setBounds(245, 411, 429, 14);
		panelCadastrarPessoa.add(labelErroCadastroPessoa);
		
		textcNome = new JTextField();
		textcNome.setBorder(new LineBorder(new Color(0, 102, 153)));
		textcNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textcNome.setBounds(103, 37, 384, 20);
		panelCadastrarPessoa.add(textcNome);
		textcNome.setColumns(10);
		
		textcEmail = new JTextField();
		textcEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textcEmail.setColumns(10);
		textcEmail.setBorder(new LineBorder(new Color(0, 102, 153)));
		textcEmail.setBounds(103, 68, 307, 20);
		panelCadastrarPessoa.add(textcEmail);
		
		textcTelefone = new JTextField();
		textcTelefone.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textcTelefone.setColumns(10);
		textcTelefone.setBorder(new LineBorder(new Color(0, 102, 153)));
		textcTelefone.setBounds(103, 99, 110, 20);
		panelCadastrarPessoa.add(textcTelefone);
		
		textcLogradouro = new JTextField();
		textcLogradouro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textcLogradouro.setColumns(10);
		textcLogradouro.setBorder(new LineBorder(new Color(0, 102, 153)));
		textcLogradouro.setBounds(103, 130, 425, 20);
		panelCadastrarPessoa.add(textcLogradouro);
		
		textcComplemento = new JTextField();
		textcComplemento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textcComplemento.setColumns(10);
		textcComplemento.setBorder(new LineBorder(new Color(0, 102, 153)));
		textcComplemento.setBounds(103, 161, 571, 20);
		panelCadastrarPessoa.add(textcComplemento);
		
		textcCEP = new JTextField();
		textcCEP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textcCEP.setColumns(10);
		textcCEP.setBorder(new LineBorder(new Color(0, 102, 153)));
		textcCEP.setBounds(103, 192, 110, 20);
		panelCadastrarPessoa.add(textcCEP);
		
		textcPais = new JTextField();
		textcPais.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textcPais.setColumns(10);
		textcPais.setBorder(new LineBorder(new Color(0, 102, 153)));
		textcPais.setBounds(464, 223, 210, 20);
		panelCadastrarPessoa.add(textcPais);
		
		textcCPF = new JTextField();
		textcCPF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textcCPF.setColumns(10);
		textcCPF.setBorder(new LineBorder(new Color(0, 102, 153)));
		textcCPF.setBounds(547, 37, 127, 20);
		panelCadastrarPessoa.add(textcCPF);
		
		textcSenha = new JPasswordField();
		textcSenha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textcSenha.setColumns(10);
		textcSenha.setBorder(new LineBorder(new Color(0, 102, 153)));
		textcSenha.setBounds(510, 68, 164, 20);
		panelCadastrarPessoa.add(textcSenha);
		
		textcNumero = new JTextField();
		textcNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textcNumero.setColumns(10);
		textcNumero.setBorder(new LineBorder(new Color(0, 102, 153)));
		textcNumero.setBounds(595, 130, 79, 20);
		panelCadastrarPessoa.add(textcNumero);
		
		textcBairro = new JTextField();
		textcBairro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textcBairro.setColumns(10);
		textcBairro.setBorder(new LineBorder(new Color(0, 102, 153)));
		textcBairro.setBounds(301, 192, 136, 20);
		panelCadastrarPessoa.add(textcBairro);
		
		textcCidade = new JTextField();
		textcCidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textcCidade.setColumns(10);
		textcCidade.setBorder(new LineBorder(new Color(0, 102, 153)));
		textcCidade.setBounds(538, 192, 136, 20);
		panelCadastrarPessoa.add(textcCidade);
		comboBoxcSexo = new JComboBox<Object>(sexos);
		comboBoxcSexo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxcSexo.setBackground(new Color(255, 255, 255));
		comboBoxcSexo.setBounds(287, 99, 39, 20);
		panelCadastrarPessoa.add(comboBoxcSexo);
		comboBoxcDias = new JComboBox<Object>(dias);
		comboBoxcDias.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxcDias.setBackground(Color.WHITE);
		comboBoxcDias.setBounds(449, 99, 39, 20);
		panelCadastrarPessoa.add(comboBoxcDias);
		comboBoxcMes = new JComboBox<Object>(meses);
		comboBoxcMes.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxcMes.setBackground(Color.WHITE);
		comboBoxcMes.setBounds(498, 99, 110, 20);
		panelCadastrarPessoa.add(comboBoxcMes);
		comboBoxcAnos = new JComboBox<Object>(anos);
		comboBoxcAnos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxcAnos.setBackground(Color.WHITE);
		comboBoxcAnos.setBounds(618, 99, 56, 20);
		panelCadastrarPessoa.add(comboBoxcAnos);
		
		comboBoxcEstados = new JComboBox<Object>(Estado.getEstados());
		comboBoxcEstados.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxcEstados.setBackground(Color.WHITE);
		comboBoxcEstados.setBounds(103, 223, 282, 20);
		panelCadastrarPessoa.add(comboBoxcEstados);
		
		panelcFuncionario = new JPanel();
		panelcFuncionario.setBackground(new Color(0, 153, 204));
		panelcFuncionario.setBounds(0, 248, 684, 147);
		panelCadastrarPessoa.add(panelcFuncionario);
		panelcFuncionario.setLayout(null);
		panelcFuncionario.setVisible(false);
		
		labelcSalario = new JLabel("Salario: ");
		labelcSalario.setForeground(Color.WHITE);
		labelcSalario.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelcSalario.setBounds(53, 7, 49, 20);
		panelcFuncionario.add(labelcSalario);
		
		labelcCargo = new JLabel("Cargo: ");
		labelcCargo.setForeground(Color.WHITE);
		labelcCargo.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelcCargo.setBounds(225, 7, 54, 20);
		panelcFuncionario.add(labelcCargo);
		
		labelcHorasSemanais = new JLabel("Horas semanais: ");
		labelcHorasSemanais.setForeground(Color.WHITE);
		labelcHorasSemanais.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelcHorasSemanais.setBounds(477, 7, 110, 20);
		panelcFuncionario.add(labelcHorasSemanais);
		
		textcSalario = new JTextField();
		textcSalario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textcSalario.setColumns(10);
		textcSalario.setBorder(new LineBorder(new Color(0, 102, 153)));
		textcSalario.setBounds(103, 7, 83, 20);
		panelcFuncionario.add(textcSalario);
		
		textcHorasSemanais = new JTextField();
		textcHorasSemanais.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textcHorasSemanais.setColumns(10);
		textcHorasSemanais.setBorder(new LineBorder(new Color(0, 102, 153)));
		textcHorasSemanais.setBounds(580, 7, 94, 20);
		panelcFuncionario.add(textcHorasSemanais);
		
		comboBoxcCargos = new JComboBox<Object>(Cargo.getCargos());
		comboBoxcCargos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxcCargos.setBackground(Color.WHITE);
		comboBoxcCargos.setBounds(271, 7, 174, 20);
		panelcFuncionario.add(comboBoxcCargos);
		
		buttoncCancelarPessoa = new JButton("Cancelar");
		buttoncCancelarPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(panelCadastrarPessoa, "Deseja realmente cancelar a operação") == JOptionPane.YES_OPTION){
					panelCadastrar.setVisible(false);
					panelHome.setVisible(true);
				}
			}
		});
		buttoncCancelarPessoa.setBorder(new LineBorder(new Color(0, 102, 153)));
		buttoncCancelarPessoa.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttoncCancelarPessoa.setBackground(new Color(255, 255, 255));
		buttoncCancelarPessoa.setBounds(15, 406, 104, 23);
		panelCadastrarPessoa.add(buttoncCancelarPessoa);
		
		buttoncPessoa = new JButton("Cadastrar");
		buttoncPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String nome = textcNome.getText();
					String CPF = textcCPF.getText();
					String email = textcEmail.getText();
					String senha = textcSenha.getText();
					String telefone = textcTelefone.getText();
					char sexo = sexos[comboBoxcSexo.getSelectedIndex()].charAt(0);
					int dia = comboBoxcDias.getSelectedIndex() + 1;
					int mes = comboBoxcMes.getSelectedIndex() + 1;
					String data = new Date().toString();
					int ano = Integer.parseInt(data.substring(data.length()- 4, data.length())) - comboBoxcAnos.getSelectedIndex();
					String logradouro = textcLogradouro.getText();
					int numero = 0;
					if(textcNumero.getText().matches("[0-9]+")){
						numero = Integer.parseInt(textcNumero.getText());
					} else {
						throw new ValorInvalidoException("número");
					}
					String complemento = textcComplemento.getText();
					String CEP = textcCEP.getText();
					String bairro = textcBairro.getText();
					String cidade = textcCidade.getText();
					Estado estado = Estado.seletor(comboBoxcEstados.getSelectedIndex());
					String pais = textcPais.getText();
					Data dat = new Data(dia, mes, ano);
					Endereco endereco = new Endereco(logradouro, numero, complemento, CEP, bairro, cidade, estado, pais);
					if(radioCliente.isSelected()){
						Cliente cliente = new Cliente(nome, CPF, email, senha, telefone, sexo, dat, endereco);
						fachada.cadastrarPessoa(cliente);
					} else {
						double salario = 0;
						if(textcSalario.getText().matches("[0-9]+\\,{0,1}[0-9]*")){
							salario = Double.parseDouble(textcSalario.getText().replace(',', '.'));
						} else {
							throw new ValorInvalidoException("salário");
						}
						Cargo cargo = Cargo.seletor(comboBoxcCargos.getSelectedIndex());
						double horas = 0;
						if(textcHorasSemanais.getText().matches("[0-9]+\\,{0,1}[0-9]*")){
							horas = Double.parseDouble(textcHorasSemanais.getText().replace(',', '.'));
						} else {
							throw new ValorInvalidoException("horas semanais");
						}
						Funcionario func = new Funcionario(nome, CPF, email, senha, telefone, sexo, dat, endereco, salario, cargo, horas);
						fachada.cadastrarPessoa(func);
					}
					JOptionPane.showMessageDialog(panelCadastrarPessoa, "Pessoa cadastrada com sucesso", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
					panelHome.setVisible(true);
					panelCadastrar.setVisible(false);
				} catch (RepositorioException e1) {
					JOptionPane.showMessageDialog(panelCadastrarPessoa, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				} catch (ValorInvalidoException e1) {
					JOptionPane.showMessageDialog(panelCadastrarPessoa, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				} catch (ValorJaCadastradoException e1) {
					JOptionPane.showMessageDialog(panelCadastrarPessoa, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				}
			}
		});
		buttoncPessoa.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttoncPessoa.setBorder(new LineBorder(new Color(0, 102, 153)));
		buttoncPessoa.setBackground(Color.WHITE);
		buttoncPessoa.setBounds(129, 406, 104, 23);
		panelCadastrarPessoa.add(buttoncPessoa);
		
		panelCadastrarServico = new JPanel();
		panelCadastrarServico.setLayout(null);
		panelCadastrarServico.setBackground(new Color(0, 153, 204));
		panelCadastrarServico.setBounds(0, 0, 684, 440);
		panelCadastrar.add(panelCadastrarServico);
		
		radioPalestra = new JRadioButton("Palestra");
		radioPalestra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioCurso.setSelected(false);
				radioPalestra.setSelected(true);
				panelscPalestra.setVisible(true);
				panelscCurso.setVisible(false);
			}
		});
		radioPalestra.setForeground(Color.WHITE);
		radioPalestra.setFont(new Font("Tahoma", Font.BOLD, 12));
		radioPalestra.setBackground(new Color(0, 153, 204));
		radioPalestra.setBounds(6, 7, 81, 23);
		panelCadastrarServico.add(radioPalestra);
		radioPalestra.setSelected(true);
		
		radioCurso = new JRadioButton("Curso");
		radioCurso.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					radioCurso.getAction().setEnabled(true);
				}
			}
		});
		radioCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioPalestra.setSelected(false);
				radioCurso.setSelected(true);
				panelscPalestra.setVisible(false);
				panelscCurso.setVisible(true);
			}
		});
		radioCurso.setForeground(Color.WHITE);
		radioCurso.setFont(new Font("Tahoma", Font.BOLD, 12));
		radioCurso.setBackground(new Color(0, 153, 204));
		radioCurso.setBounds(88, 7, 104, 23);
		panelCadastrarServico.add(radioCurso);
		radioCurso.setSelected(false);
		
		lblHorrio = new JLabel("Hor\u00E1rio: ");
		lblHorrio.setForeground(Color.WHITE);
		lblHorrio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHorrio.setBounds(50, 99, 60, 20);
		panelCadastrarServico.add(lblHorrio);
		
		vagas = new JLabel("vagas:");
		vagas.setForeground(Color.WHITE);
		vagas.setFont(new Font("Tahoma", Font.BOLD, 12));
		vagas.setBounds(60, 68, 60, 20);
		panelCadastrarServico.add(vagas);
		
		lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setForeground(Color.WHITE);
		lblCdigo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCdigo.setBounds(460, 39, 59, 14);
		panelCadastrarServico.add(lblCdigo);
		
		lblData = new JLabel("Data:");
		lblData.setForeground(Color.WHITE);
		lblData.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblData.setBounds(411, 68, 39, 20);
		panelCadastrarServico.add(lblData);
		
		lblDurao = new JLabel("Dura\u00E7\u00E3o:");
		lblDurao.setForeground(Color.WHITE);
		lblDurao.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDurao.setBounds(194, 99, 60, 20);
		panelCadastrarServico.add(lblDurao);
		
		label_6 = new JLabel("Logradouro:");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_6.setBounds(23, 130, 86, 20);
		panelCadastrarServico.add(label_6);
		
		label_7 = new JLabel("Num: ");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_7.setBounds(560, 130, 39, 20);
		panelCadastrarServico.add(label_7);
		
		label = new JLabel("Nome:");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(60, 37, 46, 20);
		panelCadastrarServico.add(label);
		
		label_8 = new JLabel("Complemento: ");
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_8.setBounds(10, 161, 98, 20);
		panelCadastrarServico.add(label_8);
		
		label_9 = new JLabel("CEP: ");
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_9.setBounds(72, 192, 31, 20);
		panelCadastrarServico.add(label_9);
		
		label_10 = new JLabel("Bairro: ");
		label_10.setForeground(Color.WHITE);
		label_10.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_10.setBounds(257, 192, 54, 20);
		panelCadastrarServico.add(label_10);
		
		label_11 = new JLabel("Cidade: ");
		label_11.setForeground(Color.WHITE);
		label_11.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_11.setBounds(489, 192, 68, 20);
		panelCadastrarServico.add(label_11);
		
		label_12 = new JLabel("Pais: ");
		label_12.setForeground(Color.WHITE);
		label_12.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_12.setBounds(431, 223, 46, 20);
		panelCadastrarServico.add(label_12);
		
		label_13 = new JLabel("Estado:");
		label_13.setForeground(Color.WHITE);
		label_13.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_13.setBounds(53, 223, 57, 20);
		panelCadastrarServico.add(label_13);
		
		textscNome = new JTextField();
		textscNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textscNome.setColumns(10);
		textscNome.setBorder(new LineBorder(new Color(0, 102, 153)));
		textscNome.setBounds(104, 37, 322, 20);
		panelCadastrarServico.add(textscNome);
		
		textscHorario = new JTextField();
		textscHorario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textscHorario.setColumns(10);
		textscHorario.setBorder(new LineBorder(new Color(0, 102, 153)));
		textscHorario.setBounds(104, 99, 53, 20);
		panelCadastrarServico.add(textscHorario);
		
		textscVagas = new JTextField();
		textscVagas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textscVagas.setColumns(10);
		textscVagas.setBorder(new LineBorder(new Color(0, 102, 153)));
		textscVagas.setBounds(104, 68, 110, 20);
		panelCadastrarServico.add(textscVagas);
		
		textscCodigo = new JTextField();
		textscCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textscCodigo.setColumns(10);
		textscCodigo.setBorder(new LineBorder(new Color(0, 102, 153)));
		textscCodigo.setBounds(512, 37, 162, 20);
		panelCadastrarServico.add(textscCodigo);
		
		
		
		textscDuracao = new JTextField();
		textscDuracao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textscDuracao.setColumns(10);
		textscDuracao.setBorder(new LineBorder(new Color(0, 102, 153)));
		textscDuracao.setBounds(252, 99, 53, 20);
		panelCadastrarServico.add(textscDuracao);
		
		textscLogradouro = new JTextField();
		textscLogradouro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textscLogradouro.setColumns(10);
		textscLogradouro.setBorder(new LineBorder(new Color(0, 102, 153)));
		textscLogradouro.setBounds(103, 130, 425, 20);
		panelCadastrarServico.add(textscLogradouro);
		
		textscNumero = new JTextField();
		textscNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textscNumero.setColumns(10);
		textscNumero.setBorder(new LineBorder(new Color(0, 102, 153)));
		textscNumero.setBounds(595, 130, 79, 20);
		panelCadastrarServico.add(textscNumero);
		
		textscComplemento = new JTextField();
		textscComplemento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textscComplemento.setColumns(10);
		textscComplemento.setBorder(new LineBorder(new Color(0, 102, 153)));
		textscComplemento.setBounds(103, 161, 571, 20);
		panelCadastrarServico.add(textscComplemento);
		
		textscCEP = new JTextField();
		textscCEP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textscCEP.setColumns(10);
		textscCEP.setBorder(new LineBorder(new Color(0, 102, 153)));
		textscCEP.setBounds(103, 192, 110, 20);
		panelCadastrarServico.add(textscCEP);
		
		textscBairro = new JTextField();
		textscBairro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textscBairro.setColumns(10);
		textscBairro.setBorder(new LineBorder(new Color(0, 102, 153)));
		textscBairro.setBounds(301, 192, 136, 20);
		panelCadastrarServico.add(textscBairro);
		
		textscCidade = new JTextField();
		textscCidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textscCidade.setColumns(10);
		textscCidade.setBorder(new LineBorder(new Color(0, 102, 153)));
		textscCidade.setBounds(538, 192, 136, 20);
		panelCadastrarServico.add(textscCidade);
		
		textscPais = new JTextField();
		textscPais.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textscPais.setColumns(10);
		textscPais.setBorder(new LineBorder(new Color(0, 102, 153)));
		textscPais.setBounds(464, 223, 210, 20);
		panelCadastrarServico.add(textscPais);
		
		comboBoxscDias = new JComboBox<Object>(dias);
		comboBoxscDias.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxscDias.setBackground(Color.WHITE);
		comboBoxscDias.setBounds(449, 68, 39, 20);
		panelCadastrarServico.add(comboBoxscDias);
		
		comboBoxscMeses = new JComboBox<Object>(meses);
		comboBoxscMeses.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxscMeses.setBackground(Color.WHITE);
		comboBoxscMeses.setBounds(498, 68, 110, 20);
		panelCadastrarServico.add(comboBoxscMeses);
		comboBoxscAnos = new JComboBox<Object>(maisAnos);
		comboBoxscAnos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxscAnos.setBackground(Color.WHITE);
		comboBoxscAnos.setBounds(618, 68, 56, 20);
		panelCadastrarServico.add(comboBoxscAnos);
		
		comboBoxscEstados = new JComboBox<Object>(Estado.getEstados());
		comboBoxscEstados.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxscEstados.setBackground(Color.WHITE);
		comboBoxscEstados.setBounds(103, 223, 282, 20);
		panelCadastrarServico.add(comboBoxscEstados);
		
		lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setForeground(Color.WHITE);
		lblDescrio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDescrio.setBounds(37, 254, 68, 20);
		panelCadastrarServico.add(lblDescrio);
		
		textscDescricao = new JTextField();
		textscDescricao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textscDescricao.setColumns(10);
		textscDescricao.setBorder(new LineBorder(new Color(0, 102, 153)));
		textscDescricao.setBounds(103, 254, 282, 130);
		panelCadastrarServico.add(textscDescricao);
		
		panelscCurso = new JPanel();
		panelscCurso.setLayout(null);
		panelscCurso.setBackground(new Color(0, 153, 204));
		panelscCurso.setBounds(398, 247, 286, 182);
		panelCadastrarServico.add(panelscCurso);
		panelscCurso.setVisible(false);
		
		lblProfessor = new JLabel("Professor:");
		lblProfessor.setForeground(Color.WHITE);
		lblProfessor.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProfessor.setBounds(14, 7, 98, 20);
		panelscCurso.add(lblProfessor);
		
		textscProfessor = new JTextField();
		textscProfessor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textscProfessor.setColumns(10);
		textscProfessor.setBorder(new LineBorder(new Color(0, 102, 153)));
		textscProfessor.setBounds(81, 7, 195, 20);
		panelscCurso.add(textscProfessor);
		
		lblCargaHorria = new JLabel("Carga hor\u00E1ria:");
		lblCargaHorria.setForeground(Color.WHITE);
		lblCargaHorria.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCargaHorria.setBounds(75, 38, 98, 20);
		panelscCurso.add(lblCargaHorria);
		
		textscCargaHoraria = new JTextField();
		textscCargaHoraria.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textscCargaHoraria.setColumns(10);
		textscCargaHoraria.setBorder(new LineBorder(new Color(0, 102, 153)));
		textscCargaHoraria.setBounds(166, 38, 110, 20);
		panelscCurso.add(textscCargaHoraria);
		
		checkscseg = new JCheckBox("SEG");
		checkscseg.setForeground(new Color(255, 255, 255));
		checkscseg.setFont(new Font("Tahoma", Font.BOLD, 12));
		checkscseg.setBackground(new Color(0, 153, 204));
		checkscseg.setBounds(10, 94, 55, 23);
		panelscCurso.add(checkscseg);
		
		checkscter = new JCheckBox("TER");
		checkscter.setForeground(Color.WHITE);
		checkscter.setFont(new Font("Tahoma", Font.BOLD, 12));
		checkscter.setBackground(new Color(0, 153, 204));
		checkscter.setBounds(66, 94, 55, 23);
		panelscCurso.add(checkscter);
		
		checkscqua = new JCheckBox("QUA");
		checkscqua.setForeground(Color.WHITE);
		checkscqua.setFont(new Font("Tahoma", Font.BOLD, 12));
		checkscqua.setBackground(new Color(0, 153, 204));
		checkscqua.setBounds(123, 94, 55, 23);
		panelscCurso.add(checkscqua);
		
		checkscqui = new JCheckBox("QUI");
		checkscqui.setForeground(Color.WHITE);
		checkscqui.setFont(new Font("Tahoma", Font.BOLD, 12));
		checkscqui.setBackground(new Color(0, 153, 204));
		checkscqui.setBounds(180, 94, 55, 23);
		panelscCurso.add(checkscqui);
		
		checkscsex = new JCheckBox("SEX");
		checkscsex.setForeground(Color.WHITE);
		checkscsex.setFont(new Font("Tahoma", Font.BOLD, 12));
		checkscsex.setBackground(new Color(0, 153, 204));
		checkscsex.setBounds(10, 119, 55, 23);
		panelscCurso.add(checkscsex);
		
		checkscsab = new JCheckBox("SAB");
		checkscsab.setForeground(Color.WHITE);
		checkscsab.setFont(new Font("Tahoma", Font.BOLD, 12));
		checkscsab.setBackground(new Color(0, 153, 204));
		checkscsab.setBounds(66, 120, 55, 23);
		panelscCurso.add(checkscsab);
		
		checkscdom = new JCheckBox("DOM");
		checkscdom.setForeground(Color.WHITE);
		checkscdom.setFont(new Font("Tahoma", Font.BOLD, 12));
		checkscdom.setBackground(new Color(0, 153, 204));
		checkscdom.setBounds(123, 120, 55, 23);
		panelscCurso.add(checkscdom);
		
		JLabel lblDiasComAula = new JLabel("Dias com aula:");
		lblDiasComAula.setForeground(Color.WHITE);
		lblDiasComAula.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDiasComAula.setBounds(15, 69, 98, 14);
		panelscCurso.add(lblDiasComAula);
		
		JButton buttonscCancelarServico = new JButton("Cancelar");
		buttonscCancelarServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(panelCadastrarServico, "Deseja realmente cancelar a operação") == JOptionPane.YES_OPTION){
					panelCadastrar.setVisible(false);
					panelHome.setVisible(true);
				}
			}
		});
		
		panelscPalestra = new JPanel();
		panelscPalestra.setBackground(new Color(0, 153, 204));
		panelscPalestra.setBounds(398, 247, 286, 182);
		panelCadastrarServico.add(panelscPalestra);
		panelscPalestra.setLayout(null);
		panelscPalestra.setVisible(true);
		
		lblPalestrante = new JLabel("Palestrante:");
		lblPalestrante.setForeground(Color.WHITE);
		lblPalestrante.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPalestrante.setBounds(13, 7, 98, 20);
		panelscPalestra.add(lblPalestrante);
		
		textscPalestrante = new JTextField();
		textscPalestrante.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textscPalestrante.setColumns(10);
		textscPalestrante.setBorder(new LineBorder(new Color(0, 102, 153)));
		textscPalestrante.setBounds(92, 7, 184, 20);
		panelscPalestra.add(textscPalestrante);
		buttonscCancelarServico.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonscCancelarServico.setBorder(new LineBorder(new Color(0, 102, 153)));
		buttonscCancelarServico.setBackground(Color.WHITE);
		buttonscCancelarServico.setBounds(6, 406, 104, 23);
		panelCadastrarServico.add(buttonscCancelarServico);
		
		JButton buttonCadastrarServico = new JButton("Cadastrar");
		buttonCadastrarServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String nome = textscNome.getText();
					String codigo = textscCodigo.getText();
					int vagas = 0;
					if(textscVagas.getText().matches("[0-9]+")){
						vagas = Integer.parseInt(textscVagas.getText());
					} else {
						throw new ValorInvalidoException("vagas");
					}
					int dia = comboBoxscDias.getSelectedIndex() + 1;
					int mes = comboBoxscMeses.getSelectedIndex() + 1;
					String data = new Date().toString();
					int ano = Integer.parseInt(data.substring(data.length()- 4, data.length())) + comboBoxscAnos.getSelectedIndex();
					String horario = textscHorario.getText();
					double duracao = 0;
					if(textscDuracao.getText().matches("[0-9]+\\,{0,1}[0-9]*")){
						duracao = Double.parseDouble(textscDuracao.getText().replace(',', '.'));
					} else {
						throw new ValorInvalidoException("duração");
					}
					String logradouro = textscLogradouro.getText();
					int numero = 0;
					if(textscNumero.getText().matches("[0-9]+")){
						numero = Integer.parseInt(textscNumero.getText());
					} else {
						throw new ValorInvalidoException("número");
					}
					String complemento = textscComplemento.getText();
					String CEP = textscCEP.getText();
					String bairro = textscBairro.getText();
					String cidade = textscCidade.getText();
					Estado estado = Estado.seletor(comboBoxscEstados.getSelectedIndex());
					String pais = textscPais.getText();
					String descricao = textscDescricao.getText();
					Data dat = new Data(dia, mes, ano);
					Endereco endereco = new Endereco(logradouro, numero, complemento, CEP, bairro, cidade, estado, pais);
					
					if(radioPalestra.isSelected()){
						String palestrante = textscPalestrante.getText();
						Palestra palestra = new Palestra(nome, codigo, vagas, dat, horario, duracao,endereco, descricao, palestrante);
						fachada.cadastrarServico(palestra);
					} else {
						String professor = textscProfessor.getText();
						double hora = 0;
						if(textscCargaHoraria.getText().matches("[0-9]+\\,{0,1}[0-9]*")){
							hora = Double.parseDouble(textscCargaHoraria.getText().replace(',', '.'));
						} else {
							throw new ValorInvalidoException("carga horária");
						}
						int contador = 0;
						if(checkscseg.isSelected()){
							contador++;
						}
						if(checkscter.isSelected()){
							contador++;
						}
						if(checkscqua.isSelected()){
							contador++;
						}
						if(checkscqui.isSelected()){
							contador++;
						}
						if(checkscsex.isSelected()){
							contador++;
						}
						if(checkscsab.isSelected()){
							contador++;
						}
						if(checkscdom.isSelected()){
							contador++;
						}
						
						if(contador==0){
							contador++;
						}
						Dia[] dias = new Dia[contador];
						contador = 0;
						if(checkscseg.isSelected()){
							dias[contador++] = Dia.SEGUNDAFEIRA;
						}
						if(checkscter.isSelected()){
							dias[contador++] = Dia.TERCAFEIRA;
						}
						if(checkscqua.isSelected()){
							dias[contador++] = Dia.QUARTAFEIRA;
						}
						if(checkscqui.isSelected()){
							dias[contador++] = Dia.QUINTAFEIRA;
						}
						if(checkscsex.isSelected()){
							dias[contador++] = Dia.SEXTAFEIRA;
						}
						if(checkscsab.isSelected()){
							dias[contador++] = Dia.SABADO;
						}
						if(checkscdom.isSelected()){
							dias[contador++] = Dia.DOMINGO;
						}
						
						Curso curso = new Curso(nome, codigo, vagas, dat, horario, duracao, endereco, descricao, professor, hora, dias);
						fachada.cadastrarServico(curso);
					}
					JOptionPane.showMessageDialog(panelCadastrarServico, "Serviço cadastrada com sucesso", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
					panelHome.setVisible(true);
					panelCadastrar.setVisible(false);
				} catch (ValorInvalidoException e1) {
					JOptionPane.showMessageDialog(panelCadastrarServico, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				} catch (RepositorioException e1) {
					JOptionPane.showMessageDialog(panelCadastrarServico, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				} catch (ValorJaCadastradoException e1) {
					JOptionPane.showMessageDialog(panelCadastrarServico, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				}
			}
		});
		buttonCadastrarServico.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonCadastrarServico.setBorder(new LineBorder(new Color(0, 102, 153)));
		buttonCadastrarServico.setBackground(Color.WHITE);
		buttonCadastrarServico.setBounds(120, 406, 104, 23);
		panelCadastrarServico.add(buttonCadastrarServico);
		
		panelRelatorio = new JPanel();
		panelRelatorio.setLayout(null);
		panelRelatorio.setBackground(new Color(0, 153, 204));
		panelRelatorio.setBounds(0, 21, 684, 440);
		contentPane.add(panelRelatorio);
		
		panelRelatorioServico = new JPanel();
		panelRelatorioServico.setLayout(null);
		panelRelatorioServico.setBackground(new Color(0, 153, 204));
		panelRelatorioServico.setBounds(0, 0, 684, 440);
		panelRelatorio.add(panelRelatorioServico);
		
		buttonsGerarRelatorio = new JButton("Gerar Relat\u00F3rio");
		buttonsGerarRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					repRelatorio.gerarRelatorioServico(repServico.getIterator());
					textsRelatorioServico.setText(repRelatorio.puxarUltimoRelatorioServico());
					JOptionPane.showMessageDialog(panelRelatorioServico, "Relatório gerado com suscesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
				} catch (RepositorioException e1) {
					JOptionPane.showMessageDialog(panelRelatorioServico, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				} catch (ValorInvalidoException e1) {
					JOptionPane.showMessageDialog(panelRelatorioServico, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				}
			}
		});
		buttonsGerarRelatorio.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonsGerarRelatorio.setBorder(new LineBorder(new Color(0, 102, 153)));
		buttonsGerarRelatorio.setBackground(Color.WHITE);
		buttonsGerarRelatorio.setBounds(30, 11, 133, 23);
		panelRelatorioServico.add(buttonsGerarRelatorio);
		
		textsRelatorioServico = new JTextPane();
		textsRelatorioServico.setForeground(Color.WHITE);
		textsRelatorioServico.setFont(new Font("Tahoma", Font.BOLD, 12));
		textsRelatorioServico.setBackground(new Color(0, 153, 204));
		textsRelatorioServico.setBounds(10, 85, 664, 344);
		panelRelatorioServico.add(textsRelatorioServico);
		
		buttonsVerRelatorio = new JButton("Ver Relat\u00F3rio N.");
		buttonsVerRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int numero = 0;
					if(textsNumero.getText().matches("[0-9]+")){
						numero = Integer.parseInt(textsNumero.getText());
					} else {
						throw new ValorInvalidoException("número");
					}
					textsRelatorioServico.setText(repRelatorio.puxarRelatorioServico(numero));
					JOptionPane.showMessageDialog(panelRelatorioServico, "Relatório recuperado com suscesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
				} catch (ValorInvalidoException e1) {
					JOptionPane.showMessageDialog(panelRelatorioServico, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				}
			}
		});
		buttonsVerRelatorio.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonsVerRelatorio.setBorder(new LineBorder(new Color(0, 102, 153)));
		buttonsVerRelatorio.setBackground(Color.WHITE);
		buttonsVerRelatorio.setBounds(193, 11, 133, 23);
		panelRelatorioServico.add(buttonsVerRelatorio);
		
		buttonsSalvarRelatorio = new JButton("Salvar Relat\u00F3rio N.");
		buttonsSalvarRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooserDiretorio = new JFileChooser();
				chooserDiretorio.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				chooserDiretorio.setAcceptAllFileFilterUsed(false);
				chooserDiretorio.setFileFilter(new javax.swing.filechooser.FileFilter(){  
					   public boolean accept(File f){  
					      return (f.getName().endsWith(".txt")) || f.isDirectory();  
					   }  
					   public String getDescription(){  
					       return ".txt";  
					   }  
				});
				int resposta = chooserDiretorio.showSaveDialog(null);
				if(resposta == JFileChooser.APPROVE_OPTION){
					try{
						int numero = 0;
						if(textsNumero.getText().matches("[0-9]+")){
							numero = Integer.parseInt(textsNumero.getText());
						} else {
							throw new ValorInvalidoException("número");
						}
						
						File file = new File((chooserDiretorio.getSelectedFile().getAbsolutePath()+ ".txt").replace(".txt.txt", ".txt"));
						FileWriter wFile;
						BufferedWriter bfFile;
						if(file.exists()){
							file.delete();
						}
						file.createNewFile();
						wFile = new FileWriter(file);
						bfFile = new BufferedWriter(wFile);
						bfFile.write(repRelatorio.puxarRelatorioServico(numero).replaceAll("\n", "\r\n"));
						bfFile.close();
						wFile.close();
						JOptionPane.showMessageDialog(panelRelatorioServico, "Arquivo .txt gerado com sucesso!");
						JOptionPane.showMessageDialog(panelRelatorioServico, "Arquivo .txt gerado com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(panelRelatorioServico, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
					} catch (ValorInvalidoException e1) {
						JOptionPane.showMessageDialog(panelRelatorioServico, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
					}
				}
			}
		});
		buttonsSalvarRelatorio.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonsSalvarRelatorio.setBorder(new LineBorder(new Color(0, 102, 153)));
		buttonsSalvarRelatorio.setBackground(Color.WHITE);
		buttonsSalvarRelatorio.setBounds(356, 11, 133, 23);
		panelRelatorioServico.add(buttonsSalvarRelatorio);
		
		buttonsSalvarRelatorios = new JButton("Salvar Relat\u00F3rios");
		buttonsSalvarRelatorios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooserDiretorio = new JFileChooser();
				chooserDiretorio.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				chooserDiretorio.setAcceptAllFileFilterUsed(false);
				chooserDiretorio.setFileFilter(new javax.swing.filechooser.FileFilter(){  
					   public boolean accept(File f){  
					      return (f.getName().endsWith(".txt")) || f.isDirectory();  
					   }  
					   public String getDescription(){  
					       return ".txt";  
					   }  
				});
				int resposta = chooserDiretorio.showSaveDialog(null);
				if(resposta == JFileChooser.APPROVE_OPTION){
					try{
						File file = new File((chooserDiretorio.getSelectedFile().getAbsolutePath()+ ".txt").replace(".txt.txt", ".txt"));
						FileWriter wFile;
						BufferedWriter bfFile;
						if(file.exists()){
							file.delete();
						}
						file.createNewFile();
						wFile = new FileWriter(file);
						bfFile = new BufferedWriter(wFile);
						
						
						Iterator<String> it = repRelatorio.IteratorRelatorioServico();
						while(it.hasNext()){
							bfFile.write(it.next().replaceAll("\n", "\r\n") + "\r\n\r\n");
						}
						
						bfFile.close();
						wFile.close();
						JOptionPane.showMessageDialog(panelRelatorioServico, "Arquivo .txt gerado com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(panelRelatorioServico, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
					}
				}
			}
		});
		buttonsSalvarRelatorios.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonsSalvarRelatorios.setBorder(new LineBorder(new Color(0, 102, 153)));
		buttonsSalvarRelatorios.setBackground(Color.WHITE);
		buttonsSalvarRelatorios.setBounds(519, 11, 133, 23);
		panelRelatorioServico.add(buttonsSalvarRelatorios);
		
		label_33 = new JLabel("N\u00FAmero do Relat\u00F3rio:");
		label_33.setForeground(Color.WHITE);
		label_33.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_33.setBounds(178, 43, 133, 20);
		panelRelatorioServico.add(label_33);
		
		textsNumero = new JTextField();
		textsNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textsNumero.setColumns(10);
		textsNumero.setBorder(new LineBorder(new Color(0, 102, 153)));
		textsNumero.setBounds(312, 43, 192, 20);
		panelRelatorioServico.add(textsNumero);
		
		panelRelatorioPessoa = new JPanel();
		panelRelatorioPessoa.setLayout(null);
		panelRelatorioPessoa.setBackground(new Color(0, 153, 204));
		panelRelatorioPessoa.setBounds(0, 0, 684, 440);
		panelRelatorio.add(panelRelatorioPessoa);
		
		btnGerarRelatrio = new JButton("Gerar Relat\u00F3rio");
		btnGerarRelatrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					repRelatorio.gerarRelatorioPessoa(repPessoa.getIterator());
					textrPessoa.setText(repRelatorio.puxarUltimoRelatorioPessoa());
					JOptionPane.showMessageDialog(panelRelatorioPessoa, "Relatório gerado com suscesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
				} catch (RepositorioException e1) {
					JOptionPane.showMessageDialog(panelRelatorioPessoa, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				} catch (ValorInvalidoException e1) {
					JOptionPane.showMessageDialog(panelRelatorioPessoa, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				}
			}
		});
		btnGerarRelatrio.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGerarRelatrio.setBorder(new LineBorder(new Color(0, 102, 153)));
		btnGerarRelatrio.setBackground(Color.WHITE);
		btnGerarRelatrio.setBounds(30, 11, 133, 23);
		panelRelatorioPessoa.add(btnGerarRelatrio);
		
		textrPessoa = new JTextPane();
		textrPessoa.setBackground(new Color(0, 153, 204));
		textrPessoa.setFont(new Font("Tahoma", Font.BOLD, 12));
		textrPessoa.setForeground(new Color(255, 255, 255));
		textrPessoa.setBounds(10, 85, 664, 344);
		panelRelatorioPessoa.add(textrPessoa);
		
		buttonVerRelatorio = new JButton("Ver Relat\u00F3rio N.");
		buttonVerRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int numero = 0;
					if(textrpNumero.getText().matches("[0-9]+")){
						numero = Integer.parseInt(textrpNumero.getText());
					} else {
						throw new ValorInvalidoException("número");
					}
					textrPessoa.setText(repRelatorio.puxarRelatorioPessoa(numero));
					JOptionPane.showMessageDialog(panelRelatorioPessoa, "Relatório recuperado com suscesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
				} catch (ValorInvalidoException e1) {
					JOptionPane.showMessageDialog(panelRelatorioPessoa, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				}
			}
		});
		buttonVerRelatorio.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonVerRelatorio.setBorder(new LineBorder(new Color(0, 102, 153)));
		buttonVerRelatorio.setBackground(Color.WHITE);
		buttonVerRelatorio.setBounds(193, 11, 133, 23);
		panelRelatorioPessoa.add(buttonVerRelatorio);
		
		btnSalvarRelatrioN = new JButton("Salvar Relat\u00F3rio N.");
		btnSalvarRelatrioN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser chooserDiretorio = new JFileChooser();
				chooserDiretorio.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				chooserDiretorio.setAcceptAllFileFilterUsed(false);
				chooserDiretorio.setFileFilter(new javax.swing.filechooser.FileFilter(){  
					   public boolean accept(File f){  
					      return (f.getName().endsWith(".txt")) || f.isDirectory();  
					   }  
					   public String getDescription(){  
					       return ".txt";  
					   }  
				});
				int resposta = chooserDiretorio.showSaveDialog(null);
				if(resposta == JFileChooser.APPROVE_OPTION){
					try{
						int numero = 0;
						if(textrpNumero.getText().matches("[0-9]+")){
							numero = Integer.parseInt(textrpNumero.getText());
						} else {
							throw new ValorInvalidoException("número");
						}
						
						File file = new File((chooserDiretorio.getSelectedFile().getAbsolutePath()+ ".txt").replace(".txt.txt", ".txt"));
						FileWriter wFile;
						BufferedWriter bfFile;
						if(file.exists()){
							file.delete();
						}
						file.createNewFile();
						wFile = new FileWriter(file);
						bfFile = new BufferedWriter(wFile);
						bfFile.write(repRelatorio.puxarRelatorioPessoa(numero).replaceAll("\n", "\r\n"));
						bfFile.close();
						wFile.close();
						JOptionPane.showMessageDialog(panelRelatorioPessoa, "Arquivo .txt gerado com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(panelRelatorioPessoa, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
					} catch (ValorInvalidoException e1) {
						JOptionPane.showMessageDialog(panelRelatorioPessoa, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
					}
				}
			}
		});
		btnSalvarRelatrioN.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSalvarRelatrioN.setBorder(new LineBorder(new Color(0, 102, 153)));
		btnSalvarRelatrioN.setBackground(Color.WHITE);
		btnSalvarRelatrioN.setBounds(356, 11, 133, 23);
		panelRelatorioPessoa.add(btnSalvarRelatrioN);
		
		btnSalvarRelatrios = new JButton("Salvar Relat\u00F3rios");
		btnSalvarRelatrios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser chooserDiretorio = new JFileChooser();
				chooserDiretorio.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				chooserDiretorio.setAcceptAllFileFilterUsed(false);
				chooserDiretorio.setFileFilter(new javax.swing.filechooser.FileFilter(){  
					   public boolean accept(File f){  
					      return (f.getName().endsWith(".txt")) || f.isDirectory();  
					   }  
					   public String getDescription(){  
					       return ".txt";  
					   }  
				});
				int resposta = chooserDiretorio.showSaveDialog(null);
				if(resposta == JFileChooser.APPROVE_OPTION){
					try{
						File file = new File((chooserDiretorio.getSelectedFile().getAbsolutePath()+ ".txt").replace(".txt.txt", ".txt"));
						FileWriter wFile;
						BufferedWriter bfFile;
						if(file.exists()){
							file.delete();
						}
						file.createNewFile();
						wFile = new FileWriter(file);
						bfFile = new BufferedWriter(wFile);
						
						
						Iterator<String> it = repRelatorio.IteratorRelatorioPessoa();
						while(it.hasNext()){
							bfFile.write(it.next().replaceAll("\n", "\r\n") + "\r\n\r\n");
						}
						
						bfFile.close();
						wFile.close();
						JOptionPane.showMessageDialog(panelRelatorioPessoa, "Arquivo .txt gerado com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(panelRelatorioPessoa, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
					}
				}
			}
		});
		btnSalvarRelatrios.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSalvarRelatrios.setBorder(new LineBorder(new Color(0, 102, 153)));
		btnSalvarRelatrios.setBackground(Color.WHITE);
		btnSalvarRelatrios.setBounds(519, 11, 133, 23);
		panelRelatorioPessoa.add(btnSalvarRelatrios);
		
		lblNmeroDoRelatrio = new JLabel("N\u00FAmero do Relat\u00F3rio:");
		lblNmeroDoRelatrio.setForeground(Color.WHITE);
		lblNmeroDoRelatrio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNmeroDoRelatrio.setBounds(178, 43, 162, 20);
		panelRelatorioPessoa.add(lblNmeroDoRelatrio);
		
		textrpNumero = new JTextField();
		textrpNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textrpNumero.setColumns(10);
		textrpNumero.setBorder(new LineBorder(new Color(0, 102, 153)));
		textrpNumero.setBounds(311, 43, 193, 20);
		panelRelatorioPessoa.add(textrpNumero);
		
		panelRelatorioProduto = new JPanel();
		panelRelatorioProduto.setLayout(null);
		panelRelatorioProduto.setBackground(new Color(0, 153, 204));
		panelRelatorioProduto.setBounds(0, 0, 684, 440);
		panelRelatorio.add(panelRelatorioProduto);
		
		JButton buttonrpGerarRelatorio = new JButton("Gerar Relat\u00F3rio");
		buttonrpGerarRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					repRelatorio.gerarRelatorioProduto(repProduto.getIterator());
					textrProduto.setText(repRelatorio.puxarUltimoRelatorioProduto());
					JOptionPane.showMessageDialog(panelRelatorioProduto, "Relatório gerado com suscesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
				} catch (RepositorioException e1) {
					JOptionPane.showMessageDialog(panelRelatorioProduto, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				} catch (ValorInvalidoException e1) {
					JOptionPane.showMessageDialog(panelRelatorioProduto, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				}
			}
		});
		buttonrpGerarRelatorio.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonrpGerarRelatorio.setBorder(new LineBorder(new Color(0, 102, 153)));
		buttonrpGerarRelatorio.setBackground(Color.WHITE);
		buttonrpGerarRelatorio.setBounds(30, 11, 133, 23);
		panelRelatorioProduto.add(buttonrpGerarRelatorio);
		
		textrProduto = new JTextPane();
		textrProduto.setForeground(Color.WHITE);
		textrProduto.setFont(new Font("Tahoma", Font.BOLD, 12));
		textrProduto.setBackground(new Color(0, 153, 204));
		textrProduto.setBounds(10, 85, 664, 344);
		panelRelatorioProduto.add(textrProduto);
		
		JButton buttonrpVerRelatorio = new JButton("Ver Relat\u00F3rio N.");
		buttonrpVerRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int numero = 0;
					if(textrpRelatorioNumero.getText().matches("[0-9]+")){
						numero = Integer.parseInt(textrpRelatorioNumero.getText());
					} else {
						throw new ValorInvalidoException("número");
					}
					textrProduto.setText(repRelatorio.puxarRelatorioProduto(numero));
					JOptionPane.showMessageDialog(panelRelatorioProduto, "Relatório recuperado com suscesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
				} catch (ValorInvalidoException e1) {
					JOptionPane.showMessageDialog(panelRelatorioProduto, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
				}
			}
		});
		buttonrpVerRelatorio.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonrpVerRelatorio.setBorder(new LineBorder(new Color(0, 102, 153)));
		buttonrpVerRelatorio.setBackground(Color.WHITE);
		buttonrpVerRelatorio.setBounds(193, 11, 133, 23);
		panelRelatorioProduto.add(buttonrpVerRelatorio);
		
		JButton buttonrpSalvarRelatorioN = new JButton("Salvar Relat\u00F3rio N.");
		buttonrpSalvarRelatorioN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser chooserDiretorio = new JFileChooser();
				chooserDiretorio.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				chooserDiretorio.setAcceptAllFileFilterUsed(false);
				chooserDiretorio.setFileFilter(new javax.swing.filechooser.FileFilter(){  
					   public boolean accept(File f){  
					      return (f.getName().endsWith(".txt")) || f.isDirectory();  
					   }  
					   public String getDescription(){  
					       return ".txt";  
					   }  
				});
				int resposta = chooserDiretorio.showSaveDialog(null);
				if(resposta == JFileChooser.APPROVE_OPTION){
					try{
						int numero = 0;
						if(textrpRelatorioNumero.getText().matches("[0-9]+")){
							numero = Integer.parseInt(textrpRelatorioNumero.getText());
						} else {
							throw new ValorInvalidoException("número");
						}
						
						File file = new File((chooserDiretorio.getSelectedFile().getAbsolutePath()+ ".txt").replace(".txt.txt", ".txt"));
						FileWriter wFile;
						BufferedWriter bfFile;
						if(file.exists()){
							file.delete();
						}
						file.createNewFile();
						wFile = new FileWriter(file);
						bfFile = new BufferedWriter(wFile);
						bfFile.write(repRelatorio.puxarRelatorioProduto(numero).replaceAll("\n", "\r\n"));
						bfFile.close();
						wFile.close();
						JOptionPane.showMessageDialog(panelRelatorioProduto, "Arquivo .txt gerado com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
						
						
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(panelRelatorioProduto, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
					} catch (ValorInvalidoException e1) {
						JOptionPane.showMessageDialog(panelRelatorioProduto, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
					}
				}
			}
		});
		buttonrpSalvarRelatorioN.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonrpSalvarRelatorioN.setBorder(new LineBorder(new Color(0, 102, 153)));
		buttonrpSalvarRelatorioN.setBackground(Color.WHITE);
		buttonrpSalvarRelatorioN.setBounds(356, 11, 133, 23);
		panelRelatorioProduto.add(buttonrpSalvarRelatorioN);
		
		JButton buttonrpSalvarRelatorio = new JButton("Salvar Relat\u00F3rios");
		buttonrpSalvarRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooserDiretorio = new JFileChooser();
				chooserDiretorio.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				chooserDiretorio.setAcceptAllFileFilterUsed(false);
				chooserDiretorio.setFileFilter(new javax.swing.filechooser.FileFilter(){  
					   public boolean accept(File f){  
					      return (f.getName().endsWith(".txt")) || f.isDirectory();  
					   }  
					   public String getDescription(){  
					       return ".txt";  
					   }  
				});
				int resposta = chooserDiretorio.showSaveDialog(null);
				if(resposta == JFileChooser.APPROVE_OPTION){
					try{
						File file = new File((chooserDiretorio.getSelectedFile().getAbsolutePath()+ ".txt").replace(".txt.txt", ".txt"));
						FileWriter wFile;
						BufferedWriter bfFile;
						if(file.exists()){
							file.delete();
						}
						file.createNewFile();
						wFile = new FileWriter(file);
						bfFile = new BufferedWriter(wFile);
						
						
						Iterator<String> it = repRelatorio.IteratorRelatorioProduto();
						while(it.hasNext()){
							bfFile.write(it.next().replaceAll("\n", "\r\n") + "\r\n\r\n");
						}
						
						bfFile.close();
						wFile.close();
						JOptionPane.showMessageDialog(panelRelatorioProduto, "Arquivo .txt gerado com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(panelRelatorioProduto, e1.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/erro.png")));
					}
				}
			}
		});
		buttonrpSalvarRelatorio.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonrpSalvarRelatorio.setBorder(new LineBorder(new Color(0, 102, 153)));
		buttonrpSalvarRelatorio.setBackground(Color.WHITE);
		buttonrpSalvarRelatorio.setBounds(519, 11, 133, 23);
		panelRelatorioProduto.add(buttonrpSalvarRelatorio);
		
		JLabel label_32 = new JLabel("N\u00FAmero do Relat\u00F3rio:");
		label_32.setForeground(Color.WHITE);
		label_32.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_32.setBounds(178, 43, 193, 20);
		panelRelatorioProduto.add(label_32);
		
		textrpRelatorioNumero = new JTextField();
		textrpRelatorioNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textrpRelatorioNumero.setColumns(10);
		textrpRelatorioNumero.setBorder(new LineBorder(new Color(0, 102, 153)));
		textrpRelatorioNumero.setBounds(311, 43, 193, 20);
		panelRelatorioProduto.add(textrpRelatorioNumero);
		panelRelatorio.setVisible(false);
		
		
		panelCadastrar.setVisible(false);
	}
	
	public void limparText(){
		this.textcBairro.setText("");
		this.textcCEP.setText("");
		this.textcCidade.setText("");
		this.textcComplemento.setText("");
		this.textcCPF.setText("");
		this.textcEmail.setText("");
		this.textcHorasSemanais.setText("");
		this.textcLogradouro.setText("");
		this.textcNome.setText("");
		this.textcNumero.setText("");
		this.textcPais.setText("");
		this.textcSalario.setText("");
		this.textcSenha.setText("");
		this.textcTelefone.setText("");
		this.comboBoxcAnos.setSelectedIndex(0);
		this.comboBoxcCargos.setSelectedIndex(0);
		this.comboBoxcDias.setSelectedIndex(0);
		this.comboBoxcEstados.setSelectedIndex(0);
		this.comboBoxcMes.setSelectedIndex(0);
		this.comboBoxcSexo.setSelectedIndex(0);
		
		this.textpcTitulo.setText("");
		this.textpcPreco.setText("");
		this.textpcEdicao.setText("");
		this.textpcISBN.setText("");
		this.textpcAutor.setText("");
		this.textpcEditora.setText("");
		this.textpcAno.setText("");
		this.textpcNumeroPag.setText("");
		this.textpcQuantEstoque.setText("");
		this.textpcPeso.setText("");
		this.textpcAltura.setText("");
		this.textpcLargura.setText("");
		this.textpcComprimento.setText("");
		this.comboBoxpcIdiomas.setSelectedIndex(0);
		this.comboBoxpcAcabamentos.setSelectedIndex(0);
		this.textpcTamanho.setText("");
		this.textpcQuantLicenca.setText("");
		this.comboBoxpcFormatos.setSelectedIndex(0);
		
		this.textscNome.setText("");
		this.textscHorario.setText("");
		this.textscVagas.setText("");
		this.textscCodigo.setText("");
		this.comboBoxscDias.setSelectedIndex(0);
		this.comboBoxscMeses.setSelectedIndex(0);
		this.comboBoxscAnos.setSelectedIndex(0);
		this.textscDuracao.setText("");
		this.textscLogradouro.setText("");
		this.textscNumero.setText("");
		this.textscComplemento.setText("");
		this.textscCEP.setText("");
		this.textscBairro.setText("");
		this.textscCidade.setText("");
		this.textscPais.setText("");
		this.comboBoxscEstados.setSelectedIndex(0);
		this.textscDescricao.setText("");
		this.textscPalestrante.setText("");
		this.textscProfessor.setText("");
		this.textscCargaHoraria.setText("");
		this.checkscseg.setSelected(false);
		this.checkscter.setSelected(false);
		this.checkscqua.setSelected(false);
		this.checkscqui.setSelected(false);
		this.checkscsex.setSelected(false);
		this.checkscsab.setSelected(false);
		this.checkscdom.setSelected(false);
	}
}
