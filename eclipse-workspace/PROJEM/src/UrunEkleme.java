class UrunDugum{
	Urun urun;
	UrunDugum sol;
	UrunDugum sag;

public UrunDugum(Urun urun){
	this.urun = urun;
	this.sol = null;
	this.sag = null;
 }
}
public class UrunEkleme {
	private UrunDugum kok;

    public UrunEkleme(){
		this.kok = null;
	}
public void ekle(Urun yeniUrun) {
	kok = ekleOzyinelemeli(kok, yeniUrun);
	System.out.println("ürün başarıyla eklendi:" + yeniUrun.getAd());
}

private UrunDugum ekleOzyinelemeli(UrunDugum mevcutKok, Urun yeniUrun) {
	if(mevcutKok == null){
		return new UrunDugum(yeniUrun);
	}
	if(yeniUrun.getAd().compareToIgnoreCase(mevcutKok.urun.getAd()) < 0){
		mevcutKok.sol = ekleOzyinelemeli(mevcutKok.sol,yeniUrun);
	}
	else if (yeniUrun.getAd().compareToIgnoreCase(mevcutKok.urun.getAd()) > 0){
		mevcutKok.sag = ekleOzyinelemeli(mevcutKok.sag, yeniUrun);
	}
	return mevcutKok;
}
public UrunDugum getKok(){
	return kok;
}
public void kataloguYazdir(){
	System.out.println("\n--- ÜRÜN KATALOĞU (A-Z Sıralı) ---");
	kataloguYazdirOzyinelemeli(kok);
}
private void kataloguYazdirOzyinelemeli(UrunDugum mevcutKok){
if(mevcutKok != null){
	kataloguYazdirOzyinelemeli(mevcutKok.sol);
	System.out.println(mevcutKok.urun);
	kataloguYazdirOzyinelemeli(mevcutKok.sag);
  }
 }
}
