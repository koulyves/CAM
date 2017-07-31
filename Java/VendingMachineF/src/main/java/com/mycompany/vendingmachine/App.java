/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachine;

import com.mycompany.vendingmachine.controller.VendingMachineController;
import com.mycompany.vendingmachine.dao.VendingMachineDao;
import com.mycompany.vendingmachine.dao.VendingMachineDaoFileImpl;
import com.mycompany.vendingmachine.service.VendingMachineServiceLayer;
import com.mycompany.vendingmachine.service.VendingMachineServiceLayerImpl;
import com.mycompany.vendingmachine.ui.UserIO;
import com.mycompany.vendingmachine.ui.UserIOConsoleImpl;
import com.mycompany.vendingmachine.ui.VendingMachineView;

/**
 *
 * @author n0200797
 */
public class App {
    public static void main(String[] args) {
        
        UserIO myIo = new UserIOConsoleImpl();
        VendingMachineDao myDao = new VendingMachineDaoFileImpl();
        
        VendingMachineServiceLayer myService = new VendingMachineServiceLayerImpl(myDao);
        VendingMachineView myView = new VendingMachineView(myIo);
        
        VendingMachineController controller = new VendingMachineController(myService, myView);
        controller.run();        
    }    
}
