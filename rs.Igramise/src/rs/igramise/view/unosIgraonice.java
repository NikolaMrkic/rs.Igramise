package rs.igramise.view;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import rs.igramise.controller.Kontroler;
import rs.igramise.dao.DBKomunikacija;
import rs.igramise.model.Igraonica;
import rs.igramise.view.DodajSliku;

import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Label;
import java.awt.Button;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.awt.SystemColor;

public class unosIgraonice extends JFrame {

	private JPanel contentPane;
	private JTextField tfUnosNazivaIgraonice;
	private JTextField tfUnosKontaktOsobe;
	private JTextField tfUnosEmail;
	private JTextField tfUnosTel1;
	private JTextField tfUnosWeb;
	private JTextField tfKorisnickoIme;
	private JTextField tfLozinka;
	private JTextField tfUnosAdrese;
	private JTextField tfUnosOpstine;
	private JTextField tfUnosGrada;
	private JTextField tfUnosOpisa;
	private JComboBox cbIdIgraonice;
	private ArrayList<Igraonica> al = new ArrayList<>();
	private int idAdresa, idKorisnik, idIgraonica, idOpis;
	private JLabel lblZaOdabirSlike;
	private String imgPath1 = null;

	private Connection con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					unosIgraonice frame = new unosIgraonice();

					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public unosIgraonice() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 874, 459);
		contentPane = new JPanel();
		contentPane.setForeground(Color.RED);
		contentPane.setBorder(UIManager.getBorder("DesktopIcon.border"));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelIgraonica = new JPanel();
		panelIgraonica.setBackground(new Color(176, 224, 230));
		panelIgraonica.setBorder(UIManager.getBorder("DesktopIcon.border"));
		panelIgraonica.setBounds(10, 32, 334, 169);
		contentPane.add(panelIgraonica);
		panelIgraonica.setLayout(null);

		JLabel label = new JLabel("Naziv :");
		label.setBounds(24, 30, 46, 14);
		panelIgraonica.add(label);

		JLabel label_1 = new JLabel("Kontakt osoba:");
		label_1.setBounds(24, 55, 92, 14);
		panelIgraonica.add(label_1);

		JLabel label_2 = new JLabel("Email :");
		label_2.setBounds(24, 80, 46, 14);
		panelIgraonica.add(label_2);

		JLabel lblTelefon = new JLabel("Telefon  :");
		lblTelefon.setBounds(24, 105, 66, 14);
		panelIgraonica.add(lblTelefon);

		JLabel label_5 = new JLabel("Web :");
		label_5.setBounds(24, 130, 46, 14);
		panelIgraonica.add(label_5);

		tfUnosNazivaIgraonice = new JTextField();
		tfUnosNazivaIgraonice.setColumns(10);
		tfUnosNazivaIgraonice.setBounds(126, 27, 161, 20);
		panelIgraonica.add(tfUnosNazivaIgraonice);

		tfUnosKontaktOsobe = new JTextField();
		tfUnosKontaktOsobe.setColumns(10);
		tfUnosKontaktOsobe.setBounds(126, 52, 161, 20);
		panelIgraonica.add(tfUnosKontaktOsobe);

		tfUnosEmail = new JTextField();
		tfUnosEmail.setColumns(10);
		tfUnosEmail.setBounds(126, 77, 161, 20);
		panelIgraonica.add(tfUnosEmail);

		tfUnosTel1 = new JTextField();
		tfUnosTel1.setColumns(10);
		tfUnosTel1.setBounds(126, 102, 161, 20);
		panelIgraonica.add(tfUnosTel1);
		tfUnosTel1.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent kk) {
				// dozvoli samo unios brojeva!
				if (!Character.isDigit(kk.getKeyChar())) {
					JOptionPane.showMessageDialog(null, "Mozete uneti samo broj");
					kk.consume();

				}

			}

		});

		tfUnosWeb = new JTextField();
		tfUnosWeb.setColumns(10);
		tfUnosWeb.setBounds(126, 130, 161, 20);
		panelIgraonica.add(tfUnosWeb);

		JLabel lblDodajIgraonicu = new JLabel("Dodaj igraonicu*");
		lblDodajIgraonicu.setForeground(Color.RED);
		lblDodajIgraonicu.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDodajIgraonicu.setBounds(24, 0, 115, 25);
		panelIgraonica.add(lblDodajIgraonicu);

		JPanel panelKorisnik = new JPanel();
		panelKorisnik.setBackground(new Color(176, 224, 230));
		panelKorisnik.setForeground(Color.RED);
		panelKorisnik.setBorder(UIManager.getBorder("CheckBox.border"));
		panelKorisnik.setBounds(10, 322, 334, 98);
		contentPane.add(panelKorisnik);
		panelKorisnik.setLayout(null);

		JLabel lblUnesiKorisnika = new JLabel("Dodaj korisnika*");
		lblUnesiKorisnika.setForeground(Color.RED);
		lblUnesiKorisnika.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUnesiKorisnika.setBounds(10, 11, 115, 14);
		panelKorisnik.add(lblUnesiKorisnika);

		JLabel lblKorisnickoIme = new JLabel("Korisnicko ime:");
		lblKorisnickoIme.setBounds(10, 36, 98, 14);
		panelKorisnik.add(lblKorisnickoIme);

		JLabel lblLozinka = new JLabel("Lozinka :");
		lblLozinka.setBounds(10, 64, 66, 14);
		panelKorisnik.add(lblLozinka);

		tfKorisnickoIme = new JTextField();
		tfKorisnickoIme.setColumns(10);
		tfKorisnickoIme.setBounds(128, 30, 161, 20);
		panelKorisnik.add(tfKorisnickoIme);

		tfLozinka = new JTextField();
		tfLozinka.setColumns(10);
		tfLozinka.setBounds(128, 61, 161, 20);
		panelKorisnik.add(tfLozinka);

		JPanel panelAdresa = new JPanel();
		panelAdresa.setBackground(new Color(176, 224, 230));
		panelAdresa.setBorder(UIManager.getBorder("CheckBox.border"));
		panelAdresa.setBounds(10, 201, 334, 122);
		contentPane.add(panelAdresa);
		panelAdresa.setLayout(null);

		JLabel label_12 = new JLabel("Adresa : ");
		label_12.setBounds(10, 39, 60, 14);
		panelAdresa.add(label_12);

		JLabel label_13 = new JLabel("Opstina :");
		label_13.setBounds(10, 64, 60, 14);
		panelAdresa.add(label_13);

		JLabel label_14 = new JLabel("Grad :");
		label_14.setBounds(10, 89, 46, 14);
		panelAdresa.add(label_14);

		tfUnosAdrese = new JTextField();
		tfUnosAdrese.setColumns(10);
		tfUnosAdrese.setBounds(128, 36, 156, 20);
		panelAdresa.add(tfUnosAdrese);

		tfUnosOpstine = new JTextField();
		tfUnosOpstine.setColumns(10);
		tfUnosOpstine.setBounds(128, 61, 156, 20);
		panelAdresa.add(tfUnosOpstine);

		tfUnosGrada = new JTextField();
		tfUnosGrada.setColumns(10);
		tfUnosGrada.setBounds(128, 86, 156, 20);
		panelAdresa.add(tfUnosGrada);

		JLabel lblAdresa = new JLabel("Dodaj adresu*");
		lblAdresa.setForeground(Color.RED);
		lblAdresa.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAdresa.setBounds(10, 11, 101, 14);
		panelAdresa.add(lblAdresa);

		JButton btnVratiSeNaGlavnuStranu = new JButton("");
		btnVratiSeNaGlavnuStranu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				GlavnaForma g = new GlavnaForma();
				g.setVisible(true);
				dispose();
			}
		});
		btnVratiSeNaGlavnuStranu.setBackground(UIManager.getColor("Button.background"));
		btnVratiSeNaGlavnuStranu
				.setIcon(new ImageIcon(unosIgraonice.class.getResource("/images/button-round-arrow-left-icon.png")));
		btnVratiSeNaGlavnuStranu.setForeground(Color.RED);
		btnVratiSeNaGlavnuStranu.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVratiSeNaGlavnuStranu.setBounds(774, 357, 54, 52);
		contentPane.add(btnVratiSeNaGlavnuStranu);

		JPanel panelOpis = new JPanel();
		panelOpis.setBackground(new Color(176, 224, 230));
		panelOpis.setBorder(UIManager.getBorder("CheckBox.border"));
		panelOpis.setBounds(344, 32, 504, 98);
		contentPane.add(panelOpis);
		panelOpis.setLayout(null);

		JLabel lblOpis = new JLabel("Dodaj opis*");
		lblOpis.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOpis.setForeground(Color.RED);
		lblOpis.setBounds(10, 11, 77, 14);
		panelOpis.add(lblOpis);

		tfUnosOpisa = new JTextField();
		tfUnosOpisa.setBounds(10, 36, 484, 36);
		panelOpis.add(tfUnosOpisa);
		tfUnosOpisa.setColumns(10);

		cbIdIgraonice = new JComboBox();
		cbIdIgraonice.setVisible(false);
		cbIdIgraonice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String a = (String) cbIdIgraonice.getSelectedItem();

				for (Igraonica i : Kontroler.getInstance().vratiIgraonicu()) {
					if (i.getNaziv().equalsIgnoreCase(a))

						idIgraonica = i.getIdIgraonica();
				}
			}
		});
		cbIdIgraonice.setFont(new Font("Tahoma", Font.BOLD, 11));
		cbIdIgraonice.setBounds(81, 6, 165, 20);
		contentPane.add(cbIdIgraonice);

		JButton btnUnesiPaket = new JButton("DODAJ PAKET");
		btnUnesiPaket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				paketForma u = new paketForma();
				u.setVisible(true);
				dispose();
			}
		});
		btnUnesiPaket.setIcon(new ImageIcon(unosIgraonice.class.getResource("/images/button-arrow-right-icon.png")));
		btnUnesiPaket.setForeground(Color.RED);
		btnUnesiPaket.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUnesiPaket.setBounds(354, 255, 218, 43);
		contentPane.add(btnUnesiPaket);

		JButton btnUnesiSlike = new JButton("DODAJ SLIKE");
		btnUnesiSlike.setBackground(UIManager.getColor("Button.background"));
		btnUnesiSlike.setForeground(Color.RED);
		btnUnesiSlike.setIcon(new ImageIcon(unosIgraonice.class.getResource("/images/button-arrow-right-icon.png")));
		btnUnesiSlike.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUnesiSlike.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DodajSliku d = new DodajSliku();
				d.setVisible(true);
				dispose();
			}
		});
		btnUnesiSlike.setBounds(354, 201, 218, 43);
		contentPane.add(btnUnesiSlike);

		JButton btnDodajDatumI = new JButton("DODAJ DATUM I CENU");
		btnDodajDatumI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				datumCenaForma d = new datumCenaForma();
				d.setVisible(true);
				dispose();
			}
		});
		btnDodajDatumI.setIcon(new ImageIcon(unosIgraonice.class.getResource("/images/button-arrow-right-icon.png")));
		btnDodajDatumI.setForeground(Color.RED);
		btnDodajDatumI.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDodajDatumI.setBounds(354, 309, 218, 43);
		contentPane.add(btnDodajDatumI);
		
				//// UPIS IGRAONICE ////////////
				JButton btnUpisiIgraonicu = new JButton("DODAJ IGRAONICU");
				btnUpisiIgraonicu.setFont(new Font("Tahoma", Font.BOLD, 11));
				btnUpisiIgraonicu.setForeground(Color.RED);
				btnUpisiIgraonicu.setBounds(354, 141, 218, 43);
				contentPane.add(btnUpisiIgraonicu);
				btnUpisiIgraonicu.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						String naziv = tfUnosNazivaIgraonice.getText().toString();
						String kontaktOsoba = tfUnosKontaktOsobe.getText().toString();
						String email = tfUnosEmail.getText().toString();
						String telefon = tfUnosTel1.getText().toString();
						String web = tfUnosWeb.getText().toString();
						String korisnickoIme = tfKorisnickoIme.getText().toString();
						String lozinka = tfLozinka.getText().toString();
						String adresa = tfUnosAdrese.getText().toString();
						String opstina = tfUnosOpstine.getText().toString();
						String grad = tfUnosGrada.getText().toString();
						String opis = tfUnosOpisa.getText().toString();
						
						Kontroler.getInstance().posaljiNazivIgraonice(naziv, kontaktOsoba, email, telefon, web);
						popuniCombo();
						Kontroler.getInstance().unesiAdresu(idAdresa, adresa, opstina, grad, idIgraonica);
						Kontroler.getInstance().unesiKorisnika(idKorisnik, korisnickoIme, lozinka, idIgraonica);
						Kontroler.getInstance().unesiOpis(idOpis, opis, idIgraonica);
						JOptionPane.showMessageDialog(null, "Podaci o igraonici su upisani!");
						srediFormu();
						System.out.println("Id Igraonice je:" + idIgraonica);
					}

					private void srediFormu() {
						tfUnosNazivaIgraonice.setText("");
						tfUnosKontaktOsobe.setText("");
						tfUnosEmail.setText("");
						tfUnosTel1.setText("");
						tfUnosWeb.setText("");
						tfKorisnickoIme.setText("");
						tfLozinka.setText("");
						tfUnosAdrese.setText("");
						tfUnosOpstine.setText("");
						tfUnosGrada.setText("");
						tfUnosOpisa.setText("");
					}

					////////////////////////////////////////////////
					private void ocistiFormu() {

						tfUnosNazivaIgraonice.setText("");
						tfUnosKontaktOsobe.setText("");
						tfUnosEmail.setText("");
						tfUnosTel1.setText("");
						tfUnosWeb.setText("");

					}
				});
				btnUpisiIgraonicu.setBackground(UIManager.getColor("Button.background"));
				btnUpisiIgraonicu.setIcon(new ImageIcon(unosIgraonice.class.getResource("/images/ajax-loader (1).gif")));
				
						JLabel lblNewLabel = new JLabel("New label");
						lblNewLabel.setIcon(
								new ImageIcon(unosIgraonice.class.getResource("/images/Screen Shot 2015-10-27 at 02.44.34.png")));
						lblNewLabel.setBounds(0, 0, 858, 420);
						contentPane.add(lblNewLabel);
		popuniCombo();
	}

	private void popuniCombo() {
		for (Igraonica i : Kontroler.getInstance().vratiIgraonicu()) {

			cbIdIgraonice.addItem(i.getNaziv());
			// cbIdIgraonice.grabFocus();
			cbIdIgraonice.setSelectedIndex(cbIdIgraonice.getItemCount() - 1);

		}
	}
}
