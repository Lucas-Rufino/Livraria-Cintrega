# Livraria Cintrega - Sistema de Gerenciamento para Livrarias

A aplicação "Livraria Cintegra" é um projeto de sistema de gerenciamento de uma livraria, apresentado como 
requisito parcial na cadeira de introdução a programação (IF669) no Centro de Informática da UFPE (Cin - Campus Recife).

## Introdução

O aplicativo "Livraria Cintegra" é um sistema de gerenciamento desenvolvido especificamente para livrarias, onde é possível
cadastrar, atualizar, procurar e remover informações de clientes, funcionários, livros, ebooks, palestras e cursos em um 
repositório. O tipo do repositório pode variar entre três opções distintas: Array, Lista e Arquivo (repositório consistente
com a biblioteca jExcel). A aplicação também permite realizar transações de vendas de produtos e inscrições em cursos e 
palestras. Também é possível gerar relatórios sobre o repositório de dados.

<p align="center">
<img align="center" src="https://github.com/Lucas-Rufino/Livraria-Cintrega/blob/master/doc/1.png?raw=true" alt="doc">
</p> 

## Funcionalidades

Dentre as funcionalidades da aplicação, podemos citar:

  - Acesso por senha. Apenas um funcionário cadastrado pode acessar (Obs.: primeiro acesso através do CPF: admin e senha: 
  admin).
  - Seleção entre 3 diferentes tipos de repositório: Array, Lista e Arquivos (xls), sendo apenas o último consistente através
  da biblioteca jExcel. O tipo de repositório pode ser escolhido através do arquivo "config.txt", modificando para o número
  respectivo dentro do arquivo. Obs1.: o arquivo "config.txt" deve esta sempre próximo ao projeto ao aplicação executável (.jar).
  Obs2.: O repositório de arquivo produzirá automaticamente arquivos próximos ao projeto ou aplicação (.jar).
  - Cadastro de clientes, funcionários, livros físicos, ebooks, palestras e cursos.
  
<p align="center">
<img align="center" src="https://github.com/Lucas-Rufino/Livraria-Cintrega/blob/master/doc/2.png?raw=true" alt="doc">
</p> 
  - Atualização de clientes, funcionários, livros físicos, ebooks, palestras e cursos sem modificação do identificador único,
  são eles: CPF (para pessoas), ISBN (para produtos) e Código (para serviços).
  
<p align="center">
<img align="center" src="https://github.com/Lucas-Rufino/Livraria-Cintrega/blob/master/doc/3.png?raw=true" alt="doc">
</p> 

  - Busca de clientes, funcionários, livros físicos, ebooks, palestras e cursos através do identificador único.
  
<p align="center">
<img align="center" src="https://github.com/Lucas-Rufino/Livraria-Cintrega/blob/master/doc/4.png?raw=true" alt="doc">
</p> 

  - Remoção de clientes, funcionários, livros físicos, ebooks, palestras e cursos através do identificador único.
  
<p align="center">
<img align="center" src="https://github.com/Lucas-Rufino/Livraria-Cintrega/blob/master/doc/5.png?raw=true" alt="doc">
</p> 

  - Realizar transições comerciais de venda de produto e inscrição de pessoas em serviços.
  
<p align="center">
<img align="center" src="https://github.com/Lucas-Rufino/Livraria-Cintrega/blob/master/doc/6.png?raw=true" alt="doc">
<img align="center" src="https://github.com/Lucas-Rufino/Livraria-Cintrega/blob/master/doc/7.png?raw=true" alt="doc">
</p> 

  - Geração de relatório de pessoas, produtos e serviços, que podem ser visualizados na própria aplicação através do número
  do relatório. Os relatórios também podem ser salvos como uma versão .txt. Obs.: todos as informações são organizadas no
  relatório em ordem alfabética.
  
<p align="center">
<img align="center" src="https://github.com/Lucas-Rufino/Livraria-Cintrega/blob/master/doc/8.png?raw=true" alt="doc">
<img align="center" src="https://github.com/Lucas-Rufino/Livraria-Cintrega/blob/master/doc/9.png?raw=true" alt="doc">
</p> 

## Informações Relevantes

  - Toda a aplicação foi baseada em técnicas de padrão de projeto (Interface, Facade, Business...).
  - Todo o projeto está documentado em JavaDoc.
  - Foram aplicadas técnicas de herança e classes/métodos abstratos.
  - o repositório possui clonagem de dados para manter consistência.
  - Sistema de exceções para tratamento de inconsistências de dados.
  
