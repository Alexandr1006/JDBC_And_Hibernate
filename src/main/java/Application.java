import java.util.List;

public class Application {
    public static void main(String[] args) {

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        CityDAO cityDAO = new CityDAOImpl();

        Employee employee1 = new Employee("Anton", "Petrov", "man", 20, new City("Omsk"));

         employeeDAO.create(employee1);

        System.out.println(employeeDAO.readById(2));

        List<Employee> list = employeeDAO.readAll();

        for (Employee employee : list) {
           System.out.println(employee);
       }

        Employee employee2 = new Employee(2,"Alex", "Ivanov", "man", 19, new City("Irkutsk") );

        employeeDAO.updateEmployeeById(employee2);

       employeeDAO.deleteById(employee2);

        City city1 = new City("Tver");
        cityDAO.create(city1);

        System.out.println(cityDAO.readById(1));

        List<City> cityList = cityDAO.readAll();
        cityList.forEach(System.out::println);

        City city2 = new City("Sochi");
        cityDAO.updateCityById(city2);

        cityDAO.deleteByCityId(city2);
    }
}