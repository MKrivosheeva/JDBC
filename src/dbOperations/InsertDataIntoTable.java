package dbOperations;

import db.MySqlDbExecutor;
import java.sql.SQLException;

public class InsertDataIntoTable {

    MySqlDbExecutor iDbExecutor = new MySqlDbExecutor();
    public void insertDataIntoStudentsTable () throws SQLException {

      iDbExecutor.executeCRUD("INSERT INTO student (fio, sex, id_group) VALUES ('Петров', 'М', 1);");
      iDbExecutor.executeCRUD("INSERT INTO student (fio, sex, id_group) VALUES ('Васечкин', 'М', 1);");
      iDbExecutor.executeCRUD("INSERT INTO student (fio, sex, id_group) VALUES ('Ложкин', 'М', 1);");
      iDbExecutor.executeCRUD("INSERT INTO student (fio, sex, id_group) VALUES ('Ножкин', 'М', 1);");
      iDbExecutor.executeCRUD("INSERT INTO student (fio, sex, id_group) VALUES ('Кошкин', 'М', 1);");
      iDbExecutor.executeCRUD("INSERT INTO student (fio, sex, id_group) VALUES ('Петрова', 'Ж', 2);");
      iDbExecutor.executeCRUD("INSERT INTO student (fio, sex, id_group) VALUES ('Кузнецов', 'М', 2);");
      iDbExecutor.executeCRUD("INSERT INTO student (fio, sex, id_group) VALUES ('Мышкин', 'М', 2);");
      iDbExecutor.executeCRUD("INSERT INTO student (fio, sex, id_group) VALUES ('Сидорова', 'Ж', 2);");
      iDbExecutor.executeCRUD("INSERT INTO student (fio, sex, id_group) VALUES ('Кораблёв', 'М', 2);");
      iDbExecutor.executeCRUD("INSERT INTO student (fio, sex, id_group) VALUES ('Королёва', 'Ж', 3);");
      iDbExecutor.executeCRUD("INSERT INTO student (fio, sex, id_group) VALUES ('Носкова', 'Ж', 3);");
      iDbExecutor.executeCRUD("INSERT INTO student (fio, sex, id_group) VALUES ('Павлова', 'Ж', 3);");
      iDbExecutor.executeCRUD("INSERT INTO student (fio, sex, id_group) VALUES ('Макарова', 'Ж', 3);");
      iDbExecutor.executeCRUD("INSERT INTO student (fio, sex, id_group) VALUES ('Назарова', 'Ж', 3);");
   }

    public void insertDataIntoGroupsTable () throws SQLException {
        iDbExecutor.executeCRUD("INSERT INTO gruppa (name, id_curator) VALUES ('Авиамоделирование', 1);");
        iDbExecutor.executeCRUD("INSERT INTO gruppa (name, id_curator) VALUES ('Ракетомоделирование', 2);");
        iDbExecutor.executeCRUD("INSERT INTO gruppa (name, id_curator) VALUES ('Радиосвязь', 3);");

    }
    public void insertDataIntoCuratorsTable () throws SQLException {
        iDbExecutor.executeCRUD("INSERT INTO curator (fio) VALUES ('Абрикосов');");
        iDbExecutor.executeCRUD("INSERT INTO curator (fio) VALUES ('Яблочкина');");
        iDbExecutor.executeCRUD("INSERT INTO curator (fio) VALUES ('Персиков');");
        iDbExecutor.executeCRUD("INSERT INTO curator (fio) VALUES ('Виноградова');");

    }
}
