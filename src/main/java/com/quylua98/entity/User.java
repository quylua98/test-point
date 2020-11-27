package com.quylua98.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class User {
    @Id
    private Long id;
    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Set<Detail> details;
    private String name;
}
