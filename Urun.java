package sepet;

import java.util.Objects;

/** Katalogdaki tek bir ürün. Kod, haritada anahtar olarak kullanılır. */
public final class Urun {
    private final String kod;
    private final String ad;
    private final String kategori;
    private final double fiyat;

    public Urun(String kod, String ad, String kategori, double fiyat) {
        if (kod == null || kod.isBlank()) {
            throw new IllegalArgumentException("Ürün kodu boş olamaz.");
        }
        if (ad == null || ad.isBlank()) {
            throw new IllegalArgumentException("Ürün adı boş olamaz.");
        }
        if (kategori == null || kategori.isBlank()) {
            throw new IllegalArgumentException("Kategori boş olamaz.");
        }
        if (fiyat < 0) {
            throw new IllegalArgumentException("Fiyat negatif olamaz.");
        }
        this.kod = kod.trim().toUpperCase();
        this.ad = ad.trim();
        this.kategori = kategori.trim();
        this.fiyat = fiyat;
    }

    public String kod() {
        return kod;
    }

    public String ad() {
        return ad;
    }

    public String kategori() {
        return kategori;
    }

    public double fiyat() {
        return fiyat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Urun urun)) {
            return false;
        }
        return kod.equals(urun.kod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kod);
    }

    @Override
    public String toString() {
        return kod + "  " + ad + "  (" + kategori + ")  " + Para.yaz(fiyat);
    }
}
