package br.com.banco.services;

import br.com.banco.entities.Transferencia;
import br.com.banco.helpers.ConvertDate;
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


    public Page<Transferencia> findAll(String numeroConta, String dataInicial, String dataFinal, String operadorTransacao, Pageable paginacao){
        if (numeroConta == null && dataInicial == null && dataFinal == null && operadorTransacao == null) {
            return transferenciasRepository.findAll(paginacao);
        }

        if (dataInicial != null && dataFinal != null && operadorTransacao != null) {
            var inicial = ConvertDate.convert(dataInicial);
            var dataF = ConvertDate.convert(dataFinal);
            return transferenciasRepository.findByContaNumeroContaAndDataTransferenciaBetweenAndOperadorTransacao(numeroConta, inicial, dataF, operadorTransacao, paginacao);
        }
        if (dataInicial != null && dataFinal != null && numeroConta == null) {
            var inicial = ConvertDate.convert(dataInicial);
            var dataF = ConvertDate.convert(dataFinal);
            return transferenciasRepository.findByDataTransferenciaBetween(inicial, dataF, paginacao);
        }
        if (dataInicial != null && dataFinal != null ) {
            var inicial = ConvertDate.convert(dataInicial);
            var dataF = ConvertDate.convert(dataFinal);
            return transferenciasRepository.findByContaNumeroContaAndDataTransferenciaBetween(numeroConta, inicial, dataF, paginacao);
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
