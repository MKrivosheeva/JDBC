package tablesData;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Students {

   private int id;
   private String fio;
   private String sex;
   private int id_group;

   @Override
   public String toString() {

      return  getClass().getSimpleName()  +
              " id = " + id +  ", fio = " + fio +  " sex = " + sex +", id_group = " + id_group;
   }
}
