package com.tippers.containment.live.repository.model.mysql;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Products {

    @Id
    private Long id;

    private String name;

    private Float price;
}