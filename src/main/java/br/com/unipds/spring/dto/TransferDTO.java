package br.com.unipds.spring.dto;

public record TransferDTO(
        Integer debitAccountNumber,
        Integer creditAccountNumber,
        Double amount
) {
}
