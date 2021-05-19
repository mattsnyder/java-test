package henrys;

import henrys.StockItem;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Basket {
  private final ArrayList<StockItem> contents = new ArrayList<StockItem>();

  public BigDecimal getTotal(){
    BigDecimal total = contents
      .stream()
      .map(i -> i.getPrice())
      .reduce(BigDecimal.ZERO, BigDecimal::add);
    
    return total;
  }

  public Basket addItem(StockItem itemToAdd){
    contents.add(itemToAdd);
    return this;
  }
}
