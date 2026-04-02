
public class Point {
    
    private int x;
    private int y;
    
    
    public Point(int x,int y) { //Constructor
        
        this.x = x;
        this.y = y;
        
    }
    
    @Override
    public String toString() { //override
        return "(x=" + this.x + ", y=" + this.y + ")";
    }
    
    public double distanceFromPoint(Point otherPoint) {
        //otherPoint baska bir classtan gelirse x ve y private oldugu icin get ile cagiriyoruz
        double dx = this.x - otherPoint.getX(); // x'ler farki
        double dy = this.y - otherPoint.getY(); //y'ler farki
        
        return Math.sqrt((dx*dx) + (dy*dy));
        
    }
    
    public int getX(){
        return this.x;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public int getY(){
        return this.y;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    
    
}
