package dbOperations;

import db.MySqlDbExecutor;
import tablesData.Curators;
import tablesData.Groups;
import tablesData.SelectResult;
import tablesData.Students;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectDataFromTable {

MySqlDbExecutor iDbExecutor = new MySqlDbExecutor();
    public void countStudentsBoys () throws SQLException {
        String queryCountBoys = "SELECT COUNT(sex) FROM student where sex='М';";
        ResultSet getBoys = iDbExecutor.executeSelect(queryCountBoys);
        SelectResult selectResult = new SelectResult();
        while (getBoys.next()) {
        selectResult.setResultQuantity(getBoys.getInt(1));
        }
        System.out.println("Всего студентов: " + selectResult.getResultQuantity());
        iDbExecutor.closeAll();

    }
    public void countStudentsGirls () throws SQLException {
        String queryCountGirls = "SELECT COUNT(sex) FROM student where sex='Ж';";
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
        String query = "SELECT student.id, student.fio, student.sex, student.id_group, gruppa.name, gruppa.id_curator, curator.fio" +
                " FROM student " +
                "JOIN gruppa " +
                "ON student.id_group=gruppa.id " +
                "JOIN curator  " +
                "ON gruppa.id_curator=curator.id;";
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

    public void printGroupsWithCurators () throws SQLException {
        Curators curators = new Curators();
        Groups groups = new Groups();
        String query = "SELECT * FROM gruppa " +
                "JOIN curator  " +
                "ON gruppa.id_curator=curator.id;";
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

    public void printStudentsFromGroup () throws SQLException {
        Students students = new Students();
        String selectStudents = "SELECT * " +
                "FROM student " +
                "WHERE (id_group) = " +
                " (SELECT id" +
                "  FROM gruppa" +
                "  WHERE name='Ракетомоделирование' );";
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
}