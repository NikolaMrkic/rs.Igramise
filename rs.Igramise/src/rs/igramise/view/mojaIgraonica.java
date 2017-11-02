package rs.igramise.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.javafx.collections.MappingChange.Map;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import jdk.nashorn.internal.ir.JumpStatement;
import net.sf.jasperreports.charts.JRXAxisFormat;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.olap.xmla.JRXmlaHierarchyLevel;
import net.sf.jasperreports.view.JasperViewer;
import rs.igramise.baza.DBKomunikacija;
import rs.igramise.domen.Igraonica;
import rs.igramise.domen.KlasaZaINNERIgraonicaAdresaOpisKorisnik;
import rs.igramise.domen.KlasaZaINNERIgraonicaPaketDatumCena;
import rs.igramise.domen.KlasaZaINNERSlike;
import rs.igramise.kontroler.Kontroler;

import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;

import javax.imageio.ImageIO;
import javax.naming.InitialContext;
import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Button;
import javax.swing.JMenu;

public class mojaIgraonica extends JFrame {

	private static final String ImagePath = null;
	private JPanel contentPane;
	private JTextField tfZaPrikazKometara;
	private JTextField tfodTrajanjePakreka;
	private JTextField tfKojiPaketKoristi;
	private JTextField tfCenaPaketa;
	private JTextField tfPrikazOpisa;
	private JTextField tfPrikazNazivaIgraonice;
	private JTextField tfPrikazAdrese;
	private JTextField tfPrikazTel;
	private JTextField tfPrikazWeb;
	private JTextField tfPrikazOpstine;
	private JTextField tfPrikazGrada;
	private JTextField tfPrikazKontaktOsobe;
	private JTextField tfPrikazEmail;
	private JLabel lblSlikaOdIgraonice;
	private JTextField tfIdIgraonice;
	private Connection con;
	private String pic;
	String imgPath = null;
	private JTextField tfDoTrajanjePaketa;
	private JTextField tfIdPaketa;
	private JLabel lblPozadina;
	private JButton btnPdf;
	HashMap parameters;
	private JButton button_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mojaIgraonica frame = new mojaIgraonica();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @param JTextField
	 */
	public mojaIgraonica(String korisnickoIme, String lozinka) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 873, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tfZaPrikazKometara = new JTextField();
		tfZaPrikazKometara.setBounds(621, 178, 226, 43);
		contentPane.add(tfZaPrikazKometara);
		tfZaPrikazKometara.setColumns(10);

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GlavnaForma g = new GlavnaForma();
				g.setVisible(true);
				dispose();
			}
		});
		button.setIcon(new ImageIcon(mojaIgraonica.class.getResource("/images/button-arrow-left-icon.png")));
		button.setForeground(Color.RED);
		button.setFont(new Font("Tahoma", Font.BOLD, 11));
		button.setBackground(new Color(255, 255, 255));
		button.setBounds(570, 381, 52, 50);
		contentPane.add(button);

		JLabel lblOvaIgraonicaKoristi = new JLabel("Ova igraonica koristi paket :");
		lblOvaIgraonicaKoristi.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOvaIgraonicaKoristi.setForeground(Color.RED);
		lblOvaIgraonicaKoristi.setBounds(6, 352, 166, 20);
		contentPane.add(lblOvaIgraonicaKoristi);

		JLabel lblVaziDo = new JLabel("Od :");
		lblVaziDo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVaziDo.setForeground(Color.RED);
		lblVaziDo.setBackground(Color.RED);
		lblVaziDo.setBounds(271, 355, 40, 14);
		contentPane.add(lblVaziDo);

		tfodTrajanjePakreka = new JTextField();
		tfodTrajanjePakreka.setBounds(300, 352, 77, 20);
		contentPane.add(tfodTrajanjePakreka);
		tfodTrajanjePakreka.setColumns(10);

		tfKojiPaketKoristi = new JTextField();
		tfKojiPaketKoristi.setBounds(175, 352, 86, 20);
		contentPane.add(tfKojiPaketKoristi);
		tfKojiPaketKoristi.setColumns(10);

		btnPdf = new JButton("");
		btnPdf.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				try {
					FileInputStream izvestaj = new FileInputStream(new File("C:\\rs.IgramiseGitHub\\rs.Igramise\\src\\rs\\igramise\\JasperyReport\\IzvestajOdIgraonice.jasper"));
					HashMap p = new HashMap<>();
					p.put("Naziv Igraonice", tfPrikazNazivaIgraonice.getText());
					JasperReport jasperReport = (JasperReport) JRLoader.loadObject(izvestaj);
					JasperPrint jasperPrint = JasperFillManager.fillReport(izvestaj, p,DriverManager.getConnection("jdbc:mysql://localhost/igramise.rs", "root", ""));
					JasperViewer jReportViewer = new JasperViewer(jasperPrint,false);
					jReportViewer.setFitWidthZoomRatio();
					jReportViewer.setVisible(true);
					izvestaj.close();
				}catch(Exception e1) {
					e1.printStackTrace();
					}
				}
		});
		btnPdf.setIcon(new ImageIcon(mojaIgraonica.class.getResource("/images/pdf-icon.png")));
		btnPdf.setBackground(Color.WHITE);
		btnPdf.setBounds(755, 381, 52, 50);
		contentPane.add(btnPdf);

		JLabel lblIznos = new JLabel("Iznos Paketa :");
		lblIznos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIznos.setForeground(Color.RED);
		lblIznos.setBounds(82, 381, 83, 14);
		contentPane.add(lblIznos);

		tfCenaPaketa = new JTextField();
		tfCenaPaketa.setBounds(175, 378, 86, 20);
		contentPane.add(tfCenaPaketa);
		tfCenaPaketa.setColumns(10);

		JButton btnPromenaPodataka = new JButton("");
		btnPromenaPodataka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int id = Integer.parseInt(tfIdIgraonice.getText());
				int idPaketa = Integer.parseInt(tfIdPaketa.getText());
				String naziv = tfPrikazNazivaIgraonice.getText().toString();
				String kontaktosoba = tfPrikazKontaktOsobe.getText().toString();
				String email = tfPrikazEmail.getText().toString();
				String adresa = tfPrikazAdrese.getText().toString();
				String opstina = tfPrikazOpstine.getText().toString();
				String grad = tfPrikazGrada.getText().toString();
				String telefon = tfPrikazTel.getText().toString();
				String web = tfPrikazWeb.getText().toString();
				String opis = tfPrikazOpisa.getText().toString();
				String komentar = tfZaPrikazKometara.toString();
				String nazivPaketa = tfKojiPaketKoristi.getText().toString();
				String datumOd = tfodTrajanjePakreka.getText().toString();
				String datumDo = tfDoTrajanjePaketa.getText().toString();
				String cenaPaketa = tfCenaPaketa.getText().toString();

				Kontroler.getInstance().updateIgraonicu(naziv, kontaktosoba, email, telefon, web, id);
				Kontroler.getInstance().updateAdresa(adresa, opstina, grad, id);
				Kontroler.getInstance().updateOpis(opis, id);
				Kontroler.getInstance().updatePaket(nazivPaketa, id);
				Kontroler.getInstance().updateDatum(datumOd, datumDo, idPaketa);
				Kontroler.getInstance().updateCenovnik(cenaPaketa, idPaketa);

				JOptionPane.showMessageDialog(null, "Uspesno ste promenili podatke!");
			}
		});
		btnPromenaPodataka.setBounds(694, 381, 52, 50);
		contentPane.add(btnPromenaPodataka);
		btnPromenaPodataka.setIcon(new ImageIcon(mojaIgraonica.class.getResource("/images/update.png")));
		btnPromenaPodataka.setBackground(new Color(255, 255, 255));

		JLabel lblOpis = new JLabel("Opis*");
		lblOpis.setForeground(Color.RED);
		lblOpis.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOpis.setBounds(366, 230, 77, 14);
		contentPane.add(lblOpis);

		tfPrikazOpisa = new JTextField();
		tfPrikazOpisa.setColumns(10);
		tfPrikazOpisa.setBounds(366, 178, 219, 43);
		contentPane.add(tfPrikazOpisa);

		tfPrikazNazivaIgraonice = new JTextField();
		tfPrikazNazivaIgraonice.setColumns(10);
		tfPrikazNazivaIgraonice.setBounds(117, 27, 209, 29);
		contentPane.add(tfPrikazNazivaIgraonice);

		tfPrikazAdrese = new JTextField();
		tfPrikazAdrese.setColumns(10);
		tfPrikazAdrese.setBounds(117, 147, 209, 29);
		contentPane.add(tfPrikazAdrese);

		tfPrikazTel = new JTextField();
		tfPrikazTel.setColumns(10);
		tfPrikazTel.setBounds(117, 265, 209, 29);
		contentPane.add(tfPrikazTel);

		tfPrikazWeb = new JTextField();
		tfPrikazWeb.setColumns(10);
		tfPrikazWeb.setBounds(117, 305, 209, 29);
		contentPane.add(tfPrikazWeb);

		JLabel label_2 = new JLabel("Naziv :");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setForeground(new Color(255, 0, 0));
		label_2.setBounds(49, 34, 46, 14);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("Adresa :");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_3.setForeground(Color.RED);
		label_3.setBounds(38, 154, 69, 14);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("Tel :");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_4.setForeground(Color.RED);
		label_4.setBounds(49, 272, 46, 14);
		contentPane.add(label_4);

		JLabel label_5 = new JLabel("Web :");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_5.setForeground(Color.RED);
		label_5.setBounds(49, 312, 46, 14);
		contentPane.add(label_5);

		tfPrikazOpstine = new JTextField();
		tfPrikazOpstine.setColumns(10);
		tfPrikazOpstine.setBounds(117, 185, 209, 29);
		contentPane.add(tfPrikazOpstine);

		tfPrikazGrada = new JTextField();
		tfPrikazGrada.setColumns(10);
		tfPrikazGrada.setBounds(117, 225, 209, 29);
		contentPane.add(tfPrikazGrada);

		JLabel lblOpstina = new JLabel("Opstina :");
		lblOpstina.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOpstina.setForeground(Color.RED);
		lblOpstina.setBounds(38, 192, 57, 14);
		contentPane.add(lblOpstina);

		JLabel lblGrad = new JLabel("Grad :");
		lblGrad.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGrad.setForeground(Color.RED);
		lblGrad.setBounds(49, 233, 46, 14);
		contentPane.add(lblGrad);

		tfPrikazKontaktOsobe = new JTextField();
		tfPrikazKontaktOsobe.setColumns(10);
		tfPrikazKontaktOsobe.setBounds(117, 67, 209, 29);
		contentPane.add(tfPrikazKontaktOsobe);

		JLabel lblKontaktOsoba = new JLabel("Kontakt osoba :");
		lblKontaktOsoba.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblKontaktOsoba.setForeground(Color.RED);
		lblKontaktOsoba.setBounds(10, 74, 97, 14);
		contentPane.add(lblKontaktOsoba);

		tfPrikazEmail = new JTextField();
		tfPrikazEmail.setColumns(10);
		tfPrikazEmail.setBounds(117, 107, 209, 29);
		contentPane.add(tfPrikazEmail);

		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setForeground(Color.RED);
		lblEmail.setBounds(49, 114, 46, 14);
		contentPane.add(lblEmail);

		JLabel lblKomentar = new JLabel("Komenrat*");
		lblKomentar.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblKomentar.setForeground(new Color(255, 0, 0));
		lblKomentar.setBounds(621, 232, 64, 14);
		contentPane.add(lblKomentar);

		lblSlikaOdIgraonice = new JLabel("");
		lblSlikaOdIgraonice.setForeground(Color.ORANGE);
		lblSlikaOdIgraonice.setBackground(Color.ORANGE);
		lblSlikaOdIgraonice.setBounds(351, 11, 496, 142);
		contentPane.add(lblSlikaOdIgraonice);

		tfIdIgraonice = new JTextField();

		tfIdIgraonice.setBounds(22, 408, 47, 20);
		contentPane.add(tfIdIgraonice);
		tfIdIgraonice.setColumns(10);
		tfIdIgraonice.setVisible(false);

		JLabel lblDoTRrajanjePaketa = new JLabel("Do :");
		lblDoTRrajanjePaketa.setForeground(Color.RED);
		lblDoTRrajanjePaketa.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDoTRrajanjePaketa.setBackground(Color.RED);
		lblDoTRrajanjePaketa.setBounds(385, 355, 58, 14);
		contentPane.add(lblDoTRrajanjePaketa);

		tfDoTrajanjePaketa = new JTextField();
		tfDoTrajanjePaketa.setColumns(10);
		tfDoTrajanjePaketa.setBounds(415, 352, 77, 20);
		contentPane.add(tfDoTrajanjePaketa);

		tfIdPaketa = new JTextField();
		tfIdPaketa.setColumns(10);
		tfIdPaketa.setBounds(99, 408, 47, 20);
		contentPane.add(tfIdPaketa);
		tfIdPaketa.setVisible(false);

		JButton btnDelete = new JButton("");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int id = Integer.parseInt(tfIdIgraonice.getText());

				Kontroler.getInstance().deleteIgraonicu(id);
				Kontroler.getInstance().deleteKorisnika(id);
				Kontroler.getInstance().deleteAdresa(id);
				Kontroler.getInstance().deleteOpis(id);
				Kontroler.getInstance().deletePaket(id);
				int idPaketa = Integer.parseInt(tfIdPaketa.getText());
				Kontroler.getInstance().deleteDatum(idPaketa);
				Kontroler.getInstance().deleteCenovnik(idPaketa);
				JOptionPane.showMessageDialog(null, "Upsesno ste obrisali igraonicu!");
				srediFormu();

			}

			private void srediFormu() {
				tfPrikazNazivaIgraonice.setText("");
				tfPrikazKontaktOsobe.setText("");
				tfPrikazTel.setText("");
				tfPrikazEmail.setText("");
				tfPrikazWeb.setText("");
				tfPrikazAdrese.setText("");
				tfPrikazGrada.setText("");
				tfPrikazOpstine.setText("");
				tfPrikazOpisa.setText("");
				tfKojiPaketKoristi.setText("");
				tfCenaPaketa.setText("");
				tfDoTrajanjePaketa.setText("");
				tfodTrajanjePakreka.setText("");

			}
		});
		btnDelete.setIcon(new ImageIcon(mojaIgraonica.class.getResource("/images/Button-error-icon.png")));
		btnDelete.setBackground(new Color(255, 255, 255));
		btnDelete.setBounds(632, 381, 52, 50);
		contentPane.add(btnDelete);

		JLabel lblRsd = new JLabel("rsd");
		lblRsd.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRsd.setForeground(Color.RED);
		lblRsd.setBackground(Color.WHITE);
		lblRsd.setBounds(271, 381, 46, 14);
		contentPane.add(lblRsd);

		lblPozadina = new JLabel("");
		lblPozadina.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPozadina.setIcon(
				new ImageIcon(mojaIgraonica.class.getResource("/images/Screen Shot 2015-10-27 at 02.44.34.png")));
		lblPozadina.setBounds(0, 0, 857, 439);
		contentPane.add(lblPozadina);
		////////////////////////// metode koje vracaju podatke /////////////////
		upisiPodatkeIgraonicuAdresuOpis(korisnickoIme, lozinka);
		upisiPodatkeZaPaketDatumPaketaCenuPaketa(korisnickoIme, lozinka);
		

	}

	//////////////// Konstruktor koji pomogucava prikaz komponenti
	//////////////// ///////////////////////
	public mojaIgraonica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 873, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tfZaPrikazKometara = new JTextField();
		tfZaPrikazKometara.setBounds(621, 178, 226, 43);
		contentPane.add(tfZaPrikazKometara);
		tfZaPrikazKometara.setColumns(10);

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GlavnaForma g = new GlavnaForma();
				g.setVisible(true);
				dispose();
			}
		});
		button.setIcon(new ImageIcon(mojaIgraonica.class.getResource("/images/button-arrow-left-icon.png")));
		button.setForeground(Color.RED);
		button.setFont(new Font("Tahoma", Font.BOLD, 11));
		button.setBackground(new Color(255, 255, 255));
		button.setBounds(550, 378, 52, 50);
		contentPane.add(button);

		JLabel lblOvaIgraonicaKoristi = new JLabel("Ova igraonica koristi paket :");
		lblOvaIgraonicaKoristi.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOvaIgraonicaKoristi.setForeground(Color.RED);
		lblOvaIgraonicaKoristi.setBounds(6, 352, 166, 20);
		contentPane.add(lblOvaIgraonicaKoristi);

		JLabel lblVaziDo = new JLabel("Od :");
		lblVaziDo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVaziDo.setForeground(Color.RED);
		lblVaziDo.setBackground(Color.RED);
		lblVaziDo.setBounds(271, 355, 40, 14);
		contentPane.add(lblVaziDo);

		tfodTrajanjePakreka = new JTextField();
		tfodTrajanjePakreka.setBounds(300, 352, 77, 20);
		contentPane.add(tfodTrajanjePakreka);
		tfodTrajanjePakreka.setColumns(10);

		tfKojiPaketKoristi = new JTextField();
		tfKojiPaketKoristi.setBounds(175, 352, 86, 20);
		contentPane.add(tfKojiPaketKoristi);
		tfKojiPaketKoristi.setColumns(10);

		btnPdf = new JButton("");
		btnPdf.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					FileInputStream izvestaj = new FileInputStream(new File("C:\\rs.IgramiseGitHub\\rs.Igramise\\src\\rs\\igramise\\JasperyReport\\IzvestajOdIgraonice.jasper"));
					HashMap p = new HashMap<>();
					p.put("Naziv Igraonice", tfPrikazNazivaIgraonice.getText());
					JasperReport jasperReport = (JasperReport) JRLoader.loadObject(izvestaj);
					JasperPrint jasperPrint = JasperFillManager.fillReport(izvestaj, p,DriverManager.getConnection("jdbc:mysql://localhost/igramise.rs", "root", ""));
					JasperViewer jReportViewer = new JasperViewer(jasperPrint,false);
					jReportViewer.setFitWidthZoomRatio();
					jReportViewer.setVisible(true);
					izvestaj.close();
				}catch(Exception e1) {
					e1.printStackTrace();
					}
				}
		});
		btnPdf.setIcon(new ImageIcon(mojaIgraonica.class.getResource("/images/pdf-icon.png")));
		btnPdf.setBackground(Color.WHITE);
		btnPdf.setBounds(735, 378, 52, 50);
		contentPane.add(btnPdf);

		JLabel lblIznos = new JLabel("Iznos Paketa :");
		lblIznos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIznos.setForeground(Color.RED);
		lblIznos.setBounds(82, 381, 83, 14);
		contentPane.add(lblIznos);

		tfCenaPaketa = new JTextField();
		tfCenaPaketa.setBounds(175, 378, 86, 20);
		contentPane.add(tfCenaPaketa);
		tfCenaPaketa.setColumns(10);

		JButton btnPromenaPodataka = new JButton("");
		btnPromenaPodataka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int id = Integer.parseInt(tfIdIgraonice.getText());
				int idPaketa = Integer.parseInt(tfIdPaketa.getText());
				String naziv = tfPrikazNazivaIgraonice.getText().toString();
				String kontaktosoba = tfPrikazKontaktOsobe.getText().toString();
				String email = tfPrikazEmail.getText().toString();
				String adresa = tfPrikazAdrese.getText().toString();
				String opstina = tfPrikazOpstine.getText().toString();
				String grad = tfPrikazGrada.getText().toString();
				String telefon = tfPrikazTel.getText().toString();
				String web = tfPrikazWeb.getText().toString();
				String opis = tfPrikazOpisa.getText().toString();
				String komentar = tfZaPrikazKometara.toString();
				String nazivPaketa = tfKojiPaketKoristi.getText().toString();
				String datumOd = tfodTrajanjePakreka.getText().toString();
				String datumDo = tfDoTrajanjePaketa.getText().toString();
				String cenaPaketa = tfCenaPaketa.getText().toString();

				Kontroler.getInstance().updateIgraonicu(naziv, kontaktosoba, email, telefon, web, id);
				Kontroler.getInstance().updateAdresa(adresa, opstina, grad, id);
				Kontroler.getInstance().updateOpis(opis, id);
				Kontroler.getInstance().updatePaket(nazivPaketa, id);
				Kontroler.getInstance().updateDatum(datumOd, datumDo, idPaketa);
				Kontroler.getInstance().updateCenovnik(cenaPaketa, idPaketa);

				JOptionPane.showMessageDialog(null, "Uspesno ste promenili podatke!");
			}
		});
		btnPromenaPodataka.setBounds(674, 378, 52, 50);
		contentPane.add(btnPromenaPodataka);
		btnPromenaPodataka.setIcon(new ImageIcon(mojaIgraonica.class.getResource("/images/update.png")));
		btnPromenaPodataka.setBackground(new Color(255, 255, 255));

		JLabel lblOpis = new JLabel("Opis*");
		lblOpis.setForeground(Color.RED);
		lblOpis.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOpis.setBounds(366, 230, 77, 14);
		contentPane.add(lblOpis);

		tfPrikazOpisa = new JTextField();
		tfPrikazOpisa.setColumns(10);
		tfPrikazOpisa.setBounds(366, 178, 219, 43);
		contentPane.add(tfPrikazOpisa);

		tfPrikazNazivaIgraonice = new JTextField();
		tfPrikazNazivaIgraonice.setColumns(10);
		tfPrikazNazivaIgraonice.setBounds(117, 27, 209, 29);
		contentPane.add(tfPrikazNazivaIgraonice);

		tfPrikazAdrese = new JTextField();
		tfPrikazAdrese.setColumns(10);
		tfPrikazAdrese.setBounds(117, 147, 209, 29);
		contentPane.add(tfPrikazAdrese);

		tfPrikazTel = new JTextField();
		tfPrikazTel.setColumns(10);
		tfPrikazTel.setBounds(117, 265, 209, 29);
		contentPane.add(tfPrikazTel);

		tfPrikazWeb = new JTextField();
		tfPrikazWeb.setColumns(10);
		tfPrikazWeb.setBounds(117, 305, 209, 29);
		contentPane.add(tfPrikazWeb);

		JLabel label_2 = new JLabel("Naziv :");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setForeground(new Color(255, 0, 0));
		label_2.setBounds(49, 34, 46, 14);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("Adresa :");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_3.setForeground(Color.RED);
		label_3.setBounds(38, 154, 69, 14);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("Tel :");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_4.setForeground(Color.RED);
		label_4.setBounds(49, 272, 46, 14);
		contentPane.add(label_4);

		JLabel label_5 = new JLabel("Web :");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_5.setForeground(Color.RED);
		label_5.setBounds(49, 312, 46, 14);
		contentPane.add(label_5);

		tfPrikazOpstine = new JTextField();
		tfPrikazOpstine.setColumns(10);
		tfPrikazOpstine.setBounds(117, 185, 209, 29);
		contentPane.add(tfPrikazOpstine);

		tfPrikazGrada = new JTextField();
		tfPrikazGrada.setColumns(10);
		tfPrikazGrada.setBounds(117, 225, 209, 29);
		contentPane.add(tfPrikazGrada);

		JLabel lblOpstina = new JLabel("Opstina :");
		lblOpstina.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOpstina.setForeground(Color.RED);
		lblOpstina.setBounds(38, 192, 57, 14);
		contentPane.add(lblOpstina);

		JLabel lblGrad = new JLabel("Grad :");
		lblGrad.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGrad.setForeground(Color.RED);
		lblGrad.setBounds(49, 233, 46, 14);
		contentPane.add(lblGrad);

		tfPrikazKontaktOsobe = new JTextField();
		tfPrikazKontaktOsobe.setColumns(10);
		tfPrikazKontaktOsobe.setBounds(117, 67, 209, 29);
		contentPane.add(tfPrikazKontaktOsobe);

		JLabel lblKontaktOsoba = new JLabel("Kontakt osoba :");
		lblKontaktOsoba.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblKontaktOsoba.setForeground(Color.RED);
		lblKontaktOsoba.setBounds(10, 74, 97, 14);
		contentPane.add(lblKontaktOsoba);

		tfPrikazEmail = new JTextField();
		tfPrikazEmail.setColumns(10);
		tfPrikazEmail.setBounds(117, 107, 209, 29);
		contentPane.add(tfPrikazEmail);

		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setForeground(Color.RED);
		lblEmail.setBounds(49, 114, 46, 14);
		contentPane.add(lblEmail);

		JLabel lblKomentar = new JLabel("Komenrat*");
		lblKomentar.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblKomentar.setForeground(new Color(255, 0, 0));
		lblKomentar.setBounds(621, 232, 64, 14);
		contentPane.add(lblKomentar);

		lblSlikaOdIgraonice = new JLabel("");
		lblSlikaOdIgraonice.setForeground(Color.ORANGE);
		lblSlikaOdIgraonice.setBackground(Color.ORANGE);
		lblSlikaOdIgraonice.setBounds(351, 11, 496, 142);
		contentPane.add(lblSlikaOdIgraonice);

		tfIdIgraonice = new JTextField();

		tfIdIgraonice.setBounds(22, 408, 47, 20);
		contentPane.add(tfIdIgraonice);
		tfIdIgraonice.setColumns(10);
		tfIdIgraonice.setVisible(false);

		JLabel lblDoTRrajanjePaketa = new JLabel("Do :");
		lblDoTRrajanjePaketa.setForeground(Color.RED);
		lblDoTRrajanjePaketa.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDoTRrajanjePaketa.setBackground(Color.RED);
		lblDoTRrajanjePaketa.setBounds(385, 355, 58, 14);
		contentPane.add(lblDoTRrajanjePaketa);

		tfDoTrajanjePaketa = new JTextField();
		tfDoTrajanjePaketa.setColumns(10);
		tfDoTrajanjePaketa.setBounds(415, 352, 77, 20);
		contentPane.add(tfDoTrajanjePaketa);

		tfIdPaketa = new JTextField();
		tfIdPaketa.setColumns(10);
		tfIdPaketa.setBounds(99, 408, 47, 20);
		contentPane.add(tfIdPaketa);
		tfIdPaketa.setVisible(false);

		JButton btnDelete = new JButton("");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int id = Integer.parseInt(tfIdIgraonice.getText());

				Kontroler.getInstance().deleteIgraonicu(id);
				Kontroler.getInstance().deleteKorisnika(id);
				Kontroler.getInstance().deleteAdresa(id);
				Kontroler.getInstance().deleteOpis(id);
				Kontroler.getInstance().deletePaket(id);
				int idPaketa = Integer.parseInt(tfIdPaketa.getText());
				Kontroler.getInstance().deleteDatum(idPaketa);
				Kontroler.getInstance().deleteCenovnik(idPaketa);
				JOptionPane.showMessageDialog(null, "Upsesno ste obrisali igraonicu!");
				srediFormu();

			}

			private void srediFormu() {
				tfPrikazNazivaIgraonice.setText("");
				tfPrikazKontaktOsobe.setText("");
				tfPrikazTel.setText("");
				tfPrikazEmail.setText("");
				tfPrikazWeb.setText("");
				tfPrikazAdrese.setText("");
				tfPrikazGrada.setText("");
				tfPrikazOpstine.setText("");
				tfPrikazOpisa.setText("");
				tfKojiPaketKoristi.setText("");
				tfCenaPaketa.setText("");
				tfDoTrajanjePaketa.setText("");
				tfodTrajanjePakreka.setText("");

			}
		});
		btnDelete.setIcon(new ImageIcon(mojaIgraonica.class.getResource("/images/Button-error-icon.png")));
		btnDelete.setBackground(new Color(255, 255, 255));
		btnDelete.setBounds(612, 378, 52, 50);
		contentPane.add(btnDelete);

		JLabel lblRsd = new JLabel("rsd");
		lblRsd.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRsd.setForeground(Color.RED);
		lblRsd.setBackground(Color.WHITE);
		lblRsd.setBounds(271, 381, 46, 14);
		contentPane.add(lblRsd);
		
		button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(mojaIgraonica.class.getResource("/images/chat-2-icon (1).png")));
		button_1.setForeground(Color.RED);
		button_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(795, 378, 52, 50);
		contentPane.add(button_1);
		
				lblPozadina = new JLabel("");
				lblPozadina.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblPozadina.setIcon(
						new ImageIcon(mojaIgraonica.class.getResource("/images/Screen Shot 2015-10-27 at 02.44.34.png")));
				lblPozadina.setBounds(0, 0, 857, 439);
				contentPane.add(lblPozadina);
	}

	private void upisiPodatkeIgraonicuAdresuOpis(String korisnickoIme, String lozinka) {

		for (KlasaZaINNERIgraonicaAdresaOpisKorisnik k : Kontroler.getInstance()
				.upisiPodatkeIgraonicuAdresuOpis(korisnickoIme, lozinka)) {

			tfPrikazNazivaIgraonice.setText(k.getNaziv());
			tfPrikazAdrese.setText(k.getAdresa());
			tfPrikazWeb.setText(k.getWeb());
			tfPrikazTel.setText(k.getTelefon());
			tfPrikazGrada.setText(k.getGrad());
			tfPrikazKontaktOsobe.setText(k.getKontaktOsoba());
			tfPrikazOpstine.setText(k.getOstina());
			tfPrikazEmail.setText(k.getEmail());
			// tfZaPrikazKometara.setText(k.getKomentar());
			tfPrikazOpisa.setText(k.getOpisIgraonice());
			tfIdIgraonice.setText(k.getIdIgraonica());
			System.out.println("Id Igraonice je = " + tfIdIgraonice.getText());

		}
	}

	private void upisiPodatkeZaPaketDatumPaketaCenuPaketa(String korisnickoIme, String lozinka) {
		for (KlasaZaINNERIgraonicaPaketDatumCena k : Kontroler.getInstance()
				.upisiPodatkeZaPaketDatumPaketaCenuPaketa(korisnickoIme, lozinka)) {
			tfKojiPaketKoristi.setText(k.getNazivPaketa());
			tfodTrajanjePakreka.setText(k.getDatumOd());
			tfDoTrajanjePaketa.setText(k.getDatumDo());
			tfCenaPaketa.setText(k.getCenaPaketa());
			tfIdPaketa.setText(k.getIdPaket());
		}

	}
}
