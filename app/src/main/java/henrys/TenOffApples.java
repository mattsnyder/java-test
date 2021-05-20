package henrys;

import java.util.Date;
import java.math.BigDecimal;
import java.util.ArrayList;

public class TenOffApples implements DiscountStrategy {
  static final BigDecimal DISCOUNT = new BigDecimal(".01"); 
  private Date startDate;

  @Override
  public BigDecimal getDiscount(Basket basket){
    BigDecimal num_apples = new BigDecimal(basket.contains("apples"));
    return DISCOUNT.multiply(num_apples); // DEBT: Should pull price from either basket of master price list
  }

  @Override
  public boolean isApplicable(Basket basket){
    return basket.contains("apples") > 0;
  }

  @Override
  public boolean isActive(Date now){
    return now.compareTo(startDate) >= 0;
  }

  public TenOffApples startsOn(Date startDate){
    this.startDate = startDate;
    return this;
  }
}
