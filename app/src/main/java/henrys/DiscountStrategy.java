package henrys;

import java.util.ArrayList;
import java.math.BigDecimal;
import java.util.Date;

public interface DiscountStrategy {
  public BigDecimal getDiscount(Basket basket);
  public boolean isApplicable(Basket basket);
}
