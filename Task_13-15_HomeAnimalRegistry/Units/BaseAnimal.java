// Родительский класс реестра домашних животных

package Units;

import java.sql.Date;
import java.util.ArrayList;

public abstract class BaseAnimal {
    // поля класса
    protected Date birthDate;  // дата рождения
    protected Integer id;   // номер экземпляра
    protected String typeName;  // название тип
    protected String name;      // имя экземпляра
    protected ArrayList<String> commands; // команды

    public BaseAnimal(Date birthDate, Integer id, String typeName, String name, ArrayList<String> commands) {
        this.birthDate = birthDate;
        this.id = id;
        this.typeName = typeName;
        this.name = name;
        this.commands = commands;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getCommands() {
        return commands;
    }

    public void setCommands(ArrayList<String> commands) {
        this.commands = commands;
    }

}
