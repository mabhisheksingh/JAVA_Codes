package InterviewQuestion.tsys;

import JAVA8.Stream.Employee;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
class sortByAge implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        if(o1.getEmpAge() == o2.getEmpAge()){
            return new sortByName().compare(o1,o2);
        }else
            return o1.getEmpAge() - o2.getEmpAge();
    }
}


class sortByName implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getEmpName().compareTo(o2.getEmpName());
    }
}
public class Questions {


    static List<Employee> employeeList = Employee.getEmployeeData();
    public static void main(String ... args) {

        System.out.println("Unsorted");
        for (int i = 0; i < employeeList.size(); i++)
            System.out.println(employeeList.get(i));

        Collections.sort(employeeList,new sortByAge());

        System.out.println("Sorted");
        for (int i = 0; i < employeeList.size(); i++)
            System.out.println(employeeList.get(i));

    }



}
