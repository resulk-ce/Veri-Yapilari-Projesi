/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package varliklar;

/**
 *
 * @author Resul KIZILTAŞ
 */
public class Urun {
    


    private int id;
    private String ad;
    private double fiyat;
    private int stok;

    public Urun(int id, String ad, double fiyat, int stok) {
        this.id = id;
        this.ad = ad;
        this.fiyat = fiyat;
        this.stok = stok;
    }

    @Override
    public String toString() {
        return id + " - " + ad + " (" + fiyat + " TL) | Stok: " + stok;
    }
}

