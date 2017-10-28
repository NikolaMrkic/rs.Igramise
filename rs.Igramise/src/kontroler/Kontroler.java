package kontroler;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

import forme.unosIgraonice;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import baza.DBKomunikacija;
import domen.PonudaPaketaTabela;
import domen.Admin;
import domen.Igraonica;
import domen.KlasaZaINNERIgraonicaAdresaOpisKorisnik;
import domen.KlasaZaINNERIgraonicaPaketDatumCena;
import domen.KlasaZaINNERSlike;
import domen.Korisnik;
import domen.Paket;

public class Kontroler {
	Connection con;
	public static Kontroler instance;
	ArrayList<Igraonica> i = new ArrayList<>();
	ArrayList<Korisnik> k = new ArrayList<>();
	ArrayList<Paket> p = new ArrayList<>();
	LinkedList<PonudaPaketaTabela> pp = new LinkedList<>();
	ArrayList<KlasaZaINNERIgraonicaAdresaOpisKorisnik> al = new ArrayList<>();
	ArrayList<KlasaZaINNERSlike> arrayZaSlike = new ArrayList<>();
	ArrayList<KlasaZaINNERIgraonicaPaketDatumCena> arrayZaPaketNazivCenuDatum = new ArrayList<>();
	ArrayList<Admin>arrayAdmin = new ArrayList<>();

	public static Kontroler getInstance() {

		if (instance == null) {

			instance = new Kontroler();
		}

		return instance;
	}

	////////// IGRAONICA //////
	public void posaljiNazivIgraonice(String naziv, String kontaktOsoba, String email, String telefon, String web) {

		DBKomunikacija.getInstance().otvoriKonekciju();
		DBKomunikacija.getInstance().upisiIgraonicu(naziv, kontaktOsoba, email, telefon, web);
		DBKomunikacija.getInstance().zatvoriKonekciju();
	}

	public ArrayList<Igraonica> vratiIgraonicu() {
		DBKomunikacija.getInstance().otvoriKonekciju();
		i = DBKomunikacija.getInstance().vratiIgraonicu();
		DBKomunikacija.getInstance().zatvoriKonekciju();
		return i;
	}

	// Korisnik
	public ArrayList<Korisnik> vratiKorisnike() {
		DBKomunikacija.getInstance().otvoriKonekciju();
		k = DBKomunikacija.getInstance().vratiKorisnike();
		DBKomunikacija.getInstance().zatvoriKonekciju();
		return k;
	}

	//////// PAKET //////

	public ArrayList<Paket> vratiPaket() {
		DBKomunikacija.getInstance().otvoriKonekciju();
		p = DBKomunikacija.getInstance().vratiPaket();
		DBKomunikacija.getInstance().zatvoriKonekciju();
		return p;
	}

	public void unesiPaket(int idPaket, String nazivPaketa, String opisPaketa, int idIgraonica) {

		DBKomunikacija.getInstance().otvoriKonekciju();
		DBKomunikacija.getInstance().upisiPaket(idPaket, nazivPaketa, opisPaketa, idIgraonica);
		DBKomunikacija.getInstance().zatvoriKonekciju();

	}

	////////////////////////////
	///////// KORISNIK//////////////

	public void unesiKorisnika(int idKorisnik, String korisnickoIme, String lozinka, int idIgraonica) {
		DBKomunikacija.getInstance().otvoriKonekciju();
		DBKomunikacija.getInstance().unesiKorisnika(idKorisnik, korisnickoIme, lozinka, idIgraonica);
		DBKomunikacija.getInstance().zatvoriKonekciju();

	}

	public void unesiAdresu(int idAdresa, String adresa, String opstina, String grad, int idIgraonica) {
		DBKomunikacija.getInstance().otvoriKonekciju();
		DBKomunikacija.getInstance().unesiAdresu(idAdresa, adresa, opstina, grad, idIgraonica);
		DBKomunikacija.getInstance().zatvoriKonekciju();

	}

	public void unesiOpis(int idOpis, String opis, int idIgraonica) {
		DBKomunikacija.getInstance().otvoriKonekciju();
		DBKomunikacija.getInstance().unesiOpis(idOpis, opis, idIgraonica);
		DBKomunikacija.getInstance().zatvoriKonekciju();
	}

