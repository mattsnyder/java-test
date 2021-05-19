package henrys;

import henrys.StockItem;
import java.util.ArrayList;
import java.math.BigDecimal;

public class StockItemBuilder {
  String name = "Default Product";

  public StockItemBuilder() {}

  public StockItem build(){
    return new StockItem(this.name, "single", new BigDecimal(0));
  }

  public StockItemBuilder withName(String name){
    this.name = name;
    return this;
  }
}
