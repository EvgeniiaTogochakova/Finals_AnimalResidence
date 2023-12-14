package animals;

import java.util.ArrayList;

public abstract class Animal {
    protected static int id = 0;
    protected String name;
    protected String birthDate;
    protected ArrayList<String> commandList = new ArrayList<>();

    protected Animal(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        ++id;
    }

    protected Animal(String name, String birthDate, ArrayList<String> list) {
        this.name = name;
        this.birthDate = birthDate;
        commandList = list;
        ++id;
    }

    public int getId() {
        return id;
    }

    public String commandIntegrator(ArrayList<String> commList) {
        StringBuilder commands = new StringBuilder();
        for (String s : commList) {
            commands.append(s).append(" ");
        }
        return commands.toString();
    }


    public String getInfo() {
        if (commandList.size() == 0) {
            return name + " " + getId() + " " + birthDate + " не знает команд";
        }
        return name + " " + getId() + " " + birthDate + " знает команды: " + commandIntegrator(commandList);
    }
}