	public void unesiSliku(int idSlike, byte slika, int idIgraonica) {
		DBKomunikacija.getInstance().otvoriKonekciju();
		DBKomunikacija.getInstance().unesiSliku(idSlike, slika, idIgraonica);
		DBKomunikacija.getInstance().zatvoriKonekciju();
	}

	public void unesiDatum(String datumOd, String datumDo, int idPaket) {
		DBKomunikacija.getInstance().otvoriKonekciju();
		DBKomunikacija.getInstance().unesiDatum(datumOd, datumDo, idPaket);
		DBKomunikacija.getInstance().zatvoriKonekciju();
	}

	public void unesiCenu(int ce, int idPaket) {
		DBKomunikacija.getInstance().otvoriKonekciju();
		DBKomunikacija.getInstance().unesiCenu(ce, idPaket);
		DBKomunikacija.getInstance().zatvoriKonekciju();

	}

	public void LogInProveraUbazi(JTextField KorisnickoIme, JTextField Lozinka) {
		DBKomunikacija.getInstance().otvoriKonekciju();
		DBKomunikacija.getInstance().LogInProveraUbazi(KorisnickoIme, Lozinka);
		DBKomunikacija.getInstance().zatvoriKonekciju();
	}

	public void uneciDatumICenu(String datumOd, String datumDo, int idPaket) {
		// TODO Auto-generated method stub
		DBKomunikacija.getInstance().otvoriKonekciju();
		DBKomunikacija.getInstance().unesiDatum(datumOd, datumDo, idPaket);
		DBKomunikacija.getInstance().zatvoriKonekciju();
	}

	///////////////////////// CENOVNIK PAKETA TABELA ////////////////////

	public LinkedList<PonudaPaketaTabela> vratiPonuduPaketa() {
		DBKomunikacija.getInstance().otvoriKonekciju();
		pp = DBKomunikacija.getInstance().vratiPonuduPaketa();
		DBKomunikacija.getInstance().zatvoriKonekciju();
		return pp;
	}

	/////////////////////////// INNER JOIN adresa korisnik igraonica ///////////////

	public ArrayList<KlasaZaINNERIgraonicaAdresaOpisKorisnik> upisiPodatkeIgraonicuAdresuOpis(String korisnickoIme,
			String lozinka) {
		DBKomunikacija.getInstance().otvoriKonekciju();
		al = DBKomunikacija.getInstance().upisiPodatkeIgraonicuAdresuOpis(korisnickoIme, lozinka);
		DBKomunikacija.getInstance().zatvoriKonekciju();
		return al;
	}
	///////////////////////////////////////////////////////////////////////////////

	//////////////////////// INER JOIN igraonica paket datum cenvnik ///////////////

	public ArrayList<KlasaZaINNERIgraonicaPaketDatumCena> upisiPodatkeZaPaketDatumPaketaCenuPaketa(String korisnickoIme,
			String lozinka) {
		DBKomunikacija.getInstance().otvoriKonekciju();
		arrayZaPaketNazivCenuDatum = DBKomunikacija.getInstance()
				.upisiPodatkeZaPaketDatumPaketaCenuPaketa(korisnickoIme, lozinka);
		DBKomunikacija.getInstance().zatvoriKonekciju();
		return arrayZaPaketNazivCenuDatum;
	}

	////////////////////// UPDATE IGRAONICA
	////////////////////// /////////////////////////////////////////////
	public void updateIgraonicu(String naziv, String kontaktosoba, String email, String telefon, String web, int id) {
		DBKomunikacija.getInstance().otvoriKonekciju();
		DBKomunikacija.getInstance().updateIgraonicu(naziv, kontaktosoba, email, telefon, web, id);
		DBKomunikacija.getInstance().zatvoriKonekciju();

	}

	////////////////////// UPDATE ADRESA ///////////////////
	public void updateAdresa(String adresa, String opstina, String grad, int id) {
		DBKomunikacija.getInstance().otvoriKonekciju();
		DBKomunikacija.getInstance().updateAdresa(adresa, opstina, grad, id);
		DBKomunikacija.getInstance().zatvoriKonekciju();

	}

