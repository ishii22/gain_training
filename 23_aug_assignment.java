// First Assignment - Deque of Employee
import java.util.*;
class Employee
{
    String name;
    int emp_id;
    Employee4(String name, int emp_id)
    {
        this.name=name;
        this.emp_id=emp_id;
    }
    public String toString(){
        return name+" "+emp_id;
    }
}
public class Semaphore1 {
    public static void main(String[] args) {

        Deque<Employee> d= new ArrayDeque<>();
        d.addFirst(new Employee("Sherlock Holmes",101));
        d.addLast(new Employee("John Watson",102));
        System.out.println(d);

    }
}

// Second Assignment - Hashmap of email id and passwords
import java.util.HashMap;

public class CollectionsHashMap {
    public static void main(String[] args) {
        HashMap<String, String> emailAccountMap = new HashMap<>();
        emailAccountMap.put("Ross@yahoo.com","A@123");
        emailAccountMap.put("Joey@orkut.com","B@123");
        emailAccountMap.put("Chandler@gmail.com","C@123");

        System.out.println(emailAccountMap);
    }
}

//Third Assignment - Hashmap of Employees and Address
public class Address {
    private String houseNo;
    private String street;
    private String city;
    private String state;
    public Address(){}
    public Address(String houseNo, String street,String city, String state){
        this.houseNo = houseNo;
        this.street = street;
        this.city = city;
        this.state = state;
    }
    public String getHouseNo() {
        return houseNo;
    }
    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String toString(){
        return houseNo+" "+street+" "+city+" "+state;
    }
}

public class Employee {
    private int empid;
    private String ename;
    private double salary;
    private int deptno;
    public Employee(){}
    public Employee(int empid, String ename,double salary, int deptno){
        this.empid = empid;
        this.ename = ename;
        this.salary = salary;
        this.deptno = deptno;
    }
    public String toString(){
        return empid+" "+ename+" "+salary+" "+deptno;
    }
}

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CollectionsHashMap {
    public static void main(String[] args) {

        HashMap<Employee, Address> map = new HashMap<>();
        map.put(new Employee(101,"Ajay",1000,10), new Address("221B","Baker Street","city", "state"));
        map.put(new Employee(102,"Babu",2000,20), new Address("1-2-3","MG Street","city", "state"));
        map.put(new Employee(103,"Charan",3000,30), new Address("3-2-1","T Street","city", "state"));
        map.put(new Employee(104,"Dinesh",4000,40), new Address("7-8-9","XYZ Street","city", "state"));

      //Enter in set to print in organized manner
        Set<Map.Entry<Employee,Address>> eSet = map.entrySet();
        for(Map.Entry<Employee,Address> e :eSet){
            System.out.println(e.getKey());
            System.out.println(e.getValue());
            System.out.println();
        }
        System.out.println(map);
    }
}

