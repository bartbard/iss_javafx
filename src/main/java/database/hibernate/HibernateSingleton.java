package database.hibernate;

import database.model.*;
import database.repository.ISSRepository;
import controllers.openNotify.OpenNotifyInformation;
import lombok.Data;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
@Data
public class HibernateSingleton {
    public static HibernateSingleton INSTANCE = new HibernateSingleton();
    private ISSRepository issRepository;

    private HibernateSingleton(){
        final String URL = "/hibernateConfig/hibernate.cfg.xml";

        SessionFactory sessionFactory = new Configuration()
                .configure(URL)
                .addAnnotatedClass(Astronaut.class)
                .addAnnotatedClass(City.class)
                .addAnnotatedClass(PassPrediction.class)
                .addAnnotatedClass(Position.class)
                .addAnnotatedClass(Speed.class)
                .buildSessionFactory();

        issRepository = new ISSRepository(sessionFactory.createEntityManager());
        try {
            issRepository.saveAstronauts(OpenNotifyInformation.getPeopleInSpace());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static HibernateSingleton getInstance(){
        return INSTANCE;
    }


}
