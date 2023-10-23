package entities;

import java.time.LocalDate;
import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Extrato_geral")
public class Extrato {
    
    private LocalDate data;
    private String nome;
    private String cpf;
    private double valor;
    private static ArrayList<Extrato> extrato_geral = new ArrayList<>();

    public Extrato(String nome, String cpf, double valor, LocalDate data){
        this.nome = nome;
        this.cpf = cpf;
        this.valor = valor;
        this.data = data;
    }

    public static ArrayList<Extrato> getExtrato_geral(){
        return extrato_geral;
    }    
    public static void setExtrato_geral(String nome, String cpf, double valor, LocalDate data){
        Extrato novo = new Extrato(nome,cpf,valor,data);
        extrato_geral.add(novo);
    }
}
