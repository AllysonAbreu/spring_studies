package br.com.unipds.spring.service.impl;

import br.com.unipds.spring.dto.TransferDTO;
import br.com.unipds.spring.exception.InvalidAccountException;
import br.com.unipds.spring.model.Account;
import br.com.unipds.spring.model.Transaction;
import br.com.unipds.spring.repository.AccountRepository;
import br.com.unipds.spring.repository.TransactionRepository;
import br.com.unipds.spring.service.ITransferService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransferServiceImpl implements ITransferService {

    private AccountRepository accountRepository;
    private TransactionRepository transactionRepository;

    public TransferServiceImpl(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    @Transactional
    public Transaction transferValues(TransferDTO dto) {
        Account src = accountRepository.findById(dto.debitAccountNumber())
                .orElseThrow(() -> new InvalidAccountException(
                        String.format("Account #%d does not exists",dto.debitAccountNumber())));

        Account dst = accountRepository.findById(dto.creditAccountNumber())
                .orElseThrow(() -> new InvalidAccountException(
                        String.format("Account #%d does not exists", dto.creditAccountNumber())
                ));

        dst.setBalance(dst.getBalance() + dto.amount());
        accountRepository.save(dst);

        src.setBalance(src.getBalance() - dto.amount());
        accountRepository.save(src);

        Transaction transaction = new Transaction();
        transaction.setDebitAccount(src);
        transaction.setCreditAccount(dst);
        transaction.setAmount(dto.amount());
        transaction.setTimestamp(LocalDateTime.now());
        return transactionRepository.save(transaction);
    }
}
