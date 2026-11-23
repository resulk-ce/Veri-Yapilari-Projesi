/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.veriyapilariprojesi;


import varliklar.Urun;
import veriyapilari.BagliListe;
/**
 *
 * @author Resul KIZILTAŞ
 */
public class VeriYapilariProjesi {

    public static void main(String[] args) {
        


        BagliListe urunListesi = new BagliListe();

        // 1. Ürün Ekleme
        Urun u1 = new Urun(101, "Mekanik Klavye", "Elektronik", 850.0, 15);
        Urun u2 = new Urun(102, "Kablosuz Mouse", "Elektronik", 450.0, 25);
        Urun u3 = new Urun(103, "Oyuncu Kulaklığı", "Aksesuar", 1200.0, 10);
        Urun u4 = new Urun(104, "Klavye Bilek Desteği", "Aksesuar", 250.0, 30);

        urunListesi.ekle(u1);
        urunListesi.ekle(u2);
        urunListesi.ekle(u3);
        urunListesi.ekle(u4);

        System.out.println("--- TÜM ÜRÜNLER ---");
        urunListesi.listele();

        // 2. ID ve Ad ile Arama
        System.out.println("\n--- ID İLE ARAMA (102) ---");
        Urun bulunan = urunListesi.urunAraById(102);
        System.out.println(bulunan != null ? bulunan : "Ürün bulunamadı.");

        System.out.println("\n--- İSİM İLE ARAMA ('klavye') ---");
        urunListesi.urunAraByAd("klavye");

        // 3. Stok ve Güncelleme İşlemleri
        System.out.println("\n--- STOK VE GÜNCELLEME ---");
        u1.stokDus(3);
        u1.stokEkle(5);
        urunListesi.urunGuncelle(102, 490.0, 20);
        System.out.println("Dosya formatı: " + u1.toDosyaFormati());

        // 4. Fiyata Göre Sıralama
        System.out.println("\n--- UCUZDAN PAHALIYA SIRALI ---");
        urunListesi.fiyataGoreSirala(true);
        urunListesi.listele();

        System.out.println("\n--- PAHALIDAN UCUZA SIRALI ---");
        urunListesi.fiyataGoreSirala(false);
        urunListesi.listele();

        // 5. Silme Testi
        System.out.println("\n--- SİLME SONRASI LİSTE (ID: 102 SİLİNDİ) ---");
        urunListesi.urunSil(102);
        urunListesi.listele();
    }
}
    

