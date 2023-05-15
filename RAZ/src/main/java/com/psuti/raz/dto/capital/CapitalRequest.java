package com.psuti.raz.dto.capital;

import com.psuti.raz.entity.City;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class CapitalRequest {
    private String name;

    private List<City> city;
}
