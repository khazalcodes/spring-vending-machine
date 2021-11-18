package com.khazalcodes;

import com.khazalcodes.interfaces.Dao;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

@Component
@Qualifier("dbDao")
public class DbDao implements Dao<ItemDto> {

    private final Map<Integer, ItemDto> itemsHashMap = new HashMap<>();
    private static final String connectionUrl = "jdbc:mysql://localhost:3306/vending_machine";
    private static final String user = "dummy";
    private static final String pass = "";


    public DbDao() {
        readItemsTable();
    }

    public void readItemsTable() {
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
//            StringWriter sq = new StringWriter();
//            PrintWriter pw = new PrintWriter(sq);
            e.printStackTrace();
            System.exit(0);
        }
    }

    @Override
    public void saveDb() {

    }

    @Override
    public Map<Integer, ItemDto> getAll() {
        return itemsHashMap;
    }

    @Override
    public ItemDto get(int id) {
        return null;
    }
}
