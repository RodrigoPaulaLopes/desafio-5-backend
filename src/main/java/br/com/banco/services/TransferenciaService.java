package br.com.banco.services;

import br.com.banco.entities.Transferencia;
import br.com.banco.repositories.TransferenciasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Service
public class TransferenciaService {

    @Autowired
    private TransferenciasRepository transferenciasRepository;


    public Page<Transferencia> findAll(String numeroConta, LocalDate dataInicial, LocalDate dataFinal, String operadorTransacao, Pageable paginacao){
        if (numeroConta == null && dataInicial == null && dataFinal == null && operadorTransacao == null) {
            return transferenciasRepository.findAll(paginacao);
        }

        if (dataInicial != null && dataFinal != null && operadorTransacao != null) {
            return transferenciasRepository.findByContaNumeroContaAndDataTransferenciaBetweenAndOperadorTransacao(numeroConta, dataInicial, dataFinal, operadorTransacao, paginacao);
        }

        if (dataInicial != null && dataFinal != null) {
            return transferenciasRepository.findByContaNumeroContaAndDataTransferenciaBetween(numeroConta, dataInicial, dataFinal, paginacao);
        }
        if (operadorTransacao != null && numeroConta == null) {
            return transferenciasRepository.findByOperadorTransacao(operadorTransacao, paginacao);
        }
        if (operadorTransacao != null) {
            return transferenciasRepository.findByContaNumeroContaAndOperadorTransacao(numeroConta, operadorTransacao, paginacao);
        }


        return transferenciasRepository.findByContaNumeroConta(numeroConta, paginacao);
    }
}
