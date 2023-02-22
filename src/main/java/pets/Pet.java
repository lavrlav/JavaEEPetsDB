package pets;

import java.io.Serializable;

public class Pet implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String animal;
    private String name;
    private int age;
    private String color;
    private int ownerId;

    public Pet(int id, String animal, String name, int age, String color, int ownerId) {
        this.id = id;
        this.animal = animal;
        this.name = name;
        this.age = age;
        this.color = color;
        this.ownerId = ownerId;
    }

    public Pet(String animal, String name, int age, String color, int ownerId) {
        this.animal = animal;
        this.name = name;
        this.age = age;
        this.color = color;
        this.ownerId = ownerId;
    }

    public int getId() {
        return id;
    }

    public String getAnimal() {
        return animal;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }

    public int getOwnerId() {
        return ownerId;
    }


}
