/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calisanucrethesaplama;

/**
 *
 * @author UMUTCAN TUNÇ
 */
import java.util.Scanner;
import java.util.Locale;

public class CalisanUcretHesaplama {
    public static void main(String[] args) {
        Scanner tarayici = new Scanner (System.in);
        tarayici.useLocale(Locale.US); //ondalikli sayilari nokta ile de girebilmek icin
        
        System.out.print("Normal haftalik mesai saat sinirini belirleyin:");
        int saat_siniri = tarayici.nextInt();
        
        System.out.print("Calisanin haftalik calisma saatini girin:");  
        int calisma_saati = tarayici.nextInt();
        
        System.out.print("Calisanin saatlik ucretini girin:");  
        int saatlik_ucret = tarayici.nextInt();
        
        System.out.print("Calisanin ekstra mesai olursa saatlik ucretini girin:");  
        int saatlik_ucret_mesai = tarayici.nextInt();
        int maas;
        if (calisma_saati<=saat_siniri) {
            maas = calisma_saati * saatlik_ucret; 
        }
                
        else {
            maas = (saat_siniri * saatlik_ucret) + (calisma_saati - saat_siniri) * saatlik_ucret_mesai;
        }
        
        
        System.out.println("Calisanin maasi:"+ maas); 
    }
    
}
