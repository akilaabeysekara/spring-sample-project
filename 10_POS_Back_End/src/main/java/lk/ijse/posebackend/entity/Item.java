package lk.ijse.posebackend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @Column(name = "iCode")
    private String iCode;

    @Column(name = "iName", nullable = false)
    private String iName;

    @Column(name = "iPrice", nullable = false, precision = 10, scale = 2)
    private BigDecimal iPrice;

    @Column(name = "iQty", nullable = false)
    private Integer iQty;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;
}
