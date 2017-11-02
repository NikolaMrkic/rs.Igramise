package rs.igramise.domen;

import com.mysql.jdbc.Blob;

public class Slike {
	
	private int idSlike,idIgraonice;
	private String logoIgraonice;
	/**
	 * @return the idSlike
	 */
	public int getIdSlike() {
		return idSlike;
	}
	/**
	 * @param idSlike the idSlike to set
	 */
	public void setIdSlike(int idSlike) {
		this.idSlike = idSlike;
	}
	/**
	 * @return the idIgraonice
	 */
	public int getIdIgraonice() {
		return idIgraonice;
	}
	/**
	 * @param idIgraonice the idIgraonice to set
	 */
	public void setIdIgraonice(int idIgraonice) {
		this.idIgraonice = idIgraonice;
	}
	/**
	 * @return the logoIgraonice
	 */
	public String getLogoIgraonice() {
		return logoIgraonice;
	}
	/**
	 * @param logoIgraonice the logoIgraonice to set
	 */
	public void setLogoIgraonice(String logoIgraonice) {
		this.logoIgraonice = logoIgraonice;
	}
	
}