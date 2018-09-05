package com.podo.todo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Item")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemEntity {
    @Id
    @GeneratedValue
    private int itemId;
    @Column
    private String description;
}
