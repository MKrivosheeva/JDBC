package db;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IDbExecutor {

public void executeCRUD (String sqlRequest) throws SQLException;
public ResultSet executeSelect(String sqlRequest);

}
