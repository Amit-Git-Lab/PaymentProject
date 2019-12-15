/**
 * 
 */
package retail.com.payamentService;

import org.springframework.stereotype.Service;

import retail.com.graphTypes.PayableAmountVO;
import retail.com.graphTypes.ShoppingCartDtlsVO;

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
