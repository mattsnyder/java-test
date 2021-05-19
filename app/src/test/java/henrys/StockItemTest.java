package henrys;

import java.math.BigDecimal;

import org.junit.Test;
import static org.junit.Assert.*;

public class StockItemTest {
  @Test public void testCanConstructWithAttributes(){
    StockItem item = new StockItem("apple", "single", new BigDecimal(0.35));

    assertEquals("apple", item.getName());
    assertEquals("single", item.getUnit());
    assertEquals(new BigDecimal(0.35), item.getPrice());
  }
}