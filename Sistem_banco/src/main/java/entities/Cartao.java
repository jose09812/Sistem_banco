package entities;
import java.io.DataInput;

import interfaces.Cadastro;
import lombok.Data;

@Data

public class Cartao implements Cadastro{
    private String numero;
    private String nome;
    private int cvv;
    private DataInput data_validade;
    private int senha;
    private double limite_cartao;
    private String tipo_cartao;
    private boolean status_cartao;
    /*
     1- implementar os metodos 
     2- cada cliente tem sua propria lista de cartoes 
     */
    @Override
    public void criar() {
        //add metodo para criar cartao usando numeros aleatorios 
        //uma data de 10 anos para expirar a validade
        //criar um calculo para dizer os limites das pessoas 

    }
    @Override
    public void atualizar() {
        //metodo para atualizar/trocar o cartao ou trocar a senha dele
    }
    @Override
    public void excluir() {
        // Excluir cartao
    }
    @Override
    public void ver() {
        // ver todas infos do cartao como limite nome numero  cvv e data de validade
    }
    @Override
    public void saldo() {
        //mostrar o limite que ainda pode ser gasto no cartao 
     }
    @Override
    public void deposito() {
        // Aumentar o limite do cartao
    }
    @Override
    public void saque() {
        // metodo responsavel pela compra
    }
    @Override
    public void extrato(String cpf) {
        // mostrar historico de compras
    }
    @Override
    public void transferencia() {
        // TODO Auto-generated method stub
        System.out.println("metodo não retorna nada!");
    }
    public double calculo_limite(){
        System.out.println("metodo reponsavel por calcular o limite");
        return 20.00;
    }


}
