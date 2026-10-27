class UrunDugum{
	Urun urun;
	UrunDugum sol;//alfabetik olarak kökten(root) önce gelen ürünün olduğu taraf
	UrunDugum sag;//alfabetik olarak kökten(root) sonra gelen ürünün olduğu taraf

public UrunDugum(Urun urun){
	this.urun = urun;
	this.sol = null;//düğümü yeni oluşturduğum için henüz sol çocugu (child) yok o yüzden null
	this.sag = null;//düğümü yeni oluşturduğum için henüz sağ çocuğu (child) yok o yüzden null
 }
}
public class UrunEkleme {
	private UrunDugum kok;

    public UrunEkleme(){
		this.kok = null;//başlangıçta agaç boş olduğu için null
	}
public void ekle(Urun yeniUrun) {
	kok = ekleOzyinelemeli(kok, yeniUrun);//ürünü alıp A-Z sırasına göre agaçtaki dogru yerine yerleştirilmesini sağlar
	System.out.println("ürün başarıyla eklendi:" + yeniUrun.getAd());
}
//A-Z sıarasına göre dogru boş yeri arayan yardımcı kod
private UrunDugum ekleOzyinelemeli(UrunDugum mevcutKok, Urun yeniUrun) {
	//baktığımız yer boşsa yeni ürünü hemen buraya yerleştirmesini saglar
	if(mevcutKok == null){
		return new UrunDugum(yeniUrun);
	}
	//yeni ürünün adı baktıgımız üründen alfabetik olarak önce geliyorsa sola eklemesini sağlar
	if(yeniUrun.getAd().compareToIgnoreCase(mevcutKok.urun.getAd()) < 0){
		mevcutKok.sol = ekleOzyinelemeli(mevcutKok.sol,yeniUrun);
	}
	//yeni ürünün adı baktığımız üründe alfabetik olarak sonra geliyorsa sağa eklemesini sağlar
	else if (yeniUrun.getAd().compareToIgnoreCase(mevcutKok.urun.getAd()) > 0){
		mevcutKok.sag = ekleOzyinelemeli(mevcutKok.sag, yeniUrun);
	}
	return mevcutKok;//agacın son halini koruyarak geri döndürür
}
public UrunDugum getKok(){
	return kok;
}
//kullanıcının tüm listeyi alfabetik sırayla görmesini sağlar
public void kataloguYazdir(){
	System.out.println("\n--- ÜRÜN KATALOĞU (A-Z Sıralı) ---");
	kataloguYazdirOzyinelemeli(kok);
}
//agactaki ürünleri soldan sağa dogru alfabetik olarak yazar.
private void kataloguYazdirOzyinelemeli(UrunDugum mevcutKok){
if(mevcutKok != null){
	kataloguYazdirOzyinelemeli(mevcutKok.sol);
	System.out.println(mevcutKok.urun);
	kataloguYazdirOzyinelemeli(mevcutKok.sag);
  }
 }
}
