package org.example.pos.Model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "company_date")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Use camelCase for 'id'

    private String company_name;
    private String company_location;
    private String company_email;
    private String company_logo;
    private String company_phone_number;
}
