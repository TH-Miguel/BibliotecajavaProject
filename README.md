# Sistema de Biblioteca em Java

Este projeto consiste em um **Sistema de Gerenciamento de Biblioteca** desenvolvido em **Java** utilizando os princípios da **Programação Orientada a Objetos (POO)**. O objetivo é fornecer uma ferramenta robusta e funcional para o controle de livros, usuários e empréstimos em um ambiente de biblioteca universitária, operando via terminal.

---

## Funcionalidades Implementadas

O sistema permite as seguintes operações essenciais para o gerenciamento de uma biblioteca:

* **Cadastro de Livros:** Adicionar novos livros com informações como título, autor, gênero e ano de publicação.
* **Modificação de Livros:** Atualizar os dados de livros existentes.
* **Exclusão de Livros:** Remover livros do acervo (com validações para evitar exclusão de livros emprestados).
* **Cadastro de Usuários:** Registrar novos usuários da biblioteca com nome e matrícula.
* **Modificação de Usuários:** Atualizar informações de usuários existentes.
* **Exclusão de Usuários:** Remover usuários do sistema.
* **Registro de Empréstimos:** Efetuar o empréstimo de um livro para um usuário, atualizando a disponibilidade do livro.
* **Encerramento de Empréstimos:** Registrar a devolução de um livro, atualizando seu status para disponível.
* **Consulta de Livros:** Listar todos os livros disponíveis, com opções de filtro por gênero e autor.
* **Consulta de Histórico de Empréstimos:** Visualizar o histórico de empréstimos de um usuário específico.
* **Consulta de Usuários e Empréstimos:** O bibliotecário pode consultar a lista de usuários e livros com filtros por status de empréstimo.

---

## Estrutura do Projeto

O projeto é organizado em pacotes para garantir modularidade e clareza, seguindo as boas práticas de POO:

* `com.suaempresa.biblioteca.model`: Contém as classes que representam as entidades do sistema (ex: `Livro`, `Usuario`, `Emprestimo`).
* `com.suaempresa.biblioteca.service` (ou `manager`): Contém a lógica de negócio e as operações CRUD para cada entidade.
* `com.suaempresa.biblioteca.app`: Contém a classe principal (`Main`) responsável por iniciar a aplicação e interagir com o usuário via terminal.

---

## Como Executar o Projeto

Para rodar o Sistema de Biblioteca em seu ambiente local, siga os passos abaixo:

1.  **Pré-requisitos:**
    * **Java Development Kit (JDK) 17 ou superior:** Certifique-se de ter o JDK instalado e configurado em seu sistema.
    * **IntelliJ IDEA:** Esta é a IDE recomendada para o desenvolvimento e execução deste projeto.

2.  **Clonar o Repositório:**
    * Abra o **IntelliJ IDEA**.
    * Na tela de boas-vindas, clique em **"Get from VCS"** (ou `File` > `New` > `Project from Version Control...`).
    * Cole a URL deste repositório: `https://github.com/SeuUsuario/BibliotecaJavaProject.git` (substitua `SeuUsuario` pelo seu username do GitHub).
    * Clique em **"Clone"**.

3.  **Configurar e Executar:**
    * Após a clonagem, o IntelliJ irá abrir o projeto.
    * Certifique-se de que o JDK esteja corretamente configurado para o projeto (File > Project Structure > Project SDK).
    * Navegue até a classe `Main` (geralmente em `src/main/java/com/suaempresa/biblioteca/app/Main.java`).
    * Clique no botão verde de "play" ao lado do método `main` ou vá em `Run` > `Run 'Main'`.
    * A aplicação será iniciada no terminal do IntelliJ, e você poderá interagir com o sistema através de comandos de texto.

---

## Equipe de Desenvolvimento

Este projeto foi desenvolvido por:

* Thiago  Miguel (Back-end / Desenvolvedor Principal)
* Abilio  Batista (Colaborador)
* Gabriel Travassos (Colaborador)
* Pedro   Dantas (Colaborador)

---

## Dificuldades e Colaboração

Este projeto foi um desafio interessante, especialmente por contar com uma equipe multidisciplinar. Como o projeto é puramente **back-end** e opera via **terminal**, sem uma interface gráfica de usuário (UI), a principal dificuldade para os membros da equipe com foco em **front-end** (e conhecimento em Python) pode ter sido a adaptação à lógica de negócios orientada a objetos em Java e a ausência de uma visualização imediata das interações, que geralmente é proporcionada pelo front-end.

Para superar isso, a colaboração se focou em:

* **Entendimento da Lógica:** Os colaboradores front-end contribuíram significativamente no entendimento e na validação das regras de negócio do sistema de biblioteca.
* **Testes e Validação:** A equipe se uniu na etapa de testes manuais via terminal, verificando se as funcionalidades de CRUD e empréstimos estavam operando conforme o esperado.
* **Documentação e Estrutura:** A contribuição para a organização do código, a criação de comentários claros e a estruturação do `README` foi essencial para garantir a compreensão do projeto por todos.

Apesar da diferença nas expertises de front-end, o conhecimento em **lógica de programação e back-end em Python** dos colaboradores foi fundamental para a compreensão das estruturas de dados, fluxos de controle e princípios de POO aplicados em Java, facilitando a colaboração e o aprendizado mútuo.
