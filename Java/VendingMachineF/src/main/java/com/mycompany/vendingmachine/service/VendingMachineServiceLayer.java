/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachine.service;

import com.mycompany.vendingmachine.dao.VendingMachinePersistenceException;
import com.mycompany.vendingmachine.dto.Item;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author n0200797
 */
public interface VendingMachineServiceLayer {
    //GET INVENTORTY OF ITEM FROM MAP.
    List<Item> getInventory()
            throws VendingMachinePersistenceException;
    
    //VALIDATE CLIENT MONEY
    public void validateMoney(BigDecimal clientMoney)
            throws InvalidClientMoneyException;
    //PURCHASE ITEM
    public BigDecimal purchaseItem(int itemId, BigDecimal clientMoney)
            throws VendingMachinePersistenceException, 
            NoItemInventoryException, InsufficientFundsException, 
            InvalidItemSelectionException;

    //SAVE TO INVENTORY
    public void saveInventory()
            throws VendingMachinePersistenceException;
}
