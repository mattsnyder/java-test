package henrys;

import java.math.BigDecimal;
import java.util.ArrayList;

public class TenOffApples implements DiscountStrategy {
  static final BigDecimal DISCOUNT = new BigDecimal(".01"); 

  @Override
  public BigDecimal getDiscount(Basket basket){
    BigDecimal num_apples = new BigDecimal(basket.contains("apples"));
    return DISCOUNT.multiply(num_apples); // DEBT: Should pull price from either basket of master price list
  }

  @Override
  public boolean isApplicable(Basket basket){
    return basket.contains("apples") > 0;
  }
}
