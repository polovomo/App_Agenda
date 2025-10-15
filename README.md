# 📱 AppAgenda - Cadastro de Pessoas com Banco de Dados

Um aplicativo Android simples desenvolvido em **Java + XML** no **Android Studio**, que permite cadastrar e gerenciar pessoas com nome, CPF e telefone armazenados em banco de dados SQLite.  
Projeto criado para aprendizado prático de desenvolvimento mobile nativo, persistência de dados e manipulação de listas.

---

## 🧠 Sobre o Projeto

O **AppAgenda** oferece funcionalidades básicas de:

- Criação, leitura, atualização e exclusão (CRUD) de registros em banco SQLite  
- Uso de **EditText**, **Button** e **ListView** no layout  
- Criação de menus de contexto e menu principal para navegação e ações  
- Implementação de banco de dados SQLite com helper e DAO  
- Navegação entre telas e passagem de objetos entre Activities via Intent  

---

## 🛠️ Tecnologias Utilizadas

| Categoria       | Ferramenta                  |
|-----------------|----------------------------|
| IDE             | Android Studio             |
| Linguagem       | Java                       |
| Layouts         | XML                        |
| Banco de Dados  | SQLite                    |
| Android API     | API 21 (Android 5.0 Lollipop) |
| UI Framework    | ConstraintLayout           |

---

## 📁 Estrutura do Projeto
````
app/
├── java/
│ └── br/com/senacrs/appagenda/
│ ├── MainActivity.java
│ ├── ListarPessoasActitivity.java
│ ├── Pessoa.java
│ ├── PessoaDAO.java
│ └── Conexao.java
├── res/
│ ├── layout/
│ │ ├── activity_main.xml
│ │ └── activity_listar_pessoa_activity.xml
│ ├── menu/
│ │ ├── menu_principal.xml
│ │ └── menu_contexto.xml
│ └── values/
│ └── strings.xml
└── AndroidManifest.xml
````

---

## 🧩 Funcionalidades do App

- Formulário para cadastro de pessoa (nome, CPF, telefone)  
- Armazenamento dos dados em banco SQLite local  
- Listagem dos registros cadastrados em ListView  
- Pesquisa dinâmica por nome via SearchView no menu  
- Menu contextual para atualizar ou excluir registros  
- Passagem de objeto Pessoa entre Activities para edição  

---

## 📋 Exemplo de Código - Inserção de Pessoa

````
java
public void salvar(View view) {
    if (pessoa == null) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(edNome.getText().toString());
        pessoa.setCpf(edCpf.getText().toString());
        pessoa.setTelefone(edTelefone.getText().toString());
        long id = dao.inserir(pessoa);
        Toast.makeText(this, "Pessoa inserida no ID: " + id, Toast.LENGTH_LONG).show();
    } else {
        pessoa.setNome(edNome.getText().toString());
        pessoa.setCpf(edCpf.getText().toString());
        pessoa.setTelefone(edTelefone.getText().toString());
        dao.atualizar(pessoa);
        Toast.makeText(this, pessoa.getNome() + " atualizado com sucesso!", Toast.LENGTH_LONG).show();
    }
}
````

## 🗂️ Layout XML - Exemplo do Formulário

````

<EditText
    android:id="@+id/edNome"
    android:layout_width="0dp"
    android:layout_height="wrap_content"
    android:hint="Insira seu nome"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintTop_toTopOf="parent" />

````

## ⚙️ Banco de Dados SQLite

A classe Conexao cria o banco e a tabela:
````
@Override
public void onCreate(SQLiteDatabase db) {
    db.execSQL("CREATE TABLE pessoa(" +
               "id INTEGER PRIMARY KEY AUTOINCREMENT," +
               "nome VARCHAR(50)," +
               "cpf VARCHAR(50)," +
               "telefone VARCHAR(50))");
}

````


## 📑 Menus do Aplicativo

menu_principal.xml: opções para cadastrar nova pessoa e pesquisar

menu_contexto.xml: opções para atualizar e excluir na lista via toque longo

## 👩‍💻 Autor

Nome: Jeferson Leon
Instituição: Senac RS
Disciplina: Desenvolvimento Mobile Android

## 📚 Licença

Projeto para fins educacionais. Sinta-se à vontade para modificar e usar mantendo os créditos.

## 🚀 Vamos codar!

"Persistência e aprendizado andam juntos, mãos à obra!"
