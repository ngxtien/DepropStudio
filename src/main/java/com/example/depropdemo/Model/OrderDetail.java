package com.example.depropdemo.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private CustomerOrder order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Products product;

    private Integer quantity;

    private Double Price;

    private String startDate;

    private String endDate;

    public Long getProductID() {
        return product != null ? product.getId() : null;
    }

}
