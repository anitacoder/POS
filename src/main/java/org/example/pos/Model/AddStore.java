package org.example.pos.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Store_Data")
public class AddStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int store_id;

    private String name;

    private String manager;

    private String location;

    private String StorePhone;

    private String status;

}
