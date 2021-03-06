/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

/**
 *
 * @author n0200797
 */
public class Order {

    private Integer number;
    private String customerName;
    String OrderNumber;

    public StateTax getTaxRate() {
        return taxRate;
    }

    public String getOrderNumber() {
        return OrderNumber;
    }

    public void setOrderNumber(String OrderNumber) {
        this.OrderNumber = OrderNumber;
    }

    public void setTaxRate(StateTax taxRate) {
        this.taxRate = taxRate;
    }

    public Product getProductType() {
        return productType;
    }

    public void setProductType(Product productType) {
        this.productType = productType;
    }

    private StateTax taxRate;
    private Product productType;

    private BigDecimal area;

    private BigDecimal materialCost;
    private BigDecimal laborCost;
    private BigDecimal tax;
    private BigDecimal total;
//******************************************************************************

    public Order(Integer number) {
        this.number = number;
    }
//******************************************************************************    

    public Order() {
    }
//********************SETTERS***************************************************    

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public void setMaterialCost(BigDecimal materialCost) {
        this.materialCost = materialCost;
    }

    public void setLaborCost(BigDecimal laborCost) {
        this.laborCost = laborCost;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
//**************************GETTERS*********************************************

    public Integer getNumber() {
        return number;
    }

    public BigDecimal getArea() {
        return area;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
//******************************************************************************    
    //CALCULATE MATERIAL COST UP FRONT
    public BigDecimal getMaterialCost() {
        materialCost = productType.getCostPerSqFt().multiply(area);
        return materialCost.setScale(2, RoundingMode.HALF_UP);
    }

    //CALCULATE LABOR COST UP FRONT
    public BigDecimal getLaborCost() {
        laborCost = productType.getLaborCostPerSqFt().multiply(area);
        return laborCost.setScale(2, RoundingMode.HALF_UP);
    }

    //CALCULATE TAX
    public BigDecimal getTax() {
        BigDecimal costBeforeTax = materialCost.add(laborCost);
        tax = (taxRate.getTaxRate().divide(new BigDecimal("100")).multiply(costBeforeTax));
        return tax.setScale(2, RoundingMode.HALF_UP);
    }

    //CALCULATE TOTAL
    public BigDecimal getTotal() {
        total = materialCost.add(laborCost).add(tax);
        return total.setScale(2, RoundingMode.HALF_UP);
    }
//****************GET AND STORE ORDER INFO IN AN ARRAY**************************


}
