package retail.com.paymentResolver;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import retail.com.discount.StoreAffilatedEmployee;
import retail.com.graphTypes.ItemDetailsVO;
import retail.com.graphTypes.PayableAmountVO;
import retail.com.graphTypes.ShoppingCartDtlsVO;
import retail.com.payamentService.PaymentService;


@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration
public class CartQueryTest {

	@InjectMocks
	private CartQuery cartQuery;
	@Mock
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
		PayableAmountVO payableAmountVO = new PayableAmountVO();
		List<ItemDetailsVO> itemDetailsVOList = new ArrayList<>();
		itemDetailsVOList.add(itemDetailsVO);
		when(shoppingCartDtlsVO.getUser()).thenReturn("AE");
		when(shoppingCartDtlsVO.getItemDetailsVO()).thenReturn(itemDetailsVOList);
		when(itemDetailsVO.getItemType()).thenReturn("NGRC");
		when(itemDetailsVO.getPrice()).thenReturn(150f);
		payableAmountVO = paymentSvc.getPayableAmount(shoppingCartDtlsVO);
		assertNotNull(payableAmountVO);
	}

}
