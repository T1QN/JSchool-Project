package com.model.entity.item.dao;

import com.model.entity.item.Item;

import java.sql.SQLException;
import java.util.List;

public interface ItemDAO {
    void add(Item item) throws SQLException;
    void update(Item item) throws SQLException;
    Item getById(Integer id) throws SQLException;

    List<Item> getAll() throws SQLException;
    List<Item> getByStatus(String status) throws SQLException;
    List<Item> getPrepared() throws SQLException;
    List<Item> getUnload() throws SQLException;
    List<Item> getDelivered() throws SQLException;

    void delete(Item item);
}
