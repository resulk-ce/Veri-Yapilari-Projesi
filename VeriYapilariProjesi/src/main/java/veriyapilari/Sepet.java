package veriyapilari;
import varliklar.SepetElemani;
import varliklar.Urun;

public class Sepet{
    private class SepetDugum{
        SepetElemani veri;
        SepetDugum sonraki;
    public SepetDugum(SepetElemani veri){
        this.veri=veri;
        this.sonraki=null;
    }   
  }
  private SepetDugum head;

  public Sepet(){
    this.head=null;

  }
  public void sepeteEkle(Urun urun,int adet){
    //stok kontrolu ve bagli listeye ekleme mantıgı yazılacak
  }
  public void adetGuncelle(int urunId,int yeniAdet){
    //ID ye göre urun bulup adet guncelleme mantıgı yazılacak
  }
  public void sepettenCikar(int urunId){
    // bastan ortadan ve sondan dugum silme mantıgı yazılacak
  }
  public double toplamTutar(){
    //sepetteki tum elemanların ara toplami hesaplanacak
    return 0.0;
  }
  public void sepetiListele(){
    //bagli liste dolasilarak sepet icerigi yazdırılacak
  }
  public void sepetiTemizle(){
    this.head=null;
  }
}
