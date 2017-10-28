package forme;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;

import GlavnaForma.GlavnaForma;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class sveIgraoniceForma extends JFrame {
	private JTable table;
	private JTextField tfUnosKomentara;

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
		setBounds(100, 100, 852, 473);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Grad");
		lblNewLabel.setBounds(248, 45, 177, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblAdresa = new JLabel("Adresa");
		lblAdresa.setBounds(248, 70, 177, 14);
		getContentPane().add(lblAdresa);
		
		JLabel lblTelefon = new JLabel("Telefon");
		lblTelefon.setBounds(248, 95, 177, 14);
		getContentPane().add(lblTelefon);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 388, 145, -146);
		getContentPane().add(scrollPane_1);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GlavnaForma g = new GlavnaForma();
				g.setVisible(true);
			}
		});
		button.setIcon(new ImageIcon(sveIgraoniceForma.class.getResource("/images/back.png")));
		button.setForeground(Color.RED);
		button.setFont(new Font("Tahoma", Font.BOLD, 11));
		button.setBackground(new Color(204, 255, 255));
		button.setBounds(740, 355, 58, 43);
		getContentPane().add(button);
		
		JLabel lblWeb = new JLabel("Web");
		lblWeb.setBounds(248, 120, 177, 14);
		getContentPane().add(lblWeb);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(sveIgraoniceForma.class.getResource("/images/komentar.png")));
		button_1.setBounds(233, 227, 33, 30);
		getContentPane().add(button_1);
		
		JLabel lblZaSlikuOdIgraonice = new JLabel("New label");
		lblZaSlikuOdIgraonice.setBackground(Color.YELLOW);
		lblZaSlikuOdIgraonice.setForeground(Color.BLUE);
		lblZaSlikuOdIgraonice.setBounds(10, 25, 228, 109);
		getContentPane().add(lblZaSlikuOdIgraonice);
		
		JLabel lblOpstina = new JLabel("Opstina");
		lblOpstina.setBounds(248, 25, 177, 14);
		getContentPane().add(lblOpstina);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(619, 317, 179, -290);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBounds(0, 0, 1, 1);
		getContentPane().add(table);
		
		tfUnosKomentara = new JTextField();
		tfUnosKomentara.setBounds(10, 171, 256, 52);
		getContentPane().add(tfUnosKomentara);
		tfUnosKomentara.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(sveIgraoniceForma.class.getResource("/images/1456587501_Untitled-1.gif")));
		lblNewLabel_1.setBounds(0, 0, 836, 434);
		getContentPane().add(lblNewLabel_1);
	}
}
