/**
 * 
 */
package retail.com.discount;

import retail.com.discountService.DiscountType;

/**
 * @author amit
 *
 */
public class StoreAffilatedEmployee implements DiscountType {

	@Override
	public float getDiscount(float totalAmount) {
		float discount = (float) (totalAmount *(0.10));
		return discount;
	}

}
