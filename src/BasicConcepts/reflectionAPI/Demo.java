package BasicConcepts.reflectionAPI;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Demo {
    public static void main(String[] args) throws Exception {

        Class c = Class.forName("BasicConcepts.reflectionAPI.Test1");
        //Test1 t = (Test1) c.newInstance(); //depricated
        Test1 t = (Test1) c.getDeclaredConstructor().newInstance();
        System.out.println("Class name is : "+c.getName());
        Constructor constructor = t.getClass().getConstructor();
        System.out.println("Constructor name is : "+constructor.getName());
        System.out.println("The public methods of class are : ");
        Method[] methods = c.getMethods();
        for(Method m : methods){
            System.out.println( "Method name is : "+m.getName());
        }

        Method methodcall1 = c.getDeclaredMethod("method2", int.class);
        methodcall1.setAccessible(true);
        methodcall1.invoke(t,19);

        Field f = c.getDeclaredField("s");
        f.setAccessible(true);
        f.set(t,"Abhishek");
        Method methodcall2 = c.getDeclaredMethod("method1");
        methodcall2.setAccessible(true);
        methodcall2.invoke(t);

        Method methodcall3 = c.getDeclaredMethod("method3");
        methodcall3.setAccessible(true);
        methodcall3.invoke(t);

    }
}
