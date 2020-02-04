package main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import view.HistogramDisplay;
import model.Histogram;
import model.Mail;
import static view.ConnectionBD.connect;
import view.MailHistogramBuilder;
import static view.MailListBuilderBD.selectData_EMAIL;
import view.MailListReaderBD;

public class Main {

    public static void main(String[] args) throws SQLException {
        Connection connection = connect();
        List<Mail> mailList = MailListReaderBD.read(connection);
        Histogram histogram = MailHistogramBuilder.build(mailList);
        HistogramDisplay display = new HistogramDisplay(histogram);
        selectData_EMAIL(connection);
        display.execute();
    }
}
