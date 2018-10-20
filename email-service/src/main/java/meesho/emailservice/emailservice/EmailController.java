package meesho.emailservice.emailservice;

import meesho.data.DetailedOderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    private EmailSerice emailSerice;

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

        boolean result = emailSerice.sendEmail(order.getUser().getEmail(), subject, body);

        if(!result){
            return false;
        }

        if(order.getInvoiceUrl() != null && order.getInvoiceUrl().trim().length() > 0){
            orderService.updateEmailSendWithInvoice(orderId, true);
        }
        return true;
    }



}
