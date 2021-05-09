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
		if(!verificarIdUtil(u.getNumeroUtil())) {
			utilizadores.add(u);
		}
	}
	
	public boolean verificarIdUtil(int idUtil) {
		for(Utilizador u: utilizadores) {
			if(u.getNumeroUtil()==idUtil) {
				return true;
			}
		}
		return false;
	}

	public Utilizador pesquisarUtilizador(int numUtil) {
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

	public Utilizador verificaLoginFunc(int numUtil, int password) {
		for (Utilizador u : utilizadores) {
			if(!(u instanceof Cliente)) {
				if (u.getNumeroUtil() == numUtil) {
					return u;
				}
			}
		}
		System.out.println("Nao existe esse funcionario");
		return null;
	}
	
	public Utilizador verificaLoginCliente(int numUtil, int password) {
		for (Utilizador u : utilizadores) {
			if(u instanceof Cliente) {
				if (u.getNumeroUtil() == numUtil) {
					return u;
				}
			}
		}
		System.out.println("Nao existe esse cliente");
		return null;
	}

	public void eliminarUtilizador(int numUtil) {
		for(Utilizador u1 : utilizadores) {
			System.out.println("Utilizador [numeroUtil=" + u1.getNumeroUtil() + ", nome=" + u1.getNome() + "]");
		}
		
		Utilizador u = pesquisarUtilizador(numUtil);

		if (u != null) {
			utilizadores.remove(u);
			System.out.println("Utilizador eliminado com sucesso");
		}
	}

	public void imprimirTodosUtil() {
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

	public void imprimirTodosEnc() {
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

	public void imprimirUmUtil(int num) {
		Utilizador u = pesquisarUtilizador(num);
		System.out.println(u.toString());
	}

	public void consultarHistoricoUm(int numUtil) {	
		for (Utilizador u : utilizadores) {
			if (u instanceof Cliente) {
				if (u.getNumeroUtil() == numUtil) {
					((Cliente) u).historicoCliente();
				}
			}
		}
	}

	public void consultarEstado(int id) {
		consultarHistoricoUm(id);
		
		for (Utilizador u : utilizadores) {
			if (u instanceof Cliente) {
				((Cliente) u).consultarEstado(id);
			}
		}

	}

	public void realizarEncomenda(Encomenda e, int numUtil) {
		for (Utilizador u : utilizadores) {
			if (u instanceof Cliente) {
				if (u.getNumeroUtil() == numUtil) {
					((Cliente) u).registarEncomenda(e);
				}
			}
		}
	}

	public void melhorCliente() {
		double precoMax = 0;
		String nomeMax = "";
		int numMax = 0;
		
		for (Utilizador u : utilizadores) {
			if (u instanceof Cliente) {
				if(((Cliente) u).calcularTotalEncomendasCliente()>precoMax) {
					precoMax = ((Cliente) u).calcularTotalEncomendasCliente();
					nomeMax = u.getNome();
					numMax = u.getNumeroUtil();
				}
			}
		}
		System.out.println("O melhor cliente foi o " + numMax + " cujo nome e " + nomeMax + " e gastou " + precoMax);
	}

	public void melhorProd() {
		Produto p = null;
		
		for(Utilizador u: utilizadores) {
			if(u instanceof Cliente) {
				p = ((Cliente) u).melhorProd();
			}
		}
		System.out.println("O melhor produto foi: " + p.toString());
	}
	
	public void registarPagamento(int idEnc) {
		imprimirTodosEnc();
		
		for (Utilizador u : utilizadores) {
			if (u instanceof Cliente) {
				((Cliente) u).pesquisarEncomenda(idEnc);
				((Cliente) u).alterarEstado(idEnc, 1);
			}
		}
	}
}
