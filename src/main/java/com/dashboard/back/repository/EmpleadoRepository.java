package com.dashboard.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dashboard.back.model.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
}
