package dbOperations;

import db.MySqlDbExecutor;
import java.sql.SQLException;

public class UpdateTableData {

    private String updateCurator = "UPDATE gruppa " +
            "SET id_curator=4 " +
            "WHERE id=3;";
    MySqlDbExecutor iDbExecutor = new MySqlDbExecutor();
    public void updateCurator() throws SQLException {
         iDbExecutor.executeCRUD(updateCurator);
    }
}