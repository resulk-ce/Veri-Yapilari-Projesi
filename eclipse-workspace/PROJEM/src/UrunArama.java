/ İsme göre arama yapıyorum, eşleşen bulamazsam null  dönüyorum
public Urun isimleAra(Urun[] urunler, int elemanSayisi, String arananIsim) {
    if (urunler == null || arananIsim == null) {
        return null;
    }
// IgnoreCase:farklılıkları yok sayarak bakma 
// .trim() : baş ve sondaki boşlukları temizleme 
    for (int i = 0; i < elemanSayisi; i++) {
        if (urunler[i] != null && urunler[i].getAd().equalsIgnoreCase(arananIsim.trim())) {
            return urunler[i]; // Bulursam ürünü veriyorum
        }
    }
    return null; // Bulamazsam boş dönüyorum
}

// ID'ye göre arama yapıyorum, yoksa yine null dönüyorum
public Urun idIleAra(Urun[] urunler, int elemanSayisi, String arananId) {
    if (urunler == null || arananId == null) {
        return null;
    }

    for (int i = 0; i < elemanSayisi; i++) {
        if (urunler[i] != null && urunler[i].getId().equalsIgnoreCase(arananId.trim())) {
            return urunler[i];
        }
    }
    return null; // Eşleşen ID yoksa boş dönüyorum
}

// Belirli fiyat aralığındaki ürünleri buluyorum
// Hiç ürün uymazsa boş dizi  dönüyorum
public Urun[] fiyataGoreFiltrele(Urun[] urunler, int elemanSayisi, double minFiyat, double maxFiyat) {
    if (urunler == null || elemanSayisi <= 0) {
        return new Urun[0]; 
        // return new kullanımı ise ; 0 elamanlı yeni bir ürün dizisi oşuştur
        // Liste yoksa direkt boş dizi dönüyorum
    }

    // Önce kaç tane uyan ürün var onu sayıyorum
    int sayac = 0;
    for (int i = 0; i < elemanSayisi; i++) {
        if (urunler[i] != null && urunler[i].getFiyat() >= minFiyat && urunler[i].getFiyat() <= maxFiyat) {
            sayac++;
        }
    }

    // Hiç uyan ürün bulamazsam boş dizi dönüyorum
    if (sayac == 0) {
        return new Urun[0];
    }

    // Uyan ürün sayısı kadar tam boyutlu dizi açıp içine atıyorum
    Urun[] bulunanlar = new Urun[sayac];
    int sira = 0;
    for (int i = 0; i < elemanSayisi; i++) {
        if (urunler[i] != null && urunler[i].getFiyat() >= minFiyat && urunler[i].getFiyat() <= maxFiyat) {
            bulunanlar[sira] = urunler[i];
            sira++;
        }
    }
    return bulunanlar;
}
