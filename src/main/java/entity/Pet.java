package entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class Pet implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String animal;
    private String name;
    private int age;
    private String color;
    private int ownerId;


}
