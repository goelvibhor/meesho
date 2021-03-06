package meesho.consumers;

import meesho.consumers.service.EmailService;
import meesho.consumers.service.InvoiceService;

public class InvoiceConsumer {

    public InvoiceService invoiceService;
    public EmailService emailService;


    public void processOrder(String orderId){

        if(!invoiceService.generateInvoiceForOrder(orderId)){
            //push to failure invoice topic with proper message
            return;
        }

        if(!emailService.sendEmailForOrder(orderId)){
            // push to failure email topic
        }
    }
}
