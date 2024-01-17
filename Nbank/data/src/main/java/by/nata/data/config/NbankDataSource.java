package by.nata.data.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NbankDataSource {
    private static NbankDataSource dataSource;
    protected NbankDataSource() throws ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");

    }
    protected Connection getEShopConnection() throws SQLException {
        return   DriverManager.getConnection("jdbc:mysql://localhost:3306/N_BANK?createDatabaseIfNotExist=true",
                "user",
                "user");
    }
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (dataSource == null){
            dataSource = new NbankDataSource();
        }
        return dataSource.getEShopConnection();
    }
}
