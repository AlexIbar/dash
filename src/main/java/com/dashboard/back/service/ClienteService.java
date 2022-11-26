package com.dashboard.back.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dashboard.back.Base.BaseService;
import com.dashboard.back.dto.ClienteDto;
import com.dashboard.back.model.Cliente;
import com.dashboard.back.repository.IClienteRepository;

@Service
public class ClienteService implements BaseService<ClienteDto> {
	
	@Autowired
	IClienteRepository clienteRepository;

	@Override
	public List<ClienteDto> findAll() {

		List<Cliente> cliente = this.clienteRepository.findAll();
		
		List<ClienteDto> clienteDto = new ArrayList<ClienteDto>();
		
		int tamCliente = cliente.size();
		
		for(int i =0; i<tamCliente; i++) {
			ClienteDto client = this.transfromCliente(cliente.get(i));
			clienteDto.add(client);
		}
		
		return clienteDto;
	}

	@Override
	public ClienteDto save(ClienteDto clienteDto) {
		Cliente cliente = new Cliente();
		
		cliente.setCedula_cliente(clienteDto.getCedula_cliente());
		cliente.setCelular(clienteDto.getCelular());
		cliente.setNombre_cliente(clienteDto.getNombre_cliente());
		
		Cliente clientSave = this.clienteRepository.save(cliente);
		
		if(clientSave == null) {
			return null;
		}
		
		return this.transfromCliente(clientSave);
		
	}

	@Override
	public ClienteDto findId(Integer id) {
		// TODO Auto-generated method stub
		Cliente client = this.clienteRepository.findById(id).orElse(null);
		
		if(client == null) {
			return null;
		}
		
		return this.transfromCliente(client);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.clienteRepository.deleteById(id);
		
	}
	
	private ClienteDto transfromCliente(Cliente c) {
		ClienteDto clientDto = new ClienteDto(
				c.getId_cliente(),
				c.getCedula_cliente(),
				c.getNombre_cliente(),
				c.getNombre_cliente(),
				c.getVentas_encabezado()
		);
		return clientDto;
	}

	@Override
	public ClienteDto update(ClienteDto clienteDto, Integer id) {
		ClienteDto cliente = this.findId(id);
		if(cliente.getCedula_cliente() != clienteDto.getCedula_cliente()) {
			cliente.setCedula_cliente(clienteDto.getCedula_cliente());
		}
		if(cliente.getCelular() != clienteDto.getCelular()) {
			cliente.setCelular(clienteDto.getCelular());
		}
		if(cliente.getNombre_cliente() != clienteDto.getNombre_cliente()) {
			cliente.setNombre_cliente(clienteDto.getNombre_cliente());
		}
		
		return this.save(cliente);
	}
	
}