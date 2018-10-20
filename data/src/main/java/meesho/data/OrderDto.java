package meesho.data;

import java.util.Date;
import java.util.List;

public class OrderDto {

    private String orderId;
    private String userId;
    private List<ProductDto> products;
    private String address;
    private Double totalAmount ;
    private Double pendingAmount;
    private Date date;
    private String invoiceUrl;
    private boolean emailSendWithInvoice;
    private String paymentTransactionId;

    public OrderDto(String orderId, String userId, List<ProductDto> products, String address, Double totalAmount, Double pendingAmount, Date date, String invoiceUrl, boolean emailSendWithInvoice, String paymentTransactionId) {
        this.orderId = orderId;
        this.userId = userId;
        this.products = products;
        this.address = address;
        this.totalAmount = totalAmount;
        this.pendingAmount = pendingAmount;
        this.date = date;
        this.invoiceUrl = invoiceUrl;
        this.emailSendWithInvoice = emailSendWithInvoice;
        this.paymentTransactionId = paymentTransactionId;
    }



    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getPaymentTransactionId() {
        return paymentTransactionId;
    }

    public void setPaymentTransactionId(String paymentTransactionId) {
        this.paymentTransactionId = paymentTransactionId;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "orderId='" + orderId + '\'' +
                ", userId='" + userId + '\'' +
                ", products=" + products +
                ", address='" + address + '\'' +
                ", totalAmount=" + totalAmount +
                ", pendingAmount=" + pendingAmount +
                ", date=" + date +
                ", invoiceUrl='" + invoiceUrl + '\'' +
                ", emailSendWithInvoice=" + emailSendWithInvoice +
                ", paymentTransactionId='" + paymentTransactionId + '\'' +
                '}';
    }
}


