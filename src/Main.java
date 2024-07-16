
public class Main {

	public static void main(String[] args) {
		try {
			Cliente ruan = new Cliente("549.740.986-59");
			ruan.setNome("Ruan Ian Aragão");

			Cliente amanda = new Cliente("431.977.853-71");
			amanda.setNome("Amanda Emanuelly Isis Assis");

			Conta contaCorrente = new ContaCorrente(ruan);
			Conta contaPoupanca = new ContaPoupanca(amanda);

			Banco banco = new Banco();
			banco.adicionarConta(contaCorrente);
			banco.adicionarConta(contaPoupanca);

			banco.adicionarCliente(ruan);
			banco.adicionarCliente(amanda);

			banco.atualizarInformacoesCliente("549.740.986-59",
					"Rua Arapaçu-vermelho, 318",
					"(43) 99117-7826",
					"ruan.ian.aragao@iname.com");
					
			banco.atualizarInformacoesCliente("431.977.853-71",
					"Rua Arapaçu-vermelho, 318",
					"(43) 99117-7826",
					"ruan.ian.aragao@iname.com");

			contaCorrente.depositar(1000);
			contaPoupanca.depositar(500);

			banco.transferir(contaCorrente.getNumero(), contaPoupanca.getNumero(), 200);

			contaCorrente.imprimirExtrato();
			contaPoupanca.imprimirExtrato();
		} catch (Exception e) {
			System.err.println("Erro: " + e.getMessage());
		}
	}

}
