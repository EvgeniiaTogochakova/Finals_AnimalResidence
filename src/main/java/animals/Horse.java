package animals;

import java.util.ArrayList;

public class Horse extends PackAnimal {
    String type;

    public Horse(String name, String birthDate) {
        super(name, birthDate);
        this.type = "лошадь";
    }

    public Horse(String name, String birthDate, ArrayList<String> list) {
        super(name, birthDate, list);
        this.type = "лошадь";
    }

    @Override
    public String getInfo() {
        if (commandList.size() == 0) {
            return name + " " + getId() + " лошадь " + birthDate + " не знает команд";
        }
        return name + " " + getId() + " лошадь " + birthDate + " знает команды: " + commandIntegrator(commandList);
    }
}
