
public class Line {
    
    private Point basNokta;
    private Point sonNokta;
    
    
    public Line(Point basNokta,Point sonNokta) { //Constructor
    
        this.basNokta = basNokta;
        this.sonNokta = sonNokta;
       
    }
    
    @Override
    public String toString() { //override
        return this.basNokta.toString() + ", " + this.sonNokta.toString(); //noktalari yazdiran Point'teki toString metodumuzu kullaniyoruz
    }
    
    public double length() {
        
        return this.basNokta.distanceFromPoint(this.sonNokta); //uzunluk=basNokta ve sonNokta arasindaki uzunluktu. iki nokta icin uzunlugu hesapylana metodu Point'ten cagiriyoruz
        
    }
    
    public Point getbasNokta() {
        return this.basNokta;
    }
    
    public void setbasNokta(Point basNokta) {
        this.basNokta = basNokta;
    }
    
    public Point getsonNokta() {
        return this.sonNokta;
    }
    
    public void setsonNokta(Point sonNokta) {
        this.sonNokta = sonNokta;
    }
    
}
