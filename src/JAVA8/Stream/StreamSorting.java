package JAVA8.Stream;

import java.util.*;
import java.util.stream.Collectors;

public class StreamSorting {

    public static void main(String[] args) {
        List<Employee> employees = Employee.getEmployeeData();
        System.out.println(employees);
        Map<Integer,String > hash = new HashMap<>();
        for(Employee emp : employees)
            hash.put(emp.getEmpId(),emp.getEmpName());
        System.out.println(hash);
        System.out.println("********Traditional list Sorting on key********");
        List<Map.Entry<Integer,String >> list = new ArrayList<>(hash.entrySet());

        //use long code without lambda expression
        Collections.sort(list,new Comparator<Map.Entry<Integer,String >>(){
            @Override
            public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
               return o1.getKey().compareTo(o2.getKey());
            }
        });
        System.out.println(list);
        System.out.println("********Traditional list Sorting using lambda on value********");
        Collections.sort(list,(o1, o2) -> o1.getValue().compareTo(o2.getValue()));
        System.out.println(list);
        Collections.sort(employees,(o1, o2) -> o1.getEmpSalary().compareTo(o2.getEmpSalary()));
        System.out.println(employees);
        Collections.reverse( employees);
        System.out.println(employees);
        System.out.println("********Stream list Sorting on value on list********");
        hash.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
        //employees.stream().sorted(Comparator.comparing())
        System.out.println(hash);
        System.out.println("********Stream Map reverse Sorting on value on list********");
        hash.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
        System.out.println(hash);
        System.out.println("********Stream list reverse Sorting on value on list********");
        List<Employee> sortedEmployes = employees.stream()
                .sorted(Comparator.comparing( (o1 )-> o1.getEmpAge() )).collect(Collectors.toList());
        System.out.println(sortedEmployes);

    }
}
