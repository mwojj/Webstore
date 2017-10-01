import com.packt.webstore.domain.Cart;
import com.packt.webstore.domain.CartItem;
import com.packt.webstore.domain.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class CartTest {
private Cart cart;
private CartItem cartItem;

@Before
    public void setup(){
    cart = new Cart();
    cartItem = new CartItem();
}

@Test
public void grand_total_should_be_equals_to_sum_of_price_in_cart(){
    Product iphone = new Product("P1234", "iphone 5s", new BigDecimal(500));
    cartItem.setProduct(iphone);
    cart.addCartItem(cartItem);
    BigDecimal grandTotal = cart.getGrandTotal();
    Assert.assertEquals(iphone.getUnitPrice(), grandTotal);
}
}
