package menus;

import java.util.ArrayList;
import java.util.Scanner;

import entities.*;

public class menu_inicial {
    Scanner sc = new Scanner(System.in);
    Scanner scint = new Scanner(System.in);
    
    public void menus() {
        int resposta = 0;
        while (resposta !=2) {
            System.out.println("digite 1 para iniciar ou 2 para sairr");
            resposta = scint.nextInt();
            String login_digitado, senha_digitada;
            System.out.println("Seja bem-vindo!");
            System.out.println("Digite Login:");
            login_digitado = sc.nextLine();
            System.out.println("digite sua senha: ");
            senha_digitada = sc.nextLine();
            System.out.println();
            String tipo_menu = login(login_digitado, senha_digitada, Funcionario.getLista_funcionario(),
                    Cliente.getLista_cliente());
    
            switch (tipo_menu) {
                case "cliente":
                    this.menu_cliente(login_digitado, senha_digitada);
                    break;
                case "gerente":
                    this.menu_gerente(login_digitado, senha_digitada); // so falta esse
                    break;
                case "caixa":
                    this.menu_caixa(login_digitado, senha_digitada);
                    break;
                default:
                    System.out.println("Erro!!!");
                    break;
            }
        }
    }

    public void menu_cliente(String login, String senha) {
        for (int i = 0; i < Cliente.getLista_cliente().size(); i++) {
            if (login.equals(Cliente.getLista_cliente().get(i).getLogin())) {
                int escolha = 0;
                while (escolha != 7) {
                    System.out.println(
                            "\n1.Ver saldo\n2.Depositar\n3.Sacar\n4.Transferir\n5.Extrato\n6.Para verficar suas informações\n7.Para sair");
                    escolha = sc.nextInt();
                    switch (escolha) {
                        case 1:
                            Cliente.getLista_cliente().get(i).saldo();

                            break;
                        case 2:
                            Cliente.getLista_cliente().get(i).deposito();
                            break;
                        case 3:
                            Cliente.getLista_cliente().get(i).saque();
                            break;
                        case 4:
                            Cliente.getLista_cliente().get(i).transferencia();
                            break;
                        case 5:
                            String cpf = Cliente.getLista_cliente().get(i).getCpf();
                            Cliente.getLista_cliente().get(i).extrato(cpf);
                            break;
                        case 6:
                            Cliente.getLista_cliente().get(i).ver();
                            break;
                        case 7:
                            System.out.println("Até Mais");
                            break;
                        default:
                            System.out.println("Opção inválida");

                    }
                }
                break;
            }
        }
    }

    public void menu_gerente(String login, String senha) {
        // gerente exclui,acrescenta, atualiza cadastro,ver lista// add loop menu
        // 09.10.2023
        int escolha = 0;
        for (int j = 0; j < Funcionario.getLista_funcionario().size(); j++) {
            if (login.equals(Funcionario.getLista_funcionario().get(j).getLogin())) {
                while (escolha != 11) {
                    System.out.println(
                            "1.Ver lista de funcionarios\n2.Ver lista de clientes\n3.Ver informações do Cliente\n4.Cadastrar cliente\n5.Cadastrar funcionario\n6.Atualizar cadastro cliente\n7.Atualizar cadastro funcionario\n8.Para excluir um cliente\n9.Para exluir um funcionario\n10.Para o extrato do cliente\n11.Para sair");

                    escolha = sc.nextInt();

                    switch (escolha) {
                        case 1:
                            ((Gerente) Funcionario.getLista_funcionario().get(j)).ver_lista_func();// perguntar arthur
                            break;
                        case 2:
                            ((Gerente) Funcionario.getLista_funcionario().get(j)).ver_lista_cliente();
                            break;
                        case 3:
                            ((Gerente) Funcionario.getLista_funcionario().get(j)).ver();
                            break;
                        case 4:
                            ((Gerente) Funcionario.getLista_funcionario().get(j)).criar();
                            break;
                        case 5:
                            ((Gerente) Funcionario.getLista_funcionario().get(j)).criar_funcionario();
                            break;
                        case 6:
                            ((Gerente) Funcionario.getLista_funcionario().get(j)).atualizar();
                            break;
                        case 7:
                            ((Gerente) Funcionario.getLista_funcionario().get(j)).atualizar_funcionario();
                            break;
                        case 8:
                            ((Gerente) Funcionario.getLista_funcionario().get(j)).excluir();
                            ;
                            break;
                        case 9:
                            ((Gerente) Funcionario.getLista_funcionario().get(j)).excluir_funcionario();
                            break;
                        case 10:
                            ((Gerente) Funcionario.getLista_funcionario().get(j)).extrato("");
                            break;
                        case 11:
                            System.out.println("Até mais");
                            break;
                        default:
                            System.out.println("Opção Inválida");
                            break;
                    }
                }
            }
        }

    }

    public void menu_caixa(String login, String senha) {
        // gerente exclui,acrescenta, atualiza cadastro,ver lista
        int escolha = 0;
        for (int j = 0; j < Funcionario.getLista_funcionario().size(); j++) {
            if (login.equals(Funcionario.getLista_funcionario().get(j).getLogin())) {

                while (escolha !=5) {
                    System.out.println("\n1.Criar cliente\n2.Atualizar cadastro do cliente\n3.Realizar Depósito\n4.Ver informações do cliente\n5.Para sair.");// 3.Consultar
                                                                                                                        // saldo\n4.Realizar
                    // deposito\n5.Sacar
                    escolha = sc.nextInt();
                    
                    switch (escolha) {
                        case 1:
                            Funcionario.getLista_funcionario().get(j).criar();
                            break;
                        case 2:
                            Funcionario.getLista_funcionario().get(j).atualizar();
                            break;
                        case 3:
                            Funcionario.getLista_funcionario().get(j).deposito();
                            break;
                        case 4:
                            Funcionario.getLista_funcionario().get(j).ver();
                            break;
                            case 5:
                            System.out.println("Até mais");
                            break;
                        default:
                            System.out.println("Opção Inválida");
                            break;
                    }
                }

            }
        }

    }

    public String login(String username, String senha, ArrayList<Funcionario> lista_funcionario,
            ArrayList<Cliente> lista_cliente) {
        for (int i = 0; i < Funcionario.getLista_funcionario().size(); i++) {
            if (username.equalsIgnoreCase(Funcionario.getLista_funcionario().get(i).getLogin())
                    && senha.equalsIgnoreCase(Funcionario.getLista_funcionario().get(i).getSenha())) {
                if (Funcionario.getLista_funcionario().get(i).getCargo().equalsIgnoreCase("gerente")) {
                    return "gerente";
                } else if (Funcionario.getLista_funcionario().get(i).getCargo().equalsIgnoreCase("caixa")) {
                    return "caixa";
                }
            }
        }
        for (int i = 0; i < Cliente.getLista_cliente().size(); i++) {
            if (username.equalsIgnoreCase(Cliente.getLista_cliente().get(i).getLogin())
                    && senha.equals(Cliente.getLista_cliente().get(i).getSenha())) {
                return "cliente";
            }
        }
        return "Não cadastrado";
    }
}
