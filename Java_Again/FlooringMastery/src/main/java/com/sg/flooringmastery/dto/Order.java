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

    private int number;
    private String customerName;
    private String customerState;
    private LocalDate orderDate;

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public StateTax getTaxRate() {
        return taxRate;
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

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
    
    private StateTax taxRate;
    private Product productType;
    
    private BigDecimal area;
    private BigDecimal costPerSqFt;
    private BigDecimal laborCostPerSqFt;

    private BigDecimal materialCost;
    private BigDecimal laborCost;
    private BigDecimal tax;
    private BigDecimal total;
//******************************************************************************

    public Order(int number){ 
//            String customerName,
//            String customerState, BigDecimal area, BigDecimal costPerSqFt) {
        this.number = number;
//        this.customerName = customerName;
//        this.customerState = customerState;
//        this.area = area;
//        this.costPerSqFt = costPerSqFt;

    }

//********************SETTERS***************************************************    
    public void setNumber(int number) {
        this.number = number;
    }

    public void setCustomerState(String customerState) {
        this.customerState = customerState;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public void setCostPerSqFt(BigDecimal costPerSqFt) {
        this.costPerSqFt = costPerSqFt;
    }

    public void setMaterialCost(BigDecimal materialCost) {
        this.materialCost = materialCost;
    }

    public void setLaborCostPerSqFt(BigDecimal laborCostPerSqFt) {
        this.laborCostPerSqFt = laborCostPerSqFt;
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

    public int getNumber() {
        return number;
    }

    public BigDecimal getArea() {
        return area;
    }

    public String getCustomerState() {
        return customerState;
    }

    public BigDecimal getCostPerSqFt() {
        return costPerSqFt;
    }

    public BigDecimal getLaborCostPerSqFt() {
        return laborCostPerSqFt;
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
        materialCost = costPerSqFt.multiply(area);
        return materialCost.setScale(2, RoundingMode.HALF_UP);
    }

    //CALCULATE LABOR COST UP FRONT
    public BigDecimal getLaborCost() {
        laborCost = laborCostPerSqFt.multiply(area);
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
