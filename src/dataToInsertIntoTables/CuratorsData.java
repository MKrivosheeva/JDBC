package dataToInsertIntoTables;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@AllArgsConstructor
@Getter
public enum CuratorsData {
    CURATOR1("Абрикосов"),
    CURATOR2 ("Яблочкина"),
    CURATOR3("Персиков"),
    CURATOR4("Виноградова");

    private String fio;

    public static CuratorsData getRandomCurator()
    {
        int getRandom= new Random().nextInt(CuratorsData.values().length);
        return CuratorsData.values()[getRandom];
    }
}
