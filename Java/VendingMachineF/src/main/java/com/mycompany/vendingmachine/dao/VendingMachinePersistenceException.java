/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachine.dao;

/**
 *
 * @author n0200797
 */
public class VendingMachinePersistenceException extends Exception {

    public VendingMachinePersistenceException(String message) {
        super(message);
    }

    public VendingMachinePersistenceException(String message, Throwable cause) {
        super(message, cause);
    }

}
