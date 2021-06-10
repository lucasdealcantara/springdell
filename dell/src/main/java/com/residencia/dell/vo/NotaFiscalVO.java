package com.residencia.dell.vo;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

public class NotaFiscalVO {


private String FirstName;
private String CustomerLastName;
private BigDecimal NetAmount;
private Calendar OrderDate;
private Integer OrderId;
private List<ItemOrderLinesVO> listItemOrderLinesVO;

private BigDecimal TotalAmount;

public String getFirstName() {
    return FirstName;
}
public void setFirstName(String firstName) {
    FirstName = firstName;
}
public String getCustomerLastName() {
    return CustomerLastName;
}
public void setCustomerLastName(String customerLastName) {
    CustomerLastName = customerLastName;
}
public BigDecimal getNetAmount() {
    return NetAmount;
}
public void setNetAmount(BigDecimal netAmount) {
    NetAmount = netAmount;
}
public Calendar getOrderDate() {
    return OrderDate;
}
public void setOrderDate(Calendar orderDate) {
    OrderDate = orderDate;
}
public Integer getOrderId() {
    return OrderId;
}
public void setOrderId(Integer orderId) {
    OrderId = orderId;
}

public BigDecimal getTotalAmount() {
    return TotalAmount;
}
public void setTotalAmount(BigDecimal totalAmount) {
    TotalAmount = totalAmount;
}
public List<ItemOrderLinesVO> getListItemOrderLinesVO() {
	return listItemOrderLinesVO;
}
public void setListItemOrderLinesVO(List<ItemOrderLinesVO> listItemOrderLinesVO) {
	this.listItemOrderLinesVO = listItemOrderLinesVO;
}

}