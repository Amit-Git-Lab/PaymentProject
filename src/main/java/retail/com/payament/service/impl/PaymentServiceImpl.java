/**
 * 
 */
package retail.com.payament.service.impl;

import org.springframework.stereotype.Service;

import retail.com.constants.Constant;
import retail.com.discount.GeneralCustomer;
import retail.com.discount.StoreAffilatedEmployee;
import retail.com.discount.StoreEmployee;
import retail.com.graph.types.ItemDetailsVO;
import retail.com.graph.types.PayableAmountVO;
import retail.com.graph.types.ShoppingCartDtlsVO;
import retail.com.payament.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	/* 
	 * method to find net payable amount after discount 
	 */
	@Override
	public PayableAmountVO getPayableAmount(ShoppingCartDtlsVO shoppingCartDtlsVO) {
		PayableAmountVO payableAmountVO = new PayableAmountVO();
		float grocAmount = 0f;
		float nonGrocAmount = 0f;
		float discount = 0f;
		float netPayAmount = 0f;
		if (null != shoppingCartDtlsVO && null != shoppingCartDtlsVO.getUser()) {
			for (ItemDetailsVO details : shoppingCartDtlsVO.getItemDetailsVO()) {
				if (details.getItemType().equals(Constant.Grocery)) {
					grocAmount += details.getPrice();
				} else if (details.getItemType().equals(Constant.NonGrocery)) {
					nonGrocAmount += details.getPrice();
				}
			}
			if (Constant.StoreEmp.equalsIgnoreCase(shoppingCartDtlsVO.getUser())) {
				StoreEmployee se = new StoreEmployee();
				discount = se.getDiscount(nonGrocAmount);
				payableAmountVO.setDiscountType(Constant.StoreEmpConstant);
			} else if (Constant.AffilatedEmp.equalsIgnoreCase(shoppingCartDtlsVO.getUser())) {
				StoreAffilatedEmployee sae = new StoreAffilatedEmployee();
				discount = sae.getDiscount(nonGrocAmount);
				payableAmountVO.setDiscountType(Constant.AffliateEmpConstant);
			} else if (Constant.GeneralCustomer.equalsIgnoreCase(shoppingCartDtlsVO.getUser())) {
				if (shoppingCartDtlsVO.getCustYearDuration() >= 2) {
					GeneralCustomer gc = new GeneralCustomer();
					discount = gc.getDiscount(nonGrocAmount);
					payableAmountVO.setDiscountType(Constant.GeneralCustomerConstant);
				}
			}
			netPayAmount = (grocAmount + nonGrocAmount) - discount;
			payableAmountVO.setNetAmount(netPayAmount);
			payableAmountVO = checkDiscountOnTotalBill(netPayAmount, payableAmountVO);
		}

		return payableAmountVO;
	}

	/** method to calculate discount on more than 100$ bill and reduce them
	 * @param netPayAmount
	 * @param payableAmountVO
	 * @return
	 */
	PayableAmountVO checkDiscountOnTotalBill(float netPayAmount, PayableAmountVO payableAmountVO) {
		float payment = netPayAmount;
		if (netPayAmount >= 100) {
			int amount = (int) (netPayAmount / 100);
			int discountAmnt = 5 * amount;
			payment = netPayAmount - discountAmnt;
			payableAmountVO.setNetAmount(payment);
			payableAmountVO.setDiscountType(Constant.BilDiscountConstant);
		}
		return payableAmountVO;
	}
}
