package Units;

import java.sql.Date;
import java.util.ArrayList;

public abstract class Pets extends BaseAnimal{

    public Pets(ArrayList<String> commands, Date birthDate, String name) {
        super(commands, birthDate, name);
    }

}
