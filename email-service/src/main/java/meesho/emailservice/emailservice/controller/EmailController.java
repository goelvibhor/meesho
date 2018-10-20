package meesho.emailservice.emailservice.controller;

import meesho.data.DetailedOderDto;
import meesho.emailservice.emailservice.service.EmailService;
import meesho.emailservice.emailservice.service.FormaterService;
import meesho.emailservice.emailservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private FormaterService formaterService;

    @Autowired
    private EmailService emailService;

    @PostMapping("/sendemail/order/{orderId}")
    public Boolean sendEmailForOrder(@PathVariable String orderId) {
        //validate input parameter

        if(StringUtils.isEmpty(orderId)){
            // return bad request
            return false;
        }

        DetailedOderDto order = orderService.getDetailedOrder(orderId);

        String subject = formaterService.formatEmailSubject(order);
        String body = formaterService.formatEmailBody(order);

        boolean result = emailService.sendEmail(order.getUser().getEmail(), subject, body);

        if(!result){
            return false;
        }

        if(order.getInvoiceUrl() != null && order.getInvoiceUrl().trim().length() > 0){
            orderService.updateEmailSendWithInvoice(orderId, true);
        }
        return true;
    }



}
