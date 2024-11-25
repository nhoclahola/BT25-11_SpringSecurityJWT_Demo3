package com.nhoclahola.bt2511_springsecurityjwt_demo3.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Products")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 255)
    private String name;
    @Column(length = 255)
    private String brand;
    @Column(length = 255)
    private String madein;
    private float price;
}
