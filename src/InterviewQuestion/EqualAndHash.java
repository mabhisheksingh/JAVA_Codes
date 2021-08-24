package InterviewQuestion;

import java.util.Objects;

class emp{
    int id;
    String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        emp emp = (emp) o;
        return id == emp.id && name.equals(emp.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public emp() {}

    @Override
    public String toString() {
        return "emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
public class EqualAndHash {
    public static void main(String[] args) {
        emp e1 = new emp (1,"Abc");
        emp e2 = new emp (1,"abc");
        System.out.println(e1.hashCode());
        System.out.println(e2.hashCode());
    }
}
