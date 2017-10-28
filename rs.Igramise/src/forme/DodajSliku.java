package forme;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import baza.DBKomunikacija;

import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


import com.mysql.jdbc.PreparedStatement;


import domen.Igraonica;
import kontroler.Kontroler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JComponent;

public class DodajSliku extends JFrame {

	
	
	protected static final Statement JdbcConnection = null;
	JButton button;
    JButton btnAdd;
    JLabel labelPanelZaSDodavanjeSlike;
    JTextField textID;
    private int idIgraonica ,idSlike;
    public String assign_in = null,s;
	private JComboBox cbIdIgraonice;
	private JFrame frame;
	
  

    
    

    public DodajSliku() {
    	setTitle("DODAVANJE SLIKA");
        
        
        button = new JButton("");
        button.setIcon(new ImageIcon(DodajSliku.class.getResource("/images/next.png")));
        button.setBounds(325, 393, 73, 51);
        
        btnAdd = new JButton("");
        btnAdd.setIcon(new ImageIcon(DodajSliku.class.getResource("/images/add.png")));
        btnAdd.setBounds(226, 393, 64, 51);

        labelPanelZaSDodavanjeSlike = new JLabel();
        labelPanelZaSDodavanjeSlike.setIcon(null);
        labelPanelZaSDodavanjeSlike.setBounds(0, 55, 861, 289);

        //button to browse the image into jlabel
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg", "gif", "png");
                fileChooser.addChoosableFileFilter(filter);
                int result = fileChooser.showSaveDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    String path = selectedFile.getAbsolutePath();
                    labelPanelZaSDodavanjeSlike.setIcon(ResizeImage(path));
                    s = path;
                } else if (result == JFileChooser.CANCEL_OPTION) {
                    System.out.println("No Data");
                }
            }
        });

        
        button.addActionListener(new ActionListener() {

            private Connection con;
			@Override
            public void actionPerformed(ActionEvent e) {
             

                	try {
            			Class.forName("com.mysql.jdbc.Driver");
            		} catch (ClassNotFoundException e1) {
            			e1.printStackTrace();
            		}
                	try{
                	con = DriverManager.getConnection("jdbc:mysql://localhost/igramise.rs", "root", "");
                    PreparedStatement ps = (PreparedStatement) con.prepareStatement("insert into slike(slika,id_Igraonica) values(?,?)");
                    InputStream is = new FileInputStream(new File(s));
                    ps.setInt(1, cbIdIgraonice.getSelectedIndex());
                    ps.setBlob(2, is);
                    ps.setInt(2, idIgraonica);
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Uspesno dodavanje slike!");
                    srediFormu();
                    
                   
                    DBKomunikacija.getInstance().zatvoriKonekciju();
                    
                } catch (Exception ex) {
                    ex.printStackTrace();
                    
                
                }
                	
			}
			private void srediFormu() {
				labelPanelZaSDodavanjeSlike.setIcon(null);
			}
            
        });
        
        getContentPane().add(labelPanelZaSDodavanjeSlike);
        getContentPane().add(button);
        getContentPane().add(btnAdd);
        getContentPane().setLayout(null);
        
        cbIdIgraonice = new JComboBox();
        cbIdIgraonice.setVisible(false);
        cbIdIgraonice.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		String a = (String) cbIdIgraonice.getSelectedItem();

				for (Igraonica i : Kontroler.getInstance().vratiIgraonicu()) {
					if (i.getNaziv().equalsIgnoreCase(a))
						
					idIgraonica = i.getIdIgraonica();
				}
			
        	}
        });
        cbIdIgraonice.setBounds(42, 11, 113, 20);
        getContentPane().add(cbIdIgraonice);
        cbIdIgraonice.setVisible(false);
        
        JButton btnVratiSeNaUnosIgraonice = new JButton("");
        btnVratiSeNaUnosIgraonice.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		unosIgraonice u = new unosIgraonice();
        		u.setVisible(true);
        		dispose();
        	}
        });
        btnVratiSeNaUnosIgraonice.setIcon(new ImageIcon(DodajSliku.class.getResource("/images/back.png")));
        btnVratiSeNaUnosIgraonice.setForeground(Color.RED);
        btnVratiSeNaUnosIgraonice.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnVratiSeNaUnosIgraonice.setBackground(new Color(204, 255, 255));
        btnVratiSeNaUnosIgraonice.setBounds(567, 393, 64, 51);
        getContentPane().add(btnVratiSeNaUnosIgraonice);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(DodajSliku.class.getResource("/images/dodj sliku.jpg")));
        lblNewLabel.setBounds(0, 0, 861, 455);
        getContentPane().add(lblNewLabel);
      
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(877, 494);
        setVisible(true);
      
   


		popuniCombo();
	}

	public void popuniCombo() {
		for (Igraonica i : Kontroler.getInstance().vratiIgraonicu()) {

			cbIdIgraonice.addItem(i.getNaziv());
			// cbIdIgraonice.grabFocus();
			cbIdIgraonice.setSelectedIndex(cbIdIgraonice.getItemCount() - 1);

		}
	}

	// Methode to resize imageIcon with the same size of a Jlabel
	public ImageIcon ResizeImage(String ImagePath) {
		ImageIcon MyImage = new ImageIcon(ImagePath);
		Image img = MyImage.getImage();
		Image newImg = img.getScaledInstance(labelPanelZaSDodavanjeSlike.getWidth(), labelPanelZaSDodavanjeSlike.getHeight(), Image.SCALE_FAST);
		ImageIcon image = new ImageIcon(newImg);
		return image;
	}
}

