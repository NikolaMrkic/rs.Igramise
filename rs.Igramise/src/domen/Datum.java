package domen;

public class Datum {

	private String datumOd;
	private String datumDo;

	public Datum(String datumOd, String datumDo) {
		super();
		this.datumOd = datumOd;
		this.datumDo = datumDo;
	}

	public Datum() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the datumOd
	 */
	public String getDatumOd() {
		return datumOd;
	}

	/**
	 * @param datumOd
	 *            the datumOd to set
	 */
	public void setDatumOd(String datumOd) {
		this.datumOd = datumOd;
	}

	/**
	 * @return the datumDo
	 */
	public String getDatumDo() {
		return datumDo;
	}

	/**
	 * @param datumDo
	 *            the datumDo to set
	 */
	public void setDatumDo(String datumDo) {
		this.datumDo = datumDo;
	}

}
