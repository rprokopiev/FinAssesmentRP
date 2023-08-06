package Units;

import java.sql.Date;
import java.util.ArrayList;

public abstract class PackAnimals extends BaseAnimal{

    public PackAnimals(ArrayList<String> commands, Date birthDate, String name) {
        super(commands, birthDate, name);
    }
}
