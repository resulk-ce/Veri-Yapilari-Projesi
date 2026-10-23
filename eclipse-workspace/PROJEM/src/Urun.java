import java.io.BufferedReader;

/**
 * =====================================================================
 * ORTAK VERİ MODELİ: Urun Sınıfı
 * =====================================================================
 * Sistemdeki her bir ürünün özelliklerini (ID, ad, fiyat, stok) tutar.
 * Veritabanı kullanılmadığı için ürünlerin dosyaya yazılabilmesi amacıyla
 * toString() metodu CSV formatına (`id,ad,fiyat,stok`) uyarlanmıştır.
 */
public class Urun {
    private String id;
    private String ad;
    private double fiyat;
    private int stok;

    public Urun(String id, String ad, double fiyat, int stok) {
        this.id = id;
        this.ad = ad;
        this.fiyat = fiyat;
        this.stok = stok;
    }

    public String getId() { return id; }
    public String getAd() { return ad; }
    public double getFiyat() { return fiyat; }
    public int getStok() { return stok; }
    public void setStok(int stok) { this.stok = stok; }

    /**
     * Ürün nesnesini metin dosyasına yazabilmek için virgüllü formata çevirir.
     */
    @Override
    public String toString() {
        return id + "," + ad + "," + fiyat + "," + stok;
    }
}
