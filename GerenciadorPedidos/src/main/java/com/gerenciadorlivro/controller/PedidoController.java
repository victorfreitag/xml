package com.gerenciadorlivro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciadorlivro.entities.Pedido;
import com.gerenciadorlivro.service.PedidoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name= "Pedido",description = "API REST DE GERENCIAMENTO DE USUÁRIOS")
@RestController
@RequestMapping("/pedido")
public class PedidoController {
	private final PedidoService livroService;
	
	@Autowired
	public PedidoController(PedidoService livroService) {
		this.livroService = livroService;
	}
	
	@GetMapping("/{id}")
	@Operation(summary = "Localiza usuario por ID")
	public ResponseEntity<Pedido> buscarId(@PathVariable Long id){
		Pedido pedido = livroService.buscarId(id);
		if(pedido != null) {
			return ResponseEntity.ok(pedido);
		}
		else {
			return ResponseEntity.notFound().build();
		}}
	
		@GetMapping("/")
		@Operation(summary = "Apresenta todos os usuarios")
		public ResponseEntity <List<Pedido>> buscartodos(){
		List<Pedido> pedido = livroService.buscarTodos();
		return ResponseEntity.ok(pedido);
	}
		@PostMapping("/")
		@Operation(summary = "Inserindo Dados")
		public ResponseEntity<Pedido>salvar(@RequestBody @Valid Pedido pedido){
			Pedido salvar = livroService.salvar(pedido);
			return ResponseEntity.status(HttpStatus.CREATED).body(salvar);
		}
		@PutMapping("/")
		@Operation(summary = "Aterando Dados")
		public ResponseEntity<Pedido> alterar(@PathVariable Long id, @RequestBody @Valid Pedido pedido){
			Pedido alterar = livroService.alterar(id, pedido);
			if(alterar !=null) {
				return ResponseEntity.ok(pedido);
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
			@DeleteMapping("/{id}")
			@Operation(summary = "Deletando Dados")
			public ResponseEntity<Pedido> apagar(@PathVariable Long id){
				boolean apagar = livroService.apagar(id);
				if(apagar) {
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				}
				else {
					return ResponseEntity.notFound().build();
				}
			}
		}