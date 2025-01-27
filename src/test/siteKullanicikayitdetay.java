package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Choice;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JDialog;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class siteKullanicikayitdetay extends JDialog {

	private JPanel contentPane;
	private JTextField txtkadi;
	private JPasswordField txtsifresi;
	private JTextField txtkaciklama;
	private JComboBox txtyetki;
	private JTextField txtsoru;
	private JTextField txtcevap;
	
	static Connection myconn;
	static Statement mystat;
	
	static Connection myconn1;
	static Statement mystat1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					siteKullanicikayitdetay frame = new siteKullanicikayitdetay();
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
	public siteKullanicikayitdetay() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				
				int id_al=siteKullanicikayit.id;
				ResultSet rs = null;
				try {
					myconn=DriverManager.getConnection (siteBaglanti.sunucuparametresi,"root","");
					String listele="Select * From sitekullanicibilgi where kullaniciid='"+id_al+"'";
					mystat=myconn.createStatement();
					rs=mystat.executeQuery(listele);
					if(rs.next())
					{
						txtkadi.setText(rs.getString("kullaniciadi"));
						//txtsifresi.setText(rs.getString("sifresi"));
						txtyetki.setSelectedItem(rs.getString("yetki"));
						txtkaciklama.setText(rs.getString("aciklama"));
						txtsoru.setText(rs.getString("sifrehatirlatmasoru"));
						txtcevap.setText(rs.getString("sifrehatirlatmacevap"));
												
						siteKullanicikayit.id_sakla=siteKullanicikayit.id;
						siteKullanicikayit.id=0;
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		setResizable(false);
		setModal(true);
		setTitle("Kullanici Kayit Ekrani");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 623, 356);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtkadi = new JTextField();
		txtkadi.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					txtsifresi.requestFocus();
				}
			}
		});
		txtkadi.setBounds(449, 50, 140, 20);
		contentPane.add(txtkadi);
		txtkadi.setColumns(30);
		
		txtsifresi = new JPasswordField();
		txtsifresi.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					txtkaciklama.requestFocus();
				}
			}
		});
		txtsifresi.setBounds(449, 80, 140, 20);
		contentPane.add(txtsifresi);
		
		txtyetki = new JComboBox();
		txtyetki.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					txtsoru.requestFocus();
				}
			}
		});
		txtyetki.setModel(new DefaultComboBoxModel(new String[] {"YONETICI", "GUVENLIK", "SEKRETER", "SITESAKINI"}));
		txtyetki.setSelectedIndex(0);
		txtyetki.setBounds(449, 140, 140, 22);
		contentPane.add(txtyetki);
		
		txtkaciklama = new JTextField();
		txtkaciklama.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					txtyetki.requestFocus();
				}
			}
		});
		txtkaciklama.setColumns(30);
		txtkaciklama.setBounds(449, 110, 140, 20);
		contentPane.add(txtkaciklama);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/User-Group-icon.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(10, 48, 256, 243);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Sifre:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(298, 80, 82, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Yetki:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(298, 140, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_2 = new JLabel("Kullanici Adi:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(298, 50, 98, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4_1 = new JLabel("Aciklama:");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4_1.setBounds(298, 110, 105, 14);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblKullaniciKayitEkrani = new JLabel("Kullanici Kayit Ekrani");
		lblKullaniciKayitEkrani.setHorizontalAlignment(SwingConstants.LEFT);
		lblKullaniciKayitEkrani.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblKullaniciKayitEkrani.setBounds(10, 11, 305, 26);
		contentPane.add(lblKullaniciKayitEkrani);
		
		JLabel lblNewLabel_4_2 = new JLabel("Hatirlatma Sorusu :");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4_2.setBounds(298, 170, 129, 14);
		contentPane.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("Hatirlatma Cevabi :");
		lblNewLabel_4_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4_2_1.setBounds(298, 200, 129, 14);
		contentPane.add(lblNewLabel_4_2_1);
		
		txtsoru = new JTextField();
		txtsoru.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					txtcevap.requestFocus();
				}
			}
		});
		txtsoru.setColumns(30);
		txtsoru.setBounds(449, 170, 140, 20);
		contentPane.add(txtsoru);
		
		txtcevap = new JTextField();
		txtcevap.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					txtkadi.requestFocus();
				}
			}
		});
		txtcevap.setColumns(30);
		txtcevap.setBounds(449, 200, 140, 20);
		contentPane.add(txtcevap);
		
		
		JButton btnNewButton = new JButton("Kaydet");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if ((!txtkadi.getText().equals("")) && (!txtsifresi.getText().equals(""))) { //KULLANICI ADI VE SIFRESI BOS DEGILSE
				
				//INSERT INTO kullanicibilgi (kadi,sifresi,kaciklama,yetki) VALUES ('6','6','HASAN','AVUKAT');
				String kullaniciadi,sifresi,aciklama,yetki,sorgukullanicikayit,sifrehatirlatmasoru,sifrehatirlatmacevap;
				kullaniciadi=txtkadi.getText();
				sifresi=",(AES_ENCRYPT("+"'"+txtsifresi.getText()+"'"+",'abc1234')),";
				aciklama=txtkaciklama.getText();
				yetki=txtyetki.getSelectedItem().toString();
				sifrehatirlatmasoru=txtsoru.getText();
				sifrehatirlatmacevap=txtcevap.getText();

				//SIFRELERI GIZLEYEREK SAKLAMA KODU
				sorgukullanicikayit="INSERT INTO sitekullanicibilgi (kullaniciadi,sifresi,aciklama,yetki,sifrehatirlatmasoru,sifrehatirlatmacevap) VALUES ("+
				"'"+kullaniciadi+"'"+ sifresi  +"'"+ aciklama+"',"+"'"+ yetki+"'," +"'"+ sifrehatirlatmasoru+"'," +"'"+ sifrehatirlatmacevap+"')";			
				//SIFRELERI GIZLEYEREK SAKLAMA KODU
				
				System.out.println(sorgukullanicikayit);	
				
				//
				try {
					System.out.println(siteBaglanti.sunucuparametresi);
					myconn1=DriverManager.getConnection (siteBaglanti.sunucuparametresi,"root","");
					System.out.println("Ba�lant� Sa�land�");
				}catch(Exception hata)
				{
				System.err.println(hata);
				}
				
				try {
					mystat1=myconn1.createStatement();
					mystat1.executeUpdate(sorgukullanicikayit);
					System.out.println("BAGLANTI CLASSINDAN Ba�lant Ekleme Basarili YENI");
					dispose();//FORM KAPAMA
					}catch(Exception hata)
					{
					System.err.println(hata);
					{JOptionPane.showMessageDialog(null,"Tekrarli Alanlari Duzeltiniz..!");}
					}

			}else {JOptionPane.showMessageDialog(null,"Gerekli Alanlari Doldurunuz.!");}
			}
		});
		btnNewButton.setBounds(298, 261, 100, 30);
		//contentPane.add(btnNewButton);
		

		
		JButton btnGuncelle = new JButton("Guncelle");
		btnGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//if ((!txtkadi.getText().equals("")) && (!txtsifresi.getText().equals(""))) { //KULLANICI ADI VE SIFRESI BOS DEGILSE
				if (!txtkadi.getText().equals(""))  { //KULLANICI ADI VE SIFRESI BOS DEGILSE	
					
				//INSERT INTO kullanicibilgi (kadi,sifresi,kaciklama,yetki) VALUES ('6','6','HASAN','AVUKAT');
				String kadi,sifresi,sifresi2,kaciklama,yetki,sifrehatirlatmasoru,sifrehatirlatmacevap;
				kadi=txtkadi.getText();
				sifresi2="AES_ENCRYPT("+"'"+txtsifresi.getText()+"'"+",'abc1234')";
				kaciklama=txtkaciklama.getText();
				yetki=txtyetki.getSelectedItem().toString();
				sifrehatirlatmasoru=txtsoru.getText();
				sifrehatirlatmacevap=txtcevap.getText();
				System.out.println(sifresi2);
				String sorguguncelle="UPDATE `sitekullanicibilgi` SET `kullaniciadi` = '"+kadi+"', `sifresi` = "+sifresi2+", `aciklama` = '"+kaciklama+"', `yetki` = '"+yetki+"', `sifrehatirlatmasoru` = '"+sifrehatirlatmasoru+"', `sifrehatirlatmacevap` = '"+sifrehatirlatmacevap+"' WHERE `sitekullanicibilgi`.`kullaniciid` = '"+siteKullanicikayit.id_sakla+"'";
				
				System.out.println(sorguguncelle);	


				try {
					System.out.println(siteBaglanti.sunucuparametresi);
					System.out.println("BAGLANTI CLASSINDAN Ba�lant� Sa�land� PARAMETRE ALINDI");
					myconn=DriverManager.getConnection (siteBaglanti.sunucuparametresi,"root","");
					mystat=myconn.createStatement();
					mystat.executeUpdate(sorguguncelle);
					System.out.println("BAGLANTI CLASSINDAN Ba�lant Ekleme Basarili YENI");
					JOptionPane.showMessageDialog(null,"Islem Basarili..!");
				    dispose();//FORM KAPAMA
					}catch(Exception hata)
					{
					System.err.println(hata);
					JOptionPane.showMessageDialog(null,"Tekrarlanan Alanlari Kontrol Ediniz.!");
					}
				//

			}
				else {JOptionPane.showMessageDialog(null,"Gerekli Alanlari Doldurunuz.!");}
				
			}
		});
		btnGuncelle.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnGuncelle.setBounds(298, 261, 100, 30);
		//contentPane.add(btnGuncelle);
		
		
		
		if(siteKullanicikayit.id==0)
		{
			contentPane.add(btnNewButton);
		}
		else
		{
			if (siteBaglanti.logkullaniciyetkisi.equals("YONETICI")) 
				txtyetki.enable(true);
			else	txtyetki.enable(false); //YALNIZCA YETKILENDIRME YONETICIDE
			txtkadi.setEnabled(false);
			contentPane.add(btnGuncelle);
		}
		
		

		JButton btnKapat = new JButton("Vazgec");
		btnKapat.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnKapat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();//FORM KAPAMA
			}
		});
		btnKapat.setBounds(413, 261, 100, 30);
		contentPane.add(btnKapat);
		

	}
}
