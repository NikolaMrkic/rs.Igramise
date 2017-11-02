package rs.igramise.domen;

public class Adresa {

	private String adresa, opstina, grad;
	private int idAdresa,idIgraonica;


	/**
	 * @return the idAdresa
	 */
	
	public Adresa() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	/**
	 * @return the idAdresa
	 */
	public int getIdAdresa() {
		return idAdresa;
	}



	/**
	 * @param idAdresa the idAdresa to set
	 */
	public void setIdAdresa(int idAdresa) {
		this.idAdresa = idAdresa;
	}



	/**
	 * @return the adresa
	 */
	public String getAdresa() {
		return adresa;
	}

	/**
	 * @param adresa
	 *            the adresa to set
	 */
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	/**
	 * @return the opstina
	 */
	public String getOpstina() {
		return opstina;
	}

	/**
	 * @param opstina
	 *            the opstina to set
	 */
	public void setOpstina(String opstina) {
		this.opstina = opstina;
	}

	/**
	 * @return the grad
	 */
	public String getGrad() {
		return grad;
	}

	/**
	 * @param grad
	 *            the grad to set
	 */
	public void setGrad(String grad) {
		this.grad = grad;
	}

}
