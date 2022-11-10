package tablesData;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Curators {

    private int id;
    private String fio;
    @Override
    public String toString() {

        return  getClass().getSimpleName()  +
                " id = " + id +  ", fio = " + fio;
    }
}
