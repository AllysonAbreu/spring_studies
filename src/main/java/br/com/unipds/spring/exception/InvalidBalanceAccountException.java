package br.com.unipds.spring.exception;

public class InvalidBalanceAccountException extends RuntimeException {
    public InvalidBalanceAccountException(String message) {
        super(message);
    }
}
