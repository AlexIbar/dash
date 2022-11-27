package com.dashboard.back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dashboard.back.repository.IVentasCuerpo;

@Service
public class VentasCuerpoService {

	@Autowired
	IVentasCuerpo ventasCuerpoService;
	
}
