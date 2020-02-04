
package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBD {
    
    // Método que realiza la conexión con la Base de Datos
    
    public static Connection connect() {
        String URL_BD_SQLite = "jdbc:sqlite:/Users/ana/Desktop/Kata5P2/src/main/KATA5.db";
        Connection connection = null;
        
        try {
            connection = DriverManager.getConnection(URL_BD_SQLite);
            System.out.println("Conexion establecida con la Base de Datos...");
        } catch(SQLException e){
            System.out.println("Error en Kata5::connect(SQLException) " + e.getMessage());
        }

        return connection;
    }
}
