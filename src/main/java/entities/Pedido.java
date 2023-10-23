package entities;

import java.sql.Date;

import lombok.Data;


@Data
public class Pedido {
    private Date data;
    private String nome;
    private String numero_conta;
    private double valor;
    private boolean status = false;
  
   public Pedido(Date data,String nome,String numero_conta, double valor, boolean status){
        this.data = data;
        this.nome = nome;
        this.numero_conta = numero_conta;
        this.valor = valor;
        this.status = status;
   }
   
}
