package henrys;

import java.util.ArrayList;
import java.math.BigDecimal;

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
    return this.addItem(itemToAdd, 1);
  }

  public Basket addItem(StockItem itemToAdd, Integer quantity){
    for (int i=0; i<quantity; i++) {
      contents.add(itemToAdd);
    }
    return this;
  }

  public Integer contains(String itemName){
    Long count = contents
      .stream()
      .map(i -> i.getName())
      .filter(name -> name == itemName)
      .count();

    return count.intValue();
  }
}
