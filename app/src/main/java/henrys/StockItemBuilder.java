package henrys;

import henrys.StockItem;
import java.util.ArrayList;
import java.math.BigDecimal;

public class StockItemBuilder {
  String name = "Default Product";
  String price = "0"; // Use string constructor for BidDecimal

  public StockItemBuilder() {}

  public StockItem build(){
    return new StockItem(this.name, "single", new BigDecimal(this.price));
  }

  public StockItemBuilder withName(String name){
    this.name = name;
    return this;
  }

  public StockItemBuilder withPrice(String price){
    this.price = price;
    return this;
  }
}
