Satış ve Alışveriş Sepeti Uygulaması (VeriYapilariProjesi)

Veri Yapıları dersi dönem projesi olarak geliştirdiğimiz masaüstü satış ve alışveriş sepeti uygulamasıdır. Projede Java'nın hazır `ArrayList`, `LinkedList`, `Stack` veya `Queue` sınıfları kullanılmamış, tüm veri yapıları kendi düğüm (`Node`) yapılarımızla sıfırdan yazılmıştır.

Kullanılan Teknolojiler
Dil: Java
Arayüz:Java Swing
Proje Yapısı: Apache Maven (NetBeans IDE)
Veri Kaydı: Metin dosyaları (`.txt` formatında, `;` ayırıcılı yapı)

Ekip Üyeleri ve İş Bölümü
Resul Kızıltaş (`resulk-ce`): `Urun` ve `BagliListe` sınıfları (ürün ekleme, ID ve isimle arama, silme, fiyat/stok güncelleme, fiyata göre sıralama) ve `VeriYapilariProjesi` ana test sınıfı.
Fatmanur Bakırcı (`fatmanurbkrc`):`SepetElemani` ve `Sepet` sınıfları (sepete ürün ekleme, stok kontrolü, adet güncelleme, sepetten ürün çıkarma ve toplam tutar hesaplama).
Muhammed Fatih Dündar (`fatih-dndr02`): `Kullanici`, `Siparis`, `SiparisKuyrugu` (sipariş sırası) ve `IslemYigini` (işlem geçmişi) sınıfları.
Zeki Aslan (`ZekiAslan21`): `DosyaYoneticisi` sınıfı (verilerin `.txt` dosyalarına kaydedilmesi ve uygulama açılışında dosyadan okunması).

 Projenin Temel İşlevleri
* Ürün kataloğuna yeni ürün ekleme, ürün silme, fiyat/stok güncelleme, ID veya isme göre arama ve fiyata göre sıralama.
* Kullanıcı kaydı ve giriş kontrolü.
* Sepete ürün ekleme, sepetteki ürün adedini değiştirme, sepetten çıkarma ve toplam tutarı görme.
* Verilen siparişlerin sıraya alınması ve sırayla işlenmesi.
* Kullanıcının yaptığı son işlemlerin geçmiş olarak listelenmesi.
* Ürün, kullanıcı ve sipariş verilerinin program kapandığında dosyaya kaydedilip açılışta geri yüklenmesi.

Kullanılan Veri Yapıları ve Tercih Nedenleri

Tek Yönlü Bağlı Liste (`BagliListe` ve `Sepet`): Ürün listesi ve sepetteki ürün sayısı sürekli değiştiği için sabit boyutlu dizi yerine bağlı liste tercih ettik. Dinamik düğüm yapısı sayesinde baştan, ortadan ve sondan ekleme-silme işlemleri bellek israfı olmadan yapılabiliyor.
Kuyruk - FIFO (`SiparisKuyrugu`): Müşterilerin oluşturduğu siparişlerin geliş sırasına göre (ilk gelen ilk işlenir mantığıyla) hazırlanması gerektiği için kuyruk yapısı kullandık. `front` ve `rear` işaretçileri ile ekleme ve çıkarma işlemlerini listeyi baştan sona gezmeden yapabiliyoruz.
Yığın - LIFO (`IslemYigini`): Kullanıcının yaptığı son işlemleri en yeniden eskiye doğru görebilmesi ve son işlemi takip edebilmesi için son giren ilk çıkar mantığıyla çalışan yığın yapısını seçtik.

 Temel Sınıf ve Düğüm Yapıları Taslağı

text
Urun
- id: int, ad: String, kategori: String, fiyat: double, stok: int
+ stokDus(), stokEkle(), toDosyaFormati()

BagliListe -> Dugum (veri: Urun, sonraki: Dugum)
- bas: Dugum
+ ekle(), urunAraById(), urunAraByAd(), urunSil(), urunGuncelle(), fiyataGoreSirala()

Sepet -> SepetElemani (urun: Urun, adet: int, sonraki: SepetElemani)
- bas: SepetElemani
+ sepeteEkle(), sepettenCikar(), adetGuncelle(), toplamTutar()

SiparisKuyrugu -> SiparisDugum (siparis: Siparis, sonraki: SiparisDugum)
- front: SiparisDugum, rear: SiparisDugum
+ enqueue(), dequeue(), peek(), bekleyenSiparisleriListele()

IslemYigini -> YiginDugum (islem: String, sonraki: YiginDugum)
- top: YiginDugum
+ push(), pop(), peek(), gecmisiListele()
