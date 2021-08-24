package InterviewQuestion;

import java.io.ObjectStreamException;

class A{
    public void m1(int m){
        System.out.println("Print Am1");
        }
}
class B extends A{
    public void m1(int m ,int m2){
        System.out.println("print m1B");
    }
}
public class Test2 {
    public static void main(String[] args) {
        B b = new B();
       // b.m1(5);
        Thread t = new Thread();
        t.stop();

        Test33 t33 = new Test33();
        t33.A(new Test33());

    }
}

class Test33{
    public void A(Object o){
        System.out.println("call Object ");
    }

    public void A(String o){
        System.out.println("call String ");
    }
}
