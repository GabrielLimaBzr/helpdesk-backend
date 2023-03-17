package com.gabriel.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel.helpdesk.domain.Chamado;
import com.gabriel.helpdesk.domain.Cliente;
import com.gabriel.helpdesk.domain.Tecnico;
import com.gabriel.helpdesk.domain.enums.Perfil;
import com.gabriel.helpdesk.domain.enums.Prioridade;
import com.gabriel.helpdesk.domain.enums.Status;
import com.gabriel.helpdesk.repositories.ChamadoRepository;
import com.gabriel.helpdesk.repositories.ClienteRepository;
import com.gabriel.helpdesk.repositories.TecnicoRepository;

@Service
public class DBService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ChamadoRepository chamdoRepository;

	public void iniciaDB() {
		Tecnico tec1 = new Tecnico(null, "Gabriel Lima", "02433325270", "gabriel@gmail.com", "123");
		tec1.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Jack Daniels", "54962303066", "jackd@gamil.com", "123");
		cli1.addPerfil(Perfil.CLIENTE);
		
		Chamado task1 = new Chamado(null, Prioridade.BAIXA, Status.ABERTO, "Chamado 01", "primeiro chamado", tec1, cli1);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamdoRepository.saveAll(Arrays.asList(task1));
	}
}