/**
 * 
 */
package projeto;

import java.time.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author 40036_38298_40298_37994
 *
 */
public class Encomenda {
	private int idEnc;
	private LocalDate dataLevantamento;
	private String estado;
	private ArrayList<DetalhesEncomenda> detalhesE;
	private static int id = 1;

	/**
	 * @param dataLevantamento
	 * @param precoTotal
	 * @param estado
	 * @param linhasE
	 */

	public Encomenda(LocalDate dataLevantamento) {
		idEnc = this.id++;
		this.dataLevantamento = dataLevantamento;
		this.estado = "Validada";
		detalhesE = new ArrayList<DetalhesEncomenda>();
	}

	public void registarDetalhes(DetalhesEncomenda d) {
		detalhesE.add(d);
	}

	/**
	 * @return the idEnc
	 */
	public int getIdEnc() {
		return idEnc;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public double precoTotal() {// calcula e devolve o preco total de uma encomenda
		double var = 0;
		for (DetalhesEncomenda d : detalhesE) {
			var += d.calcularPrecoTotal();
		}
		return var;
	}

	public Produto melhorProd() {// devolve o produto mais vendido de uma encomenda
		int max = 0;
		Produto p = null;

		for (DetalhesEncomenda d : detalhesE) {
			if (d.melhorProd() > max) {
				max = d.melhorProd();
				p = d.getProduto();
			}
		}
		return p;
	}

	/**
	 * @return the detalhesE
	 */
	public ArrayList<DetalhesEncomenda> getDetalhesE() {
		return detalhesE;
	}

	@Override
	public String toString() {
		return "Encomenda [idEnc=" + idEnc + ", dataLevantamento=" + dataLevantamento + ", precoTotal="
				+ this.precoTotal() + ", estado=" + estado + ", detalhesE=" + detalhesE + "]";
	}

}
