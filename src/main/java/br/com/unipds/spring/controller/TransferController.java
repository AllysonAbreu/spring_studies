package br.com.unipds.spring.controller;

import br.com.unipds.spring.dto.TransferDTO;
import br.com.unipds.spring.model.Transaction;
import br.com.unipds.spring.service.ITransferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {

    private ITransferService service;

    public TransferController(ITransferService service) {
        this.service = service;
    }

    @PostMapping("/transfer")
    public ResponseEntity<Transaction> transferValue(
            @RequestBody TransferDTO dto
    ) {
        return ResponseEntity.status(201).body(service.transferValues(dto));
    }
}
