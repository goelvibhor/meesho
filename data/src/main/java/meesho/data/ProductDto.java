package meesho.data;

public class ProductDto {

    private String productId;
    private String imageUrl;
    private Integer quantity;
    private Double amount;
    private Double totalDiscount;

    public ProductDto(String productId, String imageUrl, Integer quantity, Double amount, Double totalDiscount) {
        this.productId = productId;
        this.imageUrl = imageUrl;
        this.quantity = quantity;
        this.amount = amount;
        this.totalDiscount = totalDiscount;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(Double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "productId='" + productId + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", quantity=" + quantity +
                ", amount=" + amount +
                ", totalDiscount=" + totalDiscount +
                '}';
    }
}
