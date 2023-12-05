package com.service.FoodAndTravel.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long categoryId;
    private String name;
    private String image;
    private String description;
}
