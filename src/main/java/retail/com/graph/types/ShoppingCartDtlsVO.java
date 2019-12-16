/**
 * 
 */
package retail.com.graph.types;

import java.util.List;

/**
 * @author amit
 *
 */
public class ShoppingCartDtlsVO {
	private String user;
	private int noOfItems;
	private int custYearDuration;
	private List<ItemDetailsVO> itemDetailsVO;

	public ShoppingCartDtlsVO() {

	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * @return the noOfItems
	 */
	public int getNoOfItems() {
		return noOfItems;
	}

	/**
	 * @param noOfItems
	 *            the noOfItems to set
	 */
	public void setNoOfItems(int noOfItems) {
		this.noOfItems = noOfItems;
	}

	/**
	 * @return the custYearDuration
	 */
	public int getCustYearDuration() {
		return custYearDuration;
	}

	/**
	 * @param custYearDuration
	 *            the custYearDuration to set
	 */
	public void setCustYearDuration(int custYearDuration) {
		this.custYearDuration = custYearDuration;
	}

	/**
	 * @return the itemDetailsVO
	 */
	public List<ItemDetailsVO> getItemDetailsVO() {
		return itemDetailsVO;
	}

	/**
	 * @param itemDetailsVO
	 *            the itemDetailsVO to set
	 */
	public void setItemDetailsVO(List<ItemDetailsVO> itemDetailsVO) {
		this.itemDetailsVO = itemDetailsVO;
	}

}
