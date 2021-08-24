package JAVA8.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {
    private Integer empId;
    private String empName;
    private Integer empAge;
    private Integer empSalary;
    private List<String> empPhoneNumber;

    public  static List<Employee> getEmployeeData(){
        List<Employee> employees= new ArrayList<Employee>();
        employees.add( new Employee(100,"Abhishek Singh",24,240000, Arrays.asList("7271058852","7905840761")) );
        employees.add( new Employee(101,"Shivam Singh",25,24000, Arrays.asList("7271058853","7905840762")) );
        employees.add( new Employee(108,"Ashish Singh",26,2400, Arrays.asList("7271058882","7905840961")) );
        employees.add( new Employee(109,"Arav patel",5,2400000, Arrays.asList("7271058952","7905849761")) );
        employees.add( new Employee(104,"Abhishek das",20,450000, Arrays.asList("7276058852","7905846761")) );
        employees.add( new Employee(105,"Akash Singh",24,900000, Arrays.asList("7271258892","7905860761")) );
        employees.add( new Employee(106,"Ashutosh Singh",25,1000000, Arrays.asList("7273658852","7985840761")) );
        employees.add( new Employee(103,"kamal Singh rawal",22,20000, Arrays.asList("123467899","7905840761")) );
        employees.add( new Employee(102,"Alpha Singh",60,200, Arrays.asList("72710589992","7905520761")) );

        return employees;
    }
}
