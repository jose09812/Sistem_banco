package enums;

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
}
