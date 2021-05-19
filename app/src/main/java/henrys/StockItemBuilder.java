package henrys;

import henrys.StockItem;
import java.util.ArrayList;
import java.math.BigDecimal;

public class StockItemBuilder {
  public StockItem build(){
    return new StockItem("Default Product","single", new BigDecimal(0));
  }
}
