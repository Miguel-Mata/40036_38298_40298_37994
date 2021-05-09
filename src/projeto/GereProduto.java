/**
 * 
 */
package projeto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 40036_38298_40298_37994
 *
 */
public class GereProduto {
	private ArrayList<Produto> produtos;
	Scanner input = new Scanner(System.in);

	/**
	 * @param produtos
	 */
	public GereProduto() {
		produtos = new ArrayList<Produto>();
	}

	public void registarProduto(Produto p) {
		produtos.add(p);
	}

	public Produto pesquisarProduto(double id) {

		if (produtos.isEmpty()) {
			System.out.println("Nao existem produtos");
			return null;
		}
		for (Produto p : produtos) {
			if (p.getId() == id) {
				return p;
			}
		}
		System.out.println("Nao existe esse produto");

		return null;
	}

	public void eliminarProduto(double id) {
		Produto p = pesquisarProduto(id);

		if (p != null) {
			produtos.remove(p);
		}
	}

	public void imprimirTodos() {
		if (produtos.isEmpty()) {
			System.out.println("Nao existem produtos");
		} else {
			for (Produto p : produtos) {
				System.out.println(p.toString());
			}
		}
	}

	public void imprimirUm(double id) {
		Produto p = pesquisarProduto(id);
		System.out.println(p.toString());
	}

	public void adicionarStock(double id, int quant) {
		Produto p = pesquisarProduto(id);

		if (p != null) {
			p.setStock(p.getStock() + quant);
		}
	}

	public void removerStock(double id, int quant) {
		Produto p = pesquisarProduto(id);

		if (p != null) {
			p.setStock(p.getStock() - quant);
			
			if(p.getStock()==0) {
				eliminarProduto(id);
			}
		}
	}

	public void consultarStockEspecifico(double id) {
		for(Produto p1 : produtos) {
			System.out.println("Produto [id=" + p1.getId() + ", nome=" + p1.getNome() + "]");
		}
		
		Produto p = pesquisarProduto(id);
		
		if (p != null) {
			System.out.println(p.toString());
		}
	}

	public void imprimirTodoStock() {
		if (produtos.isEmpty()) {
			System.out.println("Nao existem produtos");
		} else {
			for (Produto p : produtos) {
				System.out.println("Produto [id=" + p.getId() + ", nome=" + p.getNome() + ", stock=" + p.getStock());
			}
		}
	}

	public boolean compararStock(int idProd, int quant) {
		Produto p = pesquisarProduto(idProd);

		if (p != null) {
			if (quant > p.getStock()) {
				return false;
			}
			return true;
		}
		return false;
	}

	public void consultarPreco(double id) {
		for(Produto p1 : produtos) {
			System.out.println("Produto [id=" + p1.getId() + ", nome=" + p1.getNome() + "]");
		}
		
		Produto p = pesquisarProduto(id);

		if (p != null) {
			System.out.println("Preco do produto = " + p.getPreco());
		}
	}
	

	public void imprimirTodoPreco() {
		if (produtos.isEmpty()) {
			System.out.println("Nao existem produtos");
		} else {
			for (Produto p : produtos) {
				System.out.println("Produto [id=" + p.getId() + ", nome=" + p.getNome() + ", preco=" + p.getPreco());
			}
		}
	}
	
	public boolean produtoExpirado(LocalDate date) {		
			if(date.isBefore(LocalDate.now())) {
				System.out.println("Data invalida");
				return false;
			}
		return true;
	}

}
