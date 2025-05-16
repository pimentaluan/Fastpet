
---

# 🐾 Fastpet

**Fastpet** é uma aplicação de console em Java que simula o gerenciamento de um pet shop. O sistema implementa operações de cadastro, listagem, alteração, consulta e exclusão de dados utilizando o banco de dados orientado a objetos **db4o**.

## 🎯 Objetivo

Este projeto foi desenvolvido com o objetivo de aplicar os conceitos de **persistência de objetos** usando o banco de dados **db4o**.

## 📚 Tecnologias Utilizadas

- Java (JDK 5+)
- db4o (versão 8.1)
- Eclipse IDE (recomendado)
- Persistência em arquivo local (`banco.db4o`)

---

## 🧱 Estrutura do Projeto

Fastpet/ ├── bin/                  # Arquivos compilados (.class) ├── lib/                  # Biblioteca db4o │   └── db4o-8.1.249.16099-core-java5.jar ├── src/                  # Código-fonte │   ├── appconsole/       # Funcionalidades de console │   └── modelo/           # Classes de negócio ├── banco.db4o            # Arquivo do banco de dados ├── .classpath            # Arquivo de configuração (Eclipse) ├── .project              # Arquivo de configuração (Eclipse)

---

## 💼 Classes de Negócio

Localizadas em `src/modelo/`:

- `Pet.java`
- `Tutor.java`
- `Servico.java`

---

## 🖥️ Funcionalidades

Localizadas em `src/appconsole/`, cada classe representa uma operação CRUD:

### ✅ `Cadastrar.java`
- Realiza o cadastro de vários objetos como massa de teste.

### ✅ `Listar.java`
- Lista todos os objetos cadastrados no banco.

### ✅ `Alterar.java`
- Permite:
  - Adicionar relacionamentos entre objetos.
  - Remover relacionamentos existentes.

### ✅ `Apagar.java`
- Exclui objetos mesmo que possuam relacionamentos.
- Contém lógica para evitar objetos órfãos.

### ✅ `Consultar.java`
- Realiza **3 consultas utilizando a linguagem SODA**, conforme exigido no projeto.

---

## 🛠️ Configuração e Execução

### Pré-requisitos:
- Java JDK 5 ou superior instalado.
- Eclipse IDE (opcional, mas recomendado).

### Passo a passo:

1. Clone o repositório:

```bash
git clone https://github.com/seu-usuario/Fastpet.git

2. Importe o projeto no Eclipse:

File > Import > Existing Projects into Workspace



3. Verifique se a biblioteca db4o está incluída no build path:

Clique com o botão direito no projeto → Build Path > Configure Build Path → aba Libraries.



4. Execute uma das classes com main, como Cadastrar.java:

Clique com o direito → Run As > Java Application.





---

📌 Requisitos Atendidos

✔️ Persistência de objetos com db4o
✔️ Implementação completa das funcionalidades CRUD
✔️ Consultas com SODA
✔️ Relacionamentos entre objetos tratados
✔️ Armazenamento de datas como String
✔️ Tratamento de objetos órfãos
✔️ Projeto pronto para apresentação

---

👤 Autor

Luan Pimenta 

Jonata Barbosa



---

📄 Licença

Este projeto está licenciado sob a licença MIT.

---

