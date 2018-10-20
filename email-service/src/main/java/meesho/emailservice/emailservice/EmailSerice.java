package meesho.emailservice.emailservice;

import org.springframework.stereotype.Service;

@Service
public class EmailSerice {

    public boolean sendEmail(String toEmailId, String subject, String body){
        return true;
    }
}
