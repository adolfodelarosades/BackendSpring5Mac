package com.bolsadeideas.spring.boot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.spring.boot.backend.apirest.models.dao.IClienteDao;
import com.bolsadeideas.spring.boot.backend.apirest.models.entity.Cliente;

//Anotar como Service para marcarla como una clase de Servicio
@Service
public class ClienteServiceImpl implements IClienteService {

	// Inyectar (Inyección de dependdencias) el ClienteDao
	@Autowired
	private IClienteDao clienteDao;

	@Override
	@Transactional(readOnly = true) // Permite manejar transacción en el método y como es un Select será sólo de
									// lectura
	public List<Cliente> findAll() {
		// Como findAll() retorna un Iterable le hacemos un CAST
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findById(Long id) {
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		return clienteDao.save(cliente);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		clienteDao.deleteById(id);

	}

}