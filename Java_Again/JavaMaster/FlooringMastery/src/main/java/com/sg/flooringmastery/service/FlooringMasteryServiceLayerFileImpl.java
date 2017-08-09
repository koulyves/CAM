/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dao.FlooringMasteryOrderDao;
import com.sg.flooringmastery.dao.FlooringMasteryPersistenceException;
import com.sg.flooringmastery.dao.FlooringMasteryProductDao;
import com.sg.flooringmastery.dao.FlooringMasteryStateTaxDao;
import com.sg.flooringmastery.dto.Order;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author n0200797
 */
public class FlooringMasteryServiceLayerFileImpl implements FlooringMasteryServiceLayer {

    FlooringMasteryOrderDao orderDao;
    FlooringMasteryProductDao productDao;
    FlooringMasteryStateTaxDao stateTaxDao;

    public FlooringMasteryServiceLayerFileImpl(FlooringMasteryOrderDao orderDao,
            FlooringMasteryProductDao productDao, FlooringMasteryStateTaxDao stateTaxDao) {
        this.orderDao = orderDao;
        this.productDao = productDao;
        this.stateTaxDao = stateTaxDao;

    }
//******************************************************************************
    @Override
    public List<Order> getOrders(LocalDate date)
            throws NoOrderFoundException, FlooringMasteryPersistenceException  {
        List<Order> allOrderByDate = orderDao.retrieveOrdersByDate(date);
        return allOrderByDate;
    }
//******************************************************************************

    @Override
    public Order createOrder() 
            throws NoOrderFoundException, FlooringMasteryPersistenceException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
//******************************************************************************

//******************************************************************************    
}
