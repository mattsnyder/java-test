package henrys;

import java.util.*;
import java.math.BigDecimal;

public class Basket {
  private final ArrayList<StockItem> contents = new ArrayList<StockItem>();
  private DiscountRepository discountRepo = new DiscountRepository();

  public BigDecimal getTotal(Date checkoutDate){
    ArrayList<DiscountStrategy> activeDiscounts = discountRepo.getActive(checkoutDate);
    BigDecimal totalDiscounts = activeDiscounts
      .stream()
      .map(discount -> discount.getDiscount(this))
      .reduce(BigDecimal.ZERO, BigDecimal::add);
    
    return getTotal().subtract(totalDiscounts);
  }

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

  public Basket withDiscounts(DiscountRepository discountRepo){
    this.discountRepo = discountRepo;
    return this;
  }
}
