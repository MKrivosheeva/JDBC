package dataToInsertIntoTables;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@AllArgsConstructor
@Getter
public enum GroupsData {

    GROUP1 ("Авиамоделирование", 1),
    GROUP2 ("Ракетомоделирование", 2),
    GROUP3 ("Радиосвязь", 3);
    
    private String name;
    private int id_curatror;
    public static GroupsData getRandomGroup()
    {
        int getRandom= new Random().nextInt(GroupsData.values().length);
        return GroupsData.values()[getRandom];
    }
}
