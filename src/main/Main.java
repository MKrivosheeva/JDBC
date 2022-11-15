package main;

import dataToInsertIntoTables.GroupsData;
import dataToInsertIntoTables.TablesList;
import dbOperations.CreateTable;
import dbOperations.InsertDataIntoTable;
import dbOperations.SelectDataFromTable;
import dbOperations.UpdateTableData;
import java.sql.SQLException;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) throws SQLException {

        CreateTable createTables = new CreateTable();
        InsertDataIntoTable insertDataIntoTable = new InsertDataIntoTable();
        SelectDataFromTable selectDataFromTable = new SelectDataFromTable();
        UpdateTableData updateTableData  = new UpdateTableData();

          createTables.createTables();
          insertDataIntoTable.insertDataIntoStudentsTable();
          insertDataIntoTable.insertDataIntoCuratorsTable();
          insertDataIntoTable.insertDataIntoGroupsTable();
          selectDataFromTable.joinAllData();
          selectDataFromTable.countStudentsBoys();
          selectDataFromTable.countStudentsGirls();
          updateTableData.updateCurator(ThreadLocalRandom.current().nextInt(1, 5), ThreadLocalRandom.current().nextInt(1, 3));
          selectDataFromTable.printGroupsWithCurators(TablesList.GROUPS.getName(), TablesList.CURATORS.getName());
          selectDataFromTable.printStudentsFromGroup(GroupsData.getRandomGroup().getName());

    }
}
