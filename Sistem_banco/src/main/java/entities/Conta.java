package entities;

import java.util.ArrayList;
import java.util.Random;
import enums.Agencia;
import lombok.Data;

@Data
public class Conta {
    
    private String numero;
    private ArrayList<Conta> lista_conta = new ArrayList<>();
    //pedir socorro para algume porque o gerador ta funcionando porem só gera conta com numero 0.09873
    //o erro provavelmente esta na hora onde eu  chamo 
    public Conta(String numero) {
        this.numero = numero;
    }

    public Conta gerar_conta(String cpf, Agencia agencia) {
        String numero_conta = "0";
        Random random = new Random();
        if (agencia.equals(Agencia.CENTRAL)) {
           String num_fix = "6608";
            int numero_aleatorio = 0;

            numero_aleatorio = random.nextInt();
            numero_conta = String.valueOf(num_fix + 000 + numero_aleatorio) ;
            while (getLista_conta().contains(numero_conta)) {
                numero_aleatorio = random.nextInt();
                // numero_conta = String.valueOf(num_fix);// + 000 + numero_aleatorio);
                String teste1 = String.valueOf(numero_aleatorio);
                numero_conta = num_fix + "000" + teste1;
            }
            Conta conta = new Conta(numero_conta);
            return  conta;

        } else if (agencia.equals(Agencia.ITAIPAVA)) {
            String num_fix = "6609";
            int contador = 0;
            for (int i = 0; i < getLista_conta().size(); i++) {
                contador = i + 1;
            }
            Conta conta = new Conta(numero_conta = String.valueOf(num_fix + contador));
            return  conta;
        } else if (agencia.equals(Agencia.ITAMARATY)) {
            String num_fix = "6610";
            int contador = 0;
            for (int i = 0; i < getLista_conta().size(); i++) {
                contador = i + 1;
            }
            Conta conta = new Conta(numero_conta = String.valueOf(num_fix + contador));
            return  conta;
        }

            return null;
    }
}
