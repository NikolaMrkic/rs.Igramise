package rs.igramise.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import rs.igramise.baza.DBKomunikacija;
import rs.igramise.domen.Igraonica;
import rs.igramise.kontroler.Kontroler;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextArea;

public class GlavnaForma extends JFrame {

	private JPanel contentPane;
	private JComboBox cbLogIn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlavnaForma frame = new GlavnaForma();
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
	public GlavnaForma() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 874, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JButton pogledajSvojuIgraonicu = new JButton("Moja Igraonica");
		pogledajSvojuIgraonicu.setBackground(SystemColor.activeCaption);
		pogledajSvojuIgraonicu.setFont(new Font("Tahoma", Font.BOLD, 11));
		pogledajSvojuIgraonicu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				logInForma l = new logInForma();
				l.setVisible(true);
				dispose();
				
			
			

			}});
		pogledajSvojuIgraonicu.setIcon(new javax.swing.ImageIcon(GlavnaForma.class.getResource("/images/update.png")));
		pogledajSvojuIgraonicu.setBounds(318, 333, 220, 60);
		contentPane.add(pogledajSvojuIgraonicu);
		
		JButton PogledajSveIgraonice = new JButton("Pogledaj Igraonice");
		PogledajSveIgraonice.setFont(new Font("Tahoma", Font.BOLD, 11));
		PogledajSveIgraonice.setBackground(SystemColor.activeCaption);
		PogledajSveIgraonice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sveIgraoniceForma s = new sveIgraoniceForma();
				s.setVisible(true);
				dispose();
			}
		});
		PogledajSveIgraonice.setBounds(548, 333, 209, 60);
		PogledajSveIgraonice.setIcon(new javax.swing.ImageIcon(GlavnaForma.class.getResource("/images/next.png")));
		contentPane.add(PogledajSveIgraonice);
		
		JButton dodajIdraonicu = new JButton("Dodaj Igraonicu");
		dodajIdraonicu.setFont(new Font("Tahoma", Font.BOLD, 11));
		dodajIdraonicu.setBackground(SystemColor.activeCaption);
		dodajIdraonicu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				unosIgraonice d = new unosIgraonice();
				d.setVisible(true);
				dispose();
			}
		});
		dodajIdraonicu.setIcon(new javax.swing.ImageIcon(GlavnaForma.class.getResource("/images/Toolbar-Add-Folder-icon.png")));
		dodajIdraonicu.setBounds(90, 333, 218, 60);
		contentPane.add(dodajIdraonicu);
		
		JButton btnIzvestajOSvimIgraonicama = new JButton("Igraonice koje koriste aplikaciju");
		btnIzvestajOSvimIgraonicama.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					//DBKomunikacija.getInstance().otvoriKonekciju();
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/igramise.rs", "root", "");
					HashMap parm = new HashMap();
					JasperPrint jp = JasperFillManager.fillReport("C:\\rs.IgramiseGitHub\\rs.Igramise\\src\\rs\\igramise\\JasperyReport\\TrenutnoStanjeIgraonica.jasper",parm,con);
					JasperViewer jw = new JasperViewer(jp);
					jw.setVisible(true);
					DBKomunikacija.getInstance().zatvoriKonekciju();
				} catch (JRException ex) {
					ex.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnIzvestajOSvimIgraonicama.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnIzvestajOSvimIgraonicama.setBackground(SystemColor.activeCaption);
		btnIzvestajOSvimIgraonicama.setBounds(10, 11, 250, 33);
		btnIzvestajOSvimIgraonicama.setIcon(new javax.swing.ImageIcon(GlavnaForma.class.getResource("/images/Documents-icon (1).png")));
		contentPane.add(btnIzvestajOSvimIgraonicama);
		
		JLabel slikaPozadina = new JLabel("");
		slikaPozadina.setBackground(Color.ORANGE);
		slikaPozadina.setForeground(Color.RED);
		slikaPozadina.setFont(new Font("Tahoma", Font.BOLD, 16));
		slikaPozadina.setIcon(new javax.swing.ImageIcon(GlavnaForma.class.getResource("/images/Screen Shot 2015-10-27 at 02.44.34.png")));
		slikaPozadina.setBounds(0, -26, 858, 451);
		contentPane.add(slikaPozadina);
		
		
	}
}
