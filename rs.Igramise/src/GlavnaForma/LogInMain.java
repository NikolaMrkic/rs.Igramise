package GlavnaForma;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domen.Admin;
import domen.Korisnik;
import forme.mojaIgraonica;
import kontroler.Kontroler;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogInMain extends JFrame {

	private JPanel contentPane;
	private JTextField tfKorisnickoIme;
	private JTextField tfLozninka;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInMain frame = new LogInMain();
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
	public LogInMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGif = new JLabel("");
		lblGif.setBounds(0, 0, 470, 186);
		contentPane.add(lblGif);
		 lblGif.setIcon(new javax.swing.ImageIcon(LogInMain.class.getResource("/images/logIn_ani.gif"))); 
		 
		 JLabel label = new JLabel("Korisnicko ime");
		 label.setForeground(Color.BLACK);
		 label.setFont(new Font("Tahoma", Font.BOLD, 12));
		 label.setBounds(77, 197, 111, 27);
		 contentPane.add(label);
		 
		 JLabel label_1 = new JLabel("Lozinka");
		 label_1.setForeground(Color.BLACK);
		 label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		 label_1.setBounds(98, 245, 73, 27);
		 contentPane.add(label_1);
		 
		 tfKorisnickoIme = new JTextField();
		 tfKorisnickoIme.setColumns(10);
		 tfKorisnickoIme.setBounds(198, 197, 206, 27);
		 contentPane.add(tfKorisnickoIme);
		 
		 tfLozninka = new JTextField();
		 tfLozninka.setColumns(10);
		 tfLozninka.setBounds(198, 246, 206, 27);
		 contentPane.add(tfLozninka);
		  
		  JButton button = new JButton("");
		  button.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent arg0) {
		  		
		  		String korisnickoIme = tfKorisnickoIme.getText();
				String lozinka = tfLozninka.getText();
				
				boolean provera = false;
				for(Admin k : Kontroler.getInstance().vratiAdmina()){
					
					if(k.getLozinka().equalsIgnoreCase(lozinka)&&k.getKorisnickoIme().equalsIgnoreCase(korisnickoIme)){
						provera = true;
						break;
					}
				}
				
				if(provera == true){
					JOptionPane.showMessageDialog(null, "Imate pristup Aplikaciji!");
					GlavnaForma m = new GlavnaForma();
					m.setVisible(true);
					dispose();
				}else{
					JOptionPane.showMessageDialog(null, "Nemate pristup Aplikaciji?'!");
				}
				tfKorisnickoIme.setText("");
				tfLozninka.setText("");
				
			
		  		
		  		
		  	}
		  });
		  button.setForeground(Color.RED);
		  button.setFont(new Font("Tahoma", Font.BOLD, 11));
		  button.setBackground(UIManager.getColor("Button.background"));
		  button.setBounds(126, 297, 206, 43);
		  contentPane.add(button);
		  button.setIcon(new javax.swing.ImageIcon(LogInMain.class.getResource("/images/ajax-loader (1).gif")));
		 
		  JLabel lblPozadina = new JLabel("New label");
		  lblPozadina.setBounds(0, 0, 470, 351);
		  contentPane.add(lblPozadina);
		  lblPozadina.setIcon(new javax.swing.ImageIcon(LogInMain.class.getResource("/images/simple_blue_background-wallpaper-2048x1152.jpg")));
	}
}
