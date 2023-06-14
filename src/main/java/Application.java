import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException {
        final String user = "postgres";
        final String password = "Alex2183263";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("SELECT first_name, last_name, gender, city_name FROM employee INNER JOIN city ON employee.city_id = city.city_id WHERE id = (?)")) {

            statement.setInt(1, 1);
            final ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String employeeName = "Name: " + resultSet.getString("first_name");
                String employeeLastName = "Last name: " + resultSet.getString("last_name");
                String employeeGender = "Gender: " + resultSet.getString("gender");
                String employeeCity = "City: " + resultSet.getString("city_name");


                System.out.println(employeeName);
                System.out.println(employeeLastName);
                System.out.println(employeeGender);
                System.out.println(employeeCity);

            }
        }
        try (final Connection connection = DriverManager.getConnection(url, user, password)) {
            EmployeeDAO employeeDAO = new EmployeeDAOImpl(connection);
          employeeDAO.create(new Employee("Serge", "Snow", "man", 35, new City(5, "Omsk")));

             System.out.println(employeeDAO.readById(5));

            List<Employee> employeeList = new ArrayList<>(employeeDAO.readAll());
            employeeList.forEach(System.out::println);

            employeeDAO.updateEmployeeById(5, "Andrey", "Petrov", "man", 40, 1);
         employeeDAO.deleteById(5);

        }
    }
}