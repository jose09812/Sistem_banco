package entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import enums.Agencia;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class Gerente extends Funcionario {

    private String departamento;
    private HashMap<Agencia,ArrayList<Pedido>>lista_pedido = new HashMap<>();
    Scanner sc = new Scanner(System.in);
    Scanner sc2 = new Scanner(System.in);

    public Gerente(String nome, String cpf, String data_nasc, String login, String senha,
            Endereco endereco, double salario, String cpts, String departamento, boolean ativo,
            String cargo, Agencia agencia) {
        super(nome, cpf, data_nasc, login, senha, endereco, salario, ativo, cargo, agencia);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public void criar() {
        for (int i = 0; i < getLista_funcionario().size(); i++) {
            if (this.getCpf().equals(getLista_funcionario().get(i).getCpf())) {
                Funcionario.getLista_funcionario().get(i).criar();
            }
        }

        String nome, cpf, data_nac, login, senha, tipo_conta, gerente,complemento,cep;
        double saldo;
        int numero;
        ArrayList<Double> historico = new ArrayList<>();
        boolean ativo = true;
        System.out.println("Digite o nome: ");
        nome = sc.nextLine();
        System.out.println("cpf: ");
        cpf = sc.nextLine();
        System.out.println("data:");
        data_nac = sc.nextLine();
        System.out.println("login:");
        login = sc.nextLine();
        System.out.println("senha: ");
        senha = sc.nextLine();
        saldo = 0;
        System.out.println("tipo de conta:");
        tipo_conta = sc.nextLine();
        System.out.println("gerente");
        gerente = sc.nextLine();
  
        System.out.println("CEP:");
        cep = sc.nextLine();
        Endereco teste = Endereco.getEnderecoByCep(cep);
        System.out.println("Número");     
        numero = sc2.nextInt(); 
        teste.setNumero(numero);
        System.out.println("Complemento:");
        complemento = sc.nextLine();
        teste.setComplemento(complemento);;
        Agencia agencia = Agencia.encontrar_agencia(gerente);
        Conta conta = new Conta("0");
        Conta nova_Conta = conta.gerar_conta("121",agencia);
        Cliente cliente = new Cliente(nome, cpf, data_nac, login, senha, teste, saldo, tipo_conta, gerente, ativo,
                historico,agencia,nova_Conta);
        Cliente.getLista_cliente().add(cliente);
    }

    @Override
    public void atualizar() {
        String cpf;
        System.out.println("CPF do cliente: ");
        cpf = sc.nextLine();
        for (int i = 0; i < Cliente.getLista_cliente().size(); i++) {
            if (cpf.equals(Cliente.getLista_cliente().get(i).getCpf())) {
                int escolha = 0;
                while (escolha != 1 || escolha != 2) {
                    System.out.println("1.Para mudar dados do cliente\n2.Para mudar dados do endereço do cliente");
                    escolha = sc.nextInt();
                }
                if (escolha == 1) {
                    String[] opcoes = { "Nome", "CPF", "Data de nascimento", "Login", "Senha", "Tipo Conta",
                            "Gerente" };
                    for (int j = 0; j < opcoes.length; j++) {
                        System.out.println(opcoes[j] + "\n");
                    }
                    String mudança = sc.nextLine().toLowerCase();
                    switch (mudança) {
                        case "nome":
                            System.out.println("Qual o nome desejado?");
                            String nome = sc.nextLine();
                            Cliente.getLista_cliente().get(i).setNome(nome);
                            break;
                        case "cpf":
                            System.out.println("Qual o CPF desejado?");
                            String cpf1 = sc.nextLine();
                            Cliente.getLista_cliente().get(i).setCpf(cpf1);
                            break;
                        case "data de nascimento":
                            System.out.println("Qual a data desejado?");
                            String data = sc.nextLine();
                            Cliente.getLista_cliente().get(i).setData_nasc(data);
                            break;
                        case "login":
                            System.out.println("Qual o Login desejado?");
                            String login = sc.nextLine();
                            Cliente.getLista_cliente().get(i).setLogin(login);
                            break;
                        case "senha":
                            System.out.println("Qual a senha desejada?");
                            String senha = sc.nextLine();
                            Cliente.getLista_cliente().get(i).setSenha(senha);
                            break;
                        case "tipo conta":
                            System.out.println("Qual o tipo desejado?");
                            String tipo = sc.nextLine();
                            Cliente.getLista_cliente().get(i).setTipoConta(tipo);
                            break;
                        case "gerente":
                            System.out.println("Qual o gerente?");
                            String gerente = sc.nextLine();
                            Cliente.getLista_cliente().get(i).setGerente(gerente);
                            break;
                        default:
                            System.out.println("Opção Inválida");
                            break;
                    }
                    break;
                } else if (escolha == 2) {
                    String[] opcoes = { "Bairro", "Rua", "Número", "Complemento", "Cidade", "CEP", "UF" };
                    for (int j = 0; j < opcoes.length; j++) {
                        System.out.println(opcoes[j] + "\n");
                    }
                    String mudança = sc.nextLine().toLowerCase();
                    switch (mudança) {
                        case "bairro":
                            System.out.println("Qual o bairro desejado?");
                            String bairro = sc.nextLine();
                            Cliente.getLista_cliente().get(i).getEndereco().setBairro(bairro);
                            break;
                        case "rua":
                            System.out.println("Qual a rua desejada?");
                            String rua = sc.nextLine();
                            Cliente.getLista_cliente().get(i).getEndereco().setLogradouro(rua);
                            ;
                            break;
                        case "numero":
                            System.out.println("Qual o numero desejado?");
                            sc.next();
                            int numero = sc.nextInt();
                            sc.next();
                            Cliente.getLista_cliente().get(i).getEndereco().setNumero(numero);
                            break;
                        case "complemento":
                            System.out.println("Qual o complemento desejado?");
                            String comp = sc.nextLine();
                            Cliente.getLista_cliente().get(i).getEndereco().setComplemento(comp);
                            break;
                        case "cidade":
                            System.out.println("Qual a cidade desejada?");
                            String cidade = sc.nextLine();
                            Cliente.getLista_cliente().get(i).getEndereco().setLocalidade(cidade);
                            break;
                        case "cep":
                            System.out.println("Qual o CEP desejado?");
                            String cep = sc.nextLine();
                            Cliente.getLista_cliente().get(i).getEndereco().setCep(cep);
                            ;
                            break;
                        case "uf":
                            System.out.println("Qual a UF?");
                            String uf1 = sc.nextLine().toUpperCase();
                            Cliente.getLista_cliente().get(i).getEndereco().setUf(uf1);
                            break;
                        default:
                            System.out.println("Opção Inválida");
                            break;
                    }
                } else {
                    System.out.println("Opção Inválida");
                }
            }
        }
    }

    @Override
    public void excluir() {

        String cpf_digitado;
        System.out.println("Digite o nome da pessoa que deseja excluir");
        cpf_digitado = sc.nextLine();
        for (int i = 0; i < Cliente.getLista_cliente().size(); i++) {
            if (cpf_digitado.equalsIgnoreCase(Cliente.getLista_cliente().get(i).getCpf())) {
                // add metodo para inativar o cliente
                Cliente.getLista_cliente().get(i).setAtivo(false);

            }

        }
    }

    @Override
    public void ver() {

        String cpf_digitado;
        System.out.println("Digite o CPF do cliente que você deseja acessar as informações:");
        cpf_digitado = sc.nextLine();
        for (int i = 0; i < Cliente.getLista_cliente().size(); i++) {
            if (cpf_digitado.equalsIgnoreCase(Cliente.getLista_cliente().get(i).getCpf())) {
                // verificar como vai ficar as infos quando chamar esse metodo.
                System.out.println(Cliente.getLista_cliente().get(i).getNome());
                System.out.println(Cliente.getLista_cliente().get(i).getData_nasc());
                System.out.println(Cliente.getLista_cliente().get(i).getCpf());
                System.out.println(Cliente.getLista_cliente().get(i).getEndereco());
                System.out.println(Cliente.getLista_cliente().get(i).getTipoConta());
                System.out.println(Cliente.getLista_cliente().get(i).getGerente());
                System.out.println(Cliente.getLista_cliente().get(i).getSaldo());
                System.out.println(Cliente.getLista_cliente().get(i).getAgencia());

            }

        }
    }

    @Override
    public void saldo() {
        System.out.println("Qual o CPF que deseja ver?");
        String cpf = sc.nextLine();

        for (int i = 0; i < Cliente.getLista_cliente().size(); i++) {
            if (cpf.equals(Cliente.getLista_cliente().get(i).getCpf())) {
                System.out.println("R$:" + Cliente.getLista_cliente().get(i).getSaldo());
            }
        }
    }

    @Override
    public void extrato(String cpf) {
        int contador = 0;

        System.out.println("Qual o CPF que deseja ver?");
        String cpf1 = sc.nextLine();

        // for (int i = 0; i < Cliente.getLista_cliente().size(); i++) {
        //     if (cpf.equals(Cliente.getLista_cliente().get(i).getCpf())) {
        //         if (Cliente.getLista_cliente().get(i).getHistorico().size() > 0) {
        //             for (int j = 0; j < Cliente.getLista_cliente().get(i).getHistorico().size(); j++) {
        //                 System.out.println("R$" + Cliente.getLista_cliente().get(i).getHistorico().get(j));
        //             }
        //         } else {
        //             System.out.println("Sem operações ainda");
        //         }
        //         break;
        //     }
        // }
        for (int i = 0; i < Extrato.getExtrato_geral().size(); i++) {
            if (cpf1.equals(Extrato.getExtrato_geral().get(i).getCpf())) {
                System.out.println(Extrato.getExtrato_geral().get(i).getData()+" R$:"+ Extrato.getExtrato_geral().get(i).getValor() );
                contador += 1;
            }
            
        }
        if (contador == 0){
            System.out.println("\nSem operações");
        }
    }

    @Override
    public void deposito() {
        double valor;
        String cpf;
        System.out.println("Para qual cpf você deseja depositar? ");
        cpf = sc.nextLine();
        System.out.println("Digite o valor: ");

        valor = sc2.nextDouble(); // fazer um try catch
        for (int i = 0; i < Cliente.getLista_cliente().size(); i++) {
            if (cpf.equals(Cliente.getLista_cliente().get(i).getCpf())) {
                Cliente.getLista_cliente().get(i).setSaldo((Cliente.getLista_cliente().get(i).getSaldo()) + valor);
                Cliente.getLista_cliente().get(i).setHistorico(valor);
                System.out.println("\nDeposito realizado com sucesso:");
                return;
            } 
        }
        System.out.println("\nConta inexistente.");
    }



    @Override
    public void saque() {
        System.out.println("Qual o CPF que deseja ver?");
        String cpf = sc.nextLine();
        System.out.println("Valor a sacar R$:");
        double valor = sc2.nextDouble();

        for (int i = 0; i < Cliente.getLista_cliente().size(); i++) {
            if (Cliente.getLista_cliente().get(i).getCpf().equals(cpf)) {
                if (Cliente.getLista_cliente().get(i).getSaldo() > valor) {
                    Cliente.getLista_cliente().get(i).setSaldo(Cliente.getLista_cliente().get(i).getSaldo() - valor);
                    Cliente.getLista_cliente().get(i).setHistorico(-valor);
                } else {
                    System.out.println("Saldo insuficiente");
                }
            }
        }
    }

    @Override
    public void transferencia() {
        System.out.println("Qual o CPF que deseja mandar a transferencia?");
        String cpf = sc.nextLine();
        System.out.println("Qual o CPF que deseja receber a transferencia?");
        String cpf2 = sc.nextLine();

        for (int i = 0; i < Cliente.getLista_cliente().size(); i++) {
            if (Cliente.getLista_cliente().get(i).getCpf().equals(cpf)) {
                for (int j = 0; j < Cliente.getLista_cliente().size(); j++) {
                    if (Cliente.getLista_cliente().get(j).getCpf().equals(cpf2)) {
                        System.out.println("R$:");
                        double valor = sc2.nextDouble();
                        if (Cliente.getLista_cliente().get(i).getSaldo() > valor) {
                            Cliente.getLista_cliente().get(i)
                                    .setSaldo(Cliente.getLista_cliente().get(i).getSaldo() - valor);
                            Cliente.getLista_cliente().get(i).setHistorico(-valor);
                            Cliente.getLista_cliente().get(j)
                                    .setSaldo(Cliente.getLista_cliente().get(j).getSaldo() + valor);
                            Cliente.getLista_cliente().get(j).setHistorico(+valor);
                            System.out.println("Transferencia Concluida");
                            return;
                        }
                    }
                }
            } else {
                System.out.println("CPF não consta nos registros");
            }
        }
    }

    public void criar_funcionario() {
        // nome,cpf,data_nasc,login,senha,Endereco endereco,double salario, String ctps,
        // boolean ativo,cargo

        String nome, cpf, data_nasc, login, senha1, senha2, senha = "", cargo,gerente_cadastro;
        String  cep, complemento;
        double salario;
        int numero;
        System.out.println("Digite o nome do funcionario:");
        nome = sc.nextLine();
        System.out.println("Digite o cpf:");
        cpf = sc.nextLine();
        System.out.println("Digite a data de nascimento:");
        data_nasc = sc.nextLine();
        System.out.println("Digite o login:");
        login = sc.nextLine();
        System.out.println("Digite uma senha:");
        senha1 = sc.nextLine();
        System.out.println("Digite a senha novamente: ");
        senha2 = sc.nextLine();
        if (senha1.equals(senha2)) {
            senha = sc.nextLine();
        } else {
            System.out.println("Senha invalida");
        }
        System.out.println("Digite o cargo do funcionario: ");
        cargo = sc.nextLine();
        System.out.println("Digite o salario do funcionario: ");
        sc.next();
        salario = sc.nextDouble();
        // rua bairro numero cidade complemente cep uf
        System.out.println("Digite o CEP: ");
        cep = sc.nextLine();
        Endereco endereco = Endereco.getEnderecoByCep(cep);
        System.out.println("Digite o numero");
        numero = sc2.nextInt();       
        endereco.setNumero(numero);
        System.out.println("Digite o complemento");
        complemento = sc.nextLine();
        endereco.setComplemento(complemento);
        System.out.println("Digite o nome do responsavel pelo cadastro do funcionario:");
        gerente_cadastro = sc.nextLine();
        Agencia agencia = Agencia.encontrar_agencia(gerente_cadastro);
        
        
        if (cargo.equalsIgnoreCase("gerente")) {
            Gerente gerente = new Gerente(nome, cpf, data_nasc, login, senha, endereco, salario, cpf, cep,
                    isAtivo(), cargo,agencia);
            Funcionario.getLista_funcionario().add(gerente);
            lista_pedido.put(agencia,new ArrayList<>());
            System.out.println("Operação realizada com sucesso");
        } else {
            Caixa caixa = new Caixa(nome, cpf, data_nasc, login, senha, endereco, salario, cpf, isAtivo(), cargo,agencia);
            Funcionario.getLista_funcionario().add(caixa);
            System.out.println("Operação realizada com sucesso");
        }
    }

    // metodo excluir atualizar funcionario
    public void excluir_funcionario() {
        System.out.println("Qual o CPF que deseja modificar?");
        String cpf = sc.nextLine();

        for (int i = 0; i < Funcionario.getLista_funcionario().size(); i++) {
            if (Funcionario.getLista_funcionario().get(i).getCpf().equals(cpf)) {
                Funcionario.getLista_funcionario().get(i).setAtivo(false);
                break;
            }
        }
    }

    public void atualizar_funcionario() {
        // atualizar todas infos do funcionario

        // nome,cpf,data_nascimento,login,senha,cargo
        // bairro,rua,numero,complemento,cidade,cep,Localidade
        String cpf;
        System.out.println("CPF do cliente: ");
        cpf = sc.nextLine();
        for (int i = 0; i < Funcionario.getLista_funcionario().size(); i++) {
            if (cpf.equals(Funcionario.getLista_funcionario().get(i).getCpf())) {
                int escolha = 0;
                while (escolha != 1 || escolha != 2) {
                    System.out.println(
                            "1.Para mudar dados do funcionario\n2.Para mudar dados do endereço do funcionario");
                    escolha = sc.nextInt();
                }
                if (escolha == 1) {
                    String[] opcoes = { "Nome", "CPF", "Data de nascimento", "Login", "Senha", "Cargo",
                            "Gerente" };
                    for (int j = 0; j < opcoes.length; j++) {
                        System.out.println(opcoes[j] + "\n");
                    }
                    String mudança = sc.nextLine().toLowerCase();
                    switch (mudança) {
                        case "nome":
                            System.out.println("Qual o nome desejado?");
                            String nome = sc.nextLine();
                            Funcionario.getLista_funcionario().get(i).setNome(nome);
                            break;
                        case "cpf":
                            System.out.println("Qual o CPF desejado?");
                            String cpf1 = sc.nextLine();
                            Funcionario.getLista_funcionario().get(i).setCpf(cpf1);
                            break;
                        case "data de nascimento":
                            System.out.println("Qual a data desejado?");
                            String data = sc.nextLine();
                            Funcionario.getLista_funcionario().get(i).setData_nasc(data);
                            break;
                        case "login":
                            System.out.println("Qual o Login desejado?");
                            String login = sc.nextLine();
                            Funcionario.getLista_funcionario().get(i).setLogin(login);
                            break;
                        case "senha":
                            System.out.println("Qual a senha desejada?");
                            String senha = sc.nextLine();
                            Funcionario.getLista_funcionario().get(i).setSenha(senha);
                            break;
                        case "tipo conta":
                            System.out.println("Qual o tipo desejado?");
                            String cargo = sc.nextLine();
                            Funcionario.getLista_funcionario().get(i).setCargo(cargo);
                            break;
                        default:
                            System.out.println("Opção Inválida");
                            break;
                    }
                    break;
                } else if (escolha == 2) {
                    String[] opcoes = { "Bairro", "Rua", "Número", "Complemento", "Cidade", "CEP", "UF" };
                    for (int j = 0; j < opcoes.length; j++) {
                        System.out.println(opcoes[j] + "\n");
                    }
                    String mudança = sc.nextLine().toLowerCase();
                    switch (mudança) {
                        case "bairro":
                            System.out.println("Qual o bairro desejado?");
                            String bairro = sc.nextLine();
                            Funcionario.getLista_funcionario().get(i).getEndereco().setBairro(bairro);
                            break;
                        case "rua":
                            System.out.println("Qual a rua desejada?");
                            String rua = sc.nextLine();
                            Funcionario.getLista_funcionario().get(i).getEndereco().setLogradouro(rua);
                            ;
                            break;
                        case "numero":
                            System.out.println("Qual o numero desejado?");
                            sc.next();
                            int numero = sc.nextInt();
                            sc.next();
                            Funcionario.getLista_funcionario().get(i).getEndereco().setNumero(numero);
                            break;
                        case "complemento":
                            System.out.println("Qual o complemento desejado?");
                            String comp = sc.nextLine();
                            Funcionario.getLista_funcionario().get(i).getEndereco().setComplemento(comp);
                            break;
                        case "cidade":
                            System.out.println("Qual a cidade desejada?");
                            String cidade = sc.nextLine();
                            Funcionario.getLista_funcionario().get(i).getEndereco().setLocalidade(cidade);
                            break;
                        case "cep":
                            System.out.println("Qual o CEP desejado?");
                            String cep = sc.nextLine();
                            Funcionario.getLista_funcionario().get(i).getEndereco().setCep(cep);
                            ;
                            break;
                        case "uf":
                            System.out.println("Qual a UF?");
                            String uf1 = sc.nextLine().toUpperCase();
                            Funcionario.getLista_funcionario().get(i).getEndereco().setUf(uf1);
                            break;
                        default:
                            System.out.println("Opção Inválida");
                            break;
                    }
                } else {
                    System.out.println("Opção Inválida");
                }
            }
        }

    }

    public void ver_lista_func() {
        for (int i = 0; i < Funcionario.getLista_funcionario().size(); i++) {
            if (Funcionario.getLista_funcionario().get(i).isAtivo()){
                    System.out.println(Funcionario.getLista_funcionario().get(i).getNome() + " "
                    + Funcionario.getLista_funcionario().get(i).getCargo());
                }
        }
    }

    public void ver_lista_cliente() {
        for (int i = 0; i < Cliente.getLista_cliente().size(); i++) {
            
            if (Cliente.getLista_cliente().get(i).isAtivo()){
                System.out.println(Cliente.getLista_cliente().get(i).getNome());
            }
        }
    }
    public void movimentacao(){
        //mudar somente a logica quando implementar o HashMap
        System.out.println("digite cpf:");
        String cpf = sc.nextLine();
        double soma = 0;
        for (int i = 0; i < Extrato.getExtrato_geral().size(); i++) {
            if (cpf.equals(Extrato.getExtrato_geral().get(i).getCpf())) {
                soma += Extrato.getExtrato_geral().get(i).getValor();
            }
        }
        System.out.println(soma);

    }
}
