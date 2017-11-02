package rs.igramise.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import rs.igramise.domen.Paket;
import rs.igramise.domen.PonudaPaketaTabela;
import rs.igramise.kontroler.Kontroler;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class datumCenaForma extends JFrame {

    private JPanel contentPane;
    private JComboBox cbIdPaketa;
    private int idPaket, idCenovnik, idDatum, idIgraonica;
    private String danOd, danDo, mesecOd, mesecDo, godOd, godDo;
    private String datumOd, datumDo;
    private JTextField tfOd;
    private JTextField tfDo;
    private JComboBox cbDanOd, cbDanDo, cbMesecOd, cbMesecDo, cbGodOd, cbGodDo;
    private JTextField tfCena;
    private JScrollPane scrollPane;
    private JTable table;
    private DefaultTableModel dtm = new DefaultTableModel();
    private LinkedList<PonudaPaketaTabela> pp = new LinkedList<>();
    private JLabel lblNazivpaketa;
    private JLabel lblCenaPaketa;
    private JLabel lblNewLabel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    datumCenaForma frame = new datumCenaForma();
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
    public datumCenaForma() {
        setTitle("UNOS DATUMA I CENE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 887, 488);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        cbIdPaketa = new JComboBox();
       // cbIdPaketa.setVisible(false);
        cbIdPaketa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String Paket = (String) cbIdPaketa.getSelectedItem();
                for (rs.igramise.domen.Paket p : Kontroler.getInstance().vratiPaket()) {
                    if (p.getNazivPaketa().equalsIgnoreCase(Paket)) {
                        idPaket = p.getIdPaketa();
                    }
                }
            }
        });
        cbIdPaketa.setBounds(322, 11, 140, 20);
        contentPane.add(cbIdPaketa);

        JButton button = new JButton("");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                unosIgraonice u = new unosIgraonice();
                u.setVisible(true);
                dispose();
            }
        });
        button.setForeground(new Color(0, 0, 153));
        button.setIcon(new ImageIcon(datumCenaForma.class.getResource("/images/back.png")));
        button.setBounds(754, 388, 70, 50);
        contentPane.add(button);

        JButton button_1 = new JButton("");
        button_1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                datumOd = godOd + "/" + mesecOd + "/" + danOd;
                datumDo = godDo + "/" + mesecDo + "/" + danDo;

                String cena = tfCena.getText();
                int ce = Integer.valueOf(cena);
                Kontroler.getInstance().unesiCenu(ce, idPaket);
                Kontroler.getInstance().uneciDatumICenu(datumOd, datumDo, idPaket);
                srediFormu();
                JOptionPane.showMessageDialog(null, "Uspesno ste uneli datum i cenu!");
            }

            private void srediFormu() {
                tfCena.setText("");
            }
        });
        button_1.setIcon(new ImageIcon(datumCenaForma.class.getResource("/images/update.png")));
        button_1.setBounds(644, 388, 70, 50);
        contentPane.add(button_1);

        JLabel label_2 = new JLabel("Datum od :");
        label_2.setBounds(180, 109, 66, 14);
        contentPane.add(label_2);

        JLabel label_3 = new JLabel("Datum do :");
        label_3.setBounds(180, 140, 71, 14);
        contentPane.add(label_3);

        JLabel label_4 = new JLabel("Unesi datum*");
        label_4.setForeground(Color.RED);
        label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
        label_4.setBounds(74, 81, 78, 14);
        contentPane.add(label_4);

        cbDanOd = new JComboBox();
        cbDanOd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                danOd = cbDanOd.getSelectedItem().toString();
            }
        });
        cbDanOd.setBounds(256, 106, 46, 20);
        contentPane.add(cbDanOd);

        cbMesecOd = new JComboBox();
        cbMesecOd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                mesecOd = cbMesecOd.getSelectedItem().toString();
            }
        });
        cbMesecOd.setBounds(337, 106, 66, 20);
        contentPane.add(cbMesecOd);

        cbGodOd = new JComboBox();
        cbGodOd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                godOd = cbGodOd.getSelectedItem().toString();
                tfOd.setText(danOd + "/" + mesecOd + "/" + godOd);
            }
        });
        cbGodOd.setBounds(440, 106, 88, 20);
        contentPane.add(cbGodOd);

        cbDanDo = new JComboBox();
        cbDanDo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                danDo = cbDanDo.getSelectedItem().toString();

            }
        });
        cbDanDo.setBounds(256, 137, 46, 20);
        contentPane.add(cbDanDo);
        cbMesecDo = new JComboBox();
        cbMesecDo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                mesecDo = cbMesecDo.getSelectedItem().toString();

            }
        });
        cbMesecDo.setBounds(337, 137, 66, 20);
        contentPane.add(cbMesecDo);

        cbGodDo = new JComboBox();
        cbGodDo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                godDo = cbGodDo.getSelectedItem().toString();
                tfDo.setText(danDo + "/" + mesecDo + "/" + godDo);
            }
        });
        cbGodDo.setBounds(440, 137, 88, 20);
        contentPane.add(cbGodDo);

        tfOd = new JTextField();
        tfOd.setColumns(10);
        tfOd.setBounds(573, 106, 88, 20);
        contentPane.add(tfOd);

        tfDo = new JTextField();
        tfDo.setColumns(10);
        tfDo.setBounds(573, 137, 88, 20);
        contentPane.add(tfDo);

        JLabel label = new JLabel("Cena :");
        label.setBounds(180, 333, 46, 14);
        contentPane.add(label);

        tfCena = new JTextField();
        tfCena.setColumns(10);
        tfCena.setBounds(256, 327, 139, 20);
        contentPane.add(tfCena);
        
        tfCena.addKeyListener(new KeyAdapter() {
        	public void keyTyped(KeyEvent kk){
        		//dozvoli samo unios brojeva!
        		if(!Character.isDigit(kk.getKeyChar())){
        			JOptionPane.showMessageDialog(null, "Mozete uneti samo broj");
        			kk.consume();
        		
        			
        		}
        	
        	}

			
			
		});
   

        JLabel label_1 = new JLabel("Unesi cenu*");
        label_1.setForeground(Color.RED);
        label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        label_1.setBounds(84, 299, 68, 14);
        contentPane.add(label_1);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(176, 197, 503, 38);
        contentPane.add(scrollPane);

        table = new JTable(dtm);
        scrollPane.setViewportView(table);

        lblNazivpaketa = new JLabel("Naziv Paketa :");
        lblNazivpaketa.setForeground(Color.RED);
        lblNazivpaketa.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNazivpaketa.setBounds(74, 198, 92, 14);
        contentPane.add(lblNazivpaketa);

        lblCenaPaketa = new JLabel("Cena Paketa :");
        lblCenaPaketa.setForeground(Color.RED);
        lblCenaPaketa.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblCenaPaketa.setBounds(74, 221, 78, 14);
        contentPane.add(lblCenaPaketa);
        
        lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon(datumCenaForma.class.getResource("/images/7488fc31516629.5654cf4b7e813.png")));
        lblNewLabel.setBounds(0, 0, 871, 449);
        contentPane.add(lblNewLabel);

        Object[] kolone = new Object[4];
        kolone[0] = "Promo";
        kolone[1] = "Mesecni";
        kolone[2] = "Sest Meseci";
        kolone[3] = "Dvanaeset Meseci";

        dtm.addColumn(kolone[0]);
        dtm.addColumn(kolone[1]);
        dtm.addColumn(kolone[2]);
        dtm.addColumn(kolone[3]);

        popuniComboPaketa();
        popuniDatume();
        srediTabelu();
    }

    private void srediTabelu() {

        dtm.setRowCount(0);
        Object[] ob = new Object[4];

        pp = Kontroler.getInstance().vratiPonuduPaketa();

        for (PonudaPaketaTabela ppt : pp) {
            ob[0] = ppt.getPromo();
            ob[1] = ppt.getMesecni();
            ob[2] = ppt.getSestMeseci();
            ob[3] = ppt.getDvanaestMeseci();
            dtm.addRow(ob);
        }
    }

    private void popuniDatume() {

        for (int i = 1; i < 32; i++) {
            cbDanOd.addItem(i);
            cbDanDo.addItem(i);
        }
        for (int i = 1; i < 13; i++) {
            cbMesecOd.addItem(i);
            cbMesecDo.addItem(i);
        }
        for (int i = 2016; i < 2100; i++) {
            cbGodOd.addItem(i);
            cbGodDo.addItem(i);
        }
    }

    public void popuniComboPaketa() {

        String predhodniPaket = "";

        for (Paket p : Kontroler.getInstance().vratiPaket()) {
            if (!predhodniPaket.equals(p.getNazivPaketa())) {
                cbIdPaketa.addItem(p.getNazivPaketa());
            }
            predhodniPaket = p.getNazivPaketa();
        }
    }
}
