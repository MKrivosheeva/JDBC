package dataToInsertIntoTables;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TablesList {
    GROUPS("gruppa"),
    STUDENTS("student"),
    CURATORS("curator");

    private String name;

}
