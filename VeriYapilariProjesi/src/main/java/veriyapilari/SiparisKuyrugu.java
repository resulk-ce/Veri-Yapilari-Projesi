package veriyapilari;

import varliklar.Siparis;

// siparişleri geliş sırasına göre ilk giren ilk çıkar mantığıyla tutmak için kuyruk sınıfını açtım
public class SiparisKuyrugu {

    // hazır koleksiyon yasak olduğu için kuyruğun her düğümünü tutacak iç sınıfı tanımladım
    private static class KuyrukDugum {
        Siparis veri;
        KuyrukDugum sonraki;

        // yeni düğüm oluşturulurken siparişi içine koyup sonraki bağlantısını boş bıraktım
        KuyrukDugum(Siparis veri) {
            this.veri = veri;
            this.sonraki = null;
        }
    }

    // kuyruğun en önündeki ve en arkasındaki elemanı gösteren işaretçileri tanımladım
    private KuyrukDugum front;
    private KuyrukDugum rear;
    private int boyut;

    // başlangıçta boş bir sipariş kuyruğu oluşturan kurucu metot
    public SiparisKuyrugu() {
        this.front = null;
        this.rear = null;
        this.boyut = 0;
    }

    // kuyruğun boş olup olmadığını kontrol eder
    public boolean bosMu() {
        return front == null;
    }

    // kuyrukta bekleyen toplam sipariş sayısını döndürür
    public int bekleyenSayisi() {
        return boyut;
    }

    // yeni verilen siparişi kuyruğun en sonuna ekler
    public void enqueue(Siparis yeniSiparis) {
        if (yeniSiparis == null) {
            return;
        }
        KuyrukDugum yeniDugum = new KuyrukDugum(yeniSiparis);
        // kuyruk tamamen boşsa hem ön hem arka işaretçi bu yeni düğümü gösterir
        if (bosMu()) {
            front = yeniDugum;
            rear = yeniDugum;
        } else {
            // kuyruk doluysa en arkadaki elemanın sonrasına bağlayıp arka işaretçiyi kaydırdım
            rear.sonraki = yeniDugum;
            rear = yeniDugum;
        }
        boyut++;
    }

    // sıradaki en eski siparişi kuyruğun başından çıkarıp döndürür
    public Siparis dequeue() {
        // kuyruk boşsa hata vermek yerine null döndürdüm
        if (bosMu()) {
            return null;
        }
        Siparis cikarilanSiparis = front.veri;
        // ön işaretçiyi bir sonraki siparişe kaydırdım
        front = front.sonraki;
        // kuyruktaki son eleman da çıktıysa arka işaretçiyi de sıfırladım
        if (front == null) {
            rear = null;
        }
        boyut--;
        return cikarilanSiparis;
    }

    // sıradaki ilk siparişi kuyruktan çıkarmadan sadece gösterir
    public Siparis peek() {
        if (bosMu()) {
            return null;
        }
        return front.veri;
    }

    // kuyrukta bekleyen tüm siparişleri baştan sona konsola yazdırır
    public void bekleyenSiparisleriListele() {
        if (bosMu()) {
            System.out.println("Bekleyen sipariş bulunmuyor.");
            return;
        }
        KuyrukDugum gecici = front;
        while (gecici != null) {
            System.out.println(gecici.veri.toString());
            gecici = gecici.sonraki;
        }
    }
}