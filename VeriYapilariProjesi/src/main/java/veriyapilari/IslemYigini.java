package veriyapilari;

// yapılan son işlemleri takip etmek ve geri almak için son giren ilk çıkar mantığıyla yığın açtım
public class IslemYigini {

    // yığındaki her bir işlem açıklamasını tutacak iç düğüm sınıfını tanımladım
    private static class YiginDugum {
        String islemAciklamasi;
        YiginDugum sonraki;

        // yeni düğüm oluşturulurken işlem metnini içine alıp alt bağlantısını boş bıraktım
        YiginDugum(String islemAciklamasi) {
            this.islemAciklamasi = islemAciklamasi;
            this.sonraki = null;
        }
    }

    // yığının en tepesindeki son işlemi gösteren işaretçi
    private YiginDugum top;
    private int boyut;

    // başlangıçta boş bir işlem yığını oluşturan kurucu metot
    public IslemYigini() {
        this.top = null;
        this.boyut = 0;
    }

    // yığının boş olup olmadığını kontrol eder
    public boolean bosMu() {
        return top == null;
    }

    // yığındaki toplam işlem sayısını döndürür
    public int boyut() {
        return boyut;
    }

    // yapılan yeni işlemi yığının en tepesine ekler
    public void push(String islemAciklamasi) {
        if (islemAciklamasi == null || islemAciklamasi.trim().isEmpty()) {
            return;
        }
        YiginDugum yeniDugum = new YiginDugum(islemAciklamasi);
        // yeni düğümü mevcut tepe elemanın üstüne koyup tepe işaretçisini güncelledim
        yeniDugum.sonraki = top;
        top = yeniDugum;
        boyut++;
    }

    // en son yapılan işlemi yığının tepesinden çıkarıp geri döndürür
    public String pop() {
        // yığın boşsa hata vermek yerine null döndürdüm
        if (bosMu()) {
            return null;
        }
        String cikarilanIslem = top.islemAciklamasi;
        // tepe işaretçisini bir alttaki düğüme indirdim
        top = top.sonraki;
        boyut--;
        return cikarilanIslem;
    }

    // en son yapılan işlemi yığından çıkarmadan sadece gösterir
    public String peek() {
        if (bosMu()) {
            return null;
        }
        return top.islemAciklamasi;
    }

    // geçmiş işlemleri en yeniden en eskiye doğru konsola yazdırır
    public void gecmisiListele() {
        if (bosMu()) {
            System.out.println("Henüz kaydedilmiş işlem geçmişi yok.");
            return;
        }
        YiginDugum gecici = top;
        int sira = 1;
        while (gecici != null) {
            System.out.println(sira + ". " + gecici.islemAciklamasi);
            gecici = gecici.sonraki;
            sira++;
        }
    }
}
