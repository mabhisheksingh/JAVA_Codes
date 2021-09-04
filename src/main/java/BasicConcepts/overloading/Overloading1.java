package BasicConcepts.overloading;

public class Overloading1 {
    public int findarea (int l, int b) {
        int var1;
        var1 = l * b;
        return var1;
    }
    /*public double findarea (int l, int b) {  //this condition is followed in overloading
        double var1;
        var1 = l * b;
        return var1;
    }*/
    public int findarea (int l, int b, int h) {
        int var2;
        var2 = l * b * h;
        return var2;
    }

    public static void main(String[] args) {
        Overloading1 obj = new Overloading1();
        System.out.println("Output : "+obj.findarea(1,2));
    }
}
