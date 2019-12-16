/**
 * 
 */
package retail.com.serviceimpl;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import retail.com.constants.Constant;
import retail.com.discount.StoreAffilatedEmployee;
import retail.com.graph.types.ItemDetailsVO;
import retail.com.graph.types.PayableAmountVO;
import retail.com.graph.types.ShoppingCartDtlsVO;
import retail.com.payament.service.PaymentService;
import retail.com.payament.service.impl.PaymentServiceImpl;

/**
 * @author amit.kushwaha
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PaymentServiceImpl.class)
public class TestPaymentServiceImpl {
	@InjectMocks
	private PaymentServiceImpl paymentSvcImpl;
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

	/**
	 * test case for Store employee and grocery type item
	 */
	@Test
	public void testPaymentServiceImplStoreEmp() {
		List<ItemDetailsVO> itemDetailsVOList = new ArrayList<>();
		itemDetailsVOList.add(itemDetailsVO);
		when(shoppingCartDtlsVO.getUser()).thenReturn(Constant.StoreEmp);
		when(shoppingCartDtlsVO.getItemDetailsVO()).thenReturn(itemDetailsVOList);
		when(itemDetailsVO.getItemType()).thenReturn(Constant.Grocery);
		when(itemDetailsVO.getPrice()).thenReturn(150f);
		PayableAmountVO payAmount=paymentSvcImpl.getPayableAmount(shoppingCartDtlsVO);
		assertNotNull(payAmount);
	}
	
	/**
	 * test case for Affilated Store employee and grocery type item
	 */
	@Test
	public void testPaymentServiceImplAfflEmp() {
		List<ItemDetailsVO> itemDetailsVOList = new ArrayList<>();
		itemDetailsVOList.add(itemDetailsVO);
		when(shoppingCartDtlsVO.getUser()).thenReturn(Constant.AffilatedEmp);
		when(shoppingCartDtlsVO.getItemDetailsVO()).thenReturn(itemDetailsVOList);
		when(itemDetailsVO.getItemType()).thenReturn(Constant.Grocery);
		when(itemDetailsVO.getPrice()).thenReturn(150f);
		PayableAmountVO payAmount=paymentSvcImpl.getPayableAmount(shoppingCartDtlsVO);
		assertNotNull(payAmount);
	}
	
	/**
	 * test case for General Customer over 2 year and grocery type item
	 */
	@Test
	public void testPaymentSvcGenCust() {
		List<ItemDetailsVO> itemDetailsVOList = new ArrayList<>();
		itemDetailsVOList.add(itemDetailsVO);
		when(shoppingCartDtlsVO.getUser()).thenReturn(Constant.GeneralCustomer);
		when(shoppingCartDtlsVO.getItemDetailsVO()).thenReturn(itemDetailsVOList);
		when(itemDetailsVO.getItemType()).thenReturn(Constant.NonGrocery);
		when(itemDetailsVO.getPrice()).thenReturn(150f);
		when(shoppingCartDtlsVO.getCustYearDuration()).thenReturn(2);
		PayableAmountVO payAmount=paymentSvcImpl.getPayableAmount(shoppingCartDtlsVO);
		assertNotNull(payAmount);
	}

	/**
	 * test case for Store employee and non-grocery type item
	 */
	@Test
	public void testPaymentSvcImplStoreEmp() {
		List<ItemDetailsVO> itemDetailsVOList = new ArrayList<>();
		itemDetailsVOList.add(itemDetailsVO);
		when(shoppingCartDtlsVO.getUser()).thenReturn(Constant.StoreEmp);
		when(shoppingCartDtlsVO.getItemDetailsVO()).thenReturn(itemDetailsVOList);
		when(itemDetailsVO.getItemType()).thenReturn(Constant.NonGrocery);
		when(itemDetailsVO.getPrice()).thenReturn(150f);
		PayableAmountVO payAmount=paymentSvcImpl.getPayableAmount(shoppingCartDtlsVO);
		assertNotNull(payAmount);
	}
	
	/**
	 * test case for Affilated Store employee and non-grocery type item
	 */
	@Test
	public void testPaymentSvcImplAfflEmp() {
		List<ItemDetailsVO> itemDetailsVOList = new ArrayList<>();
		itemDetailsVOList.add(itemDetailsVO);
		when(shoppingCartDtlsVO.getUser()).thenReturn(Constant.AffilatedEmp);
		when(shoppingCartDtlsVO.getItemDetailsVO()).thenReturn(itemDetailsVOList);
		when(itemDetailsVO.getItemType()).thenReturn(Constant.NonGrocery);
		when(itemDetailsVO.getPrice()).thenReturn(150f);
		PayableAmountVO payAmount=paymentSvcImpl.getPayableAmount(shoppingCartDtlsVO);
		assertNotNull(payAmount);
	}
	
	/**
	 * test case for General Customer over 2 year and non-grocery type item
	 */
	@Test
	public void testPaymentServiceGenCust() {
		List<ItemDetailsVO> itemDetailsVOList = new ArrayList<>();
		itemDetailsVOList.add(itemDetailsVO);
		when(shoppingCartDtlsVO.getUser()).thenReturn(Constant.GeneralCustomer);
		when(shoppingCartDtlsVO.getItemDetailsVO()).thenReturn(itemDetailsVOList);
		when(itemDetailsVO.getItemType()).thenReturn(Constant.Grocery);
		when(itemDetailsVO.getPrice()).thenReturn(150f);
		when(shoppingCartDtlsVO.getCustYearDuration()).thenReturn(2);
		PayableAmountVO payAmount=paymentSvcImpl.getPayableAmount(shoppingCartDtlsVO);
		assertNotNull(payAmount);
	}
}
