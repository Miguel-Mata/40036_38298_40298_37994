/**
 * 
 */
package projeto;

/**
 * @author 40036_38298_40298_37994
 *
 */
public class Utilizador 
{
	private int numeroUtil;
	private String password;
	private String nome;

	/**
	 * @param numeroUtil
	 * @param password
	 */
	public Utilizador(int numeroUtil, String password, String nome) {
		this.numeroUtil = numeroUtil;
		this.password = password;
		this.nome = nome;
	}

	/**
	 * @return the numeroUtil
	 */
	public int getNumeroUtil() {
		return numeroUtil;
	}

	@Override
	public String toString() {
		return "Utilizador [numeroUtil=" + numeroUtil + ", password=" + password + ", nome=" + nome + "]";
	}	


}
