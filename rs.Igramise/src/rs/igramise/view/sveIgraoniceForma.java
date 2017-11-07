package rs.igramise.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.table.DefaultTableModel;

import rs.igramise.domen.Igraonica;
import rs.igramise.kontroler.Kontroler;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;




import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.Box;

public class sveIgraoniceForma extends JFrame {
	private DefaultTableModel dtm = new DefaultTableModel();
	private ArrayList<Igraonica	> igraonicaArraay = new ArrayList<>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sveIgraoniceForma frame = new sveIgraoniceForma();
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
	public sveIgraoniceForma() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 852, 492);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Sve decije igraonice na jednom mestu!");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(604, 3, 245, 22);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnIgraonica1 = new JButton("Zlatna Ribica / Kralja Petra 12 Obrenovac");
		btnIgraonica1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				zlatnaRibicaForma z = new zlatnaRibicaForma();
				z.setVisible(true);
				dispose();
			}
		});
		btnIgraonica1.setBackground(new Color(255, 255, 255));
		btnIgraonica1.setBounds(102, 151, 255, 38);
		getContentPane().add(btnIgraonica1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(102, 37, 255, 114);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblIgraonica1 = new JLabel("");
		lblIgraonica1.setIcon(new ImageIcon(sveIgraoniceForma.class.getResource("/images/orange-fishie-thingie-256x.png")));
		lblIgraonica1.setBounds(0, 0, 256, 114);
		panel_1.add(lblIgraonica1);
		
		JButton btnIgraonica2 = new JButton("Nodi / Ugrinovacka 21b Zemun");
		btnIgraonica2.setBackground(new Color(255, 255, 255));
		btnIgraonica2.setBounds(465, 151, 255, 38);
		getContentPane().add(btnIgraonica2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(465, 37, 255, 114);
		getContentPane().add(panel_2);
		
		JLabel lblIgraonica2 = new JLabel("");
		lblIgraonica2.setIcon(new ImageIcon(sveIgraoniceForma.class.getResource("/images/w5520.jpg")));
		lblIgraonica2.setBounds(0, 0, 256, 114);
		panel_2.add(lblIgraonica2);
		
		JLabel lblNewLabel_3 = new JLabel("Prona\u0111ite odgovaraju\u0107u igraonicu u Beogradu. Pogledajte opise, fotografije, preporuke... Prona\u0111ite kontakt podatke i adresu. Pozovite izabranu ");
		lblNewLabel_3.setBounds(76, 200, 697, 22);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblRoendaonicuiliStartujteNavigaciju = new JLabel("ro\u0111endaonicuili startujte navigaciju od Va\u0161e trenutne lokacije do igraonice jednim klikom. Budite u toku sa akcijama, novostima i aktivnostima.");
		lblRoendaonicuiliStartujteNavigaciju.setBounds(86, 221, 716, 22);
		getContentPane().add(lblRoendaonicuiliStartujteNavigaciju);
		
		JLabel lblNewLabel_4 = new JLabel("Preporucene igraonice za 11/2017");
		lblNewLabel_4.setBounds(319, 264, 231, 14);
		getContentPane().add(lblNewLabel_4);
		
		JButton btnIgraonica3 = new JButton("New button");
		btnIgraonica3.setBounds(166, 289, 212, 43);
		getContentPane().add(btnIgraonica3);
		
		JButton btnIgraonica4 = new JButton("New button");
		btnIgraonica4.setBounds(426, 289, 212, 43);
		getContentPane().add(btnIgraonica4);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(192, 192, 192));
		panel_3.setBounds(0, 393, 836, 60);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblDoniOpis = new JLabel("\u00A9 2017 igramise");
		lblDoniOpis.setBounds(10, 0, 227, 19);
		panel_3.add(lblDoniOpis);
		
		JLabel lblNewLabel_6 = new JLabel("Osnovne informacije se objavljuju besplatno. Ako imate igraonicu koji \u017Eelite da promovi\u0161ete - po\u0161aljite nam informacije na igraonice@igramise.rs.");
		lblNewLabel_6.setBounds(10, 30, 764, 13);
		panel_3.add(lblNewLabel_6);
		
		JButton btnNazad = new JButton("");
		btnNazad.setBounds(768, 0, 68, 60);
		panel_3.add(btnNazad);
		btnNazad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GlavnaForma g = new GlavnaForma();
				g.setVisible(true);
			}
		});
		btnNazad.setIcon(new ImageIcon(sveIgraoniceForma.class.getResource("/images/button-arrow-left-icon.png")));
		btnNazad.setForeground(Color.RED);
		btnNazad.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNazad.setBackground(new Color(192, 192, 192));
		
		JLabel label_1 = new JLabel("igramise.rs");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_1.setBounds(10, -1, 164, 27);
		getContentPane().add(label_1);
		
		JLabel lblPozadina = new JLabel("New label");
		lblPozadina.setIcon(new ImageIcon(sveIgraoniceForma.class.getResource("/images/7488fc31516629.5654cf4b7e813.png")));
		lblPozadina.setBounds(0, 0, 836, 392);
		getContentPane().add(lblPozadina);
		
		Object[]kolone = new Object[2];
		kolone[0]= "Naziv Igraonice";
		
		dtm.addColumn( kolone[0]);
		
		srediTabelu();
	}

	private void srediTabelu() {
		
		dtm.setRowCount(0);
		Object[] ob = new Object[2];
		
		igraonicaArraay = Kontroler.getInstance().vratiIgraonicu();
		
		for(Igraonica i : igraonicaArraay) {
			ob[0] = i.getNaziv();
			dtm.addRow(ob);
		}
	}
}
