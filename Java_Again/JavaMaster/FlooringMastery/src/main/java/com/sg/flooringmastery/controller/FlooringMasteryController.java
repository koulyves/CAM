/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.controller;

import com.sg.flooringmastery.dao.FlooringMasteryPersistenceException;
import com.sg.flooringmastery.service.FlooringMasteryServiceLayer;
import com.sg.flooringmastery.service.InvalidSelectionException;
import com.sg.flooringmastery.service.NoOrderFoundException;
import com.sg.flooringmastery.ui.FlooringMasteryView;
import java.time.LocalDate;

/**
 *
 * @author n0200797
 */
public class FlooringMasteryController {

    private FlooringMasteryView view;
    private FlooringMasteryServiceLayer service;

    public FlooringMasteryController(FlooringMasteryServiceLayer service,
            FlooringMasteryView view) {
        this.service = service;
        this.view = view;
    }
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
                            displayOrders();
                            break;
                        case 2:

                            break;
                        case 3:

                            break;

                        case 4:

                            break;
                        case 5:

                            break;
                        case 6:
                            keepGoing = false;
                            break;
                        default:
                    }
                } catch (InvalidSelectionException e) {
                    view.displayErrorMessage(e.getMessage());
                }
            }
            exitMessage();
        } catch (FlooringMasteryPersistenceException e) {
            view.displayErrorMessage(e.getMessage());

        }
    }
//******************************************************************************

    private int getMenuSelection()
            throws FlooringMasteryPersistenceException,
            InvalidSelectionException {
        return view.displayMenuSelection();
    }
//******************************************************************************    

    private void exitMessage() {
        view.displayExitBanner();
    }
//******************************************************************************
    private void displayOrders()
            throws
            FlooringMasteryPersistenceException {
        try {
            view.displayOrders();
            LocalDate date = view.displayRequestOrderDate();
            view.displayOrderList(service.getOrders(date));
        } catch (NoOrderFoundException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }
//******************************************************************************    
}
