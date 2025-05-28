package com.eventsapp.backend.dto;

import com.eventsapp.backend.model.enums.DrinkType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DrinkDTO {
    private int id;
    private String name;
    private DrinkType drinkType;
    public DrinkDTO(int id, String name, DrinkType drinkType) {
        this.id = id;
        this.name = name;
        this.drinkType = drinkType;
    }

}
