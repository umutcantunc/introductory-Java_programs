/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package asalsayitespitfonksiyonu;

/**
 *
 * @author UMUTCAN TUNÇ
 */
import java.util.Scanner;
public class AsalSayiTespitFonksiyonu {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        Scanner tarayici = new Scanner(System.in);
        
        while (true) {
            System.out.print("Asal olup olmadigini gormek icin bir sayi girin(Cikmak icin 0 giriniz):");
            int sayi = tarayici.nextInt();
            if (sayi==0) {
                System.out.println("Cikis yapiliyor...");
                break;
            }
            if (AsalSayiMi(sayi)) {
                System.out.println(sayi+" bir asal sayidir.");
            }
            else {
                System.out.println(sayi+" bir asal sayi DEGILDIR.");
            }
        }
    }
    public static boolean AsalSayiMi(int sayi) {
        
        if (sayi<=1) {
            return false;
        }
        
        if (sayi==2) {
            return true;
        }
        
        for (int i=2;i<=sayi/2;i++) {
            if (sayi%i==0) { //eger kalansız bolunuyorsa
                return false; //asal degıldır
            }
        }     
        
        return true; //for sonrasında buraya gırecek
    }
    
    
    
}
