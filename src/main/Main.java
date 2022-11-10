package main;

import db.IDbExecutor;
import db.MySqlDbExecutor;
import dbOperations.CreateTable;
import dbOperations.InsertDataIntoTable;
import dbOperations.SelectDataFromTable;
import dbOperations.UpdateTableData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        updateTableData.updateCurator();
        selectDataFromTable.printGroupsWithCurators();
        selectDataFromTable.printStudentsFromGroup();

    }
}
