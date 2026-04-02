
import java.util.ArrayList;

public class PolyLine {

    private ArrayList<Point> noktalar; //herhangi bir sayida nokta tutabilmesi icin esnek dizi

    public PolyLine() { //Constructor-parametresiz, bos liste olusturur
        this.noktalar = new ArrayList<>();
    }

    public PolyLine(Line line) { //Constructor
        this.noktalar = new ArrayList<>(); //

        //bir cizgiyi(basNokta ve sonNokta) listeye ekleme
        this.noktalar.add(line.getbasNokta());
        this.noktalar.add(line.getsonNokta());

    }

    public void addPoint(Point point) {

        this.noktalar.add(point); //listeye nokta ekleme

    }
    
    public void addLine(Line line) {
        //cizgiyi yani basNokta ve sonNokta'yi listeyi ekleme
        this.noktalar.add(line.getbasNokta());
        this.noktalar.add(line.getsonNokta());
    }
    
    public void addPolyLine(PolyLine otherPolyLine) {
    
        for (int i =0;i<otherPolyLine.noktalar.size();i++) { //diger yani otherPolyLine'daki noktalar listesinde geziniyoruz
            Point siradakiNokta = otherPolyLine.noktalar.get(i); //otherPolyLine'in i. siradaki noktayi aliyoruz
            this.noktalar.add(siradakiNokta); //su anki PolyLine'a ekliyoruz
        }
    }
    
    public String toString() {
        String sonuc = "["; 
        
        for (int i = 0; i < this.noktalar.size(); i++) {
            sonuc += this.noktalar.get(i).toString(); 
            
            // Son eleman değilse araya SADECE virgül koyuyoruz (boşluk yok)
            if (i < this.noktalar.size() - 1) {
                sonuc += ",";
            }
        }
        
        sonuc += "]"; 
        return sonuc;
    }
    
    public double length() {
    
        double totalLength = 0;
        
        for (int i = 0; i < this.noktalar.size() - 1; i++) {
            Point currentPoint = this.noktalar.get(i);
            Point nextPoint = this.noktalar.get(i + 1);
            //iki ardisik noktayi sectik ve iki nokta arasi uzakligi hesaplayi toplam uzunluga ekledik
            totalLength += currentPoint.distanceFromPoint(nextPoint);
        }
        
        return totalLength;
    }
    
    public void reverse() {
        int baslangic = 0; // ArrayList noktalar dizisinin ilk indeksi
        int bitis = this.noktalar.size() - 1; // son indeksi
        
        //baslangic ile bitisi ortada kavustarana kadar donguye devam
        while (baslangic < bitis) {
            
            Point gecici = this.noktalar.get(baslangic); //swap islemi icin temp bir degiskene atama islemi
            
            this.noktalar.set(baslangic, this.noktalar.get(bitis)); //sagdakini sola yaz. yani sonlardakini baslardakilere yaz
            this.noktalar.set(bitis,gecici); //gecici burada baslardaki olmus oluyor, baslardakini sonlardakilere yaz
            
            //bir sonrakiler icin indeksleri ortaya dogru kaydiriyoruz
            baslangic++;
            bitis--;
        }
    }
    
    public ArrayList<Point> getNoktalar() {
        return this.noktalar;
    }

    public void setNoktalar(ArrayList<Point> noktalar) {
        this.noktalar = noktalar;
    }
    
    
    
    
    
    
    
}
