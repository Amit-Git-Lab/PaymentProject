/**
 * 
 */
package retail.com.paymentResolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import retail.com.graphTypes.PayableAmountVO;
import retail.com.graphTypes.ShoppingCartDtlsVO;
import retail.com.payamentService.PaymentService;

/**
 * @author amit
 *
 */
@Component
public class CartQuery implements GraphQLQueryResolver {
	@Autowired
	private PaymentService paymentSvc;

	/**
	 * method to find net payable amount after discount
	 * 
	 * @param shoppingCartDtlsVO
	 * @return
	 */
	public PayableAmountVO getPayableAmount(ShoppingCartDtlsVO shoppingCartDtlsVO) {
		return paymentSvc.getPayableAmount(shoppingCartDtlsVO);
	}
}
