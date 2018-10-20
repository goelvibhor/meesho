package meesho.data;

public class PaymentDetailsDto {

    private String ordreId;
    private String paymentId;
    private String userId;
    private Double amount;
    private Double tax;

    public PaymentDetailsDto(String ordreId, String paymentId, String userId, Double amount, Double tax) {
        this.ordreId = ordreId;
        this.paymentId = paymentId;
        this.userId = userId;
        this.amount = amount;
        this.tax = tax;
    }

    public String getOrdreId() {
        return ordreId;
    }

    public void setOrdreId(String ordreId) {
        this.ordreId = ordreId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    @Override
    public String toString() {
        return "PaymentDetailsDto{" +
                "ordreId='" + ordreId + '\'' +
                ", paymentId='" + paymentId + '\'' +
                ", userId='" + userId + '\'' +
                ", amount=" + amount +
                ", tax=" + tax +
                '}';
    }
}
