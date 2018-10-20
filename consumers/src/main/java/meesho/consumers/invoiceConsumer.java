package meesho.consumers;

import meesho.consumers.service.EmailService;
import meesho.consumers.service.InvoiceService;

public class invoiceConsumer {

    public InvoiceService invoiceService;
    public EmailService emailService;


    public boolean processOrder(String orderId){
        boolean result = invoiceService.generateInvoiceForOrder(orderId);

        result = emailService.sendEmailForOrder(orderId);

        return result;
    }
}
