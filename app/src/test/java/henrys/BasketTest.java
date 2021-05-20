package henrys;

import java.math.BigDecimal;
import java.util.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class BasketTest {
  private Date today(){
    return new Date(2021, 5, 20); // DEBT
  }

  private Date inFiveDays(){
    return new Date(2021, 5, 25); // DEBT
  }

  private Date inThreeDays(){
    return new Date(2021, 5, 23); // DEBT
  }

  private Date endOfNextMonth(){
    return new Date(2021, 6, 30); // DEBT
  }

  @Test public void testEmptyBasketHasZeroTotal() {
    assertEquals(new BigDecimal(0), new Basket().getTotal());
  }

  @Test public void testBasketWithAUnitOfApplesTotalIsAccurate(){
    Basket basket = new Basket();
    StockItem apples = new StockItemBuilder().withPrice("0.10").build();

    basket.addItem(apples);

    assertEquals(new BigDecimal("0.10"), basket.getTotal());
  }

  @Test public void testBasketWithMultipleItemsTotalIsAccurate(){
    Basket basket = new Basket();
    basket.addItem(new StockItemBuilder().withPrice("0.10").build());
    basket.addItem(new StockItemBuilder().withPrice("0.65").build());

    assertEquals(new BigDecimal("0.75"), basket.getTotal());
  }

  @Test public void testBasketWithMultipleOfSameItemNameAndPrice(){
    Basket basket = new Basket();
    basket.addItem(new StockItemBuilder().withPrice("1.20").withName("bread").build());
    basket.addItem(new StockItemBuilder().withPrice("1.20").withName("bread").build());
    basket.addItem(new StockItemBuilder().withPrice("1.20").withName("bread").build());

    assertEquals(new BigDecimal("3.60"), basket.getTotal());
  }

  @Test public void testBasketWithAddMultipleOfSameItemUsingQuantity(){
    Basket basket = new Basket();
    basket.addItem(new StockItemBuilder().withPrice("1.20").withName("bread").build(), 3);

    assertEquals(new BigDecimal("3.60"), basket.getTotal());
  }

  @Test public void testBasketContains(){
    Basket basket = new Basket();
    basket.addItem(new StockItemBuilder().withName("bread").build());
    basket.addItem(new StockItemBuilder().withName("beer").build(), 6);
    basket.addItem(new StockItemBuilder().withName("soup").build());
    basket.addItem(new StockItemBuilder().withName("beef").build(), 4);

    assertSame(0, basket.contains("apples"));
    assertSame(1, basket.contains("soup"));
    assertSame(6, basket.contains("beer"));
    assertSame(4, basket.contains("beef"));
  }

  // Price a basket containing: 3 tins of soup and 2 loaves of bread, bought today
  @Test public void testScenarioOne(){
    Basket basket = new Basket();
    basket.addItem(new StockItemBuilder().withPrice("0.65").withUnit("tin").withName("soup").build(), 3);
    basket.addItem(new StockItemBuilder().withPrice("0.80").withUnit("loaf").withName("bread").build(), 2);

    // assertEquals(new BigDecimal("3.15"), basket.getTotal());
  }

  // Price a basket containing: 6 apples and a bottle of milk, bought today, 
  //   - Expected total cost = 1.90;
  // @Test public void testScenarioTwo() {
  //   Basket basket = new Basket()
  //     .withDiscount(new TenOffApples()
  //     //.withCheckoutOn(THREE_DAYS_HENCE));
  //   basket.addItem(new StockItemBuilder().withPrice("0.10").withUnit("single").withName("apples").build(), 6);
  //   basket.addItem(new StockItemBuilder().withPrice("1.30").withUnit("bottle").withName("milk").build());

  //   assertEquals(new BigDecimal("1.90"), basket.getTotal());
  // }


  // Price a basket containing: 6 apples and a bottle of milk, bought in 5 days time,
  //    - Expected total cost = 1.84;
  @Test public void testScenarioThree() {
    DiscountStrategy tenPercentOffApples = new TenOffApples().startsOn(inThreeDays()).endsOn(endOfNextMonth());
    ArrayList<DiscountStrategy> discounts = new ArrayList<DiscountStrategy>(Arrays.asList(tenPercentOffApples));

    Basket basket = new Basket()
      .withDiscounts(new DiscountRepository(discounts))
      .addItem(new StockItemBuilder().withPrice("0.10").withUnit("single").withName("apples").build(), 6)
      .addItem(new StockItemBuilder().withPrice("1.30").withUnit("bottle").withName("milk").build());

    assertEquals(new BigDecimal("1.84"), basket.getTotal(inFiveDays()));
  }

  // //  - Price a basket containing: 3 apples, 2 tins of soup and a loaf of bread, bought in 5 days time,
  // //    - Expected total cost = 1.97.
  // @Test public void testScenarioFour() {
  //   Basket basket = new Basket()
  //     .withDiscounts(DiscountRepository.getActive(five_days_from_today())
  //     .addItem(new StockItemBuilder().withPrice("0.10").withUnit("single").withName("apples").build(), 3)
  //     .addItem(new StockItemBuilder().withPrice("0.65").withUnit("tin").withName("soup").build(), 2)
  //     .addItem(new StockItemBuilder().withPrice("0.80").withUnit("loaf").withName("bread").build());

  //   assertEquals(new BigDecimal("1.97"), basket.getTotal());
  // }
}
