package br.com.banco.dto;

import br.com.banco.entities.Conta;

public record ListarContaDTO(Integer id, String numero_conta, String nome_responsavel) {

    public ListarContaDTO(Conta conta){this(conta.getId(), conta.getNumeroConta(), conta.getNome_responsavel());}
}
