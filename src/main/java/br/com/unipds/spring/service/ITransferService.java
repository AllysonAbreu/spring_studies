package br.com.unipds.spring.service;

import br.com.unipds.spring.dto.TransferDTO;
import br.com.unipds.spring.model.Transaction;

public interface ITransferService {

    Transaction transferValues(TransferDTO dto);
}
