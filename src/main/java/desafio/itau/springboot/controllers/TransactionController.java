package desafio.itau.springboot.controllers;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import desafio.itau.springboot.dto.TransactionDto;
import desafio.itau.springboot.model.Transaction;
import desafio.itau.springboot.services.TransactionService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
@RequestMapping("/transacao")
public class TransactionController {

	@Autowired
	private TransactionService transactionsService;	
	
	@PostMapping
	public ResponseEntity<Void> addTransactions (@RequestBody TransactionDto transactionDto){
		if(transactionDto.dataHora().isAfter(OffsetDateTime.now())) {
			return ResponseEntity.unprocessableEntity().build();
		}
		
		transactionsService.addTransactions(transactionDto);
		 return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@GetMapping
	public ResponseEntity<List<Transaction>> getAllTransactions (){
		return ResponseEntity.ok(transactionsService.getAllTransactions());
	}
	
	@DeleteMapping
	public ResponseEntity<Void> clearTransactions () {
		transactionsService.clear();
		return ResponseEntity.ok().build();
	}

}
