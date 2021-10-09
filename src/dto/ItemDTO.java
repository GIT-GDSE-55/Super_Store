/*
 *
 *  * -------------------------------------------------------------
 *  *  Copyright (c) GDSE- Gansters. All rights reserved
 *  *  Licensed under the SriLankan Information  License. See LICENSE.txt in the project root for License information
 *  * -------------------------------------------------------------
 *
 */

package dto;

/**
 * @author Sachini Umayangana <sachi.umay@gmail.com>
 * @since 10/9/2021
 */
public class ItemDTO {

    private String code;
    private String description;
    private double unitPrice;
    private int qtyOnHand;
    public ItemDTO() {
    }

    public ItemDTO(String code, String description, double unitPrice, int qtyOnHand) {
        this.code = code;
        this.description = description;
        this.unitPrice = unitPrice;
        this.qtyOnHand = qtyOnHand;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    @Override
    public String toString() {
        return "Item{" + "code=" + code + ", description=" + description + ", unitPrice=" + unitPrice + ", qtyOnHand=" + qtyOnHand + '}';
    }
}
