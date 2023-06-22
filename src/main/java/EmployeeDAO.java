import java.util.List;

public interface EmployeeDAO {

    void create(Employee employee);

    Employee readById(int id);

    List<Employee> readAll();

    void updateEmployeeById(Employee employee);

    void deleteById(Employee employee);
}
