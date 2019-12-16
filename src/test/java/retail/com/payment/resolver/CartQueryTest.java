package retail.com.payment.resolver;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import retail.com.discount.StoreAffilatedEmployee;
import retail.com.graph.types.ItemDetailsVO;
import retail.com.graph.types.PayableAmountVO;
import retail.com.graph.types.ShoppingCartDtlsVO;
import retail.com.payament.service.PaymentService;
import retail.com.payment.resolver.CartQuery;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = CartQuery.class)
public class CartQueryTest {

	@InjectMocks
	private CartQuery cartQuery;
	@MockBean
	PaymentService paymentSvc;
	@Mock
	ShoppingCartDtlsVO shoppingCartDtlsVO;
	@Mock
	PayableAmountVO payableAmountVO;
	@Mock
	ItemDetailsVO itemDetailsVO;
	@Mock
	StoreAffilatedEmployee storeAffilatedEmp;

	@Test
	public void testGetPayableAmount() {
		PayableAmountVO payableAmntVO = null;
		when(paymentSvc.getPayableAmount(shoppingCartDtlsVO)).thenReturn(payableAmountVO);
		payableAmntVO = paymentSvc.getPayableAmount(shoppingCartDtlsVO);
		assertNotNull(payableAmntVO);
	}

}
