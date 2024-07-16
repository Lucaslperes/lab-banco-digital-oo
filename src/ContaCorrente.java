import Excecoes.SaldoInsuficienteException;

public class ContaCorrente extends Conta {

	private double taxaDeOperacao = 0.1;
	private double limiteChequeEspecial = 450.0;

	public ContaCorrente(Cliente cliente) {
		super(cliente);
	}
	
	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Corrente ===");
		super.imprimirInfosComuns();
	}

	@Override
	public void sacar(double valor) throws Exception {
		double valorComTaxa = valor + taxaDeOperacao;
		if (getSaldo() + limiteChequeEspecial < valorComTaxa) {
			throw new SaldoInsuficienteException("Saldo insuficiente, incluindo limite de cheque especial.");
		}
		super.sacar(valorComTaxa);
	}

	@Override
	public void transferir(double valor, IConta contaDestino) throws Exception {
		double valorComTaxa = valor + taxaDeOperacao;
		sacar(valorComTaxa);
		contaDestino.depositar(valor);
	}



}
