package cm;

import java.math.BigDecimal;

public class CalculateContext {
    private ICalculate calculate;

    public CalculateContext(ICalculate calculate) {
        this.calculate = calculate;
    }

    public BigDecimal calculateFee(BigDecimal fee){
        return calculate.calculateFee(fee);
    }
}
