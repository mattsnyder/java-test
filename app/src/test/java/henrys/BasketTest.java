package henrys;

import java.math.BigDecimal;

import org.junit.Test;
import static org.junit.Assert.*;

public class BasketTest {
  @Test public void testEmptyBasketHasZeroTotal() {
    assertEquals(new BigDecimal(0), new Basket().getTotal());
  }

  @Test public void testBasketWithAUnitOfApplesTotalIsAccurate(){
    Basket basket = new Basket();
    StockItem apples = new StockItemBuilder().withPrice("0.10").build();

    basket.addItem(apples);

    assertEquals(new BigDecimal("0.10"), basket.getTotal());
  }

  @Test public void testBasketWithMultipleItemsTotalIsAccurate(){
    Basket basket = new Basket();
    basket.addItem(new StockItemBuilder().withPrice("0.10").build());
    basket.addItem(new StockItemBuilder().withPrice("0.65").build());

    assertEquals(new BigDecimal("0.75"), basket.getTotal());
  }

  @Test public void testBasketWithMultipleOfSameItemNameAndPrice(){
    Basket basket = new Basket();
    basket.addItem(new StockItemBuilder().withPrice("1.20").withName("bread").build());
    basket.addItem(new StockItemBuilder().withPrice("1.20").withName("bread").build());
    basket.addItem(new StockItemBuilder().withPrice("1.20").withName("bread").build());

    assertEquals(new BigDecimal("3.60"), basket.getTotal());
  }
}
