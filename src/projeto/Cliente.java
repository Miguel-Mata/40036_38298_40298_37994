/**
 * 
 */
package projeto;

import java.util.ArrayList;

/**
 * @author migue
 *
 */
public class Cliente extends Utilizador{
	private ArrayList<Encomenda> encomendas;

	/**
	 * @param numeroUtil
	 * @param password
	 * @param nome
	 * @param encomendas
	 */
	public Cliente(int numeroUtil, String password, String nome) {
		super(numeroUtil, password, nome);
		encomendas = new ArrayList<Encomenda>();
	}

	public void registarEncomenda(Encomenda e) {
		encomendas.add(e);
	}

	public Encomenda pesquisarEncomenda(int idEnc){
		if(encomendas.isEmpty()) {
			System.out.println("Nao existem encomendas");
			return null;
		}
		for(Encomenda e: encomendas) {
			if(e.getIdEnc()==idEnc) {
				return e;
			}
		}
		System.out.println("Nao existe essa encomenda");

		return null;
	}

	public void alterarEstado() {
		//TODO fazer
	}

	public void consultarEstado(int idEnc) {
		Encomenda e = pesquisarEncomenda(idEnc);

		if(e!=null) {
			System.out.println(e.getEstado());
		}
	}

	public Encomenda historicoCliente() {
		for(Encomenda e: encomendas) {
			return e;
		}
		return null;
	}
	
	public void melhorCli()
	{
		double max = 0;
		
		for(Encomenda e: encomendas)
		{
			if(e.precoTotal()>max)
			{
				max = e.precoTotal();
			}
		}
	}

	@Override
	public String toString() {
		return "Cliente [toString()=" + super.toString() + "]";
	}
		

}
