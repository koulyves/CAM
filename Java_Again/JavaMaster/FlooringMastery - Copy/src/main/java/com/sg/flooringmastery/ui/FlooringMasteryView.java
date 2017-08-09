/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.ui;

import java.text.DecimalFormat;

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
        io.print(" * 5. Save Cuurent Work\n");
        io.print(" * 6. Quit\n");
        io.print(" * ");
        io.print("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");

        return io.readInt("PLEASE SELECT FROM THE ABOVE CHOICES: ", 1, 6);
    }
//******************************************************************************
    
    
    
    
    
    
    
    

//******************************************************************************    
    public void displayExitBanner() {
        io.print("Thanks for being our awesome customer! PLEASE COME BACK.");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("\n");
        io.print("====================== ERROR ==============================");
        io.print(errorMsg);
    }

}
