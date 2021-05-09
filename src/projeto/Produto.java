/**
 * 
 */
package projeto;

import java.time.*;

/**
 * @author 40036_38298_40298_37994
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
	private static int id = 1;

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
		this.dataRegisto = LocalDateTime.now();
		this.dataValidade = dataValidade;
		this.tipo = tipo;
		// this.contadorVendas = contadorVendas;
	}

	/**
	 * @return the id
	 */
	public double getId() {
		return idProd;
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

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @return the dataValidade
	 */
	public LocalDate getDataValidade() {
		return dataValidade;
	}

	@Override
	public String toString() {
		return "Produto [idProd=" + idProd + ", nome=" + nome + ", preco=" + preco + ", stock=" + stock
				+ ", dataRegisto=" + dataRegisto + ", dataValidade=" + dataValidade + ", tipo=" + tipo + "]";
	}

}
