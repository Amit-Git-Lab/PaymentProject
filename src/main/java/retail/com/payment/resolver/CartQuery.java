/**
 * 
 */
package retail.com.payment.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import retail.com.graph.types.PayableAmountVO;
import retail.com.graph.types.ShoppingCartDtlsVO;
import retail.com.payament.service.PaymentService;

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
