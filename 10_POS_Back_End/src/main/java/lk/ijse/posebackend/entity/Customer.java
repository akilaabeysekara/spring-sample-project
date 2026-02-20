package lk.ijse.posebackend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @Column(nullable = false, unique = true)
    private String id;
    private String name;
    private String address;
    private String phone;
}
