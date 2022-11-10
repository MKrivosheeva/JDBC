package dbOperations;


import db.MySqlDbExecutor;
import java.sql.*;

public class CreateTable  {

    MySqlDbExecutor iDbExecutor = new MySqlDbExecutor();
    private final  String createTableStudent = "CREATE TABLE `mytest`.`student` ("+
            "  `id` INT NOT NULL AUTO_INCREMENT,"+
            "  `fio` VARCHAR(45) NOT NULL,"+
            "  `sex` VARCHAR(45) NOT NULL,"+
            "  `id_group` INT NOT NULL,"+
            "  PRIMARY KEY (`id`)) "+
            "ENGINE = InnoDB "+
            "DEFAULT CHARACTER SET = utf8;";

    private final   String createTableGroup = "CREATE TABLE `mytest`.`gruppa` (" +
            "  `id` INT NOT NULL AUTO_INCREMENT," +
            "  `name` VARCHAR(45) NOT NULL," +
            "  `id_curator` INT NOT NULL," +
            "  PRIMARY KEY (`id`))" +
            "ENGINE = InnoDB " +
            "DEFAULT CHARACTER SET = utf8;" ;
    private final  String createTableCurator = "CREATE TABLE `mytest`.`curator` (" +
            "  `id` INT NOT NULL AUTO_INCREMENT," +
            "  `fio` VARCHAR(45) NOT NULL," +
            "  PRIMARY KEY (`id`))" +
            "ENGINE = InnoDB " +
            "DEFAULT CHARACTER SET = utf8;";

   public void createTables () throws SQLException {
       iDbExecutor.executeCRUD(createTableStudent);
       iDbExecutor.executeCRUD(createTableCurator);
       iDbExecutor.executeCRUD(createTableGroup);

   }

}
