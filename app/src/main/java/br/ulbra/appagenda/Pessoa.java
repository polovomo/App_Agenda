package br.ulbra.appagenda;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pessoa implements Serializable {
    private Integer id;
    private String nome;
    private String cpf;
    private String telefone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    @Override
    public String toString() {


        return nome;
    }

    public class PessoaDAO {
        private Conexao conexao;
        private SQLiteDatabase banco;
        public PessoaDAO(Context context){
            conexao = new Conexao(context);
            banco = conexao.getWritableDatabase();
        }
        //Create - C
        public long inserir(Pessoa pessoa){
            ContentValues values = new ContentValues();
            values.put("nome", pessoa.getNome());
            values.put("cpf", pessoa.getCpf());
            values.put("telefone", pessoa.getTelefone());
            return banco.insert("pessoa", null,values);
        }
        //Read - R
        public List<Pessoa> obterTodos() {
            List<Pessoa> pessoas = new ArrayList<>();
            Cursor cursor = banco.query("pessoa", new String[]{"id", "nome", "cpf", "telefone"},
                    null, null, null, null, null);
            while (cursor.moveToNext()) {
                Pessoa p = new Pessoa();
                p.setId(cursor.getInt(0));
                p.setNome(cursor.getString(1));
                p.setCpf(cursor.getString(2));
                p.setTelefone(cursor.getString(3));
                pessoas.add(p);
            }
            return pessoas;
        }


        //Update - U
        public void atualizar(Pessoa pessoa){
            ContentValues values = new ContentValues();
            values.put("nome", pessoa.getNome());
            values.put("cpf", pessoa.getCpf());
            values.put("telefone", pessoa.getTelefone());
            banco.update("pessoa", values, "id = ?",new String[]{pessoa.getId().toString()});
        }
    }
}
