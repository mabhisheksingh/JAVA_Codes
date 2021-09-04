package JAVA8.Stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8StreamPracticeProblems {

    public static List<Student>  fillDataInStudentsList(){
        List<Student> students = new ArrayList<>();
        List<MobileNumber> mobileNumber1 = new ArrayList<>();
        mobileNumber1.add(new MobileNumber("7271058852"));
        mobileNumber1.add(new MobileNumber("9935692815"));
        students.add(new Student("Abhishek", 24, new Address("Shivkuti"),mobileNumber1) );
        List<MobileNumber> mobileNumber2 = new ArrayList<>();
        mobileNumber2.add(new MobileNumber("7271053333"));
        mobileNumber2.add(new MobileNumber("3333"));
        students.add(new Student("jayesh", 24, new Address("Santipuram"),mobileNumber2) );
        List<MobileNumber> mobileNumber3 = new ArrayList<>();
        mobileNumber3.add(new MobileNumber("1233"));
        mobileNumber3.add(new MobileNumber("1234"));
        students.add(new Student("Ashish", 24, new Address("12345"),mobileNumber3) );
        Student student1 = new Student(
                "Jayesh",
                20,
                new Address("1234"),
                Arrays.asList(new MobileNumber("1233"), new MobileNumber("1234")));

        Student student2 = new Student(
                "Khyati",
                20,
                new Address("1235"),
                Arrays.asList(new MobileNumber("1111"), new MobileNumber("3333"), new MobileNumber("1233")));

        Student student3 = new Student(
                "Jason",
                20,
                new Address("1236"),
                Arrays.asList(new MobileNumber("3333"), new MobileNumber("4444")));
        students.add(student1);
        students.add(student2);
        students.add(student3);
        return students;
    }

    public static void main(String[] args) {
        List<Student> students = fillDataInStudentsList();
        //1 .Get student with exact match name "jayesh"
        Optional<Student> first =students.stream().filter(n -> n.getName().equalsIgnoreCase("jayesh")).findFirst();
        if(first.isPresent()){
            System.out.println(first.get().getName());
        }else {
            System.out.println("Student Name is not present");
        }
        System.out.println("--------------------");
       //2. Get student with matching address "1235
        Optional<Student> second = students.stream().filter(n -> n.getAddress().getZipcode().equalsIgnoreCase("12345") ).findFirst();
        if(second.isPresent()){
            System.out.println(second.get().getAddress().getZipcode());
        }else {
            System.out.println("Address is not present");
        }
        System.out.println("--------------------");
        //3. Get all student having mobile numbers 3333.
        System.out.println("3. Get all student having mobile numbers 3333");
        List<Student> third = students.stream().filter(n -> n.getMobileNumbers().stream().anyMatch(no -> no.getNumber() == ("3333"))).collect(Collectors.toList());
        String NamesList = third.stream().map( std ->  std.getName() ).collect(Collectors.joining(",","[","]"));

        System.out.println("NumberList : "+NamesList);
        for(Student obj : third){
            System.out.print( obj.getName() );
            for (MobileNumber mno : obj.getMobileNumbers()){
                System.out.print(" "+mno.getNumber() );
            }
            System.out.println();
        }
        System.out.println("--------------------");
        /*4 . Get all student having mobile number 1233 and 1234*/
        System.out.println("4. Get all student having mobile number 1233 and 1234");
         List<Student> fourth = students.stream()
                 .filter( no -> no.getMobileNumbers().stream().anyMatch( n -> ( n.getNumber() == "1233" || n.getNumber() == " 1234") ))
                 .collect(Collectors.toList());
        System.out.println("NumberList : "+fourth);
        for(Student obj : fourth){
            System.out.print( obj.getName() );
            for (MobileNumber mno : obj.getMobileNumbers()){
                System.out.print(" "+mno.getNumber() );
            }
            System.out.println();
        }
        System.out.println("--------------------");
         /*4 Create a List<Student> from the List<TempStudent>*/
        System.out.println("4. Create a List<Student> from the List<TempStudent>");
        System.out.println("--------------------");


        /*5 .Convert List<Student> to List<String> of student name*/
        System.out.println("5 .Convert List<Student> to List<String> of student name");

        List<String> studentList = students.stream().map(a -> a.getName()).collect(Collectors.toList());
        studentList.forEach(System.out::println);
        System.out.println("--------------------");
        //Convert List<students> to String
        System.out.println("6. Convert List<students> to String");
        String str = studentList.stream().collect(Collectors.joining(",","[","]"));
        System.out.println(str);
        System.out.println("--------------------");

        //6. Sort List<String>
        System.out.println("7. Sort List<String>");
        studentList.sort( (a,b) -> a.compareTo(b) );
        studentList.forEach(System.out::println);
        System.out.println("--------------------");
        /*Change the case of List<String>

        Conditionally apply Filter condition, say if flag is enabled then.
        */

    }
}

class TempStudent {
    public String name;
    public int age;
    public Address address;
    public List<MobileNumber> mobileNumbers;

    public TempStudent(String name, int age, Address address, List<MobileNumber> mobileNumbers) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.mobileNumbers = mobileNumbers;
    }
}

class Student{
    private String name;
    private int age;
    private Address address;
    private List<MobileNumber> mobileNumbers;

    public Student(String name, int age, Address address, List<MobileNumber> mobileNumbers) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.mobileNumbers = mobileNumbers;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }

    public List<MobileNumber> getMobileNumbers() {
        return mobileNumbers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setMobileNumbers(List<MobileNumber> mobileNumbers) {
        this.mobileNumbers = mobileNumbers;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address.getZipcode() +
                ", mobileNumbers=" + mobileNumbers +
                '}';
    }
}

class Address{
    private String zipcode;

    public Address(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}

class MobileNumber{
    private String number;

    public MobileNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}