package com.psuti.raz.Repository;

import com.psuti.raz.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface RoleRepository extends JpaRepository<Role, String> {
    Role findByName(String name);
    boolean existsByName(String name);

    @Transactional
    @Modifying
    @Query("delete from Role b where b.name=:name")
    void deleteRoleBy(@Param("name") String name);
}
