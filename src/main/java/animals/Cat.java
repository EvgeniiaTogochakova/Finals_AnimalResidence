package animals;

import java.util.ArrayList;

public class Cat extends Pet {
    String type;

    public Cat(String name, String birthDate) {
        super(name, birthDate);
        this.type = "кошка";
    }

    public Cat(String name, String birthDate, ArrayList<String> list) {
        super(name, birthDate, list);
        this.type = "кошка";
    }

    @Override
    public String getInfo() {
        if (commandList.size() == 0) {
            return name + " " + getId() + " кошка " + birthDate + " не знает команд";
        }
        return name + " " + getId() + " кошка " + birthDate + " знает команды: " + commandIntegrator(commandList);
    }
}
