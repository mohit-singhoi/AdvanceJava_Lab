public class Main1 {
    public static void main(String[] args) {
        Rectangle r = new Rectangle();
        r.length = 60;
        r.width = 25;

        r.display();
    }
    
}
class Rectangle{
    int length;
    int width;

    int area(){
        return length*width;

    }

    int perimeter(){
        return 2*(length+width);
    }

    void display(){
        System.out.println("length : " +length);
        System.out.println("Width : " +width);
        System.out.println("Area of Rectangle : " +area());
        System.out.println("Perimeter of Rectangle : " +perimeter());
        
    }
}
