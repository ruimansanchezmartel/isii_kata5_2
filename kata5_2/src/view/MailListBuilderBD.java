package view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class MailListBuilderBD {
    
    // Método que lee desde el fichero de emails y los inserta en la BD
    
    public static void build(Connection connection) {
        String SQL = "INSERT INTO EMAIL(MAIL) VALUES (?)";
        List<String> emails = MailListReader.read("/Users/ana/Desktop/Kata5P2/src/main/email.txt");
     
        try {
            for(String email : emails){
                PreparedStatement preparedstatement = connection.prepareStatement(SQL);
                preparedstatement.setString(1, email);
                preparedstatement.executeUpdate();
            }
        }
        catch(SQLException exception) {
            System.out.println("Error en Kata5::preparedStatement(SQLException) " + exception.getMessage());
        }
    }
    
    // Método que selecciona todos los campos de la tabla EMAIL
    
    public static void selectData_EMAIL(Connection connection) {
        String SQL = "SELECT * FROM EMAIL";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery(SQL);
            System.out.println("ID \t MAIL");
            while(resultset.next()) {
                System.out.println(resultset.getInt("ID") + "\t " 
                                    + resultset.getString("Mail"));
            }
        }
        catch(SQLException exception) {
            System.out.println("Error en Kata5::select(SQLException) " + exception.getMessage());
        }
    }
}
