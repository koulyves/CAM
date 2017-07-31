/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachine.dao;

import com.mycompany.vendingmachine.dto.Item;
import java.util.List;

/**
 *
 * @author n0200797
 */
public interface VendingMachineDao {
    /**
     * Returns a String array containing the Item IDs of all Items in the
     * list.
     ** @return String array containing the IDs of all the students in the roster
     * @throws com.mycompany.vendingmachine.dao.vendingMachineDaoException
     **/
    List<Item> getAllItems()
            throws VendingMachinePersistenceException;
     /**
     * Returns the item object associated with the given item id. Returns
     * null if no such item exists.
     *
     * @param itemId ID of the item to retrieve.
     * @return the item object associated with the given item id, null if
     * no such item exists
     * @throws com.mycompany.vendingmachine.dao.vendingMachineDaoException
     **/
    
    //Item getAnItem(int itemId)
    Item getAnItem(int itemId)
            throws VendingMachinePersistenceException;
    
    
     /**
     * Update from the inventory list the item associated with the given id. Returns
     * the item object that is being removed or null if there is no item
     * associated with the given id     *
     * @param itemId id of item to be removed
     * @return item object that was removed or null if no item was
     * associated with the given student id
     * @throws com.mycompany.vendingmachine.dao.vendingMachineDaoException
     */
    Item updateItemQuantity (Item item)
            throws VendingMachinePersistenceException;

    void saveItemsToFile()
            throws VendingMachinePersistenceException;
}
