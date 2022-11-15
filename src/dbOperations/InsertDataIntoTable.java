package dbOperations;

import dataToInsertIntoTables.CuratorsData;
import dataToInsertIntoTables.GroupsData;
import dataToInsertIntoTables.StudentsData;
import dataToInsertIntoTables.TablesList;
import db.MySqlDbExecutor;
import java.sql.SQLException;

public class InsertDataIntoTable {

    MySqlDbExecutor iDbExecutor = new MySqlDbExecutor();

    public void insertDataIntoStudentsTable() throws SQLException {
        String thisQuery;
        for (int i = 0; i < 15; i++) {
            StudentsData randomStudent = StudentsData.getRandomStudent();
            thisQuery = String.format("INSERT INTO %s (fio, sex, id_group) VALUES ('%s', '%s', %d);", TablesList.STUDENTS.getName(), randomStudent.getFio(), randomStudent.getSex(), randomStudent.getId_group());
            iDbExecutor.executeCRUD(thisQuery);
        }
    }

    public void insertDataIntoGroupsTable() throws SQLException {
        String thisQuery;
        for (int i = 0; i < 3; i++) {
            GroupsData randomGroup = GroupsData.getRandomGroup();
            thisQuery = String.format("INSERT INTO %s (name, id_curator) VALUES ('%s', %d);", TablesList.GROUPS.getName(), randomGroup.getName(), randomGroup.getId_curatror());
            iDbExecutor.executeCRUD(thisQuery);
        }
    }

    public void insertDataIntoCuratorsTable() throws SQLException {
        String thisQuery;
        for (int i = 0; i < 4; i++) {
            CuratorsData randomCurator = CuratorsData.getRandomCurator();
            thisQuery = String.format("INSERT INTO %s (fio) VALUES ('%s');", TablesList.CURATORS.getName(), randomCurator.getFio());
            iDbExecutor.executeCRUD(thisQuery);
        }
    }
}
