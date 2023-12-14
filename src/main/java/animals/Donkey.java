package animals;

import java.util.ArrayList;

public class Donkey extends PackAnimal {
    String type;

    public Donkey(String name, String birthDate) {
        super(name, birthDate);
        this.type = "осел";
    }

    public Donkey(String name, String birthDate, ArrayList<String> list) {
        super(name, birthDate, list);
        this.type = "осел";
    }

    @Override
    public String getInfo() {
        if (commandList.size() == 0) {
            return name + " " + getId() + " осел " + birthDate + " не знает команд";
        }
        return name + " " + getId() + " осел " + birthDate + " знает команды: " + commandIntegrator(commandList);
    }
}
