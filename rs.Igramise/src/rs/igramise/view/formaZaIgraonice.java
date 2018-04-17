package rs.igramise.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import rs.igramise.controller.Kontroler;
import rs.igramise.model.Igraonica;
import rs.igramise.model.KlasaZaINNERIgraonicaAdresaOpisKorisnik;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class formaZaIgraonice extends JFrame {

	private JPanel contentPane;
	private JTextField tfKomentar;
	private JButton btnUnesiKomentar;
	private JButton btnNazad;
	private JLabel lblSlikaOdIgraonice;
	private JLabel lblLogoodIgraonice;
	private JLabel lblNazivIgraonice;
	private JLabel lblAdresa;
	private JLabel lblGrad;
	private JLabel lblWeb;
	private JLabel lblTelefon;
	private JLabel lblEmail;
	private JLabel lblPozadina;
	private JLabel lblIdIgraonice;
	private JButton btnZakaziRodjendan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					formaZaIgraonice frame = new formaZaIgraonice();
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
	public formaZaIgraonice() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 863, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblSlikaOdIgraonice = new JLabel("");
		lblSlikaOdIgraonice.setBounds(21, 11, 805, 206);
		contentPane.add(lblSlikaOdIgraonice);
		lblSlikaOdIgraonice.setIcon(new ImageIcon(
				formaZaIgraonice.class.getResource("/images/13445562_248550615529867_1964824544674697722_n.jpg")));

		lblLogoodIgraonice = new JLabel("");
		lblLogoodIgraonice.setBackground(new Color(255, 255, 255));
		lblLogoodIgraonice
				.setIcon(new ImageIcon(formaZaIgraonice.class.getResource("/images/orange-fishie-thingie-256x.png")));
		lblLogoodIgraonice.setBounds(14, 262, 155, 143);
		contentPane.add(lblLogoodIgraonice);

		tfKomentar = new JTextField();
		tfKomentar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tfKomentar.setText("");
			}
		});
		tfKomentar.setFont(new Font("Tahoma", Font.ITALIC, 11));
		tfKomentar.setText("ostavi komentar");
		tfKomentar.setColumns(10);
		tfKomentar.setBounds(517, 270, 309, 59);
		contentPane.add(tfKomentar);

		btnUnesiKomentar = new JButton("");
		btnUnesiKomentar.setIcon(new ImageIcon(formaZaIgraonice.class.getResource("/images/komentar.png")));
		btnUnesiKomentar.setBounds(737, 340, 89, 29);
		contentPane.add(btnUnesiKomentar);

		btnNazad = new JButton("Nazad");
		btnNazad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				sveIgraoniceForma s = new sveIgraoniceForma();
				s.setVisible(true);
				dispose();
			}
		});
		btnNazad.setBackground(new Color(255, 255, 255));
		btnNazad.setIcon(new ImageIcon(formaZaIgraonice.class.getResource("/images/button-arrow-left-icon.png")));
		btnNazad.setBounds(705, 392, 132, 47);
		contentPane.add(btnNazad);

		lblNazivIgraonice = new JLabel();
		lblNazivIgraonice.setForeground(Color.BLACK);
		lblNazivIgraonice.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblNazivIgraonice.setBounds(175, 287, 125, 20);
		contentPane.add(lblNazivIgraonice);

		lblAdresa = new JLabel();
		lblAdresa.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAdresa.setBounds(175, 318, 125, 20);
		contentPane.add(lblAdresa);

		lblGrad = new JLabel();
		lblGrad.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGrad.setBounds(175, 349, 125, 20);
		contentPane.add(lblGrad);

		lblWeb = new JLabel();
		lblWeb.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWeb.setForeground(Color.WHITE);
		lblWeb.setIcon(
				new ImageIcon(formaZaIgraonice.class.getResource("/images/Categories-applications-internet-icon.png")));
		lblWeb.setBounds(124, 228, 176, 29);
		contentPane.add(lblWeb);

		lblTelefon = new JLabel();
		lblTelefon.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTelefon.setForeground(Color.WHITE);
		lblTelefon.setIcon(new ImageIcon(formaZaIgraonice.class.getResource("/images/Phone-icon.png")));
		lblTelefon.setBounds(382, 232, 125, 20);
		contentPane.add(lblTelefon);

		lblEmail = new JLabel("New label");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setIcon(new ImageIcon(formaZaIgraonice.class.getResource("/images/email-icon.png")));
		lblEmail.setBounds(592, 230, 245, 29);
		contentPane.add(lblEmail);

		lblIdIgraonice = new JLabel("");
		lblIdIgraonice.setBounds(21, 425, 46, 14);
		contentPane.add(lblIdIgraonice);

		btnZakaziRodjendan = new JButton("Zakazi rodjendan");
		btnZakaziRodjendan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 
				String id =lblIdIgraonice.getText();
				zakaziRodjendan z = new zakaziRodjendan(id);
				z.setVisible(true);
				dispose();
			}
		});
		btnZakaziRodjendan.setBackground(Color.WHITE);
		btnZakaziRodjendan.setIcon(new ImageIcon(formaZaIgraonice.class.getResource("/images/Get-Info-icon.png")));
		btnZakaziRodjendan.setBounds(501, 392, 190, 47);
		contentPane.add(btnZakaziRodjendan);

		lblPozadina = new JLabel();
		lblPozadina.setIcon(
				new ImageIcon(formaZaIgraonice.class.getResource("/images/Screen Shot 2015-10-27 at 02.44.34.png")));
		lblPozadina.setBounds(0, 0, 847, 448);
		contentPane.add(lblPozadina);

		podesiSlikuOdIgraonice();
		podesiLogoOdIgraonice();
	}

	private void podesiSlikuOdIgraonice() {

		try {

			File file = new File(
					"///C:/rs.IgramiseGitHub/rs.Igramise/src/images/13445562_248550615529867_1964824544674697722_n.jpg");
			BufferedImage bimg = ImageIO.read(file);
			Image scaled = bimg.getScaledInstance(1000, 350, Image.SCALE_SMOOTH);
			ImageIcon icon = new ImageIcon(scaled);
			lblSlikaOdIgraonice.setIcon(icon);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void podesiLogoOdIgraonice() {

		try {

			File file = new File("///C:/rs.IgramiseGitHub/rs.Igramise/src/images/orange-fishie-thingie-256x.png");
			BufferedImage bimg = ImageIO.read(file);
			Image scaled = bimg.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
			ImageIcon icon = new ImageIcon(scaled);
			lblLogoodIgraonice.setIcon(icon);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @return the contentPane
	 * 
	 *         /**
	 * @return the tfKomentar
	 */
	public JTextField getTfKomentar() {
		return tfKomentar;
	}

	/**
	 * @param tfKomentar
	 *            the tfKomentar to set
	 */
	public void setTfKomentar(JTextField tfKomentar) {
		this.tfKomentar = tfKomentar;
	}

	/**
	 * @return the btnUnesiKomentar
	 */
	public JButton getBtnUnesiKomentar() {
		return btnUnesiKomentar;
	}

	/**
	 * @param btnUnesiKomentar
	 *            the btnUnesiKomentar to set
	 */
	public void setBtnUnesiKomentar(JButton btnUnesiKomentar) {
		this.btnUnesiKomentar = btnUnesiKomentar;
	}

	/**
	 * @return the btnNazad
	 */
	public JButton getBtnNazad() {
		return btnNazad;
	}

	/**
	 * @param btnNazad
	 *            the btnNazad to set
	 */
	public void setBtnNazad(JButton btnNazad) {
		this.btnNazad = btnNazad;
	}

	/**
	 * @return the lblSlikaOdIgraonice
	 */
	public JLabel getLblSlikaOdIgraonice() {
		return lblSlikaOdIgraonice;
	}

	/**
	 * @param lblSlikaOdIgraonice
	 *            the lblSlikaOdIgraonice to set
	 */
	public void setLblSlikaOdIgraonice(JLabel lblSlikaOdIgraonice) {
		this.lblSlikaOdIgraonice = lblSlikaOdIgraonice;
	}

	/**
	 * @return the lblLogoodIgraonice
	 */
	public JLabel getLblLogoodIgraonice() {
		return lblLogoodIgraonice;
	}

	/**
	 * @param lblLogoodIgraonice
	 *            the lblLogoodIgraonice to set
	 */
	public void setLblLogoodIgraonice(JLabel lblLogoodIgraonice) {
		this.lblLogoodIgraonice = lblLogoodIgraonice;
	}

	/**
	 * @return the lblNazivIgraonice
	 */
	public JLabel getLblNazivIgraonice() {
		return lblNazivIgraonice;
	}

	/**
	 * @param lblNazivIgraonice
	 *            the lblNazivIgraonice to set
	 */
	public void setLblNazivIgraonice(JLabel lblNazivIgraonice) {
		this.lblNazivIgraonice = lblNazivIgraonice;
	}

	/**
	 * @return the lblAdresa
	 */
	public JLabel getLblAdresa() {
		return lblAdresa;
	}

	/**
	 * @param lblAdresa
	 *            the lblAdresa to set
	 */
	public void setLblAdresa(JLabel lblAdresa) {
		this.lblAdresa = lblAdresa;
	}

	/**
	 * @return the lblGrad
	 */
	public JLabel getLblGrad() {
		return lblGrad;
	}

	/**
	 * @param lblGrad
	 *            the lblGrad to set
	 */
	public void setLblGrad(JLabel lblGrad) {
		this.lblGrad = lblGrad;
	}

	/**
	 * @return the lblWeb
	 */
	public JLabel getLblWeb() {
		return lblWeb;
	}

	/**
	 * @param lblWeb
	 *            the lblWeb to set
	 */
	public void setLblWeb(JLabel lblWeb) {
		this.lblWeb = lblWeb;
	}

	/**
	 * @return the lblTelefon
	 */
	public JLabel getLblTelefon() {
		return lblTelefon;
	}

	/**
	 * @param lblTelefon
	 *            the lblTelefon to set
	 */
	public void setLblTelefon(JLabel lblTelefon) {
		this.lblTelefon = lblTelefon;
	}

	/**
	 * @return the lblEmail
	 */
	public JLabel getLblEmail() {
		return lblEmail;
	}

	/**
	 * @param lblEmail
	 *            the lblEmail to set
	 */
	public void setLblEmail(JLabel lblEmail) {
		this.lblEmail = lblEmail;
	}

	/**
	 * @return the lblPozadina
	 */
	public JLabel getLblPozadina() {
		return lblPozadina;
	}

	/**
	 * @param lblPozadina
	 *            the lblPozadina to set
	 */
	public void setLblPozadina(JLabel lblPozadina) {
		this.lblPozadina = lblPozadina;
	}

	/**
	 * @return the lblIdIgraonice
	 */
	public JLabel getLblIdIgraonice() {
		return lblIdIgraonice;
	}

	/**
	 * @param lblIdIgraonice
	 *            the lblIdIgraonice to set
	 */
	public void setLblIdIgraonice(JLabel lblIdIgraonice) {
		this.lblIdIgraonice = lblIdIgraonice;
	}

	/**
	 * @return the btnZakaziRodjendan
	 */
	public JButton getBtnZakaziRodjendan() {
		return btnZakaziRodjendan;
	}

	/**
	 * @param btnZakaziRodjendan
	 *            the btnZakaziRodjendan to set
	 */
	public void setBtnZakaziRodjendan(JButton btnZakaziRodjendan) {
		this.btnZakaziRodjendan = btnZakaziRodjendan;
	}
}
