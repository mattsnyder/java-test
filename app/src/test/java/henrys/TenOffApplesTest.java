package henrys;

import java.math.BigDecimal;
import java.util.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class TenOffApplesTest {
  private Date today(){
    return new Date(2021, 5, 20); // DEBT
  }

  private Date tomorrow(){
    return new Date(2021, 5, 21); // DEBT
  }

  private Date yesterday(){
    return new Date(2021, 5, 19); // DEBT
  }

  private Date last_week(){
    return new Date(2021, 5, 16); // DEBT
  }

  @Test public void testOnEmptyBasket() {
    assertFalse(new TenOffApples().isApplicable(new Basket()));
    assertEquals(new BigDecimal("0.00"), new TenOffApples().getDiscount(new Basket()));
  }  

  @Test public void testWhenOneUnitOfApples() {
    Basket basketWithApples = new Basket();
    basketWithApples.addItem(new StockItemBuilder().withName("apples").withPrice("0.10").build());

    assertTrue(new TenOffApples().isApplicable(basketWithApples));
    assertEquals(new BigDecimal("0.01"), new TenOffApples().getDiscount(basketWithApples));
  }

  @Test public void testWhenDiscountStartsToday() {
    TenOffApples discount = new TenOffApples().startsOn(today());
    assertTrue(discount.isActive(today()));
  }

  @Test public void testWhenDiscountStartsTomorrow() {
    TenOffApples discount = new TenOffApples().startsOn(tomorrow());
    assertFalse(discount.isActive(today()));
  }

  @Test public void testWhenDiscountStartedLastWeekAndEndedYesterday() {
    TenOffApples discount = new TenOffApples().startsOn(last_week()).endsOn(yesterday());
    assertFalse(discount.isActive(today()));
  }

  // Assuming the Product Owner told us Discounts with no start or end are Active
  @Test public void testWhenNoStartOrEndSpecified() {
    assertTrue(new TenOffApples().isActive(today()));
  }
}
