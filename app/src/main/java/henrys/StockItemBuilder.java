package henrys;

import henrys.StockItem;
import java.util.ArrayList;
import java.math.BigDecimal;

public class StockItemBuilder {
  String name = "Default Product";
  String unit = "single";
  String price = "0"; // Use string constructor for BidDecimal

  public StockItemBuilder() {}

  public StockItem build(){
    return new StockItem(this.name, this.unit, new BigDecimal(this.price));
  }

  public StockItemBuilder withName(String name){
    this.name = name;
    return this;
  }

  public StockItemBuilder withPrice(String price){
    this.price = price;
    return this;
  }

  public StockItemBuilder withUnit(String unit){
    this.unit = unit;
    return this;
  }
}
