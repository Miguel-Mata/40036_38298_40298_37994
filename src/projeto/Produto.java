/**
 * 
 */
package projeto;

import java.time.*;

/**
 * @author migue
 *
 */
public class Produto {
	private double idProd;
	private String nome;
	private double preco;
	private int stock;
	private LocalDateTime dataRegisto;
	private LocalDate dataValidade;
	private String tipo;
	private static int id = 0;

	/**
	 * @param id
	 * @param nome
	 * @param preco
	 * @param stock
	 * @param dataRegisto
	 * @param dataValidade
	 */
	public Produto(String nome, double preco, int stock, LocalDate dataValidade, String tipo) {
		idProd = this.id++;
		this.nome = nome;
		this.preco = preco;
		this.stock = stock;
		this.dataRegisto = LocalDateTime.now();;
		this.dataValidade = dataValidade;
		this.tipo = tipo;
	}



	/**
	 * @return the id
	 */
	public double getId() {
		return id;
	}


	/**
	 * @return the dataRegisto
	 */
	public LocalDateTime getDataRegisto() {
		return dataRegisto;
	}



	/**
	 * @return the stock
	 */
	public int getStock() {
		return stock;
	}



	/**
	 * @param stock the stock to set
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}


	/**
	 * @return the preco
	 */
	public double getPreco() {
		return preco;
	}



	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", preco=" + preco + ", stock=" + stock + ", dataRegisto="
				+ dataRegisto + ", dataValidade=" + dataValidade + ", tipo=" + tipo + "]";
	}





}
