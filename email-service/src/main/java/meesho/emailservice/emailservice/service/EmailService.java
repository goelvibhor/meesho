package meesho.emailservice.emailservice.service;

import org.springframework.stereotype.Service;

@Service
public class EmailService {

    // it will retry 3 times before failing the call
    public boolean sendEmail(String toEmailId, String subject, String body){
        return true;
    }
}
