package com.psuti.raz.Repository;

import com.psuti.raz.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CityRepository extends JpaRepository<City, String> {
    boolean existsByName(String name);
    City findByName(String name);

    @Transactional
    @Modifying
    @Query("delete from City b where b.name=:name")
    void deleteCityBy(@Param("name") String name);
}
