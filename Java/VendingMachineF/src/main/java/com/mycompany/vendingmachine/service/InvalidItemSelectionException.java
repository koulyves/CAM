package com.mycompany.vendingmachine.service;

public class InvalidItemSelectionException extends Exception {

    public String getMessage(){
        return ("YOU ENTERED AN INVALID ITEM SELECTION!!!!\n"
                +"PLEASE SELECT FROM THE LIST OF AVAILABLE ITEMS.");
    }
}
