/**
 * 
 */
package projeto;

import java.util.ArrayList;

/**
 * @author 40036_38298_40298_37994
 *
 */
public class GereUtilizador {
	private ArrayList<Utilizador> utilizadores;

	public GereUtilizador() {
		utilizadores = new ArrayList<Utilizador>();
	}

	public void registarUtilizador(Utilizador u) {
		if (!verificarIdUtil(u.getNumeroUtil())) {
			utilizadores.add(u);
		}
	}

	public boolean verificarIdUtil(int idUtil) {// verifica se ja existe um dado id de utilzador
		for (Utilizador u : utilizadores) {
			if (u.getNumeroUtil() == idUtil) {
				return true;
			}
		}
		return false;
	}

	public Utilizador pesquisarUtilizador(int numUtil) {// pesquisa um utilizador cujo numero e dado
		if (utilizadores.isEmpty()) {
			System.out.println("Nao existem utilizadores");
			return null;
		}
		for (Utilizador u : utilizadores) {
			if (u.getNumeroUtil() == numUtil) {
				return u;
			}
		}
		System.out.println("Nao existe esse utilizador");

		return null;
	}

	public Utilizador verificaLoginFunc(int numUtil, int password) {// verifica credenciais de login de um funcionario
		for (Utilizador u : utilizadores) {
			if (!(u instanceof Cliente)) {
				if (u.getNumeroUtil() == numUtil) {
					return u;
				}
			}
		}
		System.out.println("Nao existe esse funcionario");
		return null;
	}

	public Utilizador verificaLoginCliente(int numUtil, int password) {// verifica credenciais de login de um cliente
		for (Utilizador u : utilizadores) {
			if (u instanceof Cliente) {
				if (u.getNumeroUtil() == numUtil) {
					return u;
				}
			}
		}
		System.out.println("Nao existe esse cliente");
		return null;
	}

	public void eliminarUtilizador(int numUtil) {// elimina um utilizador cujo id e dado
		for (Utilizador u1 : utilizadores) {
			System.out.println("Utilizador [numeroUtil=" + u1.getNumeroUtil() + ", nome=" + u1.getNome() + "]");
		}

		Utilizador u = pesquisarUtilizador(numUtil);

		if (u != null) {
			utilizadores.remove(u);
			System.out.println("Utilizador eliminado com sucesso");
		}
	}

	public void imprimirTodosUtil() {// imprime todos os utilizadores
		if (utilizadores.isEmpty()) {
			System.out.println("Nao existem utilizadores");
		} else {

			for (Utilizador u : utilizadores) {
				if (u instanceof Cliente) {
					System.out.println(u.toString());
				} else {
					System.out.println(u.toString());
				}

			}
		}
	}

	public void imprimirTodosEnc() {// imprime todas as encomendas de todos os clientes
		if (utilizadores.isEmpty()) {
			System.out.println("Nao existem utilizadores");
		} else {
			for (Utilizador u : utilizadores) {
				if (u instanceof Cliente) {
					System.out.println("Encomendas");
					((Cliente) u).historicoCliente();
				}
			}
		}
	}

	public void imprimirUmUtil(int num) {// imprime um utilizador cujo numero e dado
		Utilizador u = pesquisarUtilizador(num);
		System.out.println(u.toString());
	}

	public void consultarHistoricoUm(int numUtil) { // consulta as encomendas de um utilizador cujo numero e dado
		for (Utilizador u : utilizadores) {
			if (u instanceof Cliente) {
				if (u.getNumeroUtil() == numUtil) {
					((Cliente) u).historicoCliente();
				}
			}
		}
	}

	public void consultarEstado(int id) {// consulta o estado de uma encomenda cujo id e dado
		consultarHistoricoUm(id);

		for (Utilizador u : utilizadores) {
			if (u instanceof Cliente) {
				((Cliente) u).consultarEstado(id);
			}
		}

	}

	public void realizarEncomenda(Encomenda e, int numUtil) {// realiza encomenda
		for (Utilizador u : utilizadores) {
			if (u instanceof Cliente) {
				if (u.getNumeroUtil() == numUtil) {
					((Cliente) u).registarEncomenda(e);
				}
			}
		}
	}

	public void melhorCliente() {// compara e imprime o cliente que gastou mais dinheiro
		double precoMax = 0;
		String nomeMax = "";
		int numMax = 0;

		for (Utilizador u : utilizadores) {
			if (u instanceof Cliente) {
				if (((Cliente) u).calcularTotalEncomendasCliente() > precoMax) {
					precoMax = ((Cliente) u).calcularTotalEncomendasCliente();
					nomeMax = u.getNome();
					numMax = u.getNumeroUtil();
				}
			}
		}
		System.out.println("O melhor cliente foi o " + numMax + " cujo nome e " + nomeMax + " e gastou " + precoMax);
	}

	public void melhorProd() {// imprime o produto que mais foi comprado
		Produto p = null;

		for (Utilizador u : utilizadores) {
			if (u instanceof Cliente) {
				p = ((Cliente) u).melhorProd();
			}
		}
		System.out.println("O melhor produto foi: " + p.toString());
	}

	public void registarPagamento(int idEnc) {// regista pagamento e altera estado
		imprimirTodosEnc();

		for (Utilizador u : utilizadores) {
			if (u instanceof Cliente) {
				((Cliente) u).pesquisarEncomenda(idEnc);
				((Cliente) u).alterarEstado(idEnc, 1);
			}
		}
	}
}
