package BasicConcepts.immutableclass;

//This is immutable class

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@ToString
public final class Employee {
    private final Integer empId;
    private final String empName;
    private final Deparment deparment;
    private final List<String> empPhoneNumber;


    public Integer getEmpId() {
        return empId;
    }
    public String getEmpName() {
        return empName;
    }

    public Deparment getDeparment() {
        return new Deparment(deparment.getId(), deparment.getDeparmentName());
    }

    public List<String> getEmpPhoneNumber() {
        return empPhoneNumber;
    }

    public static void main(String[] args) {
        Employee emp =
                new Employee(1,"Abhishek",new Deparment(2,"Dev"),Arrays.asList("77","88"));
        System.out.println(emp);
        emp.getDeparment().deparmentName="ABC";
        System.out.println(emp.getDeparment().deparmentName);
        System.out.println(emp);


    }
}
