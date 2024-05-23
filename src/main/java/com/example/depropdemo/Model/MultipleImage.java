//package com.example.depropdemo.Model;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Table(name = "multiple_image")
//public class MultipleImage {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "image_id")
//    private int imageId;
//
//    @Column(name = "name", length = 256)
//    private String imageName;
//
//    @Column(name = "image_data", columnDefinition = "LONGTEXT")
//    @Lob
//    private String imageData;
//
//    @ManyToOne(cascade = {
//            CascadeType.PERSIST, CascadeType.MERGE,
//            CascadeType.DETACH, CascadeType.REFRESH
//    })
//    @JoinColumn(name = "product_id", nullable = false)
//    private Products product;
//}
