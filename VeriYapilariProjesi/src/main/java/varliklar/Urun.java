
package varliklar;


public class Urun {
    


   private int id;
    private String ad;
    private String kategori;
    private double fiyat;
    private int stok;

    public Urun(int id, String ad, String kategori, double fiyat, int stok) {
        this.id = id;
        this.ad = ad;
        this.kategori = kategori;
        this.fiyat = fiyat;
        this.stok = stok;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public double getFiyat() {
        return fiyat;
    }

    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    // Stok eksiye düşmeyecek şekilde kontrol yapar
    public boolean stokDus(int adet) {
        if (adet <= 0 || this.stok < adet) {
            return false;
        }
        this.stok -= adet;
        return true;
    }

    // Negatif veya sıfır değerleri reddeder
    public boolean stokEkle(int adet) {
        if (adet <= 0) {
            return false;
        }
        this.stok += adet;
        return true;
    }

    // Örnek çıktı: 101;Klavye;Elektronik;850.0;15
    public String toDosyaFormati() {
        return id + ";" + ad + ";" + kategori + ";" + fiyat + ";" + stok;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Ürün: " + ad + " | Kategori: " + kategori
                + " | Fiyat: " + fiyat + " TL | Stok: " + stok;
    }
}

