package varliklar;

// sipariş içindeki her bir ürün satırını ve miktarını tutmak için bu sınıfı açtım
public class SiparisKalemi {
    // dışarıdan direkt değiştirilmesin diye değişkenleri private yaptım
    private Urun urun;
    private int urunId;
    private String urunAdi;
    private double birimFiyat;
    private int adet;

    // ürün nesnesi olmadan direkt bilgilerle kalem oluşturmak için kurucu metot
    public SiparisKalemi(int urunId, String urunAdi, double birimFiyat, int adet) {
        this.urunId = urunId;
        this.urunAdi = guvenliMetin(urunAdi);
        setBirimFiyat(birimFiyat);
        setAdet(adet);
    }

    // hem ürün nesnesini hem de o anki fiyat bilgisini birlikte tutmak için ikinci kurucu metot
    public SiparisKalemi(Urun urun, int urunId, String urunAdi, double birimFiyat, int adet) {
        this.urun = urun;
        this.urunId = urunId;
        this.urunAdi = guvenliMetin(urunAdi);
        setBirimFiyat(birimFiyat);
        setAdet(adet);
    }

    // dosyaya kaydederken ayraç karakterleri karışmasın diye metni temizledim
    private String guvenliMetin(String metin) {
        if (metin == null) {
            return "";
        }
        return metin.replace(";", "").replace("|", "").trim();
    }

    // ürün nesnesini döndürür
    public Urun getUrun() {
        return urun;
    }

    // ürün nesnesini günceller
    public void setUrun(Urun urun) {
        this.urun = urun;
    }

    // ürünün id numarasını döndürür
    public int getUrunId() {
        return urunId;
    }

    // ürünün id numarasını günceller
    public void setUrunId(int urunId) {
        this.urunId = urunId;
    }

    // ürünün adını döndürür
    public String getUrunAdi() {
        return urunAdi;
    }

    // ürün adını temizleyip atar
    public void setUrunAdi(String urunAdi) {
        this.urunAdi = guvenliMetin(urunAdi);
    }

    // ürünün birim fiyatını döndürür
    public double getBirimFiyat() {
        return birimFiyat;
    }

    // fiyat eksi girilirse hata olmasın diye en az sıfır yaptım
    public void setBirimFiyat(double birimFiyat) {
        this.birimFiyat = Math.max(0.0, birimFiyat);
    }

    // ürünün kaç adet alındığını döndürür
    public int getAdet() {
        return adet;
    }

    // adet sıfır veya eksi girilirse en az bir olsun diye kontrol koydum
    public void setAdet(int adet) {
        this.adet = Math.max(1, adet);
    }

    // birim fiyat ile adeti çarpıp bu satırın toplam tutarını hesaplar
    public double araToplamHesapla() {
        return birimFiyat * adet;
    }

    // siparişler txt dosyasına yazarken satırı düzenli formata çevirir
    public String toDosyaFormati() {
        return urunId + ":" + urunAdi + ":" + birimFiyat + ":" + adet;
    }

    // ekranda yazdırırken okunaklı çıktı verir
    @Override
    public String toString() {
        return urunAdi + " x" + adet + " (" + araToplamHesapla() + " TL)";
    }
}