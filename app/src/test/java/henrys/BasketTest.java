package henrys;

import henrys.Basket;
import java.math.BigDecimal;

import org.junit.Test;
import static org.junit.Assert.*;

public class BasketTest {
  @Test public void testEmptyBasketHasZeroTotal() {
    Basket emptyBasket = new Basket();
    assertEquals(new BigDecimal(0), emptyBasket.getTotal());
  }

  @Test public void testBasketWithAUnitOfApplesTotalIsAccurate(){
    Basket basket = new Basket();
    StockItem apples = new StockItem("apples", "single", new BigDecimal(0.10));

    basket.addItem(apples);

    assertEquals(new BigDecimal(0.10), basket.getTotal());
  }
}
