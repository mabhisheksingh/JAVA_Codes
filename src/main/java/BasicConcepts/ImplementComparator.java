package BasicConcepts;

import java.util.*;

public class ImplementComparator  {
    public static void main(String[] args) {
        Employee emp = new Employee("Abhishek Singh" ,20094373);
        Employee emp1 = new Employee("Shivam Singh" ,20094352);
        Employee emp2 = new Employee("Ashsih Singh" ,20094399);
        List<Employee> list = new ArrayList<Employee>();
        list.add(emp);
        list.add(emp1);
        list.add(emp2);


        //without class
        /*Comparator<Employee> com = new Comparator<Employee>() {
            @Override
            public int compare(Employee a,Employee b) {
                if( a.empId > b.empId){
                    return 1;
                }
                return -1;
            }
        };
        Collections.sort(list,com);*/
        //with the help of lambda on empId
        Collections.sort(list,(o1,o2)->{
            if( o1.empId > o2.empId){
                return -1;  //+means swap
            }
            return 1;
        });
        ListIterator<Employee> litsIterator = list.listIterator();
        while(litsIterator.hasNext()){
            Employee em3 = litsIterator.next();
            System.out.println("Name "+em3.toString());
        }

        //with the help of lambda on empId
        Collections.sort(list,(o1,o2)->{
            return o1.name.compareTo(o2.name) *-1;
        });
        ListIterator<Employee> litsIterator1 = list.listIterator();
        while(litsIterator1.hasNext()){
            Employee em3 = litsIterator1.next();
            System.out.println("Name "+em3.toString());
        }
    }
}

class Employee{
    public String name;
    public int empId;

    Employee(String name , int empId){
        this.name = name;
        this.empId = empId;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", empId=" + empId +
                '}';
    }
}
