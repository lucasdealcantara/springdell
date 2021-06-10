package com.residencia.dell.vo;

public class ItemOrderLinesVO {

    private Integer ProdId;
    private String ProdTitle;
    private Integer Quantity;
    public Integer getProdId() {
        return ProdId;
    }
    public void setProdId(Integer prodId) {
        ProdId = prodId;
    }
    public String getProdTitle() {
        return ProdTitle;
    }
    public void setProdTitle(String prodTitle) {
        ProdTitle = prodTitle;
    }
    public Integer getQuantity() {
        return Quantity;
    }
    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }

}