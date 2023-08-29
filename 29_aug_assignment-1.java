// JDBC
// Create a DAO to perform CRUD operations and access it menu-driven program

package org.example.DAO;

public class Employee {
    private int empid;
    private String ename;
    private double salary;
    private int deptno;
    private double bonus;
    public Employee(){}
    public Employee(int empid, String ename,double salary, int deptno, double bonus){
        this.empid = empid;
        this.ename = ename;
        this.salary = salary;
        this.deptno = deptno;
        this.bonus = bonus;
    }
    public int getEmpid() { return empid;   }
    public String getEname() {  return ename;   }
    public double getSalary() { return salary;  }
    public int getDeptno() {    return deptno;}
    public double getBonus() {  return bonus;   }
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    public void setEmpid(int empid) {
        this.empid = empid;
    }
    public void setEname(String ename) {
        this.ename = ename;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }
}

//DAO class
package org.example.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

//should contain CRUD operations
public class EmployeeDAO {
    private static String url = "jdbc:mysql://localhost:3306/gainsight";
  
    public Employee getEmployeeByEmployeeID(int empid){
        Employee emp = null;
        try (Connection con = DriverManager.getConnection(url, "root", "G@1nsight");
             PreparedStatement pst = con.prepareStatement("select * from employee where emp_id =?");) {
            pst.setInt(1,empid);
            ResultSet rs = pst.executeQuery();
            if(rs.next())
                emp = new Employee(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4),rs.getDouble(5));
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return emp;
    }
    public ArrayList<Employee> getAllEmployees(){
        ArrayList<Employee> elist = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(url, "root", "G@1nsight");
             PreparedStatement pst = con.prepareStatement("select * from employee");) {
            ResultSet rs = pst.executeQuery();
            while(rs.next())
                elist.add(new Employee(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4),rs.getDouble(5)));
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return elist;
    }
  
    public boolean addEmployee(Employee emp){
        int count = 0;
        try (Connection con = DriverManager.getConnection(url, "root", "G@1nsight");
             PreparedStatement pst = con.prepareStatement("insert into employee values(?,?,?,?,?)") ){
            pst.setInt(1,emp.getEmpid());
            pst.setString(2,emp.getEname());
            pst.setDouble(3,emp.getSalary());
            pst.setInt(4,emp.getDeptno());
            pst.setDouble(5,emp.getBonus());
            count = pst.executeUpdate();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return count==1;
    }
  
    public boolean modifyEmployee(Employee emp){
        int count = 0;
        try (Connection con = DriverManager.getConnection(url, "root", "G@1nsight");
             PreparedStatement pst = con.prepareStatement("update employee set emp_sal=?, deptno=?, bonus=? where emp_id=?");) {
            pst.setDouble(1,emp.getSalary());
            pst.setInt(2,emp.getDeptno());
            pst.setDouble(3,emp.getBonus());
            pst.setInt(4,emp.getEmpid());
            count = pst.executeUpdate();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return count==1;
    }
  
    public boolean deleteEmployeeByEmployeeID(int empid){
        int count = 0;
        try (Connection con = DriverManager.getConnection(url, "root", "G@1nsight");
             PreparedStatement pst = con.prepareStatement("delete from employee where emp_id =?");) {
            pst.setInt(1,empid);
            count = pst.executeUpdate();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return count==1;
    }
}

package org.example.DAO;
import java.util.ArrayList;
import java.util.Scanner;

public class Company {
    EmployeeDAO edao = new EmployeeDAO();
    public void addEmployeeDetails(Employee employee){
//        should call EmployeeDao class' addEmployee return message regarding success or faliure
        if(edao.addEmployee(employee))
            System.out.println("Employee details added succesfully!");
        else
            System.out.println("Employee insertion FAILED!");
    }
    public void displayAllEmployeeDetails(){
//        should call EmployeeDao class' getAllEmployees() and display them
        ArrayList<Employee> elist = edao.getAllEmployees();
        for(Employee e : elist)
            System.out.println(e.getEmpid()+" "+e.getEname()+" "+e.getSalary()+" "+e.getDeptno()+" "+e.getBonus());
    }
    public void displayEmployeeDetailsById(int empid){
//        should call EmployeeDao's getEmployeeByEmployeeId() and display it or faliure message
        Employee e = edao.getEmployeeByEmployeeID(200);
        if(e!=null)
            System.out.println(e.getEname()+" "+e.getSalary()+" "+e.getDeptno()+" "+e.getBonus());
        else
            System.out.println("Employee does not exist");
    }
    public void modifyEmployeeDetails(Employee employee){
//        should call EmployeeDao's getEmployeeByEmployeeId() and display message whether modified or not
        if(edao.modifyEmployee(employee))
            System.out.println("Employee details modified successfully");
        else
            System.out.println("Employee modification failed");
    }
    public void deleteEmployeeDetails (int empid){
//        deleteEmployee and display message whether deleted or not
        if(edao.deleteEmployeeByEmployeeID(empid))
            System.out.println("Employee details deleted successfully");
        else
            System.out.println("Employee deletion failed");
    }

    public static void main(String[] args) {
        Company c = new Company();
        Scanner scanner = new Scanner(System.in);
        char choice = 'Y';
        while(choice=='Y' || choice=='y'){
            System.out.println("1. Add Employee Details");
            System.out.println("2. Delete Employee Details");
            System.out.println("3. Show All Employee");
            System.out.println("4. Select Employee by Id");
            System.out.println("5. Modify Employee Details");
            int option = scanner.nextInt();
            switch(option){
                case 1:
                    System.out.println("Enter employee id, name, salary, department number, bonus");
                    int eid = scanner.nextInt();
                    String ename = scanner.next();
                    double esal = scanner.nextDouble();
                    int edept = scanner.nextInt();
                    double ebonus = scanner.nextDouble();
                    c.addEmployeeDetails(new Employee(eid,ename,esal,edept,ebonus));
                    break;
                case 2:
                    System.out.println("Enter employee id");
                    eid = scanner.nextInt();
                    c.deleteEmployeeDetails(eid);
                    break;
                case 3:
                    c.displayAllEmployeeDetails();
                    break;
                case 4:
                    System.out.println("Enter employee id");
                    eid = scanner.nextInt();
                    c.displayEmployeeDetailsById(eid);
                    break;
                case 5:
                    System.out.println("Enter employee id, name, salary, department number, bonus");
                    eid = scanner.nextInt();
                    ename = scanner.next();
                    esal = scanner.nextDouble();
                    edept = scanner.nextInt();
                    ebonus = scanner.nextDouble();
                    c.modifyEmployeeDetails(new Employee(eid,ename,esal,edept,ebonus));
                    break;
                default:
                    System.out.println("Not a valid choice");
            }
            System.out.println("Do you want to continue? (Y/N)");
            choice = scanner.next().charAt(0);
        }
    }
}

