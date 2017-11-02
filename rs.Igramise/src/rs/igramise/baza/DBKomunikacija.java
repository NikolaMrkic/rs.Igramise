package rs.igramise.baza;

import java.awt.font.ImageGraphicAttribute;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

import rs.igramise.domen.Igraonica;
import rs.igramise.domen.KlasaZaINNERIgraonicaAdresaOpisKorisnik;
import rs.igramise.domen.KlasaZaINNERIgraonicaPaketDatumCena;
import rs.igramise.domen.KlasaZaINNERSlike;
import rs.igramise.domen.Korisnik;
import rs.igramise.domen.KorisnikAplikacije;
import rs.igramise.domen.Paket;
import rs.igramise.domen.PonudaPaketaTabela;
import rs.igramise.kontroler.Kontroler;
import rs.igramise.view.mojaIgraonica;
import rs.igramise.view.unosIgraonice;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DBKomunikacija {

	public static DBKomunikacija broker;
	public Connection con;
	public ResultSet rs;
	public Statement st;
	public JComboBox<String> cbPaketIgraonica;

	public DBKomunikacija() {
		uvitajDrajver();

	}

	private void uvitajDrajver() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void otvoriKonekciju() {

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/igramise.rs", "root", "");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Komunikacija sa serverom nije uspela !"
					
					+ "Proverite da li je Server pokrenut!"
					);

			e.printStackTrace();
		}
	}

	public static DBKomunikacija getInstance() {
		if (broker == null) {
			broker = new DBKomunikacija();
		}
		return broker;
	}

	public void zatvoriKonekciju() {

		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//////////////// IGRAONICA /////////////////////////////
	public void upisiIgraonicu(String naziv, String kontaktOsoba, String email, String telefon, String web) {

		String sql = "INSERT INTO igraonica (naziv,kontakt_osoba,email,telefon,web) VALUES (?,?,?,?,?)";
		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, naziv);
			ps.setString(2, kontaktOsoba);
			ps.setString(3, email);
			ps.setString(4, telefon);
			ps.setString(5, web);
			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Igraonica> vratiIgraonicu() {
		ResultSet rs = null;
		java.sql.Statement st = null;
		ArrayList<Igraonica> al = new ArrayList<>();
		String upit = "SELECT id_igraonica, naziv, kontakt_osoba, email, telefon, web FROM igraonica";

		try {

			st = con.createStatement();
			rs = st.executeQuery(upit);

			while (rs.next()) {
				Igraonica id = new Igraonica();
				id.setIdIgraonica(rs.getInt("id_igraonica"));
				id.setNaziv(rs.getString("naziv"));
				id.setKontaktOsoba(rs.getString("kontakt_osoba"));
				id.setEmail(rs.getString("email"));
				id.setTelefon(rs.getString("telefon"));
				id.setWeb(rs.getString("web"));
				al.add(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, " Podaci igraonice nisu vraceni!");
		}

		return al;
	}

	/////////////////////// PAKET /////////////////////////////////

	public void upisiPaket(int idPaket, String nazivPaketa, String opisPaketa, int idIgraonica) {

		String sql = "INSERT INTO paket (id_paket,naziv_paketa,opis_paketa,id_Igraonica) VALUES (?,?,?,?)";
		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, idPaket);
			ps.setString(2, nazivPaketa);
			ps.setString(3, opisPaketa);
			ps.setInt(4, idIgraonica);
			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Paket> vratiPaket() {
		ResultSet rs = null;
		java.sql.Statement st = null;
		ArrayList<Paket> al = new ArrayList<>();
		String upit = "SELECT id_paket,naziv_paketa,opis_paketa FROM paket";
		try {

			st = con.createStatement();
			rs = st.executeQuery(upit);

			while (rs.next()) {
				Paket p = new Paket();
				p.setIdPaketa(rs.getInt("id_paket"));
				p.setNazivPaketa(rs.getString("naziv_paketa"));
				p.setOpisPaketa(rs.getString("opis_paketa"));
				al.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
	}

	///////////////////////////////////////////////////////////////
	////////////////////// KORISNIK ///////////////////////////////
	public void unesiKorisnika(int idKorisnik, String korisnickoIme, String lozinka, int idIgraonice) {

		String sql = "INSERT INTO korisnik (id_korisnik,korisnicko_ime,lozinka,id_Igraonica) VALUES (?,?,?,?)";
		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, idKorisnik);
			ps.setString(2, korisnickoIme);
			ps.setString(3, lozinka);
			ps.setInt(4, idIgraonice);
			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public ArrayList<Korisnik> vratiKorisnike() {
		ResultSet rs = null;
		java.sql.Statement st = null;
		ArrayList<Korisnik> al = new ArrayList<>();
		String upit = "SELECT id_korisnik,korisnicko_ime,lozinka,id_igraonica FROM korisnik";

		try {

			st = con.createStatement();
			rs = st.executeQuery(upit);

			while (rs.next()) {
				Korisnik id = new Korisnik();
				id.setIdKorisnik(rs.getInt("id_korisnik"));
				id.setKorisnickoIme(rs.getString("korisnicko_ime"));
				id.setLozinka(rs.getString("lozinka"));
				id.setIdIgraonica(rs.getInt("id_Igraonica"));
				al.add(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, " Podaci Korisnika !");
		}

		return al;
	}

	//////////////////////// ADRESA
	//////////////////////// //////////////////////////////////////////////////

	public void unesiAdresu(int idAdresa, String adresa, String opstina, String grad, int idIgraonica) {
		String sql = "INSERT INTO adresa(id_adresa,adresa,opstina,grad,id_Igraonica) VALUES (?,?,?,?,?)";

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, idAdresa);
			ps.setString(2, adresa);
			ps.setString(3, opstina);
			ps.setString(4, grad);
			ps.setInt(5, idIgraonica);

			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void unesiOpis(int idOpis, String opis, int idIgraonica) {
		String sql = "INSERT INTO opis (id_Opis,opis_igraonice,id_Igraonica) VALUES (?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, idOpis);
			ps.setString(2, opis);
			ps.setInt(3, idIgraonica);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void unesiSliku(int idSlike, byte slika, int idIgraonica) {

		String sql = "INSER INTO slike(id_slike,slika,id_Igraonica) VAULES (?,?,?)";

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, idSlike);
			ps.setByte(2, slika);
			ps.setInt(3, idIgraonica);
			ps.execute();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	/////////////////////// DATUM ///////////////////////

	public void unesiDatum(String datumOd, String datumDo, int idPaket) {

		String sql = "INSERT INTO datum (datum_od,datum_do,id_Paket) VALUES (?,?,?)";
		try {

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, datumOd);
			ps.setString(2, datumDo);
			ps.setInt(3, idPaket);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/////////////////////////// CENA //////////////////////////////////////

	public void unesiCenu(int ce, int idPaket) {

		String cenovnik = "INSERT INTO cenovnik (cena,id_Paket) VALUES (?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(cenovnik);
			ps.setInt(1, ce);
			ps.setInt(2, idPaket);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	//////////////////////// log in /////////////////////////////
	public void LogInProveraUbazi(JTextField tfKorisnickoIme, JTextField tfLozinka) {

		String sql = "SELECT korisnicko_ime,lozinka FROM korisnik ";

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, tfKorisnickoIme.getText());
			ps.setString(2, tfLozinka.getText());
			rs = ps.executeQuery();

			if (rs.next()) {
				JOptionPane.showMessageDialog(null, "Dobrodosli!");
				//////////
			} else {
				JOptionPane.showMessageDialog(null, "Pograsan unos KORISNICKOG IMENA ILI LOZNIKE", sql,
						JOptionPane.ERROR_MESSAGE, null);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	//////////////////////// VRATI PONUDU PAKETA //////////////

	public LinkedList<PonudaPaketaTabela> vratiPonuduPaketa() {
		ResultSet rs = null;
		java.sql.Statement st = null;
		LinkedList<PonudaPaketaTabela> pp = new LinkedList<>();

		String upit = "SELECT  Promo, Mesecni, 6_Meseci, 12_Meseci FROM cenovnikpaketa ";
		try {

			st = con.createStatement();
			rs = st.executeQuery(upit);

			while (rs.next()) {

				PonudaPaketaTabela ppt = new PonudaPaketaTabela();
				ppt.setPromo(rs.getInt("Promo"));
				ppt.setMesecni(rs.getInt("Mesecni"));
				ppt.setSestMeseci(rs.getInt("6_Meseci"));
				ppt.setDvanaestMeseci(rs.getInt("12_Meseci"));
				pp.add(ppt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pp;
	}
	////////////////////////////// INNER JOIN = Igraonica,Adresa,Opis,Korisnik
	////////////////////////////// ////////////////////////

	public ArrayList<KlasaZaINNERIgraonicaAdresaOpisKorisnik> upisiPodatkeIgraonicuAdresuOpis(String korisnickoIme,
			String lozinka) {
		ArrayList<KlasaZaINNERIgraonicaAdresaOpisKorisnik> al = new ArrayList<>();
		String upit = " SELECT i.id_Igraonica,naziv,kontakt_Osoba,email,opstina,grad,telefon,web,adresa,opis_igraonice FROM igraonica AS i INNER JOIN opis AS o ON i.id_igraonica = o.id_Opis INNER JOIN adresa AS a ON i.id_igraonica = a.id_Igraonica INNER JOIN korisnik k ON i.id_igraonica = k.id_Igraonica WHERE korisnicko_ime =? AND lozinka =?";

		try {
			PreparedStatement ps = con.prepareStatement(upit);
			ps.setString(1, korisnickoIme);
			ps.setString(2, lozinka);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				KlasaZaINNERIgraonicaAdresaOpisKorisnik k = new KlasaZaINNERIgraonicaAdresaOpisKorisnik();
				k.setNaziv(rs.getString("naziv"));
				k.setKontaktOsoba(rs.getString("kontakt_Osoba"));
				k.setEmail(rs.getString("email"));
				k.setOstina(rs.getString("opstina"));
				k.setGrad(rs.getString("grad"));
				k.setTelefon(rs.getString("telefon"));
				k.setWeb(rs.getString("web"));
				k.setAdresa(rs.getString("adresa"));
				k.setOpisIgraonice(rs.getString("opis_igraonice"));
				k.setIdIgraonica(rs.getString("id_Igraonica"));

				al.add(k);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return al;
	}
	/////////////////////////////////////////////////////////////////////////////////////////////
	//////////////// INER JOI Igraonica Paket Datum Cena

	public ArrayList<KlasaZaINNERIgraonicaPaketDatumCena> upisiPodatkeZaPaketDatumPaketaCenuPaketa(String korisnickoIme,
			String lozinka) {
		ArrayList<KlasaZaINNERIgraonicaPaketDatumCena> al = new ArrayList<>();

		String upit = "SELECT p.id_paket,i.naziv,p.naziv_paketa,d.datum_od,d.datum_do,c.cena FROM igraonica AS i INNER JOIN korisnik as k ON i.id_igraonica = k.id_Igraonica INNER JOIN paket as p ON i.id_igraonica = p.id_Igraonica INNER JOIN datum AS d ON p.id_paket = d.id_Paket INNER JOIN cenovnik AS c ON p.id_paket = c.id_Paket WHERE korisnicko_ime =? AND lozinka=?";

		try {
			PreparedStatement ps = con.prepareStatement(upit);
			ps.setString(1, korisnickoIme);
			ps.setString(2, lozinka);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				KlasaZaINNERIgraonicaPaketDatumCena k = new KlasaZaINNERIgraonicaPaketDatumCena();
				k.setNazivPaketa(rs.getString("naziv_paketa"));
				k.setDatumOd(rs.getString("datum_od"));
				k.setDatumDo(rs.getString("datum_do"));
				k.setCenaPaketa(rs.getString("cena"));
				k.setIdPaket(rs.getString("id_paket"));
				al.add(k);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return al;
	}

	/////////////////////////// UPDATE IGRAONICA ///////////////////////////////
	public void updateIgraonicu(String naziv, String kontaktosoba, String email, String telefon, String web, int id) {

		String upit = " UPDATE igraonica  SET naziv='" + naziv + "',kontakt_osoba='" + kontaktosoba + "',email='"
				+ email + "',telefon='" + telefon + "',web='" + web + "' WHERE id_igraonica = '" + id + "'";

		try {
			Statement ps = con.createStatement();

			ps.executeUpdate(upit);

			// JOptionPane.showMessageDialog(null, "Podaci o Igraonici su promenjeni!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//////////////////////////// UPDATE ADRESA ////////////////////////////////////
	public void updateAdresa(String adresa, String opstina, String grad, int id) {
		String sqlAdresa = "UPDATE adresa SET adresa ='" + adresa + "',opstina='" + opstina + "',grad='" + grad
				+ "' WHERE id_Igraonica = '" + id + "'";

		try {
			Statement s = con.createStatement();
			s.executeUpdate(sqlAdresa);

			// JOptionPane.showMessageDialog(null, "Podaci o Adresi su promenjeni!");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//////////////////////// UPDATE OPIS ////////////////////////////////////
	public void updateOpis(String opis, int id) {
		String sqlOpis = "UPDATE opis SET opis_igraonice = '" + opis + "' WHERE id_Igraonica = '" + id + "'";

		try {
			Statement s = con.createStatement();
			s.executeUpdate(sqlOpis);
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	////////////////// UPDATE PAKET ///////////////////
	public void updatePaket(String nazivPaketa, int id) {

		String sqlPaket = "UPDATE paket SET naziv = '" + nazivPaketa + "' WHERE id_paket = '" + id + "'";

		try {

			Statement s = con.createStatement();
			s.executeUpdate(sqlPaket);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/////////////////////////////////// UPDATE DATUM /////////////////////
	public void updateDatum(String datumOd, String datumDo, int idPaketa) {

		String sqlDatum = "UPDATE datum SET datum_od = '" + datumOd + "', datum_do = '" + datumDo
				+ "'WHERE id_Paket = '" + idPaketa + "'";

		try {

			Statement s = con.createStatement();
			s.executeUpdate(sqlDatum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	///////////////////////////////// UPDATE CENOVNIK /////////////////////
	public void updateCenovnik(String cenaPaketa, int idPaketa) {
		String sqlCenovnik = "UPDATE cenovnik SET cena = '" + cenaPaketa + "' WHERE id_Paket = '" + idPaketa + "'";

		try {
			Statement s = con.createStatement();
			s.executeUpdate(sqlCenovnik);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	///////////////////////// DELETE IGRAONICU ///////////////////////////
	public void deleteIgraonicu(int id) {

		String sql = "DELETE FROM igraonica WHERE id_igraonica = ?";
		System.out.println("Kod upita sam");
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			System.out.println("U brisanju sam");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	///////////////////////// DELETE ADRESU ///////////////////////////
	public void deleteAdresu(int id) {

		String sql = "DELETE FROM adresa WHERE id_igraonica = ?";
		System.out.println("kod upita");
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	///////////////////////// DELETE OPIS ///////////////////////////
	public void deleteOpis(int id) {

		String sql = "DELETE FROM opis WHERE id_igraonica =?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	///////////////////////// DELETE PAKET ///////////////////////////
	public void deletePaket(int id) {
		String sql = "DELETE FROM paket WHERE id_Igraonica = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	///////////////////////// DELETE DATUM ///////////////////////////

	public void deleteDatum(int idPaketa) {
		
		String sql = "DELETE FROM datum WHERE id_Paket = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, idPaketa);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
///////////////////////// DELETE CENOVNIK ///////////////////////////
	public void deleteCenovnik(int idPaketa) {
		String sql = "DELETE FROM cenovnik WHERE id_Paket = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, idPaketa);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
/////////////////////// DELETE KORISNIKA ///////////////////////////
	public void deleteKorisnika(int id) {
		String sql = "DELETE FROM korisnik WHERE id_Igraonica= ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e	) {
			e.printStackTrace();
		}
		
	}
///////////////////////// DELETE SLIKE ///////////////////////////
	public void deleteSlike(int id) {
	String sql = "DELETE FROM slike WHERE id_Igraonica =?";
	try {
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeQuery();
	} catch (SQLException e) {
		e.printStackTrace();
	}
		
	}
/////////////////////// DELETE ADMINA ///////////////////////////
	public ArrayList<KorisnikAplikacije> vratiKorisnikaAplikacije() {
	ResultSet rs = null;
	Statement st = null;
	ArrayList<KorisnikAplikacije>korisnik = new ArrayList<>();
	String upit = "SELECT korisnickoIme,lozinka FROM login";
	try {
		st = con.createStatement();
		rs = st.executeQuery(upit);
		
		while(rs.next()) {
			KorisnikAplikacije a = new KorisnikAplikacije();
			a.setKorisnickoIme(rs.getString("korisnickoIme"));
			a.setLozinka(rs.getString("lozinka"));
			korisnik.add(a);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return korisnik;
	}

}
