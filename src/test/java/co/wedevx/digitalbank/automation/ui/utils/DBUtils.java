package co.wedevx.digitalbank.automation.ui.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static co.wedevx.digitalbank.automation.ui.utils.ConfigReader.getPropertiesvalue;

public class DBUtils {

    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;

    //method to establish connection with the DB
    public static void establishConnection(){

//        String url = "jdbc:mysql://3.249.240.23:3306/mayafarberov";
//        String username = "mayafarberov";
//        String password = ";DUF,EqK";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(ConfigReader.getPropertiesvalue("digitalbank.db.url"),
                        getPropertiesvalue("digitalbank.db.username"),
                        getPropertiesvalue("digitalbank.db.password"));
            } catch (SQLException  | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
    }

    //a method that can dynamically send select statements and return a list of map of all columns
    public static List<Map<String,Object>> runSQLSelectQuery(String sqlQuery){

        List<Map<String,Object>> dbResultList = new ArrayList<>();

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlQuery);

            //getMetaData method return info about your info.
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();
            while(resultSet.next()){
                Map<String, Object> rowMap = new HashMap<>();
                for(int col =1; col <= columnCount; col ++){
                    rowMap.put(resultSetMetaData.getColumnName(col),resultSet.getObject(col));
                }
                dbResultList.add(rowMap);
            }
            return dbResultList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //a method that inserts into DB and return the numbers of rows updated or 0 when action is not taken

    //delete or truncate the table
    public static int runSQLUpdateQuery(String sqlQuery){
        int rowsAffected = 0;
        try {
            statement = connection.createStatement();
           rowsAffected =  statement.executeUpdate(sqlQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
return rowsAffected;

    }

    //close connection method
public static void closeConnection(){
        try{
            if(resultSet!= null){
                resultSet.close();
            }
            if(statement != null){
                statement.close();
            }
            if(connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
}
}
