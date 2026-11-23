package varliklar;


// sipariş saatini ve tarihini sistemden otomatik çekebilmek için ekledim (hazır zaman kütüphanesi)
import java.time.LocalDateTime;
// aldığım tarihi gün ay yıl saat formatına çevirmek için ekledim (tarih biçimlendirici)
import java.time.format.DateTimeFormatter;
// sipariş kalemlerini tutacak dinamik liste yapısı için ekledim (boyutu otomatik büyüyen dizi)
import java.util.ArrayList;
// liste arayüzünü kullanabilmek için ekledim (arraylist yapısının üst şablonu)
import java.util.List;



// müşterinin verdiği siparişin genel bilgilerini ve içindeki ürünleri tutmak için açtım
public class Siparis {
    // kapsülleme için tüm alanları private tanımladım
    private int siparisId;
    private String kullaniciAdi;
    private List<SiparisKalemi> kalemler;
    private double toplamTutar;
    private String tarih;
    private String durum;

    // yeni sipariş oluşturulurken o anki tarihi otomatik alıp durumu hazırlanıyor yaptım
    public Siparis(int siparisId, String kullaniciAdi) {
        this.siparisId = siparisId;
        this.kullaniciAdi = guvenliMetin(kullaniciAdi);
        this.kalemler = new ArrayList<>();
        this.toplamTutar = 0.0;
        this.tarih = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
        this.durum = "HAZIRLANIYOR";
    }

    // dosyadan eski siparişleri geri okurken tüm bilgileriyle nesne oluşturmak için ikinci kurucu
    public Siparis(int siparisId, String kullaniciAdi, List<SiparisKalemi> kalemler, String tarih, String durum) {
        this.siparisId = siparisId;
        this.kullaniciAdi = guvenliMetin(kullaniciAdi);
        this.kalemler = (kalemler != null) ? new ArrayList<>(kalemler) : new ArrayList<>();
        this.tarih = guvenliMetin(tarih);
        this.durum = guvenliMetin(durum).isEmpty() ? "HAZIRLANIYOR" : guvenliMetin(durum);
        toplamiGuncelle();
    }

    // dosyaya yazarken noktalı virgül yapısını bozmasın diye temizlik yapar
    private String guvenliMetin(String metin) {
        if (metin == null) {
            return "";
        }
        return metin.replace(";", "").trim();
    }

    // siparişe yeni bir ürün satırı ekleyip toplam tutarı otomatik günceller
    public void kalemEkle(SiparisKalemi kalem) {
        if (kalem != null) {
            this.kalemler.add(kalem);
            toplamiGuncelle();
        }
    }

    // listedeki tüm ürünlerin ara toplamını gezip genel toplamı hesaplar
    public void toplamiGuncelle() {
        double toplam = 0.0;
        for (SiparisKalemi kalem : kalemler) {
            toplam += kalem.araToplamHesapla();
        }
        this.toplamTutar = toplam;
    }

    // sipariş numarasını döndürür
    public int getSiparisId() {
        return siparisId;
    }

    // sipariş numarasını günceller
    public void setSiparisId(int siparisId) {
        this.siparisId = siparisId;
    }

    // siparişi veren kullanıcının adını döndürür
    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    // kullanıcı adını temizleyip günceller
    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = guvenliMetin(kullaniciAdi);
    }

    // siparişteki tüm ürün kalemlerini liste olarak döndürür
    public List<SiparisKalemi> getKalemler() {
        return kalemler;
    }

    // ürün kalemi listesini dışarıdan set edip toplamı yeniden hesaplar
    public void setKalemler(List<SiparisKalemi> kalemler) {
        this.kalemler = (kalemler != null) ? kalemler : new ArrayList<>();
        toplamiGuncelle();
    }

    // siparişin toplam tutarını döndürür
    public double getToplamTutar() {
        return toplamTutar;
    }

    // sipariş tarihini döndürür
    public String getTarih() {
        return tarih;
    }

    // sipariş tarihini günceller
    public void setTarih(String tarih) {
        this.tarih = guvenliMetin(tarih);
    }

    // siparişin son durumunu döndürür
    public String getDurum() {
        return durum;
    }

    // sipariş durumunu günceller
    public void setDurum(String durum) {
        this.durum = guvenliMetin(durum);
    }

    // tüm siparişi ve içindeki kalemleri tek satır halinde dosyaya yazılacak formata çevirir
    public String toDosyaFormati() {
        StringBuilder kalemMetni = new StringBuilder();
        for (int i = 0; i < kalemler.size(); i++) {
            kalemMetni.append(kalemler.get(i).toDosyaFormati());
            if (i < kalemler.size() - 1) {
                kalemMetni.append("|");
            }
        }
        return siparisId + ";" + kullaniciAdi + ";" + toplamTutar + ";" + tarih + ";" + durum + ";" + kalemMetni;
    }

    // konsolda veya listede sipariş özetini okunaklı gösterir
    @Override
    public String toString() {
        return "Sipariş #" + siparisId + " | Müşteri: " + kullaniciAdi + " | Tutar: " + toplamTutar + " TL | Durum: " + durum;
    }
}