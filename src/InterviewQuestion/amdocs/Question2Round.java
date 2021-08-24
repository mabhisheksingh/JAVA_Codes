package InterviewQuestion.amdocs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Person{
    private  String name;
    private int id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
       // if (o == null || getClass() != o.getClass()) return false;
        if(! (this instanceof  Object)) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}
public class Question2Round {
    //equals and hashcode overide
    public static void main(String[] args) throws Exception {
        Person p1 = new Person("Abhishek",23);
        Person p2 = new Person("Abhishek", 23);
        System.out.println("With equals method ");
        if(p1.equals(p2) ){
            System.out.println("Equal");
        }else{
            System.out.println("Not Equal");
        }
        System.out.println("With == ");
        if(p1==p2 ){
            System.out.println("Equal");
        }else{
            System.out.println("Not Equal");
        }

        int num[] = {1, 2, 3, 4};
        //System.out.println(num[5]);
        Question2Round q = new Question2Round();
        q.p();
        System.out.println("Normal flow...");

    }

    void m()
    {
        int data = 50 / 0; // unchecked exception occurred
        // exception propagated to n()
    }

    void n()
    {
        m();
        // exception propagated to p()
    }

    void p()
    {
        try {
            n(); // exception handled
        }
        catch (Exception e) {
            System.out.println("Exception handled");
        }
    }


}
