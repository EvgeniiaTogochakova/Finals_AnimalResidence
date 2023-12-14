package animals;

import java.util.ArrayList;

public class Dog extends Pet {
    String type;

    public Dog(String name, String birthDate) {
        super(name, birthDate);
        this.type = "собака";
    }

    public Dog(String name, String birthDate, ArrayList<String> list) {
        super(name, birthDate, list);
        this.type = "собака";
    }

    @Override
    public String getInfo() {
        if (commandList.size() == 0) {
            return name + " " + getId() + " собака " + birthDate + " не знает команд";
        }
        return name + " " + getId() + " собака " + birthDate + " знает команды: " + commandIntegrator(commandList);
    }
}
