/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dao.FlooringMasteryPersistenceException;
import com.sg.flooringmastery.dto.Order;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author n0200797
 */
public interface FlooringMasteryServiceLayer {

    public List<Order> getOrders(LocalDate date)
            throws NoOrderFoundException, FlooringMasteryPersistenceException;
//******************************************************************************
    public Order createOrder()
            throws NoOrderFoundException, FlooringMasteryPersistenceException;
}
