package henrys;

import java.util.Date;

import org.junit.Test;
import static org.junit.Assert.*;

public class DiscountRepositoryTest {
  private Date today(){
    return new Date(2021, 3, 20);
  }

  @Test public void testGetActiveWhenEmpty(){
    assertTrue(new DiscountRepository().getActive(today()).isEmpty());
  }  
}
