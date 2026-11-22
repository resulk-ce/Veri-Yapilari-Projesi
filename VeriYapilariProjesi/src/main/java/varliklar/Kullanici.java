package varliklar;

public class Kullanici {

    private String kullaniciAdi;
    private String sifre;
    private String rol;

    public Kullanici(String kullaniciAdi, String sifre, String rol){
        setKullaniciAdi(kullaniciAdi);
        setSifre(sifre);
        setRol(rol);
    }
    private String guvenliMetin(String metin) {
        if (metin == null) {
            return "";
        }
        return metin.replace(",","").trim();
    }
    public String getKullaniciAdi(){
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = guvenliMetin(kullaniciAdi);
    }

    public String getSifre(){
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = guvenliMetin(sifre);
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        String temizRol = guvenliMetin(rol).toUpperCase();
        if (temizRol.equals("ADMIN") || temizRol.equals("MUSTERI")) {
            this.rol = temizRol;
        } else {
            this.rol = "MUSTERI";
        }
    }

    public boolean sifreDogrula(String girilenSifre){
        return this.sifre !=null && this.sifre.equals(girilenSifre);
    }

    public String toDosyaFormati() {
        return  kullaniciAdi + ";" + sifre + ";" + rol;
    }
    @Override
    public String toString(){
        return "Kullanıcı: " + kullaniciAdi + " [" + rol + "]";
    }

}