package com.dashboard.back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dashboard.back.repository.IVentasEncabezado;

@Service
public class VentasEncabezadoService {

	@Autowired
	IVentasEncabezado ventasEncabezadoRepository;
}
