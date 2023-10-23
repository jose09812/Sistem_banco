package interfaces;


public interface Cadastro {
    void criar();
    void atualizar();
    void excluir();
    void ver();
    void saldo();
    void deposito();
    void saque();
    void extrato(String cpf);
    void transferencia();
}
