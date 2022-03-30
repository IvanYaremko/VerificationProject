package cm;

import java.math.BigDecimal;

public class StudentRate implements ICalculate{
    @Override
    public BigDecimal calculateFee(BigDecimal fee) {
        BigDecimal aboveRate = new BigDecimal("5.50");
        BigDecimal discountRate = new BigDecimal("0.25");

        // if the fee is greater  to the the aboveRate, than the discount applies
        if(fee.compareTo(aboveRate) > 0 ) {
            return fee.subtract(fee.multiply(discountRate));
        }
        return fee;
    }
}
