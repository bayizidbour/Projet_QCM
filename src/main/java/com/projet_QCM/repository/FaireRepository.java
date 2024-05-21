package com.projet_QCM.repository;

import com.projet_QCM.model.Faire;
import com.projet_QCM.model.Faire_key;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FaireRepository extends JpaRepository<Faire, Faire_key> {

    @Query(value = "SELECT AVG(note) FROM faire WHERE user_id=?;",nativeQuery = true)
    double calculMoyenneByIdUser(int id);

}
