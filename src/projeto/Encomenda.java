/**
 * 
 */
package projeto;


import java.time.*;
import java.util.ArrayList;
import java.util.Random;
/**
 * @author migue
 *
 */
public class Encomenda {
	private int idEnc;
	private LocalDate dataLevantamento;
	private String estado;
	private ArrayList<DetalhesEncomenda> detalhesE;
	private static int id = 0;

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

	public double precoTotal()
	{
		double var = 0;
		for(DetalhesEncomenda d: detalhesE)
		{
			var += d.calcularPrecoTotal();
		}
		return var;
	}

	@Override
	public String toString() {
		return "Encomenda [idEnc=" + idEnc + ", dataLevantamento=" + dataLevantamento + ", precoTotal=" + this.precoTotal()
		+ ", estado=" + estado + ", detalhesE=" + detalhesE + "]";
	}


}
