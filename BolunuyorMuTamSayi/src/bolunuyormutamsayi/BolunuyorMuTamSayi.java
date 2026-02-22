/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bolunuyormutamsayi;

/**
 *
 * @author UMUTCAN TUNÇ
 */
import java.util.Scanner;

public class BolunuyorMuTamSayi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner tarayici = new Scanner (System.in);
        System.out.println("*****1.SAYI,2.SAYININ BIR KATI MI?*****");
        
        System.out.print("1.sayiyi girin:");
        int sayi1 = tarayici.nextInt();
        
        System.out.print("2.sayiyi girin:");
        int sayi2 = tarayici.nextInt();
        
        if (sayi2 !=0) {
            
            if (BolunuyorMu(sayi1, sayi2)) {
                System.out.printf("%d, %d sayisini tam boler\n",sayi2,sayi1);
                System.out.printf("%d / %d = %d\n",sayi1,sayi2,sayi1/sayi2);
            }

            else {
                System.out.println("TAM BOLUNMEZ");
                System.out.printf("%d / %d = %.2f\n",sayi1,sayi2,(double)sayi1/sayi2);
            }
        }
        //sayi2'nin 0 olma durumu
        else {
            System.out.println("SIFIRA BOLME HATASI!");
        }
    }
    
    public static boolean BolunuyorMu(int s1,int s2) {
        return s1%s2==0;
    }
    
}
