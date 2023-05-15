package com.psuti.raz.Repository;

import com.psuti.raz.entity.Capital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CapitalsRepository extends JpaRepository<Capital, String> {

    boolean existsByName(String name);

    Capital findByName(String name);


    @Transactional
    @Modifying
    @Query("delete from Capital b where b.name=:name")
    void deleteCapitalBy(@Param("name") String name);
}
