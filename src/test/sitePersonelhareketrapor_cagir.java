package test;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.lowagie.text.Document;
import com.lowagie.text.List;
import com.lowagie.text.ListItem;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class sitePersonelhareketrapor_cagir {
	
	static Connection myconn1;
	static Statement mystat1;
	
	public void rapor(String sayi) {
		
		ResultSet rs1 = null;
		
		try 
		{
	 
			myconn1=DriverManager.getConnection (siteBaglanti.sunucuparametresi,"root","");
			String listele="Select * From sitepersonelcarihareket where Personelhareketid='"+sayi+"'";
			mystat1=myconn1.createStatement();
			rs1=mystat1.executeQuery(listele);
				if(rs1.next())
				{	
					String path;
					path=System.getProperty("user.home") + "/Desktop"; //DESKTOP YOLUNU BULMA
					Document document = new Document();
					PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(path+"\\sitepersonelhareket.pdf"));
					document.open();
					//ekrana yaz�lar bas�l�yor
					document.add(new Paragraph("SECILEN PERSONEL CARI HAREKET SATIRI BILGILERI :"));
					
				
				
				
				
			         //Liste y�ntemiyle veri ekleme
			         List list = new List(List.UNORDERED);
			            list.add(new ListItem("Personel hareketid="+rs1.getString("Personelhareketid")));
			            list.add(new ListItem("Ad Soyadi="+rs1.getString("Personeladsoyad")));
			            list.add(new ListItem("Alacak Tutari="+rs1.getString("Personelalacaktutari")));
			            list.add(new ListItem("Borc Tutari="+rs1.getString("Personelborctutari")));
			            list.add(new ListItem("---------------------------------------------------------------------------------------------------------"));
			            list.add(new ListItem("Hareket Tarihi="+rs1.getString("Personelharekettarihi")));
			            list.add(new ListItem("Aciklama="+rs1.getString("Aciklama")));
			            list.add(new ListItem("Tc No="+rs1.getString("Personeltcno")));
			            list.add(new ListItem("---------------------------------------------------------------------------------------------------------"));
			            list.add(new ListItem("Hatirlat="+rs1.getString("hatirlat")));
			            list.add(new ListItem("Hakedis="+rs1.getString("hakedis")));
			            list.add(new ListItem("---------------------------------------------------------------------------------------------------------"));
			            list.add(new ListItem("Bu Rapor :"+ siteBaglanti.versionadi+" Uygulamasi ile talebiniz uzere olusturulmustur..."));
			           document.add(list);
			         
					//D�k�man� kapat�yoruz
					document.close();
			        pdfWriter.close();
				
			        
			        
			        //Eklenen pdf'i direk olarak a�ma
			       // String FILE = "C:\\Users\\y�lmaz\\eclipse-workspace\\Deneme\\avukatbilgi.pdf";
			        String FILE = path+"\\sitepersonelhareket.pdf";
					try 
					{
						if ((new File(FILE)).exists()) {
							Process p = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + FILE);
							p.waitFor();
						} else {
							System.out.println("Dosya Bulunamadi");
						}
						System.out.println("Islem Basarili");
					}catch (Exception ex) {
						ex.printStackTrace();
					}
			        
		        
				}	
		}
		catch(Exception e1)
		{
			 JOptionPane.showMessageDialog(null,"1 sat�r se�iniz veya");
				e1.printStackTrace();
		}
		
 
	}
	
	
}
