package owners;

import java.io.Serializable;

public class Owner implements Serializable {
    private int id;
    private String name;

    public Owner(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
