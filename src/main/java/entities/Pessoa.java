package entities;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class Pessoa {
    @Id
    private Long id;
    private String nome;
    private String cpf;
    private String data_nasc;
    private String login;
    private String senha;
    private Endereco endereco;
    private boolean ativo;
    
    public Pessoa(String nome, String cpf, String data_nasc, String login, String senha,
    Endereco endereco, boolean ativo) {
        this.nome = nome;
        this.cpf = cpf;
        this.data_nasc = data_nasc;
        this.login = login;
        this.senha = senha;
        this.endereco = endereco;
        this.ativo = ativo;
    }
    public boolean isAtivo() {
        return ativo;
    }
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
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
    public String getData_nasc() {
        return data_nasc;
    }
    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}
