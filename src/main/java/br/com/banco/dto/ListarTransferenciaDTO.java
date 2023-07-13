package br.com.banco.dto;

import br.com.banco.entities.Transferencia;
import br.com.banco.enums.TipoTransferencia;

import java.time.LocalDate;

public record ListarTransferenciaDTO(Long id, LocalDate date, Double valor, TipoTransferencia tipo, String nome_operador, ListarContaDTO conta) {

    public ListarTransferenciaDTO(Transferencia transferencia){
        this(transferencia.getId(), transferencia.getDataTransferencia(), transferencia.getValor(), transferencia.getTipo(), transferencia.getOperadorTransacao(), new ListarContaDTO(transferencia.getConta()));
    }
}
