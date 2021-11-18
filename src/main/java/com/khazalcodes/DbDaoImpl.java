package com.khazalcodes;

import com.khazalcodes.interfaces.DbDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.naming.ldap.PagedResultsControl;
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
            PreparedStatement pStmt = conn.prepareCall("SELECT * FROM items");
            ResultSet rs =  pStmt.executeQuery();
            while (rs.next()) {
                ItemDto item = new ItemDto(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("amount_in_stock"));

                this.itemsHashMap.put(item.getKey(), item);
            }
        } catch (SQLException e) {
            handleSqlException(e);
        }
    }

    /**
     * Since we only need to worry about decrementing we only need to change the amount_in_stock
     * */
    @Override
    public void updateDb(ItemDto item) {
        try (Connection conn = DriverManager.getConnection(connectionUrl, user, pass)) {
            PreparedStatement pStmt = conn.prepareCall("UPDATE items SET amount_in_stock=? WHERE id=?");
            pStmt.setInt(1, item.getStockRemaining());
            pStmt.setInt(2, item.getKey());
            pStmt.executeUpdate();
        } catch (SQLException e) {
            handleSqlException(e);
        }
    }

    @Override
    public void deleteFromDb(ItemDto dto) {
        /*
          This functionality is not available to the user so will not be implemented in this class.
          */
    }

    @Override
    public void addToDb(ItemDto dto) {
        /*
          This functionality is not available to the user so will not be implemented in this class.
          */
    }

    @Override
    public Map<Integer, ItemDto> getDbAsMap() {
        return itemsHashMap;
    }

    @Override
    public ItemDto get(int id) {
        return null;
    }

    private void handleSqlException(SQLException e) {
        System.out.println("Error reading db");
        System.out.println(e.getMessage());
        e.printStackTrace();
        System.exit(0);
    }
}
