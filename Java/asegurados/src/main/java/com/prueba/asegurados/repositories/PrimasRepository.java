package com.prueba.asegurados.repositories;

import com.prueba.asegurados.entities.Prima;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimasRepository extends JpaRepository<Prima, Integer> {

}
