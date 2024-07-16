
public interface IConta {
	
	void sacar(double valor) throws Exception;
	
	void depositar(double valor) throws Exception;
	
	void transferir(double valor, IConta contaDestino) throws Exception;
	
	void imprimirExtrato();
}
