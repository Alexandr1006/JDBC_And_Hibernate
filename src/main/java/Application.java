import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();

        Employee employee1 = new Employee("Anton", "Petrov", "man", 20, 2);

         employeeDAO.create(employee1);

        System.out.println(employeeDAO.readById(2));

        List<Employee> list = employeeDAO.readAll();

        for (Employee employee : list) {
           System.out.println(employee);
       }

        Employee employee2 = new Employee(2,"Alex", "Ivanov", "man", 19, 1);

        employeeDAO.updateEmployeeById(employee2);
       employeeDAO.deleteById(employee2);
    }
}