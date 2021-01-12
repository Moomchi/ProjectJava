package com.mimi.FoodDelivery.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="products_list")
public class ProductsList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="product_table_id")
    private Integer productTableId;

    @Column(name="product_id")
    private Integer productId;

    @Column(name="quantity")
    private Integer quantity;

    @Column(name="customer_id")
    private Integer customerId;

    @Column(name="products_price")
    private BigDecimal productsPrice;

    public ProductsList() {
    }

    public ProductsList(Long id, Integer productTableId, Integer productId, Integer quantity,Integer customerId ,BigDecimal productsPrice) {
        this.id = id;
        this.productTableId = productTableId;
        this.productId = productId;
        this.quantity = quantity;
        this.productsPrice = productsPrice;
        this.customerId = customerId;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Integer getProductTableId() { return productTableId; }

    public void setProductTableId(Integer productTableId) { this.productTableId = productTableId; }

    public Integer getProductId() { return productId; }

    public void setProductId(Integer productId) { this.productId = productId; }

    public Integer getQuantity() { return quantity; }

    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public BigDecimal getProductsPrice() { return productsPrice; }

    public void setProductsPrice(BigDecimal productsPrice) { this.productsPrice = productsPrice; }

    public Integer getCustomerId() { return customerId; }

    public void setCustomerId(Integer customerId) { this.customerId = customerId; }
}
