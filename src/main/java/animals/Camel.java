package animals;

import java.util.ArrayList;

public class Camel extends PackAnimal {
    String type;

    public Camel(String name, String birthDate) {
        super(name, birthDate);
        this.type = "верблюд";
    }

    public Camel(String name, String birthDate, ArrayList<String> list) {
        super(name, birthDate, list);
        this.type = "верблюд";
    }

    @Override
    public String getInfo() {
        if (commandList.size() == 0) {
            return name + " " + getId() + " верблюд " + birthDate + " не знает команд";
        }
        return name + " " + getId() + " верблюд " + birthDate + " знает команды: " + commandIntegrator(commandList);
    }
}
