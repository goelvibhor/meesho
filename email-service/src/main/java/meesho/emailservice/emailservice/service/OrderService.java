package meesho.emailservice.emailservice.service;

import meesho.data.DetailedOderDto;
import meesho.data.OrderDto;
import meesho.data.PaymentDetailsDto;
import meesho.data.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderService {

    @Autowired
    private UserService userService;

    @Autowired
    private PaymentService paymentService;

    public OrderDto getOrder(String orderId){
        return null;
    }

    public DetailedOderDto getDetailedOrder(String orderId){
        OrderDto order = getOrder(orderId);

        if(order == null)
            return null;

        UserDto user = userService.getUser(order.getUserId());
        PaymentDetailsDto paymentDetails = paymentService.getPaymentDetails(order.getPaymentTransactionId());
        return new DetailedOderDto(order, user, paymentDetails);
    }

    // it should retry 3 times before failing
    public boolean updateEmailSendWithInvoice(String orderId, boolean emailSendWithInvoice){
        return true;
    }

}
