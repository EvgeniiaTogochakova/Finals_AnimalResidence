package animals;

import java.util.ArrayList;

public abstract class Pet extends Animal {
    public Pet(String name, String birthDate) {
        super(name, birthDate);
    }

    public Pet(String name, String birthDate, ArrayList<String> list) {
        super(name, birthDate, list);
    }

}
