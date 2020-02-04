package view;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Mail;
import static view.MailListBuilderBD.build;

public class MailListReaderBD {
    
    // Método que lee desde la Base de Datos los emails que se encuentran registrados
    
    public static List<Mail> read(Connection connection) throws SQLException {

        String SQL = "SELECT MAIL FROM EMAIL";
        List<Mail> mailList = new ArrayList<>();

        try{
            build(connection);
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery(SQL);
            while(resultset.next()){
                String mail = resultset.getString("Mail");
                mailList.add(new Mail(mail));
            }
        }
        catch(SQLException exception) {
            System.out.println("Error en Kata5::select(SQLException) " + exception.getMessage());
        }
        return mailList;
    }
}
