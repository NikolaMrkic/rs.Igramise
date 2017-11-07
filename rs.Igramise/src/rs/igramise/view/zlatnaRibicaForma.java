package rs.igramise.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import rs.igramise.domen.Igraonica;
import rs.igramise.domen.KlasaZaINNERIgraonicaAdresaOpisKorisnik;
import rs.igramise.kontroler.Kontroler;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class zlatnaRibicaForma extends JFrame {

	private JPanel contentPane;
	private JTextField tfAdresa;
	private JTextField tfNazivIgranice;
	private JTextField tfWeb;
	private JTextField tfOpstina;
	private JTextField tfTelefon;
	private JTextField tfKomentar;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
	private JTextField tfGrad;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					zlatnaRibicaForma frame = new zlatnaRibicaForma();
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
	public zlatnaRibicaForma() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 863, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfAdresa = new JTextField();
		tfAdresa.setColumns(10);
		tfAdresa.setBounds(205, 282, 125, 20);
		contentPane.add(tfAdresa);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(21, 11, 805, 206);
		contentPane.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(zlatnaRibicaForma.class.getResource("/images/13445562_248550615529867_1964824544674697722_n.jpg")));
		
		tfNazivIgranice = new JTextField();
		tfNazivIgranice.setColumns(10);
		tfNazivIgranice.setBounds(163, 228, 125, 20);
		contentPane.add(tfNazivIgranice);
		
		tfWeb = new JTextField();
		tfWeb.setColumns(10);
		tfWeb.setBounds(596, 228, 125, 20);
		contentPane.add(tfWeb);
		
		JLabel label = new JLabel("");
		label.setBackground(new Color(255, 255, 255));
		label.setIcon(new ImageIcon(zlatnaRibicaForma.class.getResource("/images/orange-fishie-thingie-256x.png")));
		label.setBounds(10, 282, 185, 143);
		contentPane.add(label);
		
		tfOpstina = new JTextField();
		tfOpstina.setColumns(10);
		tfOpstina.setBounds(205, 313, 125, 20);
		contentPane.add(tfOpstina);
		
		tfTelefon = new JTextField();
		tfTelefon.setColumns(10);
		tfTelefon.setBounds(373, 228, 125, 20);
		contentPane.add(tfTelefon);
		
		tfKomentar = new JTextField();
		tfKomentar.setFont(new Font("Tahoma", Font.ITALIC, 11));
		tfKomentar.setText("ostavi komentar");
		tfKomentar.setColumns(10);
		tfKomentar.setBounds(517, 270, 309, 59);
		contentPane.add(tfKomentar);
		
		btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(zlatnaRibicaForma.class.getResource("/images/komentar.png")));
		btnNewButton.setBounds(737, 340, 89, 29);
		contentPane.add(btnNewButton);
		
		tfGrad = new JTextField();
		tfGrad.setColumns(10);
		tfGrad.setBounds(205, 345, 125, 20);
		contentPane.add(tfGrad);
		
		btnNewButton_1 = new JButton("Nazad");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sveIgraoniceForma s = new sveIgraoniceForma();
				s.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setIcon(new ImageIcon(zlatnaRibicaForma.class.getResource("/images/button-arrow-left-icon.png")));
		btnNewButton_1.setBounds(705, 392, 132, 47);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(zlatnaRibicaForma.class.getResource("/images/Screen Shot 2015-10-27 at 02.42.47.png")));
		lblNewLabel_1.setBounds(0, 0, 847, 448);
		contentPane.add(lblNewLabel_1);
		
		vratiPodatke();
	}

	private void vratiPodatke() {
		for(KlasaZaINNERIgraonicaAdresaOpisKorisnik i : Kontroler.getInstance().vratiIgraonicuZlatnuRibicu()) {
			tfNazivIgranice.setText(i.getNaziv());
			tfAdresa.setText(i.getAdresa());
			tfTelefon.setText(i.getTelefon());
			tfWeb.setText(i.getWeb());
			tfGrad.setText(i.getGrad());
			tfOpstina.setText(i.getOstina());
		}
	}

}
