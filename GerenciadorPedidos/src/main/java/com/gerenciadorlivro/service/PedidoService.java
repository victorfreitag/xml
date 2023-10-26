package com.gerenciadorlivro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciadorlivro.entities.Pedido;
import com.gerenciadorlivro.repository.PedidoRepository;

@Service
public class PedidoService {
	private PedidoRepository livroRepository;
	
	@Autowired
	public PedidoService(PedidoRepository livroRepository) {
		this.livroRepository = livroRepository;
	}
	public List<Pedido> buscarTodos(){
	return livroRepository.findAll();
	}
	public Pedido buscarId(Long id) {
		Optional <Pedido> Pedido = livroRepository.findById(id);
		return Pedido.orElse(null);
	}
	public Pedido salvar(Pedido usuario) {
		return livroRepository.save(usuario);
	}
	public Pedido alterar(Long id, Pedido alterarprod) {
		Optional <Pedido> existe  = livroRepository.findById(id);
		if(existe.isPresent()) {
			alterarprod.setId(id);
			return livroRepository.save(alterarprod);
		}
		return null;
	}
	public boolean apagar(Long id) {
		Optional <Pedido> existe = livroRepository.findById(id);
		if(existe.isPresent()) {
			livroRepository.deleteById(id);
			return true;
		}
				
		return false;
	}

}

