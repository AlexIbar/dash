package com.dashboard.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dashboard.back.model.Ciudad;


@Repository
public interface ICiudadRepository extends JpaRepository<Ciudad, Integer> {

}
