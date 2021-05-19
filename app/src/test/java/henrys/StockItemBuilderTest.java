package henrys;

import henrys.StockItem;
import henrys.StockItemBuilder;
import java.math.BigDecimal;

import org.junit.Test;
import static org.junit.Assert.*;

public class StockItemBuilderTest {
  @Test public void testDefaultSettings(){
    StockItemBuilder builder = new StockItemBuilder();
    StockItem builtItem = builder.build();

    assertEquals(BigDecimal.ZERO, builtItem.getPrice());
    assertEquals("Default Product", builtItem.getName());
    assertEquals("single", builtItem.getUnit());
  }
}
