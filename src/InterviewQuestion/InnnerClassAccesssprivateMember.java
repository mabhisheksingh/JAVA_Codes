package InterviewQuestion;

public class InnnerClassAccesssprivateMember {

    private static int max =Integer.MIN_VALUE;
    private static int max1 = 100;

    private static  void main(){
        System.out.println("main of parent private ");
    }
    static class InnnrClass  {
        private static int alpha = 20;

        private void print(){
            System.out.println("Access private Max "+max);
            max1 = 25;
            main();
        }
    }

    public static void main(String[] args) {
        System.out.println("max = "+new InnnerClassAccesssprivateMember().max);
        InnnrClass ic  = new InnnrClass();
        ic.print();
        //System.out.println("Max 1 "+max1+ " private member of inner class "+ alpha);

    }

    public static void main(String[] args,int a) {
        System.out.println("max = "+new InnnerClassAccesssprivateMember().max);
        InnnrClass ic  = new InnnrClass();
        ic.print();

    }
}
