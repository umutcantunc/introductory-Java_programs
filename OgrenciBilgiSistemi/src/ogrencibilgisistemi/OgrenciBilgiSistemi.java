/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ogrencibilgisistemi;

/**
 *
 * @author UMUTCAN TUNÇ
 */
import java.util.Scanner; //scanneri kullanmak icin dahil ettik

public class OgrenciBilgiSistemi {

    public static void main(String[] args) {
        Scanner tarayici = new Scanner(System.in); //sayi almamizi saglayan scanner tanimladik

        System.out.print("Kac adet ogrenci bilgisi girilecek?:");
        int ogrenci_sayisi = tarayici.nextInt(); //kullanidan alinan n adet ogrenci, pozitif tam sayi girdigi kabul ediliyor

        //bilgileri kaydetmek icin dizileri olusturuyoruz
        int[] ogrenci_no = new int[ogrenci_sayisi];
        String[] ogrenci_isim = new String[ogrenci_sayisi];
        int[] vize_not = new int[ogrenci_sayisi];
        int[] final_not = new int[ogrenci_sayisi];
        double[] sinav_not = new double[ogrenci_sayisi];
        double sinav_not_ortalamasi = 0; //ortalamayi 0'la baslatıyoruz

        int secim; //menude secim yapmak icin
        boolean ilkVeriAlindi = false; //ogrenci bilgileri girildi mi diye kontrol etmek icin
        boolean sinavSonucuHesaplandiMi = false; //sinav sonucu hesaplandi mi diye kontrol etmek icin

        do {

            System.out.println("\n===== OGRENCI BILGI SISTEMI MENUSU =====");
            System.out.println("1 - Ogrenci Bilgilerini Gir");
            System.out.println("2 - Bilgileri Giris Sirasina Gore Goruntule");
            System.out.println("3 - Sinav Sonuc Ortalamasini Bul");
            System.out.println("4 - Sinav Notu 60'dan Kucuk Olanlari Goruntule");
            System.out.println("5 - Ortalamanin Ustundeki Ogrencileri Goruntule");
            System.out.println("6 - Sinav notu 60'dan Kucuk Olanlarin Sayisini Goruntule");
            System.out.println("7 - En Yuksek Sinav Notunu Goruntule");
            System.out.println("8 - En Dusuk Sinav Notunu Goruntule");
            System.out.println("9 - Sinav Notlarina Gore Goruntule");
            System.out.println("0 - Cikis Yap");

            System.out.print("Lutfen yapmak istediginiz islemi secin: ");
            secim = tarayici.nextInt();

            if (!ilkVeriAlindi && secim != 0 && secim != 1 && secim <= 9) { //kullancidan once ogrenci bilgilerini almasini saglar
                System.out.println("Lutfen once 1.secenegi kullanarak ogrenci bilgilerini giriniz!");
                continue; //do while dongusunun basina gider
            }

            if (!sinavSonucuHesaplandiMi && secim >= 4 && secim <= 9) { //kullanici sinav sonucuyla ilgili menu secmeden once sinav sonucunu hesaplamasini saglar
                System.out.println("Lutfen once 3.secenegi kullanarak sinav sonucunu hesaplayiniz!");
                continue; //do while dongusunun basina gider
            }

            switch (secim) {

                case 0:
                    System.out.println("Programdan cikiliyor...");
                    break;
                case 1:
                    if (ilkVeriAlindi) { //ilk veri alindaktan sonra tekrar veri girmez
                        System.out.println("Ogrenci bilgileri girilmis,degistirme yapilamaz!");
                        break;
                    } else {
                        bilgileriAl(ogrenci_sayisi, ogrenci_no, ogrenci_isim, vize_not, final_not);
                        ilkVeriAlindi = true; //ogrenci verileri alindigi icin main'deki if yapisina birdaha girmez
                        break;
                    }
                case 2:
                    bilgileriSirayaGoreGoruntule(ogrenci_sayisi, ogrenci_no, ogrenci_isim, vize_not, final_not);
                    break;
                case 3:
                    sinav_not_ortalamasi = sinavSonucunuBul(ogrenci_sayisi, vize_not, final_not, sinav_not);
                    sinavSonucuHesaplandiMi = true;
                    break;
                case 4:
                    sinavNotu60danKucukseGoruntule(ogrenci_sayisi, sinav_not, ogrenci_no, ogrenci_isim);
                    break;
                case 5:
                    ortalamaninUstundeyseGoruntule(ogrenci_sayisi, sinav_not, sinav_not_ortalamasi, ogrenci_no, ogrenci_isim);
                    break;
                case 6:
                    System.out.println("Sinav notu 60'dan kucuk olan ogrenci sayisi: " + sinavNotu60danKucukOlanlarinSayisiniHesapla(ogrenci_sayisi, sinav_not));
                    break;
                case 7:
                    System.out.println("En yuksek sinav notu:" + enYuksekSinavSonucunuHesapla(ogrenci_sayisi, sinav_not));
                    break;
                case 8:
                    System.out.println("En dusuk sinav notu:" + enDusukSinavSonucunuHesapla(ogrenci_sayisi, sinav_not));
                    break;
                case 9:
                    sinavSonuclarinaGoreGoruntule(ogrenci_sayisi, sinav_not, ogrenci_no, ogrenci_isim);
                    break;
                default:
                    System.out.println("Gecersiz bir secim yaptiniz");
                    break;
            }

        } while (secim != 0); //0 girene kadar devam et
    }

