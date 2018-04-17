package rs.igramise.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import rs.igramise.controller.Kontroler;
import rs.igramise.model.Rodjendan;

import java.awt.Color;
import java.awt.Component;

import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class zakaziRodjendan extends JFrame {

	private JPanel contentPane;
	private JTextField tfImeRoditelja;
	private JTextField tfImeSlavljenika;
	private JTextField tfBrDece;
	private JTextField tfBrOdraslih;
	private JTextField tfDatum;
	private JTextField tfVremeDo;
	private JComboBox cbSatDo, cbSatOd, cbMinutiOd, cbSecOd, cbMinutDo, cbGodinaOd, cbMesecOd, cbDanOd;
	private String satOd, minutOD, godinaOd, MesecOd, danOd, secOd, datumOd, satDo, minutiDo, satiDo, secDo, vrameOd,
			vremeDo;
	private JComboBox cbSecDo;
	private int idRodjendan, idDatumRodjendana, idVremeRodjendana;
	private JComboBox cbIdRodjendan;
	private JTextField tfIdIgraonica;
	private int idIgraonica;
	private JTextField tfVremeOd;
	private int glbId;

	// private JLabel lblIdIgraonica;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					zakaziRodjendan frame = new zakaziRodjendan();
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
	 * @wbp.parser.constructor
	 */
	public zakaziRodjendan() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(UIManager.getBorder("DesktopIcon.border"));
		panel.setBackground(new Color(176, 224, 230));
		panel.setBounds(10, 35, 706, 187);
		contentPane.add(panel);

		JLabel lblImeRodjitelja = new JLabel("Ime rodjitelja :");
		lblImeRodjitelja.setBounds(24, 30, 115, 14);
		panel.add(lblImeRodjitelja);

		JLabel lblImeSlavljenika = new JLabel("Ime slavljenika :");
		lblImeSlavljenika.setBounds(24, 55, 115, 14);
		panel.add(lblImeSlavljenika);

		JLabel lblBrojDece = new JLabel("Broj dece :");
		lblBrojDece.setBounds(24, 80, 92, 14);
		panel.add(lblBrojDece);

		JLabel lblBrojOdraslih = new JLabel("Broj odraslih :");
		lblBrojOdraslih.setBounds(24, 105, 115, 14);
		panel.add(lblBrojOdraslih);

		tfImeRoditelja = new JTextField();
		tfImeRoditelja.setColumns(10);
		tfImeRoditelja.setBounds(223, 21, 161, 20);
		panel.add(tfImeRoditelja);

		tfImeSlavljenika = new JTextField();
		tfImeSlavljenika.setColumns(10);
		tfImeSlavljenika.setBounds(223, 46, 161, 20);
		panel.add(tfImeSlavljenika);

		tfBrDece = new JTextField();
		tfBrDece.setColumns(10);
		tfBrDece.setBounds(223, 71, 161, 20);
		panel.add(tfBrDece);

		tfBrOdraslih = new JTextField();
		tfBrOdraslih.setColumns(10);
		tfBrOdraslih.setBounds(223, 96, 161, 20);
		panel.add(tfBrOdraslih);

		JLabel lblZakaziRodjendan = new JLabel("Zakazi rodjendan");
		lblZakaziRodjendan.setForeground(Color.RED);
		lblZakaziRodjendan.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblZakaziRodjendan.setBounds(24, 0, 115, 25);
		panel.add(lblZakaziRodjendan);

		JLabel lblDatumRodjendana = new JLabel("Datum rodjendana :");
		lblDatumRodjendana.setBounds(24, 130, 115, 14);
		panel.add(lblDatumRodjendana);

		cbDanOd = new JComboBox();
		cbDanOd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				danOd = cbDanOd.getSelectedItem().toString();
			}
		});
		cbDanOd.setBounds(223, 127, 46, 20);
		panel.add(cbDanOd);

		cbMesecOd = new JComboBox();
		cbMesecOd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MesecOd = cbMesecOd.getSelectedItem().toString();
			}
		});
		cbMesecOd.setBounds(284, 127, 66, 20);
		panel.add(cbMesecOd);

		cbGodinaOd = new JComboBox();
		cbGodinaOd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				godinaOd = cbGodinaOd.getSelectedItem().toString();
				tfDatum.setText(danOd + "/" + MesecOd + "/" + godinaOd);

			}
		});
		cbGodinaOd.setBounds(360, 127, 88, 20);
		panel.add(cbGodinaOd);

		tfDatum = new JTextField();
		tfDatum.setColumns(10);
		tfDatum.setBounds(608, 127, 88, 20);
		panel.add(tfDatum);

		JLabel lblNewLabel = new JLabel("Vreme rodjendana ");
		lblNewLabel.setBounds(24, 159, 106, 14);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("od ");
		lblNewLabel_1.setBounds(121, 159, 19, 14);
		panel.add(lblNewLabel_1);

		JLabel lblDo = new JLabel("do :");
		lblDo.setBounds(316, 159, 32, 14);
		panel.add(lblDo);

		cbMinutDo = new JComboBox();
		cbMinutDo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				minutiDo = cbMinutDo.getSelectedItem().toString();
				tfVremeDo.setText(satDo + ":" + minutiDo);
			}
		});
		cbMinutDo.setBounds(411, 156, 66, 20);
		panel.add(cbMinutDo);

		cbSatDo = new JComboBox();
		cbSatDo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				satDo = cbSatDo.getSelectedItem().toString();
				tfVremeDo.setText(satDo);
			}
		});
		cbSatDo.setBounds(360, 156, 46, 20);
		panel.add(cbSatDo);

		tfVremeDo = new JTextField();
		tfVremeDo.setColumns(10);
		tfVremeDo.setBounds(618, 156, 78, 20);
		panel.add(tfVremeDo);

		cbSecDo = new JComboBox();
		cbSecDo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				secDo = cbSecDo.getSelectedItem().toString();
				tfVremeDo.setText(satDo + ":" + minutiDo + ":" + secDo);
			}
		});
		cbSecDo.setBounds(480, 156, 46, 20);
		panel.add(cbSecDo);

		cbMinutiOd = new JComboBox();
		cbMinutiOd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				minutOD = cbMinutiOd.getSelectedItem().toString();
				tfVremeOd.setText(satOd + ":" + minutOD);
			}
		});
		cbMinutiOd.setBounds(191, 158, 66, 20);
		panel.add(cbMinutiOd);

		cbSatOd = new JComboBox();
		cbSatOd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				satOd = cbSatOd.getSelectedItem().toString();
				tfVremeOd.setText(satOd);
			}
		});
		cbSatOd.setBounds(140, 158, 46, 20);
		panel.add(cbSatOd);

		cbSecOd = new JComboBox();
		cbSecOd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				secOd = cbSecOd.getSelectedItem().toString();
				tfVremeOd.setText(satOd + ":" + minutOD + ":" + secOd);
			}
		});
		cbSecOd.setBounds(260, 158, 46, 20);
		panel.add(cbSecOd);

		tfVremeOd = new JTextField();
		tfVremeOd.setColumns(10);
		tfVremeOd.setBounds(536, 156, 74, 20);
		panel.add(tfVremeOd);

		JButton btnZakazi = new JButton("ZAKAZI");
		btnZakazi.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				//godOd + "/" + mesecOd + "/" + danOd;
				datumOd = godinaOd + "-" + MesecOd  +"-" +  danOd;

				vrameOd = satOd + "/" + minutOD + "/" + secOd;
				vremeDo = satDo + "/" + minutiDo + "/" + secDo;

				String imeRodjitelja = tfImeRoditelja.getText().toString();
				String imeSlavljenika = tfImeSlavljenika.getText().toString();
				String brDece = tfBrDece.getText().toString();
				int brD = Integer.valueOf(brDece);
				String brODraslih = tfBrOdraslih.getText().toString();
				int brO = Integer.valueOf(brODraslih);
				

				Kontroler.getInstance().zakaziRodjendan( imeRodjitelja, imeSlavljenika, brD, brO,
						idIgraonica);
				Kontroler.getInstance().zakaziDatumRodjendana( datumOd, glbId);
				 //Kontroler.getInstance().zakaziVremeRodjendana(idVremeRodjendana,vrameOd,vremeDo,idRodjendan);
				srediFormu();
			}

			private void srediFormu() {
				tfImeRoditelja.setText("");
				tfImeSlavljenika.setText("");
				tfBrDece.setText("");
				tfBrOdraslih.setText("");

			}

		});
		btnZakazi.setIcon(new ImageIcon(zakaziRodjendan.class.getResource("/images/ajax-loader (1).gif")));
		btnZakazi.setForeground(Color.RED);
		btnZakazi.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnZakazi.setBackground(SystemColor.menu);
		btnZakazi.setBounds(243, 243, 218, 43);
		contentPane.add(btnZakazi);

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				sveIgraoniceForma s = new sveIgraoniceForma();
				s.setVisible(true);
				dispose();
			}
		});
		button.setIcon(new ImageIcon(zakaziRodjendan.class.getResource("/images/button-round-arrow-left-icon.png")));
		button.setForeground(Color.RED);
		button.setFont(new Font("Tahoma", Font.BOLD, 11));
		button.setBackground(SystemColor.menu);
		button.setBounds(651, 334, 54, 52);
		contentPane.add(button);

		tfIdIgraonica = new JTextField();
		tfIdIgraonica.setBounds(61, 334, 54, 10);
		contentPane.add(tfIdIgraonica);
		tfIdIgraonica.setColumns(10);

		

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(0, 0, 726, 397);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(
				new ImageIcon(zakaziRodjendan.class.getResource("/images/Screen Shot 2015-10-27 at 02.44.34.png")));
		popuniDatum();
		popuniSat();

	}

	public zakaziRodjendan(String id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(UIManager.getBorder("DesktopIcon.border"));
		panel.setBackground(new Color(176, 224, 230));
		panel.setBounds(10, 35, 706, 187);
		contentPane.add(panel);

		JLabel lblImeRodjitelja = new JLabel("Ime rodjitelja :");
		lblImeRodjitelja.setBounds(24, 30, 115, 14);
		panel.add(lblImeRodjitelja);

		JLabel lblImeSlavljenika = new JLabel("Ime slavljenika :");
		lblImeSlavljenika.setBounds(24, 55, 115, 14);
		panel.add(lblImeSlavljenika);

		JLabel lblBrojDece = new JLabel("Broj dece :");
		lblBrojDece.setBounds(24, 80, 92, 14);
		panel.add(lblBrojDece);

		JLabel lblBrojOdraslih = new JLabel("Broj odraslih :");
		lblBrojOdraslih.setBounds(24, 105, 115, 14);
		panel.add(lblBrojOdraslih);

		tfImeRoditelja = new JTextField();
		tfImeRoditelja.setColumns(10);
		tfImeRoditelja.setBounds(223, 21, 161, 20);
		panel.add(tfImeRoditelja);

		tfImeSlavljenika = new JTextField();
		tfImeSlavljenika.setColumns(10);
		tfImeSlavljenika.setBounds(223, 46, 161, 20);
		panel.add(tfImeSlavljenika);

		tfBrDece = new JTextField();
		tfBrDece.setColumns(10);
		tfBrDece.setBounds(223, 71, 161, 20);
		panel.add(tfBrDece);

		tfBrOdraslih = new JTextField();
		tfBrOdraslih.setColumns(10);
		tfBrOdraslih.setBounds(223, 96, 161, 20);
		panel.add(tfBrOdraslih);

		JLabel lblZakaziRodjendan = new JLabel("Zakazi rodjendan");
		lblZakaziRodjendan.setForeground(Color.RED);
		lblZakaziRodjendan.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblZakaziRodjendan.setBounds(24, 0, 115, 25);
		panel.add(lblZakaziRodjendan);

		JLabel lblDatumRodjendana = new JLabel("Datum rodjendana :");
		lblDatumRodjendana.setBounds(24, 130, 115, 14);
		panel.add(lblDatumRodjendana);

		cbDanOd = new JComboBox();
		cbDanOd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				danOd = cbDanOd.getSelectedItem().toString();
			}
		});
		cbDanOd.setBounds(223, 127, 46, 20);
		panel.add(cbDanOd);

		cbMesecOd = new JComboBox();
		cbMesecOd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MesecOd = cbMesecOd.getSelectedItem().toString();
			}
		});
		cbMesecOd.setBounds(284, 127, 66, 20);
		panel.add(cbMesecOd);

		cbGodinaOd = new JComboBox();
		cbGodinaOd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				godinaOd = cbGodinaOd.getSelectedItem().toString();
				tfDatum.setText(danOd + "/" + MesecOd + "/" + godinaOd);

			}
		});
		cbGodinaOd.setBounds(360, 127, 88, 20);
		panel.add(cbGodinaOd);

		tfDatum = new JTextField();
		tfDatum.setColumns(10);
		tfDatum.setBounds(608, 127, 88, 20);
		panel.add(tfDatum);

		JLabel lblNewLabel = new JLabel("Vreme rodjendana ");
		lblNewLabel.setBounds(24, 159, 106, 14);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("od ");
		lblNewLabel_1.setBounds(121, 159, 19, 14);
		panel.add(lblNewLabel_1);

		JLabel lblDo = new JLabel("do :");
		lblDo.setBounds(316, 159, 32, 14);
		panel.add(lblDo);

		cbMinutDo = new JComboBox();
		cbMinutDo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				minutiDo = cbMinutDo.getSelectedItem().toString();
				tfVremeDo.setText(satDo + ":" + minutiDo);
			}
		});
		cbMinutDo.setBounds(411, 156, 66, 20);
		panel.add(cbMinutDo);

		cbSatDo = new JComboBox();
		cbSatDo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				satDo = cbSatDo.getSelectedItem().toString();
				tfVremeDo.setText(satDo);
			}
		});
		cbSatDo.setBounds(360, 156, 46, 20);
		panel.add(cbSatDo);

		tfVremeDo = new JTextField();
		tfVremeDo.setColumns(10);
		tfVremeDo.setBounds(618, 156, 78, 20);
		panel.add(tfVremeDo);

		cbSecDo = new JComboBox();
		cbSecDo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				secDo = cbSecDo.getSelectedItem().toString();
				tfVremeDo.setText(satDo + ":" + minutiDo + ":" + secDo);
			}
		});
		cbSecDo.setBounds(480, 156, 46, 20);
		panel.add(cbSecDo);

		cbMinutiOd = new JComboBox();
		cbMinutiOd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				minutOD = cbMinutiOd.getSelectedItem().toString();
				tfVremeOd.setText(satOd + ":" + minutOD);
			}
		});
		cbMinutiOd.setBounds(191, 158, 66, 20);
		panel.add(cbMinutiOd);

		cbSatOd = new JComboBox();
		cbSatOd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				satOd = cbSatOd.getSelectedItem().toString();
				tfVremeOd.setText(satOd);
			}
		});
		cbSatOd.setBounds(140, 158, 46, 20);
		panel.add(cbSatOd);

		cbSecOd = new JComboBox();
		cbSecOd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				secOd = cbSecOd.getSelectedItem().toString();
				tfVremeOd.setText(satOd + ":" + minutOD + ":" + secOd);
			}
		});
		cbSecOd.setBounds(260, 158, 46, 20);
		panel.add(cbSecOd);

		tfVremeOd = new JTextField();
		tfVremeOd.setColumns(10);
		tfVremeOd.setBounds(536, 156, 74, 20);
		panel.add(tfVremeOd);
		JButton btnZakazi = new JButton("ZAKAZI");
		btnZakazi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//godOd + "/" + mesecOd + "/" + danOd;
				datumOd = godinaOd + "-" + MesecOd  +"-" +  danOd;

				vrameOd = satOd + ":" + minutOD + ":" + secOd;
				vremeDo = satDo + ":" + minutiDo + ":" + secDo;

				String imeRodjitelja = tfImeRoditelja.getText().toString();
				String imeSlavljenika = tfImeSlavljenika.getText().toString();
				String brDece = tfBrDece.getText().toString();
				int brD = Integer.valueOf(brDece);
				String brODraslih = tfBrOdraslih.getText().toString();
				int brO = Integer.valueOf(brODraslih);
				

				Kontroler.getInstance().zakaziRodjendan( imeRodjitelja, imeSlavljenika, brD, brO,
						idIgraonica);
				for(Rodjendan r : Kontroler.getInstance().vratRodjendan()) {
					if(tfImeRoditelja.getText().equalsIgnoreCase(r.getImeRoditelja())) {
						glbId = r.getIdRodjendan();
					}
				}
				Kontroler.getInstance().zakaziDatumRodjendana( datumOd, glbId);
				 Kontroler.getInstance().zakaziVremeRodjendana(vrameOd,vremeDo,glbId);
				srediFormu();
				JOptionPane.showMessageDialog(null, "Uspesno ste zakazali rodjendan za ");
			}

			private void srediFormu() {
				tfImeRoditelja.setText("");
				tfImeSlavljenika.setText("");
				tfBrDece.setText("");
				tfBrOdraslih.setText("");
			}
		});
		btnZakazi.setIcon(new ImageIcon(zakaziRodjendan.class.getResource("/images/ajax-loader (1).gif")));
		btnZakazi.setForeground(Color.RED);
		btnZakazi.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnZakazi.setBackground(SystemColor.menu);
		btnZakazi.setBounds(243, 243, 218, 43);
		contentPane.add(btnZakazi);

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				formaZaIgraonice z = new formaZaIgraonice();
				z.setVisible(true);
				dispose();
			}
		});
		button.setIcon(new ImageIcon(zakaziRodjendan.class.getResource("/images/button-round-arrow-left-icon.png")));
		button.setForeground(Color.RED);
		button.setFont(new Font("Tahoma", Font.BOLD, 11));
		button.setBackground(SystemColor.menu);
		button.setBounds(651, 334, 54, 52);
		contentPane.add(button);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(0, 0, 726, 397);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(
				new ImageIcon(zakaziRodjendan.class.getResource("/images/Screen Shot 2015-10-27 at 02.44.34.png")));

		tfIdIgraonica = new JTextField();
		tfIdIgraonica.setBounds(61, 334, 54, 10);
		contentPane.add(tfIdIgraonica);
		tfIdIgraonica.setColumns(10);

		
		popuniDatum();
		popuniSat();
		postaviIdRodjendana();
		id(id);

	}

	

	private void postaviIdRodjendana() {
		for(Rodjendan r : Kontroler.getInstance().vratRodjendan()) {
			if(tfImeRoditelja.getText().equalsIgnoreCase(r.getImeRoditelja())) {
				glbId = r.getIdRodjendan();
			}
		}
		
	}

	private void id(String id) {
		idIgraonica = Integer.parseInt(id);
	}

	private void popuniSat() {

		for (int i = 1; i < 25; i++) {
			cbSatOd.addItem(i);
			cbSatDo.addItem(i);
		}

		for (int i = 0; i < 61; i++) {
			cbMinutiOd.addItem(i);
			cbMinutDo.addItem(i);
		}

		for (int i = 0; i < 61; i++) {
			cbSecOd.addItem(i);
			cbSecDo.addItem(i);
		}

	}

	private void popuniDatum() {

		for (int i = 1; i < 32; i++) {
			cbDanOd.addItem(i);

		}
		for (int i = 1; i < 13; i++) {
			cbMesecOd.addItem(i);
			// cbMesecOd.addItem(i);
		}
		for (int i = 2017; i < 2100; i++) {
			cbGodinaOd.addItem(i);

		}

	}
}
