package com.example.demo.tayma.Repository;


import com.example.demo.tayma.Entities.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.Set;

public interface CoursRepo extends JpaRepository<Cours,Long> {



    void deleteCoursByIdCr(Long id);



    Optional<Cours> findCoursByIdCr(Long idCr);
    @Modifying
    @Query("delete from Cours where Name=?1")
    void deleteCoursByName(String Name);


    Optional<Cours> findCoursByTitre(String titre);

    /*  Set<Cours> findByCatégorie(String nomC);*/
    Optional<Set<Cours>> findCoursByCatégorie(Long idCt);

    Optional<Set<Cours>> findCoursByUserName(String userName);
}
