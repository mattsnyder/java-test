package henrys;

import java.math.BigDecimal;
import java.util.ArrayList;

public class TenOffApples implements DiscountStrategy {
  @Override
  public BigDecimal getDiscount(Basket basket){
    return BigDecimal.ZERO;
  }

  @Override
  public boolean isApplicable(Basket basket){
    return basket.contains("apples") > 0;
  }
}
