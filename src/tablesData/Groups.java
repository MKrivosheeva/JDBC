package tablesData;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Groups {

    private int id;
    private String name;
    private int id_curator;

    @Override
    public String toString() {

        return  getClass().getSimpleName()  +
                " id = " + id +  ", name = " + name +  " id_curator = " + id_curator;
    }
}
