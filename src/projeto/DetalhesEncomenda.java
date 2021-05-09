/**
 * 
 */
package projeto;

/**
 * @author 40036_38298_40298_37994
 *
 */
public class DetalhesEncomenda {
	private Produto produto;
	private int quantidade;

	/**
	 * @param produto
	 * @param quantidade
	 */
	public DetalhesEncomenda(Produto produto, int quantidade) {
		this.produto = produto;
		this.quantidade = quantidade;
	}
	
	public int melhorProd() {
		return this.quantidade;
	}

	/**
	 * @return the produto
	 */
	public Produto getProduto() {
		return produto;
	}

	public double calcularPrecoTotal() {
		return this.produto.getPreco() * this.quantidade;
	}

	@Override
	public String toString() {
		return "DetalhesEncomenda [produto=" + produto.getNome() + ", quantidade=" + quantidade + "]";
	}
	
}
