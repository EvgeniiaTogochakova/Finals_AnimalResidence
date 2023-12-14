package animals;

import java.util.ArrayList;

public class Hamster extends Pet {
    String type;

    public Hamster(String name, String birthDate) {
        super(name, birthDate);
        this.type = "хомяк";
    }

    public Hamster(String name, String birthDate, ArrayList<String> list) {
        super(name, birthDate, list);
        this.type = "хомяк";
    }

    @Override
    public String getInfo() {
        if (commandList.size() == 0) {
            return name + " " + getId() + " хомяк " + birthDate + " не знает команд";
        }
        return name + " " + getId() + " хомяк " + birthDate + " знает команды: " + commandIntegrator(commandList);
    }
}
