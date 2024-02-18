package by.nata.data.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NbankDataSourceTest extends NbankDataSource{
    private static NbankDataSourceTest dataSource;
    protected NbankDataSourceTest() throws ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");

    }
    protected Connection getNbankConnection() throws SQLException {
        return   DriverManager.getConnection("jdbc:mysql://localhost:3306/N_BANK_TEST?createDatabaseIfNotExist=true",
                "user",
                "user");
    }
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (dataSource == null){
            dataSource = new NbankDataSourceTest();
        }
        return dataSource.getNbankConnection();
    }
}
