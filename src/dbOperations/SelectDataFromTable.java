package dbOperations;

import dataToInsertIntoTables.TablesList;
import db.MySqlDbExecutor;
import tablesData.Curators;
import tablesData.Groups;
import tablesData.SelectResult;
import tablesData.Students;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class SelectDataFromTable {

MySqlDbExecutor iDbExecutor = new MySqlDbExecutor();
    public void countStudentsBoys () throws SQLException {
        String queryCountBoys = String.format("SELECT COUNT(sex) FROM %s where sex='М';", TablesList.STUDENTS.getName());
        ResultSet getBoys = iDbExecutor.executeSelect(queryCountBoys);
        SelectResult selectResult = new SelectResult();
        while (getBoys.next()) {
        selectResult.setResultQuantity(getBoys.getInt(1));
        }
        System.out.println("Всего студентов: " + selectResult.getResultQuantity());
        iDbExecutor.closeAll();
    }
    public void countStudentsGirls () throws SQLException {
        String queryCountGirls = String.format("SELECT COUNT(sex) FROM %s where sex='Ж';", TablesList.STUDENTS.getName());
        ResultSet getGirls = iDbExecutor.executeSelect(queryCountGirls);
        SelectResult selectResult = new SelectResult();
        while (getGirls.next()) {
            selectResult.setResultQuantity(getGirls.getInt(1));
      }
        System.out.println("Всего студенток: " + selectResult.getResultQuantity());
        iDbExecutor.closeAll();
    }

    public void joinAllData () throws SQLException {
        Students students = new Students();
        Curators curators = new Curators();
        Groups groups = new Groups();

        String query = String.format("SELECT student.id, student.fio, student.sex, student.id_group, gruppa.name, gruppa.id_curator, curator.fio" +
                " FROM %s JOIN %s ON %s JOIN %s ON %s;", TablesList.STUDENTS.getName(),
                TablesList.GROUPS.getName(), getJoinParameters().get(TablesList.GROUPS.getName()),
                TablesList.CURATORS.getName(), getJoinParameters().get(TablesList.CURATORS.getName()));
        ResultSet resultSet = iDbExecutor.executeSelect(query);
        while (resultSet.next()) {
            students.setId(resultSet.getInt("id"));
            students.setFio(resultSet.getString("fio"));
            students.setSex(resultSet.getString("sex"));
            students.setId_group(resultSet.getInt("id_group"));
            groups.setName(resultSet.getString("name"));
            groups.setId_curator(resultSet.getInt("id_curator"));
            curators.setFio(resultSet.getString(7));
            System.out.println("ID студента " + students.getId()  +
                  " ФИО студента " + students.getFio()+
                  " Пол студента " +students.getSex() +
                  " Название группы " + groups.getName() +
                  " ID группы " +groups.getId_curator() +
                  " ФИО куратора "+curators.getFio());
       }
        iDbExecutor.closeAll();
    }
    public void printGroupsWithCurators (String tableSelectFromName, String tableJoinWithName) throws SQLException {
        Curators curators = new Curators();
        Groups groups = new Groups();
        String query = String.format("SELECT gruppa.id, gruppa.name, gruppa.id_curator, curator.fio FROM %s JOIN %s ON %s;"
                ,tableSelectFromName, tableJoinWithName, getJoinParameters().get(tableJoinWithName));
        ResultSet resultSet = iDbExecutor.executeSelect(query);
        while (resultSet.next()) {
            groups.setId(resultSet.getInt("id"));
            groups.setName(resultSet.getString("name"));
            groups.setId_curator(resultSet.getInt("id_curator"));
            curators.setFio(resultSet.getString("fio"));
            System.out.println("ID группы " + groups.getId() +
                    " Название группы " + groups.getName() +
                    " ID куратора " + groups.getId_curator() +
                    " ФИО куратора " + curators.getFio());
        }
        iDbExecutor.closeAll();
    }

    public void printStudentsFromGroup(String groupName) throws SQLException {
        Students students = new Students();
        String selectStudents = String.format("SELECT * FROM %s WHERE (id_group) = ANY (SELECT id FROM %s WHERE name='%s');", TablesList.STUDENTS.getName(), TablesList.GROUPS.getName(), groupName);
        ResultSet resultSet = iDbExecutor.executeSelect(selectStudents);
        while (resultSet.next()) {
            students.setId(resultSet.getInt("id"));
            students.setFio(resultSet.getString("fio"));
            students.setSex(resultSet.getString("sex"));
            students.setId_group(resultSet.getInt("id_group"));
            System.out.println("ID студента " + students.getId()  +
                    " ФИО студента " + students.getFio()+
                    " Пол студента " +students.getSex() +
                    " ID группы " +students.getId_group());
        }
     iDbExecutor.closeAll();
    }
    public Map<String, String> getJoinParameters () {
       Map<String, String> joinOptions = new HashMap<>();
        joinOptions.put(TablesList.GROUPS.getName(), "student.id_group=gruppa.id");
        joinOptions.put(TablesList.CURATORS.getName(), "gruppa.id_curator=curator.id");
    return joinOptions;
    }
}