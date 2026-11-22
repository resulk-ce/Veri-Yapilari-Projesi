/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dosyaislemleri;

import java.io.File;
import java.io.IOException;

public class DosyaYoneticisi {
    //klasorAdi + File.separator metodu mevcut dosyayı klasore ekler
	private final String klasorAdi = "veriler";
	private final String urunler = klasorAdi + File.separator + "urunler.txt";
	private final String kullanicilar = klasorAdi + File.separator + "kullanicilar.txt";
	private final String siparisler = klasorAdi + File.separator + "siparisler.txt";

	public DosyaYoneticisi() {
		dosyalariHazirla();
	}
    //dosya hazirla diye bir metod tanımladım ve dosy oluşturma işlemlerini yapacak 
	public void dosyalariHazirla() {
		File klasorFile = new File(klasorAdi);          //klasor tanımla 
		if (!klasorFile.exists()) {                     //klasor degilse mevcut
			klasorFile.mkdirs();                        //klasoru oluştur 
			System.out.println("klasör oluşturuldu");
		}
		File urunlerFile = new File(urunler);            //urunler i tanımla 
		File kullanicilarFile = new File(kullanicilar);  //kulaniciler i tanımla 
		File siparislerFile = new File(siparisler);      //siparişleri tanımla

		try {                                           //try blogu aç hata yakalamak için
			if (!urunlerFile.exists()) {                //degilse urunler mevcut
				urunlerFile.createNewFile();            //yeni bir urun dosyası yap
				System.out.println("ürünler dosyası oluşturuldu");
			}
			if (!kullanicilarFile.exists()) {                              //degilse kulaniciler mevcut
				kullanicilarFile.createNewFile();                          //yeni bir kulanici dosyası yap
				System.out.println("kullanicilar dosyası oluşturuldu");
			}
			if (!siparislerFile.exists()) {                           //degilse siparisler mevcut
				siparislerFile.createNewFile();                       //yeni bir siparis dosyası yap 
				System.out.println("siparisler dosyası oluşturuldu");
			}
		} catch (IOException e) {                                               //eger hata yakalarsan 
			System.err.println("Dosya oluşturulurken hata: " + e.getMessage());  //hatanın kaynagını yaz
		}
	}
}