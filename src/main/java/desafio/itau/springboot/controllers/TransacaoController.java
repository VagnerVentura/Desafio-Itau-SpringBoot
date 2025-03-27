package desafio.itau.springboot.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import desafio.itau.springboot.dto.TransacaoDto;
import desafio.itau.springboot.model.Transacao;
import desafio.itau.springboot.services.TransacaoService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
@RequestMapping("/transacao")
public class TransacaoController {

	private TransacaoService transacaoService;	
	
	@PostMapping
	public ResponseEntity<Transacao>recebeTransacao (@RequestBody TransacaoDto transacaoDto){
		return ResponseEntity.ok(transacaoService.createTransacao(transacaoDto));
	}
	
	
}
