package entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class Owner implements Serializable {
    private int id;
    private String name;


}

