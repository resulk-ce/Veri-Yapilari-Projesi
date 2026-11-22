/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.veriyapilariprojesi;


import varliklar.Urun;
import veriyapilari.BagliListe;
/**
 *
 * @author Resul KIZILTAŞ
 */
public class VeriYapilariProjesi {

    public static void main(String[] args) {
        


        BagliListe sepet = new BagliListe();

        sepet.ekle(new Urun(1, "Kulaklık", 1500.0, 10));
        sepet.ekle(new Urun(2, "Klavye", 2200.0, 5));

        System.out.println("--- Test Başarılı ---");
        sepet.listele();
    }
}
    

