/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.dto.Product;
import com.sg.flooringmastery.dto.StateTax;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author n0200797
 */
public class FlooringMasteryOrderDaoFileImpl implements FlooringMasteryOrderDao {

    public static final String DELIMITER = ",";
    HashMap<LocalDate, HashMap<Integer, Order>> orderMapMemory = new HashMap<>();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");

//******************************************************************************
    @Override
    public void createOrder(LocalDate date, Order order) {
        //ADD AN IF STATEMENT TO VALIDATE IF ORDER EXIST. IF NO CREATE A NEW ONE
        HashMap<Integer, Order> newMap = new HashMap<>();
        newMap.put(order.getNumber(), order);
        orderMapMemory.put(date, newMap);
    }

    @Override
    public void removeOrder(LocalDate date, int number)
            throws FlooringMasteryPersistenceException {
        orderMapMemory.get(date).remove(number);
    }

    @Override
    public Order editOrder(LocalDate date, Order order)
            throws FlooringMasteryPersistenceException {
        Order editedOrder = orderMapMemory.get(date).put(order.getNumber(), order);
        return editedOrder;
    }

    @Override
    public List<Order> retrieveOrdersByDate(LocalDate date)
            throws FlooringMasteryPersistenceException {
        return new ArrayList<Order>(orderMapMemory.get(date).values());
    }

    @Override
    public Order retrieveOrdersByDateAndId(LocalDate date, int number)
            throws FlooringMasteryPersistenceException {
        return orderMapMemory.get(date).get(number);

    }

    @Override
    public void load(LocalDate date)
            throws FlooringMasteryPersistenceException {
        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader("Orders_" + date.format(formatter))));

        } catch (FileNotFoundException e) {
            throw new FlooringMasteryPersistenceException("-_- COULD NOT LOAD ORDER DATA INTO MEMORY.", e);
        }

        String currentLine;
        String[] currentTokens;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);

            Order newOrder = new Order(Integer.parseInt(currentTokens[0]));

            newOrder.setCustomerName(currentTokens[1]);

            StateTax newStateTax = new StateTax(currentTokens[2]);
            newStateTax.setTaxRate(new BigDecimal(currentTokens[3]));
            newOrder.setTaxRate(newStateTax);

            Product newProduct = new Product(currentTokens[4]);
            newProduct.setProductType(currentTokens[5]);
            newOrder.setProductType(newProduct);

            newOrder.setArea(new BigDecimal(currentTokens[6]));
            newOrder.setLaborCost(new BigDecimal(currentTokens[7]));
            newOrder.setMaterialCost(new BigDecimal(currentTokens[8]));
            newOrder.setLaborCostPerSqFt(new BigDecimal(currentTokens[9]));
            newOrder.setTax(new BigDecimal(currentTokens[10]));
            newOrder.setTotal(new BigDecimal(currentTokens[11]));

            HashMap<Integer, Order> newMap = new HashMap<>();

            newMap.put(newOrder.getNumber(), newOrder);
            orderMapMemory.put(date, newMap);

        }
        scanner.close();
    }
//******************************************************************************

    @Override
    public void saveOrder(LocalDate date)
            throws FlooringMasteryPersistenceException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter("Orders_" + date.format(formatter) + ".txt"));
        } catch (IOException e) {
            throw new FlooringMasteryPersistenceException("COULD NOT FIND THE ORDER. ", e);
        }
        List<Order> orderList = this.retrieveOrdersByDate(date);
        for (Order currentOrder : orderList) {
            out.print(currentOrder.getNumber() + DELIMITER
                    + currentOrder.getCustomerName() + DELIMITER
                    + currentOrder.getCustomerState() + DELIMITER
                    + currentOrder.getTaxRate() + DELIMITER
                    + currentOrder.getProductType() + DELIMITER
                    + currentOrder.getArea() + DELIMITER
                    + currentOrder.getCostPerSqFt() + DELIMITER
                    + currentOrder.getLaborCostPerSqFt() + DELIMITER
                    + currentOrder.getMaterialCost() + DELIMITER
                    + currentOrder.getLaborCost() + DELIMITER
                    + currentOrder.getTax() + DELIMITER
                    + currentOrder.getTotal());

            out.flush();
        }
        out.close();
    }
}
//******************************************************************************    

