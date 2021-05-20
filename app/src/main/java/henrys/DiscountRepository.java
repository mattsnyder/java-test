package henrys;

import java.util.*;
import java.util.stream.*;

public class DiscountRepository {
  private List<DiscountStrategy> discounts = new ArrayList<DiscountStrategy>();

  public DiscountRepository(){
    this.discounts = new ArrayList<DiscountStrategy>();
  }

  public DiscountRepository(ArrayList<DiscountStrategy> discounts){
    this.discounts = discounts;
  }

  public ArrayList getActive(Date todays_date){
    List active = this.discounts
      .stream()
      .filter(discount -> discount.isActive(todays_date))
      .collect(Collectors.<DiscountStrategy>toList());

    return new ArrayList<DiscountStrategy>(active);
  }  
}
