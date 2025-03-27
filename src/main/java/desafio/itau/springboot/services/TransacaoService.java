package desafio.itau.springboot.services;

import org.springframework.stereotype.Service;

import desafio.itau.springboot.dto.TransacaoDto;
import desafio.itau.springboot.model.Transacao;

@Service
public class TransacaoService {

//	private Transacao transacao;
	
	
	public Transacao createTransacao (TransacaoDto transacaoDto){
		Transacao newTransacao = new Transacao();
		newTransacao.setDataHora(transacaoDto.dataHora());
		newTransacao.setValor(transacaoDto.valor());
		return newTransacao;		
	}
}
