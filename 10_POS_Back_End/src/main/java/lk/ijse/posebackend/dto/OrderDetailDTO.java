package lk.ijse.posebackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDetailDTO {
    private Long id;
    private String orderId;
    private String itemCode;
    private Integer qty;
    private BigDecimal unitPrice;
}