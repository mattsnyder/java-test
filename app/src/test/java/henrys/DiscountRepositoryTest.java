package henrys;

import java.util.*;
import java.math.BigDecimal;

import org.junit.Test;
import static org.junit.Assert.*;

public class DiscountRepositoryTest {
  // DEBT: Introduce Mokito here for fake discounts?
  public class ActiveDiscount implements DiscountStrategy {
    @Override
    public boolean isActive(Date now){
      return true;
    }

    @Override
    public boolean isApplicable(Basket basket){
      return true;
    }

    @Override
    public BigDecimal getDiscount(Basket basket){
      return BigDecimal.ZERO;
    }
  }

  // DEBT: Introduce Mokito here for fake discounts?
  public class InActiveDiscount implements DiscountStrategy {
    @Override
    public boolean isActive(Date now){
      return false;
    }

    @Override
    public boolean isApplicable(Basket basket){
      return false;
    }

    @Override
    public BigDecimal getDiscount(Basket basket){
      return BigDecimal.ZERO;
    }
  }

  private Date today(){
    return new Date(2021, 3, 20);
  }

  @Test public void testGetActiveWhenEmpty(){
    assertTrue(new DiscountRepository().getActive(today()).isEmpty());
  }

  @Test public void testGetActiveWhenOneIsActive(){
    DiscountRepository repo = new DiscountRepository(new ArrayList<DiscountStrategy>(Arrays.asList(new ActiveDiscount())));
    assertFalse(repo.getActive(today()).isEmpty());
  }

  @Test public void testGetActiveWithMixedDiscounts(){
    DiscountRepository repo = new DiscountRepository(new ArrayList<DiscountStrategy>(Arrays.asList(new ActiveDiscount(), new InActiveDiscount())));
    assertEquals(1, repo.getActive(today()).size());
  }
}
