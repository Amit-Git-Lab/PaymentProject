/**
 * 
 */
package retail.com.discount;

import retail.com.discount.service.DiscountType;

/**
 * @author amit
 *
 */
public class StoreEmployee implements DiscountType{

	@Override
	public float getDiscount(float totalAmount) {
		float discount = (float) (totalAmount*(0.30));
		return discount;
	}

}
