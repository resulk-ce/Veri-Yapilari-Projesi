package varliklar;

// müşterinin oluşturduğu siparişin bilgilerini tutmak için bu sınıfı açtım
public class Siparis {
    // kapsülleme kuralına uymak için değişkenleri private yaptım
    private int siparisId;
    private String musteriAdi;
    private String urunOzeti;
    private double toplamTutar;
    private String durum;

    // yeni sipariş oluştururken durumu otomatik bekliyor yapan kurucu metot
    public Siparis(int siparisId, String musteriAdi, String urunOzeti, double toplamTutar) {
        this.siparisId = siparisId;
        this.musteriAdi = guvenliMetin(musteriAdi);
        this.urunOzeti = guvenliMetin(urunOzeti);
        setToplamTutar(toplamTutar);
        this.durum = "Bekliyor";
    }

    // dosyadan eski siparişleri geri yüklerken kayıtlı durumuyla birlikte nesne olusturan ikinci kurucu
    public Siparis(int siparisId, String musteriAdi, String urunOzeti, double toplamTutar, String durum) {
        this.siparisId = siparisId;
        this.musteriAdi = guvenliMetin(musteriAdi);
        this.urunOzeti = guvenliMetin(urunOzeti);
        setToplamTutar(toplamTutar);
        setDurum(durum);
    }

    // dosyaya yazarken noktalı virgül yapısını bozmasın diye metni temizledim
    private String guvenliMetin(String metin) {
        if (metin == null) {
            return "";
        }
        return metin.replace(";", "").trim();
    }

    // sipariş numarasını döndürür
    public int getSiparisId() {
        return siparisId;
    }

    // sipariş numarasını günceller
    public void setSiparisId(int siparisId) {
        this.siparisId = siparisId;
    }

    // siparişi veren müşterinin adını döndürür
    public String getMusteriAdi() {
        return musteriAdi;
    }

    // müşteri adını temizleyip atar
    public void setMusteriAdi(String musteriAdi) {
        this.musteriAdi = guvenliMetin(musteriAdi);
    }

    // siparişteki ürünlerin özet metnini döndürür
    public String getUrunOzeti() {
        return urunOzeti;
    }

    // ürün özetini temizleyip atar
    public void setUrunOzeti(String urunOzeti) {
        this.urunOzeti = guvenliMetin(urunOzeti);
    }

    // siparişin toplam tutarını döndürür
    public double getToplamTutar() {
        return toplamTutar;
    }

    // tutar negatif girilirse hata olmasın diye en az sıfır yaptım
    public void setToplamTutar(double toplamTutar) {
        this.toplamTutar = Math.max(0.0, toplamTutar);
    }

    // siparişin son durumunu döndürür
    public String getDurum() {
        return durum;
    }

    // durum boş gelirse varsayılan olarak bekliyor atadım
    public void setDurum(String durum) {
        String temizDurum = guvenliMetin(durum);
        this.durum = temizDurum.isEmpty() ? "Bekliyor" : temizDurum;
    }

    // siparisler txt dosyasına yazılırken ortak formata uygun tek satır üretir
    public String toDosyaFormati() {
        return siparisId + ";" + musteriAdi + ";" + urunOzeti + ";" + toplamTutar + ";" + durum;
    }

    // konsolda sipariş özetini okunaklı gösterir
    @Override
    public String toString() {
        return "Sipariş #" + siparisId + " | Müşteri: " + musteriAdi + " | Ürünler: " + urunOzeti + " | Tutar: " + toplamTutar + " TL | Durum: " + durum;
    }
}