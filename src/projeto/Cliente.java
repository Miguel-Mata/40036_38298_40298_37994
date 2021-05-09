/**
 * 
 */
package projeto;

import java.util.ArrayList;

/**
 * @author 40036_38298_40298_37994
 *
 */
public class Cliente extends Utilizador {
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

	public Encomenda pesquisarEncomenda(int idEnc) {
		if (encomendas.isEmpty()) {
			System.out.println("Nao existem encomendas");
			return null;
			
		}
		for (Encomenda e : encomendas) {
			if (e.getIdEnc() == idEnc) {
				return e;
			}
		}
		System.out.println("Nao existe essa encomenda");

		return null;
	}

	public void alterarEstado(int idEnc, int tipo) {
		for (Encomenda e : encomendas) {
			if (e.getIdEnc() == idEnc) {
				if (tipo == 1) // Quando regista pagamento
				{
					e.setEstado("Paga");
				} else // Quando chega dia de entrega
				{
					e.setEstado("Pronta");
				}
			}
		}
	}

	public void consultarEstado(int idEnc) {
		Encomenda e = pesquisarEncomenda(idEnc);

		if (e != null) {
			System.out.println(e.getEstado());
		}
	}

	public void historicoCliente() {
		for (Encomenda e : encomendas) {
			System.out.println(e);
		}
	}

	public double calcularTotalEncomendasCliente() {
		double soma = 0;

		for (Encomenda e : encomendas) {
			soma += e.precoTotal();
		}
		return soma;
	}
	
	public Produto melhorProd() {
		Produto p = null;
		
		for(Encomenda e: encomendas) {
			p = e.melhorProd();
		}
		return p;
	}

	@Override
	public String toString() {
		return "Cliente [" + super.toString() + "]";
	}

}
