package desafio.itau.springboot.services;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

import org.springframework.stereotype.Service;

import desafio.itau.springboot.dto.TransactionDto;
import desafio.itau.springboot.model.Transaction;

@Service
public class TransactionService {

	private final List<Transaction> transactions = new ArrayList<>();
	
	public void addTransactions(TransactionDto dto) {
		 transactions.add(new Transaction(dto.valor(),dto.dataHora()));
	}

	public List<Transaction> getAllTransactions() {
		return transactions;		
	}

	public void clear() {
		transactions.clear();		
	}
	
	public DoubleSummaryStatistics getStatistics() {
		OffsetDateTime now = OffsetDateTime.now();
		
		System.out.println("tamanho da lista: " + transactions.size());
		transactions.forEach(t -> System.out.println("Transação: " + t.getValor() 
		+"data: " + t.getDataHora()));
		
		return transactions.stream()
				.filter(t -> t.getDataHora().toInstant().isAfter(Instant.now().minusSeconds(60)))
				.mapToDouble(Transaction::getValor)
				.summaryStatistics();
	}

	
	 
}

