package com.psuti.raz.dto.city;

import com.psuti.raz.entity.Capital;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CityResponse {
    private String name;
    private Long population;
    private Capital capital;
}
