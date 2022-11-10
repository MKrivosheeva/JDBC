package db;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IDbExecutor {

public ResultSet execute (String sqlRequest) throws SQLException;
public void executeCRUD (String sqlRequest) throws SQLException;
public ResultSet executeSelect(String sqlRequest);

}
