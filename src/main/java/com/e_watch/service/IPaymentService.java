package com.e_watch.service;


import com.e_watch.entity.Transaction;
import com.e_watch.exceptions.InvalidInputException;

public interface IPaymentService {
	public Transaction payBill(Transaction transaction) throws InvalidInputException;
   public String cancelTransaction(long transactionId);
   public Transaction viewTransaction(long transactionId);

}
