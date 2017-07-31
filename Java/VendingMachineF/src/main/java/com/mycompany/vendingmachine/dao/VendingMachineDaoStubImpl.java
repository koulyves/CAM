/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachine.dao;

import com.mycompany.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author n0200797
 */
public class VendingMachineDaoStubImpl implements VendingMachineDao {

    Item onlyItem;
    List<Item> itemList = new ArrayList<>();
    
    

    public VendingMachineDaoStubImpl() {
        onlyItem = new Item(Integer.parseInt("0001"));
        onlyItem.setItemId(001);
        onlyItem.setName("Doritos");
        onlyItem.setPrice(BigDecimal.TEN);
        onlyItem.setQuantity(Integer.parseInt("1"));
        itemList.add(onlyItem);
    }
//******************************************************************************

    @Override
    public List<Item> getAllItems() throws VendingMachinePersistenceException {
        return itemList;
    }

    @Override
    public Item getAnItem(int itemId) throws VendingMachinePersistenceException {
        if (itemId == onlyItem.getItemId()) {
            return onlyItem;
        } else {
            return null;
        }
    }

    @Override
    public Item updateItemQuantity(Item item) throws
            VendingMachinePersistenceException {
        if (item.getItemId() == onlyItem.getItemId()) {
            onlyItem.removeAnItem();
            return onlyItem;
        } else {
            return null;
        }
    }

    @Override
    public void saveItemsToFile() throws
            VendingMachinePersistenceException {
    }

}
