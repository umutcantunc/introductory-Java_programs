/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package esayisinihesaplama;

/**
 *
 * @author UMUTCAN TUNÇ
 */
import java.util.Scanner;
public class ESayisiniHesaplama {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner tarayici = new Scanner(System.in);
        System.out.print("e uzeri kac hesaplansin?:"); //x belirleme
        int e_uzeri = tarayici.nextInt();
        System.out.print("Hesaplama siniri ne olsun?(Sinir arttikca degere daha cok yaklasilir):");
        int hesaplama_siniri = tarayici.nextInt();
        
        System.out.printf("%d sinirina gore e uzeri %d = %f\n"
                ,hesaplama_siniri,e_uzeri,eDegeriniHesapla(hesaplama_siniri, e_uzeri));
    
    }
    
    public static double eDegeriniHesapla(int n,int x) { //n sinir, x üssü
        double sonuc = 0;
        
        for (int i=0;i<n;i++) {
            sonuc += (double) xUzeri(x,i) / Faktoriyel(i) ; // / faktoriyel gelecek
        }
        return sonuc;   
    }
    
    public static int xUzeri(int tabanX,int ussu_i) { //buradaki x üssünü hesaplayacagız
        int taban_sonuc = 1;
        
        if (ussu_i==0) {
            return taban_sonuc;
        }
        
        for (int i =1;i<=ussu_i;i++) {
            taban_sonuc *= tabanX;
        }
        return taban_sonuc;
    }
    
    public static int Faktoriyel(int n) {
        int faktoriyel_sonuc = 1;
        //n=0,1 icin for'a girmez direkt return'e gider.
        for (int i=2;i<=n;i++) {
            faktoriyel_sonuc *= i;
        }
        
        return faktoriyel_sonuc; 
    }
}
