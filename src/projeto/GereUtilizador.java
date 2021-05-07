/**
 * 
 */
package projeto;

import java.util.ArrayList;

/**
 * @author migue
 *
 */
public class GereUtilizador {
	private ArrayList<Utilizador> utilizadores;

	public GereUtilizador() {
		utilizadores = new ArrayList<Utilizador>();
	}

	public void registarUtilizador(Utilizador u) {
		utilizadores.add(u);
	}

	public Utilizador pesquisarUtilizador(int numUtil){
		if(utilizadores.isEmpty()) {
			System.out.println("Nao existem utilizadores");
			return null;
		}
		for(Utilizador u: utilizadores) {
			if(u.getNumeroUtil()==numUtil) {
				return u;
			}
		}
		System.out.println("Nao existe esse utilizador");

		return null;
	}
	
	public Utilizador verificaLogin(int numUtil, int password)
	{
		for(Utilizador u: utilizadores) {
			if(u.getNumeroUtil()==numUtil) {
				return u;
			}
		}
		return null;
	}

	public void eliminarUtilizador(int numUtil) {
		Utilizador u = pesquisarUtilizador(numUtil);

		if(u!=null) {
			utilizadores.remove(u);
			System.out.println("Utilizador eliminado com sucesso");
		}
	}

	public void imprimirTodos() {
		if(utilizadores.isEmpty()) {
			System.out.println("Nao existem utilizadores");
		}
		else{
			
			for(Utilizador u: utilizadores) {
				if(u instanceof Cliente)
				{
					System.out.println("Clientes");
					System.out.println(u.toString());
				}
				else
				{
					System.out.println("Funcionarios");
					System.out.println(u.toString());
				}
				
			}
		}
	}

	public void imprimirUm(int num) {
		Utilizador u = pesquisarUtilizador(num);
		System.out.println(u.toString());
	}

	public void consultarHistorico(int numUtil) {
		for(Utilizador u: utilizadores) {
			if(u instanceof Cliente) {
				if(u.getNumeroUtil()==numUtil) {
					System.out.println(((Cliente) u).historicoCliente());
				}
			}
		}
	}
	
	public void consultarEstado(int id)
	{
		for (Utilizador u: utilizadores)
		{
			if(u instanceof Cliente)
			{
				((Cliente) u).consultarEstado(id);
			}
		}
		
	}

	public void realizarEncomenda(Encomenda e, int numUtil) {
		for(Utilizador u: utilizadores) {
			if(u instanceof Cliente) {
				if(u.getNumeroUtil()==numUtil) {
					((Cliente) u).registarEncomenda(e);
				}
			}
		}
	}
	
	public void melhorCliente()
	{
		for(Utilizador u: utilizadores)
		{
			if(u instanceof Cliente)
			{
				((Cliente) u).melhorCli();
			}
		}
	}
}
