/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.ui;

import com.sg.flooringmastery.dto.Order;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author n0200797
 */
public class FlooringMasteryView {

    private UserIO io;
    private DecimalFormat decimalFormat = new DecimalFormat("#0.00");

    public FlooringMasteryView(UserIO io) {
        this.io = io;
    }
//******************************************************************************

    public int displayMenuSelection() {
        io.print("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
        io.print(" *  <<Flooring Program>>\n");
        io.print(" * 1. Display Orders\n");
        io.print(" * 2. Add an Order\n");
        io.print(" * 3. Edit an Order\n");
        io.print(" * 4. Remove an Order\n");
        io.print(" * 5. Save Current Work\n");
        io.print(" * 6. Quit\n");
        io.print(" * ");
        io.print("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");

        return io.readInt("PLEASE SELECT FROM THE ABOVE CHOICES: ", 1, 6);
    }
//******************************************************************************
    public void displayOrders(){
        io.print("\n*** DISPLAY ORDERS ***");
    }
    
    public LocalDate displayRequestOrderDate(){
        return io.readLocalDate("What date would you like to display orders for (MM/DD/YYYY)?\n", "MMddyyyy");        
        
    }
    public void displayOrderList(List<Order> orderList){
        io.print("-----------------------------------------------------------------------");
        io.print("          LIST OF ORDERS FOR THE DATE ENTERED: \n");
        
        for (Order currentOrder : orderList) {
            io.print(currentOrder.getNumber() + "," 
                    + currentOrder.getCustomerName() + ","               
                    + currentOrder.getTaxRate().getStateName() + ","
                    + currentOrder.getTaxRate().getTaxRate()+ ","
                    + currentOrder.getProductType().getProductType()+ ","
                    + currentOrder.getProductType().getLaborCostPerSqFt()+ ","
                    + currentOrder.getProductType().getCostPerSqFt()+ ","
                    + currentOrder.getArea()+ ","
                    + currentOrder.getMaterialCost()+ ","
                    + currentOrder.getLaborCost()+ ","        
                    + currentOrder.getTax()+ "," 
                    + currentOrder.getTotal());            
        }
        io.print("-----------------------------------------------------------------------");
    }
//******************************************************************************    
    
    
    
    
    
    

//******************************************************************************    
    public void displayExitBanner() {
        io.print("Thanks for being a awesome customer! PLEASE COME BACK.");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("\n");
        io.print("====================== ERROR ==============================");
        io.print(errorMsg);
    }

}
