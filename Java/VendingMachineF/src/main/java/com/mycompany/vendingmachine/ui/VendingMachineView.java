/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachine.ui;

import com.mycompany.vendingmachine.dto.Change;
import com.mycompany.vendingmachine.dto.Item;
import com.mycompany.vendingmachine.service.InvalidClientMoneyException;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

/**
 *
 * @author n0200797
 */
public class VendingMachineView {

    private UserIO io;
    private DecimalFormat decimalFormat = new DecimalFormat("#0.00");


    public VendingMachineView(UserIO io) {
        this.io = io;
    }
//*****************MENU SELECTION***********************************************

    public void logo() {
        io.print("                             _      _              __ _           __  __                   _         _                    \n"
                + "  __ __    ___    _ _     __| |    (_)    _ _     / _` |    o O O|  \\/  |  __ _     __    | |_      (_)    _ _      ___   \n"
                + "  \\ V /   / -_)  | ' \\   / _` |    | |   | ' \\    \\__, |   o     | |\\/| | / _` |   / _|   | ' \\     | |   | ' \\    / -_)  \n"
                + "  _\\_/_   \\___|  |_||_|  \\__,_|   _|_|_  |_||_|   |___/   TS__[O]|_|__|_| \\__,_|   \\__|_  |_||_|   _|_|_  |_||_|   \\___|  \n"
                + "_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"| {======|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"| \n"
                + "\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-'./o--000'\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-' \n"
                + "Beverages Within This Machine Are as **Chilled** as a Fat Man on a Sweaty Summer's day. Don't Waste Your Money!!! HAHAHA\n----ABDOUL CAMARA----");
    }

//*****************DISPLAY ERROR MESSAGE****************************************

    public int displayAndGoToChoice() {
        io.print(" ================= WHAT WOULD YOU LIKE TO DO? ===================\n");
        io.print(" *****************   1. Add More Money        *******************\n");
        io.print(" *****************   2. Purchase An Item      *******************\n");
        io.print(" *****************   3. Exit/Take Change      *******************\n");
        return io.readInt("PLEASE SELECT FROM THE ABOVE CHOICES: ", 1, 3);
    }

//******************************************************************************    
    public void displayErrorMessage(String errorMsg) {
        io.print("\n");
        io.print("================== ERROR =========================");
        io.print(errorMsg);
    }
//******************************************************************************

    public void displayChange(Change change) {
        io.print("         YOUR CHNAGE IS: ");
        io.print("*********\tQarters: " + change.getQuarters());
        io.print("*********\tDimes: " + change.getDimes());
        io.print("*********\tNickels " + change.getNickels());
        io.print("*********\tPennies " + change.getPennies());
    }
//**************************ADD MONEY*******************************************

    public BigDecimal clientMoney() throws InvalidClientMoneyException {
      return io.readBigDecimal("PLEASE INSERT MOMNEY --- $ ");

    }

//************************DISPLAY DVD LIST**************************************
    public void displayItemList(List<Item> ItemList, BigDecimal clientMoney) {
        io.print("\n");
        io.print("%%%%%%%%%%% WELCOME TO YOUR FAVORITE VENDING MACHINE %%%%%%%%%%%\n");
        displayMoney(clientMoney);
        io.print("----------------------------------------------------------------");
        for (Item currentItem : ItemList) {
            io.print(currentItem.getItemId() + "\t"
                    + currentItem.getName()
                    + "\t Price $" + currentItem.getPrice()
                    + "\t Quantity: " + currentItem.getQuantity() + "\n");
        }
    }

    public void displayMoney(BigDecimal clientMoney) {
        io.print("          Your Current Balance is: " + decimalFormat.format(clientMoney));
    }

    public void displayDisplayAllBanner() {
        io.print("================== DISPLAY ALL ITEM ==================");
    }

    public void displayExitBanner() {
        io.print("THANK YOU FOR SHOPPING WITH US!!! PLEASE COME BACK.");
    }

//******************************************************************************
    public int getItemIdChoice() {
        return io.readInt("\nPlease Select an Item #: ");

    }

}
