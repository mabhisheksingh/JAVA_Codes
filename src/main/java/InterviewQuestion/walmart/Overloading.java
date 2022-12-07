package InterviewQuestion.walmart;

public class Overloading {
    static int x =0;
    static double y=0;
    public static void main(String[] args) {
        Integer a1 = new Integer(-10);
        Integer b1 = new Integer(-10);
        int c =-10;
        System.out.println(a1==b1);
        System.out.println(a1.equals(b1));
        System.out.println(a1==c);
        System.out.println(a1.equals(c));

        int a =2;
        double b=12.0;
        add(a,b);
        add(b,b);
        System.out.println(x+"--"+y);
    }
    public static void add (int a,int b) {
        System.out.println("int "+a +" "+b);
        x = a *b;
    }
    public static void add (double a,double b) {
        System.out.println("double "+a +" "+b);
        y = a + b;
    }


}
