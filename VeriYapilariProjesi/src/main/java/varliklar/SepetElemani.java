package varliklar;
public class SepetElemani {
  
    private Urun urun;
    private int adet;


    public SepetElemani(Urun urun, int adet){
        this.urun=urun;
        this.adet=adet;
    }
// sepet kalemindeki ürün  nesnesini döndürür
public Urun getUrun(){
    return urun;
}
//sepet kalemindeki ürün nesnesini günceller
public void setUrun(Urun urun){
    this.urun=urun;
}
//ürünün sepetteki adedini döndürür
public int getAdet(){
    return adet;
}
//ürünün sepetteki adedini günceller
public void setAdet(int adet){
    this.adet=adet;
}
//ürünün birim fiyatı ile adedini çarparak ara toplam tutarını hesaplar
public double araToplamHesapla(){
    //ürün sınıfına getFiyat() metodu eklendiğinde urun.getFiyat()* adet olarak güncellenecek

    return 0.0;

}
//konsolda sepet içeriği listelenirken ürün bilgilerini okunaklı formatta döndürür

@Override
public String toString(){
    return "sepetElemani{adet=" + adet + "}";
}

}
