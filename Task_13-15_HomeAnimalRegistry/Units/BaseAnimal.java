// Родительский класс реестра домашних животных

package Units;

import java.sql.Date;
import java.util.ArrayList;

public abstract class BaseAnimal implements BaseInterface {
    
    public ArrayList<String> commands; // команды
    protected Date birthDate;  // дата рождения
    protected String typeName;  // название тип
    protected String name;      // имя экземпляра
    

    public BaseAnimal(ArrayList<String> commands, Date birthDate, String name) {
        this.birthDate = birthDate;
        this.name = name;
        this.typeName = this.getClass().getName().split("\\.")[1];  
    }

    @Override
    public void getInfo(){
        // 
    }


    public ArrayList<String> getCommands() {
        return commands;
    }


    public void setCommands() {
        Prompt.PromptCommand.addCommand(commands);
    }


    public Date getBirthDate() {
        return birthDate;
    }


    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }


    public String getTypeName() {
        return typeName;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }
    
    

}
