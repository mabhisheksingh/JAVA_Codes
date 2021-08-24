package BasicConcepts.designpatterns.creational;


//Thread safe singleton
class A {
    private static A obj= null;
    private A(){};
    public static A getObj(){
        if(obj == null){
            synchronized (A.class){
                if(obj == null){
                    obj = new A();
                }
            }

            return obj;
        }

        return obj;
    }
}
public class Singleton {
    public static void main(String[] args) {
        A obj = A.getObj();
        System.out.println(obj);
        A obj1 = A.getObj();
        System.out.println(obj1);
    }
}
