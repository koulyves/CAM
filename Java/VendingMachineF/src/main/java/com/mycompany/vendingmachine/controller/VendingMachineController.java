/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachine.controller;

import com.mycompany.vendingmachine.dao.VendingMachinePersistenceException;
import com.mycompany.vendingmachine.dto.Change;
import com.mycompany.vendingmachine.service.*;
import com.mycompany.vendingmachine.ui.UserIO;
import com.mycompany.vendingmachine.ui.UserIOConsoleImpl;
import com.mycompany.vendingmachine.ui.VendingMachineView;

import java.math.BigDecimal;

/**
 * @author n0200797
 */
public class VendingMachineController {
    private VendingMachineView view;
    private VendingMachineServiceLayer service;
    BigDecimal clientMoney;

    public VendingMachineController(VendingMachineServiceLayer service, VendingMachineView view) {
        this.service = service;
        this.view = view;
        this.clientMoney = BigDecimal.ZERO;    }

//******************************************************************************
    public void run() {
        int menuSelection;
        boolean keepGoing = true;
        try {
            while (keepGoing) {
                try {
                    menuSelection = getMenuSelection();

                    switch (menuSelection) {
                        case 1:
                            addToClientMoney();
                            break;
                        case 2:
                            purchaseItem();
                            break;
                        case 3:
                            exitVendingMachine();
                            keepGoing = false;
                            break;
                        default:

                    }
                } catch (InvalidItemSelectionException e) {
                    view.displayErrorMessage(e.getMessage());
                }

            }
            exitMessage();
        } catch (VendingMachinePersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

//***************************ADD MONEY *****************************************

    private void addToClientMoney() {
        BigDecimal moneyAdded;
        boolean isValid = false;
        try {
            moneyAdded = view.clientMoney();
            service.validateMoney(moneyAdded);
            clientMoney = clientMoney.add(moneyAdded);
            view.displayMoney(clientMoney);
            isValid = true;
        } catch (InvalidClientMoneyException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

//******************************************************************************
    private int getMenuSelection() throws VendingMachinePersistenceException, InvalidItemSelectionException {
        view.logo();
        view.displayItemList(service.getInventory(), clientMoney);
        if (clientMoney.compareTo(BigDecimal.ZERO) == 0) {
            addToClientMoney();
        }
        int menuSelected = 0;
        try {
            menuSelected = view.displayAndGoToChoice();
        } catch (NumberFormatException e) {
            throw new InvalidItemSelectionException();
        }
        return menuSelected;
    }

//******************************************************************************
    private void exitMessage() {
        view.displayExitBanner();
    }
//******************************************************************************

    private void purchaseItem() throws VendingMachinePersistenceException {
        if (clientMoney.compareTo(BigDecimal.ZERO) == 0) {
            view.displayErrorMessage("INSERT MONEY BEFORE MAKING A PURCHASE");
        } else {
            view.displayItemList(service.getInventory(), clientMoney);

            try {
                int itemSelected = view.getItemIdChoice();
                clientMoney = service.purchaseItem(itemSelected, clientMoney);
                Change change = getChange(clientMoney);
                view.displayChange(change);
            } catch (NumberFormatException e) {
                view.displayErrorMessage(e.getMessage());
            } catch (InvalidItemSelectionException e) {
                view.displayErrorMessage(e.getMessage());
            } catch (NoItemInventoryException e) {
                view.displayErrorMessage(e.getMessage());
            } catch (InsufficientFundsException e) {
                view.displayErrorMessage(e.getMessage());
            }
        }
    }

    private Change getChange(BigDecimal money) {
        Double doubleChange = money.doubleValue() * 100;
        int totalChangeInPennies = doubleChange.intValue();
        Change change = new Change(totalChangeInPennies);
        change.calcChange();
        return change;
    }

    private void exitVendingMachine() throws VendingMachinePersistenceException {
        Change change = getChange(clientMoney);
        view.displayChange(change);
        service.saveInventory();
    }

}
