package varliklar;
public class SepetElemani {
  
    private Urun urun;
    private int adet;


    public SepetElemani(Urun urun, int adet){
        this.urun=urun;
        this.adet=adet;
    }
public Urun getUrun(){
    return urun;
}
public void setUrun(Urun urun){
    this.urun=urun;
}
public int getAdet(){
    return adet;
}
public void setAdet(int adet){
    this.adet=adet;
}
public double araToplamHesapla(){
    return 0.0;

}
@Override
public String toString(){
    return "sepetElemani{adet=" + adet + "}";
}

}
