/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachine.dto;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author n0200797
 */
public class Item {

    private String name;
    private BigDecimal price;

    private int quantity;
    private int itemId;
    

//**********************MY CONSTRUCTOR******************************************    
    public Item(int itemId) {
//        String name, BigDecimal price, int quantity,
//        this.name = name;
//        this.price = price;
//        this.quantity = quantity;
        this.itemId = itemId;
    }
//**********************MY GETTERS & SETTERS************************************

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        //Also Called getCost
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

//***********Remove setters*****************************************************
    public void removeAnItem() {
        this.quantity = quantity - 1;
    }

    public void setOtherQuantity(int i) {
        this.quantity = i;
    }
        public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
//******************************************************************************

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.price);
        hash = 97 * hash + this.quantity;
        hash = 97 * hash + this.itemId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (this.quantity != other.quantity) {
            return false;
        }
        if (this.itemId != other.itemId) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        return true;
    }
    
}
