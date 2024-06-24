package br.com.regis.produtor.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.regis.produtor.services.ProductorService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/producer")
@RequiredArgsConstructor
public class ProductorController {

	private final ProductorService productorService;
	
	@PostMapping
	public ResponseEntity<?> sendMessage(@RequestBody String message){
		productorService.sedMessage(message);
		return ResponseEntity.status(HttpStatus.CREATED).body("Enviado...");
	}
}
