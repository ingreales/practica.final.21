package configuraciones;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Named;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ProducerResources {
    // Este método produce una conexión a la base de datos y está marcado como productor
    // El alcance de esta conexión es de solicitud (RequestScoped)
    @Produces
    @RequestScoped
    @Named("conn")
    private Connection beanConnection() throws NamingException, SQLException {
        // Se crea un contexto inicial
        Context initContext = new InitialContext();
        // Se busca el contexto de entorno (env) dentro del contexto inicial
        Context envContext = (Context) initContext.lookup("java:/comp/env");
        // Se busca el recurso de origen de datos (DataSource) llamado "jdbc/mysqlDB" dentro del contexto de entorno
        DataSource ds = (DataSource) envContext.lookup("jdbc/mysqlDB");
        // Se obtiene una conexión de la fuente de datos (DataSource)
        return ds.getConnection();
    }
}
