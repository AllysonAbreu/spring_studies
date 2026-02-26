package br.com.unipds.spring.controller.handler;

import br.com.unipds.spring.dto.ErrorDTO;
import br.com.unipds.spring.exception.InvalidAccountException;
import br.com.unipds.spring.exception.InvalidBalanceAccountException;
import br.com.unipds.spring.exception.InvalidTransferException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TransactionExceptionHandler {

    @ExceptionHandler(InvalidAccountException.class)
    public ResponseEntity<ErrorDTO> handleInvalidAccount(InvalidAccountException ex) {
        return ResponseEntity.status(404).body(new ErrorDTO(ex.getMessage()));
    }

    @ExceptionHandler(InvalidBalanceAccountException.class)
    public ResponseEntity<ErrorDTO> handleInvalidBalance(InvalidBalanceAccountException ex) {
        return ResponseEntity.status(400).body(new ErrorDTO(ex.getMessage()));
    }

    @ExceptionHandler(InvalidTransferException.class)
    public ResponseEntity<ErrorDTO> handleInvalidTransfer(InvalidTransferException ex) {
        return ResponseEntity.status(400).body(new ErrorDTO(ex.getMessage()));
    }
}
