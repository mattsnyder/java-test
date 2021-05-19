package henrys;

import java.math.BigDecimal;

import org.junit.Test;
import static org.junit.Assert.*;

public class TenOffApplesTest {
  @Test public void testOnEmptyBasket() {
    assertEquals(BigDecimal.ZERO, new TenOffApples().getDiscount(new Basket()));
  }  
}
