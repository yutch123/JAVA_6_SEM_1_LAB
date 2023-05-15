package com.psuti.raz.dto.country;

import com.psuti.raz.entity.Capital;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CountryResponse {
    private String name;
    private Long population;
    private Capital capital;
}
