package view;

import java.util.List;
import model.Histogram;
import model.Mail;

public class MailHistogramBuilder {

    public static Histogram build(List<Mail> mailList) {
        
        Histogram<String> histogram = new Histogram();
        
        for(Mail mail : mailList) {
            histogram.increment(mail.getDomain());
        }
        
        return histogram;
    }
    
}
