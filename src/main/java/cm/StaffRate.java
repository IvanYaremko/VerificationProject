package cm;

import java.math.BigDecimal;

public class StaffRate implements ICalculate{
    @Override
    public BigDecimal calculateFee(BigDecimal fee) {
        BigDecimal maxPayable = new BigDecimal("16.00");

        // if the calculated fee is above the may payable fee, return maxPayable
        if(fee.compareTo(maxPayable) == 1){
            return maxPayable;
        }
        return  fee;

    }
}