	////////////////////// UPDATE OPIS ////////////////////
	public void updateOpis(String opis, int id) {
		DBKomunikacija.getInstance().otvoriKonekciju();
		DBKomunikacija.getInstance().updateOpis(opis, id);
		DBKomunikacija.getInstance().zatvoriKonekciju();

	}

	//////////////////////// UPDATE PAKET /////////////////
	public void updatePaket(String nazivPaketa, int id) {
		DBKomunikacija.getInstance().otvoriKonekciju();
		DBKomunikacija.getInstance().updatePaket(nazivPaketa, id);
		DBKomunikacija.getInstance().zatvoriKonekciju();

	}

	//////////////////////// UPDATE DATUM //////////////////
	public void updateDatum(String datumOd, String datumDo, int idPaketa) {
		DBKomunikacija.getInstance().otvoriKonekciju();
		DBKomunikacija.getInstance().updateDatum(datumOd, datumDo, idPaketa);
		DBKomunikacija.getInstance().zatvoriKonekciju();

	}

	/////////////////////// UPDATE CENOVNIK //////////////////////
	public void updateCenovnik(String cenaPaketa, int idPaketa) {
		DBKomunikacija.getInstance().otvoriKonekciju();
		DBKomunikacija.getInstance().updateCenovnik(cenaPaketa, idPaketa);
		DBKomunikacija.getInstance().zatvoriKonekciju();

	}

	///////////////////////// DELETE IGRAONICU ///////////////////////////
	public void deleteIgraonicu(int id) {
		DBKomunikacija.getInstance().otvoriKonekciju();
		DBKomunikacija.getInstance().deleteIgraonicu(id);
		DBKomunikacija.getInstance().zatvoriKonekciju();

	}

	///////////////////////// DELETE ADRESA ///////////////////////////
	public void deleteAdresa(int id) {
		DBKomunikacija.getInstance().otvoriKonekciju();
		DBKomunikacija.getInstance().deleteAdresu(id);
		DBKomunikacija.getInstance().zatvoriKonekciju();
	}

	///////////////////////// DELETE OPIS ///////////////////////////
	public void deleteOpis(int id) {
		DBKomunikacija.getInstance().otvoriKonekciju();
		DBKomunikacija.getInstance().deleteOpis(id);
		DBKomunikacija.getInstance().zatvoriKonekciju();

	}

	///////////////////////// DELETE PAKET ///////////////////////////
	public void deletePaket(int id) {
		DBKomunikacija.getInstance().otvoriKonekciju();
		DBKomunikacija.getInstance().deletePaket(id);
		DBKomunikacija.getInstance().zatvoriKonekciju();

	}
	///////////////////////// DELETE DATUM ///////////////////////////
	public void deleteDatum(int idPaketa) {
		DBKomunikacija.getInstance().otvoriKonekciju();
		DBKomunikacija.getInstance().deleteDatum(idPaketa);
		DBKomunikacija.getInstance().zatvoriKonekciju();

	}
	///////////////////////// DELETE CENOVNIK ///////////////////////////

	public void deleteCenovnik(int idPaketa) {
		DBKomunikacija.getInstance().otvoriKonekciju();
		DBKomunikacija.getInstance().deleteCenovnik(idPaketa);
		DBKomunikacija.getInstance().zatvoriKonekciju();
	}
///////////////////////// DELETE KORISNIKA ///////////////////////////

	public void deleteKorisnika(int id) {
			DBKomunikacija.getInstance().otvoriKonekciju();
			DBKomunikacija.getInstance().deleteKorisnika(id);
			DBKomunikacija.getInstance().zatvoriKonekciju();
	}

	public void deleteSlike(int id) {
	DBKomunikacija.getInstance().otvoriKonekciju();
	DBKomunikacija.getInstance().deleteSlike(id);
	DBKomunikacija.getInstance().zatvoriKonekciju();
		
	}

	public ArrayList<Admin> vratiAdmina() {
		DBKomunikacija.getInstance().otvoriKonekciju();
		arrayAdmin= DBKomunikacija.getInstance().vratiAdmina();
		DBKomunikacija.getInstance().zatvoriKonekciju();
		return arrayAdmin;
	}

}
