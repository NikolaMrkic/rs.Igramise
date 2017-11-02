package rs.igramise.domen;

public class Korisnik {

	private String korisnickoIme, lozinka;
	private int idKorisnik,idIgraonica;
	
	public Korisnik(String korisnickoIme, String lozinka, int idKorisnik, int idIgraonica) {
		super();
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.idKorisnik = idKorisnik;
		this.idIgraonica = idIgraonica;
	}
	public Korisnik() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the korisnickoIme
	 */
	public String getKorisnickoIme() {
		return korisnickoIme;
	}
	/**
	 * @param korisnickoIme the korisnickoIme to set
	 */
	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}
	/**
	 * @return the lozinka
	 */
	public String getLozinka() {
		return lozinka;
	}
	/**
	 * @param lozinka the lozinka to set
	 */
	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	/**
	 * @return the idKorisnik
	 */
	public int getIdKorisnik() {
		return idKorisnik;
	}
	/**
	 * @param idKorisnik the idKorisnik to set
	 */
	public void setIdKorisnik(int idKorisnik) {
		this.idKorisnik = idKorisnik;
	}
	/**
	 * @return the idIgraonica
	 */
	public int getIdIgraonica() {
		return idIgraonica;
	}
	/**
	 * @param idIgraonica the idIgraonica to set
	 */
	public void setIdIgraonica(int idIgraonica) {
		this.idIgraonica = idIgraonica;
	}
	

	}