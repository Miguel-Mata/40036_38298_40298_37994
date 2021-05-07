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
	private LocalDateTime dataLevantamento;
	private double precoTotal;
	private String estado;
	private ArrayList<DetalhesEncomenda> detalhesE;
	
	/**
	 * @param dataLevantamento
	 * @param precoTotal
	 * @param estado
	 * @param linhasE
	 */
	
	public Encomenda(LocalDateTime dataLevantamento, double precoTotal, String estado) {
		Random random = new Random();
		idEnc += random.nextInt(10000);
		this.dataLevantamento = dataLevantamento;
		this.precoTotal = precoTotal;
		this.estado = "Recebida";
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

	@Override
	public String toString() {
		return "Encomenda [idEnc=" + idEnc + ", dataLevantamento=" + dataLevantamento + ", precoTotal=" + precoTotal
				+ ", estado=" + estado + ", detalhesE=" + detalhesE + "]";
	}
	
	
}
