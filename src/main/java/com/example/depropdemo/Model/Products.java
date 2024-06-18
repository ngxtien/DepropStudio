package com.example.depropdemo.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aspectj.weaver.loadtime.definition.Definition;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double price;

    private Integer quantity;

    @Lob
    @Column(length = Integer.MAX_VALUE)
    private String image;

    private String description;

}
