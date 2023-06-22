import java.util.List;

public interface CityDAO {

    void create(City city);

    City readById(int id);

    List<City> readAll();

    void updateCityById(City city);

    void deleteByCityId(City city);
}
