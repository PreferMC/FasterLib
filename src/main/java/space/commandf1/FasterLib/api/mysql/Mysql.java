package space.commandf1.FasterLib.api.mysql;

import java.sql.*;

/**
 * Code from SpeedCubingLib
 *
 * */
@SuppressWarnings("all")
public class Mysql {
    private final String address, username, password;
    private final Connection connection;

    public Mysql(String address, String username, String password) throws SQLException {
        this.address = address;
        this.username = username;
        this.password = password;
        this.connection = DriverManager.getConnection(this.address, this.username, this.password);
    }

    public Mysql delete(String table, String where) throws SQLException {
        this.connection.prepareStatement("DELETE  FROM " + table + " WHERE " + where).execute();
        return this;
    }

    public Mysql update(String table, String field, String where) throws SQLException {
        this.connection.prepareStatement("UPDATE " + table + " SET " + field + " WHERE " + where).execute();
        return this;
    }

    public Mysql insert(String table, String field, String value) throws SQLException {
        this.connection.prepareStatement("INSERT INTO " + table + " " + field + " VALUES " + value).execute();
        return this;
    }

    public boolean isStringExist(String table, String field, String target) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + table + " WHERE " + field + "=?");
        statement.setString(1, target);
        return statement.executeQuery().next();
    }

    public double selectDouble(String table, String field, String where) throws SQLException {
        ResultSet resultSet = connection.createStatement().executeQuery("SELECT " + field + " FROM " + table + " WHERE " + where);
        resultSet.next();
        return resultSet.getDouble(1);
    }

    public int selectInt(String table, String field, String where) throws SQLException {
        ResultSet resultSet = connection.createStatement().executeQuery("SELECT " + field + " FROM " + table + " WHERE " + where);
        resultSet.next();
        return resultSet.getInt(1);
    }

    public int count(String table, String field, String where) throws SQLException {
        ResultSet resultSet = connection.createStatement().executeQuery("SELECT count(" + field + ") FROM " + table + " WHERE " + where);
        resultSet.next();
        return resultSet.getInt(1);
    }

    public int[] selectInts(String table, String field, String where) throws SQLException {
        ResultSet resultSet = connection.createStatement().executeQuery("SELECT " + field + " FROM " + table + " WHERE " + where);
        resultSet.next();
        int size = resultSet.getMetaData().getColumnCount();
        int[] ints = new int[size];
        for (int i = 0; i < size; i++)
            ints[i] = resultSet.getInt(i + 1);
        return ints;
    }

    public boolean[] selectBooleans(String table, String field, String where) throws SQLException {
        ResultSet resultSet = connection.createStatement().executeQuery("SELECT " + field + " FROM " + table + " WHERE " + where);
        resultSet.next();
        int size = resultSet.getMetaData().getColumnCount();
        boolean[] bs = new boolean[size];
        for (int i = 0; i < size; i++)
            bs[i] = resultSet.getBoolean(i + 1);
        return bs;
    }

    public boolean selectBoolean(String table, String field, String where) throws SQLException {
        ResultSet resultSet = connection.createStatement().executeQuery("SELECT " + field + " FROM " + table + " WHERE " + where);
        resultSet.next();
        return resultSet.getBoolean(1);
    }

    public String selectString(String table, String field, String where) throws SQLException {
        ResultSet resultSet = connection.createStatement().executeQuery("SELECT " + field + " FROM " + table + " WHERE " + where);
        resultSet.next();
        return resultSet.getString(1);
    }

    public String[] selectStrings(String table, String field, String where) throws SQLException {
        ResultSet resultSet = connection.createStatement().executeQuery("SELECT " + field + " FROM " + table + " WHERE " + where);
        resultSet.next();
        int size = resultSet.getMetaData().getColumnCount();
        String[] str = new String[size];
        for (int i = 0; i < size; i++)
            str[i] = resultSet.getString(i + 1);
        return str;
    }
}