    //METODLAR
    public static void bilgileriAl(int n, int[] ogrenci_no, String[] ogrenci_isim, int[] vize_not, int[] final_not) { //n defa bilgileri alacak metod
        Scanner tarayici = new Scanner(System.in);

        for (int i = 0; i < n; i++) {
            System.out.print("Ogrenci numarasini giriniz:");
            ogrenci_no[i] = tarayici.nextInt();

            tarayici.nextLine();//yukarida sayi girdikten sonra kelime almadan once enter'i yutuyoruz
            System.out.print("Ogrenci ismini giriniz:");
            ogrenci_isim[i] = tarayici.nextLine();

            System.out.print("Ogrencinin vize notunu giriniz:");
            vize_not[i] = tarayici.nextInt();

            System.out.print("Ogrencinin final notunu giriniz:");
            final_not[i] = tarayici.nextInt();

            System.out.printf("%d. girilen ogrenci kaydedildi!\n", i + 1);
        }
    }

    public static void bilgileriSirayaGoreGoruntule(int n, int[] ogrenci_no, String[] ogrenci_isim, int[] vize_not, int[] final_not) {
        System.out.println("\n***OGRENCI BILGI LISTESI***"); //baslik

        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + ".OGRENCI:");
            System.out.println("Ogrenci numarasi:" + ogrenci_no[i]);
            System.out.println("Ogrenci ismi:" + ogrenci_isim[i]);
            System.out.println("Vize notu:" + vize_not[i]);
            System.out.println("Final notu:" + final_not[i]);
            System.out.println("------------------------"); //her ogrenci sonrasinda karismamasi icin cizgi
        }
    }

    public static double sinavSonucunuBul(int n, int[] vize_not, int[] final_not, double[] sinav_not) {
        double sinav_not_toplam = 0;

        for (int i = 0; i < n; i++) {
            sinav_not[i] = vize_not[i] * 0.4 + final_not[i] * 0.6; //double bir sayi ile carparak double sonucu double bir degiskene atadik
            sinav_not_toplam += sinav_not[i];
        }
        System.out.println("Sinav sonuclari ve sinav not ortalamasi hesaplandi.");
        return (sinav_not_toplam / n); //double/int yaptik sonuc double oldu ve ortalamayi bulduk
    }

    public static void sinavNotu60danKucukseGoruntule(int n, double[] sinav_not, int[] ogrenci_no, String[] ogrenci_isim) {
        System.out.println("\n---SINAV NOTU 60'DAN KUCUK OLANLAR---");
        for (int i = 0; i < n; i++) {
            if (sinav_not[i] < 60) {
                System.out.println("Ogrenci numarasi:" + ogrenci_no[i]);
                System.out.println("Ogrenci ismi:" + ogrenci_isim[i]);
                System.out.println("Sinav notu:" + sinav_not[i]);
                System.out.println("------------------------"); //bir sonraki ogrenciyle karismamasi icin bir cizgi
            }
        }
    }

    public static void ortalamaninUstundeyseGoruntule(int n, double[] sinav_not, double sinav_not_ortalamasi, int[] ogrenci_no, String[] ogrenci_isim) { //numaraları ve isimleri de gostersin         

        System.out.println("\nSINAV NOT ORTALAMASI: " + sinav_not_ortalamasi);

        System.out.println("---ORTALAMA USTUNDE OLAN OGRENCILER---");
        for (int i = 0; i < n; i++) {
            if (sinav_not[i] > sinav_not_ortalamasi) {
                System.out.println("Ogrenci numarasi: " + ogrenci_no[i]);
                System.out.println("Ogrenci ismi: " + ogrenci_isim[i]);
                System.out.println("Sinav notu: " + sinav_not[i]);
                System.out.println("-------------------------"); //bir sonraki ogrenciyle karismamasi icin bir cizgi
            }
        }
    }

    public static int sinavNotu60danKucukOlanlarinSayisiniHesapla(int n, double[] sinav_not) {
        int sayac = 0;

        for (int i = 0; i < n; i++) {
            if (sinav_not[i] < 60) {
                sayac++;
            }
        }
        return sayac;
    }

    public static double enYuksekSinavSonucunuHesapla(int n, double[] sinav_not) {
        double max_sinav_sonucu = sinav_not[0]; //ilk eleman max olsun

        for (int i = 1; i < n; i++) {
            if (sinav_not[i] > max_sinav_sonucu) {
                max_sinav_sonucu = sinav_not[i];
            }
        }
        return max_sinav_sonucu;
    }

    public static double enDusukSinavSonucunuHesapla(int n, double[] sinav_not) {
        double min_sinav_sonucu = sinav_not[0]; //ilk eleman min olsun

        for (int i = 1; i < n; i++) {
            if (sinav_not[i] < min_sinav_sonucu) {
                min_sinav_sonucu = sinav_not[i];
            }
        }
        return min_sinav_sonucu;
    }

    public static void sinavSonuclarinaGoreGoruntule(int n, double[] sinav_not, int[] ogrenci_no, String[] ogrenci_isim) {
        //ogrenci bilgilerini yeni bir diziye aktarıyoruz
        double[] sirali_not = new double[n];
        int[] sirali_no = new int[n];
        String[] sirali_isim = new String[n];

        for (int i = 0; i < n; i++) {
            sirali_not[i] = sinav_not[i];
            sirali_no[i] = ogrenci_no[i];
            sirali_isim[i] = ogrenci_isim[i];
        } //ogrenci bilgileri artık yeni bir diziye kopyalandı

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                if (sirali_not[i] > sirali_not[j]) { //bubble sort yontemiyle notları kucukten buyuge sıraladık

                    double temp_not = sirali_not[i];
                    sirali_not[i] = sirali_not[j];
                    sirali_not[j] = temp_not;

                    int temp_no = sirali_no[i];
                    sirali_no[i] = sirali_no[j];
                    sirali_no[j] = temp_no;

                    String temp_isim = sirali_isim[i];
                    sirali_isim[i] = sirali_isim[j];
                    sirali_isim[j] = temp_isim;
                }
            }
        } //sıralı notlar sıralandı. ilk ogrenci verileri korundu.

        System.out.println("\n---SINAV NOTLARINA GORE KUCUKTEN BUYUGE SIRALI LISTE---");
        for (int i = 0; i < n; i++) {
            System.out.println("Ogrenci numarasi: " + sirali_no[i]);
            System.out.println("Ogrenci ismi: " + sirali_isim[i]);
            System.out.println("Sinav notu: " + sirali_not[i]);
            System.out.println("------------------------"); //bir sonraki ogrenciyle karismamasi icin bir cizgi
        }
    }

}
