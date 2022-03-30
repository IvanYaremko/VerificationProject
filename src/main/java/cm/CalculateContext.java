package cm;

import java.math.BigDecimal;

public class CalculateContext {
    private ICalculate calculate;

    public CalculateContext(CarParkKind kind) {
        switch (kind) {
            case VISITOR:
                this.calculate = new VisitorRate();
                break;
            case MANAGEMENT:
                this.calculate  = new ManagementRate();
                break;
            case STUDENT:
                this.calculate = new StudentRate();
                break;
            case STAFF:
                this.calculate  = new StaffRate();
                break;
        }
    }

    public BigDecimal calculateFee(BigDecimal fee){
        return calculate.calculateFee(fee).setScale(2);
    }
}
