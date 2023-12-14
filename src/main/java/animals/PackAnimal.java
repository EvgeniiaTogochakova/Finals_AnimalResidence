package animals;

import java.util.ArrayList;

public abstract class PackAnimal extends Animal {
    public PackAnimal(String name, String birthDate) {
        super(name, birthDate);
    }

    public PackAnimal(String name, String birthDate, ArrayList<String> list) {
        super(name, birthDate, list);
    }
}
