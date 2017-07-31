/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachine.service;

import com.mycompany.vendingmachine.dao.VendingMachineDao;
import com.mycompany.vendingmachine.dao.VendingMachineDaoStubImpl;
import com.mycompany.vendingmachine.dao.VendingMachinePersistenceException;
import com.mycompany.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author n0200797
 */
public class VendingMachineServiceLayerTest {

    private VendingMachineServiceLayer service;

    public VendingMachineServiceLayerTest() {
        VendingMachineDao dao = new VendingMachineDaoStubImpl();//Allows me to USE the STUB IMPLEMENTATION
        service = new VendingMachineServiceLayerImpl(dao);
    }
//******************************************************************************    
    //Static

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
//******************************************************************************

    /**
     * Test of getInventory method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testGetInventory() throws Exception {
        System.out.println("GET INVENTORY TEST");
        assertEquals(1, service.getInventory().size());
    }

    /**
     * Test of validateMoney method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testValidateMoney() throws Exception {
        System.out.println("VALIDATE MONEY IS BIGDECIMAL");
        BigDecimal clientMoney = new BigDecimal("1.05");
        service.validateMoney(clientMoney);
    }

    @Test
    public void testValidateMoneyWithThreeDecimals() throws Exception {
        System.out.println("VALIDATE MONEY RULES WITH 3 DECIMALS");
        BigDecimal clientMoney = new BigDecimal("1.055");
        try {
            service.validateMoney(clientMoney);
            fail("Expected InvalidClientMoneyException was not thrown. ");
        } catch (InvalidClientMoneyException e) {
            return;
        }
    }

    @Test
    public void testValidateMoneyWithNegativeValue() throws Exception {
        System.out.println("VALIDATE MONEY RULES WITH NEGATIVE VALUE");
        BigDecimal clientMoney = new BigDecimal("-1.055");
        try {
            service.validateMoney(clientMoney);
            fail("Expected InvalidClientMoneyException was not thrown. ");
        } catch (InvalidClientMoneyException e) {
            return;
        }
    }

    @Test
    public void testValidateMoneyWithPennies() throws Exception {
        System.out.println("VALIDATE MONEY RULES WITH PENNIES");
        BigDecimal clientMoney = new BigDecimal("1.01");
        try {
            service.validateMoney(clientMoney);
            fail("Expected InvalidClientMoneyException was not thrown. ");
        } catch (InvalidClientMoneyException e) {
            return;
        }
    }

    /**
     * Test of purchaseItem method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testPurchaseItem() throws Exception {
        System.out.println("PURCHASE ITEM TEST");
        int itemId = 1;
        BigDecimal clientMoney = BigDecimal.TEN;
        BigDecimal change = service.purchaseItem(itemId, clientMoney);
        assertEquals(BigDecimal.ZERO, change);
    }

    @Test
    public void testPurchaseItemWithItemNotFound() throws Exception {
        System.out.println("PURCHASE ITEM TEST WITH ITEM NOT FOUND");
        int itemId = 2;
        BigDecimal clientMoney = BigDecimal.TEN;
        try {
            BigDecimal change = service.purchaseItem(itemId, clientMoney);
        } catch (InvalidItemSelectionException e) {
            return;
        }
    }

    @Test
    public void testPurchaseItemWithItemQuantityZero() throws Exception {
        System.out.println("PURCHASE ITEM TEST WITH ITEM QUANTITY ZERO");
        int itemId = 1;
        BigDecimal clientMoney = BigDecimal.TEN;
        try {
            BigDecimal change = service.purchaseItem(itemId, clientMoney);
            change = service.purchaseItem(itemId, clientMoney);
        } catch (NoItemInventoryException e) {
            return;
        }
    }

    @Test
    public void testPurchaseItemWithInsufficientFunds() throws Exception {
        System.out.println("PURCHASE ITEM TEST WITH INSUFFICIENT FUNDS");
        int itemId = 1;
        BigDecimal clientMoney = BigDecimal.ONE;
        try {
            BigDecimal change = service.purchaseItem(itemId, clientMoney);
        } catch (InsufficientFundsException e) {
            return;
        }
    }

    /**
     * Test of saveInventory method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testSaveInventory() throws Exception {
        System.out.println("SAVE INVENTORY");
        service.saveInventory();
    }

}
