package ec.edu.epn.software.conexion;

import com.google.appengine.api.utils.SystemProperty;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class HibernateJPA {

    private static EntityManagerFactory emf;
    private static EntityManager em;

    private static Map<String, String> propiedades() {
        Map<String, String> properties = new HashMap();
        if (SystemProperty.environment.value()
                == SystemProperty.Environment.Value.Production) {
            properties.put("javax.persistence.jdbc.driver",
                    "com.mysql.jdbc.GoogleDriver");
            properties.put("javax.persistence.jdbc.url",
                    System.getProperty("cloudsql.url"));
        } else {
            properties.put("javax.persistence.jdbc.driver",
                    "com.mysql.jdbc.Driver");
            properties.put("javax.persistence.jdbc.url",
                    System.getProperty("cloudsql.url.dev"));
        }
        return properties;
    }

    private static EntityManagerFactory getEntityManagerFactory() {
        Map<String, String> properties = propiedades();
        emf = Persistence.createEntityManagerFactory(
                "Demo", properties);
        return emf;
    }

    public static EntityManager getEntityManager() {
        em = getEntityManagerFactory().createEntityManager();
        return em;
    }
}
