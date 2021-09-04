package InterviewQuestion.accenture;
import java.util.Arrays;
/*
* The main difference between the .equals() method and == operator is that one is a method and the other is the operator.
We can use == operators for reference comparison (address comparison) and .equals()
* method for content comparison. In simple words, == checks if both objects point to the
* same memory location whereas .equals() evaluates to the comparison of values in the objects*/
public class Questions {
    public static void main(String[] args) {
        hashCodeQuestion();
        System.out.println( Void.TYPE );
    }

    private static void hashCodeQuestion() {
        String a = "India";
        String b = new String("India");
        String c = "A";
        //System.out.println(a.hashCode() == b.hashCode());
        //System.out.println(b.hashCode() == c.hashCode());
        //System.out.println(a.hashCode() == c.hashCode());

        StringBuffer a1 = new StringBuffer("India");
        StringBuffer b1 = new StringBuffer("India");
        //System.out.println(a1.hashCode() == b1.hashCode());
        String str = "Abhishek";
        String str2= "Abhi".concat("shek");
        String str1 = new String("Abhishek");
        System.out.println(str == str2);
        System.out.println(str == str1);
        System.out.println("equal "+str.equals(str1));
        String s1 = "HELLO";
        String s2 = "HELLO";
        String s3 =  new String("HELLO");
        System.out.println("s1 and s2 "+s1 == s2); // true
        System.out.println(s1 == s3); // false
        System.out.println(s1.equals(s2)); // true
        System.out.println(s1.equals(s3)); // true

    }

}
