import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CityDAOImpl implements CityDAO {

    @Override
    public void create(City city) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(city);
            transaction.commit();
        }
    }
        @Override
        public City readById(int id){
            return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(City.class, id);
            }



        @Override
        public List<City> readAll () {
            try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
                return session.createQuery("From City ").list();
            }
        }

        @Override
        public void updateCityById (City city){
            try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
                Transaction transaction = session.beginTransaction();
                session.save(city);
                transaction.commit();
            }
        }

        @Override
        public void deleteByCityId (City city){
            try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.delete(city);
                transaction.commit();
            }
        }
    }
