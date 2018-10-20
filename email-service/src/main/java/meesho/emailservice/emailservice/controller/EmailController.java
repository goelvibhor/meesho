package meesho.emailservice.emailservice.controller;

import meesho.data.DetailedOderDto;
import meesho.emailservice.emailservice.service.EmailService;
import meesho.emailservice.emailservice.service.FormatterService;
import meesho.emailservice.emailservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.http.HttpStatus;
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
    private FormatterService formatterService;

    @Autowired
    private EmailService emailService;

    /*
    improvements: make all the service calls asynchronous
    */


    @PostMapping(value = "/sendemail/order/{orderId}", produces = "application/json")
    public ResponseEntity<Boolean> sendEmailForOrder(@PathVariable String orderId) {
        //validate input parameter
        if(StringUtils.isEmpty(orderId)){
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }

        DetailedOderDto order = orderService.getDetailedOrder(orderId);
        if(order == null){
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }

        boolean result;
        try {
            // if something went wrong, function will raise exception
            String subject = formatterService.formatEmailSubject(order);
            String body = formatterService.formatEmailBody(order);

            result = emailService.sendEmail(order.getUser().getEmail(), subject, body);
        } catch (Exception e){
            //log
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (!result) {
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (order.getInvoiceUrl() != null && order.getInvoiceUrl().trim().length() > 0) {
            try {
                orderService.updateEmailSendWithInvoice(orderId, true);
            } catch (Exception e) {
                //log error
                // push to monitoring as will
                // push to error queue with message "failed to update EmailSendWithInvoice: true for irder id: {orderId}" in the error queue
            }
        }

        return new ResponseEntity<>(true, HttpStatus.OK);
    }



}
