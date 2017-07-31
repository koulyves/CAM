/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachine.dao;

import com.mycompany.vendingmachine.dto.Item;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author n0200797
 */
public class VendingMachineDaoTest {
    
    private VendingMachineDao dao = new VendingMachineDaoFileImpl();
    Item onlyItem;
    
    public VendingMachineDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception{
        //Set My Dao to a Known Good State
        List<Item> itemList = dao.getAllItems();
        onlyItem = itemList.get(0);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAllItems method, of class VendingMachineDao.
     */
    @Test
    public void testGetAllItems() throws Exception {
        assertFalse(dao.getAllItems().isEmpty());
    }

    /**
     * Test of getAnItem method, of class VendingMachineDao.
     */
    @Test
    public void testGetAnItem() throws Exception {
        int itemId = onlyItem.getItemId();
        Item item = dao.getAnItem(itemId);
        assertEquals(onlyItem.getItemId(), item.getItemId());
        assertEquals(onlyItem.getName(), item.getName());
        assertEquals(onlyItem.getPrice(), item.getPrice());
        assertEquals(onlyItem.getQuantity(), item.getQuantity());
    }

    @Test
    public void testGetAnItemNotFound() throws Exception {
        int itemId = 999;
        Item item = dao.getAnItem(itemId);
        assertNull(item);
    }

    /**
     * Test of updateItemQuantity method, of class VendingMachineDao.
     */
    @Test
    public void testUpdateItemQuantity() throws Exception {
        Item updatedItem = dao.updateItemQuantity(onlyItem);
        assertEquals(onlyItem.getItemId(), updatedItem.getItemId());
        assertEquals(onlyItem.getName(), updatedItem.getName());
        assertEquals(onlyItem.getPrice(), updatedItem.getPrice());
        assertEquals(onlyItem.getQuantity(), updatedItem.getQuantity());
    }

    /**
     * Test of saveItemsToFile method, of class VendingMachineDao.
     */
    @Test
    public void testSaveItemsToFile() throws Exception {
        dao.saveItemsToFile();
    }

}
