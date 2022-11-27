package com.dashboard.back.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dashboard.back.Base.BaseService;
import com.dashboard.back.dto.TiendaDto;
import com.dashboard.back.model.Ciudad;
import com.dashboard.back.model.Tienda;
import com.dashboard.back.repository.ICiudadRepository;
import com.dashboard.back.repository.ITiendaRepository;

@Service
public class TiendaService implements BaseService<TiendaDto> {
	
	@Autowired
	ITiendaRepository tiendaRepository;
	
	@Autowired
	ICiudadRepository ciudadRepository;

	@Override
	public List<TiendaDto> findAll() {
		List<Tienda> tiend = this.tiendaRepository.findAll();
		
		List<TiendaDto> tiendas = new ArrayList<TiendaDto>();
		
		int numTiendas = tiend.size();
		
		for(int i=0; i< numTiendas; i++) {
			tiendas.add(this.convertEntityDto(tiend.get(i)));
		}
		return tiendas;
	}

	@Override
	public TiendaDto findId(Integer id) {
		Tienda tienda =  this.tiendaRepository.findById(id).orElse(null);
		
		if(tienda == null) {
			return null;
		}
		
		return this.convertEntityDto(tienda);
	}

	@Override
	public TiendaDto save(TiendaDto tienda) {
		Tienda tiendaInicio = new Tienda();
		
		if(tienda.getId_tienda() != null && tienda.getId_tienda() > 0) {
			tiendaInicio.setId_tienda(tienda.getId_tienda());
		}
		tiendaInicio.setCentro_costos(tienda.getCentro_costos());
		if(tienda.getId_ciudad() > 0) {
			Ciudad ciudad = this.ciudadRepository.findById(tienda.getId_ciudad()).orElse(null);
			tiendaInicio.setCiudad(ciudad);
		}
		tiendaInicio.setId_tienda(tienda.getId_tienda());
		tiendaInicio.setNombre(tienda.getNombre());
		
		Tienda tiend = this.tiendaRepository.save(tiendaInicio);
		
		return this.convertEntityDto(tiend);
	}
	
	@Override
	public TiendaDto update(TiendaDto tienda, Integer id) {
		TiendaDto tiend = this.findId(id);
		if(tiend == null) {
			return null;
		}
		if(tienda.getNombre() != null) {
			tiend.setNombre(tienda.getNombre());
		}
		if(tienda.getCentro_costos() != null) {
			tiend.setCentro_costos(tienda.getCentro_costos());
		}
		if(tienda.getCiudad() != null && tienda.getCiudad() != tiend.getCiudad()) {
			
			tiend.setNombre(tienda.getNombre());
		}
		if(tienda.getNombre() != null) {
			tiend.setNombre(tienda.getNombre());
		}
		return this.save(tiend);
	}

	@Override
	public void delete(Integer id) {
		this.tiendaRepository.deleteById(id);		
	}
	
	private TiendaDto convertEntityDto(Tienda t) {
		TiendaDto tiend =  new TiendaDto();
		if(t.getId_tienda() != null) {
			tiend.setId_tienda(t.getId_tienda());
		}
		if(t.getCiudad() != null) {
			tiend.setId_ciudad(t.getCiudad().getId_ciudad());
		}
		tiend.setNombre(t.getNombre());
		tiend.setCentro_costos(t.getCentro_costos());
		tiend.setCiudad(t.getCiudad());
		return tiend;
	}

}
