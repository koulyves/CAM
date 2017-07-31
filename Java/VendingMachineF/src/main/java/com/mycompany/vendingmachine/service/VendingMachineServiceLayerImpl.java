/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachine.service;

import com.mycompany.vendingmachine.dao.VendingMachineDao;
import com.mycompany.vendingmachine.dao.VendingMachineDaoFileImpl;
import com.mycompany.vendingmachine.dao.VendingMachinePersistenceException;
import com.mycompany.vendingmachine.dto.Item;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author n0200797
 */
public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer {

    VendingMachineDao dao;

    public VendingMachineServiceLayerImpl(VendingMachineDao dao) {
        this.dao = dao;
    }
//************************ABSTRACT SERVICE LAYER METHODS************************
    @Override
    public List<Item> getInventory() throws
            VendingMachinePersistenceException {
        return dao.getAllItems();
    }
//******************************************************************************
    @Override
    public void validateMoney(BigDecimal clientMoney) throws 
            InvalidClientMoneyException {
        //VALIDATE IF USER ENTERED MONEY WITH MORE THAN 2 DECIMAL
        if (clientMoney.scale() > 2) {
            throw new InvalidClientMoneyException(clientMoney.toString());
        }//VALIDATE A POSITIVE MONEY IS ENTERED
        else if (clientMoney.compareTo(BigDecimal.ZERO) != 1) {
            throw new InvalidClientMoneyException(clientMoney.toString());
        }//VALIDATE USER DID NOT ENTER PENNIES
        else if (clientMoney.scale() == 2 && !clientMoney.remainder
        (new BigDecimal(".05")).setScale(2).equals(new BigDecimal("0.00"))) {
            throw new InvalidClientMoneyException(clientMoney.toString());
        }
    }
//******************************************************************************
    @Override
    public BigDecimal purchaseItem(int itemId, BigDecimal clientMoney)
            throws VendingMachinePersistenceException, NoItemInventoryException,
            InsufficientFundsException, InvalidItemSelectionException {
        Item userSelection = dao.getAnItem(itemId);
        if (userSelection == null) {
            throw new InvalidItemSelectionException();
        }
        if (userSelection.getQuantity() == 0) {
            throw new NoItemInventoryException();
        }
        if (userSelection.getPrice().compareTo(clientMoney) > 0) {
            throw new InsufficientFundsException();
        }

        BigDecimal change = clientMoney.subtract(userSelection.getPrice());
        dao.updateItemQuantity(userSelection);

        return change;
    }
//******************************************************************************
    @Override
    public void saveInventory() throws 
            VendingMachinePersistenceException {
        dao.saveItemsToFile();
    }
}
