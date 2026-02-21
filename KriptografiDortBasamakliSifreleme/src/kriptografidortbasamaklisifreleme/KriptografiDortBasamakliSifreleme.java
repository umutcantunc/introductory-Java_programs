/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package kriptografidortbasamaklisifreleme;

/**
 *
 * @author UMUTCAN TUNÇ
 */
import java.util.Scanner;

public class KriptografiDortBasamakliSifreleme {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner tarayici = new Scanner(System.in);

        while (true) {

            System.out.print("""
                             (Mesajlar 4 basamakli tam sayilardir)
                             Mesaj gondermek icin 1
                             Mesaj okumak icin 2
                             Cikis icin 0'a basiniz:""");
            int secici = tarayici.nextInt();

            if (secici == 0) {
                System.out.println("Cikis yapiliyor...");
                break;
            }

            int mesaj_gonder;
            if (secici == 1) {
                while (true) {
                    System.out.print("Gondermek istediginiz 4 basamakli mesaji girin: ");
                    mesaj_gonder = tarayici.nextInt();

                    // Sayı 1000'den küçük veya 9999'dan büyükse hata ver
                    if (mesaj_gonder < 1000 || mesaj_gonder > 9999) {
                        System.out.println("Hata: Lutfen sadece 4 basamakli bir sayi giriniz!\n");
                    } else {
                        // Sayı doğru aralıktaysa döngüyü kır ve işleme devam et
                        break;
                    }
                }
                int[] rakamlar_gonderilen = new int[4];
                for (int i = 3; i >= 0; i--) {
                    rakamlar_gonderilen[i] = mesaj_gonder % 10; //son rakami aldik
                    mesaj_gonder = mesaj_gonder / 10; //son rakami attik
                } //dongu sonunda dizi sayinin binler basamagından birlere kadar oldu.

                int[] sifreli_mesaj = new int[4];
                for (int i = 0; i < 4; i++) {
                    sifreli_mesaj[i] = (rakamlar_gonderilen[i] + 7) % 10;
                }
                int gecici_1ile3, gecici_2ile4;

                gecici_1ile3 = sifreli_mesaj[0];
                sifreli_mesaj[0] = sifreli_mesaj[2];
                sifreli_mesaj[2] = gecici_1ile3; //1 ile 3 degisti

                gecici_2ile4 = sifreli_mesaj[1];
                sifreli_mesaj[1] = sifreli_mesaj[3];
                sifreli_mesaj[3] = gecici_2ile4; //2 ile 4 degisti

                int gosterilecek_sifreli_mesaj = 0;
                for (int i = 0; i < 4; i++) {
                    gosterilecek_sifreli_mesaj += sifreli_mesaj[i] * (int) Math.pow(10, 3 - i);
                }
                System.out.printf("%04d sifrelenmis mesaji gonderildi.\n\n", gosterilecek_sifreli_mesaj); //bastaki 0 gozuksun diye
                continue;
            }

            int mesaj_al;
            int gecici_1ile3, gecici_2ile4;
            if (secici == 2) {

                while (true) {
                    System.out.print("Okumak istediginiz 4 basamakli mesaji girin: ");
                    mesaj_al = tarayici.nextInt();

                    // Sayı 0'dan küçük veya 9999'dan büyükse hata ver, 0189 gibi sifrelerde calısması ıcın sınırı 0 yaptık
                    if (mesaj_al < 0 || mesaj_al > 9999) {
                        System.out.println("Hata: Lutfen sadece 4 basamakli bir sayi giriniz!\n");
                    } else {
                        // Sayı doğru aralıktaysa döngüyü kır ve işleme devam et
                        break;
                    }
                }

                int[] rakamlar_gonderilen = new int[4];
                for (int i = 3; i >= 0; i--) {
                    rakamlar_gonderilen[i] = mesaj_al % 10; //son rakami aldik
                    mesaj_al = mesaj_al / 10; //son rakami attik
                } //dongu sonunda dizi sayinin binler basamagından birlere kadar oldu.

                gecici_1ile3 = rakamlar_gonderilen[0];
                rakamlar_gonderilen[0] = rakamlar_gonderilen[2];
                rakamlar_gonderilen[2] = gecici_1ile3; //1 ile 3 degisti

                gecici_2ile4 = rakamlar_gonderilen[1];
                rakamlar_gonderilen[1] = rakamlar_gonderilen[3];
                rakamlar_gonderilen[3] = gecici_2ile4; //2 ile 4 degisti

                int[] sifreli_mesaj = new int[4]; //1girince 8,2girince 9, 3-0,4-1,5-2,6-3,7-4,8-5,9-6,0-7
                for (int i = 0; i < 4; i++) {
                    sifreli_mesaj[i] = (rakamlar_gonderilen[i] + 3) % 10;
                } //for sonunda sifreli mesaj birlerden binlere kadar sıralandı.

                int gosterilecek_sifreli_mesaj = 0;
                for (int i = 0; i < 4; i++) {
                    gosterilecek_sifreli_mesaj += sifreli_mesaj[i] * (int) Math.pow(10, 3 - i);
                }
                System.out.printf("%04d sifrelenmis mesajin gonderilen hali.\n\n", gosterilecek_sifreli_mesaj); //bastaki 0 gozuksun diye

            }

        }

    }

}
