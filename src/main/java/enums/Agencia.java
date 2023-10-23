package enums;

import entities.Funcionario;
import entities.Gerente;


public enum Agencia {
    CENTRAL("Rua do Imperador,34"),
    ITAIPAVA("Rua Gregorio,356"),
    ITAMARATY("Rua Bernardo Proença,1059");

    private String endereco;
    private Agencia(String endereco){
        this.endereco = endereco;
    }
    public String getEndereco() {
        return endereco;
    } 
    public static Agencia encontrar_agencia(String nome_gerente){
        
      for (int i = 0; i < Funcionario.getLista_funcionario().size(); i++) {
        if (nome_gerente.equalsIgnoreCase(((Gerente) Funcionario.getLista_funcionario().get(i)).getNome())) {
          
          return Funcionario.getLista_funcionario().get(i).getAgencia();
        }
      }
      return null;
    }     
}
