package lk.ijse.posebackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDetailDto {
    private String itemId;
    private double unitPrice;
    private int qty;
    private double subTotal;
}
