package forme;

import java.awt.BorderLayout;
import forme.mojaIgraonica;
import kontroler.Kontroler;
import domen.Igraonica;
import java.awt.EventQueue;
import domen.Korisnik;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GlavnaForma.GlavnaForma;
import domen.Igraonica;
import kontroler.Kontroler;

import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class logInForma extends JFrame {

	private JPanel contentPane;
	private JTextField tfKorisnickoIme;
	private JTextField tfLozinka;
	private JComboBox cbLogIn;
	private ArrayList<Korisnik> alKorisnik = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					logInForma frame = new logInForma();
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
	public logInForma() {
		setTitle("Uloguj se");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 747, 429);
		contentPane = new JPanel();
		contentPane.setBorder(UIManager.getBorder("Button.border"));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSlikaLogin = new JLabel("");
		lblSlikaLogin.setIcon(new ImageIcon(logInForma.class.getResource("/images/login.png")));
		lblSlikaLogin.setBounds(32, 83, 145, 165);
		contentPane.add(lblSlikaLogin);

		JLabel lblKorisnickoIme = new JLabel("Korisnicko ime");
		lblKorisnickoIme.setForeground(new Color(0, 0, 0));
		lblKorisnickoIme.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblKorisnickoIme.setBounds(207, 128, 111, 27);
		contentPane.add(lblKorisnickoIme);

		JLabel lbllozinka = new JLabel("Lozinka");
		lbllozinka.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbllozinka.setForeground(new Color(0, 0, 0));
		lbllozinka.setBounds(247, 187, 73, 27);
		contentPane.add(lbllozinka);

		tfKorisnickoIme = new JTextField();
		tfKorisnickoIme.setBounds(339, 129, 231, 27);
		contentPane.add(tfKorisnickoIme);
		tfKorisnickoIme.setColumns(10);

		tfLozinka = new JTextField();
		tfLozinka.setColumns(10);
		tfLozinka.setBounds(339, 188, 231, 27);
		contentPane.add(tfLozinka);

		JButton btnUlogujSe = new JButton("Uloguj se");
		btnUlogujSe.setBackground(new Color(255, 255, 255));
		btnUlogujSe.setIcon(new ImageIcon(logInForma.class.getResource("/images/button-arrow-right-icon.png")));
		btnUlogujSe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String korisnickoIme = tfKorisnickoIme.getText();
				String lozinka = tfLozinka.getText();
				
				boolean provera = false;
				for(Korisnik k : Kontroler.getInstance().vratiKorisnike()){
					
					if(k.getLozinka().equalsIgnoreCase(lozinka)&&k.getKorisnickoIme().equalsIgnoreCase(korisnickoIme)){
						provera = true;
						break;
					}
				}
				
				if(provera == true){
					JOptionPane.showMessageDialog(null, "Imate pristup Igraonici!");
					mojaIgraonica m = new mojaIgraonica(korisnickoIme,lozinka);
					m.setVisible(true);
					dispose();
				}else{
					JOptionPane.showMessageDialog(null, "Nemate pristup igraonici!");
				}
				tfKorisnickoIme.setText("");
				tfLozinka.setText("");
				
			}

		});
		btnUlogujSe.setForeground(Color.DARK_GRAY);
		btnUlogujSe.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnUlogujSe.setBounds(384, 322, 171, 43);
		contentPane.add(btnUlogujSe);

		JButton btnVratiSeNazad = new JButton("Nazad");
		btnVratiSeNazad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GlavnaForma gl = new GlavnaForma();
				gl.setVisible(true);
				dispose();
			}
		});
		btnVratiSeNazad.setIcon(new ImageIcon(logInForma.class.getResource("/images/button-arrow-left-icon.png")));
		btnVratiSeNazad.setForeground(Color.DARK_GRAY);
		btnVratiSeNazad.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnVratiSeNazad.setBackground(new Color(255, 255, 255));
		btnVratiSeNazad.setBounds(144, 322, 171, 43);
		contentPane.add(btnVratiSeNazad);
		
		JLabel lblNewLabel = new JLabel("");
		lblSlikaLogin.setLabelFor(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(logInForma.class.getResource("/images/ajax-loader (1).gif")));
		lblNewLabel.setBounds(44, 124, 73, 54);
		contentPane.add(lblNewLabel);
		
		JLabel lblPozadina = new JLabel("");
		lblPozadina.setIcon(new ImageIcon(logInForma.class.getResource("/images/blue-abstract-background.gif")));
		lblPozadina.setBounds(0, 0, 737, 390);
		contentPane.add(lblPozadina);

		// popuniComboLogIn();
	}
}
