package meesho.data;

import java.util.Date;
import java.util.List;

public class DetailedOderDto {

    private String orderId;
    private UserDto user;
    private List<ProductDto> products;
    private String address;
    private Double totalAmount ;
    private Double pendingAmount;
    private Date date;
    private String invoiceUrl;
    private boolean emailSendWithInvoice;
    private PaymentDetailsDto paymentDetails;

    public DetailedOderDto(String orderId, UserDto user, List<ProductDto> products, String address, Double totalAmount, Double pendingAmount, Date date, String invoiceUrl, boolean emailSendWithInvoice, PaymentDetailsDto paymentDetails) {
        this.orderId = orderId;
        this.user = user;
        this.products = products;
        this.address = address;
        this.totalAmount = totalAmount;
        this.pendingAmount = pendingAmount;
        this.date = date;
        this.invoiceUrl = invoiceUrl;
        this.emailSendWithInvoice = emailSendWithInvoice;
        this.paymentDetails = paymentDetails;
    }

    public DetailedOderDto(OrderDto order, UserDto user, PaymentDetailsDto paymentDetails) {
        this.orderId = order.getOrderId();
        this.user = user;
        this.products = order.getProducts();
        this.address = order.getAddress();
        this.totalAmount = order.getTotalAmount();
        this.pendingAmount = order.getPendingAmount();
        this.date = order.getDate();
        this.invoiceUrl = order.getInvoiceUrl();
        this.emailSendWithInvoice = order.isEmailSendWithInvoice();
        this.paymentDetails = paymentDetails;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getPendingAmount() {
        return pendingAmount;
    }

    public void setPendingAmount(Double pendingAmount) {
        this.pendingAmount = pendingAmount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getInvoiceUrl() {
        return invoiceUrl;
    }

    public void setInvoiceUrl(String invoiceUrl) {
        this.invoiceUrl = invoiceUrl;
    }

    public boolean isEmailSendWithInvoice() {
        return emailSendWithInvoice;
    }

    public void setEmailSendWithInvoice(boolean emailSendWithInvoice) {
        this.emailSendWithInvoice = emailSendWithInvoice;
    }

    public PaymentDetailsDto getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(PaymentDetailsDto paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    @Override
    public String toString() {
        return "DetailedOderDto{" +
                "orderId='" + orderId + '\'' +
                ", user=" + user +
                ", products=" + products +
                ", address='" + address + '\'' +
                ", totalAmount=" + totalAmount +
                ", pendingAmount=" + pendingAmount +
                ", date=" + date +
                ", invoiceUrl='" + invoiceUrl + '\'' +
                ", emailSendWithInvoice=" + emailSendWithInvoice +
                ", paymentDetails=" + paymentDetails +
                '}';
    }
}
