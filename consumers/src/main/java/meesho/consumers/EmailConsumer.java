package meesho.consumers;

import meesho.consumers.service.EmailService;
import meesho.consumers.service.InvoiceService;

public class EmailConsumer {

    public EmailService emailService;


    public void processOrder(String orderId){
        if(!emailService.sendEmailForOrder(orderId)){
            // push to failure email topic
        }
    }
}
