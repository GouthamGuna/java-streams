package in.dev.gmsk.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Setter
@Getter
public class Fee {

    private String totalAmount;
    private String totalBalance;
    private String totalFeeAmount;
    private List<Fee> feeList;
}
