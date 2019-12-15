/**
 * 
 */
package retail.com.graphTypes;

/**
 * @author amit
 *
 */
public class PayableAmountVO {

	private float netAmount;
	private String discountType;

	public PayableAmountVO() {
	}

	/**
	 * @return the netAmount
	 */
	public float getNetAmount() {
		return netAmount;
	}

	/**
	 * @param netAmount
	 *            the netAmount to set
	 */
	public void setNetAmount(float netAmount) {
		this.netAmount = netAmount;
	}

	/**
	 * @return the discountType
	 */
	public String getDiscountType() {
		return discountType;
	}

	/**
	 * @param discountType
	 *            the discountType to set
	 */
	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}

}
