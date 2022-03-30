package cm;

import java.math.BigDecimal;

public class VisitorRate implements ICalculate {
    @Override
    public BigDecimal calculateFee(BigDecimal fee) {
        BigDecimal amountFree = new BigDecimal("10.00");
        BigDecimal discountRate = new BigDecimal("0.50");

        if(fee.compareTo(amountFree) == -1){
            return BigDecimal.ZERO;
        } else{
            return (fee.subtract(amountFree)).multiply(discountRate);
        }
    }
}
