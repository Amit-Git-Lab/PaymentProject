/**
 * 
 */
package retail.com.discount;

import retail.com.discountService.DiscountType;

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
