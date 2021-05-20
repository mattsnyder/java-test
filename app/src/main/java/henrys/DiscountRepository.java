package henrys;

import java.util.*;

import java.util.Date;
import java.util.ArrayList;

public class DiscountRepository {
  private ArrayList<DiscountStrategy> discounts = new ArrayList<DiscountStrategy>();

  public DiscountRepository(){
    this.discounts = new ArrayList<DiscountStrategy>();
  }

  public DiscountRepository(ArrayList<DiscountStrategy> discounts){
    this.discounts = discounts;
  }

  public ArrayList<DiscountStrategy> getActive(Date todays_date){

    return this.discounts;
  }  
}
