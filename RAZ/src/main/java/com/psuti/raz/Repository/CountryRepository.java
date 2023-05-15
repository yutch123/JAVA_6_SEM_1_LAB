package com.psuti.raz.Repository;

import com.psuti.raz.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CountryRepository extends JpaRepository<Country, String> {
    boolean existsByName(String name);

    Country findByName(String name);

    @Transactional
    @Modifying
    @Query("delete from Country b where b.name=:name")
    void deleteCountryBy(@Param("name") String name);

    @Query(value = "select city.population as p from country co " +
            "join city on co.capital = city.capital" +
            " where co.name =:country " +
            " group by p", nativeQuery = true)
    Long getPopulation(@Param("country") String country);

}
