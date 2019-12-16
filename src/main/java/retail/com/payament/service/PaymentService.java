/**
 * 
 */
package retail.com.payament.service;

import org.springframework.stereotype.Service;

import retail.com.graph.types.PayableAmountVO;
import retail.com.graph.types.ShoppingCartDtlsVO;

/**
 * @author amit
 *
 */
@Service
public interface PaymentService {

	/**
	 * method to find net payable amount after discount
	 * 
	 * @param shoppingCartDtlsVO
	 * @return
	 */
	public PayableAmountVO getPayableAmount(ShoppingCartDtlsVO shoppingCartDtlsVO);

}
