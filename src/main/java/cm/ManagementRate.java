package cm;

import java.math.BigDecimal;

public class ManagementRate implements ICalculate{
    @Override
    public BigDecimal calculateFee(BigDecimal fee) {
        BigDecimal minFee = new BigDecimal("4.00");

        // if the minimum fee is greater than the calculate fee, return the minFee
        if(fee.compareTo(minFee) == -1){
            return minFee;
        }
        return fee;

    }
}
