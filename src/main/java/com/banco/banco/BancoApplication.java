package com.banco.banco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import entities.Caixa;
import entities.Cliente;
import entities.Endereco;
import entities.Funcionario;
import entities.Gerente;
import enums.Agencia;
import menus.menu_inicial;

import java.util.ArrayList;


@SpringBootApplication
public class BancoApplication {
   /*
    1-add cartao para cada cliente e uma classe para cartao com seus proprios metodos 
    2-add um tipo de calculo especifico para calcular o valor do cheque especial
    3-add HasMap para separar cada info sobre transferenciar de clientes separados 
    4-add metodos aos gerentes para calcular as coisas a partir de uma visão geral
    5-Adaptar para receber a Classe JOptionPane
    */
	public static void main(String[] args) {
      //add tabelas para gerente, caixa, historico e cliente.
		SpringApplication.run(BancoApplication.class, args);
      Endereco teste = Endereco.getEnderecoByCep("25720160");
      Caixa funcionario_base = new Caixa("Base", null, null, "adm", "adm", teste, 0, null, false, "caixa");
      Funcionario.getLista_funcionario().add(funcionario_base);
      ArrayList<Double> historico = new ArrayList<>();
      Cliente raquel = new Cliente("raquel", "121", "01/01/01", "raquel", "raquel", teste, 10000, "Corrente", "Anderson", true, historico);
      Cliente jose = new Cliente("jose", "222", "15/12/1988", "jose", "josefodao", teste, 200, "Poupança", "Anderson", true, historico);
      Gerente chefe = new Gerente("Chefe", "333", "22/11/99", "chefe", "chefe", teste, 200, null, null, Agencia.CENTRAL, true, "Gerente");
      Cliente.getLista_cliente().add(raquel);
      Cliente.getLista_cliente().add(jose);
      Gerente.getLista_funcionario().add(chefe);
      menu_inicial menu = new menu_inicial();
      menu.menus();
      
       

	}

}
// Colocar looping no menu funcionario
// Banco
// Login de Cliente
// Login de Gerente que pode incluir, alterar ou excluir funcionário
// Login de Caixa que pode incluir cliente
// Gerador de número de conta automático
// No mínimo 3 agências
// Transferências bancárias entre clientes
// Saque
// Depósito
// Extrato
// Parte 2
// Login de Gerente que pode cliente que mais movimenta
// Login de Gerente que pode liberar uma transferencia 
// que ficou pendente de aprovacao

/*
 * private static ArrayList<Funcionario> listaFuncionarios;

    incluiFunc
    editaFunc
    excluiFunc
    listaFunc
    listaFuncByIndex
 */