package com.example.depropdemo.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.security.SecureRandom;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private Integer orderId; // Mã đơn hàng

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private Double totalprice;

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    private String status;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderDetail> orderDetails;

    @PrePersist
    public void generateRandomOrderId() {
        if (this.orderId == null) {
            SecureRandom random = new SecureRandom();
            this.orderId = 10000 + random.nextInt(90000);
        }
    }
}

