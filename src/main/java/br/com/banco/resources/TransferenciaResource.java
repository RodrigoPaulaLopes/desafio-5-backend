package br.com.banco.resources;

import br.com.banco.dto.ListarTransferenciaDTO;
import br.com.banco.entities.Transferencia;
import br.com.banco.services.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/transfers")
public class TransferenciaResource {


    @Autowired
    private TransferenciaService transferenciaService;
    @GetMapping
    public ResponseEntity<Page<ListarTransferenciaDTO>> findAll(Pageable paginacao,
                                                                @RequestParam(name = "numeroConta", required = false) String numeroConta,
                                                                @RequestParam(name = "dataInicial", required = false) String dataInicial,
                                                                @RequestParam(name = "dataFinal", required = false) String dataFinal,
                                                                @RequestParam(name = "operadorTransacao", required = false) String operadorTransacao){

        var transferencias = transferenciaService.findAll(numeroConta, dataInicial,  dataFinal, operadorTransacao, paginacao).map(ListarTransferenciaDTO::new);
        return ResponseEntity.ok(transferencias);
    }
}
