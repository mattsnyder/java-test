package henrys;

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

  @Test public void testSpecifyingTheName(){
    StockItem item = new StockItemBuilder()
      .withName("Something Different")
      .build();

    assertEquals("Something Different", item.getName());
  }

  @Test public void testSpecifyingThePrice(){
    StockItem item = new StockItemBuilder()
      .withPrice("1.10")
      .build();

    assertEquals(new BigDecimal("1.10"), item.getPrice());
  }

  @Test public void testSpecifyingTheUnit(){
    StockItem item = new StockItemBuilder()
      .withUnit("tin")
      .build();

    assertEquals("tin", item.getUnit());
  }
}
