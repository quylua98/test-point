package com.quylua98.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Detail {
    @Id
    private Long id;
    private String address;
}
