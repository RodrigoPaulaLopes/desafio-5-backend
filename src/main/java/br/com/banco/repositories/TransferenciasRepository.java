package br.com.banco.repositories;

import br.com.banco.entities.Transferencia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface TransferenciasRepository extends JpaRepository<Transferencia, Long> {
    Page<Transferencia> findByContaNumeroConta(String numeroConta, Pageable pageable);

    Page<Transferencia> findByContaNumeroContaAndDataTransferenciaBetween(String numeroConta, LocalDate dataInicial, LocalDate dataFinal, Pageable pageable);

    Page<Transferencia> findByContaNumeroContaAndOperadorTransacao(String numeroConta, String operadorTransacao, Pageable pageable);

    Page<Transferencia> findByContaNumeroContaAndDataTransferenciaBetweenAndOperadorTransacao(String numeroConta, LocalDate dataInicial, LocalDate dataFinal, String operadorTransacao, Pageable pageable);

    Page<Transferencia> findByOperadorTransacao( String operadorTransacao, Pageable paginacao);

    Page<Transferencia> findByDataTransferenciaBetween(LocalDate dataInicial, LocalDate dataFinal, Pageable paginacao);
}
