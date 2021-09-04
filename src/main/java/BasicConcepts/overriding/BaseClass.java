package BasicConcepts.overriding;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;

public class BaseClass {

    public A m1() {
        System.out.println("In BaseClass method");
        return new A();
    }

    public static void main(String args[])
    {
        BaseClass b=new SubClass();
        b.m1();

    }
}

class SubClass extends BaseClass {
    public B m1() {
        System.out.println("In SubClass method");
        return new B();

    }
}

class A {
}

class B extends A {

}
