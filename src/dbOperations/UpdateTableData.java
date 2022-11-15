package dbOperations;

import dataToInsertIntoTables.TablesList;
import db.MySqlDbExecutor;
import java.sql.SQLException;

public class UpdateTableData {

    MySqlDbExecutor iDbExecutor = new MySqlDbExecutor();
    public void updateCurator(int id_curator, int id_group) throws SQLException {
    String updateCurator = String.format("UPDATE %s SET id_curator=%d WHERE id=%d", TablesList.GROUPS.getName(), id_curator, id_group);
    iDbExecutor.executeCRUD(updateCurator);
    }



}
