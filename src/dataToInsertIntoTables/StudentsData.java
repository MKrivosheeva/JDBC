package dataToInsertIntoTables;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@AllArgsConstructor
@Getter
public enum StudentsData {
     Student1("Петров", "М", 1),
     Student2("Васечкин", "М", 1),
     Student3  ("Ложкин", "М", 1),
     Student4 ("Ножкин", "М", 1),
     Student5("Кошкин", "М", 1),
     Student6("Петрова", "Ж", 2),
     Student7 ("Кузнецов", "М", 2),
     Student8("Мышкин", "М", 2),
     Student9 ("Сидорова", "Ж", 2),
     Student10 ("Кораблёв", "М", 2),
     Student11 ("Королёва", "Ж", 3),
     Student12("Носкова", "Ж", 3),
     Student13("Павлова", "Ж", 3),
     Student14("Макарова", "Ж", 3),
     Student15 ("Назарова", "Ж", 3);

    private String fio;
    private String sex;
    private int id_group;

     public static StudentsData getRandomStudent()
     {
         int getRandom= new Random().nextInt(StudentsData.values().length);
         return StudentsData.values()[getRandom];
     }
}


