package domen;

import com.mysql.jdbc.Blob;

public class Slike {
	
	private int idSlike,idIgraonice;
	private byte slika;
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
	 * @return the slika
	 */
	public byte getSlika() {
		return slika;
	}
	/**
	 * @param slika the slika to set
	 */
	public void setSlika(byte slika) {
		this.slika = slika;
	}

	
}