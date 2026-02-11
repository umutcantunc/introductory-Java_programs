/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package vucutkutleendeksihesaplama;

/**
 *
 * @author UMUTCAN TUNÇ
 */

import java.util.Scanner;
import java.util.Locale;

public class VucutKutleEndeksiHesaplama {

    public static void main(String[] args) {
        Scanner tarayici = new Scanner(System.in);
        tarayici.useLocale(Locale.US); //ondalikli sayilari nokta ile de girebilmek icin
        
        System.out.println("Kilonuzu kilogram olarak girin:");
        double kilo = tarayici.nextDouble();
        
        System.out.println("Boyunuzu metre olarak girin:");
        double boy = tarayici.nextDouble();
        
        System.out.println("Kilonuz:"+kilo);
        System.out.println("Boyunuz:"+boy);
        
        double endeks = kilo / (boy * boy);
        
        System.out.println("Vucut Kutle Endeksiniz:"+endeks);
        if (endeks < 18.5) {
            System.out.println("Zayif");
        }
        else if (endeks < 24.9) {
            System.out.println("Normal");
        }
        else if (endeks < 29.9) {
            System.out.println("Fazla Kilolu");
        }
        else {
            System.out.println("Obez");
        }
    }       
}