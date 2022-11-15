package db;

import utils.resources.IResources;
import utils.resources.PropertiesReader;
import java.sql.*;
import java.util.Map;

public class MySqlDbExecutor implements IDbExecutor {

    Connection connection = null;
    Statement statement = null;

    @Override
    public void executeCRUD (String sqlRequest) throws SQLException {
        IResources resource = (IResources) new PropertiesReader();
        Map<String, String> props = resource.read();
        String url = String.format("%s/%s", props.get("url"), props.get("db_name"));
        try {
            connection = DriverManager.getConnection(url, props.get("username"), props.get("password"));
            statement = connection.createStatement();
            statement.execute(sqlRequest);
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
    @Override
    public ResultSet executeSelect(String sqlRequest)  {
        IResources resource = (IResources) new PropertiesReader();
        Map<String, String> props = resource.read();
        String url = String.format("%s/%s", props.get("url"), props.get("db_name"));
        try {
            connection = DriverManager.getConnection(url, props.get("username"), props.get("password"));
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlRequest);
            return resultSet;
        }
        catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public void closeAll() throws SQLException{
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
}

