import java.time.LocalDateTime;

public class ContaPoupanca extends Conta {

	private double rendimento = 0.025;
	private LocalDateTime dataUltimoRendimento;

	public ContaPoupanca(Cliente cliente) {
		super(cliente);
		this.dataUltimoRendimento = LocalDateTime.now();
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Poupanca ===");
		super.imprimirInfosComuns();
	}

	public void renderJuros() throws Exception {
		double juros = getSaldo() * rendimento;
		depositar(juros);
		dataUltimoRendimento = LocalDateTime.now();
	}

	public double getRendimento() {
		return rendimento;
	}

	public LocalDateTime getDataUltimoRendimento() {
		return dataUltimoRendimento;
	}

}
