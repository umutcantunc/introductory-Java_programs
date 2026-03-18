/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dizialciftleri2arttir;

/**
 *
 * @author UMUTCAN TUNÇ
 */

import java.util.Scanner;

public class DiziAlCiftleri2Arttir {

    public static void main(String[] args) {
        
        int[] asilDizi = DiziAl();
        int[] islenmisDizi = CiftleriIkiArttirKopyala(asilDizi);
        
        DiziYazdir("Orijinal dizi:",asilDizi);
        DiziYazdir("Ciftleri iki arttirilmis dizi:",islenmisDizi);
    }
    
    public static int[] DiziAl() {
        Scanner tarayici = new Scanner(System.in);
        
        System.out.printf("Dizi elemanlarini arada bir bosluk birakarak girin:");
        String satir = tarayici.nextLine();
        String[] metinParcalari = satir.split(" ");
        
        int[] sayiDizisi = new int[metinParcalari.length];
        
        for (int i=0;i<sayiDizisi.length;i++) {
            sayiDizisi[i] = Integer.parseInt(metinParcalari[i]);
        }
        
        return sayiDizisi;
    }
    
    public static int[] CiftleriIkiArttirKopyala(int[]orijinalDizi) {
        int[] yeniDizi = new int[orijinalDizi.length];
        
        for (int i=0;i<orijinalDizi.length;i++) {
            if (orijinalDizi[i]%2==0) {
                yeniDizi[i] = orijinalDizi[i] + 2;
            }
            else {
                yeniDizi[i] = orijinalDizi[i];
            }
        }
        
        return yeniDizi;
    }
    
    public static void DiziYazdir(String mesaj,int[]dizi) {
        System.out.print(mesaj); //dizinin ne oldugunu bilmek icin mesaj gonderimi
        for (int sayi : dizi) {
            System.out.print(sayi + " ");
        }
        System.out.println(); //alt satir gecis
    }    
    
    
}
