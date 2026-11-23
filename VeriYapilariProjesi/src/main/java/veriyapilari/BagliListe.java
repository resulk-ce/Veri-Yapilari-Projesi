/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package veriyapilari;


 import varliklar.Urun;
public class BagliListe {
   
public static class Dugum {
        public Urun veri;
        public Dugum sonraki;

        public Dugum(Urun veri) {
            this.veri = veri;
            this.sonraki = null;
        }
    }

    private Dugum bas;

    public BagliListe() {
        this.bas = null;
    }

    // DosyaYoneticisi sınıfının ürünleri sırayla okuyabilmesi için başlangıç düğümü
    public Dugum getBas() {
        return bas;
    }

    // Listenin sonuna yeni ürün ekleme
    public void ekle(Urun urun) {
        if (urun == null) {
            return;
        }
        Dugum yeni = new Dugum(urun);
        if (bas == null) {
            bas = yeni;
            return;
        }
        Dugum gecici = bas;
        while (gecici.sonraki != null) {
            gecici = gecici.sonraki;
        }
        gecici.sonraki = yeni;
    }

    // ID ile ürün arama (yoksa null döner)
    public Urun urunAraById(int id) {
        Dugum gecici = bas;
        while (gecici != null) {
            if (gecici.veri.getId() == id) {
                return gecici.veri;
            }
            gecici = gecici.sonraki;
        }
        return null;
    }

    // Ürün adında büyük/küçük harf duyarsız arama yapıp konsola yazdırır
    public void urunAraByAd(String anahtarKelime) {
        if (anahtarKelime == null || anahtarKelime.trim().isEmpty()) {
            System.out.println("Arama kelimesi boş olamaz.");
            return;
        }
        String aranan = anahtarKelime.toLowerCase();
        Dugum gecici = bas;
        boolean bulundu = false;

        while (gecici != null) {
            if (gecici.veri.getAd().toLowerCase().contains(aranan)) {
                System.out.println(gecici.veri);
                bulundu = true;
            }
            gecici = gecici.sonraki;
        }

        if (!bulundu) {
            System.out.println("'" + anahtarKelime + "' ile eşleşen ürün bulunamadı.");
        }
    }

    // Baştan, ortadan ve sondan düğüm silme
    public boolean urunSil(int id) {
        if (bas == null) {
            return false;
        }

        // Silinecek ürün baştaysa
        if (bas.veri.getId() == id) {
            bas = bas.sonraki;
            return true;
        }

        // Silinecek ürün ortada veya sondaysa
        Dugum onceki = bas;
        Dugum mevcut = bas.sonraki;

        while (mevcut != null) {
            if (mevcut.veri.getId() == id) {
                onceki.sonraki = mevcut.sonraki;
                return true;
            }
            onceki = mevcut;
            mevcut = mevcut.sonraki;
        }

        return false;
    }

    // İlgili ürünün fiyat ve stok değerlerini günceller
    public boolean urunGuncelle(int id, double yeniFiyat, int yeniStok) {
        if (yeniFiyat < 0 || yeniStok < 0) {
            return false;
        }
        Urun bulunan = urunAraById(id);
        if (bulunan != null) {
            bulunan.setFiyat(yeniFiyat);
            bulunan.setStok(yeniStok);
            return true;
        }
        return false;
    }

    // true: ucuzdan pahalıya, false: pahalıdan ucuza sıralar
    public void fiyataGoreSirala(boolean artan) {
        if (bas == null || bas.sonraki == null) {
            return;
        }

        boolean degisti;
        do {
            degisti = false;
            Dugum mevcut = bas;
            while (mevcut.sonraki != null) {
                double fiyat1 = mevcut.veri.getFiyat();
                double fiyat2 = mevcut.sonraki.veri.getFiyat();

                boolean yerDegistirsinMi = artan ? (fiyat1 > fiyat2) : (fiyat1 < fiyat2);

                if (yerDegistirsinMi) {
                    Urun geciciUrun = mevcut.veri;
                    mevcut.veri = mevcut.sonraki.veri;
                    mevcut.sonraki.veri = geciciUrun;
                    degisti = true;
                }
                mevcut = mevcut.sonraki;
            }
        } while (degisti);
    }

    // Tüm ürünleri konsolda listeleme
    public void listele() {
        if (bas == null) {
            System.out.println("Ürün listesi boş.");
            return;
        }
        Dugum gecici = bas;
        while (gecici != null) {
            System.out.println(gecici.veri);
            gecici = gecici.sonraki;
        }
    }

}
