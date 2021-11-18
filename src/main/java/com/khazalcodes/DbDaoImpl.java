package com.khazalcodes;

import com.khazalcodes.interfaces.DbDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

@Component
@Qualifier("dbDao")
public class DbDaoImpl implements DbDao<ItemDto> {

    private final Map<Integer, ItemDto> itemsHashMap = new HashMap<>();
    private static final String connectionUrl = "jdbc:mysql://localhost:3306/vending_machine";
    private static final String user = "dummy";
    private static final String pass = "";


    public DbDaoImpl() { readDb(); }

    @Override
    public void readDb() {
        try (Connection conn = DriverManager.getConnection(connectionUrl, user, pass)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM items");

            while (rs.next()) {
                ItemDto item = new ItemDto(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("amount_in_stock"));

                this.itemsHashMap.put(item.getKey(), item);
            }
        } catch (SQLException e) {
            System.out.println("Error reading db");
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.exit(0);
        }
    }

    @Override
    public void updateDb(ItemDto item) {
    }

    @Override
    public void deleteFromDb(ItemDto dto) {

    }
    @Override
    public void addToDb(ItemDto dto) {


    }

    @Override
    public Map<Integer, ItemDto> getDbAsMap() {
        return itemsHashMap;
    }

    @Override
    public ItemDto get(int id) {
        return null;
    }
}