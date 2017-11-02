package rs.igramise.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import rs.igramise.domen.Igraonica;
import rs.igramise.domen.Paket;
import rs.igramise.domen.PonudaPaketaTabela;
import rs.igramise.kontroler.Kontroler;

import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.MatteBorder;

public class paketForma extends JFrame {

	private JPanel UnesiPaketCenuDatum;
	private JComboBox<String> cbIdIgraoniceFp;
	private int idIgraonica, idPaket;
	private ArrayList<Paket> pk = new ArrayList<>();
	private ArrayList<Igraonica> ig = new ArrayList<>();
	private JComboBox<String> cbIdPaketaFp;
	private JTextField tfNazivPaketa;
	private JTextField tfOpisPaketa;
	private DefaultTableModel dtm = new DefaultTableModel();
	private LinkedList<PonudaPaketaTabela> pp = new LinkedList<>();
	private String Promo,Mesecni,sestMeseci,dvanaestMeseci;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					paketForma frame = new paketForma();
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
	public paketForma() {
		setTitle("UNOS PAKETA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 870, 486);
		UnesiPaketCenuDatum = new JPanel();
		UnesiPaketCenuDatum.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(UnesiPaketCenuDatum);
		UnesiPaketCenuDatum.setLayout(null);

		cbIdIgraoniceFp = new JComboBox<String>();
		cbIdIgraoniceFp.setVisible(false);
		cbIdIgraoniceFp.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String a = (String) cbIdIgraoniceFp.getSelectedItem();

				for (Igraonica i : Kontroler.getInstance().vratiIgraonicu()) {
					if (i.getNaziv().equalsIgnoreCase(a))
						;
					idIgraonica = i.getIdIgraonica();
				}
			}
		});
		cbIdIgraoniceFp.setBounds(32, 12, 140, 20);
		UnesiPaketCenuDatum.add(cbIdIgraoniceFp);

		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String naziv = tfNazivPaketa.getText().toString();
				String opis = tfOpisPaketa.getText().toString();
				Kontroler.getInstance().unesiPaket(idPaket,naziv, opis, idIgraonica);
				ocistiFormu();
				JOptionPane.showMessageDialog(null, "Podaci o paketu su uspesno uneti!");
				
			}

			private void ocistiFormu() {
				tfNazivPaketa.setText("");
				tfOpisPaketa.setText("");
			}
		});
		btnNewButton.setIcon(new ImageIcon(paketForma.class.getResource("/images/update.png")));
		btnNewButton.setBounds(645, 386, 70, 50);
		UnesiPaketCenuDatum.add(btnNewButton);

		JButton btnVratiSeNaGlavnuFormu = new JButton("");
		btnVratiSeNaGlavnuFormu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				unosIgraonice g = new unosIgraonice();
				g.setVisible(true);
				dispose();
			}
		});
		btnVratiSeNaGlavnuFormu.setIcon(new ImageIcon(paketForma.class.getResource("/images/back.png")));
		btnVratiSeNaGlavnuFormu.setForeground(Color.RED);
		btnVratiSeNaGlavnuFormu.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVratiSeNaGlavnuFormu.setBackground(new Color(204, 255, 255));
		btnVratiSeNaGlavnuFormu.setBounds(751, 386, 70, 50);
		UnesiPaketCenuDatum.add(btnVratiSeNaGlavnuFormu);
		
		JLabel label = new JLabel("Naziv paketa :");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setForeground(Color.RED);
		label.setBackground(Color.RED);
		label.setBounds(239, 218, 88, 14);
		UnesiPaketCenuDatum.add(label);
		
		tfNazivPaketa = new JTextField();
		tfNazivPaketa.setColumns(10);
		tfNazivPaketa.setBounds(337, 215, 183, 20);
		UnesiPaketCenuDatum.add(tfNazivPaketa);
		
		JLabel label_1 = new JLabel("Unesi paket*");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setBounds(179, 177, 92, 14);
		UnesiPaketCenuDatum.add(label_1);
		
		JLabel label_2 = new JLabel("Opis paketa :");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setForeground(Color.RED);
		label_2.setBounds(239, 254, 78, 14);
		UnesiPaketCenuDatum.add(label_2);
		
		tfOpisPaketa = new JTextField();
		tfOpisPaketa.setColumns(10);
		tfOpisPaketa.setBounds(337, 247, 339, 66);
		UnesiPaketCenuDatum.add(tfOpisPaketa);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(141, 60, 519, 36);
		UnesiPaketCenuDatum.add(scrollPane);
		
		table = new JTable(dtm);
		scrollPane.setViewportView(table);
		
		JLabel lblNaziv = new JLabel("Naziv paketa :");
		lblNaziv.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNaziv.setBounds(32, 58, 85, 20);
		UnesiPaketCenuDatum.add(lblNaziv);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(paketForma.class.getResource("/images/datumcena.png")));
		lblNewLabel.setBounds(0, 0, 854, 447);
		UnesiPaketCenuDatum.add(lblNewLabel);
						
						
				Object[]kolone = new Object[4];
				kolone[0] = "Promo";
				kolone[1] = "Mesecni";
				kolone[2] = "Sest Meseci";
				kolone[3] = "Dvanaeset Meseci";
				
				dtm.addColumn(kolone[0]);
				dtm.addColumn(kolone[1]);
				dtm.addColumn(kolone[2]);
				dtm.addColumn(kolone[3]);
				
				

		prikaziComboIdIgraonice();
		srediTabelu();

	}

	
	public void srediTabelu() {
		
		dtm.setRowCount(0);
		Object[] ob = new Object[4];
		
		pp = Kontroler.getInstance().vratiPonuduPaketa();
		
		for(PonudaPaketaTabela ppt : pp){
			ob[0] = ppt.getPromo();
			ob[1] = ppt.getMesecni();
			ob[2] = ppt.getSestMeseci();
			ob[3] = ppt.getDvanaestMeseci();
			dtm.addRow(ob);
		}
	}

	public void prikaziComboIdIgraonice() {
		

		
		for (Igraonica i : Kontroler.getInstance().vratiIgraonicu()) {
		
			cbIdIgraoniceFp.addItem(i.getNaziv());
			// cbIdIgraonice.grabFocus();
			cbIdIgraoniceFp.setSelectedIndex(cbIdIgraoniceFp.getItemCount() - 1);

		}
	}
}
