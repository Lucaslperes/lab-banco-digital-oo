import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import Excecoes.ValorInvalidoException;

public class Banco {

	private String nome;
	private List<Conta> contas = new ArrayList<>();
	private List<Cliente> clientes = new ArrayList<>();

	public Banco() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

	public void adicionarConta(Conta conta) {
		contas.add(conta);
	}

	public void adicionarCliente(Cliente cliente) {
		clientes.add(cliente);
	}

	public Optional<Conta> buscarConta(int numero) {
		return contas.stream().filter(c -> c.getNumero() == numero).findFirst();
	}

	public void transferir(int numeroOrigem, int numeroDestino, double valor) throws Exception {
		Optional<Conta> contaOrigem = buscarConta(numeroOrigem);
		Optional<Conta> contaDestino = buscarConta(numeroDestino);
		if (contaOrigem.isPresent() && contaDestino.isPresent()) {
			contaOrigem.get().transferir(valor, contaDestino.get());
		} else {
			throw new ValorInvalidoException("Uma das contas não foi encontrada.");
		}
	}

	public Optional<Cliente> buscarCliente(String cpf) {
		return clientes.stream()
				.filter(cliente -> cliente.getCpf().equals(cpf))
				.findFirst();
	}

	public void atualizarInformacoesCliente(String cpf, String novoEndereco, String novoTelefone, String novoEmail) {
		Optional<Cliente> cliente = buscarCliente(cpf);
		cliente.ifPresent(c -> {
			c.setEndereco(novoEndereco);
			c.setTelefone(novoTelefone);
			c.setEmail(novoEmail);
		});
	}

}
