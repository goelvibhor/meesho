package meesho.emailservice.emailservice.service;

import org.springframework.stereotype.Service;

@Service
public class EmailService {

    public boolean sendEmail(String toEmailId, String subject, String body){
        return true;
    }
}
