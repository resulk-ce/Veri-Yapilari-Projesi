/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package veriyapilari;


 import varliklar.Urun;
public class BagliListe {
   


    private class Dugum {
        Urun veri;
        Dugum sonraki;

        Dugum(Urun veri) {
            this.veri = veri;
            this.sonraki = null;
        }
    }

    private Dugum bas;

    public void ekle(Urun veri) {
        Dugum yeni = new Dugum(veri);
        if (bas == null) {
            bas = yeni;
        } else {
            Dugum gecici = bas;
            while (gecici.sonraki != null) {
                gecici = gecici.sonraki;
            }
            gecici.sonraki = yeni;
        }
    }

    public void listele() {
        Dugum gecici = bas;
        while (gecici != null) {
            System.out.println(gecici.veri);
            gecici = gecici.sonraki;
        }
    }

}
