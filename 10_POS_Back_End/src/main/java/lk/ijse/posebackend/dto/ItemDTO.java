package lk.ijse.posebackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemDTO {
    private String iCode;
    private String iName;
    private String iPrice;
    private String iQty;
}
